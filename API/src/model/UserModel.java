package model;

public class UserModel {
	
	int UserId;
	
	String UserName;
	
	String UseEmail;
	
	String Password;
	
	String Role;
	
	int PhoneNumber;
	
	

	public UserModel() {
		
	}



	public UserModel(int userId, String userName, String useEmail, String password, String role, int phoneNumber) {
		super();
		UserId = userId;
		UserName = userName;
		UseEmail = useEmail;
		Password = password;
		Role = role;
		PhoneNumber = phoneNumber;
	}



	public int getUserId() {
		return UserId;
	}



	public void setUserId(int userId) {
		UserId = userId;
	}



	public String getUserName() {
		return UserName;
	}



	public void setUserName(String userName) {
		UserName = userName;
	}



	public String getUseEmail() {
		return UseEmail;
	}



	public void setUseEmail(String useEmail) {
		UseEmail = useEmail;
	}



	public String getPassword() {
		return Password;
	}



	public void setPassword(String password) {
		Password = password;
	}



	public String getRole() {
		return Role;
	}



	public void setRole(String role) {
		Role = role;
	}



	public int getPhoneNumber() {
		return PhoneNumber;
	}



	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
	
	
	

}
