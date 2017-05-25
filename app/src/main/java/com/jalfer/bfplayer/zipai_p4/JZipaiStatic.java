package com.jalfer.bfplayer.zipai_p4;

import com.jalfer.bfplayer.R;

/**
 * Created by Administrator on 2017/5/23 0023.
 */

public class JZipaiStatic {

    public static int ZipaiNameToJinziImgId(char cardName){
        switch (cardName){
            case '王':   return R.drawable.zipai_400;
            case '壹':   return R.drawable.zipai_401;
            case '贰':   return R.drawable.zipai_402;
            case '叁':   return R.drawable.zipai_403;
            case '肆':   return R.drawable.zipai_404;
            case '伍':   return R.drawable.zipai_405;
            case '陸':   return R.drawable.zipai_406;
            case '柒':   return R.drawable.zipai_407;
            case '捌':   return R.drawable.zipai_408;
            case '玖':   return R.drawable.zipai_409;
            case '拾':   return R.drawable.zipai_410;
            case '一':   return R.drawable.zipai_411;
            case '二':   return R.drawable.zipai_412;
            case '三':   return R.drawable.zipai_413;
            case '四':   return R.drawable.zipai_414;
            case '五':   return R.drawable.zipai_415;
            case '六':   return R.drawable.zipai_416;
            case '七':   return R.drawable.zipai_417;
            case '八':   return R.drawable.zipai_418;
            case '九':   return R.drawable.zipai_419;
            case '十':   return R.drawable.zipai_420;
            default: break;
        }
        return -1;
    }

    public static int ZipaiNameToImgId(char cardName){
        switch (cardName){
            case '壹':   return R.drawable.zipai_421;
            case '贰':   return R.drawable.zipai_422;
            case '叁':   return R.drawable.zipai_423;
            case '肆':   return R.drawable.zipai_424;
            case '伍':   return R.drawable.zipai_425;
            case '陸':   return R.drawable.zipai_426;
            case '柒':   return R.drawable.zipai_427;
            case '捌':   return R.drawable.zipai_428;
            case '玖':   return R.drawable.zipai_429;
            case '拾':   return R.drawable.zipai_430;
            case '一':   return R.drawable.zipai_431;
            case '二':   return R.drawable.zipai_432;
            case '三':   return R.drawable.zipai_433;
            case '四':   return R.drawable.zipai_434;
            case '五':   return R.drawable.zipai_435;
            case '六':   return R.drawable.zipai_436;
            case '七':   return R.drawable.zipai_437;
            case '八':   return R.drawable.zipai_438;
            case '九':   return R.drawable.zipai_439;
            case '十':   return R.drawable.zipai_440;
            default: break;
        }

        return -1;
    }

    public static int ZipaiNameToId(char cardName){
        switch (cardName){
            case '壹':   return 1;
            case '贰':   return 2;
            case '叁':   return 3;
            case '肆':   return 4;
            case '伍':   return 5;
            case '陸':   return 6;
            case '柒':   return 7;
            case '捌':   return 8;
            case '玖':   return 9;
            case '拾':   return 10;
            case '一':   return 11;
            case '二':   return 12;
            case '三':   return 13;
            case '四':   return 14;
            case '五':   return 15;
            case '六':   return 16;
            case '七':   return 17;
            case '八':   return 18;
            case '九':   return 19;
            case '十':   return 20;
            default: break;
        }
        return -1;
    }
}
