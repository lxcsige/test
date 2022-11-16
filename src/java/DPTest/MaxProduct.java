package DPTest;

/**
 * User: lxcfour
 * Date: 2018/5/8
 * Time: 下午4:38
 */
public class MaxProduct {

    public int maxProduct(int length) {
        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }

//        return recursive(length);

        int[] products = new int[length + 1];
        // 值得注意的是这里考虑了只分成1段的情况，而length >= 4之后，不切的情况最多和切得到的结果相等
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        for (int i = 4; i <= length; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int num = products[j] * products[i - j];
                if (max < num) {
                    max = num;
                }
            }
            products[i] = max;
        }

        return products[length];
    }

    public int recursive(int length) {
        if (length == 1) {
            return 1;
        }
        if (length == 2) {
            return 2;
        }
        if (length == 3) {
            return 3;
        }

        int max = 0;
        if (length >= 4) {
            for (int i = 1; i < length; i++) {
                int temp = recursive(i) * recursive(length - i);
                if (max < temp) {
                    max = temp;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaxProduct test = new MaxProduct();
        System.out.println(test.maxProduct(7));
    }
}
