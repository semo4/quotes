/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Random;

import static org.junit.Assert.*;

public class AppTest {
    @Test
    public void testAppHasAGreeting() throws FileNotFoundException {
        Gson gson = new Gson();
        Reader reader = new FileReader("./src/main/resources/recentquotes.json");
        Book[] b = gson.fromJson(reader, Book[].class);
        Random rand = new Random();
        int randomNum = rand.nextInt((b.length ) + 1);
        String exepacted = gson.toJson(b[randomNum]);
        assertEquals("the output is ",exepacted,gson.toJson(b[randomNum]));

    }
}
