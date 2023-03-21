package customerService.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import ConnectionFactory.ConnectionFactory;
import customerService.model.bean.ApplyComplient;
import customerService.model.dao.CustomerServiceDAO;

@WebServlet("/ApplyComplients")
public class ApplyComplients extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ApplyComplients() {
		super();

	}

	Connection conn = ConnectionFactory.getConnection();

	CustomerServiceDAO cs = new CustomerServiceDAO(conn);

	SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ApplyComplient appcomplient=new ApplyComplient();
		Date now=new Date();	  
		
		String ftString = ft.format(now).toString();  

		
		appcomplient.setApplyDate(ftString);
		appcomplient.setCustomerID("1");
		appcomplient.setQuestionDate(request.getParameter("createDate"));
		appcomplient.setContent(request.getParameter("apply"));
		
		 cs.createApply(appcomplient);
		 
		 response.sendRedirect("SelectComplient.jsp");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
