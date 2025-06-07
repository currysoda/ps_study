package ps_solving.baekjoon.b1010;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br      = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw      = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb      = new StringBuilder();
		String         newline = System.lineSeparator();
		
		int T = Integer.parseInt(br.readLine());
		
		long[][] pascal = pascalTriangle(31);
		
		while (T-- > 0) {
			int A = 1, B = 1, C = 1;
			
			String   str     = br.readLine();
			String[] str_arr = str.split(" ");
			
			int N = Integer.parseInt(str_arr[0]);
			int K = Integer.parseInt(str_arr[1]);
			
			sb.append(pascal[K][N]).append(newline);
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		br.close();
		bw.close();
	}
	
	public static long[][] pascalTriangle(int n) {
		long[][] pascal = new long[n][n];
		
		for (int i = 1; i < n; i++) {
			pascal[i][0] = 1;
			pascal[i][i] = 1;
			for (int j = 1; j < i; j++) {
				pascal[i][j] = pascal[i - 1][j] + pascal[i - 1][j - 1];
			}
		}
		
		return pascal;
	}
}
