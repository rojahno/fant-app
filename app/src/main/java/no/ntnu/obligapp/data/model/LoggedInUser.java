package no.ntnu.obligapp.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String name;

    private String authenticationToken;

    public LoggedInUser(String name, String authenticationToken) {

        this.name = name;
        this.authenticationToken = authenticationToken;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public void setAuthenticationToken(String authenticationToken) {
        this.authenticationToken = authenticationToken;
    }



}