package algorithm.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	
	public static void main(String[] args) {
		
		List<Integer> list = generatedList(20);
		
		System.out.println("list = " + list);
		
		SortSet.quickSort(list);
		
		System.out.println("list = " + list);
		
		
	}
	
	// quantity의 수 만큼 1 ~ 100 사이의 자연수를 랜덤으로 가지고 있는 List 반환해준다.
	public static List<Integer> generatedList(int quantity) {
		List<Integer> list   = new ArrayList<>();
		Random        random = new Random();
		for (int i = 0; i < quantity; i++) {
			int temp = random.nextInt(100);
			list.add(temp);
		}
		
		return list;
	}
}
