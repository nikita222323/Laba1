import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {
    public static List<String> ReadExcel(String filePath) {
        List<String> dataList = null;
        try {
            // Указываем путь к Excel-файлу
            FileInputStream file = new FileInputStream(new File(filePath));

            // Создаем объект рабочей книги
            Workbook workbook = WorkbookFactory.create(file);

            // Получаем первый лист в книге
            Sheet sheet = workbook.getSheetAt(0);

            // Создаем список для хранения данных из Excel
            dataList = new ArrayList<>();

            // Получаем итератор по строкам
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                // Получаем итератор по ячейкам в текущей строке
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    dataList.add(cell.getStringCellValue());

                }
            }

            // Закрываем поток файла
            file.close();

            // Выводим   список данных из Excel


        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataList;
    }

}