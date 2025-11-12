package ps_solving.baekjoon.b2565;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	static class Pair {
		
		public int A;
		public int B;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		List<Pair> list       = new ArrayList<>();
		int        pillar_max = 0;
		
		for (int i = 0; i < N; i++)
		{
			Pair pair = new Pair();
			
			String[] str_arr = br.readLine().split(" ");
			pair.A = Integer.parseInt(str_arr[0]);
			pair.B = Integer.parseInt(str_arr[1]);
			
			list.add(pair);
			
			if (pillar_max < pair.A)
			{
				pillar_max = pair.A;
			}
			
			if (pillar_max < pair.B)
			{
				pillar_max = pair.B;
			}
		}
		
		int[] arr = new int[pillar_max + 1];
		int[] dp  = new int[pillar_max + 1];
		
		Arrays.fill(arr, Integer.MAX_VALUE);
		
		arr[0] = 0;
		
		for (int i = 0; i < list.size(); i++)
		{
			arr[list.get(i).A] = list.get(i).B;
		}
		
		for (int i = 1; i < dp.length; i++)
		{
			if (arr[i] == Integer.MAX_VALUE)
			{
				dp[i] = 0;
				continue;
			}
			
			dp[i] = 1;
			
			for (int j = 0; j < i; j++)
			{
				if (arr[j] != Integer.MAX_VALUE && arr[i] > arr[j])
				{
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		int max = 0;
		
		for (int i : dp)
		{
			if (i > max)
			{
				max = i;
			}
		}
		
		bw.write(String.valueOf(list.size() - max));
		bw.flush();
		
		br.close();
		bw.close();
	}
}

