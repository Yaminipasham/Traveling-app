import java.io.File;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TravelApp1 {

   // private static final String LOGO_PATH = "path/to/logo.png"; 
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, User> users = new HashMap<>();

    public static void main(String[] args) {
    //    displayLogo();
        showMenu();
    }

   // private static void displayLogo() {
     //   System.out.println("Displaying Company Logo...");

     
     //   File logoFile = new File(LOGO_PATH);
       // if (logoFile.exists()) {
         //   System.out.println("Logo loaded successfully!");
        //} else {
          //  System.out.println("Failed to load logo. Exiting...");
           // System.exit(0);
        //}
    //}

    private static void showMenu() {
        while (true) {
            System.out.println("\nMenu Options:");
            System.out.println("1. New Admin User Registration");
            System.out.println("2. Lock Account");
            System.out.println("3. Plan Journey");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    registerAdminUser();
                    break;
                case 2:
                    lockAccount();
                    break;
                case 3:
                    planJourney();
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

  private static void registerAdminUser() {
    System.out.println("New Admin User Registration");
    System.out.print("Enter first name: ");
    String firstName = scanner.next();
    System.out.print("Enter last name: ");
    String lastName = scanner.next();
    System.out.print("Enter mobile number: ");
    String mobileNumber = scanner.next();
    System.out.print("Enter gender: ");
    String gender = scanner.next();
    System.out.print("Enter email: ");
    String email = scanner.next();
    System.out.print("Enter password: ");
    String password = scanner.next();

    

    System.out.println("Admin user registered successfully!");
}


   private static void lockAccount() {
    System.out.println("Locking Account");
    System.out.print("Enter user email: ");
    String userEmail = scanner.next();

    User user = users.get(userEmail);
    if (user != null) {

        if (user.failedCount >= 5) {
            user.accountStatus = "LOCKED";
            System.out.println("Account locked due to multiple failed logins.");
        } else {
            System.out.println("Account not locked. Continue with other actions.");
        }
    } else {
        System.out.println("User not found. Please try again.");
    }
}


    private static void planJourney() {
        
    }

   
   public class User {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String gender;
    private String email;
    private String password;
    private int failedCount = 0;
    private String accountStatus = "ACTIVE";

    // Constructor
    public User(String firstName, String lastName, String mobileNumber, String gender, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.gender = gender;
        this.email = email;
        this.password = password;
    }

    // Getter methods
    public String getEmail() {
        return email;
    }

    public int getFailedCount() {
        return failedCount;
    }

    public void setAccountStatus(String status) {
        this.accountStatus = status;
    }
}

}
