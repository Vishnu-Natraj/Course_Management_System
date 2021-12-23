public class Register {
    String Username;
    String Email_Address;
    String Password;
    String Confirm_Password;

    public Register(String username, String email_Address, String password, String confirm_Password) {
        Username = username;
        Email_Address = email_Address;
        Password = password;
        Confirm_Password = confirm_Password;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail_Address() {
        return Email_Address;
    }

    public void setEmail_Address(String email_Address) {
        Email_Address = email_Address;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfirm_Password() {
        return Confirm_Password;
    }

    public void setConfirm_Password(String confirm_Password) {
        Confirm_Password = confirm_Password;
    }

}
