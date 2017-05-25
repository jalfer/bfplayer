package com.jalfer.bfplayer.zipai_p4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;

import com.jalfer.bfplayer.R;

/**
 * Created by Administrator on 2017/5/9 0009.
 */

public class JZipaiGiveupCardInfo {

    //保存字牌图片id
    private LayerDrawable cardDrawable;

    //进字是否是吃牌
    private char cardName;

    private Context mContext;

    public LayerDrawable getCardDrawable(){
        return this.cardDrawable;
    }

    public char getCardName(){
        return this.cardName;
    }

    public JZipaiGiveupCardInfo(char cardName, Context mContext){
        this.cardName = cardName;
        int cardId = JZipaiStatic.ZipaiNameToJinziImgId(cardName);
        this.mContext = mContext;

        Bitmap bitmap1 = ((BitmapDrawable) ContextCompat.getDrawable(mContext, R.drawable.zipai_451)).getBitmap();
        Bitmap bitmap2 = ((BitmapDrawable) ContextCompat.getDrawable(mContext, cardId)).getBitmap();
        Drawable[] array = new Drawable[2];
        array[0] = new BitmapDrawable(bitmap1);
        array[1] = new BitmapDrawable(bitmap2);
        cardDrawable = new LayerDrawable(array);
        // 其中第一个参数为层的索引号，后面的四个参数分别为left、top、right和bottom
        cardDrawable.setLayerInset(0, 0, 0, 0, 0);
        cardDrawable.setLayerInset(1, 3, 3, 2, 2);

    }
}
