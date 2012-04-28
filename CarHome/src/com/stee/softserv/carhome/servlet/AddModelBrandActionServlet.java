package com.stee.softserv.carhome.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stee.softserv.carhome.util.ConnectionFactory;

public class AddModelBrandActionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4955044839938896959L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int brandId = Integer.valueOf(req.getParameter("brandId"));

		String modelName = req.getParameter("modelName");

		String sql = "insert into carshome_brand_model(brand_model_name,brand_id) values (?,?)";
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		int effectRow = 0;

		try {
			conn = ConnectionFactory.getDirectConnection();
			preparedStatement = conn.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1,
					new String(modelName.getBytes("ISO-8859-1"), "gb2312"));
			preparedStatement.setInt(2, brandId);

			preparedStatement.executeUpdate();
			rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				effectRow = rs.getInt(1);
			}

		} catch (Exception e) {

			System.out.println("DB Search exception : " + e.getMessage());
		}

		PrintWriter out = resp.getWriter();
		out.println("add successfully");
	}

}
