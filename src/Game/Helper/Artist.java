/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Helper;

import java.io.IOException;
import java.io.InputStream;

import static org.lwjgl.opengl.GL11.*;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

/**
 *
 * @author Vovaxs
 */
public class Artist {

    public static void drawLine(float p1x, float p1y, float p2x, float p2y) {
        glBegin(GL_LINES);
        glVertex2f(p1x, p1y);
        glVertex2f(p2x, p2y);
        glEnd();
    }

    public static void drawCircle(float cx, float cy, float r) {
        float theta = (float) (2 * 3.1415926 / getCircleSegmentNum(r));
        float c = (float) Math.cos(theta);
        float s = (float) Math.sin(theta);
        float t;

        float x = r; //we start at angle 0;
        float y = 0;
        //setting a colour to black
        glColor4f(0.0f, 0.0f, 0.0f, 1.0f);
        glBegin(GL_LINE_LOOP);
        for (int i = 0; i < getCircleSegmentNum(r); i++) {
            glVertex2f(x + cx, y + cy); //output vertex

            //apply the rotation matrix
            t = x;
            x = c * x - s * y;
            y = s * t + c * y;
        }
        glEnd();
        //setting a colour back to white
        glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }

    public static void drawRect(float x, float y, float width, float height) {
        glBegin(GL_QUADS);
        glVertex2f(x, y);
        glVertex2f(x + width, y);
        glVertex2f(x + width, y + height);
        glVertex2f(x, y + height);
        glEnd();
    }

    public static void drawRectTexture(Texture tex, float x, float y,
            float width, float height) {
        tex.bind();
        glTranslatef(x, y, 0);

        // Drawing the quad texure
        glBegin(GL_QUADS);
        glTexCoord2f(0, 0);
        glVertex2f(0, 0);
        glTexCoord2f(1, 0);
        glVertex2f(width, 0);
        glTexCoord2f(1, 1);
        glVertex2f(width, height);
        glTexCoord2f(0, 1);
        glVertex2f(0, height);
        glEnd();
        glLoadIdentity();
    }

    public static void drawRotatableRectTexture(Texture tex, float x, float y,
            float width, float height, float angle) {
        tex.bind();

        //transtating 0.0 point to the middle of the texture
        glTranslatef(x + width / 2, y + height / 2, 0);

        //rotating quat texture
        glRotatef(angle, 0, 0, 1);

        //translating the 0.0 point of the texture back to original possition
        glTranslatef(-width / 2, -height / 2, 0);

        // Drawing the quad texure
        glBegin(GL_QUADS);
        glTexCoord2f(0, 0);
        glVertex2f(0, 0);
        glTexCoord2f(1, 0);
        glVertex2f(width, 0);
        glTexCoord2f(1, 1);
        glVertex2f(width, height);
        glTexCoord2f(0, 1);
        glVertex2f(0, height);
        glEnd();
        glLoadIdentity();
    }

    public static Texture loadTexture(String path, String fileType) {
        Texture tex = null;
        InputStream in = ResourceLoader.getResourceAsStream(path);
        try {
            tex = TextureLoader.getTexture(fileType, in);
        } catch (IOException e) {
        }
        return tex;
    }

    public static Texture quickLoadTexture(String name) {
        Texture tex = loadTexture("res/" + name + ".png", "PNG");
        return tex;
    }

    private static int getCircleSegmentNum(float r) {
        return (int) (10 * Math.sqrt((double) r));
    }
}
