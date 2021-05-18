import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileMain {
    public static void main(String[] args) {
        try (FileInputStream inputStream = new FileInputStream("src/file.txt")) {
            byte[] bytes = new byte[10000];
            int byteReader;

            while ((byteReader = inputStream.read(bytes)) != -1) {
                try (FileOutputStream outputStream = new FileOutputStream("src/new_file.txt")) {
                    outputStream.write(bytes, 0, byteReader);
                }
            }
        } catch (IOException e) {
            System.out.println("Error!");
        }

        System.out.println("File copied!");
    }
}
