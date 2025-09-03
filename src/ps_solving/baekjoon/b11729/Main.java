package ps_solving.baekjoon.b11729;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	private static StringBuilder sb      = new StringBuilder();
	private static String        newline = System.lineSeparator();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int K = Integer.parseInt(br.readLine());
		
		sb.append(((int) Math.pow(2, K)) - 1).append(newline);
		
		hanoi(K, 1, 2, 3);
		
		bw.write(sb.toString());
		bw.flush();
		
		br.close();
		bw.close();
	}
	
	// 원판의 갯수, 시작점, 중간 다리, 도착점
	public static void hanoi(int N, int start, int mid, int to) {
		
		if (N == 1) {
			sb.append(start).append(" ").append(to).append(newline);
			return;
		}
		
		hanoi(N - 1, start, to, mid);
		sb.append(start).append(" ").append(to).append(newline);
		hanoi(N - 1, mid, start, to);
	}
}
