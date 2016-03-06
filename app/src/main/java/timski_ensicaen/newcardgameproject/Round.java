package timski_ensicaen.newcardgameproject;

public class Round {
    private int turn;
    private int phase;
    private int winner;
    private boolean playerOnePlayed;
    private boolean playerTwoPlayed;
    private int point;
    private int playerOneScore;
    private int playerTwoScore;

    public static final int PLAYER_ONE_TURN     = 1;
    public static final int PLAYER_TWO_TURN     = 2;

    public static final int PICK_PHASE          = 1;
    public static final int BATTLE_PHASE        = 2;
    public static final int WINNER_PHASE        = 3;
    public static final int FINAL_PHASE         = 4;

    public static final int DRAW                = 0;
    public static final int PLAYER_ONE_WINS     = 1;
    public static final int PLAYER_TWO_WINS     = 2;

    public Round() {
        this.turn = globalValues.rndFunction(PLAYER_ONE_TURN,PLAYER_TWO_TURN);
        this.phase = PICK_PHASE;
        this.winner = 0;
        this.playerOnePlayed = false;
        this.playerTwoPlayed = false;
        this.point = 1;
        this.playerOneScore = 0;
        this.playerTwoScore = 0;
    }

    public int getTurn() {
        return turn;
    }

    public void setTurn(int trn) {
        this.turn = trn;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int ph) {
        this.phase = ph;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int win) {
        this.winner = win;
    }

    public boolean getPlayerOnePlayed() {
        return this.playerOnePlayed;
    }

    public void setPlayerOnePlayed(boolean bool) {
        this.playerOnePlayed = bool;
    }

    public boolean getPlayerTwoPlayed() {
        return this.playerTwoPlayed;
    }

    public void setPlayerTwoPlayed(boolean bool) {
        this.playerTwoPlayed = bool;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int pnt) {
        this.point = pnt;
    }

    public int getPlayerOneScore() {
        return playerOneScore;
    }

    public void setPlayerOneScore(int playerOneScore) {
        this.playerOneScore = playerOneScore;
    }

    public int getPlayerTwoScore() {
        return playerTwoScore;
    }

    public void setPlayerTwoScore(int playerTwoScore) {
        this.playerTwoScore = playerTwoScore;
    }

    public void changeTurn() {
        if (this.turn == PLAYER_ONE_TURN) {
            this.turn = PLAYER_TWO_TURN;
            this.playerOnePlayed = true;
        }
        else {
            this.turn = PLAYER_ONE_TURN;
            this.playerTwoPlayed = true;
        }
    }



}
