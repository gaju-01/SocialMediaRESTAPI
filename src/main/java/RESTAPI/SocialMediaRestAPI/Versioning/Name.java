package RESTAPI.SocialMediaRestAPI.Versioning;

public class Name {
    private String lastName;
    private String firstName;

    public Name(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        return "Name: firstName= " + this.firstName + " lastName= " + this.lastName;
    }
}
