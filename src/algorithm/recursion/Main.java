package algorithm.recursion;

public class Main {
	
	public static void main(String[] args) {
		
		recursive(3);
	}
	
	public static void recursive(int n) {
		if (n <= 0)
		{
			return;
		}
		
		System.out.println("재귀 호출 전 n = " + n);
		recursive(n - 1);
		System.out.println("재귀 호출 후 n = " + n);
	}
}
