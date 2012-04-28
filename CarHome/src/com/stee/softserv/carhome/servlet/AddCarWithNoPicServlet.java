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

public class AddCarWithNoPicServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9048105106719508689L;

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

		String carName = req.getParameter("carName");

		String modelId = req.getParameter("modelId");
		String carPriceMin = req.getParameter("carPriceMin");
		String carPriceMax = req.getParameter("carPriceMax");
		String sql = "insert into carshome_brand_model_car(car_name,car_price_min,car_price_max,car_model_id) values (?,?,?,?)";
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		int effectRow = 0;

		try {
			conn = ConnectionFactory.getDirectConnection();
			preparedStatement = conn.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1,
					new String(carName.getBytes("ISO-8859-1"), "gb2312"));
			preparedStatement.setFloat(2, Float.valueOf(carPriceMin));
			preparedStatement.setFloat(3, Float.valueOf(carPriceMax));
			preparedStatement.setInt(4, Integer.valueOf(modelId));
			preparedStatement.executeUpdate();
			rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				effectRow = rs.getInt(1);
			}

		} catch (Exception e) {

			System.out.println("DB Search exception : " + e.getMessage());
		}

		PrintWriter out = resp.getWriter();
		out.println("add successfully!!!");

	}
}
