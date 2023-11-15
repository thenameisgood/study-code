package org.example.netty;

import cn.hutool.json.JSONUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

public class MyMessageDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("进入了解码器");
        
        ByteBuf byteBuf = in.readBytes(in.readableBytes());

        String s = byteBuf.toString(CharsetUtil.UTF_8);

        Info info = JSONUtil.toBean(s, Info.class);

        System.out.println(info);
        out.add(info);
    }
}

