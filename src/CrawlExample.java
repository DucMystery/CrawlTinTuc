import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CrawlExample {


    public static void main(String[] args) throws IOException {

        try {
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");
            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");
            String content = scanner.next();
            scanner.close();
            content=content.replace("\\n+","");
            Pattern pattern = Pattern.compile("<a title=\"(.*?)\" href=\"(.*?)</a>");
            Matcher matcher = pattern.matcher(content);
            FileWriter writer = new FileWriter(new File("test1"));
            BufferedWriter bwf = new BufferedWriter(writer);
            while (matcher.find()){
                System.out.println(matcher.group(1));
                String downLine ="\n";
                bwf.write(matcher.group(1));
                bwf.write(downLine);

            }
            bwf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void save(String str) throws IOException {
       FileWriter writer = new FileWriter(new File("test1"));
       BufferedWriter bwf = new BufferedWriter(writer);
       String downLine ="\n";
       bwf.write(str);
       bwf.write(downLine);
       bwf.close();

    }
}
