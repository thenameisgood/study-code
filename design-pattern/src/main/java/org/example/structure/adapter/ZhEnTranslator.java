package org.example.structure.adapter;

public class ZhEnTranslator implements  Translator {
    @Override
    public String translate(String content) {
        if ("你好".equals(content)){
            return "hello";
        }
        if ("什么".equals(content)){
            return "what";
        }
        return null;
    }
}
