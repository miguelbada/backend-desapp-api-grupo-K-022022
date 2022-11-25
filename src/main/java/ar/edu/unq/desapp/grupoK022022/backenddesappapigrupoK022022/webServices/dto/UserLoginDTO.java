package ar.edu.unq.desapp.grupoK022022.backenddesappapigrupoK022022.webServices.dto;

public class UserLoginDTO {
	
	public UserLoginDTO() {
		
	}
	
	public UserLoginDTO(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String userName;
	
	private String password;
	
	

}
