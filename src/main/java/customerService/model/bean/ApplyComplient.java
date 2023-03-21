package customerService.model.bean;

import java.io.Serializable;

public class ApplyComplient implements Serializable {


	private static final long serialVersionUID = 1L;
	
	private String ApplyDate;
	private String CustomerID;
	private String QuestionDate;
	private String Content;
	
	public String getApplyDate() {
		return ApplyDate;
	}
	public void setApplyDate(String applyDate) {
		ApplyDate = applyDate;
	}
	public String getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}
	public String getQuestionDate() {
		return QuestionDate;
	}
	public void setQuestionDate(String questionDate) {
		QuestionDate = questionDate;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	
	

}
