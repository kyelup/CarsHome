package com.stee.softserv.carhome.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.stee.softserv.carhome.util.ConnectionFactory;

public class UpBrandServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5903926712622224649L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpBrandServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	String filePath;
	String diskDir;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + request.getContextPath()
				+ "/";
		String brandCountry = null;
		String brandName = null;
		String brandFirstC = null;
		String avatar = null;

		int code = 0;

		final long MAX_SIZE = 3 * 1024 * 1024;// set up max file size 3M

		// set up upload file type
		final String[] allowedExt = new String[] { "JPG", "jpg", "JPEG",
				"jpeg", "PNG", "png", "GIF", "gif", "BMP", "bmp", "TXT", "txt",
				"DOC", "doc", "DOCX", "docx", "PPT", "ppt", "PPTX", "pptx",
				"XLS", "xls", "XLSX", "xlsx", "MP3", "mp3", "MP4", "mp4",
				"WMA", "wma", "MOV", "mov", "RAR", "rar", "ZIP", "zip",
				"SQLITE", "sqlite" };
		response.setContentType("text/html");
		response.setCharacterEncoding("GB2312");

		filePath = "ImagesUpload/";
		diskDir = request.getRealPath("/");

		// instance an disk file item factory to configure ServletFileUpload
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		dfif.setSizeThreshold(4096);// 4k
		dfif.setRepository(new File(diskDir + filePath));// upload file
															// directory
															// ImagesUpload

		ServletFileUpload sfu = new ServletFileUpload(dfif);

		sfu.setSizeMax(MAX_SIZE);

		List fileList = null;
		try {
			fileList = sfu.parseRequest(request);
		} catch (FileUploadException e) {
			if (e instanceof SizeLimitExceededException) {
				// upload avatar failed
				code = -1;
				return;
			}
			e.printStackTrace();
		}
		if (fileList == null || fileList.size() == 0) {
			code = -1;
			return;
		}

		Iterator fileItr = fileList.iterator();

		while (fileItr.hasNext()) {
			FileItem fileItem = null;
			String path = null;
			long size = 0;
			fileItem = (FileItem) fileItr.next();
			if (fileItem == null || fileItem.isFormField()) {
				String fieldName = fileItem.getFieldName();

				String value = fileItem.getString();

				if (fieldName != null
						&& fieldName.equalsIgnoreCase("brandCountry")) {
					brandCountry = new String(value.getBytes("ISO-8859-1"),
							"gb2312");
				}
				if (fieldName != null
						&& fieldName.equalsIgnoreCase("brandName")) {
					brandName = new String(value.getBytes("ISO-8859-1"),
							"gb2312");
				}
				if (fieldName != null
						&& fieldName.equalsIgnoreCase("brandFirstC")) {
					brandFirstC = new String(value.getBytes("ISO-8859-1"),
							"gb2312");
				}
				continue;
			} else {
				try {
					avatar = processUploadedFile(fileItem);
					System.out.println("avataravatar" + avatar);
				} catch (Exception e) {
					code = -1;
				}
			}
		}

		String sql = "insert into carshome_brand (brand_desc,brand_icon,brand_country_id,brand_sort_c) values"
				+ "(?,?,?,?)";
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		int effectRow = 0;

		try {
			conn = ConnectionFactory.getDirectConnection();
			preparedStatement = conn.prepareStatement(sql,
					Statement.RETURN_GENERATED_KEYS);

			preparedStatement.setString(1, brandName);
			preparedStatement.setString(2, avatar);
			preparedStatement.setString(3, brandCountry);
			preparedStatement.setString(4, brandFirstC);

			preparedStatement.executeUpdate();
			rs = preparedStatement.getGeneratedKeys();
			if (rs.next()) {
				effectRow = rs.getInt(1);
			}

		} catch (Exception e) {

			System.out.println("DB Search exception : " + e.getMessage());
		}

		PrintWriter out = response.getWriter();
		out.println("文件上传成功. 已保存为: " + avatar + " &nbsp;&nbsp<p/>");

	}

	private String processUploadedFile(FileItem item) throws Exception {
		String filename = item.getName();
		int index = filename.lastIndexOf("\\");
		filename = filename.substring(index + 1, filename.length());
		// long fileSize = item.getSize();
		//
		// if(filename.equals("") && fileSize == 0) {
		// return null;
		// }

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmsss");
		String diskFile = filePath + sdf.format(new Date()) + "" + filename;

		File uploadFile = new File(diskDir + diskFile);
		item.write(uploadFile);
		// ImageUtils.reduceImg(diskDir + diskFile, diskDir + diskFile, 50, 50);
		return diskFile;
	}
}
