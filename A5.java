package practiced2;

public class A5 {
	static int n = 8;

	public static void main(String[] args) {
		solveKT();
	}

	private static void solveKT() {
		int a[][]= new int[n][n];
		for(int i =0; i<n; i++) {
			for(int j= 0; j<n; j++) {
				a[i][j]= -1;
			}
		}
		
		int xMove[]= {2,1,-1,-2,-2,-1,1,2};
		int yMove[]= {1,2,2,1,-1,-2,-2,-1};
		
		a[0][0]= 0;
		
		if(!jumpnext(0,0,1,a, xMove, yMove)) {
			System.out.println("no");
		}else {
			printSolun(a);
		}
		
		
		
		
	}

	private static boolean jumpnext(int x, int y, int jump, int[][] a, int[] xMove, int[] yMove) {
		int xNext, yNext;
		
		if(jump == n*n) return true;
		
		for(int i=0; i<n; i++) {
			xNext = x+xMove[i];
			yNext = y+yMove[i];
			if(canjump(xNext, yNext, a)) {
				a[xNext][yNext]=jump;
				if(jumpnext(xNext, yNext, jump+1, a,xMove, yMove)) {
					return true;
				}else {
					a[xNext][yNext]=-1;
				}
			}
			
		}
		
		return false;
	}
	
	private static boolean canjump(int x, int y, int[][] a) {
		if(x>=0 && x<n && y>=0 && y<n && a[x][y]==-1) return true;
		return false;
	}

	private static void printSolun(int[][] a) {
		for(int i=0; i<n; i++) {
			System.out.println();
			for(int j=0; j<n; j++) {
				System.out.print(a[i][j]+"\t");
			}
		}
	}
}
