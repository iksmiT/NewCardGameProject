package timski_ensicaen.newcardgameproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayActivity extends AppCompatActivity {
    int cnt = 1;
    CardDeck mCardDeck = new CardDeck();
    Round mRound = new Round();
    CardEntity cardOne = new CardEntity(1);
    CardEntity cardTwo = new CardEntity(2);
    Button switchTurnButton = null;
    ImageView cardImageOne = null;
    ImageView cardImageTwo = null;
    TextView scorePlayerOne = null;
    TextView scorePlayerTwo = null;
    TextView endText = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        TextView playerOneText = (TextView) findViewById(R.id.text_one);
        TextView playerTwoText = (TextView) findViewById(R.id.text_two);
        Button pickDeckButtonOne = (Button) findViewById(R.id.pick_from_one);
        Button pickDeckButtonTwo = (Button) findViewById(R.id.pick_from_two);
        switchTurnButton = (Button) findViewById(R.id.next_turn_button);
        cardImageOne = (ImageView) findViewById(R.id.image_view_one);
        cardImageTwo = (ImageView) findViewById(R.id.image_view_two);
        scorePlayerOne = (TextView) findViewById(R.id.score_one_text);
        scorePlayerTwo = (TextView) findViewById(R.id.score_two_text);
        endText = (TextView) findViewById(R.id.end_text);

        initGame(mRound, pickDeckButtonOne, pickDeckButtonTwo, playerOneText, playerTwoText);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Button pickDeckButtonOne = (Button) findViewById(R.id.pick_from_one);
        pickDeckButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cardOne = mCardDeck.pickCardEntity();
                cardOne = mCardDeck.pickCardEntity(mCardDeck.getPlayer_one_deck());
                ImageView cardImage = (ImageView) findViewById(R.id.image_view_one);
                TextView playerOneText = (TextView) findViewById(R.id.text_one);
                TextView playerTwoText = (TextView) findViewById(R.id.text_two);
                Button pickDeckButtonOne = (Button) findViewById(R.id.pick_from_one);
                Button pickDeckButtonTwo = (Button) findViewById(R.id.pick_from_two);

                if (cardOne != null) {
                    displayCardEntity(cardImageOne, cardOne.getId(), globalValues.customWidth, globalValues.customHeight);
                }
                //mRound.changeTurn();
                turnSystem(mRound,pickDeckButtonOne, pickDeckButtonTwo, playerOneText, playerTwoText);
            }
        });

        Button pickDeckButtonTwo = (Button) findViewById(R.id.pick_from_two);
        pickDeckButtonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //cardTwo = mCardDeck.pickCardEntity();
                cardTwo = mCardDeck.pickCardEntity(mCardDeck.getPlayer_two_deck());
                cardImageTwo = (ImageView) findViewById(R.id.image_view_two);
                TextView playerOneText = (TextView) findViewById(R.id.text_one);
                TextView playerTwoText = (TextView) findViewById(R.id.text_two);
                Button pickDeckButtonOne = (Button) findViewById(R.id.pick_from_one);
                Button pickDeckButtonTwo = (Button) findViewById(R.id.pick_from_two);

                if (cardTwo != null) {
                    displayCardEntity(cardImageTwo, cardTwo.getId(), globalValues.customWidth, globalValues.customHeight);
                }
                //mRound.changeTurn();
                turnSystem(mRound, pickDeckButtonOne, pickDeckButtonTwo, playerOneText, playerTwoText);
            }
        });


        //Button switchTurnButton = (Button) findViewById(R.id.next_turn_button);
        switchTurnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView playerOneText = (TextView) findViewById(R.id.text_one);
                TextView playerTwoText = (TextView) findViewById(R.id.text_two);
                Button pickDeckButtonOne = (Button) findViewById(R.id.pick_from_one);
                Button pickDeckButtonTwo = (Button) findViewById(R.id.pick_from_two);

                //if (mRound.getPhase() != Round.FINAL_PHASE) {
                if ((mRound.getPhase() == Round.PICK_PHASE)) {
                    newRound(mRound, pickDeckButtonOne, pickDeckButtonTwo, playerOneText, playerTwoText);
                    //turnSystem(mRound, pickDeckButtonOne, pickDeckButtonTwo, playerOneText, playerTwoText);
                } else if ((mRound.getPhase() == Round.BATTLE_PHASE)) {
                    newRound(mRound, pickDeckButtonOne, pickDeckButtonTwo, playerOneText, playerTwoText);
                    turnSystem(mRound, pickDeckButtonOne, pickDeckButtonTwo, playerOneText, playerTwoText);
                } else if (mRound.getPhase() == Round.WINNER_PHASE) {

                } else {
                    //resetGame(mRound, pickDeckButtonOne, pickDeckButtonTwo, playerOneText, playerTwoText);
                    initGame(mRound, pickDeckButtonOne, pickDeckButtonTwo, playerOneText, playerTwoText);
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

    public void changeTextDisplayed(TextView mTextView1, TextView mTextView2, Round round)  {
        if (round.getTurn() == Round.PLAYER_ONE_TURN ) {
            mTextView1.setText("PLAYER ONE'S TURN !!!");
            mTextView2.setText("");
        }
        else {
            mTextView2.setText("PLAYER TWO'S TURN !!!");
            mTextView1.setText("");
        }
    }

    public void initGame(Round round, Button buttonOne, Button buttonTwo, TextView mTextView1, TextView mTextView2) {
        mCardDeck = new CardDeck();
        mRound = new Round();
        scorePlayerOne.setText(String.valueOf(mRound.getPlayerOneScore()));
        scorePlayerTwo.setText(String.valueOf(mRound.getPlayerTwoScore()));
        cardImageOne.setImageResource(android.R.color.transparent);
        cardImageTwo.setImageResource(android.R.color.transparent);
        switchTurnButton.setText("NEXT ROUND");
        endText.setText("");
        if (mRound.getTurn() == Round.PLAYER_ONE_TURN) {
            buttonTwo.setEnabled(false);
            buttonOne.setEnabled(true);
            mTextView1.setText("PLAYER ONE'S TURN !!!");
            mTextView2.setText("");

        } else {
            buttonOne.setEnabled(false);
            buttonTwo.setEnabled(true);
            mTextView2.setText("PLAYER TWO'S TURN !!!");
            mTextView1.setText("");
        }
        switchTurnButton.setVisibility(View.GONE);
        Log.d("INIT", "INIT GAME " + "PHASE : " + String.valueOf(mRound.getPhase()) + "TURN OF " + String.valueOf(mRound.getTurn()) + " card left one : " + String.valueOf(mCardDeck.getPlayer_one_deck().size()) + " card left two : " + String.valueOf(mCardDeck.getPlayer_two_deck().size()) + " score one : " + String.valueOf(mRound.getPlayerOneScore()) + " score two : " + String.valueOf(mRound.getPlayerTwoScore()));
    }


    public void newRound(Round round, Button buttonOne, Button buttonTwo, TextView mTextView1, TextView mTextView2) {
        mRound.setPlayerOnePlayed(false);
        mRound.setPlayerTwoPlayed(false);
        //mRound.setPhase(Round.PICK_PHASE);
        scorePlayerOne.setText(String.valueOf(mRound.getPlayerOneScore()));
        scorePlayerTwo.setText(String.valueOf(mRound.getPlayerTwoScore()));
        cardImageOne.setImageResource(android.R.color.transparent);
        cardImageTwo.setImageResource(android.R.color.transparent);
        if (mRound.getTurn() == Round.PLAYER_ONE_TURN) {
            buttonTwo.setEnabled(false);
            buttonOne.setEnabled(true);
            mTextView1.setText("PLAYER ONE'S TURN !!!");
            mTextView2.setText("");

        } else {
            buttonOne.setEnabled(false);
            buttonTwo.setEnabled(true);
            mTextView2.setText("PLAYER TWO'S TURN !!!");
            mTextView1.setText("");
        }
        switchTurnButton.setVisibility(View.GONE);
        Log.d("NEW ROUND", "PHASE : " + String.valueOf(mRound.getPhase()) + " play_one_played = " + String.valueOf(mRound.getPlayerOnePlayed()) + " player_two_played = " + String.valueOf(mRound.getPlayerTwoPlayed()) + " card left one : " + String.valueOf(mCardDeck.getPlayer_one_deck().size()) + " card left two : " + String.valueOf(mCardDeck.getPlayer_two_deck().size()) + " score one : " + String.valueOf(mRound.getPlayerOneScore()) + " score two : " + String.valueOf(mRound.getPlayerTwoScore()));
    }

    public void resetGame(Round round, Button buttonOne, Button buttonTwo, TextView mTextView1, TextView mTextView2) {
        mCardDeck = new CardDeck();
        mRound = new Round();
    }

    public void turnSystem(Round round, Button buttonOne, Button buttonTwo, TextView mTextView1, TextView mTextView2) {
        Log.d("TURN SYSTEM", "PHASE : " + String.valueOf(mRound.getPhase()));
        int winner;
        if ((round.getPhase() == Round.PICK_PHASE)) {
            Log.d("PICK PHASE", "PHASE : " + String.valueOf(mRound.getPhase()));

            if (round.getTurn() == Round.PLAYER_ONE_TURN) {
                Log.d("PICK PHASE", "PHASE : " + String.valueOf(mRound.getPhase()) + "| PLAYER ONE PICK " + "| PLAYER ONE STATE : " + String.valueOf(mRound.getPlayerOnePlayed()) + "| PLAYER TWO STATE : " + String.valueOf(mRound.getPlayerTwoPlayed()) + " card left one : " + String.valueOf(mCardDeck.getPlayer_one_deck().size()) + " card left two : " + String.valueOf(mCardDeck.getPlayer_two_deck().size()) + " score one : " + String.valueOf(mRound.getPlayerOneScore()) + " score two : " + String.valueOf(mRound.getPlayerTwoScore()));
                buttonOne.setEnabled(false);
                buttonTwo.setEnabled(true);
                mTextView2.setText("PLAYER TWO'S TURN !!!");
                mTextView1.setText("");
                round.setTurn(Round.PLAYER_TWO_TURN);
                round.setPlayerOnePlayed(true);
                Log.d("PICK PHASE", "PHASE : " + String.valueOf(mRound.getPhase()) + "| PLAYER ONE PICK " + "| PLAYER ONE STATE : " + String.valueOf(mRound.getPlayerOnePlayed()) + "| PLAYER TWO STATE : " + String.valueOf(mRound.getPlayerTwoPlayed()) + " card left one : " + String.valueOf(mCardDeck.getPlayer_one_deck().size()) + " card left two : " + String.valueOf(mCardDeck.getPlayer_two_deck().size())+ " score one : " + String.valueOf(mRound.getPlayerOneScore()) + " score two : " + String.valueOf(mRound.getPlayerTwoScore()));
            }
            else if (round.getTurn() == Round.PLAYER_TWO_TURN) {
                Log.d("PICK PHASE", "PHASE : " + String.valueOf(mRound.getPhase()) + "| PLAYER ONE PICK " + "| PLAYER ONE STATE : " + String.valueOf(mRound.getPlayerOnePlayed()) + "| PLAYER TWO STATE : " + String.valueOf(mRound.getPlayerTwoPlayed()) + " card left one : " + String.valueOf(mCardDeck.getPlayer_one_deck().size()) + " card left two : " + String.valueOf(mCardDeck.getPlayer_two_deck().size()) +" score one : "+ String.valueOf(mRound.getPlayerOneScore()) + " score two : " + String.valueOf(mRound.getPlayerTwoScore()));
                buttonTwo.setEnabled(false);
                buttonOne.setEnabled(true);
                mTextView1.setText("PLAYER ONE'S TURN !!!");
                mTextView2.setText("");
                round.setTurn(Round.PLAYER_ONE_TURN);
                round.setPlayerTwoPlayed(true);
                Log.d("PICK PHASE", "PHASE : " + String.valueOf(mRound.getPhase()) + "| PLAYER ONE PICK " + "| PLAYER ONE STATE : " + String.valueOf(mRound.getPlayerOnePlayed()) + "| PLAYER TWO STATE : " + String.valueOf(mRound.getPlayerTwoPlayed()) + " card left one : " + String.valueOf(mCardDeck.getPlayer_one_deck().size()) + " card left two : " + String.valueOf(mCardDeck.getPlayer_two_deck().size())+ " score one : " + String.valueOf(mRound.getPlayerOneScore()) + " score two : " + String.valueOf(mRound.getPlayerTwoScore()));
            }

            if (round.getPlayerOnePlayed() && round.getPlayerTwoPlayed()) {
                Log.d("PICK PHASE", "PHASE : " + String.valueOf(mRound.getPhase()) + " SWITCH TO BATTLE PHASE ");
                //round.setPhase(Round.BATTLE_PHASE);
                buttonOne.setEnabled(false);
                buttonTwo.setEnabled(false);

                if ((mCardDeck.getPlayer_one_deck().size() == 0) && (mCardDeck.getPlayer_two_deck().size() == 0)) {
                    //if ((mCardDeck.getPlayer_one_deck().size() == 0) || (mCardDeck.getPlayer_one_deck().size() == 0)) {
                    if (round.getPlayerOneScore() > round.getPlayerTwoScore()) {
                        endText.setText("PLAYER 1 WINS");
                    }
                    else if (round.getPlayerTwoScore() > round.getPlayerOneScore()) {
                        endText.setText("PLAYER 2 WINS");
                    }
                    else {endText.setText("DRAW GAME !");}
                    switchTurnButton.setText("REMATCH");
                    mRound.setPhase(Round.FINAL_PHASE);
                    Log.d("BATTLE PHASE", "phase = " + mRound.getPhase() + " play_one_played = " + String.valueOf(cardOne.getId()) + " player_two_played = " + String.valueOf(cardTwo.getId()) + " card left one : " + String.valueOf(mCardDeck.getPlayer_one_deck().size()) + " card left two : " + String.valueOf(mCardDeck.getPlayer_two_deck().size()) + " score one : " + String.valueOf(mRound.getPlayerOneScore()) + " score two : " + String.valueOf(mRound.getPlayerTwoScore()));
                }
                else {
                    winner = CardEntity.cardBattle(cardOne, cardTwo);
                    Log.d("BATTLE PHASE", "phase = " + mRound.getPhase() + " play_one_played = " + String.valueOf(cardOne.getId()) + " player_two_played = " + String.valueOf(cardTwo.getId()) + " winner = " + String.valueOf(winner) + " card left one : " + String.valueOf(mCardDeck.getPlayer_one_deck().size()) + " card left two : " + String.valueOf(mCardDeck.getPlayer_two_deck().size()) + " score one : " + String.valueOf(mRound.getPlayerOneScore()) + " score two : " + String.valueOf(mRound.getPlayerTwoScore()));
                    if (winner == Round.PLAYER_ONE_WINS) {
                        mTextView1.setText("PLAY ONE SCORES !");
                        mTextView2.setText("PLAY TWO LOSES !");
                        //mCardDeck.pickCardEntityFromDiscard(Round.PLAYER_ONE_WINS);
                        mRound.setPlayerOneScore(mRound.getPlayerOneScore() + mRound.getPoint());
                        //mRound.setPlayerTwoScore(mRound.getPlayerTwoScore() - mRound.getPoint());
                        mRound.setPoint(1);
                    } else if (winner == Round.PLAYER_TWO_WINS) {
                        mTextView2.setText("PLAY TWO SCORES !");
                        mTextView1.setText("PLAY ONE LOSES !");
                        //mCardDeck.pickCardEntityFromDiscard(Round.PLAYER_TWO_WINS);
                        mRound.setPlayerTwoScore(mRound.getPlayerTwoScore() + mRound.getPoint());
                        //mRound.setPlayerOneScore(mRound.getPlayerOneScore() - mRound.getPoint());
                        mRound.setPoint(1);
                    } else {
                        mTextView2.setText("DRAW !");
                        mTextView1.setText("DRAW !");
                        if ((mCardDeck.getPlayer_one_deck().size() > 1) || (mCardDeck.getPlayer_two_deck().size() > 1)) {
                            mCardDeck.pickCardEntity(mCardDeck.getPlayer_one_deck());
                            mCardDeck.pickCardEntity(mCardDeck.getPlayer_two_deck());
                            mRound.setPoint(mRound.getPoint() + 2);
                        } else if ((mCardDeck.getPlayer_one_deck().size() == 1) || (mCardDeck.getPlayer_two_deck().size() == 1)) {
                            winner = CardEntity.cardBattle(mCardDeck.pickCardEntity(mCardDeck.getPlayer_one_deck()), mCardDeck.pickCardEntity(mCardDeck.getPlayer_two_deck()));
                            if (winner == Round.PLAYER_ONE_WINS) {
                                mTextView1.setText("PLAY ONE SCORES !");
                                mTextView2.setText("PLAY TWO LOSES !");
                                mRound.setPlayerOneScore(mRound.getPlayerOneScore() + mRound.getPoint());
                                mRound.setPoint(1);
                            } else if (winner == Round.PLAYER_TWO_WINS) {
                                mTextView2.setText("PLAY TWO SCORES !");
                                mTextView1.setText("PLAY ONE LOSES !");
                                mRound.setPlayerTwoScore(mRound.getPlayerTwoScore() + mRound.getPoint());
                                mRound.setPoint(1);
                            }
                        }
                    }
                    switchTurnButton.setText("NEXT ROUND");
                }
                scorePlayerOne.setText(String.valueOf(mRound.getPlayerOneScore()));
                scorePlayerTwo.setText(String.valueOf(mRound.getPlayerTwoScore()));
                switchTurnButton.setVisibility(View.VISIBLE);
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
