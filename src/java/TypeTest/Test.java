package TypeTest;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;

/**
 * User: lxcfour
 * Date: 2018/3/14
 * Time: 下午5:39
 */
public class Test {

    public static void main(String[] args) {
        Field[] fields = TypeBean.class.getDeclaredFields();
        for (Field field : fields) {
            Type type1 = field.getGenericType();
            Type type2 = field.getType();
            if (type1 instanceof ParameterizedType) {
                ParameterizedType p = (ParameterizedType) type1;
                Type rawType = p.getRawType();
                Type[] types = p.getActualTypeArguments();
                for (Type type : types) {
                    System.out.println(type);
                }
            }
        }

        List<Integer> l1 = new ArrayList<Integer>();
        l1.getClass().getTypeParameters();
    }
}
