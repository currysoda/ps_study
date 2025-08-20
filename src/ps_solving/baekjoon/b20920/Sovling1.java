package ps_solving.baekjoon.b20920;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sovling1 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br      = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw      = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb      = new StringBuilder();
		String         newline = System.lineSeparator();
		
		String   str    = br.readLine();
		String[] strArr = str.split(" ");
		
		int N = Integer.parseInt(strArr[0]);
		int M = Integer.parseInt(strArr[1]);
		
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			if (str.length() >= M) {
				list.add(str);
			}
		}
		
		// String, count
		Map<String, Integer> mode = new HashMap<>();
		
		for (String s : list) {
			mode.put(s, mode.getOrDefault(s, 0) + 1);
		}
		
		List<String> result = new ArrayList<>(mode.keySet());
		
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				int a = mode.get(o1);
				int b = mode.get(o2);
				
				if (a != b) {
					return b - a;
				}
				
				if (o1.length() != o2.length()) {
					return o2.length() - o1.length();
				}
				
				return o1.compareTo(o2);
			}
		};
		
		result.sort(comp);
		
		
		for (String s : result) {
			sb.append(s).append(newline);
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		br.close();
		bw.close();
	}
	
}
