import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayer;
    private boolean isGameOver;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        isGameOver = false;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    private void makeMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        } else {
            System.out.println("Invalid move! Try again.");
        }
    }

    private boolean checkWin() {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }

            if (board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return true;
            }
        }

        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }

        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }

    private boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // There is an empty cell, the game is not a draw yet.
                }
            }
        }
        return true; // All cells are filled, and no one won. The game is a draw.
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();

        System.out.println("Welcome to Tic Tac Toe!");
        System.out.println("Player X starts first.");

        while (!game.isGameOver) {
            game.printBoard();

            int row, col;
            do {
                System.out.print("Player " + game.currentPlayer + ", enter row (0-2): ");
                row = scanner.nextInt();
                System.out.print("Player " + game.currentPlayer + ", enter column (0-2): ");
                col = scanner.nextInt();
            } while (row < 0 || row > 2 || col < 0 || col > 2);

            game.makeMove(row, col);

            if (game.checkWin()) {
                game.printBoard();
                System.out.println("Player " + game.currentPlayer + " wins!");
                game.isGameOver = true;
            } else if (game.checkDraw()) {
                game.printBoard();
                System.out.println("It's a draw!");
                game.isGameOver = true;
            }
        }

        scanner.close();
    }
}

