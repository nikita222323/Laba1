

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class ParserBook {
    public static List<String> ParseNameBook() throws IOException {
        List<String> FictionBookList = new ArrayList<>();
        try {
            String url = "https://kamen-lib.altai.muzkult.ru/100knig/";
            Document doc = Jsoup.connect(url).get();

            Elements bookElements = doc.select("span[style=font-size: 22px;]");

            for (Element bookElement : bookElements) {
                String bookInfo = bookElement.text();
                FictionBookList.add(bookInfo);
            }

            FictionBookList = FictionBookList.subList(1, FictionBookList.size());

            String anotherUrl = "https://www.rsl.ru/ru/nauka/editions/bibliography-editions/1000-school-library";
            Document anotherDoc = Jsoup.connect(anotherUrl).get();
            Elements anotherBookElements = anotherDoc.select("li");
            for (Element anotherBookElement : anotherBookElements) {
                String anotherBookInfo = anotherBookElement.text();
                FictionBookList.add(anotherBookInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FictionBookList;
    }

    public static List<String> ParseEnglishBook() throws IOException {
        List<String> EnglishBookList = new ArrayList<>();
        try {
            String url = "https://www.labirint.ru/genres/3412/";
            Document doc = Jsoup.connect(url).get();

            Elements bookElements = doc.select("span.product-title");

            for (Element bookElement : bookElements) {
                String bookInfo = bookElement.text();
                EnglishBookList.add(bookInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return EnglishBookList;
    }
}