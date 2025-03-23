import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class AdminManager {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Library library=new Library();

        while(true){
            System.out.println("LIBRARY MANAGEMENT SYSTEM");
            System.out.println("1.Add Book");
            System.out.println("2.Display Book");
            System.out.println("3. Exit");
            System.out.println("Enter your choice");

            int choice= sc.nextInt();
            switch (choice){
                case 1:
                    sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author Name: ");
                    String author = sc.nextLine();

                    System.out.println("is Book Available");


                    library.addBook(title, author);
                    break;
                case 2:
                    System.out.println("Display Books");
                    library.displayBook();
                    break;

                case 3:
                    System.out.println("Exiting....");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice re-enter again");

            }

        }

    }
}