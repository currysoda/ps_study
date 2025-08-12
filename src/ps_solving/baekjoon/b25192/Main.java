package ps_solving.baekjoon.b25192;

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
		
		int         N      = Integer.parseInt(br.readLine());
		int         result = 0;
		Set<String> set    = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (str.equals("ENTER")) {
				result += set.size();
				set.clear();
			}
			else {
				set.add(str);
			}
		}
		
		if (!set.isEmpty()) {
			result += set.size();
			set.clear();
		}
		
		bw.write(String.valueOf(result));
		bw.flush();
		
		br.close();
		bw.close();
	}
}
