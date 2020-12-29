/*  �˰��� 12����  
 * 	Graph.java Main.java   
 *  �ۼ��� : 2020.11.19, 21
 *  �ۼ��� : 20165153 ���缺
 * 	���α׷� ���� : �׷����� ���� ������ ��Ÿ�� ���α׷�
 */

package Graph;

import java.util.*;

public class Graph {								
	private Queue<Integer>[] Q;					// ������ ���� ���� �ļ��ڸ� �����ϴ� ť �迭 Q
	private Queue<Integer> ZeroPredQ; 			// �����ڰ� ���� �������� �����ϴ� ť ZeroPreQ
	private LinkedList<Integer> sortedList;		// ���� ���� ����� �����ϴ�  ���Ḯ��Ʈ sortedList  
	
	private int[] indegree;						// ������ ���������� ��Ÿ���� indegree
	private int n;								// ���� ��
	
	public Graph(int vertex) {					// ������
		n = vertex;								// �Ű����� vertex�� n �ʱ�ȭ	
		Q = new Queue[n];						// ť�� n��ŭ �ʱ�ȭ 
		ZeroPredQ = new LinkedList<Integer>();	// ZeroPredQ �ʱ�ȭ
		sortedList = new LinkedList<Integer>();	// sortedList �ʱ�ȭ
		
		for(int i = 0; i < n; i++) {			// �ݺ����� ���� Q�迭��  
			Q[i] = new LinkedList<Integer>();	// ������ ���� ����Ʈ �ʱ�ȭ
		}
		indegree = new int[n];					// indegree �迭�� n��ŭ �ʱ�ȭ
	}
	
	public void insertEdge(int head, int tail) {// �׷����� ������ �߰��ϴ� insertEdge �޼ҵ�
		Q[head].add(tail);						// ���� head�� ���� ť�� tail ���� �߰�
		indegree[tail]++;						// ���� head�� ���ؼ� indegree �迭 �� ���� 
	}
	
	public void topologicalSort() {				// ���������� �ϴ� topologicalSort �޼ҵ�
		int i,v,successor;						// �ݺ������� ����� i�� v, �����ڸ� ����Ű�� successor ���� ����  
		for( i = 0; i < n; i++) {				// �ݺ����� ���� ZeroPredQ�� ���� �߰�
			if(indegree[i] == 0 )  				// ������ ������ ���ٸ�
				ZeroPredQ.add(i);				// �� ������ ���ҷ� �߰�
		}
		
		if(ZeroPredQ.isEmpty()) {				// ZeroPredQ�� ����ִٸ� ����Ŭ�� �����Ѵ�.
			System.out.println("network has a cycle"); 	// ����Ŭ�� �����Ѵٰ� ���
			return ;							// �޼ҵ� ����
		}
		
		while(!ZeroPredQ.isEmpty()) {			// ZeroPredQ�� ������� ���� �ݺ�
			v = ZeroPredQ.remove();	// ZeroPredQ���� ���Ҹ� remove�� ���� v�� ����, indgree�� 0�� �������� ť���� �ϳ��� ������ ó�� 
												
			sortedList.add(v);		// v���� sortedList�� �߰�, ingree�� 0�� �������� ��� ����Ʈ�� ����
												 
			if(Q[v].isEmpty())		// v�� ����� ������ ������, �� ���� v�� �ļ��ڰ� ������
				continue;			// �ݺ����� �ٽ� �ݺ�
			else 								// �ļ��ڰ� ������
				successor = Q[v].remove();		// successor�� �� �ļ��ڸ� ���� 
			
			while(true) {						// ��ø, ���� �ݺ���
				indegree[successor]--;			// successor�� ���� ���� ���� ����
				if(indegree[successor] == 0)	// ���� ��Ų ���Ŀ� ���� ������ 0�̸�
					ZeroPredQ.add(successor);	// ���� successor�� ZeroPredQ�� ���ҷ� �߰�
				
				if(!Q[v].isEmpty()) 			// ���� v�� ���� Q�� ������� �ʴٸ� 
					successor = Q[v].remove();	// remove �� ���� successor�� �ʱ�ȭ
				else 
					break;						// ��������� �ݺ��� ����
				}	// ������ while �� 
		}	// �ٱ����� while
		System.out.println("Topological Order is : ");	// ����� ��� 
		while(!sortedList.isEmpty()) {			// �ݺ����� ���� ����� sortedList ���
			System.out.print(sortedList.remove() + " ");	// ���Ҹ� �ϳ��� remove �ϸ� ���
		}
		System.out.println();					// �ݺ��� ������ �ٹٲ�
		System.out.println("End.");
	}
	
}
