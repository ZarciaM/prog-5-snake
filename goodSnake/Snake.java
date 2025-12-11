package goodSnake;

import java.util.LinkedList;
import java.util.List;

public class Snake {

    private final LinkedList<Position> body = new LinkedList<>();
    private Direction dir = Direction.RIGHT;

    public Snake(Position start) {
        body.add(start);
        body.add(new Position(start.r(), start.c() - 1));
        body.add(new Position(start.r(), start.c() - 2));
    }

    public List<Position> body() {
        return body;
    }

    public Position head() {
        return body.getFirst();
    }

    public void setDir(Direction d) {
        if (dir == Direction.UP && d == Direction.DOWN) return;
        if (dir == Direction.DOWN && d == Direction.UP) return;
        if (dir == Direction.LEFT && d == Direction.RIGHT) return;
        if (dir == Direction.RIGHT && d == Direction.LEFT) return;
        dir = d;
    }

    public Direction getDir() {
        return dir;
    }

    public Position next() {
        return head().move(dir);
    }

    public boolean hitSelf(Position p) {
        for (Position x : body) {
            if (x.equals(p)) return true;
        }
        return false;
    }

    public void move(boolean grow) {
        body.addFirst(next());
        if (!grow) body.removeLast();
    }
}
