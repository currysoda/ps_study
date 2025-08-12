package ps_solving.baekjoon.b1037;

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
		int result;
		
		List<Integer> list = new ArrayList<>();
		
		String   str     = br.readLine();
		String[] str_arr = str.split(" ");
		
		for (String s : str_arr) {
			list.add(Integer.parseInt(s));
		}
		
		Collections.sort(list);
		
		if (list.size() == 1) {
			result = (int) Math.pow(list.get(0), 2);
		}
		else {
			result = list.get(0) * list.get(list.size() - 1);
		}
		
		bw.write(String.valueOf(result));
		bw.flush();
		
		br.close();
		bw.close();
	}
}
