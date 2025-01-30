import java.util.Scanner;
public class Connect4 {
    static final int ROWS=6;
    static final int COLS=7;
    static int [][] board = new int[ROWS][COLS];
    static int currentPlayer = 1 ;

    public static void main (String[]args) {
        Scanner scanner = new Scanner(System.in);
        initializeBoard();

        while (true) {
            printBoard();
            System.out.println("Player "+ currentPlayer + " 's turn. Choose a column  (0-6): ");
            int column =scanner.nextInt();

            if (column<0 || column >=COLS) {
                System.out.println(" Invalid column.Please choose a column between 0 and 6, ");
                continue;
            }

            
        }
    }


}
