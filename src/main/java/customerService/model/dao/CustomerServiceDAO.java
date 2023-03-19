package customerService.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import customerService.model.bean.CustomerComplaints;
public class CustomerServiceDAO {
	
	private Connection conn;

	
	public CustomerServiceDAO(Connection conn) {
		this.conn=conn;
	}

	public ArrayList<CustomerComplaints> findComplaintsById(String id) {

		try {
			String sql = "select * from [Topic].[dbo].[CustomerComplaints] where CustomerID=? ";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			ArrayList<CustomerComplaints> complaints = new ArrayList<>();
			while (rs.next()) {
				CustomerComplaints complaint = new CustomerComplaints();
				complaint.setCreateDate(rs.getString(1));
				complaint.setCustomerID(rs.getString(2));
				complaint.setCustomerName(rs.getString(3));
				complaint.setEmail(rs.getString(4));
				complaint.setComplaintID(rs.getString(5));
				complaint.setTitle(rs.getString(6));
				complaint.setContent(rs.getString(7));
				complaints.add(complaint);
			}
			rs.close();
			pstmt.close();
			return complaints;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	public ArrayList<CustomerComplaints> findComplaintsByName(String name) {

		try {
			String sql = "select * from [Topic].[dbo].[CustomerComplaints] where CustomerName like ? ";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1,name+"%");
			ResultSet rs = pstmt.executeQuery();

			ArrayList<CustomerComplaints> complaints = new ArrayList<>();
			while (rs.next()) {
				CustomerComplaints complaint = new CustomerComplaints();
				complaint.setCreateDate(rs.getString(1));
				complaint.setCustomerID(rs.getString(2));
				complaint.setCustomerName(rs.getString(3));
				complaint.setEmail(rs.getString(4));
				complaint.setComplaintID(rs.getString(5));
				complaint.setTitle(rs.getString(6));
				complaint.setContent(rs.getString(7));
				complaints.add(complaint);
			}
			rs.close();
			pstmt.close();
			return complaints;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	public ArrayList<CustomerComplaints> findComplientsByType(String type) {

		try {
			String sql = "select * from [Topic].[dbo].[CustomerComplaints] where ComplaintID=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1,type);
			ResultSet rs = pstmt.executeQuery();

			ArrayList<CustomerComplaints> complaints = new ArrayList<>();
			while (rs.next()) {
				CustomerComplaints complaint = new CustomerComplaints();
				complaint.setCreateDate(rs.getString(1));
				complaint.setCustomerID(rs.getString(2));
				complaint.setCustomerName(rs.getString(3));
				complaint.setEmail(rs.getString(4));
				complaint.setComplaintID(rs.getString(5));
				complaint.setTitle(rs.getString(6));
				complaint.setContent(rs.getString(7));
				complaints.add(complaint);
			}
			rs.close();
			pstmt.close();
			return complaints;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	public boolean createComplaint(CustomerComplaints Complaint) {
		try {
			String SQL = "INSERT INTO [Topic].[dbo].[CustomerComplaints]([CreateDate],[CustomerID],[CustomerName],[Email],[ComplaintID],[Title],[Content]) VALUES(?,?,?,?,?,?,?)";

			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,Complaint.getCreateDate());
			pstmt.setString(2,Complaint.getCustomerID());
			pstmt.setString(3,Complaint.getCustomerName());
			pstmt.setString(4,Complaint.getEmail());
			pstmt.setString(5, Complaint.getComplaintID());
			pstmt.setString(6,Complaint.getTitle());
			pstmt.setString(7,Complaint.getContent());

			pstmt.execute();
			pstmt.close();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	

}
