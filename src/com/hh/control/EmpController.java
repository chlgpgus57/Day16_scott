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
		
		
		
		EmpInput ei = new EmpInput();
		EmpDAO ed = new EmpDAO();
		EmpView ev = new EmpView();
		EmpDTO empdto = null;
		boolean check = true;
		
		while (check) {
			
			System.out.println("메뉴를 골라주세요");
			System.out.println("1. 사원전체정보출력");
			System.out.println("2. 사원검색출력");
			System.out.println("3. 사원 정보 입력");
			System.out.println("4. 사원 정보 삭제");
			System.out.println("5. 종료");
			int select = sc.nextInt();

			switch(select) {
				case 1: 
					ArrayList<EmpDTO> ar = ed.getSelectList();
					if(ar.size()>0) {
						ev.view(ar);
					}else {
						ev.view("데이터가 없습니다.");
					}
					break;
				case 2:
					int num = ei.empnoInput();
					empdto = ed.getSelectOne(num);
					
					if(empdto != null) {
						ev.view(empdto);
					}else {
						ev.view("없는 사원 번호 입니다.");
					}
					
					break;
				case 3:
					EmpDTO empdto2 = ei.insert();
					 select = ed.empinsert(empdto2);
					if(select >0) {
						System.out.println("입력성공");
					}else {
						System.out.println("입력실패");
					}
					break;
				case 4:
					num = ei.delete();
					select = ed.delete(num);
					
					if(select >0) {
						System.out.println("삭제성공");
					}else {
						System.out.println("삭제실패");
					}
					
					break;
				default:
					System.out.println("종료");
					check = false;
					break;
				
			}
		}
		
		
		
	}
	
}
