package assessmentTest;

public class Test2 {
	public int[] prisonAfterNDays(int[] cells, int n) {
		int[] initiallyCell = new int[cells.length];
		// int[][] mockupArray = new int[64][cells.length];
		// int totalDays = n
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j < cells.length - 1; j++) {
				if (cells[j - 1] == cells[j + 1]) {
					initiallyCell[j] = 1;
				} else {
					initiallyCell[j] = 0;
				}
			}
			initiallyCell[0] = 0;
			initiallyCell[cells.length - 1] = 0;
			cells = initiallyCell.clone();
		}

		return initiallyCell;

	}

	public static void main(String[] args) {
		Test2 obj = new Test2();
		int[] nums = { 1, 0, 0, 1, 0, 0, 1, 0 };
		int target = 1;
		obj.prisonAfterNDays(nums, target);
	}

}
