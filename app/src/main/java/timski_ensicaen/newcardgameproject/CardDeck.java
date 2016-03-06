package timski_ensicaen.newcardgameproject;

import android.util.Log;

import java.util.Collections;
import java.util.Vector;


public class CardDeck {
    private Vector<CardEntity> avail_deck= new Vector<>(globalValues.Max,1);
    private Vector<CardEntity> unavail_deck =  new Vector<>(0,1);
    private Vector<CardEntity> player_one_deck =  new Vector<>(0,1);
    private Vector<CardEntity> player_two_deck =  new Vector<>(0,1);
    private int cnt;

    public CardDeck() {
        for (int i=1;i<globalValues.Max; i++) {
                avail_deck.addElement(new CardEntity(i));
        }
        cnt = globalValues.Max;
        Collections.shuffle(avail_deck);
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }


    public CardEntity pickCardEntity() {
        if (this.avail_deck.size() > 0) {
            //int rnd = globalValues.rndFunction(globalValues.Min, this.avail_deck.size()) - 1;
            //CardEntity tmpCard = avail_deck.get(rnd);
            CardEntity tmpCard = avail_deck.lastElement();
            //this.unavail_deck.addElement(this.avail_deck.remove(rnd));
            this.unavail_deck.addElement(this.avail_deck.remove(avail_deck.size()-1));
            return tmpCard;
        }
        else return null;
    }

    public CardEntity pickCardEntityFromDiscard() {
        if (this.unavail_deck.size() > 0) {
            //int rnd = globalValues.rndFunction(globalValues.Min, this.unavail_deck.size()) - 1;
            CardEntity tmpCard = unavail_deck.lastElement();
            this.avail_deck.insertElementAt(this.unavail_deck.remove(unavail_deck.size()-1),0);
            return tmpCard;
        }
        else return null;
    }


}
