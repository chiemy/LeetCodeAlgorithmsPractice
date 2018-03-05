import java.util.*;

/**
 * Given an integer array with even length,
 * where different numbers in this array represent different kinds of candies.
 * Each number means one candy of the corresponding kind.
 * You need to distribute these candies equally in number to brother and sister.
 * Return the maximum number of kinds of candies the sister could gain.
 * <p>
 * <br>Example 1:
 * <br>Input: candies = [1,1,2,2,3,3]
 * <br>Output: 3
 * <br>Explanation:
 * <br>There are three different kinds of candies (1, 2 and 3), and two candies for each kind.
 * <br>Optimal distribution: The sister has candies [1,2,3] and the brother has candies [1,2,3], too.
 * <br>The sister has three different kinds of candies.
 * </p>
 * <p>
 * <br>Example 2:
 * <br>Input: candies = [1,1,2,3]
 * <br>Output: 2
 * <br>Explanation: For example, the sister has candies [2,3] and the brother has candies [1,1].
 * <br>The sister has two different kinds of candies, the brother has only one kind of candies.
 * </p>
 * 思路：每人分的种类不可能超出分的糖果数量，且分的种类最多为总种类数。即：<br>
 *     当每人分的糖果数量 > 总种类时，肯定能保证一人能分到所有种类的糖果。<br>
 *     当每人分的糖果数量 < 总种类时，肯定能保证一个人拿到的糖果不重样。<br>
 */
public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        Set<Integer> kindSet = new HashSet<>();
        for (int kind : candies) {
            kindSet.add(kind);
        }
        return Math.min(kindSet.size(), candies.length / 2);
    }
}