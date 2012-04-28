package com.stee.softserv.carhome.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stee.softserv.carhome.entity.BrandEntity;
import com.stee.softserv.carhome.entity.ModelEntity;
import com.stee.softserv.carhome.util.ConnectionFactory;

public class AddCarActionServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 506044059226379920L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<ModelEntity> list = new ArrayList<ModelEntity>();
		String sqlModel = "select id,brand_model_name,brand_id from carshome_brand_model";
		try {
			Connection con = ConnectionFactory.getDirectConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sqlModel);

			while (rs.next())

			{
				ModelEntity modelEntity = new ModelEntity();

				modelEntity.setId(rs.getInt("id"));

				modelEntity.setModelName(rs.getString("brand_model_name"));
				modelEntity.setBrandId(rs.getInt("brand_id"));

				list.add(modelEntity);
			}

			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			System.out.println("DB Search exception : " + e.getMessage());
		}

		req.setAttribute("modelList", list);
		this.getServletContext().getRequestDispatcher("/addcar.jsp")
				.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
