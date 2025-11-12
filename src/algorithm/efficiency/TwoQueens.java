package algorithm.efficiency;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// N * N 체스판에서 퀸 2개를 서로 공격할 수 없는 경우로 놓는 문제
// 자세한 수식 설명은 게시글에
public class TwoQueens {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		long[] arr = new long[N + 1];
		
		arr[0] = 0;
		arr[1] = 0;
		arr[2] = 0;
		
		for (int i = 3; i <= N; i++)
		{
			// 2(k-1)^2(k-2)
			
			long temp   = i - 1;
			long temp2  = i - 2;
			long result = arr[i - 1] + (2 * temp * temp * temp2);
			
			arr[i] = result;
		}
		
		
		System.out.println("arr[N] = " + arr[N]);
		
		br.close();
		bw.close();
	}
}
