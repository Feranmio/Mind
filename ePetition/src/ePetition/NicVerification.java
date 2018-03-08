package ePetition;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/NicVerification")
public class NicVerification extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
	res.setContentType("text/html");
	PrintWriter out = res.getWriter();
	String nic=req.getParameter("nic");

		try{
			if(nic != null && nic.length() == 8){
				int taken = UserVerification.getNic(nic);
				if(taken==0){
					out.println("Nic is available");
				}else{
					out.println("Sorry Nic has been used");
				}
			}
			if(nic==null){
				out.println("Please Input valid NIC");
			}
			if(nic!= null && nic.length() < 8 || nic.length() > 8){
				out.println("Invalid Nic detected");
			}
		}catch(Exception ex){
			System.out.println("Invalid Nic detected");
			ex.getStackTrace();
		}
		out.close();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doGet(req, res);
	}
}
