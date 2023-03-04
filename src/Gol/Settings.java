package Gol;
import java.util.Random;
public class Settings {
    protected int w, h, g, s, count, cellscount;
    protected String p;
    protected char[] value;
    protected int[][] grid;
    Random rand = new Random();
    int randGrid;
    String RED = "\033[0;31m";
    String ANSI_RESET = "\u001B[0m";


    public Settings(int w, int h, int g, int s, String p) {
        this.w = w;
        this.h = h;
        this.g = g;
        this.s = s;
        this.p = p;
        this.grid = new int[w][h];
        this.value = p.toCharArray();
    }
    public void convert() throws InterruptedException {
        if (p.equals("rnd")) {
            System.out.println("initial grid: ");
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    grid[i][j] = (randGrid = rand.nextInt(2));
                    if (grid[i][j] == 0)
                        System.out.print(".\t");
                    else
                        System.out.print(RED+"*\t"+ANSI_RESET);
                }
                System.out.println();
            }
            System.out.print("\n");
            var go = new Rules(w, h, g, s, p);
            go.Run(grid);
        } else {
            int row = 0;
            int colum = 0;
            for (char vaul : value) {
                switch (vaul) {
                    case '0' -> {
                        grid[row][colum] = 0;
                        colum++;
                    }
                    case '1' -> {
                        grid[row][colum] = 1;
                        colum++;
                    }
                    case '#' -> {
                        colum = 0;
                        row++;
                    }
                }
            }
            System.out.println("initial grid: ");
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (grid[i][j] == 0)
                        System.out.print(".\t");
                    else
                        System.out.print(RED+"*\t"+ANSI_RESET);
                }
                System.out.println();
            }
            System.out.print("\n");
            var go = new Rules(w, h, g, s, p);
            go.Run(grid);
        }
    }
}