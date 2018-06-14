/**
 *
 X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.

 A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.

 Now given a positive number N, how many numbers X from 1 to N are good?

 Example:
 Input: 10
 Output: 4
 Explanation:
 There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 Note:

 N  will be in range [1, 10000].
 */
public class _788RotatedDigits {

    public int rotatedDigits(int N) {
        return solution1(N);
    }

    private int solution1(int n) {
        int count = 0;
        int size = n + 1;
        int num;
        for (int i = 1; i < size; i++) {
            num = i;
            if (num >= 10) {
                while (num >= 10) {
                    if (isGoodNumber(num % 10)) {
                        count++;
                        break;
                    }
                    num /= 10;
                }
            } else if (isGoodNumber(num)){
                count++;
            }
        }
        return count;
    }

    private boolean isGoodNumber(int num) {
        return num == 2
                || num == 5
                || num == 6
                || num == 9;
    }
}
