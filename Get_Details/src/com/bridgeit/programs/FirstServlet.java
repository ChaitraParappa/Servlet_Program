package com.bridgeit.programs;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String phonenumber = req.getParameter("phonenumber");

		Connection connection = null;
		PreparedStatement preparestatement = null;

		ResultSet resultset = null;
		String firstname = null;
		String lastname = null;
		String email = null;
		String address = null;

		String query = "select * from bridgeit.employee where phonenumber=?";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=root");

			preparestatement = connection.prepareStatement(query);
			preparestatement.setString(1, phonenumber);

			resultset = preparestatement.executeQuery();

			if (resultset.next()) {
				firstname = resultset.getString(1);
				lastname = resultset.getString(2);
				email = resultset.getString(3);
				address = resultset.getString(5);
				

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		finally {
			if (resultset != null) {
				try {
					resultset.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (preparestatement != null) {
				try {
					preparestatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		PrintWriter out = resp.getWriter();
		out.println("<html><body bgcolor='#d8f4d2'> <center><br><br><h1>The Employee Details <br><br><table>"
				+ "<tr><td>FirstName: </td><td>" + firstname + "</td></tr><tr><td>LastName: </td><td>" + lastname
				+ "</td></tr><tr><td>email: </td><td>" + email + "</td></tr><tr><td>address: </td><td>" + address
				+ "</td></tr>" + "</table><br><br><h2>THANK YOU !!!!!!!!!!!!!!!!!</h2></center></body></html>");

	}

}
