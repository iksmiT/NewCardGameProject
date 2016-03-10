package timski_ensicaen.newcardgameproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {
    CardDeck mCardDeck;
    Round mRound;
    CardEntity cardOne;
    CardEntity cardTwo;
    Button switchTurnButton;
    ImageView cardImageOne;
    ImageView cardImageTwo;
    TextView scorePlayerOne;
    TextView scorePlayerTwo;
    TextView endText;
    TextView playerOneText;
    TextView playerTwoText;
    Button pickDeckButtonOne;
    Button pickDeckButtonTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        playerOneText = (TextView) findViewById(R.id.text_one);
        playerTwoText = (TextView) findViewById(R.id.text_two);
        pickDeckButtonOne = (Button) findViewById(R.id.pick_from_one);
        pickDeckButtonTwo = (Button) findViewById(R.id.pick_from_two);
        switchTurnButton = (Button) findViewById(R.id.next_turn_button);
        cardImageOne = (ImageView) findViewById(R.id.image_view_one);
        cardImageTwo = (ImageView) findViewById(R.id.image_view_two);
        scorePlayerOne = (TextView) findViewById(R.id.score_one_text);
        scorePlayerTwo = (TextView) findViewById(R.id.score_two_text);
        endText = (TextView) findViewById(R.id.end_text);
        cardOne = new CardEntity(1);
        cardTwo = new CardEntity(2);

        initGame();
    }

    @Override
    protected void onStart() {
        super.onStart();

        pickDeckButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardOne = mCardDeck.pickCardEntity(mCardDeck.getPlayer_one_deck());
                if (cardOne != null) {
                    displayCardEntity(cardImageOne, cardOne.getId(), globalValues.customWidth, globalValues.customHeight);
                }
                turnSystem();
            }
        });

        pickDeckButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardTwo = mCardDeck.pickCardEntity(mCardDeck.getPlayer_two_deck());

                if (cardTwo != null) {
                    displayCardEntity(cardImageTwo, cardTwo.getId(), globalValues.customWidth, globalValues.customHeight);
                }
                turnSystem();
            }
        });

        switchTurnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((mRound.getPhase() == Round.PICK_PHASE)) {
                    newRound();
                } else if ((mRound.getPhase() == Round.BATTLE_PHASE)) {
                    newRound();
                } else {
                    initGame();
                }
            }
        });
    }
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void initGame() {
        mCardDeck = new CardDeck();
        mRound = new Round();
        scorePlayerOne.setText(String.valueOf(mRound.getPlayerOneScore()));
        scorePlayerTwo.setText(String.valueOf(mRound.getPlayerTwoScore()));
        cardImageOne.setImageResource(android.R.color.transparent);
        cardImageTwo.setImageResource(android.R.color.transparent);
        switchTurnButton.setText("NEXT ROUND");
        endText.setText("");
        if (mRound.getTurn() == Round.PLAYER_ONE_TURN) {
            pickDeckButtonTwo.setEnabled(false);
            pickDeckButtonOne.setEnabled(true);
            playerOneText.setText("PLAYER ONE'S TURN !!!");
            playerTwoText.setText("");

        } else {
            pickDeckButtonOne.setEnabled(false);
            pickDeckButtonTwo.setEnabled(true);
            playerTwoText.setText("PLAYER TWO'S TURN !!!");
            playerOneText.setText("");
        }
        switchTurnButton.setVisibility(View.GONE);
        Log.d("INIT", "INIT GAME " + "PHASE : " + String.valueOf(mRound.getPhase()) + "TURN OF " + String.valueOf(mRound.getTurn()) + " card left one : " + String.valueOf(mCardDeck.getPlayer_one_deck().size()) + " card left two : " + String.valueOf(mCardDeck.getPlayer_two_deck().size()) + " score one : " + String.valueOf(mRound.getPlayerOneScore()) + " score two : " + String.valueOf(mRound.getPlayerTwoScore()));
    }


    public void newRound() {
        mRound.setPlayerOnePlayed(false);
        mRound.setPlayerTwoPlayed(false);
        scorePlayerOne.setText(String.valueOf(mRound.getPlayerOneScore()));
        scorePlayerTwo.setText(String.valueOf(mRound.getPlayerTwoScore()));
        cardImageOne.setImageResource(android.R.color.transparent);
        cardImageTwo.setImageResource(android.R.color.transparent);
        if (mRound.getTurn() == Round.PLAYER_ONE_TURN) {
            pickDeckButtonTwo.setEnabled(false);
            pickDeckButtonOne.setEnabled(true);
            playerOneText.setText("PLAYER ONE'S TURN !!!");
            playerTwoText.setText("");

        } else {
            pickDeckButtonOne.setEnabled(false);
            pickDeckButtonTwo.setEnabled(true);
            playerTwoText.setText("PLAYER TWO'S TURN !!!");
            playerOneText.setText("");
        }
        mRound.setPhase(Round.PICK_PHASE);
        switchTurnButton.setVisibility(View.GONE);
        Log.d("NEW ROUND", "PHASE : " + String.valueOf(mRound.getPhase()) + " play_one_played = " + String.valueOf(mRound.getPlayerOnePlayed()) + " player_two_played = " + String.valueOf(mRound.getPlayerTwoPlayed()) + " card left one : " + String.valueOf(mCardDeck.getPlayer_one_deck().size()) + " card left two : " + String.valueOf(mCardDeck.getPlayer_two_deck().size()) + " score one : " + String.valueOf(mRound.getPlayerOneScore()) + " score two : " + String.valueOf(mRound.getPlayerTwoScore()));
    }

    public void turnSystem() {
        Log.d("TURN SYSTEM", "PHASE : " + String.valueOf(mRound.getPhase()));
        int winner;
        if ((mRound.getPhase() == Round.PICK_PHASE)) {
            Log.d("PICK PHASE", "PHASE : " + String.valueOf(mRound.getPhase()));
            Log.d("POINT CARTES 1: ", "| CARTES ONE REST. : " + String.valueOf(mCardDeck.getPlayer_one_deck().size()) + " | CARTES TWO REST. : " + String.valueOf(mCardDeck.getPlayer_two_deck().size()));
            Log.d("PICK PHASE", "PHASE : " + String.valueOf(mRound.getPhase()) + "| PLAYER ONE PICK " + "| PLAYER ONE STATE : " + String.valueOf(mRound.getPlayerOnePlayed()) + "| PLAYER TWO STATE : " + String.valueOf(mRound.getPlayerTwoPlayed()) + " card left one : " + String.valueOf(mCardDeck.getPlayer_one_deck().size()) + " card left two : " + String.valueOf(mCardDeck.getPlayer_two_deck().size()) + " score one : " + String.valueOf(mRound.getPlayerOneScore()) + " score two : " + String.valueOf(mRound.getPlayerTwoScore()));
            if (mRound.getTurn() == Round.PLAYER_ONE_TURN) {
                pickDeckButtonOne.setEnabled(false);
                pickDeckButtonTwo.setEnabled(true);
                playerTwoText.setText("PLAYER TWO'S TURN !!!");
                playerOneText.setText("");
                mRound.setTurn(Round.PLAYER_TWO_TURN);
                mRound.setPlayerOnePlayed(true);
            } else if (mRound.getTurn() == Round.PLAYER_TWO_TURN) {
                pickDeckButtonTwo.setEnabled(false);
                pickDeckButtonOne.setEnabled(true);
                playerOneText.setText("PLAYER ONE'S TURN !!!");
                playerTwoText.setText("");
                mRound.setTurn(Round.PLAYER_ONE_TURN);
                mRound.setPlayerTwoPlayed(true);
                }
            Log.d("POINT CARTES 2: ", "| CARTES ONE REST. : " + String.valueOf(mCardDeck.getPlayer_one_deck().size()) + " | CARTES TWO REST. : " + String.valueOf(mCardDeck.getPlayer_two_deck().size()));
            Log.d("PICK PHASE", "PHASE : " + String.valueOf(mRound.getPhase()) + " | CARTES ONE REST. : " + String.valueOf(mCardDeck.getPlayer_one_deck().size()) + " | CARTES TWO REST. : " + String.valueOf(mCardDeck.getPlayer_two_deck().size()) + " score one : " + String.valueOf(mRound.getPlayerOneScore()) + " score two : " + String.valueOf(mRound.getPlayerTwoScore()));
            if (mRound.getPlayerOnePlayed() && mRound.getPlayerTwoPlayed()) {
                Log.d("POINT CARTES 3: ", "| CARTES ONE REST. : " + String.valueOf(mCardDeck.getPlayer_one_deck().size()) + " | CARTES TWO REST. : " + String.valueOf(mCardDeck.getPlayer_two_deck().size()));
                mRound.setPhase(Round.BATTLE_PHASE);
                pickDeckButtonOne.setEnabled(false);
                pickDeckButtonTwo.setEnabled(false);
                Log.d("BATTLE PHASE 1 ", "PHASE : " + String.valueOf(mRound.getPhase()) + " SWITCH TO BATTLE PHASE " + " | CAGNOTTE : " + String.valueOf(mRound.getPoint()));
                if ((mCardDeck.getPlayer_one_deck().size() == 0) && (mCardDeck.getPlayer_two_deck().size() == 0)) {
                    winner = CardEntity.cardBattle(cardOne, cardTwo);
                    Log.d("BATTLE PHASE 4 ", "phase = " + mRound.getPhase() + " | CAGNOTTE : " + String.valueOf(mRound.getPoint()));
                    if (winner == Round.PLAYER_ONE_WINS) {
                        playerOneText.setText("PLAY ONE SCORES !");
                        playerTwoText.setText("PLAY TWO LOSES !");
                        mRound.setPlayerOneScore(mRound.getPlayerOneScore() + mRound.getPoint());
                        mRound.setPoint(1);
                    } else if (winner == Round.PLAYER_TWO_WINS) {
                        playerTwoText.setText("PLAY TWO SCORES !");
                        playerOneText.setText("PLAY ONE LOSES !");
                        mRound.setPlayerTwoScore(mRound.getPlayerTwoScore() + mRound.getPoint());
                        mRound.setPoint(1);
                    } else {
                        playerTwoText.setText("DRAW !");
                        playerOneText.setText("DRAW !");
                    }
                    if (mRound.getPlayerOneScore() > mRound.getPlayerTwoScore()) {
                        endText.setText("PLAYER 1 WINS");
                    } else if (mRound.getPlayerTwoScore() > mRound.getPlayerOneScore()) {
                        endText.setText("PLAYER 2 WINS");
                    } else {
                        endText.setText("DRAW GAME !");
                    }
                    switchTurnButton.setText("REMATCH");
                    mRound.setPhase(Round.FINAL_PHASE);
                    Log.d("BATTLE PHASE 2 ", "phase = " + mRound.getPhase() + " | CAGNOTTE : " + String.valueOf(mRound.getPoint()));
                } else if ((mCardDeck.getPlayer_one_deck().size() == 1) && (mCardDeck.getPlayer_two_deck().size() == 1)) {
                    winner = CardEntity.cardBattle(cardOne, cardTwo);
                    Log.d("BATTLE PHASE 3 ", "phase = " + mRound.getPhase() + " | CAGNOTTE : " + String.valueOf(mRound.getPoint()));
                    if (winner == Round.PLAYER_ONE_WINS) {
                        playerOneText.setText("PLAY ONE SCORES !");
                        playerTwoText.setText("PLAY TWO LOSES !");
                        mRound.setPlayerOneScore(mRound.getPlayerOneScore() + mRound.getPoint());
                        mRound.setPoint(1);
                    } else if (winner == Round.PLAYER_TWO_WINS) {
                        playerTwoText.setText("PLAY TWO SCORES !");
                        playerOneText.setText("PLAY ONE LOSES !");
                        mRound.setPlayerTwoScore(mRound.getPlayerTwoScore() + mRound.getPoint());
                        mRound.setPoint(1);
                    } else {
                        playerTwoText.setText("DRAW !");
                        playerOneText.setText("DRAW !");
                        mRound.setPoint(mRound.getPoint() + 1);
                    }
                    Log.d("BATTLE PHASE 4 ", "phase = " + mRound.getPhase() + " | CAGNOTTE : " + String.valueOf(mRound.getPoint()));
                } else {
                    winner = CardEntity.cardBattle(cardOne, cardTwo);
                    Log.d("BATTLE PHASE 5 ", "phase = " + mRound.getPhase() + " | CAGNOTTE : " + String.valueOf(mRound.getPoint()));if (winner == Round.PLAYER_ONE_WINS) {
                        playerOneText.setText("PLAY ONE SCORES !");
                        playerTwoText.setText("PLAY TWO LOSES !");
                        mRound.setPlayerOneScore(mRound.getPlayerOneScore() + mRound.getPoint());
                        mRound.setPoint(1);
                    } else if (winner == Round.PLAYER_TWO_WINS) {
                        playerTwoText.setText("PLAY TWO SCORES !");
                        playerOneText.setText("PLAY ONE LOSES !");
                        mRound.setPlayerTwoScore(mRound.getPlayerTwoScore() + mRound.getPoint());
                        mRound.setPoint(1);
                    } else {
                        playerTwoText.setText("DRAW !");
                        playerOneText.setText("DRAW !");
                        mCardDeck.pickCardEntity(mCardDeck.getPlayer_one_deck());
                        mCardDeck.pickCardEntity(mCardDeck.getPlayer_two_deck());
                        mRound.setPoint(mRound.getPoint() + 2);
                    }
                    pickDeckButtonOne.setEnabled(false);
                    pickDeckButtonTwo.setEnabled(false);
                    Log.d("POINT CARTES 4: ", "| CARTES ONE REST. : " + String.valueOf(mCardDeck.getPlayer_one_deck().size()) + " | CARTES TWO REST. : " + String.valueOf(mCardDeck.getPlayer_two_deck().size()));
                    Log.d("BATTLE PHASE 6 ", "phase = " + mRound.getPhase() + " | CAGNOTTE : " + String.valueOf(mRound.getPoint()));
                }
                switchTurnButton.setVisibility(View.VISIBLE);
                scorePlayerOne.setText(String.valueOf(mRound.getPlayerOneScore()));
                scorePlayerTwo.setText(String.valueOf(mRound.getPlayerTwoScore()));
            }
        }
    }

    public void displayCardEntity(ImageView imageView, int i, int customWidth, int customHeight) {
        switch (i) {
            case(1) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.ace_of_spades_w720, customWidth, customHeight));
                break;
            case(2) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.two_of_spades_w720, customWidth, customHeight));
                break;
            case(3) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.three_of_spades_w720, customWidth, customHeight));
                break;
            case(4) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.four_of_spades_w720, customWidth, customHeight));
                break;
            case(5) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.five_of_spades_w720, customWidth, customHeight));
                break;
            case(6) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.six_of_spades_w720, customWidth, customHeight));
                break;
            case(7) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.seven_of_spades_w720, customWidth, customHeight));
                break;
            case(8) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.eight_of_spades_w720, customWidth, customHeight));
                break;
            case(9) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.nine_of_spades_w720, customWidth, customHeight));
                break;
            case(10) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.ten_of_spades_w720, customWidth, customHeight));
                break;
            case(11) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.jack_of_spades_w720, customWidth, customHeight));
                break;
            case(12) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.queen_of_spades_w720, customWidth, customHeight));
                break;
            case(13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.king_of_spades_w720, customWidth, customHeight));
                break;
            case(1+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.ace_of_clubs_w720, customWidth, customHeight));
                break;
            case(2+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.two_of_clubs_w720, customWidth, customHeight));
                break;
            case(3+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.three_of_clubs_w720, customWidth, customHeight));
                break;
            case(4+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.four_of_clubs_w720, customWidth, customHeight));
                break;
            case(5+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.five_of_clubs_w720, customWidth, customHeight));
                break;
            case(6+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.six_of_clubs_w720, customWidth, customHeight));
                break;
            case(7+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.seven_of_clubs_w720, customWidth, customHeight));
                break;
            case(8+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.eight_of_clubs_w720, customWidth, customHeight));
                break;
            case(9+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.nine_of_clubs_w720, customWidth, customHeight));
                break;
            case(10+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.ten_of_clubs_w720, customWidth, customHeight));
                break;
            case(11+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.jack_of_clubs_w720, customWidth, customHeight));
                break;
            case(12+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.queen_of_clubs_w720, customWidth, customHeight));
                break;
            case(13+13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.king_of_clubs_w720, customWidth, customHeight));
                break;
            case(1+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.ace_of_hearts_w720, customWidth, customHeight));
                break;
            case(2+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.two_of_hearts_w720, customWidth, customHeight));
                break;
            case(3+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.three_of_hearts_w720, customWidth, customHeight));
                break;
            case(4+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.four_of_hearts_w720, customWidth, customHeight));
                break;
            case(5+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.five_of_hearts_w720, customWidth, customHeight));
                break;
            case(6+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.six_of_hearts_w720, customWidth, customHeight));
                break;
            case(7+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.seven_of_hearts_w720, customWidth, customHeight));
                break;
            case(8+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.eight_of_hearts_w720, customWidth, customHeight));
                break;
            case(9+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.nine_of_hearts_w720, customWidth, customHeight));
                break;
            case(10+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.ten_of_hearts_w720, customWidth, customHeight));
                break;
            case(11+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.jack_of_hearts_w720, customWidth, customHeight));
                break;
            case(12+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.queen_of_hearts_w720, customWidth, customHeight));
                break;
            case(13+2*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.king_of_hearts_w720, customWidth, customHeight));
                break;
            case(1+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.ace_of_diamonds_w720, customWidth, customHeight));
                break;
            case(2+3*13) :
                imageView.setImageBitmap(BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.two_of_diamonds_w720, customWidth, customHeight));
                break;
            case(3+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.three_of_diamonds_w720, customWidth, customHeight));
                break;
            case(4+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.four_of_diamonds_w720, customWidth, customHeight));
                break;
            case(5+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.five_of_diamonds_w720, customWidth, customHeight));
                break;
            case(6+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.six_of_diamonds_w720, customWidth, customHeight));
                break;
            case(7+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.seven_of_diamonds_w720, customWidth, customHeight));
                break;
            case(8+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.eight_of_diamonds_w720, customWidth, customHeight));
                break;
            case(9+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.nine_of_diamonds_w720, customWidth, customHeight));
                break;
            case(10+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.ten_of_diamonds_w720, customWidth, customHeight));
                break;
            case(11+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.jack_of_diamonds_w720, customWidth, customHeight));
                break;
            case(12+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.queen_of_diamonds_w720, customWidth, customHeight));
                break;
            case(13+3*13) :
                imageView.setImageBitmap( BitmapCustomMethods.decodeSampledBitmapFromResource(getResources(), R.drawable.king_of_diamonds_w720, customWidth, customHeight));
                break;
            default: {
                Log.d("EXCEPTION SWITCH", "carte no : " + String.valueOf(i));
            }
        }
    }
}
