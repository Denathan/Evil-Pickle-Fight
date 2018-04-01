package com.example.android.evilpicklefight;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int pickleHp = 41;
    int mortyHp = 41;
    int rickMana = 30;
    int mortyMana = 30;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RelativeLayout mortyWon = findViewById(R.id.morty_won);
        final RelativeLayout rickWon = findViewById(R.id.rick_won);

        final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.victory);
        final MediaPlayer hit = MediaPlayer.create(getApplicationContext(), R.raw.hit);

        final Button pickleFirst = findViewById(R.id.attackPickleFirst);
        final Button pickleSecond = findViewById(R.id.attackPickleSecond);
        final Button pickleThird = findViewById(R.id.attackPickleThird);

        final Button mortyThird = findViewById(R.id.attackMortyThird);
        final Button mortySecond = findViewById(R.id.attackMortySecond);
        final Button mortyFirst = findViewById(R.id.attackMortyFirst);

        final Button reset = findViewById(R.id.reset);

        final ImageView three = findViewById(R.id.three);
        final ImageView two = findViewById(R.id.two);
        final ImageView one = findViewById(R.id.one);
        final ImageView start = findViewById(R.id.start);

        final ImageView mortysClaw = findViewById(R.id.mortysClaw);
        final ImageView ricksClaw = findViewById(R.id.ricksClaw);

        pickleThird.setEnabled(true);
        pickleSecond.setEnabled(true);
        pickleFirst.setEnabled(true);
        mortyFirst.setEnabled(true);
        mortySecond.setEnabled(true);
        mortyThird.setEnabled(true);


        new CountDownTimer(1000, 500) {

            public void onTick(long millisUntilFinished) {
                three.setVisibility(View.VISIBLE);
                pickleThird.setEnabled(false);
                pickleSecond.setEnabled(false);
                pickleFirst.setEnabled(false);
                mortyFirst.setEnabled(false);
                mortySecond.setEnabled(false);
                mortyThird.setEnabled(false);
            }

            public void onFinish() {
                three.setVisibility(View.INVISIBLE);
                new CountDownTimer(1000, 500) {

                    public void onTick(long millisUntilFinished) {
                        two.setVisibility(View.VISIBLE);
                    }

                    public void onFinish() {
                        two.setVisibility(View.INVISIBLE);
                        new CountDownTimer(1000, 500) {

                            public void onTick(long millisUntilFinished) {
                                one.setVisibility(View.VISIBLE);
                            }

                            public void onFinish() {
                                one.setVisibility(View.INVISIBLE);
                                new CountDownTimer(1500, 500) {

                                    public void onTick(long millisUntilFinished) {
                                        start.setVisibility(View.VISIBLE);
                                    }

                                    public void onFinish() {
                                        start.setVisibility(View.INVISIBLE);
                                        pickleThird.setEnabled(true);
                                        pickleSecond.setEnabled(true);
                                        pickleFirst.setEnabled(true);
                                        mortyFirst.setEnabled(true);
                                        mortySecond.setEnabled(true);
                                        mortyThird.setEnabled(true);
                                    }
                                }.start();
                            }
                        }.start();
                    }
                }.start();
            }
        }.start();


        /**pickle attack for 3*/


        pickleThird.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mortyHp = mortyHp - 8;

                if (rickMana <= 5) {
                    mortyWon.setVisibility(View.VISIBLE);
                    pickleThird.setEnabled(true);
                    pickleSecond.setEnabled(true);
                    pickleFirst.setEnabled(true);
                    mortyFirst.setEnabled(false);
                    mortySecond.setEnabled(false);
                    mortyThird.setEnabled(false);
                    mp.start();
                } else {
                    if (mortyHp <= 0) {
                        rickWon.setVisibility(View.VISIBLE);
                        pickleThird.setEnabled(false);
                        pickleSecond.setEnabled(false);
                        pickleFirst.setEnabled(false);
                        mortyFirst.setEnabled(true);
                        mortySecond.setEnabled(true);
                        mortyThird.setEnabled(true);
                        mp.start();
                    } else {
                        displayForMorty(mortyHp);
                        pickleThird.setEnabled(false);
                        pickleSecond.setEnabled(false);
                        pickleFirst.setEnabled(false);
                        mortyFirst.setEnabled(true);
                        mortySecond.setEnabled(true);
                        mortyThird.setEnabled(true);
                        hit.start();

                        /**mana*/
                        rickMana = rickMana - 6;
                        if (rickMana <= 0) {
                            mortyWon.setVisibility(View.VISIBLE);
                            pickleThird.setEnabled(true);
                            pickleSecond.setEnabled(true);
                            pickleFirst.setEnabled(true);
                            mortyFirst.setEnabled(false);
                            mortySecond.setEnabled(false);
                            mortyThird.setEnabled(false);
                        } else {
                            displayManaForPickle(rickMana);
                        }

                        /**claw*/
                        new CountDownTimer(500, 250) {

                            public void onTick(long millisUntilFinished) {
                                ricksClaw.setVisibility(View.VISIBLE);
                            }

                            public void onFinish() {
                                ricksClaw.setVisibility(View.INVISIBLE);
                            }
                        }.start();
                    }
                }
            }
        });


        /**pickle attack for 2*/


        pickleSecond.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mortyHp = mortyHp - 4;

                if (rickMana <= 3) {
                    mortyWon.setVisibility(View.VISIBLE);
                    pickleThird.setEnabled(true);
                    pickleSecond.setEnabled(true);
                    pickleFirst.setEnabled(true);
                    mortyFirst.setEnabled(false);
                    mortySecond.setEnabled(false);
                    mortyThird.setEnabled(false);
                    mp.start();
                } else {
                    if (mortyHp <= 0) {
                        rickWon.setVisibility(View.VISIBLE);
                        pickleThird.setEnabled(false);
                        pickleSecond.setEnabled(false);
                        pickleFirst.setEnabled(false);
                        mortyFirst.setEnabled(true);
                        mortySecond.setEnabled(true);
                        mortyThird.setEnabled(true);
                        mp.start();
                    } else {
                        displayForMorty(mortyHp);
                        pickleThird.setEnabled(false);
                        pickleSecond.setEnabled(false);
                        pickleFirst.setEnabled(false);
                        mortyFirst.setEnabled(true);
                        mortySecond.setEnabled(true);
                        mortyThird.setEnabled(true);
                        hit.start();

                        /**mana*/
                        rickMana = rickMana - 4;
                        if (rickMana <= 0) {
                            mortyWon.setVisibility(View.VISIBLE);
                            pickleThird.setEnabled(true);
                            pickleSecond.setEnabled(true);
                            pickleFirst.setEnabled(true);
                            mortyFirst.setEnabled(false);
                            mortySecond.setEnabled(false);
                            mortyThird.setEnabled(false);
                        } else {
                            displayManaForPickle(rickMana);
                        }

                        /**claw*/
                        new CountDownTimer(500, 250) {

                            public void onTick(long millisUntilFinished) {
                                ricksClaw.setVisibility(View.VISIBLE);
                            }

                            public void onFinish() {
                                ricksClaw.setVisibility(View.INVISIBLE);
                            }
                        }.start();
                    }
                }
            }
        });


        /**pickle attack for 1*/


        pickleFirst.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mortyHp = mortyHp - 2;
                if (mortyHp <= 0) {
                    rickWon.setVisibility(View.VISIBLE);
                    pickleThird.setEnabled(false);
                    pickleSecond.setEnabled(false);
                    pickleFirst.setEnabled(false);
                    mortyFirst.setEnabled(true);
                    mortySecond.setEnabled(true);
                    mortyThird.setEnabled(true);
                    mp.start();
                } else {
                    displayForMorty(mortyHp);
                    pickleThird.setEnabled(false);
                    pickleSecond.setEnabled(false);
                    pickleFirst.setEnabled(false);
                    mortyFirst.setEnabled(true);
                    mortySecond.setEnabled(true);
                    mortyThird.setEnabled(true);
                    hit.start();

                    /**mana*/
                    rickMana = rickMana - 1;
                    if (rickMana <= 0) {
                        mortyWon.setVisibility(View.VISIBLE);
                        pickleThird.setEnabled(true);
                        pickleSecond.setEnabled(true);
                        pickleFirst.setEnabled(true);
                        mortyFirst.setEnabled(false);
                        mortySecond.setEnabled(false);
                        mortyThird.setEnabled(false);
                    } else {
                        displayManaForPickle(rickMana);
                    }

                    /**claw*/
                    new CountDownTimer(500, 250) {

                        public void onTick(long millisUntilFinished) {
                            ricksClaw.setVisibility(View.VISIBLE);
                        }

                        public void onFinish() {
                            ricksClaw.setVisibility(View.INVISIBLE);
                        }
                    }.start();
                }
            }
        });

        /**morty attack for 3*/


        mortyThird.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pickleHp = pickleHp - 8;

                if (mortyMana <= 5) {
                    rickWon.setVisibility(View.VISIBLE);
                    pickleThird.setEnabled(false);
                    pickleSecond.setEnabled(false);
                    pickleFirst.setEnabled(false);
                    mortyFirst.setEnabled(true);
                    mortySecond.setEnabled(true);
                    mortyThird.setEnabled(true);
                    mp.start();
                } else {
                    if (pickleHp <= 0) {
                        mortyWon.setVisibility(View.VISIBLE);
                        pickleThird.setEnabled(true);
                        pickleSecond.setEnabled(true);
                        pickleFirst.setEnabled(true);
                        mortyFirst.setEnabled(false);
                        mortySecond.setEnabled(false);
                        mortyThird.setEnabled(false);
                        mp.start();
                    } else {
                        displayForPickle(pickleHp);
                        pickleThird.setEnabled(true);
                        pickleSecond.setEnabled(true);
                        pickleFirst.setEnabled(true);
                        mortyFirst.setEnabled(false);
                        mortySecond.setEnabled(false);
                        mortyThird.setEnabled(false);
                        hit.start();

                        /**mana*/
                        mortyMana = mortyMana - 6;
                        if (mortyMana <= 0) {
                            rickWon.setVisibility(View.VISIBLE);
                            pickleThird.setEnabled(false);
                            pickleSecond.setEnabled(false);
                            pickleFirst.setEnabled(false);
                            mortyFirst.setEnabled(true);
                            mortySecond.setEnabled(true);
                            mortyThird.setEnabled(true);
                        } else {
                            displayManaForMorty(mortyMana);
                        }

                        /**claw*/
                        new CountDownTimer(500, 250) {

                            public void onTick(long millisUntilFinished) {
                                mortysClaw.setVisibility(View.VISIBLE);
                            }

                            public void onFinish() {
                                mortysClaw.setVisibility(View.INVISIBLE);
                            }
                        }.start();
                    }
                }
            }
        });


        /**morty attack for 2*/


        mortySecond.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pickleHp = pickleHp - 4;

                if (mortyMana <= 3) {
                    rickWon.setVisibility(View.VISIBLE);
                    pickleThird.setEnabled(false);
                    pickleSecond.setEnabled(false);
                    pickleFirst.setEnabled(false);
                    mortyFirst.setEnabled(true);
                    mortySecond.setEnabled(true);
                    mortyThird.setEnabled(true);
                    mp.start();
                } else {
                    if (pickleHp <= 0) {
                        mortyWon.setVisibility(View.VISIBLE);
                        pickleThird.setEnabled(true);
                        pickleSecond.setEnabled(true);
                        pickleFirst.setEnabled(true);
                        mortyFirst.setEnabled(false);
                        mortySecond.setEnabled(false);
                        mortyThird.setEnabled(false);
                        mp.start();
                    } else {
                        displayForPickle(pickleHp);
                        pickleThird.setEnabled(true);
                        pickleSecond.setEnabled(true);
                        pickleFirst.setEnabled(true);
                        mortyFirst.setEnabled(false);
                        mortySecond.setEnabled(false);
                        mortyThird.setEnabled(false);
                        hit.start();

                        /**mana*/
                        mortyMana = mortyMana - 4;
                        if (mortyMana <= 0) {
                            rickWon.setVisibility(View.VISIBLE);
                            pickleThird.setEnabled(false);
                            pickleSecond.setEnabled(false);
                            pickleFirst.setEnabled(false);
                            mortyFirst.setEnabled(true);
                            mortySecond.setEnabled(true);
                            mortyThird.setEnabled(true);
                        } else {
                            displayManaForMorty(mortyMana);
                        }

                        /**claw*/
                        new CountDownTimer(500, 250) {

                            public void onTick(long millisUntilFinished) {
                                mortysClaw.setVisibility(View.VISIBLE);
                            }

                            public void onFinish() {
                                mortysClaw.setVisibility(View.INVISIBLE);
                            }
                        }.start();
                    }
                }
            }
        });


        /**morty attack for 1*/


        mortyFirst.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pickleHp = pickleHp - 2;
                if (pickleHp <= 0) {
                    mortyWon.setVisibility(View.VISIBLE);
                    pickleThird.setEnabled(true);
                    pickleSecond.setEnabled(true);
                    pickleFirst.setEnabled(true);
                    mortyFirst.setEnabled(false);
                    mortySecond.setEnabled(false);
                    mortyThird.setEnabled(false);
                    mp.start();

                } else {
                    displayForPickle(pickleHp);
                    pickleThird.setEnabled(true);
                    pickleSecond.setEnabled(true);
                    pickleFirst.setEnabled(true);
                    mortyFirst.setEnabled(false);
                    mortySecond.setEnabled(false);
                    mortyThird.setEnabled(false);
                    hit.start();

                    /**mana*/
                    mortyMana = mortyMana - 1;
                    if (mortyMana <= 0) {
                        rickWon.setVisibility(View.VISIBLE);
                        pickleThird.setEnabled(false);
                        pickleSecond.setEnabled(false);
                        pickleFirst.setEnabled(false);
                        mortyFirst.setEnabled(true);
                        mortySecond.setEnabled(true);
                        mortyThird.setEnabled(true);
                        rickMana = 30;
                        mortyMana = 30;
                        displayManaForPickle(rickMana);
                        displayManaForMorty(mortyMana);
                    } else {
                        displayManaForMorty(mortyMana);
                    }

                    /**claw*/
                    new CountDownTimer(500, 250) {

                        public void onTick(long millisUntilFinished) {
                            mortysClaw.setVisibility(View.VISIBLE);
                        }

                        public void onFinish() {
                            mortysClaw.setVisibility(View.INVISIBLE);
                        }
                    }.start();
                }
            }
        });

        /** mana*/


        /**reset button*/


        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                pickleHp = 41;
                displayForPickle(pickleHp);
                mortyHp = 41;
                displayForMorty(mortyHp);
                mortyWon.setVisibility(View.INVISIBLE);
                rickWon.setVisibility(View.INVISIBLE);

                rickMana = 30;
                mortyMana = 30;
                displayManaForPickle(rickMana);
                displayManaForMorty(mortyMana);

                /**reset timer*/

                new CountDownTimer(1000, 500) {

                    public void onTick(long millisUntilFinished) {
                        three.setVisibility(View.VISIBLE);
                        pickleThird.setEnabled(false);
                        pickleSecond.setEnabled(false);
                        pickleFirst.setEnabled(false);
                        mortyFirst.setEnabled(false);
                        mortySecond.setEnabled(false);
                        mortyThird.setEnabled(false);
                    }

                    public void onFinish() {
                        three.setVisibility(View.INVISIBLE);
                        new CountDownTimer(1000, 500) {

                            public void onTick(long millisUntilFinished) {
                                two.setVisibility(View.VISIBLE);
                            }

                            public void onFinish() {
                                two.setVisibility(View.INVISIBLE);
                                new CountDownTimer(1000, 500) {

                                    public void onTick(long millisUntilFinished) {
                                        one.setVisibility(View.VISIBLE);
                                    }

                                    public void onFinish() {
                                        one.setVisibility(View.INVISIBLE);
                                        new CountDownTimer(1500, 500) {

                                            public void onTick(long millisUntilFinished) {
                                                start.setVisibility(View.VISIBLE);
                                            }

                                            public void onFinish() {
                                                start.setVisibility(View.INVISIBLE);
                                                pickleThird.setEnabled(true);
                                                pickleSecond.setEnabled(true);
                                                pickleFirst.setEnabled(true);
                                                mortyFirst.setEnabled(true);
                                                mortySecond.setEnabled(true);
                                                mortyThird.setEnabled(true);
                                            }
                                        }.start();
                                    }
                                }.start();
                            }
                        }.start();
                    }
                }.start();
            }
        });

    }


    /**
     * Displays the given score for Morty.
     */
    public void displayForMorty(int mortyHp) {
        TextView scoreView = (TextView) findViewById(R.id.morty_hp);
        scoreView.setText(String.valueOf(mortyHp));
    }


    /**
     * Displays the given score for Pickle.
     */
    public void displayForPickle(int pickleHp) {
        TextView scoreView = (TextView) findViewById(R.id.pickle_hp);
        scoreView.setText(String.valueOf(pickleHp));
    }

    /**
     * Displays the mana for Morty.
     */
    public void displayManaForMorty(int mortyMana) {
        TextView manaView = (TextView) findViewById(R.id.mortysMana);
        manaView.setText(String.valueOf(mortyMana));
    }

    /**
     * Displays the mana for Pickle.
     */
    public void displayManaForPickle(int rickMana) {
        TextView manaView = (TextView) findViewById(R.id.ricksMana);
        manaView.setText(String.valueOf(rickMana));
    }

}
