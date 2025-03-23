import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Library studentsLibrary=new Library();

        while(true) {
            System.out.println("Enter your choice");
            System.out.println("1.Enter the title " + " Add ID");
            System.out.println("2. Return Book");
            System.out.println("3.Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("1.Add title");
                    String bookTitle = sc.nextLine();

                    System.out.println("Add ID");
                    int ID = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Author name");
                    String author = sc.nextLine();

                    studentsLibrary.borrowBook(bookTitle, ID, author);


                    break;

                case 2:
                    System.out.println("Return book");
                    System.out.println("Enter the book name to be written");
                    String bookName=sc.nextLine();

                    System.out.println("Enter the ID");
                    int returnId=sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter author name");
                    String authorName=sc.nextLine();


                    studentsLibrary.returnBook(bookName, returnId);
                    break;
                case 3:
                    System.out.println("3.Exit");
                    int exit = sc.nextInt();
                default:
                    System.out.println("Invalid choice");


            }
        }




    }


}
