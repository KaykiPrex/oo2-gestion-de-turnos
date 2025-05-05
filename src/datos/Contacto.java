package datos;

public class Contacto {
	private String email;
	private String telephone;
	private String mobile;
	
	public Contacto() {
	}

	public Contacto(String email, String telephone, String mobile) {
		this.email = email;
		this.telephone = telephone;
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	
}
