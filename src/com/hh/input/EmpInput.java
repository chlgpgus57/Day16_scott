package com.hh.input;

import java.util.Scanner;

import com.hh.emp.EmpDTO;

public class EmpInput {
	
	Scanner sc = null;
	
	
		public int empnoInput() {
		
			sc = new Scanner(System.in);
			System.out.println("사원 번호를 입력하세요.");
			
			int empnum = sc.nextInt();
			
			return empnum;
		}
		
		
		
		public EmpDTO insert() {
			EmpDTO empdto = new EmpDTO();
			sc = new Scanner(System.in);
		
			System.out.println("사원 번호 입력");
			empdto.setEmpno(sc.nextInt());
			System.out.println("사원 이름 입력");
			empdto.setEname(sc.next());
			System.out.println("직업 입력");
			empdto.setJob(sc.next());
			System.out.println("MGR 입력");
			empdto.setMgr(sc.nextInt());
		//	System.out.println("HIREDATE 입력");
		//	empdto.setHiredate(sc.next());
			System.out.println("SAL 입력");
			empdto.setSal(sc.nextInt());
			System.out.println("COMM 입력");
			empdto.setComm(sc.nextInt());
			System.out.println("DEPTNO 입력");
			empdto.setDeptno(sc.nextInt());
			
			
			return empdto;
			
		}
		
		public int delete() {
			
			sc = new Scanner(System.in);
			System.out.println("삭제할 직원의 직원번호 입력");
			int empno = sc.nextInt();
			
			return empno;
		}
		
}
