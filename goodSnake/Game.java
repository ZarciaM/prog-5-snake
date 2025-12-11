package goodSnake;

import java.io.IOException;

public class Game {

    private static final int H = 20;
    private static final int W = 40;

    private final Snake snake = new Snake(new Position(10, 10));
    private final Food food = new Food(H, W);
    private int score = 0;

    public void start() throws Exception {
        while (true) {
            input();
            tick();
            Renderer.clear();
            Renderer.draw(H, W, snake, food, score);
            Thread.sleep(110);
        }
    }

    private void input() throws IOException {
        if (System.in.available() == 0) return;
        char c = (char) System.in.read();
        if (c == 'a') snake.setDir(Direction.LEFT);
        if (c == 'd') snake.setDir(Direction.RIGHT);
        if (c == 'w') snake.setDir(Direction.UP);
        if (c == 's') snake.setDir(Direction.DOWN);
    }

    private void tick() {
        Position next = snake.next();

        if (next.r() <= 0 || next.r() >= H - 1 ||
            next.c() <= 0 || next.c() >= W - 1) {
            end();
        }

        if (snake.hitSelf(next)) {
            end();
        }

        boolean eat = next.equals(food.pos());
        if (eat) {
            score++;
            food.spawn(H, W);
        }

        snake.move(eat);
    }

    private void end() {
        System.out.println("GAME OVER — score = " + score);
        System.exit(0);
    }
}
