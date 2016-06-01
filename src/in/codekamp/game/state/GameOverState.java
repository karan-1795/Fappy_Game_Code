package in.codekamp.game.state;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import in.codekamp.game.main.GameMain;
import in.codekamp.game.main.Resources;

public class GameOverState extends State {
    private String playerScore;
    private Font font;

    public GameOverState(int playerScore) {
        this.playerScore = playerScore + ""; // Convert int to String
        font = new Font("Baskerville Old Face", Font.BOLD, 50);
    }

    @Override
    public void init() {
        // TODO Auto-generated method stub
    }

    @Override
    public void update(float delta) {
        // TODO Auto-generated method stub
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, GameMain.GAME_WIDTH, GameMain.GAME_HEIGHT);
        g.setColor(Color.DARK_GRAY);
        g.setFont(font);
        g.drawString("GAME OVER", 257, 175);
        g.drawString("SCORE:", 315, 250);
        g.drawString(playerScore, 530, 250);
        g.drawString("PRESS ANY KEY TO RESTART!", 10, 350);
        g.drawString("R.I.P!",10,100);
        g.drawImage(Resources.rip,10,150,null);
    }

    @Override
    public void onClick(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onKeyPress(KeyEvent e) {
        setCurrentState(new MenuState());
    }

    @Override
    public void onKeyRelease(KeyEvent e) {
        // TODO Auto-generated method stub
    }
}