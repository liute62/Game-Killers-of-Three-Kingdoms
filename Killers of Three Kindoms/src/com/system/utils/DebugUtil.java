package com.system.utils;


public class DebugUtil {

	public static void print(String param) {
	
		System.out.println(param);
	}
	
	public static void print(int param){
		System.out.println(param);
	}
	
	public static void print(String name,String param) {
		System.out.println(name+" : "+param);
	}
	
	public static void print(String name,int param) {
		System.out.println(name+" : "+String.valueOf(param));
	}
	
	public static void print(){
		System.out.println("success print!");
	}
	
	public static void print(boolean param){
		System.out.println(String.valueOf(param));
	}
}
