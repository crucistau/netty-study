package org.example.netty.socket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SocketServer {
    @Resource
    private SocketInitializer socketInitializer;
    @Getter
    private ServerBootstrap serverBootstrap;

    @Value("${netty.port}")
    private int port;
    @Value("${netty.bossThread}")
    private int bossThread;
    public void start() {
        this.init();
        this.serverBootstrap.bind(this.port);
        log.info("Netty started on port: {} (TCP) with boss thread {}", this.port, this.bossThread);
    }

    // 初始化netty配置
    private void init(){
        // 创建两个线程组，bossGroup为接收请求的线程组，一般1-2个就行
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(this.bossThread);
        // 实际工作的线程组
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        this.serverBootstrap = new ServerBootstrap();
        this.serverBootstrap.group(bossGroup, workerGroup) // 两个线程组加入进来
                .channel(NioServerSocketChannel.class)  // 配置为nio类型
                .childHandler(this.socketInitializer); // 加入自己的初始化器
    }
}
