package com.hh.scott;

import java.util.ArrayList;

import com.hh.emp.EmpDAO;
import com.hh.emp.EmpDTO;
import com.hh.input.EmpInput;
import com.hh.view.EmpView;

public class ScottMain {

	public static void main(String[] args) {
				
		EmpDAO ed = new EmpDAO();
		EmpDTO empdto = null;
		ArrayList<EmpDTO> ar = null;
		EmpView ev = new EmpView();
		EmpInput ei = new EmpInput();
		
		int num = ei.empnoInput();
		empdto = ed.getSelectOne(num);
		ar = ed.getSelectList();
		ev.view(empdto);
		ev.view(ar);
		
	}

}
