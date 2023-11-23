package practiced2;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class A6 {

	public static class Node implements Comparable<Node>{

		int cost;
		int level;
		int assigned[];
		boolean visited[];
		
		Node(int cost , int level, int assigned[], boolean visited[]){
			this.cost = cost;
			this.level = level;
			this.assigned = assigned.clone();
			this.visited = visited.clone();
		}
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;	
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of matrix : ");
		int n = sc.nextInt();
		int a[][] = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				a[i][j]=sc.nextInt();
			}
		}
		
		int mincost = Sheduler(a);
		System.out.println("mincost : "+ mincost );
	}

	private static int Sheduler(int[][] a) {
		int n = a.length;
		int assigned[] = new int[n];
		boolean  visited[] = new boolean[n];
		Arrays.fill(assigned, -1);
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.add(new Node(0,-1,assigned, visited));
		
		while(!pq.isEmpty()) {
			Node min = pq.poll();
			int i = min.level+1;
			
			if(i==n) {
				printSol(min.assigned, a);
				return min.cost;
			}
			
			for(int j=0; j<n; j++) {
				if(min.visited[j]==false) {
					int newassigned[] = min.assigned.clone();
					boolean newvisited[] = min.visited.clone();
					newassigned[i]=j;
					newvisited[j]= true;
					
					Node child = new Node(min.cost + a[i][j],i, newassigned, newvisited );
					pq.add(child);
				}
			}
		}
		
		return -1;
		
	}

	private static void printSol(int[] assigned, int[][] a) {
		for(int i=0; i<assigned.length; i++) {
			int club = assigned[i];
			int cost = a[i][club];
			System.out.println("student 1 is assined to club " + club + " with cost of "+ cost);
		}
		
	}
}
