package customerService.model.bean;

import java.io.Serializable;

public class ComplaientType  implements Serializable  {


	private static final long serialVersionUID = 1L;
	
	private String ComplaintID;
	private String ComplaintName;
	private String ComplaintDiscription;
	public String getComplaintID() {
		return ComplaintID;
	}
	public void setComplaintID(String complaintID) {
		this.ComplaintID = complaintID;
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
