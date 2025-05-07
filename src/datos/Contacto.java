package datos;

public class Contacto {
	private long id;
	private String email;
	private String phone;
	private String mobile;
	
	public Contacto() {
	}

	public Contacto(String email, String telephone, String mobile) {
		this.email = email;
		this.phone = telephone;
		this.mobile = mobile;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
}
