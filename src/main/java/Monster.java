import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.io.IOException;
import java.util.Random;

public class Monster extends Element{

    public Monster(int x, int y){
        super(x, y);
    }

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.setForegroundColor(TextColor.Factory.fromString("#000000"));
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "M");
    }

    public Position move(){
        Random random = new Random();
        boolean valid = false;
        while(true) {
            Position p = new Position(this.getPosition().getX() + random.nextInt(2),
                    this.getPosition().getY() + random.nextInt(2));
            if(valid) return p;
        }
    }
}
