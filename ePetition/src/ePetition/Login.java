package ePetition;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

			//Retrieves "email" "pass" from front-end
			PrintWriter out = res.getWriter();	
			String email=req.getParameter("email");
			String pass=req.getParameter("pass");

			//checks if the user logging in exists in the database
			UserVerification dbOperator=new UserVerification();
			User u = dbOperator.checkUser(email, pass);
			HttpSession se=req.getSession();

			if(u!=null){
				se.setAttribute("User",u);
				res.sendRedirect("./home.jsp");
			}else{
				res.sendRedirect("./error.jsp?errorid=1");
			}
			out.close();
	}
	public void doPost(HttpServletRequest req,	HttpServletResponse res) 
			throws ServletException, IOException {
				doGet(req, res);}
}
