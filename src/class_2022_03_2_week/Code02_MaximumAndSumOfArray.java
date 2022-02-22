package class_2022_03_2_week;

// 测试链接 : https://leetcode.com/problems/maximum-and-sum-of-array/
// 1, 状态压缩动态规划
// 2, km算法
// 3, 最小费用最大流(以后安排)
public class Code02_MaximumAndSumOfArray {

	public static int maximumANDSum1(int[] arr, int m) {
		int status = (int) Math.pow(3, m) - 1;
		int[] dp = new int[status + 1];
		return process1(arr, 0, status, m, dp);
	}

	public static int process1(int[] arr, int i, int status, int m, int[] dp) {
		if (dp[status] != 0) {
			return dp[status];
		}
		if (i == arr.length) {
			return 0;
		}
		int ans = 0;
		for (int j = 1, bit = 1; j <= m; j++, bit *= 3) {
			if ((status / bit) % 3 > 0) {
				ans = Math.max(ans, (arr[i] & j) + process1(arr, i + 1, status - bit, m, dp));
			}
		}
		dp[status] = ans;
		return ans;
	}

}