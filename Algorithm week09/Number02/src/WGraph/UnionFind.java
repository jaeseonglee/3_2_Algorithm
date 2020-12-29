/*  알고리즘 9주차 가중치 그래프
 * 	Edge.java, UnionFind.java, MinHeap.java, Node.java, WGraph.java, Main.java   
 *  작성일 : 2020.10.29~30, 11.1, 5~6
 *  작성자 : 20165153 이재성
 * 	프로그램 설명 : Kruscal 알고리즘을 확인하는 프로그램
 */
package WGraph;

public class UnionFind {						// UnionFind 클래스
	int [] parent;								// int형 배열 parent
	
	public UnionFind(int n) {					// UnionFind 생성자
		parent = new int[n];					// 매개변수 n만큼 초기화
		for(int i = 0; i < n; i++) {			// 반복문을 통해
			parent[i] = i;						// 각 인덱스는 인덱스의 값으로 초기화
		}
	}
	
	private int root(int i) {					// 정점이 다른 정점에 연결되어 있는지 확인하는 root 메소드
		while(i != parent[i]) {					// parent 배열의 i 인덱스가 그 인덱스의 값이 아니면, 즉 간선으로 연결되어 있으면
			parent[i] = parent[parent[i]];		// 다시 각 인덱스(정점)의 값으로 초기화
			i = parent[i];						
		}	
		return i;								// i 반환
	}
	
	public boolean find(int p, int q) {			// 매개변수 두 변수(정점)이 간선으로 연결되어 있는지 확인하는 find 메소드
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {			// 두 매개변수를 묶어주는 union 
		int i = root(p);						// 각 매개변수 root를 통해  
		int j = root(q);						// 결과를 i,j에 저장
		parent[i] = j;							// 정점 i는 j로 간선을 추가해준다.
	}	
}