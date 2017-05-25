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

public class JZipaiJinziCardInfo {

    //保存字牌图片id
    private LayerDrawable cardDrawable;

    private int firstCardId;
    private int secondCardId;
    private int thirdCardId;
    private int fourthCardId;

    //进字是否是吃牌
    private JJinziKind jinziKind;
    private boolean isFirstPlayer;
    private char opearCardInfo;
    private Context mContext;

    public LayerDrawable getCardDrawable(){
        return this.cardDrawable;
    }

    public JJinziKind getJinziKind(){
        return this.jinziKind;
    }

    public char getOpearCardInfo(){
        return this.opearCardInfo;
    }

    public JZipaiJinziCardInfo(String jinziStr, JJinziKind jinziKind, boolean isFirstPlayer, Context context){
        this.jinziKind = jinziKind;
        this.isFirstPlayer = isFirstPlayer;
        this.opearCardInfo = jinziStr.charAt(0);
        this.mContext = context;
        switch (jinziKind) {
            case 吃:
                firstCardId = JZipaiStatic.ZipaiNameToJinziImgId(jinziStr.charAt(0));
                secondCardId = JZipaiStatic.ZipaiNameToJinziImgId(jinziStr.charAt(1));
                thirdCardId = JZipaiStatic.ZipaiNameToJinziImgId(jinziStr.charAt(2));
                break;
            case 碰:
                int cardid = JZipaiStatic.ZipaiNameToJinziImgId(opearCardInfo);
                firstCardId = cardid;
                secondCardId = cardid;
                thirdCardId = cardid;
                break;
            case 跑:
                cardid = JZipaiStatic.ZipaiNameToJinziImgId(opearCardInfo);
                firstCardId = cardid;
                secondCardId = cardid;
                thirdCardId = cardid;
                fourthCardId = cardid;
                break;
            case 偎:
                if(isFirstPlayer) {
                    firstCardId = JZipaiStatic.ZipaiNameToJinziImgId(opearCardInfo);
                } else {
                    firstCardId = R.drawable.zipai_400;
                }
                secondCardId = R.drawable.zipai_400;
                thirdCardId = R.drawable.zipai_400;
                break;
            case 臭偎:
                firstCardId = JZipaiStatic.ZipaiNameToJinziImgId(opearCardInfo);
                secondCardId = R.drawable.zipai_400;
                thirdCardId = R.drawable.zipai_400;
                break;
            case 提:
                if(isFirstPlayer) {
                    firstCardId = JZipaiStatic.ZipaiNameToJinziImgId(opearCardInfo);
                } else {
                    firstCardId = R.drawable.zipai_400;
                }
                secondCardId = R.drawable.zipai_400;
                thirdCardId = R.drawable.zipai_400;
                fourthCardId = R.drawable.zipai_400;
                break;
            default:
        }

        initCardDrawable();
    }

    private void initCardDrawable(){
        Bitmap bitmap1;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Bitmap bitmap4;
        Bitmap bitmap5;
        Drawable[] array;

        switch (jinziKind) {
            case 吃:
                bitmap1 = ((BitmapDrawable) ContextCompat.getDrawable(mContext, R.drawable.zipai_452)).getBitmap();
                bitmap2 = ((BitmapDrawable) ContextCompat.getDrawable(mContext, firstCardId)).getBitmap();
                bitmap3 = ((BitmapDrawable) ContextCompat.getDrawable(mContext, secondCardId)).getBitmap();
                bitmap4 = ((BitmapDrawable) ContextCompat.getDrawable(mContext, thirdCardId)).getBitmap();

                array = new Drawable[4];
                array[0] = new BitmapDrawable(bitmap1);
                array[1] = new BitmapDrawable(bitmap2);
                array[2] = new BitmapDrawable(bitmap3);
                array[3] = new BitmapDrawable(bitmap4);

                cardDrawable = new LayerDrawable(array);
                cardDrawable.setLayerInset(0, 0, 0, 0, 0);
                cardDrawable.setLayerInset(1, 3, 3, 2, 64);
                cardDrawable.setLayerInset(2, 3, 34, 2, 33);
                cardDrawable.setLayerInset(3, 3, 65, 2, 2);
                break;
            case 碰:
            case 偎:
            case 臭偎:
                bitmap1 = ((BitmapDrawable) ContextCompat.getDrawable(mContext, R.drawable.zipai_453)).getBitmap();
                bitmap2 = ((BitmapDrawable) ContextCompat.getDrawable(mContext, firstCardId)).getBitmap();
                bitmap3 = ((BitmapDrawable) ContextCompat.getDrawable(mContext, secondCardId)).getBitmap();
                bitmap4 = ((BitmapDrawable) ContextCompat.getDrawable(mContext, thirdCardId)).getBitmap();

                array = new Drawable[4];
                array[0] = new BitmapDrawable(bitmap1);
                array[1] = new BitmapDrawable(bitmap2);
                array[2] = new BitmapDrawable(bitmap3);
                array[3] = new BitmapDrawable(bitmap4);

                cardDrawable = new LayerDrawable(array);
                cardDrawable.setLayerInset(0, 0, 0, 0, 0);
                cardDrawable.setLayerInset(1, 3, 3, 2, 64);
                cardDrawable.setLayerInset(2, 3, 34, 2, 33);
                cardDrawable.setLayerInset(3, 3, 65, 2, 2);
                break;
            case 跑:
            case 提:
                bitmap1 = ((BitmapDrawable) ContextCompat.getDrawable(mContext, R.drawable.zipai_454)).getBitmap();
                bitmap2 = ((BitmapDrawable) ContextCompat.getDrawable(mContext, firstCardId)).getBitmap();
                bitmap3 = ((BitmapDrawable) ContextCompat.getDrawable(mContext, secondCardId)).getBitmap();
                bitmap4 = ((BitmapDrawable) ContextCompat.getDrawable(mContext, thirdCardId)).getBitmap();
                bitmap5 = ((BitmapDrawable) ContextCompat.getDrawable(mContext, fourthCardId)).getBitmap();

                array = new Drawable[5];
                array[0] = new BitmapDrawable(bitmap1);
                array[1] = new BitmapDrawable(bitmap2);
                array[2] = new BitmapDrawable(bitmap3);
                array[3] = new BitmapDrawable(bitmap4);
                array[4] = new BitmapDrawable(bitmap5);

                cardDrawable = new LayerDrawable(array);
                cardDrawable.setLayerInset(0, 0, 0, 0, 0);
                cardDrawable.setLayerInset(1, 3, 3, 2, 95);
                cardDrawable.setLayerInset(2, 3, 34, 2, 64);
                cardDrawable.setLayerInset(3, 3, 65, 2, 33);
                cardDrawable.setLayerInset(4, 3, 95, 2, 2);

                break;
            default:
        }
    }
}
