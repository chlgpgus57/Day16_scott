package com.hh.control;

import java.util.List;
import java.util.Scanner;

import com.hh.dept.DeptDAO;
import com.hh.dept.DeptDTO;
import com.hh.input.DeptInput;
import com.hh.view.DeptView;


public class DeptController {
	private Scanner sc;
	private DeptDAO dao;
	private DeptView deptview;
	private DeptInput deptInput;
	private DeptDTO dto;
	public DeptController() {
		
		 sc = new Scanner(System.in);
		 dao = new DeptDAO();
		 deptview = new DeptView();
		 deptInput = new DeptInput();
		 dto = new DeptDTO();
	}
	

	public void start() {

		boolean check = true;

		
		while(check) {
			System.out.println("1. 전체출력");
			System.out.println("2. 원하는 부서 출력");
			System.out.println("3. 부서 정보 추가");
			System.out.println("4. 종료");
			int select = sc.nextInt();
			
			
			switch(select) {
			
				case 1:
					List<DeptDTO> ar = dao.deptselectList();
					if(ar.size()>0) {
						deptview.view(ar);
					}else {
						deptview.view("데이터가 없습니다.");
					}
					break;
				case 2:
					int num = deptInput.input();
					DeptDTO deptDTO = dao.deptselectOne(num);
					
					if(deptDTO != null) {
						deptview.view(deptDTO);
					}else {
						deptview.view("없는 사원 번호 입니다.");
					}
					
					break;
					
				case 3:
					dto = deptInput.insert();
					select = dao.deptInsert(dto);
					
					if(select>0) {
						System.out.println("성공");
					}else {
						System.out.println("실패");
					}

					break;
					
				default :
					System.out.println("종료");
					check = false;
					break;
		
			
			}
			
			
			
			
		}
	}
}
