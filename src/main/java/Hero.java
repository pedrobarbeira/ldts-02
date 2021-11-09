import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero extends Element{

    public Hero(int x, int y){
        super(x, y);
    }

    public int getX() {
        return position.getX();}

    public int getY(){
        return position.getY();}

    public Position moveUp(){
        return new Position(position.getX(), position.getY()-1);}
    public Position moveDown(){
        return new Position(position.getX(), position.getY()+1);}
    public Position moveLeft(){
        return new Position(position.getX()-1, position.getY());}
    public Position moveRight(){
        return new Position(position.getX()+1, position.getY());}

    public void draw(TextGraphics graphics) throws IOException {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }


    public void setPosition(Position position){
        this.position = position;
    }
}
