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

@WebServlet("/NewPetition")
public class NewPetition extends HttpServlet{

	//Initialize database information
	private static Connection connect = null;
	private static String host="mysql.mcscw3.le.ac.uk";
	private static String database="odo6";
	private static String username="odo6";
	private static String DBpassword="usaigaid";
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException {
	res.getContentType();
	PrintWriter out = res.getWriter();
	
	//Retrieve "id" "petition" "description" "date" "creator" from front-end
	String id=req.getParameter("id");
	String petition=req.getParameter("petition");
	String desc=req.getParameter("description");
	String date=req.getParameter("date");
	String creator=req.getParameter("creator");


		try{
			//Database connection
			Class.forName("com.mysql.jdbc.Driver");
			String conString="jdbc:mysql://"+host+"/"+database;
			connect=DriverManager.getConnection(conString, username, DBpassword);
			
			//Creates a new petition in the Petition table
			String sql="INSERT INTO PETITIONS (ID, TITLE, CONTENT, DATE, CREATOR) values(?,?,?,?,?)";
			System.out.println(sql);
			PreparedStatement stmt = connect.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, petition);
			stmt.setString(3, desc);
			stmt.setString(4, date);
			stmt.setString(5, creator);

			stmt.executeUpdate();
		}catch(Exception ex){
			System.out.println(ex.toString());
			ex.getStackTrace();
		}
		res.sendRedirect("./ViewPetitions.jsp");
	}

}
