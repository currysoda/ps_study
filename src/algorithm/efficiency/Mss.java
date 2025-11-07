package algorithm.efficiency;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 최대 부분 배열 합 (maximum subarray sum)
// 시간복잡도가 O(n^3) , O(n^2) , O(n) 인 경우로 볼 수 있다.
public class Mss {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str_arr = br.readLine().split(" ");
		int[]    arr     = new int[str_arr.length];
		
		for (int i = 0; i < str_arr.length; i++)
		{
			arr[i] = Integer.parseInt(str_arr[i]);
		}
		
		System.out.println("mss(arr) = " + mss(arr));
		
		bw.close();
		br.close();
	}
	
	// O(n^3) 의 시간 복잡도
	// 길이를 1 ~ n-1 범위의 반복문을 작성하고 시작점-끝점 으로 반복함
	public static void cubed(int n) {
		
	}
	
	// O(n^2) 의 시간 복잡도
	// 길이 1 ~ n-1 범위는 그대로 사용하되 시작점-끝점에서 기존 값에 더하는 방식으로 진행
	public static void squared(int n) {
		
	}
	
	// O(n) 의 시간 복잡도
	// 카데인 알고리즘
	// Math.max(이때까지의 합, arr[i]) == 이때까지의 합이 음수면 버리고 새로 시작
	public static int mss(int[] arr) {
		
		int max = 0;
		
		for (int i = 0; i < arr.length; i++)
		{
			if (max <= 0 && arr[i] < 0)
			{
				max = 0;
			}
			else
			{
				max += arr[i];
			}
		}
		
		return max;
	}
}
