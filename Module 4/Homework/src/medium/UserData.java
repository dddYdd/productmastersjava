package medium;

public class UserData {
    private final int UserId;
    private final String UserName;
    private final String UserEmail;

    public UserData(int userId, String userName, String userEmail) {
        this.UserId = userId;
        this.UserName = userName;
        this.UserEmail = userEmail;
    }

    public String toString() {
        return "UserId is " + UserId + ", UserName is " + UserName + ", UserEmal is" + UserEmail;
    }
}
