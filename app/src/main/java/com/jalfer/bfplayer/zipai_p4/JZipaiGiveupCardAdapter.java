package com.jalfer.bfplayer.zipai_p4;

import android.content.Context;
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

public class JZipaiGiveupCardAdapter extends RecyclerView.Adapter<JZipaiGiveupCardAdapter.ViewHolder> {

    private Context mContext;
    private List<JZipaiGiveupCardInfo> giveupCardInfoList;

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(mContext == null){
            mContext = parent.getContext();
        }

        View view = LayoutInflater.from(mContext).inflate(R.layout.zipai_giveupcard_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        JZipaiGiveupCardInfo cardInfo = giveupCardInfoList.get(position);
        holder.cardImg.setImageDrawable(cardInfo.getCardDrawable());
     }

    @Override
    public int getItemCount() {
        return giveupCardInfoList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout cardLayout;
        ImageView cardImg;

        public ViewHolder(View itemView) {
            super(itemView);
            cardLayout = (LinearLayout) itemView;
            cardImg = (ImageView) itemView.findViewById(R.id.zipai_giveupcard_img);
        }
    }

    public JZipaiGiveupCardAdapter(List<JZipaiGiveupCardInfo> jinziCardInfoList){
        this.giveupCardInfoList = jinziCardInfoList;
    }


}
