import java.security.spec.RSAOtherPrimeInfo;
import java.util.*;

public class TicTacToe
{
    static ArrayList<Integer> playerPositions = new ArrayList<>();
    static ArrayList<Integer> cpuPositions = new ArrayList<>();


    public static void main(String[] args)
    {
        char[][] ticTacToeBoard = {{' ','|',' ', '|',' ' },{'-','+','-','+','-'},{' ','|',' ', '|',' ' },{'-','+','-','+','-'},{' ','|',' ', '|',' ' }};

        makeGameBoard(ticTacToeBoard);

        while (gameOver() == false)
        {
            Scanner scan = new Scanner(System.in);

            System.out.println("\nEnter your move position (1-9): ");
            int positionOfPlayer = scan.nextInt();

            while (playerPositions.contains(playerPositions) || cpuPositions.contains(playerPositions) )
            {
                System.out.println("Position occupied! do better...");
                positionOfPlayer = scan.nextInt();
            }

            piecePlacement(ticTacToeBoard, positionOfPlayer, "player");

            Random rand = new Random();
            int positionCPU = rand.nextInt(9) +1;

            while (playerPositions.contains(cpuPositions) || cpuPositions.contains(cpuPositions) )
            {
                System.out.println("Position occupied! do better...");
                positionOfPlayer = scan.nextInt();
                positionCPU = rand.nextInt(9) +1;
            }

            piecePlacement(ticTacToeBoard, positionCPU, "CPU");

            makeGameBoard(ticTacToeBoard);
            String winnerResult = isWinner();
            System.out.println(winnerResult);
        }
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


    public static void piecePlacement(char[][] ticTacToeBoard, int position, String user)
    {
        char symbol = ' ';

        if (user.equals("player"))
        {
            symbol = 'X';
            playerPositions.add(position);
        }
        else if (user.equals("CPU"))
        {
            symbol = 'O';
            cpuPositions.add(position);
        }

        switch(position)
        {
            case 1:
                ticTacToeBoard[0][0] = symbol;
                break;
            case 2:
                ticTacToeBoard[0][2] = symbol;
            case 3:
                ticTacToeBoard[0][4] = symbol;
                break;
            case 4:
                ticTacToeBoard[2][0] = symbol;
                break;
            case 5:
                ticTacToeBoard[2][2] = symbol;
                break;
            case 6:
                ticTacToeBoard[2][4] = symbol;
                break;
            case 7:
                ticTacToeBoard[4][0] = symbol;
                break;
            case 8:
                ticTacToeBoard[4][2] = symbol;
                break;
            case 9:
                ticTacToeBoard[4][4] = symbol;
                break;
        }

    }

    public static String isWinner()
    {
        List topRow= Arrays.asList(1,2,3);
        List middleRow= Arrays.asList(4,5,6);
        List bottomRow= Arrays.asList(7,8,9);

        List leftColumn = Arrays.asList(1,4,7);
        List middleColumn = Arrays.asList(2,5,8);
        List rightColumn = Arrays.asList(3,6,9);

        List crossWin1 = Arrays.asList(1,5,9);
        List crossWin2 = Arrays.asList(7,5,3);

        List<List> checkWinConditionList = new ArrayList<>();
        checkWinConditionList.add(topRow);
        checkWinConditionList.add(middleRow);
        checkWinConditionList.add(bottomRow);
        checkWinConditionList.add(leftColumn);
        checkWinConditionList.add(middleColumn);
        checkWinConditionList.add(rightColumn);
        checkWinConditionList.add(crossWin1);
        checkWinConditionList.add(crossWin2);

        String winningStatement = " ";

        for (List list: checkWinConditionList)
        {
            if (playerPositions.containsAll(list))
            {
                winningStatement =  "Congratulations player!";
            }
            else if (cpuPositions.containsAll(list))
            {
                winningStatement =  "Sorry bud, you blew it...";
            }
            else if (playerPositions.size() + cpuPositions.size() == 9)
            {
                winningStatement =  "It's a tie! try again?";
            }
        }
        return winningStatement;
    }

    public static boolean gameOver()
    {
        List topRow = Arrays.asList(1, 2, 3);
        List middleRow = Arrays.asList(4, 5, 6);
        List bottomRow = Arrays.asList(7, 8, 9);

        List leftColumn = Arrays.asList(1, 4, 7);
        List middleColumn = Arrays.asList(2, 5, 8);
        List rightColumn = Arrays.asList(3, 6, 9);

        List crossWin1 = Arrays.asList(1, 5, 9);
        List crossWin2 = Arrays.asList(7, 5, 3);

        List<List> checkWinConditionList = new ArrayList<>();
        checkWinConditionList.add(topRow);
        checkWinConditionList.add(middleRow);
        checkWinConditionList.add(bottomRow);
        checkWinConditionList.add(leftColumn);
        checkWinConditionList.add(middleColumn);
        checkWinConditionList.add(rightColumn);
        checkWinConditionList.add(crossWin1);
        checkWinConditionList.add(crossWin2);

        boolean result = false;

        for (List list : checkWinConditionList)
        {
            if (playerPositions.containsAll(list))
            {
                result = true;
            } else if (cpuPositions.containsAll(list))
            {
                result =  true;
            } else if (playerPositions.size() + cpuPositions.size() == 9)
            {
                result = true;
            } else {
                result =  false;
            }
        }
        return result;
    }
}
