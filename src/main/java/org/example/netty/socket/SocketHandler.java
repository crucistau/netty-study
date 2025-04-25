package org.example.netty.socket;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


import java.nio.charset.StandardCharsets;

public class SocketHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if (msg instanceof byte[]) {
            byte[] bytes = (byte[]) msg;
            String message = new String(bytes, StandardCharsets.UTF_8);
            System.out.println("接收到的消息内容: " + message);
        }
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        // 通道就绪（连接建立）时被调用
        System.out.println("客户端连接：" + ctx.channel().remoteAddress());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 发生异常时被调用
        cause.printStackTrace();
        ctx.close(); // 关闭连接
    }
}
