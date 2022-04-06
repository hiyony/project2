package omikuji;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

@WebServlet("/input.do")

public class ActionInput extends Action{
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	protected ActionForward doGet(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		return execute(mapping, form, request, response);
	}
	
	protected void doPost(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("text/html; charset = UTF-8");
		
		InputForm inputform = (InputForm)form;
		String birthday = inputform.getBirthday();
		request.setAttribute("birthday", birthday);
		Boolean checkbday = Checkbirthday.checkbday(birthday);
		Boolean flag;
		
		if(checkbday.equals(true)) {
			RequestDispatcher rd = request.getRequestDispatcher("result.do");
			try {
				rd.forward(request, response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (checkbday.equals(false)){
			flag = false;
			request.setAttribute("flag", flag);
			execute(mapping, form, request, response);
			flag = true;
		}
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception{
		return (mapping.findForward("omkjinput"));
	}

}
