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

public class ZipaiJinziCardInfo {

    //保存字牌图片id
    private LayerDrawable cardDrawable;

    private int firstCardId;
    private int secondCardId;
    private int thirdCardId;
    private int fourthCardId;

    //进字是否是吃牌
    private JinziKind jinziKind;
    private boolean isFirstPlayer;
    private char opearCardInfo;
    private Context mContext;

    public LayerDrawable getCardDrawable(){
        return this.cardDrawable;
    }

    public JinziKind getJinziKind(){
        return this.jinziKind;
    }

    public char getOpearCardInfo(){
        return this.opearCardInfo;
    }

    public ZipaiJinziCardInfo(String jinziStr, JinziKind jinziKind, boolean isFirstPlayer, Context context){
        this.jinziKind = jinziKind;
        this.isFirstPlayer = isFirstPlayer;
        this.opearCardInfo = jinziStr.charAt(0);
        this.mContext = context;
        switch (jinziKind) {
            case 吃:
                firstCardId = ZipaiNameToImgId(jinziStr.charAt(0));
                secondCardId = ZipaiNameToImgId(jinziStr.charAt(1));
                thirdCardId = ZipaiNameToImgId(jinziStr.charAt(2));
                break;
            case 碰:
                int cardid = ZipaiNameToImgId(opearCardInfo);
                firstCardId = cardid;
                secondCardId = cardid;
                thirdCardId = cardid;
                break;
            case 跑:
                cardid = ZipaiNameToImgId(opearCardInfo);
                firstCardId = cardid;
                secondCardId = cardid;
                thirdCardId = cardid;
                fourthCardId = cardid;
                break;
            case 偎:
                if(isFirstPlayer) {
                    firstCardId = ZipaiNameToImgId(opearCardInfo);
                } else {
                    firstCardId = R.drawable._10;
                }
                secondCardId = R.drawable._10;
                thirdCardId = R.drawable._10;
                break;
            case 臭偎:
                firstCardId = ZipaiNameToImgId(opearCardInfo);
                secondCardId = R.drawable._10;
                thirdCardId = R.drawable._10;
                break;
            case 提:
                if(isFirstPlayer) {
                    firstCardId = ZipaiNameToImgId(opearCardInfo);
                } else {
                    firstCardId = R.drawable._10;
                }
                secondCardId = R.drawable._10;
                thirdCardId = R.drawable._10;
                fourthCardId = R.drawable._10;
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
                bitmap1 = ((BitmapDrawable) ContextCompat.getDrawable(mContext, R.drawable._06)).getBitmap();
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
                bitmap1 = ((BitmapDrawable) ContextCompat.getDrawable(mContext, R.drawable._07)).getBitmap();
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
                bitmap1 = ((BitmapDrawable) ContextCompat.getDrawable(mContext, R.drawable._08)).getBitmap();
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
    
    public static int ZipaiNameToImgId(char cardName){
        switch (cardName){
            case '王':   return R.drawable._10;
            case '壹':   return R.drawable._11;
            case '贰':   return R.drawable._12;
            case '叁':   return R.drawable._13;
            case '肆':   return R.drawable._14;
            case '伍':   return R.drawable._15;
            case '陸':   return R.drawable._16;
            case '柒':   return R.drawable._17;
            case '捌':   return R.drawable._18;
            case '玖':   return R.drawable._19;
            case '拾':   return R.drawable._20;
            case '一':   return R.drawable._21;
            case '二':   return R.drawable._22;
            case '三':   return R.drawable._23;
            case '四':   return R.drawable._24;
            case '五':   return R.drawable._25;
            case '六':   return R.drawable._26;
            case '七':   return R.drawable._27;
            case '八':   return R.drawable._28;
            case '九':   return R.drawable._29;
            case '十':   return R.drawable._30;
            default: break;
        }

        return -1;
    }
}
