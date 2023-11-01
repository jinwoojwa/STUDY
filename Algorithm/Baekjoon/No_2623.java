/* https://www.acmicpc.net/problem/2623
 * 
 * 백준 2623번 : 음악프로그램
 * 
 * 가수들의 출연 순서를 결정하는 문제로 위상 정렬 문제에 해당한다고 할 수 있다.
 * DAG를 위상정렬하여 만든 결과 리스트의 크기는 DAG의 크기와 같아야 한다.
 * 만약 사이클이 생긴다면 순서를 정하지 못하게 된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_2623 {
	
	static int singer;
	static int[] in_degree;
	static ArrayList<Integer> result;
	static ArrayList<ArrayList<Integer>> sequence = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		singer = Integer.parseInt(st.nextToken());
		int pd = Integer.parseInt(st.nextToken());
		
		in_degree = new int[singer + 1];
		result = new ArrayList<>();
		
		for (int i = 0; i <= singer; i++) {
			sequence.add(new ArrayList<>());
		}
		
		// pd 들이 정한 순서들
		for (int i = 0; i < pd; i++) {
			String[] str = br.readLine().split(" ");
			
			// 첫번째 숫자는 pd가 담당한 가수들의 수
			int singer_num = Integer.parseInt(str[0]);
			
			// 1 4 3 이라고 했을 때, 1 -> 4 이며, 4 -> 3이다. j 값을 2부터 변화시켜 한 줄로 주어진 순서를
			// 인접 연결 리스트에 담고, in_degree 를 갱신한다.
			for (int j = 2; j < singer_num + 1; j++) {
				int pre = Integer.parseInt(str[j-1]);
				int next = Integer.parseInt(str[j]);
				
				sequence.get(pre).add(next);
				in_degree[next]++;
			}
		}
		topologicalSort();
		
		// 결과 배열의 크기가 가수의 수와 같지 않을 때 순서를 정하는 것이 불가능한 것이므로 0을 출력
		if (result.size() != singer) {
			System.out.println(0);
		}
		else {
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
		}
	}
	static void topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= singer; i++) {
			if (in_degree[i] == 0) {
				q.offer(i);
			}
		}
		
		while (!q.isEmpty()) {
			int temp = q.poll();
			result.add(temp);
			
			for (int i : sequence.get(temp)) {
				if (--in_degree[i] == 0) {
					q.offer(i);
				}
			}
		}
	}
}
