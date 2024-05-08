import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class ParserFIO {

    List<String> teacher_names = new ArrayList<>();
    List<String> teacher_surnames = new ArrayList<>();
    List<String> teacher_patronymics = new ArrayList<>();

    public List<String> getTeacherNames() {
        return teacher_names;
    }

    public List<String> getTeacherSurnames() {
        return teacher_surnames;
    }

    public List<String> getTeacherPatronymics() {
        return teacher_patronymics;
    }

    public void parseTeacherData() {
        try {
            Document document = Jsoup.connect("https://voip.mephi.ru/units/0101800").get();
            Elements links = document.select("a.cataloglink[href^=/subscribers/]");

            for (Element link : links) {
                String text = link.text();
                String[] parts = text.split(" ");

                if (parts.length >= 2) {
                    String name = parts[0];
                    String surname = parts[1];
                    String patronymic = "";

                    if (parts.length >= 3) {
                        patronymic = parts[2];
                    }

                    teacher_names.add(name);
                    teacher_surnames.add(surname);
                    teacher_patronymics.add(patronymic);
                }
            }

            System.out.println("Имена: " + teacher_names);
            System.out.println("Фамилии: " + teacher_surnames);
            System.out.println("Отчества: " + teacher_patronymics);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ParserFIO parser = new ParserFIO();
        parser.parseTeacherData();
    }
}