package Algorithms.Graph;

import java.util.ArrayList;
import java.util.Stack;

public class DepthFirstSearch {
	private static boolean visited[];
	private static ArrayList<ArrayList<Integer>> G;

	public static void dfs(ArrayList<ArrayList<Integer>> G) {
		visited = new boolean[G.size()];
		for (int i = 0; i < G.size(); i++) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}

	public static void dfs(int v) {
		Stack<Integer> st = new Stack<>();
		st.push(v);
		ArrayList<Integer> ref;
		int vertex;
		while (!st.isEmpty()) {
			vertex = st.pop();
			visited[vertex] = true;
			ref = G.get(vertex);
			for (int i : ref) {
				if (!visited[i])
					st.add(i);
			}
		}
	}
}
