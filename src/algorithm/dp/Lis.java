package algorithm.dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// 최장 증가 부분 수열(Longest increasing subsequence)
public class Lis {
	
	public static Set<List<Integer>> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str_arr = br.readLine().split(" ");
		
		int[] number = new int[str_arr.length + 1];
		int[] dp     = new int[str_arr.length + 1];
		
		number[0] = 0;
		dp[0] = 0;
		for (int i = 1; i < str_arr.length + 1; i++)
		{
			number[i] = Integer.parseInt(str_arr[i - 1]);
		}
		
		for (int k = 1; k < number.length; k++)
		{
			// number[k] 기준으로 앞부분의 숫자를 모두 검사해야함 그래서 i = 0 ~ k 까지 검사
			// dp[k] 의 초기값은 1(자기자신)
			dp[k] = 1;
			for (int i = 0; i <= k; i++)
			{
				// 여기서 dp[k] 의 값을 갱신
				if (number[i] < number[k])
				{
					dp[k] = Math.max(dp[i] + 1, dp[k]);
				}
			}
		}
		
		for (int n : number)
		{
			System.out.print(n + " ");
		}
		
		System.out.println(System.lineSeparator());
		
		for (int n : dp)
		{
			System.out.print(n + " ");
		}
		
		System.out.println(System.lineSeparator());
		
		
		int max   = 0;
		int index = 0;
		
		for (int i = 0; i < dp.length; i++)
		{
			if (dp[i] > max)
			{
				max = dp[i];
				index = i;
			}
		}
		
		dfs(max, number, dp, dp.length, new ArrayList<>());
		
		br.close();
		bw.close();
	}
	
	public static void dfs(int target_value, int[] number, int[] dp, int currentIndex, List<Integer> list) {
		if (target_value == 0)
		{
			System.out.println("list = " + list);
			set.add(list);
			return;
		}
		
		for (int i = 0; i < currentIndex; i++)
		{
			if (list.isEmpty())
			{
				if (dp[i] == target_value)
				{
					int temp = number[i];
					
					List<Integer> list2 = new ArrayList<>(list);
					
					list2.add(temp);
					
					dfs(target_value - 1, number, dp, i, list2);
				}
			}
			else
			{
				if (dp[i] == target_value && number[i] < list.getLast())
				{
					int temp = number[i];
					
					List<Integer> list2 = new ArrayList<>(list);
					
					list2.add(temp);
					
					dfs(target_value - 1, number, dp, i, list2);
				}
			}
		}
	}
}
