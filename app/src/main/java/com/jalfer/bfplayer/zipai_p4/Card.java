package com.jalfer.bfplayer.zipai_p4;

/**
 * Created by Administrator on 2017/5/24 0024.
 */

public class Card {

    public char cardName;
    public int cardId;
    public boolean isNotMove = false;

    public Card(char name){
        this.cardName = name;
        this.cardId = JZipaiStatic.ZipaiNameToId(name);
    }
}