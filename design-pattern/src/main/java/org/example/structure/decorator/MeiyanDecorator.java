package org.example.structure.decorator;

/**
 * 美颜装饰器
 * */
public class MeiyanDecorator implements TicTokDecorator{

    private StarTicTok starTicTok;

    public MeiyanDecorator(StarTicTok starTicTok) {
        this.starTicTok = starTicTok;
    }

    @Override
    public void tictok() {
        enableMeiyan();
        starTicTok.tictok();
    }

    @Override
    public void enableMeiyan() {
        System.out.println("美颜成功");
    }
}
