package algorithm.sort;

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
	
	// 퀵 정렬
	public static void quickSort(List<Integer> list) {
		if (list == null || list.size() < 2) {
			return;
		}
		quickSortRecursive(list, 0, list.size() - 1);
	}
	
	public static void quickSortRecursive(List<Integer> list, int low, int high) {
		
		if (low >= high) {
			return;
		}
		
		int pivot = partition(list, low, high);
		quickSortRecursive(list, low, pivot);
		quickSortRecursive(list, pivot + 1, high);
		
	}
	
	public static int partition(List<Integer> list, int low, int high) {
		
		int pivot = list.get((low + high) / 2);
		int i     = low - 1;
		int j     = high + 1;
		
		while (true) {
			
			do {
				i++;
			} while (list.get(i) < pivot);
			do {
				j--;
			} while (list.get(j) > pivot);
			
			// 교차되면 리턴하기
			if (i >= j) {
				
				
				return j;
			}
			
			swap(list, i, j);
		}
	}
	
	// 병합 정렬
	public static void mergeSort(List<Integer> list) {
		
		if (list == null || list.size() < 2) {
			return;
		}
		Integer[] arr = new Integer[list.size()];
		merge(list, arr, 0, list.size());
	}
	
	public static void merge(List<Integer> list, Integer[] arr, int left, int right) {
		
		if ((right - left) <= 1) {
			return;
		}
		
		int mid = (left + right) / 2;
		
		merge(list, arr, left, mid);
		merge(list, arr, mid, right);
		
		for (int k = left; k < right; k++) {
			arr[k] = list.get(k);
		}
		
		int i          = left;
		int j          = mid;
		int save_point = left;
		
		while (i < mid && j < right) {
			list.set(save_point++, ((arr[i] <= arr[j]) ? arr[i++] : arr[j++]));
		}
		
		while (i < mid) {
			list.set(save_point++, arr[i++]);
		}
		while (j < right) {
			list.set(save_point++, arr[j++]);
		}
	}
	
	// list, index1, index2
	public static void swap(List<Integer> list, int a, int b) {
		
		int temp = list.get(a);
		list.set(a, list.get(b));
		list.set(b, temp);
	}
}
