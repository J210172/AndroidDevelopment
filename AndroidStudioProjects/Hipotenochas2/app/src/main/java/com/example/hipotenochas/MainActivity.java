package com.example.hipotenochas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TableLayout gameTable;
    private int y, x, nmines, nRmines, tempx, tempy;
    private int minefield[][];
    private ImageButton imageButtons[][];
    private String[] options;
    private Drawable facing_down;
    private boolean firstTimeSquareAction, firstTimeRevealAllEmptySquares;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        gameTable = findViewById(R.id.gameTable);
        options = new String[] {"Easy", "Normal", "Hard"};
        facing_down = getDrawable(R.drawable.facing_down);
        firstTimeSquareAction = true;
        firstTimeRevealAllEmptySquares = true;
        x = 8;
        y = 8;
        nmines = 10;
        nRmines = nmines;
    }

    public void squareAction(View v) {
        ImageButton ib = (ImageButton) v;
        if (firstTimeSquareAction) {
            generateMineField(v.getId());
            firstTimeSquareAction = false;
        }
        int val = getSquareValue(v.getId());
        if (val == -1) {
            showDefeat();
            revealAllSquares();
        } else {
            changeImage(ib, val);
        }
    }

    private boolean squareLongAction(View v) {
        ImageButton ib = (ImageButton) v;
        if (firstTimeSquareAction) {
            generateMineField(v.getId());
            firstTimeSquareAction = false;
        }
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (v.getId() == j + i * x) {
                    if (minefield[i][j] == -1) {
                        ib.setImageResource(R.drawable.flagged);
                        ib.setOnClickListener(this::squareLongAction);
                        minefield[i][j] = -2;
                        nRmines-=1;
                    /*} else if (minefield[i][j] == -2) {
                        ib.setImageResource(R.drawable.facing_down);
                        ib.setOnClickListener(this::squareAction);
                        minefield[i][j] = -1;
                        nRmines+=1;*/
                    } else if (ib.getDrawable() == facing_down) {
                        showDefeat();
                        revealAllSquares();
                    } /*else {
                        if (ib.getDrawable() == facing_down) {
                            ib.setImageResource(R.drawable.flagged);
                        } else {
                            ib.setImageDrawable(facing_down);
                        }
                    }*/
                    break;
                }
            }
        }

        if (nRmines == 0) {
            showWin();
        }
        return true;
    }

    /*
    private void revealAllEmptySquares(int id) {

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (id == j + i * x) {
                    extracted(i, j);
                }
            }
        }
    }
    private void extracted(int i, int j) {
        for (int a = (i >= 1) ? i - 1 : i; a <= ((i < y - 1) ? i + 1 : i); a++) {
            for (int b = (j >= 1) ? j - 1 : j; b <= ((j < x - 1) ? j + 1 : j); b++) {
                //if (a != i && b != j) {
                changeImage(imageButtons[a][b], 0);
                if (minefield[a][b] == 0) {
                    extracted(a, b);
                } else {
                    break;
                }
                //}
            }
        }
    }*/

    private void revealAllSquares() {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                changeImage(imageButtons[i][j], minefield[i][j]);
            }
        }
    }

    private void changeImage(ImageButton ib, int i) {
        switch (i) {
            case -2:
                ib.setImageResource(R.drawable.flagged);
                break;
            case -1:
                ib.setImageResource(R.drawable.bomb);
                break;
            case 0:
                ib.setImageResource(R.drawable.num0);
                break;
            case 1:
                ib.setImageResource(R.drawable.num1);
                break;
            case 2:
                ib.setImageResource(R.drawable.num2);
                break;
            case 3:
                ib.setImageResource(R.drawable.num3);
                break;
            case 4:
                ib.setImageResource(R.drawable.num4);
                break;
            case 5:
                ib.setImageResource(R.drawable.num5);
                break;
            case 6:
                ib.setImageResource(R.drawable.num6);
                break;
            case 7:
                ib.setImageResource(R.drawable.num7);
                break;
            case 8:
                ib.setImageResource(R.drawable.num8);
                break;
            default:
        }
    }

    private int getSquareValue(int id) {
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (id == j + i * x) {
                    return minefield[i][j];
                }
            }
        }
        return -2;
    }

    private void generateMineField(int id) {
        minefield = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                minefield[i][j] = 0;
            }
        }

        for (int i = 0; i < nmines; i++) {
            int r1 = (int) (Math.random() * y);
            int r2 = (int) (Math.random() * x);
            if (r1 + r2 * x != id && minefield[r1][r2] != -1) {
                minefield[r1][r2] = -1;
            } else {
                i--;
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {

                if (minefield[i][j] == -1) {
                    for (int a = (i >= 1) ? i - 1 : i; a <= ((i < y - 1) ? i + 1 : i); a++) {
                        for (int b = (j >= 1) ? j - 1 : j; b <= ((j < x - 1) ? j + 1 : j); b++) {
                            if (minefield[a][b] != -1) {
                                minefield[a][b] += 1;
                            }
                        }
                    }
                }
            }
        }
    }

    private void generateTable() {
        imageButtons = new ImageButton[y][x];
        gameTable = findViewById(R.id.gameTable);
        gameTable.setGravity(Gravity.CENTER);
        for (int i = 0; i < y; i++) {
            TableRow tr = new TableRow(gameTable.getContext());
            tr.setGravity(Gravity.CENTER);
            gameTable.addView(tr);
            for (int j = 0; j < x; j++) {
                ImageButton ib = new ImageButton(gameTable.getContext());
                ib.setAdjustViewBounds(true);
                ib.setMaxWidth(1050 / x);
                ib.setId(j + i * x);
                ib.setPadding(3, 3, 3, 3);
                ib.setImageDrawable(facing_down);
                ib.setOnClickListener(this::squareAction);
                ib.setOnLongClickListener(this::squareLongAction);
                tr.addView(ib);
                imageButtons[i][j] = ib;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        menu.add(R.string.howtoplayOpt).setOnMenuItemClickListener(micl -> {
            showHowToPlay();
            return true;
        });
        menu.add(R.string.newgameOpt).setOnMenuItemClickListener(micl -> {
            gameTable.removeAllViews();
            generateTable();
            firstTimeSquareAction = true;
            firstTimeRevealAllEmptySquares = true;
            nRmines = nmines;
            return true;
        });
        menu.add(R.string.configurationOpt).setOnMenuItemClickListener(micl -> {
            showMenu();
            return true;
        });
        return true;
    }

    public void showMenu() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setNeutralButton("cancel", (DialogInterface dialogInterface, int i) -> {});
        alert.setTitle("Select Dificulty");
        alert.setSingleChoiceItems(options, 0, (DialogInterface dialogInterface, int i) -> {
                String item = options[i];
                switch (item){
                    case "Easy" :
                        x = 8;
                        y = 8;
                        nmines = 10;
                        Toast.makeText(getApplicationContext(), "Easy selected", Toast.LENGTH_LONG).show();
                        break;

                    case "Normal" :
                        x =9;
                        y = 16;
                        nmines =30;
                        Toast.makeText(getApplicationContext(), "Normal selected", Toast.LENGTH_LONG).show();
                        break;

                    case "Hard" :
                        x = 15;
                        y = 24;
                        nmines = 60;
                        Toast.makeText(getApplicationContext(), "Hard selected", Toast.LENGTH_LONG).show();
                        break;
                }
        });
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void showHowToPlay() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setNeutralButton("Ok", (DialogInterface dialogInterface, int i) -> {});
        alert.setTitle("How to play");
        alert.setMessage("CONDICIÓN DE VICTORIA: El usuario gana cuando ha ocurrido la situación 2 y ha marcado correctamente todas las hipotenochas.\n" +
                "CONDICIÓN DE DERROTA: El usuario pierde cuando ha ocurrido la situación 1 o la situación 3.\n");
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void showWin() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setNeutralButton("Ok", (DialogInterface dialogInterface, int i) -> {});
        alert.setTitle("Yo win");
        alert.setMessage("Yo win");
        AlertDialog dialog = alert.create();
        dialog.show();
    }

    public void showDefeat() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setNeutralButton("Ok", (DialogInterface dialogInterface, int i) -> {});
        alert.setTitle("You lost");
        alert.setMessage("You lost");
        AlertDialog dialog = alert.create();
        dialog.show();
    }
}