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
}
