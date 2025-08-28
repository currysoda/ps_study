package ps_solving.baekjoon.b24060;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	private static int   count  = 0;
	private static int   answer = -1;
	private static int[] cash;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String   str     = br.readLine();
		String[] str_arr = str.split(" ");
		
		int N = Integer.parseInt(str_arr[0]);
		int K = Integer.parseInt(str_arr[1]);
		
		//		System.out.println(" ");
		//		System.out.println("N = " + N);
		//		System.out.println("K = " + K);
		
		
		str = br.readLine();
		str_arr = str.split(" ");
		
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(str_arr[i]);
		}
		
		cash = new int[arr.length];
		merge_sort(arr, 0, arr.length - 1, K);
		
		if (N == 1 && K == 1) {
			answer = arr[0];
		}
		
		bw.write(String.valueOf(answer));
		bw.newLine();
		bw.flush();
		
		br.close();
		bw.close();
	}
	
	// arr[p..r]을 오름차순 정렬
	public static void merge_sort(int[] arr, int p, int r, int K) {
		if (p < r) {
			int q = (p + r) / 2;          // 중간점
			merge_sort(arr, p, q, K);     // 전반부 [p..q]
			merge_sort(arr, q + 1, r, K); // 후반부 [q+1..r]
			merge(arr, p, q, r, K);       // 병합
		}
	}
	
	// arr[p..q] 와 arr[q+1..r]을 병합
	public static void merge(int[] arr, int p, int q, int r, int K) {
		int i = p;
		int j = q + 1;
		int t = 0;
		
		// 병합 결과를 cash[0..]에 담기
		while (i <= q && j <= r) {
			if (arr[i] <= arr[j]) {
				cash[t++] = arr[i++];
			}
			else {
				cash[t++] = arr[j++];
			}
		}
		while (i <= q) {
			cash[t++] = arr[i++];
		}
		while (j <= r) {
			cash[t++] = arr[j++];
		}
		
		// 다시 arr[p..r]에 덮어쓰기 (저장될 때마다 count 증가)
		i = p;
		int k = 0;
		while (i <= r) {
			arr[i] = cash[k++];
			if (++count == K) {
				answer = arr[i];
			}
			i++;
		}
	}
}
