package timski_ensicaen.newcardgameproject;

import android.util.Log;

import java.util.Vector;


public class CardDeck {
    private Vector<CardEntity> avail_deck= new Vector<>(globalValues.Max,1);
    private Vector<CardEntity> unavail_deck =  new Vector<>(0,1);
    private int cnt;

    public CardDeck() {
        for (int i=1;i<globalValues.Max; i++) {
                avail_deck.addElement(new CardEntity(i));
        }
        cnt = globalValues.Max;
    }

    public int getCnt() {
        return cnt;
    }

    public Vector getAvail_deck() {
        return avail_deck;
    }

    public Vector getUnavail_deck() {
        return unavail_deck;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }


    public CardEntity pickCardEntity() {
        if (this.avail_deck.size() > 0) {
            int rnd = globalValues.rndFunction(globalValues.Min, this.avail_deck.size()) - 1;
            Log.d("PICK", "pick num" + String.valueOf(rnd));
            CardEntity tmpCard = avail_deck.get(rnd);
            this.unavail_deck.addElement(this.avail_deck.remove(rnd));
            return tmpCard;
        }
        else return null;
    }

    public CardEntity pickCardEntityFromHeap() {
        if (this.unavail_deck.size() > 0) {
            int rnd = globalValues.rndFunction(globalValues.Min, this.unavail_deck.size()) - 1;
            Log.d("PICK", "pick num" + String.valueOf(rnd));
            CardEntity tmpCard = unavail_deck.get(rnd);
            this.avail_deck.addElement(this.unavail_deck.remove(rnd));
            return tmpCard;
        }
        else return null;
    }
}
