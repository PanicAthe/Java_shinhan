package com.shinhan.day09.homework;

public class StringUtil { //LAB8
	public static String concatenate(String[] str) {
		String result = "";
		for(String s : str) {
			result += s;
		}
		return result;
	}

	public static void main(String args[]) {
		String[] strArr = { "SuperMan", "BatMan", "SpiderMan" };
		String resultStr = concatenate(strArr);
		System.out.println("결과 문자열 : " + resultStr);
	}
}
