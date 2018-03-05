/**
 * Given a positive integer, check whether it has alternating bits: namely,
 * if two adjacent bits will always have different values.
 */
public class BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        String s = Integer.toBinaryString(n);
        char pre = '2';
        for (char c : s.toCharArray()) {
            if (c != pre) {
                pre = c;
            } else {
                return false;
            }
        }
        return true;
    }
}
