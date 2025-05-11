import exception.ExceptionMessagesConstants;
import exception.PatikaStoreException;
import model.Category;
import model.Product;
import model.User;
import model.enums.Role;
import service.CategoryService;
import service.CustomerService;
import service.ProductService;
import service.UserService;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class PatikaStoreMain {

    private static final Scanner scanner = new Scanner(System.in);
    private static final UserService userService = new UserService();
    private static final CategoryService categoryService = new CategoryService();
    private static final CustomerService customerService = new CustomerService();
    private static final ProductService productService = new ProductService();
    private static User LOGGED_IN_USER;

    public static void main(String[] args) {

        while (true) {

            getMainMenu();

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        getUserMenu();
                        break;
                    case "2":
                        getCustomerMenu();
                        break;
                    case "0":
                        System.out.println("Çıkış yapılıyor...");
                        return;
                    default:
                        System.out.println("Geçersiz Seçim!");
                }
            } catch (PatikaStoreException | SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void getUserMenu() throws PatikaStoreException, SQLException {


        while (true) {

            System.out.println("==== KULLANICI GİRİŞ PANELİ ===");
            System.out.println("1 - Kullanıcı Kayıt Ol");
            System.out.println("2 - Kullanıcı Girişi");
            System.out.println("0 - Geri Dön");
            System.out.print("Seçim yapınız: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    registerUser();
                    break;
                case "2":
                    loginUser();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Geçersiz Seçim!");
            }
        }
    }

    private static void loginUser() throws PatikaStoreException, SQLException {
        System.out.print("Kullanıcı Adı: ");
        String userName = scanner.nextLine();
        System.out.print("Şifre: ");
        String password = scanner.nextLine();

        userService.login(userName, password);

        User loggedInUser = userService.login(userName, password);

        if (loggedInUser != null && loggedInUser.getActive()) {

            LOGGED_IN_USER = loggedInUser;

            getLoggedInUserMenu();

        } else {
            throw new PatikaStoreException(ExceptionMessagesConstants.USER_IS_NOT_ACTIVE);
        }
    }

    private static void getLoggedInUserMenu() throws PatikaStoreException, SQLException {

        while (true) {
            System.out.println("==== LOGIN OLAN KULLANICI MENUSU ===");
            System.out.println("1 - Kategori Oluştur");
            System.out.println("2 - Kategori Listele");
            System.out.println("3 - Kategori Sil");
            System.out.println("4 - Ürün Oluştur");
            System.out.println("5 - Ürün Listele");
            System.out.println("6 - Ürün Sil");
            System.out.println("7 - Siparişleri Listele");
            System.out.println("0 - Geri Dön");
            System.out.print("Seçim yapınız: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    createCategory();
                    break;
                case "2":
                    listCategory();
                    break;
                case "3":
                    deleteCategory();
                    break;
                case "4":
                    createProduct();
                    break;
                case "5":
                    listProduct();
                    break;
                case "6":
                    deleteProduct();
                    break;
                case "7":
                    listOrders();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Geçersiz Seçim !");
            }
        }
    }

    private static void deleteProduct() {
        System.out.println("Silinecek Ürün ID giriniz:");
        String productId = scanner.nextLine();

        productService.deleteById(Long.parseLong(productId));
    }

    private static void listProduct() throws SQLException {
        List<Product> products = productService.getAll();
        System.out.println("\n==== ÜRÜN LİSTESİ ====");
        products.forEach(product ->
                System.out.printf("%s : %s : %s\n", product.getName(), product.getPrice(), product.getCategory().getCategoryName())
        );
        System.out.println("======");

    }

    private static void deleteCategory() {
        while (true) {
            System.out.println("Kategori id giriniz:");
            String categoryId = scanner.nextLine();

            categoryService.deleteById(Long.parseLong(categoryId));
        }
    }

    private static void listCategory() {
        List<Category> categoryList = categoryService.getAll();
        categoryList.forEach(System.out::println);
    }

    private static void createCategory() throws PatikaStoreException {
        throw new PatikaStoreException("Not Implemented");
    }

    private static void registerUser() throws PatikaStoreException {
        System.out.print("Kullanıcı Adı: ");
        String userName = scanner.nextLine();
        System.out.print("Şifre: ");
        String password = scanner.nextLine();
        System.out.print("Rol seçiniz: ADMIN-SUPPORT");
        String roleString = scanner.nextLine().toUpperCase();

        Role role = Role.valueOf(roleString);

        userService.save(userName, password, role);

    }

    private static void getMainMenu() {
        System.out.println("==== GİRİŞ TÜRÜ SEÇİN ===");
        System.out.println("1 - Kullanıcı Girişi (ADMIN,SUPPORT)");
        System.out.println("2 - Müşteri Girişi");
        System.out.println("0 - Çıkış");
        System.out.print("Seçim yapınız: ");
    }

    private static void getCustomerMenu() throws PatikaStoreException {

        while (true) {

            System.out.println("==== MÜŞTERİ GİRİŞ PANELİ ===");
            System.out.println("1 - Müşteri Kayıt Ol");
            System.out.println("2 - Müşteri Girişi");
            System.out.println("0 - Geri Dön");
            System.out.print("Seçim yapınız: ");

            String choice = scanner.nextLine();


            switch (choice) {
                case "1":
                    registerCustomer();
                    break;
                case "2":
                    loginCustomer();
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Geçersiz Seçim!");
            }
        }
    }

    private static void loginCustomer() throws PatikaStoreException {
        System.out.print("Müşteri Adı: ");
        String userName = scanner.nextLine();
        System.out.print("Şifre: ");
        String password = scanner.nextLine();

        CustomerService customerService = new CustomerService();
        customerService.login(userName, password);
    }

    private static void registerCustomer() throws PatikaStoreException {

        System.out.print("İsim: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Şifre: ");
        String password = scanner.nextLine();

        CustomerService customerService = new CustomerService();
        customerService.save(name, email, password);
    }

    private static void createProduct() throws PatikaStoreException {

        System.out.println("Ürün ismi giriniz:");
        String productName = scanner.nextLine();
        System.out.println("Ürün fiyatını giriniz:");
        String productPrice = scanner.nextLine();
        System.out.println("Ürün stok bilgisini giriniz:");
        String stock = scanner.nextLine();
        System.out.println("Kategori id giriniz:");
        String productCategoryId = scanner.nextLine();

        Category category = categoryService.getById(Long.parseLong(productCategoryId));


        Product product = new Product(productName, new BigDecimal(productPrice), Integer.parseInt(stock), category);

        productService.save(product, LOGGED_IN_USER);

    }
}
