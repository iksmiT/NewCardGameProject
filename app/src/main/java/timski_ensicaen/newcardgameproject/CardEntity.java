package timski_ensicaen.newcardgameproject;

import android.widget.ImageView;

public class CardEntity {
    private int id;

    public CardEntity(int a) {
        this.id = a;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int a) {
        this.id = a;
    }

    public static int cardBattle(CardEntity cardOne, CardEntity cardTwo) {
        if ( ((cardOne.id + 11)%13) < ((cardTwo.id + 11)%13) ) {
            return Round.PLAYER_TWO_WINS;
        }
        else if ( ((cardOne.id + 11)%13) > ((cardTwo.id + 11)%13) ) {
            return Round.PLAYER_ONE_WINS;
        }
        else return  Round.DRAW;
    }
}
