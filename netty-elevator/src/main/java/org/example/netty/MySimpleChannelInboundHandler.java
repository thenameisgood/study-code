package org.example.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.example.event.EquipEventPublisher;
import org.example.event.EquipmentEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.LockSupport;


@Component
@ChannelHandler.Sharable
public class MySimpleChannelInboundHandler extends SimpleChannelInboundHandler<Info> {

    @Autowired
    private EquipEventPublisher equipEventPublisher;
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Info o) throws Exception {
        System.out.println("我读到了数据是" + o);
        if (o.getId().equals(100)) {
            EquipmentEvent equipmentEvent = new EquipmentEvent(o.getId(), "注塑机", "生产设备", channelHandlerContext);
            equipEventPublisher.publish(equipmentEvent);
        }
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Registered");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("Active");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        System.out.println("ReadComplete");
    }
}

