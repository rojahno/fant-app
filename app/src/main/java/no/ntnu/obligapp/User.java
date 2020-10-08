package no.ntnu.obligapp;

public class User {
    String firstName;
    String lastName;
    String email;
    String password;
    String userId;

    public User(String firstName, String lastNAme, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastNAme;
        this.email = email;
        this.password = password;
    }
    public String getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setUserid(String userid) {
        this.userId = userid;
    }
}
