package customerService.model.bean;

import java.io.Serializable;

public class ComplaientType  implements Serializable  {


	private static final long serialVersionUID = 1L;
	
	private String complaintID;
	private String ComplaintName;
	private String ComplaintDiscription;
	public String getComplaintID() {
		return complaintID;
	}
	public void setComplaintID(String complaintID) {
		this.complaintID = complaintID;
	}
	public String getComplaintName() {
		return ComplaintName;
	}
	public void setComplaintName(String complaintName) {
		ComplaintName = complaintName;
	}
	public String getComplaintDiscription() {
		return ComplaintDiscription;
	}
	public void setComplaintDiscription(String complaintDiscription) {
		ComplaintDiscription = complaintDiscription;
	}
	
	

}
