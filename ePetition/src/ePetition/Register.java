package ePetition;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Register")
public class Register extends HttpServlet{
	
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
	
	//Retrieves "name" "email" "dob" "address" "pass" "nic"
	String fullname=req.getParameter("name");
	String emailAddress=req.getParameter("email");
	String dateOfBirth=req.getParameter("dob");
	String fulladdress=req.getParameter("address");
	String password=HashGenerator.getSHA256(req.getParameter("pass"));
	String nid=req.getParameter("nic");
	
		try{
			//Database connection
			Class.forName("com.mysql.jdbc.Driver");
			String conString="jdbc:mysql://"+host+"/"+database;
			connect=DriverManager.getConnection(conString, username, DBpassword);
			
			//Checks if the user inputs an NIC that has not been used
			String NIC= "SELECT * FROM NIC_RECORDS WHERE NIC=? AND USED=0";
			PreparedStatement ps = connect.prepareStatement(NIC);
			ps.setString(1, nid);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				int position = Integer.parseInt(rs.getString("MP"));
				if(position == 0){
					position = 0;
				}else{
					position = 1;
				}
			
			//Creates a new user in the database
			String sql="INSERT INTO USER (NIC, FullName, DateOfBirth, PasswordHash, FullAddress, Email, Position) values(?,?,?,?,?,?,?)";
			System.out.println(sql);
			PreparedStatement stmt = connect.prepareStatement(sql);
			stmt.setString(1, nid);
			stmt.setString(2, fullname);
			stmt.setString(3, dateOfBirth);
			stmt.setString(4, password);
			stmt.setString(5, fulladdress);
			stmt.setString(6, emailAddress);
			stmt.setInt(7, position);
			stmt.executeUpdate();
			
			//Updates the used Nic's
			int number=1;
			sql ="UPDATE NIC_RECORDS SET USED=? WHERE NIC=?";
			stmt=connect.prepareStatement(sql);
			stmt.setInt(1, number);
			stmt.setString(2, nid);
			stmt.executeUpdate();
			}
		}catch(Exception ex){
			System.out.println(ex.toString());
			ex.getStackTrace();
		}
		res.sendRedirect("./index.jsp");
	}

}
