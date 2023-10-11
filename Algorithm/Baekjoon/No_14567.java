/* https://www.acmicpc.net/problem/14567
 * 
 * 백준 14567번 : 선수과목 (Prerequisite)
 * 
 * 위상정렬 : 비순환 방향 그래프(DAG) 에서 정점들을 방향성을 거스르지 않고 순서대로 배열하는 것
 * 선수 과목은 방향성을 가지고 있으며(ex: A를 배워야 B를 배울 수 있음), 사이클을 가지지 않는다.(ex: A -> B -> C -> A 같은 형태는 없음) (A < B인 입력만 주어진다.)	
 * 따라서 이 문제는 위상정렬 알고리즘을 사용하여 풀 수 있다.
 * 
 * 진입 차수가 0인 과목을 먼저 Queue에 넣고 하나씩 빼면서 간선들을 제거, 진입 차수를 감소시킴.
 * -> 감소시킨 진입 차수가 0이 된다면, 해당 과목을 Queue에 넣고 다시 반복.
 * -> Queue가 모두 비어있을 때까지 반복한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No_14567 {
	
	static int numOfSubject;
	static int numOfCondition;
	static ArrayList<ArrayList<Integer>> subject = new ArrayList<>();
	static int[] in_degree;
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		numOfSubject = Integer.parseInt(st.nextToken());
		numOfCondition = Integer.parseInt(st.nextToken());
		
		// 진입 차수, 결과 배열의 크기를 과목의 수 + 1로 초기화
		in_degree = new int[numOfSubject + 1];
		result = new int[numOfSubject + 1];
		
		// 과목의 수만큼 ArrayList subject를 초기화
		for (int i = 0; i <= numOfSubject; i++) {
			subject.add(new ArrayList<>());
		}
		
		// 조건의 수만큼 입력을 받아 선수과목조건을 subject에 저장하고 진입차수를 증가시킨다.
		for (int i = 0; i < numOfCondition; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			subject.get(A).add(B);
			in_degree[B]++;
		}
		
		topologicalSort();
		
		for (int i = 1; i <= numOfSubject; i++) {
			System.out.print(result[i] + " ");
		}
	}
	
	static void topologicalSort() {
		Queue<Integer> q = new LinkedList<>();
		
		// 진입 차수가 0인 과목은 선수 과목이 없는 것이므로 결과 배열을 1로 초기화시키고 큐에 삽입.
		for (int i = 1; i <= numOfSubject; i++) {
			if (in_degree[i] == 0) {
				result[i] = 1;
				q.offer(i);
			}
		}
		
		while (!q.isEmpty()) {
			int temp = q.poll();
			
			for (int i : subject.get(temp)) {
				if (--in_degree[i] == 0) {
					q.offer(i);
					result[i] = result[temp] + 1;
				}
			}
		}
	}
}
