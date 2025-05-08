package dao.constants;

public class SqlScriptConstants {

    public static final String CUSTOMER_EXIST_BY_EMAIL = """
            SELECT * FROM customer WHERE email = ?;
            """;
    public static final String CUSTOMER_SAVE = """
            INSERT INTO customer(name,email,password) VALUES(?,?,?);
            """;
    public static final String CUSTOMER_FIND_BY_ID = """
            SELECT * FROM customer WHERE id = ?;
            """;
    public static final String CUSTOMER_FIND_ALL = """
            SELECT * FROM customer;
            """;

    private SqlScriptConstants() {
    }
}
