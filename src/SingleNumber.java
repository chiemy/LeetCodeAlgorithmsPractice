import java.util.Arrays;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }

    private int solution1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length ; i += 2) {
            if (i + 1 < nums.length) {
                if (nums[i] != nums[i + 1]) {
                    return nums[i];
                }
            } else {
                return nums[i];
            }
        }
        return 0;
    }
}
