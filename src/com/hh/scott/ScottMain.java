package com.hh.scott;


import com.hh.bonus.BonusDTO;
import com.hh.control.FrontController;
import com.hh.control.SalgradeController;
import com.hh.input.BonusInput;

public class ScottMain {

	public static void main(String[] args) {
		
//		FrontController fc = new FrontController();
//		fc.start();
//		
		
		SalgradeController sc = new SalgradeController();
		sc.start();
		
//		
//		BonusDTO bonusDto = null;
//		BonusInput bi = new BonusInput();
//		bonusDto = bi.insert();
//		System.out.println(bonusDto.getEname());
//		System.out.println(bonusDto.getJob());
//		System.out.println(bonusDto.getSal());
//		System.out.println(bonusDto.getComm());
	}

}
