import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

 * <br>The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 * If it does not exist, output -1 for this number.
 * <br>
 * <br>Example 1:
 * <br>Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * <br>Output: [-1,3,-1]
 * <br>Explanation:
 * <br>For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * <br>For number 1 in the first array, the next greater number for it in the second array is 3.
 * <br>For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], i);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int index = map.get(nums1[i]);
            result[i] = -1;
            while (index < nums2.length - 1) {
                index++;
                if (nums1[i] < nums2[index]) {
                    result[i] = nums2[index];
                    break;
                }
            }
        }
        return result;
    }
}
