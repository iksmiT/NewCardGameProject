package timski_ensicaen.newcardgameproject;

import android.widget.ImageView;

public class CardEntity {
    private int id;
    private boolean state = true;


    public CardEntity(int a, boolean bool) {
        this.id = a;
        this.state = bool;
    }

    public CardEntity(int a) {
        this.id = a;
        this.state = true;
    }

    public int getId() {
        return this.id;
    }

    public boolean getState() {
        return this.state;
    }

    public void setId(int a) {
        this.id = a;
    }

    public void setState(boolean bool) {
        this.state = bool;
    }
}
