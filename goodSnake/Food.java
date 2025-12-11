package goodSnake;

import java.util.Random;

public class Food {

    private final Random rnd = new Random();
    private Position pos;

    public Food(int h, int w) {
        spawn(h, w);
    }

    public Position pos() {
        return pos;
    }

    public void spawn(int sh, int sw) {
        pos = new Position(
                rnd.nextInt(sh - 2) + 1,
                rnd.nextInt(sw - 2) + 1
        );
    }
}
