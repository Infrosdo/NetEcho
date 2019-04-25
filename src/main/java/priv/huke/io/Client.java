package priv.huke.io;

import priv.huke.util.InputUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 9999);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        //向服务器端发送一条消息
        String message = InputUtil.getString("请输入要发送的数据信息：");
        bufferedWriter.write(message + "\n");
        bufferedWriter.flush();

        //读取服务器返回的消息
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s = bufferedReader.readLine();
        System.out.println("服务器：" + s);
    }

}