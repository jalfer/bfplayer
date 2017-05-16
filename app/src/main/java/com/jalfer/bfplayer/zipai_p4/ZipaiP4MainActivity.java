package com.jalfer.bfplayer.zipai_p4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jalfer.bfplayer.R;

import java.util.ArrayList;
import java.util.List;

public class ZipaiP4MainActivity extends AppCompatActivity {

    private List<ZipaiJinziCardInfo>  player1JinziCardInfoList = new ArrayList<>();
    private List<ZipaiGiveupCardInfo> player1GiveupCardInfoList = new ArrayList<>();
    private ZipaiJinziCardAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zipai_p4_main);

        showPlayer1JinziCardInfo();
    }

    private void showPlayer1JinziCardInfo(){
       // Resources res = getResources();
        player1JinziCardInfoList.clear();

        player1JinziCardInfoList.add(new ZipaiJinziCardInfo("一一一", JinziKind.偎, true, this));
        player1JinziCardInfoList.add(new ZipaiJinziCardInfo("陸陸陸", JinziKind.碰, false, this));
        player1JinziCardInfoList.add(new ZipaiJinziCardInfo("十十十十", JinziKind.提, true, this));
        player1JinziCardInfoList.add(new ZipaiJinziCardInfo("捌捌捌捌", JinziKind.跑, true, this));
        player1JinziCardInfoList.add(new ZipaiJinziCardInfo("拾贰柒", JinziKind.吃, true, this));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.zipai_player1_jinzi_recyclerview);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 5);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ZipaiJinziCardAdapter(player1JinziCardInfoList);
        recyclerView.setAdapter(adapter);

        recyclerView = (RecyclerView) findViewById(R.id.zipai_player4_jinzi_recyclerview);
        layoutManager = new GridLayoutManager(this, 5);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ZipaiJinziCardAdapter(player1JinziCardInfoList);
        recyclerView.setAdapter(adapter);

        player1GiveupCardInfoList.clear();
        player1GiveupCardInfoList.add(new ZipaiGiveupCardInfo('二', this));
        player1GiveupCardInfoList.add(new ZipaiGiveupCardInfo('五', this));
        player1GiveupCardInfoList.add(new ZipaiGiveupCardInfo('玖', this));
        player1GiveupCardInfoList.add(new ZipaiGiveupCardInfo('壹', this));
        player1GiveupCardInfoList.add(new ZipaiGiveupCardInfo('柒', this));
        player1GiveupCardInfoList.add(new ZipaiGiveupCardInfo('玖', this));

        recyclerView = (RecyclerView) findViewById(R.id.zipai_player1_giveup_recyclerview);
        layoutManager = new GridLayoutManager(this, 5);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ZipaiGiveupCardAdapter(player1GiveupCardInfoList));

        recyclerView = (RecyclerView) findViewById(R.id.zipai_player4_giveup_recyclerview);
        layoutManager = new GridLayoutManager(this, 5);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new ZipaiGiveupCardAdapter(player1GiveupCardInfoList));

    }
}
