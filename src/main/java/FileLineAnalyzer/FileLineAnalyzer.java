package FileLineAnalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class LineTooLongException extends RuntimeException {
    public LineTooLongException(String message) {
        super(message);
    }
}

public class FileLineAnalyzer {
    public static void main(String[] args) {
        String path = "C:\\Users\\AEGavrilova\\AccessLogParser\\access.log";

        try (FileReader fileReader = new FileReader(path);
             BufferedReader reader = new BufferedReader(fileReader)) {

            int totalLines = 0;
            int maxLength = 0;
            int minLength = Integer.MAX_VALUE;
            String line;

            while ((line = reader.readLine()) != null) {
                totalLines++;
                int length = line.length();

                if (length > 1024) {
                    throw new LineTooLongException(
                            "Строка #" + totalLines + " превышает максимально допустимую длину (1024 символа). " +
                                    "Найдена строка длиной: " + length + " символов.");
                }

                if (length > maxLength) {
                    maxLength = length;
                }
                if (length < minLength) {
                    minLength = length;
                }
            }

            System.out.println("Общее количество строк в файле: " + totalLines);
            System.out.println("Длина самой длинной строки: " + maxLength);
            System.out.println("Длина самой короткой строки: " + (minLength == Integer.MAX_VALUE ? 0 : minLength));

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (LineTooLongException ex) {
            System.err.println("Ошибка: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
