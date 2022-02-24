import phoneServerClient.Phone;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        try ( ServerSocket server = new ServerSocket(8000)) {
            System.out.println("Сервер Запущен!");
            while (true) {
                Phone phone = new Phone(server);
                new Thread(() ->{
                    String request = phone.readLine();
                    System.out.println("Запрос: " + request);
                    String response = (int) (Math.random() * 25 - 10) + "";
                    try {
                        Thread.sleep(6000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Ответ: " + response);
                    phone.writeLine(response);
                    try {
                        phone.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }

        } catch(IOException e){
            throw new RuntimeException(e);

        }
    }
}
