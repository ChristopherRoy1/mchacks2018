package mchacks2018;

public class Main {
	public static void main (String[] args) {
	System.out.println("Hello World!!");
	System.out.println("Hello");
	int n = factorial(5);
	System.out.println(n);
	}
	
	public static int factorial(int n) {
		if(n < 0) {
			return 0;
		}
		else if(n == 0 || n == 1) {
			return 1;
		}
		else return n*factorial(n-1);
	}
}