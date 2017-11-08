package Scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        Socket client = null;
        PrintStream out = null;
        BufferedReader buf = null;
        server = new ServerSocket(9999);

        boolean f = true;

        while (f) {
            System.out.println("服务器运行，等待客户端连接");
            client = server.accept();
            System.out.println("客户端连接成功");

            buf = new BufferedReader(new InputStreamReader(client.getInputStream()));

            out = new PrintStream(client.getOutputStream());

            boolean flag = true;

            while (flag) {
                System.out.println("开始读取客户端发送的信息");
                String str = buf.readLine();
                System.out.println("客户端发送的信息为：" + str);
                if ("bye".equals(str)) {
                    flag = false;
                } else {
                    out.println("Echo" + str);
                }
            }
            out.close();
            client.close();
        }
        server.close();
    }
}
