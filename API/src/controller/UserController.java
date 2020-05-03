package controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

import dbcon.DBConnection;
import model.UserModel;

public class UserController {
	
	Connection con = null;
	ArrayList<UserModel> userList = new ArrayList<UserModel>();
	public UserController() {
		con = DBConnection.connection();
	}
	
	public String InserUser(UserModel user) {
		
		String output = "";
		try {
		if(con == null) {
			
			return "Erro while Connecting to the databse for insering Please check your Database Connection";
		}
		
		
		String query = "INSERT INTO user(USER_ID,USER_NAME,USER_EMAIL,PASSWORD,ROLE,PHONE_NUMBER)VALUES(?,?,?,?,?,?)";
		
		PreparedStatement statment = con.prepareStatement(query);
		
		statment.setInt(1, user.getUserId());
		statment.setString(2, user.getUserName());
		statment.setString(3, user.getUseEmail());
		statment.setString(4, user.getPassword());
		statment.setString(5, user.getRole());
		statment.setInt(6, user.getPhoneNumber());
		
		statment.execute();
		con.close();
		
		output = "User Insert Sucess";
		
		
		}catch (Exception e) {
			
			output = "Erro while Inserting to Databse";
			System.err.println(e.getMessage());
			
		}
		
		return output;
		
	}
	
	public ArrayList<UserModel> readAllUsers(){
		
		try {
			
			if (con == null) {
				System.err.println(
						"Erro while Connecting to the databse for insering Please check your Database Connection");
			}
			
			String query = "SELECT USER_ID,USER_NAME,USER_EMAIL,PASSWORD,ROLE,PHONE_NUMBER FROM user";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			
			while (rs.next()) {
				
				UserModel user = new UserModel();
				
				user.setUserId(rs.getInt("USER_ID"));
				user.setUserName(rs.getString("USER_NAME"));
				user.setUseEmail(rs.getString("USER_EMAIL"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setRole(rs.getString("ROLE"));
				user.setPhoneNumber(rs.getInt("PHONE_NUMBER"));
				
				userList.add(user);		
				
			}
			
			con.close();
		}catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("View All User Sucess");
		return userList;
		
	}
	
	
	public String UpdateUser(UserModel user) {
		
		
		String Output = "";
		try {
			
			if (con == null) {
				
				return "Erro while Connecting to the databse for insering Please check your Database Connection";
			}
			
			String query = "UPDATE user SET USER_ID = ?, USER_NAME = ?, USER_EMAIL = ?, PASSWORD  =  ?,  ROLE  = ? , PHONE_NUMBER = ?   WHERE USER_ID = ?";
			
			PreparedStatement statment = con.prepareStatement(query);
			
			statment.setInt(1, user.getUserId());
			statment.setString(2, user.getUserName());
			statment.setString(3, user.getUseEmail());
			statment.setString(4, user.getPassword());
			statment.setString(5, user.getRole());
			statment.setInt(6, user.getPhoneNumber());
			
			statment.execute();
			Output = "Update Sucessful";
			con.close();		
			
			
		}catch (Exception e) {
			Output = "Error while updating Sensore.";
			System.err.println(e.getMessage());
		}
		return Output;
		
	}
	

public String DeleteUser(int UserID) {
		
String output="";
		
		try {
			
			if (con == null) {
				return "Erro while Connecting to the databse for Deleting Please check your Database Connection";
			}
			
			String query = "DELETE FROM user WHERE USER_ID = ? ";
			PreparedStatement statement = con.prepareStatement(query);
			
			statement.setInt(1, UserID);
			
			statement.execute();
			con.close();
			
			output = "Delete Sucess";
			
			
		}catch (Exception e) {
			
			output = "Error while deleting the item.";
			System.err.println(e.getMessage());
			
		}
		
		
		return output;
	}


public String LogIn(String UserName , String Password) {
	
	String Output = "";
	
	try {
		
		if (con == null) {
			return "Erro while Connecting to the databse for Deleting Please check your Database Connection";
		}
		
		String query ="SELECT USER_ID,USER_NAME,USER_EMAIL,PASSWORD,ROLE,PHONE_NUMBER FROM user WHERE USER_NAME = ? AND PASSWORD = ? ";
		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, UserName);
		statement.setString(2, Password);
		
		ResultSet rs = statement.executeQuery(query);
		
		if(rs != null) {
			Output =  "Registerd User";
		}
		else {
			Output = "Invalid User";
		}
		
	}catch (Exception e) {
		
		Output = "Error while deleting the item.";
		System.err.println(e.getMessage());
		
	}
	return Output;
	
	
}
	
	

}
