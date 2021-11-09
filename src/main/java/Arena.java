import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private int width;
    private int height;
    private Hero hero;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(10, 10);
    }

    private boolean canHeroMove(Position position){
        if (position.getX() > 0 && position.getX() < width
                && position.getY() > 0 && position.getY() < height)
            return true;
        else return false;
    }

    private void moveHero(Position position) {
        if(canHeroMove(position))
            hero.setPosition(position);
    }

    public void draw(Screen screen) throws IOException{
        try {
            screen.clear();
            screen.setCharacter(this.hero.getX(), this.hero.getY(), TextCharacter.fromCharacter('X')[0]);
            screen.refresh();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void processKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp:
                moveHero(hero.moveUp());
                break;
            case ArrowDown:
                moveHero(hero.moveDown());
                break;
            case ArrowRight:
                moveHero(hero.moveRight());
                break;
            case ArrowLeft:
                moveHero(hero.moveLeft());
                break;
        }
    }
}
