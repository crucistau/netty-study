package org.example.netty.socket;

import jakarta.annotation.Resource;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class NettyStartListener implements ApplicationRunner {
    @Resource
    private SocketServer socketServer;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.socketServer.start();
    }
}
