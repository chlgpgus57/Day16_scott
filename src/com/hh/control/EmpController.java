package com.hh.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.hh.emp.EmpDAO;
import com.hh.emp.EmpDTO;
import com.hh.input.EmpInput;
import com.hh.view.EmpView;

public class EmpController {
	Scanner sc = new Scanner(System.in);
	//start
	//1. 사원전체정보출력
	//2. 사원검색출력
	//3. 종료
	
	public void start() {
		
		ArrayList<EmpDTO> ar = null;
		
		EmpInput ei = new EmpInput();
		EmpDAO ed = new EmpDAO();
		EmpView ev = new EmpView();
		EmpDTO empdto = null;
		boolean check = true;
		
		while (check) {
			
			System.out.println("메뉴를 골라주세요");
			System.out.println("1. 사원전체정보출력");
			System.out.println("2. 사원검색출력");
			System.out.println("3. 종료");
			int select = sc.nextInt();

			switch(select) {
				case 1: 
					ar = ed.getSelectList();
					ev.view(ar);
					break;
				case 2:
					int num = ei.empnoInput();
					empdto = ed.getSelectOne(num);
					ev.view(empdto);
					break;
				case 3:
					System.out.println("종료");
					check = false;
					break;
				default:
					break;
					
			
			}
		}
		
		
		
	}
	
}
