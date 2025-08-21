package ps_solving.baekjoon.b27433;

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
		
		Long[] long_arr = new Long[21];
		
		long_arr[0] = 1L;
		
		for (int i = 1; i < long_arr.length; i++) {
			long_arr[i] = long_arr[i - 1] * i;
		}
		
		sb.append(long_arr[N]);
		bw.write(sb.toString());
		bw.flush();
		
		br.close();
		bw.close();
	}
}
