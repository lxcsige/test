/**
 * Created by liuxucheng on 2018/5/7.
 */
public class GreatestCommonDivisor {

    public static void main(String[] args) {
        GreatestCommonDivisor solution = new GreatestCommonDivisor();
        System.out.println(solution.handle(20, 15));
    }

    private int handle(int num1, int num2) {
        if (num1 < num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        int remainder = num1 % num2;
        while (remainder != 0) {
            num1 = num2;
            num2 = remainder;
            remainder = num1 % num2;
        }

        return num2;
    }
}
