package quotes;

public class QuotesData {
    String quoteText;
    String quoteAuthor;

    @Override
    public String toString() {
        return "QuotesData{" +
                "quotes='" + quoteText + '\'' +
                ", author='" + quoteAuthor + '\'' +
                '}';
    }
}
