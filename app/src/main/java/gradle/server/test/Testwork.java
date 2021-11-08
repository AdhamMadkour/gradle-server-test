package gradle.server.test;

import java.io.IOException;
import java.util.Objects;

public class Testwork {
    public static boolean testOpenPort(String ip, int port) throws IOException {
        Server.makePort(8833);
        Client.setupClient(ip, port);
        Server.setupServer();
        Client.iniVar();
        Server.iniBuffers();
        return true;
    }

    public static boolean testSend(String msg) throws IOException {
        Client.sendMsg(msg);
        return msg.equals(Server.bufferedReader.readLine());
    }

    public static boolean testReply(String msg) throws IOException {
        Server.sendMsg(msg);
        return msg.equals(Client.bufferedReader.readLine());
    }

    public static boolean addNewClient(String ip, int port) throws IOException {
        Client.Close();
        Client.setupClient(ip, port);
        return true;
    }
}
