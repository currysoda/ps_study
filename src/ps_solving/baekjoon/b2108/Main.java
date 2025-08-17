package ps_solving.baekjoon.b2108;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br      = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw      = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb      = new StringBuilder();
		String         newline = System.lineSeparator();
		
		int N = Integer.parseInt(br.readLine());
		
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			list.add(temp);
		}
		
		// 평균
		// 중앙값
		// 최빈값 (가장 많이 자주 나타나는 값)
		// 범위
		Collections.sort(list);
		
		int average;
		int middleNum;
		int mode = 0; // 최빈값
		int range;
		
		range = list.get(list.size() - 1) - list.get(0);
		
		int sum = 0;
		for (Integer i : list) {
			sum += i;
		}
		
		average = (int) Math.round((double) sum / list.size());
		middleNum = list.get(list.size() / 2);
		
		// 최빈값 mode 구하기
		
		// number, count
		Map<Integer, Integer> map = new HashMap<>();
		
		for (Integer i : list) {
			if (map.containsKey(i)) {
				int temp = map.get(i);
				map.put(i, temp + 1);
			}
			else {
				map.put(i, 1);
			}
		}
		
		int max = 0;
		
		for (Integer i : map.values()) {
			if (i > max) {
				max = i;
			}
		}
		
		// 최빈값 정답 후보
		List<Integer> list2 = new ArrayList<>();
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue().equals(max)) {
				list2.add(entry.getKey());
			}
		}
		
		Collections.sort(list2);
		
		if (list2.size() == 1) {
			mode = list2.get(0);
		}
		if (list2.size() >= 2) {
			mode = list2.get(1);
		}
		
		sb.append(average).append(newline)
		  .append(middleNum).append(newline)
		  .append(mode).append(newline)
		  .append(range).append(newline);
		
		bw.write(sb.toString());
		bw.flush();
		
		br.close();
		bw.close();
	}
}
