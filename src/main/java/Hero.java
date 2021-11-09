import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Hero {
    Position position;

    public Hero(int x, int y){
        position = new Position(x, y);
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



    public void setPosition(Position position){
        this.position = position;
    }
}
