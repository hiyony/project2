package omikuji;

//import javax.servlet.http.HttpServletRequest;

//import org.apache.struts.action.ActionErrors;
//import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;


public class InputForm extends ActionForm{
	private String birthday = "";
	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getBirthday() {
		return birthday;
	}
	
//	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
//		ActionErrors error = new ActionErrors();
//		
//		return error;
//	}
}
