package org.example.event;

import io.netty.channel.ChannelHandlerContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;


public class EquipmentEvent extends ApplicationEvent {

    Integer equipId;
    String equipName;

    String equipType;
    
    ChannelHandlerContext channelHandlerContext;


    public EquipmentEvent(Integer equipId, String equipName, String equipType, ChannelHandlerContext channelHandlerContext) {
        super(equipId);
        this.equipId = equipId;
        this.equipName = equipName;
        this.equipType = equipType;
        this.channelHandlerContext = channelHandlerContext;
    }

    @Override
    public String toString() {
        return "EquipmentEvent{" +
                "equipId=" + equipId +
                ", equipName='" + equipName + '\'' +
                ", equipType='" + equipType + '\'' +
                ", channelHandlerContext=" + channelHandlerContext +
                '}';
    }
}
