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
		
		if (index == N)
		{
			count++;
			return;
		}
		
		for (int j = 0; j < N; j++)
		{
			// 한 행에서 충돌이 없다면 진행
			// 한 행 내에서 a 열 검사를 수행한 이후 b 열이 조건을 충족하면 기존값을 덮어씀
			if (isAttack(board, index, j) == false)
			{
				board[index] = j;
				nqueen(board, index + 1, N);
			}
			// 한 행의 끝에서도 충돌이 발견되면 가능성 X => 종료 조건 하지만 명시적 구현이 필요하지 않음
		}
		// 배치가 제대로 되면 다음 행에 배치한다.
		//		nqueen(board, index + 1, N);
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
