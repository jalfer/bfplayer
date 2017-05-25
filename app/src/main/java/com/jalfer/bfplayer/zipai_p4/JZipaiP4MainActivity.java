package com.jalfer.bfplayer.zipai_p4;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.ImageButton;

import com.jalfer.bfplayer.R;

import java.util.ArrayList;
import java.util.List;

public class JZipaiP4MainActivity extends AppCompatActivity {

    private List<JZipaiJinziCardInfo>  player1JinziCardInfoList = new ArrayList<>();
    private List<JZipaiGiveupCardInfo> player1GiveupCardInfoList = new ArrayList<>();
    private List<JZipaiDragCardButton> player1OperCardInfoList = new ArrayList<>();
    private JZipaiJinziCardAdapter adapter;
    private AbsoluteLayout relativeLayout = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zipai_p4_main);

        showPlayer1JinziCardInfo();
        relativeLayout = (AbsoluteLayout) findViewById(R.id.zipai_p4_opear_layout);

        ImageButton b = (ImageButton) findViewById(R.id.zipai_p4_hu_imgbtn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOpearLayout();
            }
        });
    }

    private void showOpearLayout(){

        JZipaiOperCardLists.OperLayoutWidth = relativeLayout.getWidth();
        JZipaiOperCardLists.OperLayoutHeight = relativeLayout.getHeight();

        String cardStr = "贰五十二贰壹陸一十十伍伍伍柒柒";
        new JZipaiOperCardLists(this, relativeLayout, cardStr);
     /*   int width = JZipaiOperCardLists.OperLayoutWidth / 10;

        for (int i = 0; i < 4; i++) {
           relativeLayout.addView(new JZipaiDragCardButton(this, new Card('叁'), new JZipaiOperCardList(new Point(20,100), width) , (int)((1.2+i) * width)));
        }  */
      //  JZipaiDragImageButton button = new JZipaiDragImageButton(this, '壹', 0, 0);
      //  relativeLayout.addView(button);
       // JZipaiDragImageButton button2 = new JZipaiDragImageButton(this, '贰', width , 0);
      //  relativeLayout.addView(button2);

       // JZipaiDragImageButton button3 = new JZipaiDragImageButton(this, '叁', 2* width , 0);
      //  relativeLayout.addView(button3);
    }

    private void showPlayer1JinziCardInfo(){
       // Resources res = getResources();
        player1JinziCardInfoList.clear();

        player1JinziCardInfoList.add(new JZipaiJinziCardInfo("一一一", JJinziKind.偎, true, this));
        player1JinziCardInfoList.add(new JZipaiJinziCardInfo("陸陸陸", JJinziKind.碰, false, this));
        player1JinziCardInfoList.add(new JZipaiJinziCardInfo("十十十十", JJinziKind.提, true, this));
       // player1JinziCardInfoList.add(new JZipaiJinziCardInfo("捌捌捌捌", JJinziKind.跑, true, this));
        player1JinziCardInfoList.add(new JZipaiJinziCardInfo("拾贰柒", JJinziKind.吃, true, this));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.zipai_player1_jinzi_recyclerview);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 5);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new JZipaiJinziCardAdapter(player1JinziCardInfoList);
        recyclerView.setAdapter(adapter);

        recyclerView = (RecyclerView) findViewById(R.id.zipai_player4_jinzi_recyclerview);
        layoutManager = new GridLayoutManager(this, 5);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new JZipaiJinziCardAdapter(player1JinziCardInfoList);
        recyclerView.setAdapter(adapter);

        player1GiveupCardInfoList.clear();
        player1GiveupCardInfoList.add(new JZipaiGiveupCardInfo('二', this));
        player1GiveupCardInfoList.add(new JZipaiGiveupCardInfo('五', this));
        player1GiveupCardInfoList.add(new JZipaiGiveupCardInfo('玖', this));
        player1GiveupCardInfoList.add(new JZipaiGiveupCardInfo('壹', this));
        player1GiveupCardInfoList.add(new JZipaiGiveupCardInfo('柒', this));
        player1GiveupCardInfoList.add(new JZipaiGiveupCardInfo('玖', this));

        recyclerView = (RecyclerView) findViewById(R.id.zipai_player1_giveup_recyclerview);
        layoutManager = new GridLayoutManager(this, 5);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new JZipaiGiveupCardAdapter(player1GiveupCardInfoList));

        recyclerView = (RecyclerView) findViewById(R.id.zipai_player4_giveup_recyclerview);
        layoutManager = new GridLayoutManager(this, 5);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new JZipaiGiveupCardAdapter(player1GiveupCardInfoList));

    }
}
