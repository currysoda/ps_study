package ps_solving.baekjoon.b9663;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static int count = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int answer = 0;
		
		if (N == 1)
		{
			answer = 1;
		}
		else if (N == 2 || N == 3)
		{
			answer = 0;
		}
		else
		{
			// 배열의 index = 행, 배열의 값 = 열
			nqueen(new int[N], 0, N);
			answer = count;
		}
		
		bw.write(String.valueOf(answer));
		bw.flush();
		
		br.close();
		bw.close();
	}
	
	public static void nqueen(int[] board, int index, int N) {
		
		// 탈출조건 N 개의 퀸을 배치함
		if (index == N)
		{
			count++;
			return;
		}
		
		// 이번 행(index) 에서 어느 열(j) 에 배치 할지를 정한다.
		for (int j = 0; j < N; j++)
		{
			// 한 행에서 충돌이 없다면 진행
			// 한 행 내에서 a 열 검사를 수행한 이후 b 열이 조건을 충족하면 기존값을 덮어씀
			if (isAttack(board, index, j) == false)
			{
				board[index] = j;
				// 이번 행에서 배치에 성공했다면 다음 행으로 넘어간다.
				nqueen(board, index + 1, N);
			}
			// 이번 행에서 배치에 실패하면 이 가능성은 그대로 종료한다.
			// => 이전 행의 다음 반복문이 실행된다.
		}
	}
	
	public static boolean isAttack(int[] board, int index, int col) {
		
		boolean result = false;
		
		// 내가 배치하려는 행 = index 열 = col 에서 그 윗 행만 검사한다 (아래 행은 아직 배치하지 않았기 때문 = 백트래킹의 특징)
		for (int i = 0; i < index; i++)
		{
			if (board[i] == col)
			{
				return true;
			}
			
			if (Math.abs(board[i] - col) == index - i)
			{
				return true;
			}
		}
		
		return result;
	}
}
