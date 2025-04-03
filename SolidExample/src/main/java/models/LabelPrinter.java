package models;

public class LabelPrinter {
   public void print(Book book){
       System.out.println("[Label] " + book.getTitle() + "-" + book.getAuthor());
   }
}
