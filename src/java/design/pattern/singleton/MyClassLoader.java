package design.pattern.singleton;

import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author liuxucheng
 * @since 2022/12/13
 */
public class MyClassLoader extends URLClassLoader {

    private static final String CLASS_FILE_SUFFIX = ".class";

    private final Map<String, Class<?>> cachedClasses = new ConcurrentHashMap<>();

    private final SecurityManager securityManager = System.getSecurityManager();

    private final ClassLoader javaseClassLoader = Thread.currentThread().getContextClassLoader().getParent();

    public MyClassLoader(URL[] urls) {
        super(urls);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return loadClass(name, false);
    }

    @Override
    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {

        synchronized (getClassLoadingLock(name)) {
            Class<?> clazz = null;

            // (0) Check our previously loaded local class cache
            clazz = findLoadedClass0(name);
            if (clazz != null) {
                if (resolve) {
                    resolveClass(clazz);
                }
                return clazz;
            }

            // (0.1) Check our previously loaded class cache
            clazz = findLoadedClass(name);
            if (clazz != null) {
                if (resolve) {
                    resolveClass(clazz);
                }
                return clazz;
            }

            // (0.2) Try loading the class with the bootstrap class loader, to prevent
            //       the webapp from overriding Java SE classes. This implements
            //       SRV.10.7.2
            String resourceName = binaryNameToPath(name, false);

            boolean tryLoadingFromJavaseLoader;
            try {
                URL url;
                if (securityManager != null) {
                    PrivilegedAction<URL> dp = new PrivilegedJavaseGetResource(resourceName);
                    url = AccessController.doPrivileged(dp);
                } else {
                    url = javaseClassLoader.getResource(resourceName);
                }
                tryLoadingFromJavaseLoader = (url != null);
            } catch (Throwable t) {
                // Swallow all exceptions apart from those that must be re-thrown
                t.printStackTrace();
                // The getResource() trick won't work for this class. We have to
                // try loading it directly and accept that we might get a
                // ClassNotFoundException.
                tryLoadingFromJavaseLoader = true;
            }

            if (tryLoadingFromJavaseLoader) {
                try {
                    clazz = javaseClassLoader.loadClass(name);
                    if (clazz != null) {
                        if (resolve) {
                            resolveClass(clazz);
                        }
                        return clazz;
                    }
                } catch (ClassNotFoundException e) {
                    // Ignore
                }
            }

            // (0.5) Permission to access this class when using a SecurityManager
            if (securityManager != null) {
                int i = name.lastIndexOf('.');
                if (i >= 0) {
                    try {
                        securityManager.checkPackageAccess(name.substring(0, i));
                    } catch (SecurityException se) {
                        throw new ClassNotFoundException("error", se);
                    }
                }
            }

            // (2) Search local repositories
            try {
                clazz = findClass(name);
                if (clazz != null) {
                    if (resolve) {
                        resolveClass(clazz);
                    }
                    return clazz;
                }
            } catch (ClassNotFoundException e) {
                // Ignore
            }

            // (3) Delegate to parent unconditionally
            // 兜底，当前加载器无法加载该类
            try {
                clazz = Class.forName(name, false, super.getParent());
                if (clazz != null) {
                    if (resolve) {
                        resolveClass(clazz);
                    }
                    return clazz;
                }
            } catch (ClassNotFoundException e) {
                // Ignore
            }
        }

        throw new ClassNotFoundException(name);
    }

    protected Class<?> findLoadedClass0(String name) {
        return cachedClasses.get(name);
    }

    private String binaryNameToPath(String binaryName, boolean withLeadingSlash) {
        // 1 for leading '/', 6 for ".class"
        StringBuilder path = new StringBuilder(7 + binaryName.length());
        if (withLeadingSlash) {
            path.append('/');
        }
        path.append(binaryName.replace('.', '/'));
        path.append(CLASS_FILE_SUFFIX);
        return path.toString();
    }

    protected final class PrivilegedJavaseGetResource implements PrivilegedAction<URL> {

        private final String name;

        public PrivilegedJavaseGetResource(String name) {
            this.name = name;
        }

        @Override
        public URL run() {
            return javaseClassLoader.getResource(name);
        }
    }

    public void printLoadedClass(String name) {
        Class<?> cls = findLoadedClass(name);
        if (cls == null) {
            System.out.println("null");
            return;
        }
        System.out.println("findLoadedClass(" + name + ") = " + cls
                + ", has class loader " + cls.getClassLoader());
    }
}
