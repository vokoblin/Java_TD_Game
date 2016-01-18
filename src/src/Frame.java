/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author Vovaxs
 */
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;

public final class Frame {

    public static String title;
    public static int WIDTH;
    public static int HEIGHT;
    public static float SCALE;

    public Frame() {
        Frame.title = "TD Alpha 0.1";
        Frame.SCALE = 1;
        Frame.WIDTH = 800;
        Frame.HEIGHT = 600;
        try {
            Display.setTitle(title);
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create();
        } catch (LWJGLException ex) {
            System.out.println(ex.getMessage());
        }

        this.init();
    }

    void init() {
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glEnable(GL_TEXTURE_2D);
        glEnable(GL_BLEND);
        glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
    }

    public static String getTitle() {
        return title;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static float getSCALE() {
        return SCALE;
    }
}
