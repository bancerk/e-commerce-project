import exception.PatikaStoreException;
import model.User;
import model.enums.Role;
import service.CustomerService;
import service.UserService;
import util.PasswordUtil;

import java.util.Scanner;

public class PatikaStoreMain {

    private static final Scanner scanner = new Scanner(System.in);

    private static final UserService userService = new UserService();


    public static void main(String[] args) {

        String choice = scanner.nextLine();

        while (true) {

            getMainMenu();





//            System.out.println("====Patika Store Hoş Geldiniz===");
//            System.out.println("1 - Müşteri Kaydı");
//            System.out.println("2 - Giriş Yap");
//            System.out.println("0 - Çıkış");

            try {
                switch (choice) {
                    case "1":
                        getUserLoginMenu();
//                        saveCustomer(scanner);
                        break;
                    case "2":
                        loginCustomer(scanner);
                        break;
                    case "0":
                        System.out.println("Çıkış yapılıyor...");
                        return;
                    default:
                        System.out.println("Geçersiz Seçim!");
                }
            }catch (PatikaStoreException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void getUserLoginMenu() {
        while(true) {
            System.out.println("==== KULLANICI GİRİŞ PANELİ ===");
            System.out.println("1 - Kullanıcı Kayıt Ol");
            System.out.println("1 - Kullanıcı Girişi");
            System.out.println("0 - Geri Dön");
            System.out.print("Seçim yapınız: ");

            switch (choice){
                case "1":
                    registerUser();
                    break;
                case "2":
                    loginUser();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Geçersiz Seçim!");
            }
        }
    }

    private static void loginUser() {
        System.out.print("Kullanıcı Adı: ");
        String userName = scanner.nextLine();
        System.out.print("Şifre: ");
        String password = scanner.nextLine();
        System.out.print("Rol seçiniz: ADMIN-SUPPORT");
        String roleString = scanner.nextLine().toUpperCase();

        Role role = Role.valueOf(roleString);
        User user = new User(userName, PasswordUtil.hash(password),role);
    }

    private static void registerUser() {

    }

    private static void getMainMenu() {
        System.out.println("==== GİRİŞ TÜRÜ SEÇİN ===");
        System.out.println("1 - Kullanıcı Girişi (ADMIN,SUPPORT)");
        System.out.println("1 - Müşteri Girişi");
        System.out.println("0 - Çıkış");
        System.out.print("Seçim yapınız: ");
    }

    private static void loginCustomer(Scanner scanner) throws PatikaStoreException {
        System.out.print("Email: ");
        String email = PatikaStoreMain.scanner.nextLine();
        System.out.println("Şifre: ");
        String password = PatikaStoreMain.scanner.nextLine();

        CustomerService customerService = new CustomerService();
        customerService.login(email,password);
    }

    private static void saveCustomer() throws PatikaStoreException {
        System.out.print("İsim: ");
        String name = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.println("Şifre: ");
        String password = scanner.nextLine();

        CustomerService customerService = new CustomerService();
        customerService.save(name, email, password);
    }
}
