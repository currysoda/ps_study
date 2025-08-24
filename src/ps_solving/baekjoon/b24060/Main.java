package ps_solving.baekjoon.b24060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String   str     = br.readLine();
		String[] str_arr = str.split(" ");
		
		int N = Integer.parseInt(str_arr[0]);
		int K = Integer.parseInt(str_arr[1]);
		
		str = br.readLine();
		str_arr = str.split(" ");
		
		List<Integer> list = new ArrayList<>();
		int[]         arr  = new int[N];
		
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(str_arr[i]));
			arr[i] = Integer.parseInt(str_arr[i]);
		}
		
		
		br.close();
		bw.close();
	}
	
	public static void merge_sort(int arr[], int p, int q) {
		if (p < q) {
			int temp = (p + q) / 2;
			merge_sort(arr, p, temp);
			merge_sort(arr, temp + 1, q);
			merge(arr);
		}
		else {
			return;
		}
	}
	
	public static void merge(int arr[], int p, int q, int r) {
	
	}
	
	
}
