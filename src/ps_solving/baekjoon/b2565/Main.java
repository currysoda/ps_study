package ps_solving.baekjoon.b2565;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str_arr = br.readLine().split(" ");
		
		int[] arr1 = new int[str_arr.length + 1];
		int[] arr2 = new int[str_arr.length + 1];
		
		for (int i = 0; i < str_arr.length; i++) {
			arr1[i] = Integer.parseInt(str_arr[i]);
		}
		
		
		br.close();
		bw.close();
	}
}
