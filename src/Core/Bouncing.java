package Core;

import javax.media.opengl.GL;

public class Bouncing  {
    public float i, j;

    public Bouncing(float i, float j){
        this.i = i;
        this.j = j;
    }

    public void Draw(GL gl, int texture) {
        float sz = 5;
        float x = (i)*10;
        float y = (j)*10;

        gl.glEnable(GL.GL_BLEND);
        gl.glBindTexture(GL.GL_TEXTURE_2D, texture);
        gl.glBegin(GL.GL_QUADS);

        gl.glTexCoord2f(0.0f, 1.0f);
        gl.glVertex3f(x, y, -1.0f);

        gl.glTexCoord2f(1.0f, 1.0f);
        gl.glVertex3f(x, y + sz, -1.0f);

        gl.glTexCoord2f(1.0f, 0.0f);
        gl.glVertex3f(x + sz, y + sz, -1.0f);

        gl.glTexCoord2f(0.0f, 0.0f);
        gl.glVertex3f(x + sz, y, -1.0f);

        gl.glEnd();
        gl.glDisable(GL.GL_BLEND);
    }
}