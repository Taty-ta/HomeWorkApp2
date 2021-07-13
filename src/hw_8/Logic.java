package hw_8;

import java.util.Random;

public class Logic {
    static int SIZE = 3;
    static int DOTS_TO_WIN = 3;
    static final char DOT_EMPTY = '•';
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static char[][] map;

    static int w; // победитель
    static Random rand = new Random();
    static boolean isGamaFinished = false;

    public static int go() {

        isGamaFinished = true;
        printMap();
        if (checkWin(DOT_X, DOTS_TO_WIN)) {

            return w = 1;
        }
        if (isMapFull()) {
            // System.out.println("Ничья");
            return w = 2;
        }
        aiTurn();
        printMap();
        if (checkWin(DOT_O, DOTS_TO_WIN)) {
            System.out.println("Победил Искуственный Интеллект");
            return w = 3;
        }

        isGamaFinished = false;
        return w = 0;
    }


    /*public static boolean checkWin(char symb) {
        int sum = 0;
//            горизонталь
        for (int i = 0; i < SIZE; i++) {
            sum = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    sum = sum + 1; // соберем подряд заданное количество фишек
                } else {
                    sum = 0; // подряд нет нужного количества
                }
            }
            if (sum == DOTS_TO_WIN) {
                return true;
            }

        }
        // 1 диагональ
        for (int i = 0; i < SIZE; i++) {
            for (int j = i; j <= i; j++) {
                if (map[i][j] == symb) {
                    sum = sum + 1;
                } else {
                    sum = 0;
                }
            }
            if (sum == DOTS_TO_WIN) {
                return true;
            }
        }
//            return false;
        // 2 диагональ
        sum = 0;
        int j2 = 0;
        for (int i = SIZE - 1; i >= 0; i--) {
            for (int j = j2; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    sum = sum + 1;
                } else {
                    sum = 0;
                    j2++;
                    break;
                }
            }
            if (sum == DOTS_TO_WIN) {
                return true;
            }
        }
//            return false;
        // вертикаль

        for (int i = 0; i < SIZE; i++) {
            sum = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == symb) {
                    sum = sum + 1;
                } else {
                    sum = 0;
                }

            }
            if (sum == DOTS_TO_WIN) {
                return true;
            }
        }
        return false;
    }*/

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void aiTurn() {
        int x;
        int y;
        //попытка победить самому
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O, DOTS_TO_WIN)) {
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        //Сбить победную линию противника если остался 1 ход противника
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X, DOTS_TO_WIN)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
// попытка победить самому если осталось 2 хода
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkWin(DOT_O, DOTS_TO_WIN - 1) &&
                            Math.random() < 0.5) {

                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        // сбить победную линию противника, если остался 2 ходf
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isCellValid(i, j)) {
                    map[i][j] = DOT_X;
                    if (checkWin(DOT_X, DOTS_TO_WIN - 1) &&
                            Math.random() < 0.5) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        // сходить в произвольную незанятую ячейку
        do {
            y = rand.nextInt(SIZE);
            x = rand.nextInt(SIZE);
        } while (!isCellValid(y, x));
        map[y][x] = DOT_O;
    }

    public static int humanTurn(int y, int x) {
        if (isCellValid(y, x)) {
            map[y][x] = DOT_X;
            go();

        }
        return w;
    }

    public static boolean isCellValid(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print(" "); // верхние цифры 123..
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) { // вертикальные 123..
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%c", map[i][j]);
            }
            System.out.println();
        }
    }

    static boolean checkLine(int cy, int cx, int vy, int vx, char dot, int dotsToWin) {
        if (cx + vx * (dotsToWin - 1) > SIZE - 1 || cy + vy * (dotsToWin - 1) > SIZE - 1 ||
                cy + vy * (dotsToWin - 1) < 0) {
            return false;
        }
        for (int i = 0; i < dotsToWin; i++) {
            if (map[cy + i * vy][cx + i * vx] != dot) {
                return false;
            }
        }
        return true;
    }

    static boolean checkWin(char dot, int dotsToWin) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkLine(i, j, 0, 1, dot, dotsToWin) ||
                        checkLine(i, j, 1, 0, dot, dotsToWin) ||
                        checkLine(i, j, 1, 1, dot, dotsToWin) ||
                        checkLine(i, j, -1, 1, dot, dotsToWin)) {
                    return true;
                }
            }

        }
        return false;
    }
}


