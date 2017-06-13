package Graph;

import java.util.ArrayList;

//Graph with e edges
public class BellmanFord {
	public static ArrayList<edge> edges;
	public static long[] dist;
	
	static class edge{
		long weight;
		int u;
		int v;
		public edge(long w,int x,int y) {
			weight = w;
			u = x;
			v = y;
		}
	}
	public static void bellmanford(int source,int v) {
		dist = new long[v];
		for(int i=0;i<v;i++) {
			dist[i] = Long.MAX_VALUE;
		}
		dist[source] = 0;
		edge ref;
		for(int i=0;i<v;i++) {
			for(int j = 0;j<edges.size();j++) {
				ref = edges.get(j);
				if(dist[ref.u]!=Long.MAX_VALUE && dist[ref.u]+ref.weight<dist[ref.v]) {
					dist[ref.v] = dist[ref.u]+ref.weight;
				}
			}
		}
		for(int j = 0;j<edges.size();j++) {
			ref = edges.get(j);
			if(dist[ref.u]!=Long.MAX_VALUE && dist[ref.u]+ref.weight<dist[ref.v]) {
				System.out.println("Cycle detected");
			}
		}
	}
}
