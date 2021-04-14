package quotes;

import java.util.ArrayList;
import java.util.Objects;

public class Book {
    String author;
    String text;



    @Override
    public int hashCode() {
        return Objects.hash(author, text);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return  Objects.equals(author, book.author) && Objects.equals(text, book.text);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
