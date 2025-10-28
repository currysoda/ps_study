package tips;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SubsetRecursion {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[]     s_arr = br.readLine().split(" ");
		Set<Integer> set   = new TreeSet<>(Comparator.naturalOrder());
		
		
		for (String s : s_arr)
		{
			int temp = Integer.parseInt(s);
			set.add(temp);
		}
		
		List<Integer> set_to_list = new ArrayList<>(set);
		
		List<Integer> temp = new ArrayList<>();
		
		subset(set_to_list, 0, temp);
		
		br.close();
		bw.close();
	}
	
	/**
	 * @param set
	 * 	부분 집합을 구할 원 집합 인덱스 기반 접근을 위해 List 로 변환함
	 * @param index
	 * 	set 에서 지금 추가할지 추가 안할지 정할 원소의 index 값 호출 시 0 으로 시작
	 * @param list
	 * 	부분 집합을 저장할 list
	 */
	public static void subset(List<Integer> set, int index, List<Integer> list) {
		if (index >= set.size())
		{
			// 남은 원소가 없음을 뜻함
			System.out.println("list = " + list);
			return;
		}
		
		Integer i = set.get(index);
		
		// 들어갈 것
		List<Integer> list1 = new ArrayList<>(list);
		// 안들어 갈 것
		List<Integer> list2 = new ArrayList<>(list);
		
		list1.add(i);
		
		subset(set, index + 1, list1);
		subset(set, index + 1, list2);
	}
}
