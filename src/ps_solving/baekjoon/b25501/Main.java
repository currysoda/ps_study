package ps_solving.baekjoon.b25501;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class Main {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br      = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw      = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb      = new StringBuilder();
		String         newline = System.lineSeparator();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			
			boolean isSame    = true;
			int     recursive = 0;
			
			for (int j = 0; j < str.length() / 2; j++) {
				char temp1 = str.charAt(j);
				char temp2 = str.charAt(str.length() - (j + 1));
				
				if (temp1 != temp2) {
					isSame = false;
					recursive = j + 1;
					sb.append("0").append(" ").append(String.valueOf(recursive)).append(newline);
					break;
				}
			}
			
			if (isSame == true) {
				sb.append("1").append(" ").append(String.valueOf(str.length() / 2 + 1)).append(newline);
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		
		br.close();
		bw.close();
	}
}
