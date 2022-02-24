import phoneServerClient.Phone;

import java.io.*;

public class Client {
    public static void main(String[] args) {
        try (Phone phone = new Phone("127.0.0.1", 8000))
        {
            System.out.println("Подключено к серверу");
            String request = "Случайное число";
            System.out.println("Запрос: " + request);

            phone.writeLine(request);
            String response = phone.readLine();
            System.out.println("Ответ: " + response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
