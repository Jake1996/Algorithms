package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijikstra {
	public static ArrayList<ArrayList<edge>> graph;
	public static long[] dist;
	public static boolean[] visited;
	static class edge{
		long weight;
		int v;
		public edge(long w,int x) {
			weight = w;
			v = x;
		}
	}
	public static void dijikstra(int source) {
		dist = new long[graph.size()];
		visited = new boolean[graph.size()];
		for(int i=0;i<graph.size();i++) {
			dist[i] = Long.MAX_VALUE;
		}
		dist[source] = 0;
		PriorityQueue<edge> Q = new PriorityQueue<>(new Comparator<edge>() {
			@Override
			public int compare(edge o1, edge o2) {
				if(o1.weight-o2.weight>0) return 1;
				if(o1.weight-o2.weight<0) return -1;
				return 0;
			}
		});
		Q.add(new edge(0, source));
		edge ref;
		int u,v;
		long w;
		while(!Q.isEmpty()) {
			ref = Q.remove();
			//w = ref.weight;
			u = ref.v;
			if(visited[u]) continue;
			visited[u] = true;
			for(edge e:graph.get(u)) {
				v = e.v;
				w = e.weight;
				if(dist[u] + w < dist[v]) {
					dist[v] = w + dist[u];
					Q.add(new edge(dist[v], v));
				}
			}
		}
	}
}
