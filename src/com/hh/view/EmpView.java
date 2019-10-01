package com.hh.view;

import java.util.ArrayList;

import com.hh.emp.EmpDTO;

public class EmpView {

	public void view(ArrayList<EmpDTO> ar) {
		
		for(int i = 0; i< ar.size(); i++) {
			
			System.out.println("================================");
			System.out.println(ar.get(i).getEmpno());
			System.out.println(ar.get(i).getEname());
			System.out.println(ar.get(i).getJob());
			System.out.println(ar.get(i).getMgr());
			System.out.println(ar.get(i).getHiredate());
			System.out.println(ar.get(i).getSal());
			System.out.println(ar.get(i).getComm());
			System.out.println(ar.get(i).getDeptno());
			
		}
	}
	
	
	public void view(EmpDTO empdto) {
		
		System.out.println("EMPNO    : " +empdto.getEmpno());
		System.out.println("ENAME    : " +empdto.getEname());
		System.out.println("JOB      : " +empdto.getJob());
		System.out.println("MGR      : " +empdto.getMgr());
		System.out.println("HIREDATE : " +empdto.getHiredate());
		System.out.println("SAL      : " +empdto.getSal());
		System.out.println("COMM     : "+empdto.getComm());
		System.out.println("DEPTNO   : "+empdto.getDeptno());
	}
}
