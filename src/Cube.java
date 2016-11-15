import java.util.Random;

class Cube {
    char[][][] cube;

    public Cube(int n) {
        Random random = new Random();
        this.cube = new char[n][n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    this.cube[i][j][k] = (char) ('a' + random.nextInt(26));
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < cube.length; i++) {
            for (int j = 0; j < cube[i].length; j++) {
                for (int k = 0; k < cube[i][j].length; k++) {
                    stringBuilder.append(cube[i][j][k]);
                    stringBuilder.append(' ');
                }
                stringBuilder.append('\n');
            }
            stringBuilder.append('\n');
        }
        return stringBuilder.toString();
    }
}
