package exception;

public class ExceptionMessagesConstants {


    public static final String CATEGORY_NOT_FOUND = "Kategori bulunamadı.";

    private ExceptionMessagesConstants() {
    }

    public static final String CUSTOMER_EMAIL_DOES_NOT_EXIST = "Customer email does not exist.";
    public static final String CUSTOMER_PASSWORD_DOES_NOT_MATCH = "Entered email or password does not match.";
    public static final String CUSTOMER_EMAIL_ALREADY_EXISTS = "Customer email already exists.";

    public static final String USER_EMAIL_DOES_NOT_EXIST = "User email does not exist";
    public static final String USER_PASSWORD_DOES_NOT_MATCH = "Entered username or password does not match.";
    public static final String USER_EMAIL_ALREADY_EXISTS = "User email already exists.";
    public static final String USER_IS_NOT_ACTIVE = "User is not active or does not exist";

    public static final String USER_IS_NOT_ADMIN = "Giriş yapan kullanıcı admin rolüne sahip değildir.";

}
