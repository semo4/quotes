/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.Arrays;
import java.util.Random;

public class App {

    public static void main(String[] args){

        String apiUrl = "http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en";
        String  reader ="./app/src/main/resources/recentquotes.json";
        try {
            URL url = new URL(apiUrl);
            String data = connectApi(url);
            QuotesData q = getQuotesData(data);
            System.out.println(q);
            writeJson(reader, q);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String connectApi(URL url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int status = con.getResponseCode();
        String contact = "";
        if(status == 200){
            BufferedReader reader = getBufferedReader(con);
            contact = getContent(reader);
            reader.close();
        }
        else{
            System.out.println(getBook());
        }
        con.disconnect();
        return contact;
    }

    private static BufferedReader getBufferedReader(HttpURLConnection con) throws IOException{
        return new BufferedReader(new InputStreamReader(con.getInputStream()));
    }

    private static String getContent(BufferedReader reader) throws IOException{
        StringBuilder builder = new StringBuilder();
        String line = reader.readLine();
        while(line!=null){
            builder.append(line);
            line = reader.readLine();
        }
        return builder.toString();
    }

    private static QuotesData getQuotesData(String data){
        Gson gson = new Gson();
        QuotesData q = gson.fromJson(data, QuotesData.class);
        return q;
    }

    private static Book getBook() throws FileNotFoundException{
        Gson gson = new Gson();
        Reader reader = new FileReader("./app/src/main/resources/recentquotes.json");
        Book[] b = gson.fromJson(reader, Book[].class);
        Random rand = new Random();
        int randomNum = rand.nextInt((b.length ) + 1);
        return b[randomNum];
    }

    public static void writeJson(String filename, QuotesData q) throws Exception{
        JSONObject writeObject = new JSONObject();

        JSONArray tags = new JSONArray();
        JSONArray allQouets = new JSONArray();
        Gson gson = new Gson();
        Reader reader = new FileReader("./app/src/main/resources/recentquotes.json");
        Book[] b = gson.fromJson(reader, Book[].class);
        for (int i = 0; i < b.length; i++) {
            JSONObject fileObject = new JSONObject();
            fileObject.put("author", b[i].author);
            fileObject.put("text",b[i].text);
            System.out.println(fileObject);
            allQouets.add(fileObject);
        }
//        BufferedReader reader = new BufferedReader(new FileReader(filename));
//        String line = reader.readLine();
//        while(line!=null){
//            allQouets.add(line);
//            line = reader.readLine();
//        }

        writeObject.put("author", q.quoteAuthor);
        writeObject.put("text", q.quoteText);
        allQouets.add(writeObject);
//        FileWriter w = new FileWriter(filename,true);
        Files.write(Paths.get(filename), allQouets.toJSONString().getBytes());
        System.out.println("Added to JSOn File");



    }


}
