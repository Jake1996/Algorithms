package Graph;

public class FloydWarshall {
	public static long[][] floydwarshall(int arr[][]) {
		int n = arr.length;
		long dist[][] = new long[n][n];
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				if(i==j) continue;
				if(arr[i][j]==0) dist[i][j]=Long.MAX_VALUE;
				else dist[i][j] = arr[i][j];
			}
		}
		for(int k = 0; k < n; k++){
			for(int i = 0; i < n; i++){
				if(dist[i][k]!=Long.MAX_VALUE) {
					for(int j = 0; j < n; j++){
						if(dist[k][j]!=Long.MAX_VALUE){
							dist[i][j] = Math.min( dist[i][j], dist[i][k] + dist[k][j] );
						}
					}
				}
			}
		}
		return dist;
	}
}