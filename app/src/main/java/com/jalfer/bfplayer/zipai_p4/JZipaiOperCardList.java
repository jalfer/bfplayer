package com.jalfer.bfplayer.zipai_p4;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/24 0024.
 */

public class JZipaiOperCardList {

    private List<JZipaiDragCardButton> cardButtonList = new ArrayList<>();
    private Point location;
    private int width = 30;
    private boolean isFull;

    public boolean getIsFull(){
        return isFull;
    }

    public void  setIsFull(boolean isFull){
        this.isFull = isFull;
    }

    public Point getLocation(){
        return this.location;
    }

    public void setLocation(Point location)
    {
        this.location = location;
        setButtonsLocation();
    }

    public int getWidth(){
        return width;
    }

    public List<JZipaiDragCardButton> getCardButtonList()
    {
        return cardButtonList;
    }

    public void addButton(JZipaiDragCardButton cardButton)
    {
        this.cardButtonList.add(0, cardButton);
        cardButton.setMyCardList(this);
        if (this.cardButtonList.size() >= 4)
        {
            isFull = true;
        }
        setButtonsLocation();
    }

    public void removeButton(JZipaiDragCardButton cardButton)
    {
        this.cardButtonList.remove(cardButton);
        cardButton.setMyCardList(null);
        isFull = false;
        setButtonsLocation();
    }

    public void clearButton()
    {
        this.cardButtonList.clear();
    }

    public void setButtonsLocation()
    {
        int cnt = cardButtonList.size();
        for (int i = 0; i < cnt; i++)
        {
            int y = this.location.y - (cnt - i) * width;
            cardButtonList.get(i).setButtonParams_XY(this.location.x, y);
        }
    }

    public JZipaiOperCardList(Point location, int width)
    {
        isFull = false;
        this.setLocation(location);
        this.width = width;
    }

    public boolean isInCardList(int x)
    {
        if ((x >= this.location.x) && (x < this.location.x + width)){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String str = "";
        for (JZipaiDragCardButton button:cardButtonList) {
            str = str + button.getCard();
        }
        return str;
    }

}
