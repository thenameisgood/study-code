package org.example.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MyMessageEncoder extends MessageToByteEncoder<Info> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Info msg, ByteBuf out) throws Exception {
        System.out.println("经过了encoder");
        out.writeBytes(msg.toString().getBytes());
    }
}
