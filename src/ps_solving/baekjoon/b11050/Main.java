package ps_solving.baekjoon.b11050;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String   str     = br.readLine();
		String[] str_arr = str.split(" ");
		
		int N = Integer.parseInt(str_arr[0]);
		int K = Integer.parseInt(str_arr[1]);
		
		int A = 1, B = 1, C = 1;
		
		int temp = N;
		while (temp > 1) {
			A *= temp;
			temp--;
		}
		
		temp = N - K;
		while (temp > 1) {
			B *= temp;
			temp--;
		}
		
		temp = K;
		while (temp > 1) {
			C *= temp;
			temp--;
		}
		
		int answer = A / (B * C);
		
		bw.write(String.valueOf(answer));
		bw.flush();
		
		br.close();
		bw.close();
	}
}
