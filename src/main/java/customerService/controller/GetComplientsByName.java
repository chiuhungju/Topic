package customerService.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ConnectionFactory.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import customerService.model.bean.CustomerComplaints;
import customerService.model.dao.CustomerServiceDAO;

@WebServlet("/GetComplientsByName")
public class GetComplientsByName extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public GetComplientsByName() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Connection conn = ConnectionFactory.getConnection();
			CustomerServiceDAO cs = new CustomerServiceDAO(conn);
			String name = request.getParameter("name");

			ArrayList<CustomerComplaints> Complients = cs.findComplaintsByName(name);
			request.setAttribute("Complients", Complients);
			request.getRequestDispatcher("SelectComplient.jsp").forward(request, response);

			conn.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException("uncaught", e);
//			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}