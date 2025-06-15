package datos.refactor;

public class User {
    private int id;
    private String username;
    private String password;
    private Contact contact;

    public User() {
    }

    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }

    public User(String username, String password, Contact contact) {
        this.username = username;
        this.password = password;
        this.contact = contact;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Usuario [idUsuario=" + id + ", username=" + username + ", password=" + password + ", contact="+contact+ "]";
    }
}
