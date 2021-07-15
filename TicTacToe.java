/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author User
 */
public class TicTacToe {
 
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char [][] GameBoard = {{' ','|',' ','|',' '} ,
                              {'-','+','-','+','-'},
                              {' ','|',' ','|',' '},
                              {'-','+','-','+','-'},
                              {' ','|',' ','|',' '}};
        
        PrintGameBoard(GameBoard);
        while(true) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your placement 1-9:");
        int playerPos = scan.nextInt();
        
        while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)) {
            System.out.println("Position taken! Enter a correct position");
            playerPos= scan.nextInt();
        }
        placePiece(GameBoard, playerPos , "player");
        Random rand = new Random ();
        
        int cpuPos = rand.nextInt(9) + 1;
         while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
            
            cpuPos = rand.nextInt(9) + 1;
        }
        placePiece(GameBoard, cpuPos , "cpu");
        
        PrintGameBoard(GameBoard);
        String result = checkWinner();
        System.out.println(result);
        }
        }
        
        
   
    
    public static void PrintGameBoard(char [][] GameBoard) { 
     for(char[] row : GameBoard) {
           for(char c: row) { 
               System.out.print(c);
           } 
           System.out.println();
        }
    }
    public static void placePiece(char [][] GameBoard, int pos, String user) {
        char symbol = ' ' ;
        if(user.equals("player")) {
            
            symbol = 'x';
            playerPositions.add(pos);
        } else if(user.equals("cpu")) {
            symbol = '0';
            cpuPositions.add(pos);
        }
        
            switch(pos) {
            case 1 : 
                GameBoard[0][0] = symbol; 
                break;
            case 2 : 
                GameBoard[0][2] = symbol; 
                break;
            case 3 : 
                GameBoard[0][4] = symbol; 
                break;
            case 4 : 
                GameBoard[2][0] = symbol; 
                break;
            case 5 : 
                GameBoard[2][2] = symbol; 
                break;
            case 6 : 
                GameBoard[2][4] = symbol; 
                break;
            case 7 : 
                GameBoard[4][0] = symbol; 
                break;
            case 8 : 
                GameBoard[4][2] = symbol; 
                break;
            case 9 : 
                GameBoard[4][4] = symbol; 
                break;
            default: 
                break;
        }
    
    }
    
    
    public static String checkWinner() {
        List TopRow = Arrays.asList(1,2,3);
        List MidRow = Arrays.asList(4,5,6);
        List BotRow = Arrays.asList(7,8,9);
        List LeftColumn = Arrays.asList(1,4,7);
        List MidColumn = Arrays.asList(2,5,8);
        List RightColumn = Arrays.asList(3,6,9);
        List Cross1 = Arrays.asList(1,5,9);
        List Cross2 = Arrays.asList(7,5,3);
        
        List<List> winning = new ArrayList<>();
        winning.add(TopRow);
        winning.add(MidRow);
        winning.add(BotRow);
        winning.add(LeftColumn);
        winning.add(MidColumn);
        winning.add(RightColumn);
        winning.add(Cross1);
        winning.add(Cross2);
        
        for (List l : winning) {
            if(playerPositions.containsAll(l)) {
            return "Congratulations you won!";
        } else if(cpuPositions.contains(l)) {
                return "Cpu wins!";
            } else {
                if(playerPositions.size() + cpuPositions.size() == 9 ) {
                    return "DRAW!"; 
                }
                
            }
        }
        return null;
    }
}
  
       

    
   