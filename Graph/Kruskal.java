package Algorithms.Graph;

import java.util.ArrayList;
import java.util.Comparator;

public class Kruskal {
	public static ArrayList<edge> graph;
	public static int cycle[];

	static class edge {
		int weight;
		int u;
		int v;

		public edge(int w, int x, int y) {
			weight = w;
			u = x;
			v = y;
		}
	}

	public static int root(int i) {
		while (cycle[i] != i) {
			cycle[i] = cycle[cycle[i]];
			i = cycle[i];
		}
		return i;
	}

	public static void union(int u, int v) {
		int p = root(u);
		int q = root(v);
		cycle[p] = cycle[q];
	}

	public static long kruskal() {
		cycle = new int[graph.size()];
		for (int i = 0; i < graph.size(); i++) {
			cycle[i] = i;
		}
		graph.sort(new Comparator<edge>() {
			@Override
			public int compare(edge o1, edge o2) {
				if (o1.weight == o2.weight) {
					return o1.u + o1.v + o1.weight - o2.u - o2.v - o2.weight;
				}
				return o1.weight - o2.weight;
			}
		});
		long mincost = 0, w;
		int u, v;
		for (int i = 0; i < graph.size(); i++) {
			u = graph.get(i).u;
			v = graph.get(i).v;
			w = graph.get(i).weight;
			if (root(u) != root(v)) {
				mincost += w;
				union(u, v);
			}
		}
		return mincost;
	}
}
