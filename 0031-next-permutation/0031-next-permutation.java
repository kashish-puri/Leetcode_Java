class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length - 1;
        int pivot = -1;
        for(int i = n; i > 0; i--){
            if(nums[i] > nums[i - 1]){
                pivot = i - 1;
                break;
            }
        }
        if(pivot == -1){
            reverse(nums, 0, n);
            return;
        }
        int j = n;
        while(j >= 0 && nums[j] <= nums[pivot]){
            j--;
        }
        swap(nums, pivot, j);
        reverse(nums, pivot + 1, n);
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}