package org.example;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

            final String TEMPLATE = "<GroupData><name>%s</name><keyword>%s</keyword></GroupData>";

                // Проверка наличия аргумента количества записей
                if (args.length != 1) {
                    System.err.println("Использование: GenerateXmlRecords <количество записей>" + args.length);
                    System.exit(1);
                }

                // Получение количества записей
                int numRecords = Integer.parseInt(args[0]);

                // Генерация случайных данных
                Random random = new Random();
                String[] texts = {"Запись1", "Запись2", "Запись3", "Запись4", "Запись5"};
                String[] keywords = {"кс1", "кс2", "кс3", "кс4", "кс5"};

                // Запись данных в XML-файл
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("ArrayOfGroupData.xml"))) {


                    writer.write("<ArrayOfGroupData>");
                    for (int i = 0; i < numRecords; i++) {
                        // Выбор случайного текста и ключевого слова
                        String text = texts[random.nextInt(texts.length)];
                        String keyword = keywords[random.nextInt(keywords.length)];

                        // Формирование записи и запись ее в файл
                        String record = String.format(TEMPLATE, text, keyword);
                        writer.write(record);
                    }
                    writer.write("</ArrayOfGroupData>");

                }

                System.out.println("XML-файл с записями успешно сгенерирован.");
            }
        }
