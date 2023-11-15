package org.example.event;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import lombok.SneakyThrows;
import org.example.netty.Info;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EquipEventListener implements ApplicationListener<EquipmentEvent> {

    @SneakyThrows
    @Override
    @Async
    public void onApplicationEvent(EquipmentEvent event) {
        System.out.println("监听到的消息：" + event.toString());
        // ByteBuf byteBuf = Unpooled.copiedBuffer("1".getBytes());
        // event.channelHandlerContext.writeAndFlush(byteBuf).sync();
        event.channelHandlerContext.writeAndFlush(new Object().toString()).sync();
        System.out.println("发送完毕");
    }
}
