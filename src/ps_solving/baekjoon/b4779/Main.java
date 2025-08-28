package ps_solving.baekjoon.b4779;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String base = "-";
		
		String[] str_arr = new String[13];
		str_arr[0] = base;
		
		for (int i = 1; i < str_arr.length; i++) {
			String pattern = str_arr[i - 1];
			
			String spaces = " ".repeat(str_arr[i - 1].length());
			
			str_arr[i] = pattern + spaces + pattern;
		}
		
		String input = null;
		while ((input = br.readLine()) != null) {
			int N = Integer.parseInt(input);
			
			bw.write(str_arr[N]);
			bw.newLine();
			bw.flush();
		}
		
		br.close();
		bw.close();
	}
}
