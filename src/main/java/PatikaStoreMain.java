import exception.ExceptionMessagesConstants;
import exception.PatikaStoreException;
import model.User;
import model.enums.Role;
import service.CustomerService;
import service.UserService;

import java.util.Scanner;

public class PatikaStoreMain {

    private static final Scanner scanner = new Scanner(System.in);
    private static final UserService userService = new UserService();

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
            } catch (PatikaStoreException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void getUserMenu() throws PatikaStoreException {


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

    private static void loginUser() throws PatikaStoreException {
        System.out.print("Kullanıcı Adı: ");
        String userName = scanner.nextLine();
        System.out.print("Şifre: ");
        String password = scanner.nextLine();

        userService.login(userName, password);

        User loggedInUser = userService.login(userName, password);

        if (loggedInUser != null && loggedInUser.getActive()) {

            getLoggedInUserMenu();

        } else {
            throw new PatikaStoreException(ExceptionMessagesConstants.USER_IS_NOT_ACTIVE);
        }
    }

    private static void getLoggedInUserMenu() {

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
}
