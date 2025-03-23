import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Library {
     private Connection conn;

        public Library(){
            conn=DataConnection.getConnection();
        }
       public void addBook(String bookName, String AuthorName){
              String query="INSERT INTO book(book_title, author_name, is_available) values(?, ?, ?)";
              try{
                  PreparedStatement ptstmt=conn.prepareStatement(query);
                  ptstmt.setString(1, bookName);
                  ptstmt.setString(2, AuthorName);
                  ptstmt.setBoolean(3, true);
                  ptstmt.executeUpdate();
                  System.out.println("Book added successfully: " + bookName);
              }catch (SQLException e){
                  e.printStackTrace();
                  System.out.println("Failed to add Book");
              }

       }
       public void displayBook(){
            String query="SELECT * FROM book";
            try{
                Statement stmt=conn.createStatement();
                ResultSet res=stmt.executeQuery(query);
                while(res.next()){
                    System.out.println("Book ID " + res.getInt("book_id") + " " +
                                       "Book Title " + res.getString("book_title") + " " +
                                       "Book Author " + res.getString("author_name") + " " +
                                        "Book Available " + res.getBoolean("is_available"));
                }
            }catch (SQLException e){
                e.printStackTrace();
                System.out.println("Failed to retrive data");
            }
       }
       public void borrowBook(String title, int uniqueID, String author){
            String check="SELECT is_available FROM book WHERE book_title=? AND book_id=? AND author_name=?";
            String query="UPDATE book SET is_available=false WHERE book_title=? AND book_id=? AND author_name=? AND is_available=true";

            try {
                PreparedStatement chestmt=conn.prepareStatement(check);
                chestmt.setString(1, title);
                chestmt.setInt(2, uniqueID);
                chestmt.setString(3, author);
                ResultSet rs= chestmt.executeQuery();
                if(rs.next()) {
                    boolean status = rs.getBoolean("is_available");
                    if (!status) {
                        System.out.println("Book is already borrowed");
                        return;
                    }

                    PreparedStatement ptstmt = conn.prepareStatement(query);
                    ptstmt.setString(1, title);
                    ptstmt.setInt(2, uniqueID);
                    ptstmt.setString(3, author);
                    int update = ptstmt.executeUpdate();
                    if (update > 0) {
                        System.out.println("Book Borrowed sucessfully");
                    } else {
                        System.out.println("Book is not Borrowed");
                    }
                }else{
                    System.out.println("Book not found");
                }
            }catch (SQLException e){
                e.printStackTrace();
                System.out.println("Update is failed");
            }
       }

       public void returnBook(String bookName, int returnId){
            String query="UPDATE book SET is_available = true WHERE book_id = ? AND is_available = false;";
            try{
                PreparedStatement ptstmt=conn.prepareStatement(query);
                ptstmt.setInt(1, returnId);
                int updateRows=ptstmt.executeUpdate();
                if(updateRows>0){
                    System.out.println("Book returned sucessfully");
                }else{
                    System.out.println("Book is already returned");
                }
            }catch (SQLException e){
                e.printStackTrace();
                System.out.println("The Book return Failed");
            }
       }
}
