package Graph;

public class FloydWarshall {
	public static void floydwarshall(int arr[][]) {
		int n = arr.length;
		long dist[][] = new long[n][n];
		for(int k = 1; k <= n; k++){
		    for(int i = 1; i <= n; i++){
		        for(int j = 1; j <= n; j++){
		            dist[i][j] = Math.min( dist[i][j], dist[i][k] + dist[k][j] );
		        }
		    }
		}
	}
}
