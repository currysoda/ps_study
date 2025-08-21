package tips;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MultiKeySort {
	
	public static void main(String[] args) {
		
		// String(key), count(value)
		Map<String, Integer> mode = new HashMap<>();
		
		/**
		 * 정렬 기준
		 * 1. 많이 등장한 횟수
		 * 2. 문자열의 길이
		 * 3. 사전순 정렬
		 *
		 * 의 여러가지 정렬 기준을 적용해서 정렬이 되도록 하는 Comparator 익명 클래스 구현
		 */
		
		// 익명 클래스
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
		
		// 람다
		Comparator<String> comp2 = (String o1, String o2) -> {
			int a = mode.get(o1);
			int b = mode.get(o2);
			
			if (a != b) {
				return b - a;
			}
			
			if (o1.length() != o2.length()) {
				return o2.length() - o1.length();
			}
			
			return o1.compareTo(o2);
		};
	}
}
