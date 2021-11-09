import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero {
    Position position;

    public Hero(int x, int y){
        position = new Position(x, y);
    }

    public Position moveUp(){
        return new Position(position.getX(), position.getY()-1);}
    public Position moveDown(){
        return new Position(position.getX(), position.getY()+1);}
    public Position moveLeft(){
        return new Position(position.getX()-1, position.getY());}
    public Position moveRight(){
        return new Position(position.getX()+1, position.getY());}

    public void draw(Screen screen){
        try {
            screen.clear();
            screen.setCharacter(this.position.getX(), this.position.getY(), TextCharacter.fromCharacter('X')[0]);
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPosition(Position position){
        this.position = position;
    }
}
