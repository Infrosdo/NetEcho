package priv.huke.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(9999);
        // server将一直等待连接的到来
        System.out.println("ECHO服务器端已经启动了");
        Socket socket = serverSocket.accept();
        // 建立好连接后，从socket中获取输入流，并建立缓冲区进行读取
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = bufferedReader.readLine();
        System.out.println("客户端：" + s);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        bufferedWriter.write("server处理后的：" + s + "\n");
        bufferedWriter.flush();
    }
}
