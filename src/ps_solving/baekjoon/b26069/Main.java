package ps_solving.baekjoon.b26069;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int         N   = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			String   str     = br.readLine();
			String[] str_arr = str.split(" ");
			
			if (str_arr[0].equals("ChongChong") || str_arr[1].equals("ChongChong")) {
				set.add(str_arr[0]);
				set.add(str_arr[1]);
			}
			
			if (set.contains(str_arr[0]) || set.contains(str_arr[1])) {
				set.add(str_arr[0]);
				set.add(str_arr[1]);
			}
		}
		
		bw.write(String.valueOf(set.size()));
		bw.flush();
		
		br.close();
		bw.close();
	}
}
