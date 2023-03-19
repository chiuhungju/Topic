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

@WebServlet("/GetComplientsByType")
public class GetComplientsByType extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public GetComplientsByType() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Connection conn = ConnectionFactory.getConnection();
			CustomerServiceDAO cs = new CustomerServiceDAO(conn);
			String complaintID = request.getParameter("complaintID");

			ArrayList<CustomerComplaints> Complients = cs.findComplientsByType(complaintID);
			request.setAttribute("Complients", Complients);
			request.getRequestDispatcher("GetComplientsByID.jsp").forward(request, response);

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