package algorithm;

import java.util.ArrayList;
import java.util.List;

public class SortSet {
	
	// 버블 정렬 구현
	public static void bubbleSort(List<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			
			for (int j = 0; j < list.size() - 1 - i; j++) {
				
				if (list.get(j) > list.get(j + 1)) {
					swap(list, j, j + 1);
				}
			}
		}
	}
	
	// 선택 정렬 구현
	public static void selectionSort(List<Integer> list) {
		for (int i = 0; i < list.size() - 1; i++) {
			
			int index = i;
			
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j) < list.get(index)) {
					index = j;
				}
			}
			
			if (list.get(i) > list.get(index)) {
				swap(list, i, index);
			}
		}
	}
	
	// 삽입 정렬
	public static void insertSort(List<Integer> list) {
		List<Integer> result = new ArrayList<>(list.size());
		
		result.add(list.get(0));
		for (int i = 1; i < list.size(); i++) {
			
			int count = 0;
			
			for (int j = 0; j < result.size(); j++) {
				if (list.get(i) < result.get(j)) {
					result.add(j, list.get(i));
					count = 1;
					break;
				}
			}
			
			if (count == 0) {
				result.add(list.get(i));
			}
		}
		
		list.clear();
		list.addAll(result);
	}
	
	
	public static void QuickSort(List<Integer> list) {
	
	}
	
	// list, index1, index2
	private static void swap(List<Integer> list, int index1, int index2) {
		
		if (list == null) {
			throw new IllegalArgumentException("list must not be null");
		}
		
		Integer temp1 = list.get(index1);
		Integer temp2 = list.get(index2);
		
		list.set(index1, temp2);
		list.set(index2, temp1);
	}
}
