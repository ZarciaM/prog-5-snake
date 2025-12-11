package goodSnake;


public record Position(int r, int c) {

    public Position move(Direction d) {
        return switch (d) {
            case UP -> new Position(r - 1, c);
            case DOWN -> new Position(r + 1, c);
            case LEFT -> new Position(r, c - 1);
            case RIGHT -> new Position(r, c + 1);
        };
    }
}

