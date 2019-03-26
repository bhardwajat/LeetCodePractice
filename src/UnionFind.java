
public class UnionFind {
	
	private int[] parents;
	private int circles;
	
	public UnionFind(int n) {
		parents = new int[n];
		for(int i = 0; i < n; i++) {
			parents[i] = i;
		}
		circles = n;
	}
	
	public int find(int n) {
		if(parents[n] == n) {
			return n;
		}
		return find(parents[n]);
	}
	
	public void union(int x, int y) {
		int circleX = find(x);
		int circleY = find(y);
		
		if(circleX != circleY) {
			parents[circleX] = circleY;
			circles--;
		}
	}
}
