package practiced2;

import java.util.Scanner;

public class A4 {


	
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
System.out.println("Enter the number of nodes:");
int numNodes = sc.nextInt();
int[][] input = new int[numNodes][numNodes];
System.out.println("Enter the input matrix:");
for (int i = 0; i < numNodes; i++) {
for (int j = 0; j < numNodes; j++) {
input[i][j] = sc.nextInt();

}
}
System.out.println("Enter the source node:");
int sourceNode = sc.nextInt();
dijkstra(input, sourceNode);
}

private static void dijkstra(int[][] input, int sourceNode) {
	int V = input.length;
	boolean visited[] = new boolean[V];
	int dist[] = new int[V];
	
	for(int i=0; i<V; i++) {
		visited[i]= false;
		dist[i] = Integer.MAX_VALUE; 
	}
	
	for(int i =0; i<V-1; i++) {
		dist[sourceNode] = 0;
		int u = mindistance(dist, visited);
		visited[u]= true;
		for(int v=0; v<V; v++) {
			if(!visited[v] && input[u][v]!=0 && input[u][v]!=Integer.MAX_VALUE && dist[u]+input[u][v]<dist[v] ) {
				dist[v]= dist[u]+input[u][v];
			}
		}
	}
	
	
	for(int i: dist) {
		int j=0;
		System.out.println("Distance of veretex "+ j + "form verex "+sourceNode+" is : "+i);
		j++;
	}
}

private static int mindistance(int[] dist, boolean[] visited) {
	int index = -1;
	int mindist = Integer.MAX_VALUE;
	for(int i=0; i<dist.length; i++) {
		if(visited[i] == false && dist[i]<mindist) {
			mindist = dist[i];
			index = i;
		}
	}
	return index;
}

	
	
}
