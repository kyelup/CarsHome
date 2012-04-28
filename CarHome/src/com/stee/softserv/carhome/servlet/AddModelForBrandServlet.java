package com.stee.softserv.carhome.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stee.softserv.carhome.entity.BrandEntity;
import com.stee.softserv.carhome.util.ConnectionFactory;

public class AddModelForBrandServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4093543407121001480L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<BrandEntity> list = new ArrayList<BrandEntity>();
		String sql = "select id,brand_desc from carshome_brand";
		try {
			Connection con = ConnectionFactory.getDirectConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next())

			{
				BrandEntity brandEntity = new BrandEntity();

				brandEntity.setId(rs.getInt("id"));

				brandEntity.setBrandName(rs.getString("brand_desc"));
				System.out.println("     " + brandEntity.getId());
				list.add(brandEntity);
			}

			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("DB Search exception : " + e.getMessage());
		}

		req.setAttribute("brandList", list);
		this.getServletContext().getRequestDispatcher("/addmodelforbrand.jsp")
				.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// String modelName = new String(req.getParameter("modelName").getBytes(
		// "ISO-8859-1"), "gb2312");
		// String brandId = req.getParameter("brandId");

		// System.out.print(modelName + "            " + brandId);
		List<BrandEntity> list = new ArrayList<BrandEntity>();
		String sql = "select id,brand_desc from carshome_brand order by id esc";
		try {
			Connection con = ConnectionFactory.getDirectConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next())

			{
				BrandEntity brandEntity = new BrandEntity();

				brandEntity.setId(rs.getInt("id"));

				brandEntity.setBrandName(rs.getString("brand_desc"));
				System.out.println("     " + brandEntity.getId());
				list.add(brandEntity);
			}

			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("DB Search exception : " + e.getMessage());
		}

		req.setAttribute("brandList", list);
		this.getServletContext().getRequestDispatcher("/addmodelforbrand.jsp")
				.forward(req, resp);

	}

}
