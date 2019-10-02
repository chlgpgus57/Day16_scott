package com.hh.input;

import java.util.Scanner;

import com.hh.salgrade.SalgradeDTO;

public class SalgradeInput {

private Scanner sc;
	
	public SalgradeInput() {
		sc = new Scanner(System.in);
	}
	
	public SalgradeDTO insert() {
		SalgradeDTO salgradeDTO = new SalgradeDTO();
		
		System.out.println("추가할 급여등급을 입력하세요.");
		salgradeDTO.setGrade(sc.nextInt());
		System.out.println("추가할 최저급여를 입력하세요.");
		salgradeDTO.setLosal(sc.nextInt());
		System.out.println("추가할 최고급여를 입력하세요.");
		salgradeDTO.setHisal(sc.nextInt());
		
		return salgradeDTO;
	}
	
	
	public int salgradeInput() {
		
		System.out.println("급여등급을 입력하세요");
		int grade = sc.nextInt();
		
		return grade;
	}
	
	
	public int delete() {
		
		sc = new Scanner(System.in);
		System.out.println("삭제할 등급 입력");
		int grade = sc.nextInt();
		
		return grade;
	}
	
}
