package com.jalfer.bfplayer.zipai_p4;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.jalfer.bfplayer.R;

import java.util.List;

/**
 * Created by Administrator on 2017/5/10 0010.
 */

public class ZipaiJinziCardAdapter extends RecyclerView.Adapter<ZipaiJinziCardAdapter.ViewHolder> {

    private Context mContext;
    private List<ZipaiJinziCardInfo>  jinziCardInfoList;
    private int chipaiBackColor = Color.LTGRAY;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext == null){
            mContext = parent.getContext();
        }

        View view = LayoutInflater.from(mContext).inflate(R.layout.zipai_jinzicard_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ZipaiJinziCardInfo cardInfo = jinziCardInfoList.get(position);
        holder.cardImg.setImageDrawable(cardInfo.getCardDrawable());
    }

    @Override
    public int getItemCount() {
        return jinziCardInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout cardLayout;
        ImageView cardImg;

        public ViewHolder(View itemView) {
            super(itemView);

            cardLayout = (LinearLayout) itemView;
            cardImg = (ImageView) itemView.findViewById(R.id.zipai_jinzicard_img);
        }
    }

    public ZipaiJinziCardAdapter(List<ZipaiJinziCardInfo> jinziCardInfoList){
        this.jinziCardInfoList = jinziCardInfoList;
    }


}
