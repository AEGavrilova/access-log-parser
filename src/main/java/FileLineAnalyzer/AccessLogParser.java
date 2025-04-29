package FileLineAnalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class LineTooLongException extends RuntimeException {
    public LineTooLongException(String message) {
        super(message);
    }
}

public class AccessLogParser {
    public static void main(String[] args) {
        String path = "C:\\Users\\AEGavrilova\\AccessLogParser\\access.log";

        try (FileReader fileReader = new FileReader(path);
             BufferedReader reader = new BufferedReader(fileReader)) {

            int totalLines = 0;
            int googlebotCount = 0;
            int yandexBotCount = 0;
            String line;

            while ((line = reader.readLine()) != null) {
                totalLines++;

                if (line.length() > 1024) {
                    throw new LineTooLongException(
                            "Строка #" + totalLines + " превышает максимально допустимую длину (1024 символа).");
                }

                String userAgent = extractUserAgent(line);
                if (userAgent != null) {
                    String botName = parseUserAgent(userAgent);
                    if ("Googlebot".equals(botName)) {
                        googlebotCount++;
                    } else if ("YandexBot".equals(botName)) {
                        yandexBotCount++;
                    }
                }
            }

            System.out.println("Общее количество запросов: " + totalLines);
            if (totalLines > 0) {
                System.out.printf("Доля запросов от Googlebot: %.2f%%\n", (googlebotCount * 100.0 / totalLines));
                System.out.printf("Доля запросов от YandexBot: %.2f%%\n", (yandexBotCount * 100.0 / totalLines));
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (LineTooLongException ex) {
            System.err.println("Ошибка: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    private static String extractUserAgent(String logLine) {
        int lastQuoteIndex = logLine.lastIndexOf('"');
        if (lastQuoteIndex == -1 || lastQuoteIndex == 0) {
            return null;
        }

        int prevQuoteIndex = logLine.lastIndexOf('"', lastQuoteIndex - 1);
        if (prevQuoteIndex == -1) {
            return null;
        }

        return logLine.substring(prevQuoteIndex + 1, lastQuoteIndex);
    }

    private static String parseUserAgent(String userAgent) {
        try {
            int startBracket = userAgent.indexOf('(');
            int endBracket = userAgent.indexOf(')');

            if (startBracket != -1 && endBracket != -1 && startBracket < endBracket) {
                String firstBrackets = userAgent.substring(startBracket + 1, endBracket);

                String[] parts = firstBrackets.split(";");
                if (parts.length >= 2) {
                    String fragment = parts[1].trim();

                    int slashIndex = fragment.indexOf('/');
                    return slashIndex != -1 ? fragment.substring(0, slashIndex) : fragment;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }
}