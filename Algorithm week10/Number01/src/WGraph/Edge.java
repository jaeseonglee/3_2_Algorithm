package WGraph;

public class Edge {					// 간선을 나타내는 edge
	private int start, end, weight; // 시작되는 정점 start, 끝나는 정점 end, 가중치 weight
	
	public Edge(int start, int end, int weight) {	// Edge 생성자
		this.start = start;							// 매개변수들로 각각 초기화
		this.end = end;
		this.weight = weight;
	}
	
	public int compareTo(Edge value) {				// 가중치 값을 비교하는 compareTo 메소드 
		return this.weight - value.weight;			// 매개변수 value와 가중치의 차를 반환한다
	}
	
	public int getStart() {							// start getter
		return start;								// start 반환
	}
	
	public void setStart(int start) {				// start setter
		this.start = start;							// 매개변수 값으로 start 초기화
	}
	
	public int getEnd() {							// end getter
		return end;									// end 반환
	}
	
	public void setEnd(int end) {					// end setter
		this.end = end;								// 매개변수 값으로 end 초기화
	}
	
	public int getWeight() {						// weight getter
		return weight;								// weight 반환
	}
	
	public void setWeight(int weight) {				// weight setter
		this.weight = weight;						// weight 반환
	}
}
