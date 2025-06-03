package tips;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 자바로 PS 할 때 입출력하기
public class IOinJAVA {
	
	/**
	 * java.io.* 클래스를 이용한 자바 입출력
	 * newline 으로 String 단위로 입력받으며 줄바꿈 문자를 만날때까지 한줄씩 읽는다.
	 * BufferedWriter 를 이용하면 flush() 를 호출해야 내용을 마지막까지 출력한다.(내용 중 일부만 출력될 수 있음)
	 * BufferedWriter 를 이용하면 System.out.println() 을 이용하는 것보다 출력에 드는 시간을 줄일 수 있다.
	 * String 인스턴스를 만드는 것또한 시간공간적 비용이 많이 드는데 StringBuilder 를 이용하면 줄일 수 있다.
	 * java.util.Scanner 클래스를 이용한 자바 입출력은 java.io.* 을 이용하는 것보다 입출력에 드는 비용이 크다.
	 * Scanner 는 nextInt() 등으로 자료형에 맞게 입출력하기 편하다.
	 * nextInt() nextLong() 이후 줄바꿈 문자가 있다면 nextLine() 을 호출해서 줄바꿈 문자를 비워야 이후 오는 문자열이 정상적으로 입력된다.
	 */
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder  sb = new StringBuilder();
		
		String str     = "";
		String newline = System.lineSeparator();
		
		while ((str = br.readLine()) != null) {
			sb.append(str).append(newline);
		}
		
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
		
		// 예시용 Scanner 클래스로 윗 부분을 주석처리해야 정상 작동함
		Scanner sc = new Scanner(System.in);
		
		int i = 0;
		
		i = sc.nextInt();
		System.out.println("i = " + i);
		str = sc.nextLine();
		System.out.println("str = " + str);
		str = sc.nextLine();
		System.out.println("str = " + str);
		
		sc.close();
	}
	
}
