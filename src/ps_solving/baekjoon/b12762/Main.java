package ps_solving.baekjoon.b12762;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] str_arr = br.readLine().split(" ");
		
		List<Integer> list     = new ArrayList<>(N);
		int           previous = Integer.parseInt(str_arr[0]);
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(str_arr[i]);
			if (previous == temp) {
				continue;
			}
			else {
				list.add(temp);
				previous = temp;
			}
		}
		
		List<Integer> list2 = new ArrayList<>(list);
		list2.reversed();
		
		List<Integer> dp = new ArrayList<>(list.size() - 1);
		for (int i = 0; i < list.size() - 1; i++) {
			dp.add(list.get(i) - list.get(i + 1));
		}
		
		
		br.close();
		bw.close();
	}
}
