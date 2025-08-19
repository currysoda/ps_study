package ps_solving.baekjoon.b2108;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 백준 2108번: 통계 문제 해결
 * 
 * 주어진 N개의 수에 대해 다음 4가지 통계값을 계산하는 프로그램입니다:
 * 1. 산술평균: 모든 수의 합을 개수로 나눈 값 (소수점 이하 첫째 자리에서 반올림)
 * 2. 중앙값: 수를 크기 순으로 정렬했을 때 가장 가운데 있는 값
 * 3. 최빈값: 가장 자주 나타나는 값 (여러 개인 경우 두 번째로 작은 값)
 * 4. 범위: 최댓값과 최솟값의 차이
 * 
 * 접근 방법:
 * - try-with-resources를 사용한 안전한 자원 관리
 * - 각 통계값을 별도 메서드로 분리하여 가독성과 유지보수성 향상
 * - HashMap을 활용한 효율적인 빈도수 계산
 * - Stream API를 활용한 함수형 프로그래밍 스타일 적용
 * 
 * 시간복잡도: O(N log N) - 정렬로 인한 복잡도
 * 공간복잡도: O(N) - 입력 데이터 저장 및 빈도수 맵
 * 
 * @author ps_study
 * @since 2024
 */
public class Main {
	
	/**
	 * 프로그램의 메인 진입점
	 * 표준 입력에서 N개의 정수를 읽어 4가지 통계값을 계산하고 출력합니다.
	 * 
	 * @param args 명령행 인수 (사용하지 않음)
	 * @throws IOException 입출력 오류 발생 시
	 */
	public static void main(String[] args) throws IOException {
		// try-with-resources를 사용한 자원 관리
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		     BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			
			int N = Integer.parseInt(br.readLine());
			List<Integer> numbers = new ArrayList<>(N);
			
			// 입력 처리
			for (int i = 0; i < N; i++) {
				numbers.add(Integer.parseInt(br.readLine()));
			}
			
			// 통계값 계산
			int average = calculateAverage(numbers);
			int median = calculateMedian(numbers);
			int mode = calculateMode(numbers);
			int range = calculateRange(numbers);
			
			// 결과 출력
			bw.write(String.format("%d%n%d%n%d%n%d%n", average, median, mode, range));
			bw.flush();
		}
	}
	
	/**
	 * 주어진 숫자 리스트의 산술평균을 계산합니다.
	 * 
	 * 수학적 배경:
	 * - 산술평균 = (모든 수의 합) / (수의 개수)
	 * - 소수점 이하 첫째 자리에서 반올림 (Math.round 사용)
	 * 
	 * 구현 세부사항:
	 * - Stream API의 mapToInt와 average() 메서드 활용
	 * - OptionalDouble의 orElse로 안전한 기본값 처리
	 * 
	 * @param numbers 평균을 구할 정수 리스트
	 * @return 반올림된 산술평균 값
	 */
	private static int calculateAverage(List<Integer> numbers) {
		// Stream API를 활용한 함수형 프로그래밍 스타일
		return (int) Math.round(numbers.stream()
				.mapToInt(Integer::intValue)
				.average()
				.orElse(0.0));
	}
	
	/**
	 * 주어진 숫자 리스트의 중앙값을 계산합니다.
	 * 
	 * 수학적 배경:
	 * - 중앙값(median): 데이터를 크기 순으로 정렬했을 때 가운데 위치하는 값
	 * - N이 홀수인 경우: (N+1)/2 번째 값
	 * - 문제 조건상 N은 항상 홀수이므로 N/2 인덱스의 값이 중앙값
	 * 
	 * 알고리즘:
	 * 1. 리스트를 복사하여 원본 데이터 보존
	 * 2. 복사본을 오름차순 정렬
	 * 3. 중간 인덱스(size/2)의 값 반환
	 * 
	 * 시간복잡도: O(N log N) - 정렬 연산
	 * 
	 * @param numbers 중앙값을 구할 정수 리스트
	 * @return 중앙값
	 */
	private static int calculateMedian(List<Integer> numbers) {
		List<Integer> sorted = new ArrayList<>(numbers);
		Collections.sort(sorted);
		return sorted.get(sorted.size() / 2);
	}
	
	/**
	 * 주어진 숫자 리스트의 최빈값을 계산합니다.
	 * 
	 * 수학적 배경:
	 * - 최빈값(mode): 데이터에서 가장 자주 나타나는 값
	 * - 최빈값이 여러 개인 경우, 두 번째로 작은 값을 선택 (문제 조건)
	 * 
	 * 알고리즘:
	 * 1. Stream API의 groupingBy를 사용하여 각 숫자의 출현 빈도 계산
	 * 2. 최대 빈도수 찾기
	 * 3. 최대 빈도수를 가진 모든 숫자를 후보로 수집
	 * 4. 후보들을 오름차순 정렬
	 * 5. 후보가 2개 이상이면 두 번째 값, 1개면 첫 번째 값 반환
	 * 
	 * 구현 세부사항:
	 * - Stream API의 groupingBy와 counting() 활용
	 * - 함수형 스타일로 가독성 있는 코드 구현
	 * 
	 * 시간복잡도: O(N + K log K), K는 서로 다른 숫자의 개수
	 * 
	 * @param numbers 최빈값을 구할 정수 리스트
	 * @return 최빈값 (여러 개인 경우 두 번째로 작은 값)
	 */
	private static int calculateMode(List<Integer> numbers) {
		// Stream API를 활용한 빈도수 계산 및 그룹핑
		Map<Integer, Long> frequencyMap = numbers.stream()
				.collect(Collectors.groupingBy(
						Function.identity(),
						Collectors.counting()));
		
		// 최대 빈도수 찾기
		long maxFrequency = frequencyMap.values().stream()
				.mapToLong(Long::longValue)
				.max()
				.orElse(0L);
		
		// 최빈값 후보들 추출 및 정렬
		List<Integer> modeCandidates = frequencyMap.entrySet().stream()
				.filter(entry -> entry.getValue() == maxFrequency)
				.map(Map.Entry::getKey)
				.sorted()
				.collect(Collectors.toList());
		
		return modeCandidates.size() > 1 ? modeCandidates.get(1) : modeCandidates.get(0);
	}
	
	/**
	 * 주어진 숫자 리스트의 범위(range)를 계산합니다.
	 * 
	 * 수학적 배경:
	 * - 범위 = 최댓값 - 최솟값
	 * - 데이터의 산포도를 나타내는 기초 통계량
	 * 
	 * 구현 세부사항:
	 * - Stream API의 mapToInt().max/min() 활용
	 * - 한 번의 스트림 연산으로 최댓값과 최솟값을 각각 계산
	 * 
	 * 시간복잡도: O(N) - 리스트 전체 순회 (2회)
	 * 
	 * @param numbers 범위를 구할 정수 리스트
	 * @return 최댓값과 최솟값의 차이
	 */
	private static int calculateRange(List<Integer> numbers) {
		// Stream API를 활용한 최댓값과 최솟값 계산
		int max = numbers.stream().mapToInt(Integer::intValue).max().orElse(0);
		int min = numbers.stream().mapToInt(Integer::intValue).min().orElse(0);
		return max - min;
	}
}