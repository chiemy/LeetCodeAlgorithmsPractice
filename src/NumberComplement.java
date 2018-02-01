/**
 * Given a positive integer, output its complement number(补码).
 * The complement strategy is to flip the bits of its binary representation.
 *
 * Note:
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.<br/>
 * You could assume no leading zero bit in the integer’s binary representation.<br/>
 * Example 1:<br/>
 * Input: 5<br/>
 * Output: 2<br/>
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So yo
 */
public class NumberComplement {
    public int findComplement(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
    }
}
