public class player {

    String name;
    int pid;
    int playerXPos;
    int PlayerYPos;
    double points;
    Direction dir;

    public enum Direction{ UP, DOWN, LEFT, RIGHT}


    public player(String name, int pid, int playerXPos, int playerYPos, double points, Direction dir) {
        this.name = name;
        this.pid = pid;
        this.playerXPos = playerXPos;
        PlayerYPos = playerYPos;
        this.points = points;
        this.dir = dir;
    }

    public player(int playerXPos, int playerYPos, double points, Direction dir) {
        this.playerXPos = playerXPos;
        PlayerYPos = playerYPos;
        this.points = points;
        this.dir = dir;
    }

    public player(int playerXPos, int playerYPos, Direction dir) {
        this.playerXPos = playerXPos;
        PlayerYPos = playerYPos;
        this.dir = dir;
    }

    public int getPlayerXPos() {
        return playerXPos;
    }

    public void setPlayerXPos(int playerXPos) {
        this.playerXPos = playerXPos;
    }

    public int getPlayerYPos() {
        return PlayerYPos;
    }

    public void setPlayerYPos(int playerYPos) {
        PlayerYPos = playerYPos;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public Direction getDir() {
        return dir;
    }

    public void setDir(Direction dir) {
        this.dir = dir;
    }
}
