package ePetition;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet{
	public void doGet(HttpServletRequest req,
	        HttpServletResponse res) 
        throws ServletException, IOException {

		//Logs the particular user out of the session
	HttpSession se=req.getSession();
	se.removeAttribute("User");
	res.sendRedirect("./login.jsp");
}
	public void doPost(HttpServletRequest req, 
			HttpServletResponse res) 
            throws ServletException, IOException {
	doGet(req, res);}
	
}
