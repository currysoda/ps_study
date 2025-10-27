package ps_solving.baekjoon.b23353;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Iterator_solving {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int     N     = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		
		// 0 = 비어있음, 1 = 흑돌, 2 = 백돌
		// 흑돌의 가장 긴 길이가 점수
		for (int i = 0; i < N; i++) {
			String[] str_arr = br.readLine().split(" ");
			
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(str_arr[j]);
			}
		}
		
		List<Integer> candidate = new ArrayList<>();
		// 직선 검사
		// 좌우 검사
		for (int i = 0; i < N; i++) {
			boolean change = false;
			int     count  = 0;
			for (int j = 0; j < N; j++) {
				
				if (board[i][j] == 0) {
					break;
				}
				
				else if (board[i][j] == 1) {
					count++;
					continue;
				}
				
				else if (board[i][j] == 2) {
					if (change == false) {
						change = true;
						count++;
						continue;
					}
					else {
						break;
					}
				}
			}
		}
		// 상하 검사
		
		// 대각선 검사
		
		
		br.close();
		bw.close();
	}
}
