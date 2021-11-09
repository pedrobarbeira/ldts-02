import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private int width;
    private int height;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> mobs;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.hero = new Hero(10, 10);
        this.walls = createWalls();
        this.coins = createCoins();
        this.mobs = createMobs();
    }

    private List<Wall> createWalls(){
        List<Wall> walls = new ArrayList<>();

        for(int c = 0; c < width; c++){
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height-1));
        }

        for(int r = 1; r < height-1; r++){
            walls.add(new Wall(0, r));
            walls.add(new Wall(width-1, r));
        }

        return walls;
    }

    private List<Coin> createCoins(){
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        int i = 0;
        boolean onTop=false;
        while(i < 5){
            Position p = new Position(random.nextInt(width-2)+1,
                    random.nextInt(height-2)+1);
            for(Wall wall : walls) {
                if (wall.getPosition().equals(p))
                    onTop = true;
            }
            if(!onTop && !p.equals(hero.getPosition())) {
                coins.add(new Coin(p.getX(), p.getY()));
                onTop = false;
                i++;
            }
        }
        return coins;
    }

    private List<Monster> createMobs(){
        Random random = new Random();
        ArrayList<Monster> mobs = new ArrayList<>();
        int i = 0;
        boolean onTop=false;
        while(i < 5){
            Position p = new Position(random.nextInt(width-2)+1,
                    random.nextInt(height-2)+1);
            for(Wall wall : walls) {
                if (wall.getPosition().equals(p))
                    onTop = true;
            }
            if(!onTop && !p.equals(hero.getPosition())) {
                mobs.add(new Monster(p.getX(), p.getY()));
                onTop = false;
                i++;
            }
        }
        return mobs;
    }

    private void moveMonsters(){
        for(Monster mob : mobs)
            mob.move();
    }



    private boolean canHeroMove(Position position){
        for(Wall wall: walls){
            if (wall.getPosition().equals(position))
                return false;
        }
        return true;
    }

    private void moveHero(Position position) {
        if(canHeroMove(position))
            hero.setPosition(position);
        retrieveCoins();
    }

    private void retrieveCoins(){
        Coin out = new Coin();
        for(Coin coin : coins){
            if(coin.getPosition().equals(hero.getPosition())) {
                out = coin;
                break;
            }
        }
        coins.remove(out);
    }

    public void draw(TextGraphics graphics) throws IOException {
        //Draw Arena
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        //Draw Hero
        hero.draw(graphics);
        //Draw terrain (walls, coins);
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Coin coin : coins)
            coin.draw(graphics);
        //Draw NPCs
        for(Monster mob : mobs)
            mob.draw(graphics);
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
