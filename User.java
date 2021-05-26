package Module2_OOP.ExtraTasks.Lesson4.E_ticket;

public class User {
    private String firstName;
    private String secondName;
    private String eMail;
    private String password;
    private String passportInfo;

    public User(String firstName, String secondName, String eMail, String password, String passportInfo) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.eMail = eMail;
        this.password = password;
        this.passportInfo = passportInfo;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassportInfo() {
        return passportInfo;
    }

    public void setPassportInfo(String passportInfo) {
        this.passportInfo = passportInfo;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                ", passportInfo='" + passportInfo + '\'' +
                '}';
    }
}
