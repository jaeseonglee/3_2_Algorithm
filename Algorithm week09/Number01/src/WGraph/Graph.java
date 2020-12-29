package WGraph;

import java.util.*;

public class Graph {					// 인접 리스트로 나타낸 그래프를 가리키는 Vertex_graph 클래스
	private Node[] header;					// 인접리스트를 가리키는 header
	private int size;
	
	public Graph(int size) {			// 생성자
		this.header = new Node[size];		// size만큼 배열의 길이를 초기화
		this.size = size;					// size에 매개변수 size로 초기화
		
		for(int i = 0; i < size; i++) {		// 반복문을 통해 
			this.header[i] = null;			// 배열을 초기화 시켜준다
		}
	}
	
	public void add(int i, int k) {			// 그래프에 간선을 추가하는 add 메소드
		Node temp = header[i];				// 먼저 정점 i에서 간선을 연결
		
		while(true) {						// 반복문을 통해 간선 추가
			if(header[i] == null) {			// 해당 정점이 아무것도 연결하지 않은 상태라면
				header[i] = new Node(k);	// 첫번째로 연결되는 k에 대해 정점(Node) 추가
				break;						// 반복문 탈출
			}
			
			if(temp.getLink() == null) {	// 다음 정점을 가리키는 link가 null이라면
				temp.setLink(new Node(k));	// 정점(Node) 추가
				break;						// 반복문 탈출
			}
			temp = temp.getLink();			// 위의 두 조건에 대해 만족하지 않으면 다음 link로 초기화하여 탐색
		}

		temp = header[k];					// 무방향 그래프이므로 k에 대해서도 간선을 연결
		while(true) {
			if(header[k] == null) {			// 마찬가지로 정점 k도 아무것도 연결되지 않았다면
				header[k] = new Node(i);	// i를 첫번째로 연결시켜주고
				break;						// 반복문 탈출
			}
			
			if(temp.getLink() == null) {	// 다음 정점을 가리키는 link가 null이면
				temp.setLink(new Node(i));	// i에 대해서 정점(Node) 추가
				break;						// 반복문 탈출
			}
			temp = temp.getLink();			// 위의 두 조건에 대해 만족하지 않으면 다음 link로 초기화하여 탐색
		}	
	}
	
	public void delete(int i, int k) {					// 간선을 삭제하는 delete 메소드
		if(header[i] == null || header[k] == null) {	// 매개변수 중에 아무것도 연결되지 않은 정점이라면
			System.out.println("This is fault delete");	// 간선 삭제에 오류 발생
			return ;									// 메소드 종료
		}
		
		Node curNode = header[i];						// 정점 i의 현재 노드를 가리키는 curNode
		Node nextNode = header[i].getLink();			// i의 다음 노드를 가리키는 nextNode

		while(curNode != null) {						// 현재 노드가 null이 아니라면 반복
			if(curNode.getVertex() == k) {				// 현재 노드의 정점이 k와 같다면
				curNode.setVertex(nextNode.getVertex());// 간선을 삭제하기 위해 k의 노드에 대해 연결 리스트 삭제하고
				curNode.setLink(nextNode.getLink());	// 그 다음 노드에 연결 시켜줌으로써 삭제 완료
				break;									// 반복문 탈출
			}
			curNode = nextNode;							// 조건문에 해당하지 않는다면 현재 노드를 다음 노드로 초기화
			nextNode = nextNode.getLink();				// 다음노드는 그 다음노드에 대해 초기화하고 반복
		}
		
		curNode = header[k];							// 무방향 그래프 이므로 k에 대해서도 삭제를 진행
		nextNode = header[k].getLink();					// k에 대한 노드와 그 다음 노드를 각각 curNode와 nextNode에 대해 초기화

		while(curNode != null) {						// 마찬가지로 현재 노드가 null이 아니라면 반복
			if(curNode.getVertex() == i) {				// 현재 노드의 정점이 i와 같다면
				curNode.setVertex(nextNode.getVertex());// 간선을 삭제하기 위해 i에 대한 노드를 연결 리스트에서 삭제  
				curNode.setLink(nextNode.getLink());	// 그 다음 노드로 연결해주어 삭제 완료
				break;									// 반복문 탈출
			}
			curNode = nextNode;							// 조건문에 해당하지 않는다면 현재 노드를 다음 노드로 초기화
			nextNode = nextNode.getLink();				// 다음노드는 그 다음노드에 대해 초기화하고 반복
		}
	}
	
	public void show() {								// 그래프의 내용을 출력하는 show 메소드
		if(size == 0) {									// size가 0이면 
			System.out.println("No Vertex");			// 아무 그래프도 그려지지 않았으니 No Vertex 출력
		}
		
		for(int i = 0; i < size; i++) {					// 중첩 반복문을 통해 그래프 출력. size가 0이면 자동으로 반복하지 않음
			Node temp = header[i];						// temp에 각 정점에 대한 배열값을 저장하고
			
			System.out.print(i + " : ");				// 각 정점에 대해 출력				
			while(temp != null) {						// 반복문을 통해 연결 리스트의 내용 출력
				System.out.print(temp.getVertex() + " ");	// 현재 정점을 출력하고
				temp = temp.getLink();					// 다음 link로 초기화하고 반복
			}
			System.out.println();						// 각 정점에 대한 간선 출력이 끝나면 줄바꿈
		}
	}
	
	
	// 9주차 DFS, BFS 
	public void DFS(int i) {							// 깊이 우선 탐색(DFS) 메소드, 스택을 이용하여 탐색한다.
		boolean[] visit = new boolean[header.length];	// 방문을 확인하는 visit
		int j;											// 반복문에서 정점을 가리킬 변수 j
		
		for(j = 0; j < header.length; j++) {			// 반복문을 통해
			visit[j] = false;							// visit 배열을 false로 초기화
		}
		
		Stack<Integer> stack = new Stack<Integer>();	// Integer형 스택을 선언 및 초기화
		stack.push(i);									// 스택에 매개변수 i를 push해준다.
		
		while(!stack.isEmpty()) {						// 스택이 공백일 때 까지 반복
			j = stack.pop();							// 스택에서 pop한 값을 j에 저장 
			Node node = header[j];						// j정점의 인접리스트를 node로 저장
			
			if(visit[j] == false) {						// 현재 j의 정점을 방문하지 않았다면
				System.out.print(j + " ");				// j 출력
				visit[j] = true;						// j는 방문했으므로 true
				while(node != null) {					// 다시 반복문을 통해 스택을 계산한다. 
					if(visit[node.getVertex()] == false)// 방문하지 않은 정점이 있으면
						stack.push(node.getVertex());	// 스택에 그 정점을 push
					node = node.getLink();				// node 다음에 가리키는 Node를 node에 저장
				}
			}
		}
	}
		
	public void BFS(int i) {							// 큐를 사용하는 너비 우선 탐색(BFS) 메소드
		boolean[] visit = new boolean[header.length];	// 방문을 확인하는 visit 
		int idx;										
		
		for(int j = 0; j < header.length; j++) {		//반복문을 통해
			visit[j] = false;							// visit 배열을 false로 초기화
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();	// Integer형 큐 선언 및 초기화
		queue.add(i);									// 큐에 매개변수 i를 추가해준다 
		
		while(!queue.isEmpty()) {						// 큐가 공백일 때까지 반복
			idx = queue.remove();						// 큐에서 remove 해준 값을 idx에 저장
			Node node = header[idx];					// j정점의 인접리스트를 node로 저장
			
			if(visit[idx] == false) {					// 현재 idx의 정점을 방문하지 않았다면
				System.out.print(idx + " ");			// idx 출력
				visit[idx] = true;						// idx는 방문 했으므로 true
			}
			
			while( node != null) {						// 반복문을 통해 큐를 계산한다.
				if(visit[node.getVertex()] == false) 	// 방문하지 않은 정점이 있으면
					queue.add(node.getVertex());		// 큐에 그 정점을 추가해준다
				node = node.getLink();					// node 다음에 가리키는 Node를 node에 저장
			}
		}
	}

}