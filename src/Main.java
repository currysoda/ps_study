import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		// Main 은 아무것도 없음
		// 주요 내용은 각 패키지에
		
		int[][] arr = new int[10][2];
		
		for (int i = 0; i < 10; i++)
		{
			arr[i][0] = i;
			arr[i][1] = i;
		}
		
		Arrays.sort(arr, (a, b) -> b[0] - a[0]);
		
		for (int i = 0; i < 10; i++)
		{
			System.out.println("i = " + i + " / arr[i][0] = " + arr[i][0] + " / arr[i][1] = " + arr[i][1]);
		}
	}
}
