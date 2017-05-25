package com.jalfer.bfplayer.zipai_p4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageButton;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsoluteLayout;

import com.jalfer.bfplayer.R;

/**
 * Created by Administrator on 2017/5/23 0023.
 */

public class JZipaiDragCardButton extends AppCompatImageButton implements View.OnTouchListener {

    private Point lastLoction = new Point();

    private Card card;
    private int cardImgId;
    private LayerDrawable cardDrawable;
    private LayerDrawable cardSelectDrawable;
    private AbsoluteLayout.LayoutParams buttonParams;
    private JZipaiOperCardList myCardList = null;
    private JZipaiOperCardLists cardLists = null;

    public Card getCard(){
        return this.card;
    }

    public void setButtonParams_XY(int x, int y){
        buttonParams.x = x;
        buttonParams.y = y;
    }

    public void setMyCardList(JZipaiOperCardList list){
        this.myCardList = list;
    }

    public JZipaiOperCardList getMyCardList(){
        return this.myCardList;
    }
/*
    public JZipaiDragCardButton(Context context, Card card, int x, int y){
        super(context);
        this.setOnTouchListener(this);

        this.card = card;
        this.cardImgId = JZipaiStatic.ZipaiNameToImgId(card.cardName);

        int width = JZipaiOperCardLists.OperLayoutWidth / 10;
        buttonParams = new AbsoluteLayout.LayoutParams(width, 3 * width, x, y);

        Bitmap bitmap1 = ((BitmapDrawable) ContextCompat.getDrawable(context, R.drawable.zipai_455)).getBitmap();
        Bitmap bitmap2 = ((BitmapDrawable) ContextCompat.getDrawable(context, R.drawable.zipai_456)).getBitmap();
        Bitmap bitmap3 = ((BitmapDrawable) ContextCompat.getDrawable(context, cardImgId)).getBitmap();
        Drawable[] array = new Drawable[2];
        array[0] = new BitmapDrawable(bitmap2);
        array[1] = new BitmapDrawable(bitmap3);
        cardDrawable = new LayerDrawable(array);
        cardDrawable.setLayerInset(0, 0, 0, 0, 0);
        cardDrawable.setLayerInset(1, 3, 5, 3, 5);

        array = new Drawable[2];
        array[0] = new BitmapDrawable(bitmap1);
        array[1] = new BitmapDrawable(bitmap3);
        cardSelectDrawable = new LayerDrawable(array);
        cardSelectDrawable.setLayerInset(0, 0, 0, 0, 0);
        cardSelectDrawable.setLayerInset(1, 3, 5, 3, 5);

        this.setLayoutParams(buttonParams);
        this.setImageDrawable(cardDrawable);
        this.setScaleType(ScaleType.FIT_CENTER);
        this.setBackgroundColor(Color.TRANSPARENT);
        this.setScaleType(ScaleType.FIT_CENTER);
        this.setPadding(0,0,0,0);
    }
*/
    public JZipaiDragCardButton(Context context, Card card, JZipaiOperCardList cardList, JZipaiOperCardLists cardLists){
        super(context);
        this.setOnTouchListener(this);

        this.card = card;
        this.myCardList = cardList;
        this.cardLists = cardLists;
        this.cardImgId = JZipaiStatic.ZipaiNameToImgId(card.cardName);

        int width = cardList.getWidth();
        buttonParams = new AbsoluteLayout.LayoutParams(width, 3 * width, 0, 0);

        if(card.isNotMove){
            Bitmap bitmap1 = ((BitmapDrawable) ContextCompat.getDrawable(getContext(), R.drawable.zipai_457)).getBitmap();
            Bitmap bitmap2 = ((BitmapDrawable) ContextCompat.getDrawable(getContext(), cardImgId)).getBitmap();
            Drawable[] array = new Drawable[2];
            array[0] = new BitmapDrawable(bitmap1);
            array[1] = new BitmapDrawable(bitmap2);
            cardDrawable = new LayerDrawable(array);
            cardDrawable.setLayerInset(0, 0, 0, 0, 0);
            cardDrawable.setLayerInset(1, 3, 5, 3, 5);
            this.setImageDrawable(cardDrawable);
        }
        else {
            Bitmap bitmap1 = ((BitmapDrawable) ContextCompat.getDrawable(context, R.drawable.zipai_455)).getBitmap();
            Bitmap bitmap2 = ((BitmapDrawable) ContextCompat.getDrawable(context, R.drawable.zipai_456)).getBitmap();
            Bitmap bitmap3 = ((BitmapDrawable) ContextCompat.getDrawable(context, cardImgId)).getBitmap();
            Drawable[] array = new Drawable[2];
            array[0] = new BitmapDrawable(bitmap2);
            array[1] = new BitmapDrawable(bitmap3);
            cardDrawable = new LayerDrawable(array);
            cardDrawable.setLayerInset(0, 0, 0, 0, 0);
            cardDrawable.setLayerInset(1, 3, 5, 3, 5);

            array = new Drawable[2];
            array[0] = new BitmapDrawable(bitmap1);
            array[1] = new BitmapDrawable(bitmap3);
            cardSelectDrawable = new LayerDrawable(array);
            cardSelectDrawable.setLayerInset(0, 0, 0, 0, 0);
            cardSelectDrawable.setLayerInset(1, 3, 5, 3, 5);
        }

        this.setLayoutParams(buttonParams);
        this.setImageDrawable(cardDrawable);
        this.setScaleType(ScaleType.FIT_CENTER);
        this.setBackgroundColor(Color.TRANSPARENT);
        this.setScaleType(ScaleType.FIT_CENTER);
        this.setPadding(0,0,0,0);
    }

    private boolean cardIsMove;
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(!card.isNotMove) {
            int ea = motionEvent.getAction();
            switch (ea) {
                case MotionEvent.ACTION_DOWN:
                    bringToFront();
                    this.setImageDrawable(this.cardSelectDrawable);
                    lastLoction.x = (int) motionEvent.getRawX();
                    lastLoction.y = (int) motionEvent.getRawY();
                    cardIsMove = false;
                    break;
                case MotionEvent.ACTION_MOVE:
                    cardIsMove = true;
                    int dx = (int) motionEvent.getRawX() - lastLoction.x;
                    int dy = (int) motionEvent.getRawY() - lastLoction.y;

                    buttonParams.x = view.getLeft() + dx;
                    buttonParams.y = view.getTop() + dy;
                    view.setLayoutParams(buttonParams);

                    lastLoction.x = (int) motionEvent.getRawX();
                    lastLoction.y = (int) motionEvent.getRawY();
                    view.postInvalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    this.setImageDrawable(this.cardDrawable);
                    if(cardIsMove) {
                        cardLists.MoveCardButton(this, buttonParams.x);
                    }
                    else {
                        cardLists.resetPanel();
                    }
                    break;
            }
        }
        return false;
    }

/*    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if(!card.isNotMove) {
            int ea = motionEvent.getAction();
            switch (ea) {
                case MotionEvent.ACTION_DOWN:
                    bringToFront();
                    this.setImageDrawable(this.cardSelectDrawable);
                    lastLoction.x = (int) motionEvent.getRawX();// 获取触摸事件触摸位置的原始X坐标
                    lastLoction.y = (int) motionEvent.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    int dx = (int) motionEvent.getRawX() - lastLoction.x;
                    int dy = (int) motionEvent.getRawY() - lastLoction.y;
                    int l = view.getLeft() + dx;
                    int b = view.getBottom() + dy;
                    int r = view.getRight() + dx;
                    int t = view.getTop() + dy;

                    int width = buttonParams.width;
                    int height = buttonParams.height;

                    // 下面判断移动是否超出屏幕
                    if (l < 0) {
                        l = 0;
                    }
                    if (t < -0.4 * height) {
                        t = -(int) (0.4 * height);
                    }
                    if (r > JZipaiOperCardLists.OperLayoutWidth) {
                        l = JZipaiOperCardLists.OperLayoutWidth - width;
                    }
                    if (b > JZipaiOperCardLists.OperLayoutHeight + 0.4 * height) {
                        t = JZipaiOperCardLists.OperLayoutHeight - (int) (0.6 * height);
                    }

                    buttonParams.x = l;
                    buttonParams.y = t;
                    view.setLayoutParams(buttonParams);

                    lastLoction.x = (int) motionEvent.getRawX();
                    lastLoction.y = (int) motionEvent.getRawY();
                    view.postInvalidate();
                    break;
                case MotionEvent.ACTION_UP:
                    this.setImageDrawable(this.cardDrawable);
                    cardLists.MoveCardButton(this,buttonParams.x);
                    break;
            }
        }
        return false;
    }
    */
}
