import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * <p>
 * Example 1:<br/>
 * Input: [1,4,3,2]<br/>
 * Output: 4<br/>
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).<br/>
 * </p>
 * <p>
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].<br/>
 * All the integers in the array will be in the range of [-10000, 10000].
 *  </p>
 */
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        return solution3(nums);
    }

    private int solution1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums) {
            list.add(i);
        }
        Collections.sort(list);
        int sum = 0;
        int size = list.size() / 2;
        for (int i = 0; i < size; i++) {
            // 已经排序了，肯定是前面的小，没有必要比较大小
            sum += Math.min(list.get(2 * i), list.get(2 * i + 1));
        }
        return sum;
    }

    private int solution2(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int size = nums.length / 2;
        for (int i = 0; i < size; i++) {
            sum += Math.min(nums[2 * i], nums[2 * i + 1]);
        }
        return sum;
    }

    private int solution3(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
