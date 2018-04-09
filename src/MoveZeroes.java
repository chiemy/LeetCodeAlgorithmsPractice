public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int size = nums.length;
        int index = 0;
        for (int i = 0 ; i < size ; index++,i++) {
            int value = nums[i];
            if(value == 0) {
                for(int j = i + 1 ;  j < size ; j++) {
                    if(nums[j] != 0) {
                        value = nums[j];
                        i = j;
                        break;
                    }
                }
            }
            nums[index] = value;
        }
        for (int i = index; i < size; i++) {
            nums[i] = 0;
        }

        for (int i = 0; i < size; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
