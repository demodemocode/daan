package practiced2;

import java.util.*;
import java.math.*;
import java.lang.*;

public class A1 {

	public static BigInteger square(BigInteger num) {
		if(num.compareTo(BigInteger.TEN)<0) {
			return num.multiply(num);
		}
		
		int Y = num.toString().length();
		int half = Y/2;
		
		BigInteger a = num.divide(BigInteger.TEN.pow(half));
		BigInteger b = num.mod(BigInteger.TEN.pow(half));
		
		BigInteger ac = square(a);
		BigInteger bd = square(b);
		BigInteger aplusb = square(a.add(b)).subtract(ac).subtract(bd);
		
		return ac.multiply(BigInteger.TEN.pow(2*half)).add(aplusb.multiply(BigInteger.TEN.pow(half))).add(bd);
	}
	
	public static void main(String[] args) {
		System.out.println("Enter the no : ");
		Scanner sc = new Scanner(System.in);
		BigInteger b = sc.nextBigInteger();
		System.out.println(square(b));
	}
}
