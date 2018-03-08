package ePetition;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EditPetition")
public class EditPetition extends HttpServlet{
	
	//Initialize database information
	private static Connection connect = null;
	private static String host="mysql.mcscw3.le.ac.uk";
	private static String database="odo6";
	private static String username="odo6";
	private static String DBpassword="usaigaid";
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
	res.setContentType("/text/html");
	PrintWriter out = res.getWriter();
	
	//Retrieves "id" "petition" "description"
	String id=req.getParameter("id");
	String petition=req.getParameter("petition");
	String desc=req.getParameter("description");

		try{
			//Database connection
			Class.forName("com.mysql.jdbc.Driver");
			String conString="jdbc:mysql://"+host+"/"+database;
			connect=DriverManager.getConnection(conString, username, DBpassword);
			String sql="UPDATE PETITIONS SET TITLE=?, CONTENT=? WHERE ID=?";
			System.out.println(sql);
			PreparedStatement stmt = connect.prepareStatement(sql);
			stmt.setString(3, id);
			stmt.setString(1, petition);
			stmt.setString(2, desc);
			stmt.executeUpdate();
		}catch(Exception ex){
			
			System.out.println(ex.toString());
			ex.getStackTrace();
		}
		res.sendRedirect("./ViewPetitions.jsp");
	}
}

