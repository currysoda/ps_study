package algorithm.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str_arr = br.readLine().split(" ");
		
		int[] number = new int[str_arr.length + 1];
		int[] dp     = new int[str_arr.length + 1];
		
		number[0] = 0;
		dp[0] = 0;
		for (int i = 1; i < str_arr.length + 1; i++) {
			number[i] = Integer.parseInt(str_arr[i - 1]);
		}
		
		for (int k = 1; k < number.length; k++) {
			// number[k] 기준으로 앞부분의 숫자를 모두 검사해야함 그래서 i = 0 ~ k 까지 검사
			// dp[k] 의 초기값은 1(자기자신)
			dp[k] = 1;
			for (int i = 0; i <= k; i++) {
				// 여기서 dp[k] 의 값을 갱신
				if (number[i] < number[k]) {
					dp[k] = Math.max(dp[i] + 1, dp[k]);
				}
			}
		}
		
		br.close();
		bw.close();
	}
}
