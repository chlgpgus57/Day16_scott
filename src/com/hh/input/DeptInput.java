package com.hh.input;

import java.util.Scanner;

import com.hh.dept.DeptDTO;

public class DeptInput {
	Scanner sc = new Scanner(System.in);

	public int input() {
		
		System.out.println("부서번호를 입력 해 주세요.");
		int deptnum = sc.nextInt();
		
		
		return deptnum;
	}
	
	public DeptDTO insert() {
		DeptDTO deptdto = new DeptDTO();
		
		System.out.println("부서 번호를 입력해 주세요");
		deptdto.setDeptno(sc.nextInt()) ;
		System.out.println("부서 이름을 입력해 주세요");
		deptdto.setDname(sc.next());
		System.out.println("지역을 입력해 주세요");
		deptdto.setLoc(sc.next()); 		
		
		return deptdto;
	}
	
}
