package com.hh.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.hh.bonus.BonusDAO;
import com.hh.bonus.BonusDTO;
import com.hh.input.BonusInput;
import com.hh.view.BonusView;

public class BonusController {

	private Scanner sc;
	private BonusDAO bonusDAO;
	private BonusDTO bonusDTO;
	private BonusView bonusView;
	private BonusInput bonusInput;

	public BonusController() {
		sc = new Scanner(System.in);
		bonusDAO = new BonusDAO();
		bonusDTO = new BonusDTO();
		bonusView = new BonusView();
		bonusInput = new BonusInput();
	}


	@SuppressWarnings("unlikely-arg-type")
	public void start() {
		boolean check = true;
		int select = 0;

		while(check) {
			System.out.println("++++++++++++++++++++");
			System.out.println("1. 급여등급 전체 정보 출력");
			System.out.println("2. 급여등급 검색 출력");
			System.out.println("3. 급여등급 정보 추가");
			System.out.println("4. 급여등급 정보 삭제");
			System.out.println("5. 종료");
			System.out.println("++++++++++++++++++++");
			select = sc.nextInt();

			switch(select) {
			case 1:
				ArrayList<BonusDTO> ar = bonusDAO.getSelectList();
				if(ar.size()>0) {
					bonusView.view(ar);
				}else {
					bonusView.view("데이터가 없습니다");
				}
				break;

			case 2:
				String name = bonusInput.input();
				bonusDTO = bonusDAO.getSelectOne(name);
				
				if(bonusDTO!=null) {
					bonusView.view(bonusDTO);
				}else {
					bonusView.view("없습니다");
				}
				
				break;

			case 3:
				BonusDTO bonusDTO = bonusInput.insert();
				select = bonusDAO.bonusInsert(bonusDTO);
				if(select >0) {
					System.out.println("입력성공");
				}else {
					System.out.println("입력실패");
				}
				break;

			case 4:
				name = bonusInput.delete();
				select = bonusDAO.delete(name);
				
				if(select >0) {
					System.out.println("삭제성공");
				}else {
					System.out.println("삭제실패");
				}
				break;

			default :
				check = !check;
			}

		}
	}
}
