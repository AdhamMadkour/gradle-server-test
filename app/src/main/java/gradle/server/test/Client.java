package gradle.server.test;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static Scanner sc = new Scanner(System.in);
    private static Socket socket = null;
    public static BufferedReader bufferedReader = null;
    private static BufferedWriter bufferedWriter = null;
    private static InputStreamReader inputStreamReader = null;
    private static OutputStreamWriter outputStreamWriter = null;

    public static void setupClient(String ip, int port) throws IOException {
        socket = new Socket(ip, port);
    }

    public static void iniVar() throws IOException {
        inputStreamReader = new InputStreamReader(socket.getInputStream());
        outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
        bufferedReader = new BufferedReader(inputStreamReader);
        bufferedWriter = new BufferedWriter(outputStreamWriter);
    }

    public static void sendMsg(String msg) throws IOException {
        bufferedWriter.write(msg);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

    public static void Close() throws IOException {
        socket.close();
        bufferedReader.close();
        bufferedWriter.close();
        inputStreamReader.close();
        outputStreamWriter.close();
    }
}
