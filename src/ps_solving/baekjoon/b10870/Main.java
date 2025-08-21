package ps_solving.baekjoon.b10870;

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
		
		int N = Integer.parseInt(br.readLine());
		
		Integer[] arr = new Integer[21];
		arr[0] = 0;
		arr[1] = 1;
		
		for (int i = 2; i < 21; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		
		sb.append(arr[N]);
		bw.write(sb.toString());
		bw.flush();
		
		br.close();
		bw.close();
	}
}
