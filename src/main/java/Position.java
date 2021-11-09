import java.util.Objects;

public class Position {
    int x;
    int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;}

    public int getX(){
        return this.x;}
    public int getY(){
        return this.y;}

    public void setX(int num){
        x+= num;}
    public void setY(int num){
        y += num;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
