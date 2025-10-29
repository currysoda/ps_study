package tips;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

// 순열
public class Permutation {
	
	
	private static List<List<Integer>> resultList;
	
	private static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[]      s_arr = br.readLine().split(" ");
		List<Integer> list  = new ArrayList<>();
		
		for (String s : s_arr)
		{
			int i = Integer.parseInt(s);
			list.add(i);
		}
		
		
		int n = list.size();            // 원본 리스트의 크기
		resultList = new ArrayList<>(); // 최종 결과를 담을 리스트
		visited = new boolean[n];     // 방문 배열 (전부 false로 자동 초기화)
		
		
		permuteRecursive(list, new ArrayList<>(), n);
		
		for (List<Integer> perm : resultList)
		{
			for (int num : perm)
			{
				bw.write(num + " "); // 각 숫자를 공백으로 구분하여 씀
			}
			bw.newLine(); // 하나의 순열이 끝나면 줄바꿈
		}
		
		bw.flush(); // 버퍼에 남아있는 모든 내용을 강제로 출력
		br.close();
		bw.close();
	}
	
	private static void permuteRecursive(List<Integer> originalList, List<Integer> tempList, int n) {
		
		if (tempList.size() == n)
		{
			resultList.add(new ArrayList<>(tempList));
			return; // 현재 재귀 호출을 종료하고 이전 단계로 돌아감
		}
		
		for (int i = 0; i < n; i++)
		{
			if (!visited[i])
			{
				visited[i] = true;
				
				tempList.add(originalList.get(i));
				
				permuteRecursive(originalList, tempList, n);
				
				tempList.remove(tempList.size() - 1);
				
				visited[i] = false;
			}
		}
	}
}