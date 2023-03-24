package design.pattern.composite;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author liuxucheng
 * @since 2022/12/28
 */
public class Directory extends FsNode {

    private List<FsNode> children = new ArrayList<>();

    public Directory(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        if (children == null || children.size() == 0) {
            return 0;
        }

        int result = 0;
        for (FsNode fsNode : children) {
            result += fsNode.countNumOfFiles();
        }
        return result;
    }

    @Override
    public long countSizeOfFiles() {
        if (children == null || children.size() == 0) {
            return 0L;
        }

        long result = 0L;
        for (FsNode fsNode : children) {
            result += fsNode.countSizeOfFiles();
        }
        return result;
    }

    public void addChild(FsNode fsNode) {
        if (fsNode == null) {
            return;
        }
        if (children == null) {
            children = new ArrayList<>();
        }
        children.add(fsNode);
    }

    public void removeChild(FsNode fsNode) {
        if (fsNode == null
                || children == null || children.size() == 0) {
            return;
        }
        Iterator<FsNode> it = children.iterator();
        FsNode child;
        while(it.hasNext()) {
            child = it.next();
            if (child.path.equalsIgnoreCase(fsNode.path)) {
                it.remove();
            }
        }
    }
}
