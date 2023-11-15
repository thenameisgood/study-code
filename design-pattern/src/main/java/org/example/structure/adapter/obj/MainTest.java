package org.example.structure.adapter.obj;

import org.example.structure.adapter.MoivePlayer;

public class MainTest {
    public static void main(String[] args) {
        MoivePlayer player = new MoivePlayer();
        EnglishMoiveAdapter englishMoiveAdapter = new EnglishMoiveAdapter(player);
        englishMoiveAdapter.play();
    }
}
