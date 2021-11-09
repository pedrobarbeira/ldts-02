import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;

public abstract class Element {
    Position position;

    public Element(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition(){
        return this.position;}

    public abstract void draw(TextGraphics graphics) throws IOException;
}
