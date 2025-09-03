package ps_solving.baekjoon.b1074;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 답은 맞지만 메모리 초과 뜨는 코드
 * 모든 값을 저장할 필요가 없다.
 */
public class Main {
	
	public static int     index = 0;
	public static int[][] square;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String   str     = br.readLine();
		String[] str_arr = str.split(" ");
		
		int N = Integer.parseInt(str_arr[0]);
		int r = Integer.parseInt(str_arr[1]);
		int c = Integer.parseInt(str_arr[2]);
		
		square = new int[(int) Math.pow(2, N)][(int) Math.pow(2, N)];
		
		int power = N;
		
		numbering(power, 0, 0);
		
		bw.write(String.valueOf(square[r][c]));
		bw.flush();
		
		br.close();
		bw.close();
	}
	
	public static void numbering(int power, int x, int y) {
		
		if (power == 0) {
			square[x][y] = index++;
			return;
		}
		
		numbering(power - 1, x, y);
		numbering(power - 1, x, y + (int) Math.pow(2, power - 1));
		numbering(power - 1, x + (int) Math.pow(2, power - 1), y);
		numbering(power - 1, x + (int) Math.pow(2, power - 1), y + (int) Math.pow(2, power - 1));
	}
}
