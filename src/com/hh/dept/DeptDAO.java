package com.hh.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hh.util.DBConnecter;

public class DeptDAO {
	
	public int deptInsert(DeptDTO deptDTO) {
	
		DBConnecter dbc = new DBConnecter();
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		try {
			con = dbc.dbconnecter();
			String sql = "insert into dept values(?,?,?)";
			st = con.prepareStatement(sql);
		
			st.setInt(1, deptDTO.getDeptno());
			st.setString(2, deptDTO.getDname());
			st.setString(3, deptDTO.getLoc());
			
			result = st.executeUpdate();
			
	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}return result;
		
	}
	
	//SelectList
	public List<DeptDTO> deptselectList(){
		ArrayList<DeptDTO> ar = new ArrayList<DeptDTO>();
		DBConnecter dbc = new DBConnecter();
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = dbc.dbconnecter();
			String sql = "select * from dept order by deptno asc";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			
			while(rs.next()) {
				
				DeptDTO deptDTO = new DeptDTO();
				
				deptDTO.setDeptno(rs.getInt("deptno"));
				deptDTO.setDname(rs.getString("dname"));
				deptDTO.setLoc(rs.getString("loc"));
				
				ar.add(deptDTO);	
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
		return ar;
	}
	
	//SelectOne
	public DeptDTO deptselectOne(int deptno) {
		DBConnecter dbc = new DBConnecter();
		DeptDTO deptDTO = null;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
	
		
		try {
			con = dbc.dbconnecter();
			String sql = "select * from dept where deptno = ?";
			st = con.prepareStatement(sql);
			st.setInt(1, deptno);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				
				deptDTO = new DeptDTO();
				
				deptDTO.setDeptno(rs.getInt("deptno"));
				deptDTO.setDname(rs.getString("dname"));
				deptDTO.setLoc(rs.getString("loc"));
				
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
		
		return deptDTO;
	}
}
