/**
 * Tic Tac Toe
 * Simplified tic tac toe game
 * Jonathan Xu
 * March 7, 2018
*/

import java.util.Scanner;

public class Tictactoe {
  public static void main (String[] args){
    boolean player = true;
    Scanner input = new Scanner(System.in);
    int response, x, y, count;
    boolean win;
    String[][] board = new String[3][3];
    
    while(true){
      win = false;
      count = 0;
      for (int i = 0; i < 3; i++){
        for (int j = 0; j < 3; j++){
          board[i][j] = "-";
        }
      }
      
      //Welcome
      System.out.println("Welcome to TICTACTOE");
      System.out.println("Select your move based on the numbers below.");
      System.out.println("     1     2     3");
      System.out.println("     4     5     6");
      System.out.println("     7     8     9");
      while(!win){
        //Player guess
        if(player){
          System.out.print("Player X's turn:");
          player = false;
        }
        else{
          System.out.print("Player O's turn:");
          player = true;
        }
        response = input.nextInt();
        while(!board[(response-1)/3][(response-1)%3].equals("-")){
          System.out.print("That spot is already taken. Guess again.");
          response = input.nextInt();
        }
        
        count ++;
        y = (response-1)/3;
        x = (response-1)%3;
        
        if (!player){
          board[y][x] = "X";
        }
        else {
          board[y][x] = "O";
        }
        
        //Draw board
        for (int i = 0; i < 3; i++){
          for (int j = 0; j<3; j++){
            System.out.print("     " + board[i][j]);
          }
          System.out.println();
        }
        
        //Check win
        if (checkWin(board, y, x, !player) == 1){
          System.out.println("Player X Wins!!");
          win = true;
        }
        else if (checkWin(board, y, x, !player) == 2){
          System.out.println("Player O Wins!!");
          win = true;
        }
        else if (count == 9){
          System.out.println("It's a tie!");
          win = true;
        }
      }
      //Replay?
      System.out.print("Do you want to play again? (y/n)");
      if (input.next().equals("n")){
        System.out.println("Thanks for playing!");
        input.close();
        break;
      }
    }
  }
  
  public static int checkWin(String[][] game, int y, int x, boolean turn){
    boolean connect = false;
    if (game[y][0].equals(game[y][1])&&game[y][1].equals(game[y][2])){
      connect = true;
    }
    else if (game[0][x].equals(game[1][x])&&game[1][x].equals(game[2][x])){
      connect = true;
    }
    else if (game[0][0].equals(game[1][1])&&game[1][1].equals(game[2][2])&&!game[1][1].equals("-")){
      connect = true;
    }
    else if (game[0][2].equals(game[1][1])&&game[1][1].equals(game[2][0])&&!game[2][0].equals("-")){
      connect = true;
    }
    if (connect && turn){
      return 1;
    }
    else if (connect && !turn){
      return 2;
    }
    else{
      return 0;
    }
  }
}