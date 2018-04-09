public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        solution1(nums);

        for (int i = 0; i < size; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private void solution1(int[] nums) {
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

    private void solution2(int[] nums) {
        int size = nums.length;
        int index = 0;
        for (int i = 0 ; i < size ; i++) {
            if(nums[i] != 0) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
