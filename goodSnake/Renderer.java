package goodSnake;

public class Renderer {

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void draw(int h, int w, Snake s, Food f, int score) {
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i == 0 || j == 0 || i == h - 1 || j == w - 1) {
                    out.append('X');
                    continue;
                }

                Position p = new Position(i, j);

                if (p.equals(f.pos())) {
                    out.append('*');
                    continue;
                }

                boolean snake = false;
                for (Position k : s.body()) {
                    if (k.equals(p)) {
                        snake = true;
                        break;
                    }
                }
                out.append(snake ? '#' : ' ');
            }
            out.append("\n");
        }

        System.out.println(out);
        System.out.println("Score: " + score);
    }
}
