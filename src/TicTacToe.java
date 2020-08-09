import java.util.Scanner;

public class TicTacToe
{

    public static void main(String[] args)
    {
        char[][] ticTacToeBoard = {{' ','|',' ', '|',' ' },{'-','+','-','+','-'},{' ','|',' ', '|',' ' },{'-','+','-','+','-'},{' ','|',' ', '|',' ' }};
        makeGameBoard(ticTacToeBoard);

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your move position (1-9): ");
        int position = scan.nextInt();
        System.out.println(position);

    }

    public static void makeGameBoard(char[][] ticTacToeBoard)
    {
        for (char[] row : ticTacToeBoard)
        {
            for (char c : row)
            {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
