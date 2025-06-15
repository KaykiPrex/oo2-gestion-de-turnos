package datos.refactor;

public class Contact {
    private int id;
    private String workEmail;
    private String personalEmail;
    private String phone;
    private String mobile;
    private User user;

    public Contact() {
    }

    public Contact(String workEmail, String personalEmail, String phone, String mobile, User user) {
        this.workEmail = workEmail;
        this.personalEmail = personalEmail;
        this.phone = phone;
        this.mobile = mobile;
        this.user = user;
    }

    public Contact(String workEmail, String personalEmail, String phone, String mobile) {
        this.workEmail = workEmail;
        this.personalEmail = personalEmail;
        this.phone = phone;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Contacto [idContact=" + id + ", workEmail=" + workEmail + ", personalEmail=" + personalEmail + ", phone=" + phone
                + ", mobile=" + mobile + "]";
    }
}
