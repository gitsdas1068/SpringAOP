package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.nt.bo.TicketBO;

public final class TicketDAOImpl implements TicketDAO {
	private static final String INSERT_STUDENT_QUERY = "INSERT INTO reserve_ticket(SNAME,SADD,FARE,TOTAL,TRAINNUMBER) VALUES(?,?,?,?,?)";

	private DataSource ds;

	public TicketDAOImpl(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public int insert(TicketBO bo) throws Exception {

		Connection con = null;
		PreparedStatement ps = null;
		int count = 0;
		// get Pooled JDBC con obj from JDBC Con pool
		con = ds.getConnection();

		// create JDBC PreparedStatement object
		ps = con.prepareStatement(INSERT_STUDENT_QUERY);
		// set values to query params
		ps.setString(1, bo.getSname());
		ps.setString(2, bo.getSadd());
		ps.setString(3, bo.getFare());
		ps.setString(4, bo.getTotal());
		ps.setString(5, bo.getTrainNumber());

		// execute the Query
		count = ps.executeUpdate();
		// close jdbc objs

		ps.close();
		con.close();
		return count;
	}// method

	@Override
	public String getFare(TicketBO bo) throws Exception {
		Connection con = null;
		PreparedStatement ps = null;
		con = ds.getConnection();
		String val = null;

		String query = "select fare from  reserve_ticket where SNAME='" + bo.getSname() + "' AND sadd='" + bo.getSadd()
				+ "' AND trainnumber='" + bo.getTrainNumber() + "';";
		PreparedStatement p = con.prepareStatement(query);
		ResultSet rs = p.executeQuery();
		while (rs.next()) {

			val = rs.getString("fare");
		}
		return val;
	}
}// class
