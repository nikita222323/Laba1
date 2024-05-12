import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ParserBook {
    public static List<String> ParseNameBook(String[] args) {
        List<String> FictionBookList = null;
        try {
            String url = "https://kamen-lib.altai.muzkult.ru/100knig/";
            Document doc = Jsoup.connect(url).get();

            Elements bookElements = doc.select("span[style=font-size: 22px;]");

            FictionBookList = new ArrayList<>();
            for (Element bookElement : bookElements) {
                String bookInfo = bookElement.text();
                FictionBookList.add(bookInfo);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
        FictionBookList = FictionBookList.subList(1, FictionBookList.size());
        return FictionBookList;

    }
    public static void main(String[] args) {
        ParserBook parser = new ParserBook();
        parser.ParseNameBook(args);
        System.out.println(Arrays.toString(parser.ParseNameBook(args).toArray()));
    }
}