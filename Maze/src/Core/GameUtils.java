package Core;

import com.sun.opengl.util.GLUT;

import javax.media.opengl.GL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

public class GameUtils {

    public static void DrawBackground(GL gl, int textures) {
        gl.glEnable(GL.GL_BLEND);    // Turn Blending On
        gl.glBindTexture(GL.GL_TEXTURE_2D, textures);
        gl.glBegin(GL.GL_QUADS);
        // Front Face
        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(0.0f, 0.0f, -1.0f);

        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(600.0f, 0.0f, -1.0f);

        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(600.0f, 400.0f, -1.0f);

        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(0.0f, 400.0f, -1.0f);
        gl.glEnd();

        gl.glDisable(GL.GL_BLEND);
    }

    public static void resetPlayer(int[][] map, int n, int m, PlayerCharc player) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1) {
                    player.i = i;
                    player.j = j;
                    player.updateXY();
                }
            }
        }
    }

    public static void drawString(GL gl, int x, int y, String s) {
        GLUT glt = new GLUT();
        gl.glPushAttrib(GL.GL_CURRENT_BIT);
        gl.glRasterPos2i(x, y);
        gl.glColor3f(0, 0, 1); // BLUE
        glt.glutBitmapString(5, s);
        gl.glPopAttrib();
    }
    public static Clip playMusic(String location, boolean loop) {

        try {
            File musicPath = new File(location);

            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                if (loop) clip.loop(Clip.LOOP_CONTINUOUSLY);
                return clip;
            } else {
                System.out.println("Cant find file");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

        return null;
    }

    public static String getLastUser(){
        try {
            String user = null;
            Scanner input = new Scanner(new File("UsersList.txt"));
            while (input.hasNext()) {
                user = input.nextLine();
                user = user.substring(0, user.indexOf(' ') == -1 ? user.length() : user.indexOf(' '));
            }
            return Objects.requireNonNullElse(user, "");
        } catch (FileNotFoundException e) {
            return "";
        }
    }
    public static String getPreLastUser(){
        try {
            String lastUser = null;
            String preLastUser = lastUser;
            Scanner input = new Scanner(new File("UsersList.txt"));
            while (input.hasNext()) {
                preLastUser = lastUser;
                lastUser = input.nextLine();
                lastUser = lastUser.substring(0, lastUser.indexOf(' ') == -1 ? lastUser.length() : lastUser.indexOf(' '));

            }
            return Objects.requireNonNullElse(preLastUser, "");
        } catch (FileNotFoundException e) {
            return "";
        }
    }
}
