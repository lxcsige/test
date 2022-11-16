package GenTest;

/**
 * Created by lxcfour on 16/7/28.
 */
public class Main {
    public static <T extends Comparable<? super T>>
    void selectionSort(T[] a,int n) {
        for (int index = 0; index < n-1; index++) {
            int indexOfSmallest = getIndexOfSmallest(a,index,n-1);
            swap(a,index,indexOfSmallest);
        }
    }

    //父类实现了comparable接口，子类可以直接不用声明实现comparable接口
    public static <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last) {
        T minValue = a[first];
        int indexOfMin = first;
        for (int index = first + 1; index <= last; index++) {
            if (a[index].compareTo(minValue) < 0) {
                minValue = a[index];
                indexOfMin = index;
            }
        }

        return indexOfMin;
    }

    public static void swap(Object[] a,int first,int second) {
        Object temp = a[first];
        a[first] = a[second];
        a[second] = temp;
    }

    public static void main(String[] args) {
        CollegeStudent[] stu = new CollegeStudent[]{
                new CollegeStudent(3),
                new CollegeStudent(2),
                new CollegeStudent(5),
                new CollegeStudent(4)};
        selectionSort(stu, 4);
        for (Student student : stu) {
            System.out.println(student);
        }
    }

}
