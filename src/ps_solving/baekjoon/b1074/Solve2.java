package ps_solving.baekjoon.b1074;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solve2 {
	
	public static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String   str     = br.readLine();
		String[] str_arr = str.split(" ");
		
		int N        = Integer.parseInt(str_arr[0]);
		int target_r = Integer.parseInt(str_arr[1]);
		int target_c = Integer.parseInt(str_arr[2]);
		
		numbering(N, 0, 0, target_r, target_c);
		
		bw.write(String.valueOf(answer));
		bw.flush();
		
		br.close();
		bw.close();
	}
	
	public static void numbering(int power, int row, int col, int r, int c) {
		
		if (power == 0) {
			return;
		}
		
		int offset = (int) (Math.pow(Math.pow(2, power - 1), 2));
		
		if (r >= row + (int) Math.pow(2, power - 1)) {
			answer += (offset * 2);
			row += (int) Math.pow(2, power - 1);
		}
		
		if (c >= col + Math.pow(2, power - 1)) {
			answer += (offset);
			col += (int) Math.pow(2, power - 1);
		}
		//		System.out.println("answer = " + answer);
		//		System.out.println("row = " + row);
		//		System.out.println("col = " + col);
		
		numbering(power - 1, row, col, r, c);
	}
}
