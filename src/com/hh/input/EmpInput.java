package com.hh.input;

import java.util.Scanner;

public class EmpInput {
	
	Scanner sc = null;
	
	
		public int empnoInput() {
		
			sc = new Scanner(System.in);
			System.out.println("사원 번호를 입력하세요.");
			
			int empnum = sc.nextInt();
			
			return empnum;
		}
		
}
