package Algorithms.NumberTheory;

public class NextPermutation {
	public static void next(int nums[]) {
		boolean flag = false;
		int p = 0;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				p = i;
				flag = true;
				break;
			}
		}
		int j = 0;
		for (int i = nums.length - 1; i > p; i--) {
			if (nums[i] > nums[p]) {
				j = i;
				break;
			}
		}
		boolean sec = false;
		if (p == 0 && j == 0) {
			reverse(nums, 0, nums.length - 1);
			sec = true;
		}
		if (!sec) {
			int temp = nums[p];
			nums[p] = nums[j];
			nums[j] = temp;

			if (p < nums.length - 1) {
				reverse(nums, p + 1, nums.length - 1);
			}
		}
		if (flag) {
			System.out.println(nums);
		} else {
			System.out.println("no answer");
		}
	}

	public static void reverse(int[] nums, int left, int right) {
		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}
}
