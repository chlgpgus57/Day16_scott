package com.hh.emp;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.hh.util.DBConnecter;

public class EmpDAO {
	//getSelectList
	//전체사원정보 - 최신 입사일 순
	public ArrayList<EmpDTO> getSelectList() {
		
		DBConnecter dbc = new DBConnecter();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmpDTO empdto = null;
		ArrayList<EmpDTO> ar = null;
		boolean check = true;
		
		try {
			con = dbc.dbconnecter();
			String sql = "select * from emp order by hiredate desc";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			ar = new ArrayList<EmpDTO>();
			
			while(rs.next()) {

					empdto = new EmpDTO();
					empdto.setEmpno(rs.getInt("empno"));
					empdto.setEname(rs.getString("ename"));
					empdto.setJob(rs.getString("job"));
					empdto.setMgr(rs.getInt("mgr"));
					empdto.setHiredate(rs.getDate("hiredate"));
					empdto.setSal(rs.getInt("sal"));
					empdto.setComm(rs.getInt("comm"));
					empdto.setDeptno(rs.getInt("deptno"));
					ar.add(empdto);
			}	
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ar;
	}
	
	//getSelectOne
	//매개변수 사원번호
	public EmpDTO getSelectOne(int empno) {
		
		DBConnecter dbc = new DBConnecter();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		EmpDTO empdto = null;
		
		try {
			con = dbc.dbconnecter();
			String sql = "select * from emp where empno = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, empno);
			rs = st.executeQuery();
			
			if(rs.next()) {
				empdto = new EmpDTO();
				empdto.setEmpno(rs.getInt("empno"));
				empdto.setEname(rs.getString("ename"));
				empdto.setJob(rs.getString("job"));
				empdto.setMgr(rs.getInt("mgr"));
				empdto.setHiredate(rs.getDate("hiredate"));
				empdto.setSal(rs.getInt("sal"));
				empdto.setComm(rs.getInt("comm"));
				empdto.setDeptno(rs.getInt("deptno"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return empdto;
	}

}
