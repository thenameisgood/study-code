package org.example.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.FixedLengthFrameDecoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class NettyServer {

    @Value("${tcp.port}")
    private int port;

    @Autowired
    private MySimpleChannelInboundHandler mySimpleChannelInboundHandler;


    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        // 设置处理请求的逻辑处理类
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ChannelPipeline pipeline = ch.pipeline();
                            ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
                            pipeline.addLast(new DelimiterBasedFrameDecoder(1024 * 1024 * 1024 * 5, delimiter));
                            pipeline.addLast(new MyMessageDecoder());
                            pipeline.addLast(new MyMessageEncoder());
                            pipeline.addLast(new MyStringMessageEncoder());
                            // pipeline.addLast(new MySimpleChannelInboundHandler());
                            pipeline.addLast(mySimpleChannelInboundHandler);
                        }
                    });
            // 创建一个通道   阻塞端口号，以及同步策略
            ChannelFuture f = bootstrap.bind(port).sync();
            // 等待服务监听端口关闭 关闭通道
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }
}
