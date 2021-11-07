package gradle.server.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private static int port = 0;
    private static Scanner sc = new Scanner(System.in);
    private static ServerSocket serverSocket = null;
    private static Socket socket = null;
    public static BufferedReader bufferedReader = null;
    private static BufferedWriter bufferedWriter = null;

    public static void makePort(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public static void setupServer() throws IOException {
        socket = serverSocket.accept();
    }

    public static void iniBuffers() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
        bufferedReader = new BufferedReader(inputStreamReader);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
        bufferedWriter = new BufferedWriter(outputStreamWriter);
    }

    public static void sendMsg(String msg) throws IOException {
        bufferedWriter.write(msg);
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
}
