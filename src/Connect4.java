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

            if (!makeMove(column)) {
                System.out.println(" Column is full. Try again. ");
                continue;
            }

            if (checkWinner()) {
                printBoard();
                System.out.println(" Player "+ currentPlayer + " wins!");
                break;
            }

            currentPlayer = ( currentPlayer==1) ? 2:1 ;

        }

        scanner.close();
    }

    public static void initializeBoard() {
        for (int row =0; row <ROWS; row++ ) {
            for (int col= 0; col < COLS; col++) {
                board[row] [col] =0;
            }
            
        }
    }

    public static void printBoard() {
        for (int row =0; row< ROWS ; row++) {
            for (int col = 0; col < COLS ;col++){
                if (board[row][col] ==0 ) {
                    System.out.println(" [] ");
                } else {
                    System.out.print(" [" + (board[row][col] == 1  ?  "X" : "0") + "] ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean makeMove( int column){
        for ( int row = ROWS -1; row >=0 ;row --) {
            if (board[row][column] ==0) {
                board [row][column] = currentPlayer;
                return true;
            }
        }
        return false;
    }

    public static boolean checkWinner(){
        for ( int row=0 ; row < ROWS; row++ ) {
            for ( int col = 0 ; col < COLS -3 ; col++) {
                if (board[row][col] == currentPlayer &&
                    board[row][col] == board[row][col +1] &&
                    board[row][col] == board [row][col +2]&&
                    board[row][col] == board [row][col+3]) {
                    return true;

                }
                
            }
        }

        for ( int row =0; row < ROWS -3 ; row++) {
            for ( int col=0; col < COLS; col++) {
                if ( board[row][col] == currentPlayer &&
                    board[row][col] == board[row + 1][col + 1] &&
                    board[row][col] == board[row + 2][col + 2] &&
                    board[row][col] == board[row + 3][col + 3]) {
                        return true;
                }
                
            }
        }

        for ( int row =3; row<ROWS; row++) {
            for (int col=0; col < COLS; col++) {
                if (board [row][col] == currentPlayer &&
                    board [row][col] == board[row -1][col +1] &&
                    board [row][col] == board[row -2][col +2] &&
                    board [row][col] == board [row -3][col +3]) {
                    return true;
                }
                
            }
        }

        return false;

    }

}
