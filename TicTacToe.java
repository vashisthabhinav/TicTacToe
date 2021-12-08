/*
Here is a simple game of Tic-tac-toe.
The user has to choose a number between 1-9 which will decide the place of 'X' in the grid.
The cpu automatically generates a random number between 1-9 and fills 'O' in any other place.
The result is shown as soon as a side wins or a match is drawn.
*/

package com.company.projects;

import java.util.*;

public class TicTacToe {

    static ArrayList<Integer>playerPositions= new ArrayList<Integer>();
    static ArrayList<Integer>cpuPositions   = new ArrayList<Integer>();

    public static void main(String[] args) {
        char [][] gameBoard={{' ', '|',' ','|',' ' },
                            {'-', '+','-','+','-' },
                            {' ', '|',' ','|',' ' },
                            {'-', '+','-','+','-' },
                            {' ', '|',' ','|',' ' }};


        while (true){
            Scanner scanner= new Scanner(System.in);
            System.out.println("Enter your placements (1-9): ");
            int playerPos=scanner.nextInt();
            while (playerPositions.contains(playerPos)|| cpuPositions.contains(playerPos)){
                System.out.println("Position Taken! Enter a different position");
                playerPos = scanner.nextInt();
            }
//            System.out.println(playerPos);
            placePiece(gameBoard,playerPos, "player");
            Random rand= new Random();
            int cpuPos = rand.nextInt(9)+1;
            while (playerPositions.contains(cpuPos)|| cpuPositions.contains(cpuPos)){
                cpuPos = rand.nextInt(9)+1;
            }
            placePiece(gameBoard,cpuPos, "cpu");
            printGameBoard(gameBoard);
            String result = checkWinner();
            if (result.length()>0){
                System.out.println(result);
                break;
            }

        }
        }
        public static String checkWinner(){
            List topRow   = Arrays.asList(1,2,3);
            List midRow   = Arrays.asList(4,5,6);
            List endRow   = Arrays.asList(7,8,9);
            List leftCol  = Arrays.asList(1,4,7);
            List midCol   = Arrays.asList(2,5,8);
            List rightCol = Arrays.asList(3,6,9);
            List cross1   = Arrays.asList(1,5,9);
            List cross2   = Arrays.asList(7,5,3);
            List<List> winningCondition= new ArrayList<List>();
            winningCondition.add(topRow);
            winningCondition.add(midRow);
            winningCondition.add(endRow);
            winningCondition.add(leftCol);
            winningCondition.add(midCol);
            winningCondition.add(rightCol);
            winningCondition.add(cross1);
            winningCondition.add(cross2);
            for (List l:winningCondition) {
                if(playerPositions.containsAll(l)){
                    return "Congratulations you won!";
                }else if(cpuPositions.containsAll(l)){
                    return "Sorry you lose!";
                }else if(playerPositions.size()+cpuPositions.size()==9){
                    return "Tie";
                }
            }

        return "";
        }

    public static void placePiece(char[][] gameBoard, int pos, String user) {
        char symbol =' ';
                if(user.equals("player")){
                    symbol='X';
                    playerPositions.add(pos);
                }else if (user.equals("cpu")){
                    symbol='O';
                    cpuPositions.add(pos);
                }

        switch (pos){
            case 1:
                gameBoard[0][0]=symbol;
                break;
            case 2:
                gameBoard[0][2]=symbol;
                break;
            case 3:
                gameBoard[0][4]=symbol;
                break;
            case 4:
                gameBoard[2][0]=symbol;
                break;
            case 5:
                gameBoard[2][2]=symbol;
                break;
            case 6:
                gameBoard[2][4]=symbol;
                break;
            case 7:
                gameBoard[4][0]=symbol;
                break;
            case 8:
                gameBoard[4][2]=symbol;
                break;
            case 9:
                gameBoard[4][4]=symbol;
                break;
            default:
                break;
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[]row:gameBoard) {
            for (char c:row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
