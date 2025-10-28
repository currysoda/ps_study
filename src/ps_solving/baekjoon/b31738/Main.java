package ps_solving.baekjoon.b31738;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] s_arr = br.readLine().split(" ");
		
		long N = Long.parseLong(s_arr[0]);
		long M = Long.parseLong(s_arr[1]);
		
		long answer = 0L;
		
		if (N >= M)
		{
			answer = 0L;
		}
		else
		{
			long store = 1L;
			for (long i = 1L; i <= N; i++)
			{
				store *= i;
				store %= M;
				
				if (store == 0)
				{
					break;
				}
			}
			answer = store;
		}
		
		bw.write(String.valueOf(answer));
		bw.flush();
		
		br.close();
		bw.close();
	}
}
