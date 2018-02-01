/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 */
public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        int count = 0;
        String xStr = Integer.toBinaryString(x);
        String yStr = Integer.toBinaryString(y);
        String longStr;
        String shortStr;

        if (xStr.length() > yStr.length()) {
            longStr = xStr;
            shortStr = yStr;
        } else {
            longStr = yStr;
            shortStr = xStr;
        }
        int longStrCount = longStr.length();
        int shortStrCount = shortStr.length();
        int delta = longStrCount - shortStrCount;

        for (int i = 0; i < longStrCount; i++) {
            char c = '0';
            int index = i - delta;
            if (index >= 0) {
                c = shortStr.charAt(index);
            }
            char c1 = longStr.charAt(i);
            if (c != c1) {
                count++;
            }
        }
        return count;
    }

    public static int hammingDistance2(int x, int y) {
        int result = x ^ y;
        String str = Integer.toBinaryString(result);
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }

    public static int hammingDistance3(int x, int y) {
        // bitCount 返回整数的二进制补码中 位为1的个数
        return Integer.bitCount(x ^ y);
    }

}
