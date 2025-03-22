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
            String query="UPDATE book SET is_available=false AND is_available=true";
            try {
                PreparedStatement ptstmt=conn.prepareStatement(query);
                int update=ptstmt.executeUpdate();
                if(update>0){
                    System.out.println("Book Borrowed sucessfully");
                }else{
                    System.out.println("Book is not Borrowed");
                }
            }catch (SQLException e){
                e.printStackTrace();
                System.out.println("Update is failed");
            }
       }

       public void returnBook(String bookName, int returnId){
            String query="String query = UPDATE book SET is_availability = true WHERE id = ? AND is_availability = false;";
            try{
                PreparedStatement ptstmt=conn.prepareStatement(query);
                ptstmt.setInt(1, returnId);
                int updateRows=ptstmt.executeUpdate();
                if(updateRows>0){
                    System.out.println("Book returned sucessfully");
                }else{
                    System.out.println("Book is not returned");
                }
            }catch (SQLException e){
                e.printStackTrace();
                System.out.println("The Book return Failed");
            }
       }
}
