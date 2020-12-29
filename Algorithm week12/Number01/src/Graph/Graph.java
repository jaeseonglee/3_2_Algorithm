/*  알고리즘 12주차  
 * 	Graph.java Main.java   
 *  작성일 : 2020.11.19, 21
 *  작성자 : 20165153 이재성
 * 	프로그램 설명 : 그래프를 위상 정렬을 나타낸 프로그램
 */

package Graph;

import java.util.*;

public class Graph {								
	private Queue<Integer>[] Q;					// 정점에 대한 직속 후속자를 저장하는 큐 배열 Q
	private Queue<Integer> ZeroPredQ; 			// 선행자가 없는 정점들을 저장하는 큐 ZeroPreQ
	private LinkedList<Integer> sortedList;		// 위상 정렬 결과를 보관하는  연결리스트 sortedList  
	
	private int[] indegree;						// 정점의 진입차수를 나타내는 indegree
	private int n;								// 정점 수
	
	public Graph(int vertex) {					// 생성자
		n = vertex;								// 매개변수 vertex로 n 초기화	
		Q = new Queue[n];						// 큐를 n만큼 초기화 
		ZeroPredQ = new LinkedList<Integer>();	// ZeroPredQ 초기화
		sortedList = new LinkedList<Integer>();	// sortedList 초기화
		
		for(int i = 0; i < n; i++) {			// 반복문을 통해 Q배열을  
			Q[i] = new LinkedList<Integer>();	// 각각의 연결 리스트 초기화
		}
		indegree = new int[n];					// indegree 배열도 n만큼 초기화
	}
	
	public void insertEdge(int head, int tail) {// 그래프의 간선을 추가하는 insertEdge 메소드
		Q[head].add(tail);						// 정점 head에 대한 큐에 tail 원소 추가
		indegree[tail]++;						// 같이 head에 대해서 indegree 배열 값 증가 
	}
	
	public void topologicalSort() {				// 위상정렬을 하는 topologicalSort 메소드
		int i,v,successor;						// 반복문에서 사용할 i와 v, 선행자를 가리키는 successor 변수 선언  
		for( i = 0; i < n; i++) {				// 반복문을 통해 ZeroPredQ에 원소 추가
			if(indegree[i] == 0 )  				// 정점의 선행자 없다면
				ZeroPredQ.add(i);				// 그 정점을 원소로 추가
		}
		
		if(ZeroPredQ.isEmpty()) {				// ZeroPredQ이 비어있다면 사이클이 존재한다.
			System.out.println("network has a cycle"); 	// 사이클이 존재한다고 출력
			return ;							// 메소드 종료
		}
		
		while(!ZeroPredQ.isEmpty()) {			// ZeroPredQ이 비어질때 까지 반복
			v = ZeroPredQ.remove();	// ZeroPredQ에서 원소를 remove한 값을 v에 저장, indgree가 0인 정점들을 큐에서 하나씩 삭제해 처리 
												
			sortedList.add(v);		// v값을 sortedList에 추가, ingree가 0인 정점들을 결과 리스트에 삽입
												 
			if(Q[v].isEmpty())		// v에 연결된 간선이 없으면, 즉 정점 v의 후속자가 없으면
				continue;			// 반복문을 다시 반복
			else 								// 후속자가 있으면
				successor = Q[v].remove();		// successor에 그 후속자를 저장 
			
			while(true) {						// 중첩, 무한 반복문
				indegree[successor]--;			// successor에 대한 진입 차수 감소
				if(indegree[successor] == 0)	// 감소 시킨 이후에 진입 차수가 0이면
					ZeroPredQ.add(successor);	// 정점 successor을 ZeroPredQ에 원소로 추가
				
				if(!Q[v].isEmpty()) 			// 정점 v에 대한 Q가 비어있지 않다면 
					successor = Q[v].remove();	// remove 한 값을 successor에 초기화
				else 
					break;						// 비어있으면 반복문 종료
				}	// 안쪽의 while 문 
		}	// 바깥쪽의 while
		System.out.println("Topological Order is : ");	// 결과를 출력 
		while(!sortedList.isEmpty()) {			// 반복문을 통해 저장된 sortedList 출력
			System.out.print(sortedList.remove() + " ");	// 원소를 하나씩 remove 하며 출력
		}
		System.out.println();					// 반복이 끝나면 줄바꿈
		System.out.println("End.");
	}
	
}
