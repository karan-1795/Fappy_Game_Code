package in.codekamp.game.model;

import java.awt.Rectangle;
import in.codekamp.framework.util.RandomNumberGenerator;

public class pipe {
    private float x, y;
    private int width, height;
    private Rectangle rect;
    private boolean visible;
    private static final int UPPER_Y = 0;
    private static final int LOWER_Y = 200;

    public pipe(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        rect = new Rectangle((int) x, (int) y, width, height);
        visible = false;
    }

    // Note: Velocity value will be passed in from PlayState!
    public void update(float delta, float velX) {
        x += velX * delta;
        if (x <= -30) {
            reset();
        }
        updateRect();
    }

    public void updateRect() {
        rect.setBounds((int) x, (int) y, width, height);
    }

    public void reset() {
        visible = true;
        // 1 in 3 chance of becoming an Upper Block
        if (RandomNumberGenerator.getRandInt(3) == 0) {
            y = UPPER_Y;
        } else {
            y = LOWER_Y;
        }
        x += 1000;
    }

    public void onCollide(Player p) {
        visible = false;
        p.pushDown();
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public boolean isVisible() {
        return visible;
    }

    public Rectangle getRect() {
        return rect;
    }
}