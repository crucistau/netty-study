package org.example.netty.client;

import java.io.IOException;

public class Client1 {
    public static void main(String[] args) throws IOException {
        new ChatClient().start("client1");
    }
}
