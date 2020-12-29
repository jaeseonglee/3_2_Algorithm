package WGraph;

public class Edge {					// ������ ��Ÿ���� edge
	private int start, end, weight; // ���۵Ǵ� ���� start, ������ ���� end, ����ġ weight
	
	public Edge(int start, int end, int weight) {	// Edge ������
		this.start = start;							// �Ű�������� ���� �ʱ�ȭ
		this.end = end;
		this.weight = weight;
	}
	
	public int compareTo(Edge value) {				// ����ġ ���� ���ϴ� compareTo �޼ҵ� 
		return this.weight - value.weight;			// �Ű����� value�� ����ġ�� ���� ��ȯ�Ѵ�
	}
	
	public int getStart() {							// start getter
		return start;								// start ��ȯ
	}
	
	public void setStart(int start) {				// start setter
		this.start = start;							// �Ű����� ������ start �ʱ�ȭ
	}
	
	public int getEnd() {							// end getter
		return end;									// end ��ȯ
	}
	
	public void setEnd(int end) {					// end setter
		this.end = end;								// �Ű����� ������ end �ʱ�ȭ
	}
	
	public int getWeight() {						// weight getter
		return weight;								// weight ��ȯ
	}
	
	public void setWeight(int weight) {				// weight setter
		this.weight = weight;						// weight ��ȯ
	}
}
