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
	
	
	public static void quickSort(List<Integer> list) {
		quickSortRecursive(list, 0, list.size() - 1);
	}
	
	private static void quickSortRecursive(List<Integer> list, int low, int high) {
		
		if (low < high) {
			int pivotIndex = partition(list, low, high);
			quickSortRecursive(list, low, pivotIndex);
			quickSortRecursive(list, pivotIndex + 1, high);
		}
	}
	
	
	private static int partition(List<Integer> list, int low, int high) {
		int pivot = list.get((low + high) / 2);  // 피벗: 중간값
		int i     = low - 1;
		int j     = high + 1;
		
		while (true) {
			// 왼쪽부터 피벗보다 큰 값 찾을 때까지 오른쪽으로 이동
			do {
				i++;
			} while (list.get(i) < pivot);
			
			// 오른쪽부터 피벗보다 작은 값 찾을 때까지 왼쪽으로 이동
			do {
				j--;
			} while (list.get(j) > pivot);
			
			// 포인터가 교차되면 분할 종료
			if (i >= j) {
				return j;
			}
			
			// 찾은 두 값을 서로 교환
			swap(list, i, j);
		}
	}
	
	
	public static void mergeSort(List<Integer> list) {
		if (list.size() < 2) {
			return;
		}
		
		int mid = list.size() / 2;
		
		List<Integer> left  = new ArrayList<>(list.subList(0, mid));
		List<Integer> right = new ArrayList<>(list.subList(mid, list.size()));
		
		mergeSort(left);
		mergeSort(right);
		
		merge(list, left, right);
	}
	
	private static void merge(List<Integer> list, List<Integer> left, List<Integer> right) {
		int i = 0, j = 0, k = 0;
		
		while (i < left.size() && j < right.size()) {
			if (left.get(i) <= right.get(j)) {
				list.set(k++, left.get(i++));
			}
			else {
				list.set(k++, right.get(j++));
			}
		}
		
		while (i < left.size()) {
			list.set(k++, left.get(i++));
		}
		while (j < right.size()) {
			list.set(k++, right.get(j++));
		}
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
