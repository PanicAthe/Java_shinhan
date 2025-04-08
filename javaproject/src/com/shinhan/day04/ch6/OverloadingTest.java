package com.shinhan.day04.ch6;

public class OverloadingTest {

	public static void main(String[] args) {
		f1(10);
		f1("자바");
		f1(20,"스프링", true);
		
		System.out.println(sum(1,2,3));
		System.out.println(sum(1,2,3,4,5));
		System.out.println(sum(1,2,3,4,5,6,7,8,9,10));
		

	}
	private static int sum(int...arr) {
		int result = 0;
		for(int su:arr) {
			result += su;
		}
		return result;
	}
	/*
	private static int sum(int i, int j, int k, int l, int m) {
		// TODO Auto-generated method stub
		return i+j+k+l+m;
	}
	private static int sum(int i, int j, int k) {
		// TODO Auto-generated method stub
		return i+j+k;
	}*/
	//Overloading
    //1.함수이름같다
	//2.매개변수 갯수와 타입이 다르다.
	//3.return이 같거나 다르다.
	private static int f1(int i, String string, boolean b) {

		return 100;
		
	}

	private static void f1(String string) {
		// TODO Auto-generated method stub
		
	}

	private static void f1(int i) {
		// TODO Auto-generated method stub
		
	}

}
