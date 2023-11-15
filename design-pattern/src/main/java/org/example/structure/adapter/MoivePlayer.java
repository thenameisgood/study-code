package org.example.structure.adapter;

public class MoivePlayer implements Player{
    @Override
    public String play() {
        System.out.println("正在播放。。。");
        String content = "你好";
        System.out.println(content);    //打印字幕
        return content;
    }
}
