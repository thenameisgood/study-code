package org.example.structure.adapter.obj;

import org.example.structure.adapter.Player;
import org.example.structure.adapter.Translator;
import org.example.structure.adapter.ZhEnTranslator;

/**
 * 对象结构模型：通过组合的方式
 * */
public class EnglishMoiveAdapter implements Player {

    private Translator translate = new ZhEnTranslator();

    private Player target;

    public EnglishMoiveAdapter(Player target) {
        this.target = target;
    }

    @Override
    public String play() {
        String content = target.play();
        //转换字幕
        String translateResult = translate.translate(content);
        System.out.println(translateResult);
        return translateResult;
    }

}
