public class LongestCommonSubsequence {

	public static void main(String[] args) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		String s1 = "AABFSD";
		String s2 = "AGBAAFSDD";
		char[] c1 = s1.toCharArray();
		System.out.println(c1[0]);
		char[] c3 = new char[]{'A', 'B', 'C', 'D'};
//		System.out.println(c3.toString());
//		System.out.println(c1.toString());
		char[] c2 = s2.toCharArray();
//		System.out.println(lcs.getLCSLength(c1, c2));
		
		char[] res = lcs.getLCS(c1, c2);
		for (char c: res) {
			System.out.println(c);
		}
	}
	
	public char[] getLCS(char[] c1, char[] c2) {
		//First get the longest common subsequence length using Dynamic Programming
		int m = c1.length, n = c2.length;
		int[][] dp = new int[m + 1][n + 1];
//		dp[0][0] = 0;
		
		for (int i = 0; i <= m; i++) {		//注意等于号！
			for (int j = 0; j <= n; j++) {	//注意等于号!
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (c1[i - 1] == c2[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		
		int lcsLen = dp[m][n];
		System.out.println(lcsLen);
		char[] res = new char[lcsLen];
//		char[] result = new char[lcsLen + 1];
//		result[lcsLen] = "\0";		//Set the terminating character

/**From length - 1 to 0**/
		int i = m, j = n, index = lcsLen;
		while (i > 0 && j > 0) {
			if (c1[i - 1] == c2[j - 1]) {
				res[index - 1] = c1[i - 1];
				i--;
				j--;
				index--;
			} else if (dp[i - 1][j] > dp[i][j - 1]) {
				i--;
			} else j--;
		}
		
		
/**From 0 to lenth -1 is not a good idea**/
//		int i = 0, j = 0, index = 0;
//		while (i < m - 1 && j < n - 1) {
//			if (c1[i] == c2[j]) {
//				res[index++] = c1[i];
//				i++;
//				j++;
//			} else if (dp[i + 1][j] > dp[i][j + 1]) {
//				i++;
//			} else j++;
//		}
		
		return res;
	}
	
	public int getLCSLength(char[] c1, char[] c2) {
		//First get the longest common subsequence length using Dynamic Programming
		int m = c1.length, n = c2.length;
		int[][] dp = new int[m + 1][n + 1];
		System.out.println(c1.toString() + " " + c2.toString());
		System.out.println(c1[2]);
		
		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (c1[i - 1] == c2[j - 1]) {
					System.out.println("Reached");
					dp[i][j] = dp[i - 1][j - 1] + 1;
					System.out.println("dp[" + i + "][" + j + "]: " + dp[i][j]);
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		
		return dp[m][n];
	}
}
