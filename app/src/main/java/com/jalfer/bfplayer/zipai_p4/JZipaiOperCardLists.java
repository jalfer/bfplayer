package com.jalfer.bfplayer.zipai_p4;

import android.content.Context;
import android.graphics.Point;
import android.widget.AbsoluteLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Administrator on 2017/5/24 0024.
 */

public class JZipaiOperCardLists {

    public static int OperLayoutWidth = 800;
    public static int OperLayoutHeight = 400;

    public List<JZipaiDragCardButton> moveCardList = null;
    private List<JZipaiOperCardList> noMoveGroupList = null;
    private List<JZipaiOperCardList> buttonGroupList = new ArrayList<>();
    private Context context;
    private AbsoluteLayout absoluteLayout;
    private int cardListWidth;
    private int buttonListLocationY;

    public JZipaiOperCardLists(Context context, AbsoluteLayout absoluteLayout, String cards) {
        this.context = context;
        this.absoluteLayout = absoluteLayout;
        cardListWidth = OperLayoutWidth / 10;
        Initialize(cards);
    }

    public int Initialize(String cards) {
        this.moveCardList = new ArrayList<>();
        this.noMoveGroupList = new ArrayList<>();

        return InitializeButtonGroupList(cards);
    }

    //把初始按钮位置算法放入List
    private int InitializeButtonGroupList(String cards) {
        List<List<Card>> cardLists = InitializeCardList(cards);

        int cnt = cardLists.size();
        int x = (10 - cnt) * cardListWidth / 2;
        buttonListLocationY = OperLayoutHeight - (int) (0.8f * cardListWidth);

        for (int i = 0; i < cnt; i++) {
            JZipaiOperCardList newCardList = new JZipaiOperCardList(new Point(x, buttonListLocationY), cardListWidth);
            List<Card> cardList = cardLists.get(i);
            boolean notMove = false;

            for (int j = 0; j < cardList.size(); j++) {
                Card card = cardList.get(j);

                JZipaiDragCardButton cardButton = new JZipaiDragCardButton(this.context, card, newCardList, this);
                newCardList.addButton(cardButton);
               // absoluteLayout.addView(cardButton);

                if (!card.isNotMove) {
                    moveCardList.add(cardButton);
                } else {
                    notMove = true;
                }
            }

            if (notMove) {
                newCardList.setIsFull(true);
                noMoveGroupList.add(newCardList);
            } else if (newCardList.getCardButtonList().size() > 3) {
                newCardList.setIsFull(true);
            }
            buttonGroupList.add(newCardList);

            x += cardListWidth;
        }
        resetPanel();
        return 0;
    }

    private List<List<Card>> InitializeCardList(String cards) {

        List<List<Card>> cardLists = new ArrayList<>();
        Card[] newCards = CardsSort(cards);

        for (int i = 0; i < newCards.length; i++) {
            List<Card> newCardList = null;
            boolean noThisGroup = true;
            Card card = newCards[i];

            for (List<Card> var : cardLists) {
                if (card.cardName == var.get(0).cardName) {
                    newCardList = var;
                    noThisGroup = false;
                    break;
                }
            }
            if (noThisGroup) {
                newCardList = new ArrayList<>();
                cardLists.add(newCardList);
            }
            newCardList.add(card);
        }

        int cnt = cardLists.size();
        for (int i = 0; i < cnt; i++) {
            List<Card> cards1 = cardLists.get(i);
            if (cards1.size() > 2) {
                for (Card card : cards1) {
                    card.isNotMove = true;
                }
            } else {
                for (int j = 0; j < i; j++) {
                    List<Card> cards2 = cardLists.get(j);
                    if (cards2.size() > 0 && cards2.size() < 3) {
                        if (cards1.get(0).cardId == cards2.get(0).cardId + 10) {
                            for (Card card : cards1) {
                                cards2.add(card);
                            }
                            cards1.clear();
                            break;
                        }

                    }
                }
            }
        }

        List<List<Card>> cardLists2 = new ArrayList<>();
        for (List<Card> var : cardLists) {
            if (var.size() > 0) {
                cardLists2.add(var);
            }
        }
        return cardLists2;
    }

    private Card[] CardsSort(String cards) {
        int cnt = cards.length();
        Card[] newCards = new Card[cnt];

        for (int i = 0; i < cnt; i++) {
            newCards[i] = new Card(cards.charAt(i));
        }
        Card card;
        for (int i = 0; i < cnt - 1; i++) {
            for (int j = i + 1; j < cnt; j++) {
                if (newCards[i].cardId > newCards[j].cardId) {
                    card = newCards[i];
                    newCards[i] = newCards[j];
                    newCards[j] = card;
                }
            }

        }
        return newCards;
    }

    public void MoveCardButton(JZipaiDragCardButton cardButton, int x) {
        JZipaiOperCardList oldCaldList = null;
        JZipaiOperCardList newCardList = null;
        for (int i = 0; i < buttonGroupList.size(); i++) {
            newCardList = buttonGroupList.get(i);
            if (newCardList.isInCardList(x) && (!newCardList.getIsFull())) {
                oldCaldList = cardButton.getMyCardList();
                oldCaldList.removeButton(cardButton);
                newCardList.addButton(cardButton);
                break;
            }
        }

        if (oldCaldList == null) {
            newCardList = null;
            int cnt = 0;
            int new_x = buttonGroupList.get(cnt).getLocation().x - cardListWidth;
            if ((x >= new_x) && (x < new_x + cardListWidth)) {
                newCardList = new JZipaiOperCardList(new Point(new_x, buttonListLocationY), cardListWidth);
                buttonGroupList.add(0, newCardList);
            }

            cnt = buttonGroupList.size() - 1;
            new_x = buttonGroupList.get(cnt).getLocation().x + cardListWidth;
            if ((x >= new_x) && (x < new_x + cardListWidth)) {
                newCardList = new JZipaiOperCardList(new Point(new_x, buttonListLocationY), cardListWidth);
                buttonGroupList.add(newCardList);
            }

            if (newCardList != null) {
                oldCaldList = cardButton.getMyCardList();
                oldCaldList.removeButton(cardButton);
                newCardList.addButton(cardButton);
            }
        }

        if (oldCaldList != null) {
            if (oldCaldList.getCardButtonList().size() <= 0) {
                buttonGroupList.remove(oldCaldList);
                resetButtonGroupList();
            }

        }
        else {
            oldCaldList = cardButton.getMyCardList();
            oldCaldList.setButtonsLocation();
        }
        resetPanel();
    }

    /*
            public void ThrowCard(CardButtonOfPanel1 cardButton)
            {
                JInterface.IsTurnThrowCard = false;
                JInterface.ThrowCardLabel.Visible = false;

                moveCardList.Remove(cardButton);
                firstPlayer.GiveUpCardOfChi.Add(cardButton.MyCard);         //将打出的牌加到弃牌中去
                firstPlayer.SendMSG("P P " + cardButton.MyCard.CardName);   //发送出牌消息

                ReMoveCardButton(cardButton);

                if (ShowCardInfoEvent != null)
                {
                    ShowCardInfoEvent(cardButton.MyCard.CardName.ToString());
                }
            }

            public void ReMoveCardButton(CardButtonOfPanel1 cardButton)
            {
                try
                {
                    ButtonGroup11 bg = cardButton.MyButtonGroup;



                    if (bg != null)
                    {
                        bg.RemoveButton(cardButton);

                        if (bg.CardButtonList.Count <= 0)
                        {
                            buttonGroupList.Remove(bg);
                            ResetButtonGroupList();
                        }
                        ResetPanel();
                    }
                }
                catch
                {
                }

            }

            public void ReMoveCardButton(ButtonGroup11 buttonGroup)
            {
                try
                {
                    buttonGroupList.Remove(buttonGroup);
                    ResetButtonGroupList();

                    ResetPanel();
                }
                catch
                {
                }

            }
    */
    public void resetButtonGroupList() {
        int cnt = buttonGroupList.size();
        int x = (10 - cnt) * cardListWidth / 2;

        for (JZipaiOperCardList var : buttonGroupList) {
            var.setLocation(new Point(x, buttonListLocationY));
            x += cardListWidth;
        }
    }

    public void resetPanel() {
        absoluteLayout.removeAllViews();
        for (JZipaiOperCardList var : buttonGroupList) {
            List<JZipaiDragCardButton> list = var.getCardButtonList();
            for (int i = 0; i < list.size(); i++) {
                absoluteLayout.addView(list.get(i));
            }
        }
    }
}
