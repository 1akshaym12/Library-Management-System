public class Book {
    public String bookName;
    public String bookAuthorName;
    public int ID;
    public boolean availability;

    public Book(String bookName, String bookAuthorName, int ID) {
        this.bookName = bookName;
        this.ID=ID;
        this.bookAuthorName = bookAuthorName;
        this.availability=true;
    }
    public int getId(){return ID;}
    public String getBookName(){return bookName;}
    public String getBookAuthorName(){return bookAuthorName;}

    public boolean isAvailability(){return availability;}

    public void setAvailabile(boolean availability){
        this.availability=availability;
    }

    @Override
    public String toString() {
        return "Book ID: " + ID + ", Title: " + bookName + ", Author: " + bookAuthorName + ", Available: " + availability;
    }


}
