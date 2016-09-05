package ch9S.chapter4_TwoPointer;

public class QuickSelect {
	public int partition(int[] nums, int l, int r) {
		//初始化左右指针和pivot
		int left = l, right = r;
		int pivot = nums[left];
		
		//进行partition
		while (left < right) {
			while (left < right && nums[right] >= pivot) {
				right--;
			}
			nums[left] = nums[right];
			while (left < right && nums[left] <= pivot) {
				left++;
			}
			nums[right] = nums[left];
		}
		
		//返还pivot点到数组里面
		nums[left] = pivot;
		return left;
	}
}
