package Gol;
public class Rules extends Settings{
    public Rules(int w, int h, int g, int s, String p) {
        super(w, h, g, s, p);
    }
    int count =1;
    public void Run(int[][] grid) throws InterruptedException {
        int[][] nextGrid = new int[w][h];
        String RED = "\033[0;31m";
        String ANSI_RESET = "\u001B[0m";
        int cellsCount=0;
        for (int l = 0; l < w; l++) {
            for (int m = 0; m < h; m++) {
                if(grid[l][m]==1)
                    cellsCount++;
                int neighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        if ((l + i >= 0 && l + i < w) && (m + j >= 0 && m + j < h))
                            neighbours += grid[l + i][m + j];
                neighbours -= grid[l][m];
                if ((grid[l][m] == 1) && (neighbours < 2))
                    nextGrid[l][m] = 0;
                else if ((grid[l][m] == 1) && (neighbours > 3))
                    nextGrid[l][m] = 0;
                else if ((grid[l][m] == 0) && (neighbours == 3))
                    nextGrid[l][m] = 1;
                else
                    nextGrid[l][m] = grid[l][m];
            }
        }
        switch (g){
            case 0:
                Thread.sleep(s);
                System.out.println("\nGeneration " + count + " Cells alive: " + cellsCount + " Seconds: " + s);
                for (int x = 0; x < w; x++) {
                    for (int y = 0; y < h; y++) {
                        if (nextGrid[x][y] == 0)
                            System.out.print(".\t");
                        else
                            System.out.print(RED + "█\t" + ANSI_RESET);
                    }
                    System.out.println();
                }count ++;
                Run(nextGrid);
            default:
                if(count<=g) {
                    Thread.sleep(s);
                    System.out.println("\nGeneration " + count + " Cells alive: " + cellsCount + " Seconds: " + s);
                    for (int x = 0; x < w; x++) {
                        for (int y = 0; y < h; y++) {
                            if (nextGrid[x][y] == 0)
                                System.out.print(".\t");
                            else
                                System.out.print(RED+"█\t"+ANSI_RESET);
                        }
                        System.out.println();
                    }
                    count++;
                    Run(nextGrid);
                }
             }
         }
    }