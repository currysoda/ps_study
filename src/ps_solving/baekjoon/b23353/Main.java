package ps_solving.baekjoon.b23353;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int         N     = Integer.parseInt(br.readLine());
		int[][]     board = new int[N][N];
		int[][][][] dp    = new int[4][N][N][2]; // 방향 / 행 / 열 / 변경 전 = 0, 변경 후 = 1
		int[]       di    = {0, 1, 1, 1}; // 좌 좌상단 상단 우상단
		int[]       dj    = {1, 1, 0, -1}; // 좌 좌상단 상단 우상단
		
		// 0 = 비어있음, 1 = 흑돌, 2 = 백돌
		// 흑돌의 가장 긴 길이가 점수
		for (int i = 0; i < N; i++)
		{
			String[] str_arr = br.readLine().split(" ");
			
			for (int j = 0; j < N; j++)
			{
				int temp = Integer.parseInt(str_arr[j]);
				board[i][j] = temp;
			}
		}
		
		// 초기화
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				for (int k = 0; k < 4; k++)
				{
					for (int q = 0; q < 2; q++)
					{
						dp[k][i][j][q] = 0;
					}
				}
			}
		}
		
		int maxScore = 0;
		// 점수 매기기
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				for (int k = 0; k < 4; k++)
				{
					int stone = board[i][j];
					if (stone == 0)
					{
						continue;
					}
					int prev_i = i - di[k];
					int prev_j = j - dj[k];
					
					int prev_raw    = 0;
					int prev_change = 0;
					
					if (prev_i >= 0 && prev_i < N && prev_j >= 0 && prev_j < N)
					{
						prev_raw = dp[k][prev_i][prev_j][0];
						prev_change = dp[k][prev_i][prev_j][1];
					}
					
					if (stone == 1)
					{
						dp[k][i][j][0] = prev_raw + 1;
						dp[k][i][j][1] = prev_change + 1;
					}
					if (stone == 2)
					{
						dp[k][i][j][0] = 0;
						dp[k][i][j][1] = prev_raw + 1;
					}
					
					maxScore = Math.max(maxScore, dp[k][i][j][0]);
					maxScore = Math.max(maxScore, dp[k][i][j][1]);
				}
			}
		}
		
		bw.write(String.valueOf(maxScore));
		bw.flush();
		
		br.close();
		bw.close();
	}
}
