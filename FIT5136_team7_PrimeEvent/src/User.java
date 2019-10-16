enum userType{
	customer, owner, admin, nan
}

public class User {
	protected String name;
	protected String adress;
	protected String phone;
	protected String email;
	protected String username;
	protected String password;
	protected userType type;
	
	
	public User(userType type, String name, String adress, String phone, String email, String username, String password)
    {
        // initialise instance variables
		this.type = type;
		this.name = name;
		this.adress = adress;
		this.phone = phone;
		this.email = email;
		this.username = username;
		this.password = password;
    }
	
	public userType getType() {
		return type;
	}
	
	public String getName() {
		return name;
	}
	public String getAdress() {
		return adress;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
