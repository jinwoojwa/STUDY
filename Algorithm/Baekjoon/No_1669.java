/* https://www.acmicpc.net/problem/1669
 * 
 * 입력으로 주어지는 원숭이와 멍멍이의 키는 0 <= monkeyHeight <= dogHeight <= 2^31 을 만족  --> int 로 선언
 * 원숭이의 키를 늘릴 수 있는 조건은 1씩 증감시키거나 유지.
 * 즉, 12321이나 123321과 같이 가능함. (124311 같은 경우 X)
 * 
 * N을 제곱근이라고 하면,		N		  N = 1		와 같은 형태로 생각할 수 있음.
 * 					  1 N 1		  N = 2
 * 					1 2 N 2 1	  N = 3
 * 				  1 2 3 N 3 2 1   N = 4
 * 
 * 키의 차이가 제곱수라면 2^N - 1 일이 걸리며 제곱수 사이의 값들은 제곱수까지 걸리는 날짜 + 적절한 날짜가 된다.
 * ex) diff = 14 라면 N = 3이 되며 (N=4이면 diff < 16 이 되버림) 5일 동안의 늘릴 수 있는 키 9를 빼주면 14 - 9 = 5
 * 	   5일을 3 + 2 로 분배하여 빼주면 (빼주는 숫자는 N보다 작거나 같아야 함) 총 날짜는 5 + 1 + 1 = 7  
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No_1669 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int monkeyHeight = Integer.parseInt(st.nextToken());
		int dogHeight = Integer.parseInt(st.nextToken());
		br.close();
		
		int diff = dogHeight - monkeyHeight;
		long n = 0, result = 0;
		
		if (diff == 0) {             // 둘의 키가 같은 경우 바로 출력.
			System.out.println(0);
			return;
		}
		
		while (n * n < diff) {       // 제곱근을 구해준다.
			n++;
		}
		if (n * n != diff) {         // diff가 제곱수가 아니면 n의 제곱이 diff보다 커지기 때문에 1을 감소시킨다.
			n--;
		}
		
		result += 2 * n - 1;
		diff -= n * n;
		
		while (diff > 0) {
			diff -= Math.min(diff, n);
			result++;
		}
		System.out.println(result);
	}
}
