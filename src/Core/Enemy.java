package Core;

import javax.media.opengl.GL;

public class Enemy {
    float size = 12;
    public int step = 10;
    public float x, y;
    public int i, j;

    public PathCalc direction = PathCalc.IDEAL;

    public Enemy(int i, int j) {
        this.i = i;
        this.j = j;
        updateXY();
    }

    public void updateXY() {
        x = (float) (i - 1) * (step);
        y = (float) (j - 1) * (step);
    }

    public void updateIJ() {
        i = (int) ((x / step) + 1);
        j = (int) ((y / step) + 1);
    }

    public void Draw(GL gl, int texture) {

        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, texture);
        gl.glBegin(GL.GL_QUADS);

        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(x+2, y+3, -1.0f);

        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(x+2, y+3 + size, -1.0f);

        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(x+2 + size, y+3 + size, -1.0f);

        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(x+2 + size, y+3, -1.0f);

        gl.glEnd();
        gl.glDisable(GL.GL_BLEND);

    }

    public void moveUP() {
        direction = PathCalc.UP;
        x -= step;
        updateIJ();
    }

    public void moveDown() {
        direction = PathCalc.DOWN;
        x += step;
        updateIJ();
    }

    public void moveRight() {
        direction = PathCalc.RIGHT;
        y += step;
        updateIJ();
    }

    public void moveLeft() {
        direction = PathCalc.LEFT;
        y -= step;
        updateIJ();
    }
}