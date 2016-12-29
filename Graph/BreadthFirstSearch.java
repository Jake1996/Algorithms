package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	private static boolean visited[];
	private static ArrayList<ArrayList<Integer>> G;

	public static void bfs(ArrayList<ArrayList<Integer>> G) {
		visited = new boolean[G.size()];
		for(int i=0;i<G.size();i++) {
			if(!visited[i]) {
				bfs(i);
			}
		}
	}
	public static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		ArrayList<Integer> ref;
		int vertex;
		while(!q.isEmpty()) {
			vertex = q.remove();
			visited[vertex] = true;
			ref = G.get(vertex);
			for(int i:ref) {
				if(!visited[i])
					q.add(i);
			}
		}
	}
}
