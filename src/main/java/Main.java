import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int count = 1;
        while (true) {
            System.out.println("Введите путь к файлу: ");
            Scanner scanner = new Scanner(System.in);
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();
            if (!fileExists || isDirectory) {
                System.out.println("Ошибка: файл не существует или указанный путь ведет к папке.");
                continue;
            } else {
                System.out.println("Путь указан верно");
                count++;
                System.out.println("Это файл номер " + count);
            }
        }
    }
}
