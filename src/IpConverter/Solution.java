package IpConverter;

/**
 * Created by liuxucheng on 2018/5/10.
 */
public class Solution {

    /**
     * ipV4 --> 32位无符号整数
     * 返回值可能会大于Integer.MAX_VALUE
     * @param ip
     * @return
     */
    public long ip2Long(String ip) {
        long res = 0;
        int segCnt = 1; // 分段数量
        int segData = -1; // 每段的值
        int zeroCnt = 0; // 每一段中0的数量
        boolean startWithZero = false; // 某一段是否以0开头
        char cur; // 当前char指针
        char prev = ' '; // 当前char的前驱指针
        boolean prevBlankAfterDigit = false; // 标识前驱的空字符是否在某一数字之后

        if (ip == null) {
            return -1;
        }

        for (int i = 0; i < ip.length(); i++) {
            cur = ip.charAt(i);
            switch(prev) {
                case ' ':
                    prev = cur;
                    // 如果当前字符以及前一个字符都为空字符，不对prevBlankAfterDigit的值作改动，处理两个数字中间存在多个空格的情况
                    if (cur == ' ') {
                        continue;
                    } else if (isDigit(cur)) {
                        // 如果前面一个char为空字符，且该空字符在某一数字之后，则认为输入ip不合法
                        // eg: 1 92.0.0.1
                        if (prevBlankAfterDigit) {
                            return -1;
                        }
                        int val = cur - '0';
                        segData = val;
                        if (val == 0) {
                            zeroCnt++;
                            startWithZero = true;
                        }
                    } else if (cur == '.') { // 标识该段已经结束
                        segCnt++;
                        if (segCnt > 4) {
                            return -1;
                        }

                        // eg: 192.00.1.1, 192.01.1.1
                        if (startWithZero && (zeroCnt > 1 || segData != 0)) {
                            return -1;
                        }

                        // segData未被赋值，标识该段没有数字，输入ip不合法
                        if (segData == -1) {
                            return -1;
                        }

                        res = (res << 8) | segData;
                        segData = -1;
                        zeroCnt = 0;
                        startWithZero = false;
                    } else {
                        return -1;
                    }
                    break;
                case '.':
                    if (cur == ' ') {
                        prev = cur;
                        prevBlankAfterDigit = false;
                        continue;
                    } else if (isDigit(cur)) {
                        int val = cur - '0';
                        segData = val;
                        if (val == 0) {
                            zeroCnt++;
                            startWithZero = true;
                        }
                        prev = cur;
                    } else {
                        return -1;
                    }
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    prev = cur;
                    if (cur == ' ') {
                        prevBlankAfterDigit = true;
                        continue;
                    } else if (isDigit(cur)) {
                        int val = cur - '0';
                        if (val == 0) {
                            zeroCnt++;
                        }
                        segData = segData * 10 + val;
                        if (segData > 255) {
                            return -1;
                        }
                    } else if (cur == '.') {
                        segCnt++;
                        if (segCnt > 4) {
                            return -1;
                        }

                        if (startWithZero && (zeroCnt > 1 || segData != 0)) {
                            return -1;
                        }

                        res = (res << 8) | segData;
                        segData = -1;
                        zeroCnt = 0;
                        startWithZero = false;
                    } else {
                        return -1;
                    }
                    break;
                default:
                    return -1;
            }
        }

        // 校验最后一段是否合法
        if (segData < 0) {
            return -1;
        }

        if (startWithZero && (zeroCnt > 1 || segData != 0)) {
            return -1;
        }

        if (segCnt < 4 || prev == '.') {
            return -1;
        }

        // 加上最后一段
        return (res << 8) | segData;
    }

    private boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.ip2Long("17  2.168.5.1"));
    }
}
