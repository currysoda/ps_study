package ps_solving.baekjoon.b27172;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		String[] str_arr = br.readLine().split(" ");
		
		final int MAX_VALUE = 1000000;
		
		boolean[] exists = new boolean[MAX_VALUE + 1];
		int[]     scores = new int[MAX_VALUE + 1];
		
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(str_arr[i]);
			exists[temp] = true;
		}
		
		for (int i = 1; i < exists.length; i++) {
			
			if (exists[i] == false) {
				continue;
			}
			
			int number = i;
			
			for (int j = number + number; j <= MAX_VALUE; j += number) {
				if (exists[j]) {
					scores[number] += 1;
					scores[j] -= 1;
				}
			}
		}
		
		for (int i = 0; i < str_arr.length; i++) {
			int index = Integer.parseInt(str_arr[i]);
			
			sb.append(scores[index]).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		br.close();
		bw.close();
	}
}
