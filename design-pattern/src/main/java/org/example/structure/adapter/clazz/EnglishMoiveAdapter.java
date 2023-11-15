package org.example.structure.adapter.clazz;

import org.example.structure.adapter.Player;
import org.example.structure.adapter.ZhEnTranslator;

/**
 * 系统中原先已存在接口Player Translator，两者没有任何关系
 * 为了翻译字幕，在不改变原有系统的基础上，可以弄一个适配器完成翻译功能
 * 原来的接口不能动，扩展一个新类来连接两个不同的类
 *
 * 类结构模型：通过继承的方式
 * */
public class EnglishMoiveAdapter extends ZhEnTranslator implements Player {

    private Player target;

    public EnglishMoiveAdapter(Player target) {
        this.target = target;
    }

    @Override
    public String play() {
        String content = target.play();
        //转换字幕
        String translate = translate(content);
        System.out.println(translate);
        return translate;
    }

}
