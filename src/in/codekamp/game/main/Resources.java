package in.codekamp.game.main;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import in.codekamp.framework.animation.Animation;
import in.codekamp.framework.animation.Frame;

public class Resources {

    public static BufferedImage welcome, iconimage, pipe, cloud1, cloud2,
            bird, grass, fly, fly1, fly2, fly3, fly4, selector,rip;
    public static AudioClip hit, onfly;
    public static Color skyBlue;
    public static Animation runAnim;

    public static void load() {
        welcome = loadImage("welcome.png");
        iconimage = loadImage("iconimage.png");
        pipe = loadImage("pipe.png");
        cloud1 = loadImage("cloud1.png");
        cloud2 = loadImage("cloud2.png");
        bird = loadImage("bird.png");
        grass = loadImage("grass.png");
        //fly = loadImage("fly.png");
        fly1 = loadImage("fly1.png");
        fly2 = loadImage("fly2.png");
        fly3 = loadImage("fly3.png");
        fly4 = loadImage("fly4.png");
        rip= loadImage("rip.png");

        selector = loadImage("selector.png");
        hit = loadSound("hit.wav");
        onfly = loadSound("onfly.wav");
        skyBlue = new Color(208,248,255);

        Frame f1 = new Frame(fly1, .1f);
        Frame f2 = new Frame(fly2, .1f);
        Frame f3 = new Frame(fly3, .1f);
        Frame f4 = new Frame(fly4, .1f);
        runAnim = new Animation(f1, f2, f3, f4, f3, f2);
    }

    private static AudioClip loadSound(String filename) {
        URL fileURL = Resources.class.getResource("/resources/" + filename);
        return Applet.newAudioClip(fileURL);
    }

    private static BufferedImage loadImage(String filename) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(Resources.class
                    .getResourceAsStream("/resources/" + filename));
        } catch (IOException e) {
            System.out.println("Error while reading: " + filename);
            e.printStackTrace();
        }
        return img;
    }
}