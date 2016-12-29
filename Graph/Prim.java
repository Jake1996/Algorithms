package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Prim {
	public static ArrayList<ArrayList<edge>> graph;
	public static boolean marked[];
	static class edge{
		int weight;
		int v;
		public edge(int w,int x) {
			weight = w;
			v = x;
		}
	}
	public static long prim(int start) {
		marked = new boolean[graph.size()];
		long mincost = 0;
		int u,v;
		PriorityQueue<edge> Q = new PriorityQueue<edge>(new Comparator<edge>() {
			@Override
			public int compare(edge o1, edge o2) {
				return o1.weight-o2.weight;
			}
		});
		Q.add(new edge(0,start));
		edge ref;
		while(!Q.isEmpty()) {
			ref = Q.remove();
			u=ref.v;
			if(marked[u]) continue;
			mincost+=ref.weight;
			marked[u]=true;
			for(int i=0;i<graph.size();i++) {
				v = graph.get(u).get(i).v;
				if(!marked[v])
					Q.add(graph.get(u).get(i));
			}
		}
		return mincost;
	}
}
