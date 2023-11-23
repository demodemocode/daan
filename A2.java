package practiced2;

import java.util.*;

import practiced.Assi2;

import java.math.*;

public class A2 {
	
	char id;
	int deadline, profit;
	A2(char id, int deadline, int profit){
		this.id = id;
		this.deadline = deadline;
		this.profit = profit;
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		ArrayList<A2> job = new ArrayList<A2>();
		job.add(new A2('a', 4, 100));
		job.add(new A2('b', 2, 19));
		job.add(new A2('c', 1, 27));
		job.add(new A2('d', 1, 25));
		job.add(new A2('e', 2, 15));
		
        jobSheduler(job, 5);
	}

	private static void jobSheduler(ArrayList<A2> job, int t) {
		int n = job.size();
		
		Collections.sort(job, (a,b)->b.profit- a.profit);
		
		boolean result[] = new boolean[n];
		A2 seq[] = new A2[n];
		for(int i=0; i<n; i++) {
			for(int j= Math.min(t-1, job.get(i).deadline-1); j>=0; j--){
				if(result[j]==false) {
					result[j]=true;
					seq[j]= job.get(j);
					break;
				}
			}
		}
		
		for(A2 j:seq) {
			System.out.println(j.id);
		}
	}
}
