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
import customerService.model.bean.CustomerComplaints;
import customerService.model.dao.CustomerServiceDAO;

@WebServlet("/InsertComplient")
public class InsertComplient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public InsertComplient() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    Connection conn= ConnectionFactory.getConnection();
    
    CustomerServiceDAO cs=new CustomerServiceDAO(conn);
    
    SimpleDateFormat ft = new SimpleDateFormat ( "yyyy-MM-dd hh:mm:ss" ) ;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CustomerComplaints Complaint=new CustomerComplaints();
		
		Date now=new Date();	  
		String ftString = ft.format(now).toString();  
		System.out.print(ftString);
		
		Complaint.setCreateDate(ftString);
		Complaint.setCustomerID("1");
		Complaint.setCustomerName(request.getParameter("customerName"));
		Complaint.setEmail(request.getParameter("email"));
		Complaint.setComplaintID(request.getParameter("complaintID"));
		Complaint.setTitle(request.getParameter("title"));
		Complaint.setContent(request.getParameter("content"));
		
		cs.createComplaint(Complaint);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
