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

    public static final String ORDER_SAVE = """
            INSERT INTO "order" (customer_id,order_date,order_total_amount)
            VALUES (?,?,?);
            """;

    public static final String PAYMENT_SAVE = """
            INSERT INTO payment (order_id, payment_method, payment_amount)
            VALUES (?,?,?);
            """;

    public static final String PRODUCT_SEARCH_BY_NAME = """
            SELECT * FROM product WHERE name LIKE ?;
            """;

    public static final String PRODUCT_SAVE = """
            INSERT INTO product (name,price,stock,category_id,created_by,updated_by)
            VALUES (?,?,?,?,?,?)
            """;


    public static final String USER_SAVE = """
            INSERT INTO users (username, password, role, active)
            VALUES (?,?,?,?);
            """;

    public static final String USER_FIND_BY_NAME = """
            SELECT * FROM users WHERE username = ?;
            """;
    public static final String CATEGORY_SAVE = """
            INSERT INTO category (name,created_by, updated_by);
            VALUES (?,?,?);
            """;
    public static final String CATEGORY_DELETE = """
            DELETE FROM category WHERE id = ?;
            VALUES (?);
            """;
    public static final String CATEGORY_FIND_BY_ID = """
            SELECT * FROM category WHERE id = ?;
            VALUES (?);
            """;

    private SqlScriptConstants() {
    }
}
