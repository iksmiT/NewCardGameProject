package timski_ensicaen.newcardgameproject;

public class Round {
    private int turn;
    private int phase;
    private int winner;

    public static final int PLAYER_ONE_TURN = 1;
    public static final int PLAYER_TWO_TURN = 2;
    public static final int PICK_PHASE = 1;
    public static final int BATTLE_PHASE = 2;
    public static final int WINNER_PHASE = 3;

    public Round() {
        this.turn = globalValues.rndFunction(PLAYER_ONE_TURN,PLAYER_TWO_TURN);
        this.phase = PICK_PHASE;
        this.winner = 0;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public void changeTurn() {
        if (this.turn == PLAYER_ONE_TURN) {
            this.turn = PLAYER_TWO_TURN;
        }
        else this.turn = PLAYER_ONE_TURN;
    }

}
