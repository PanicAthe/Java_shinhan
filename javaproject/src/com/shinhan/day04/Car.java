package com.shinhan.day04;

/*
 * class : Object를 만들기위한 틀, template, 설계도 Car설계도, 붕어빵틀 (특징과 행위정의)
 * Object : class를 이용해서 만든 독립된 개체 (속성이 다른 Object와 구별된다), Car10개 
 * Instance : class를 이용해서 Object실체 = Object
 */

//상속관계
public class Car extends 기계{
	//1.Field(특징, 변수)
	String model;
	String color;
	int price;
	
	//집합관계
	엔진 a;
	타이어 b;
	핸들 c;
	
}
