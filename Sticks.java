import java.util.*;

public class Sticks {
    static final Scanner reader = new Scanner(System.in);
    
    public static void clearConsole() { 
        //try { Runtime.getRuntime().exec("clear"); }
        //catch (Exception e) { System.out.println(e); }
        System.out.println("\n\n\n\n");
    }
    
    public static Boolean getGameMode() {
        while (true) {
            System.out.println("Select game mode:\n1 - Single player\n2 - 2 player");
            String game_string = reader.next().toLowerCase().trim();
            
            if (game_string.equals("1")) { System.out.println("This mode is currently unavailable"); }
            else if (game_string.equals("2")) { return false; }
            else { System.out.println("Invalid entry"); }
            
        }
    }
    
    public static void printState(Player[] game_state, Boolean player_turn, Boolean single_player) {
        clearConsole();
        System.out.println("     L  R");
        
        if (single_player) {
            System.out.println("    " + game_state[1].getLeft() + "  " + game_state[1].getRight() + "\n");
            System.out.println("    " + game_state[0].getLeft() + "  " + game_state[0].getRight() + "\n");
            
            if (player_turn) { System.out.println("Your turn! \"ll\" for left attack left, \"lr\" for left attack right, \"rl\" for right attack left, \"rr\" for right attck right, \"s\" for split"); }
            else { System.out.println("Computer's turn!"); }
        } else {
            if (player_turn) {
                System.out.println("P2:  " + game_state[1].getLeft() + "  " + game_state[1].getRight() + "\n");
                System.out.println("P1:  " + game_state[0].getLeft() + "  " + game_state[0].getRight() + "\n");
            } else {
                System.out.println("P1:  " + game_state[0].getLeft() + "  " + game_state[0].getRight() + "\n");
                System.out.println("P2:  " + game_state[1].getLeft() + "  " + game_state[1].getRight() + "\n");
            }
            
            if (player_turn) { System.out.println("Player 1's turn! \"ll\" for left attack left, \"lr\" for left attack right, \"rl\" for right attack left, \"rr\" for right attck right, \"s\" for split"); }
            else { System.out.println("Player 2's turn! \"ll\" for left attack left, \"lr\" for left attack right, \"rl\" for right attack left, \"rr\" for right attck right, \"s\" for split"); }
        }
    }
    
    public static Move getPlayerMove() {
        while (true) {
            String move_string = reader.next().toLowerCase().trim();
            if (move_string.equals("ll")) { return new Move(0,0); }
            else if (move_string.equals("lr")) { return new Move(0,1); }
            else if (move_string.equals("rl")) { return new Move(1,0); }
            else if (move_string.equals("rr")) { return new Move(1,1); }
            else if (move_string.equals("s")) { return new Move(-1,-1); }
            else { System.out.println("Invalid move! Please enter \"ll\", \"lr\", \"rl\", \"rr\", or \"s\""); }
        }
    }
    
    public static void playMultiplayer() {
        Player[] game_state = {new Player(), new Player()};
        Boolean player_1_turn = true;
        Move move;
        
        while (true) {
            printState(game_state, player_1_turn, false);
            move = getPlayerMove();
            
            if (player_1_turn) {
                game_state[0].attack(game_state[1], move);
            } else {
                game_state[1].attack(game_state[0], move);
            }
            
            if (game_state[0].checkLose()) { 
                System.out.println("Player 2 wins!");
                break;
            }
            if (game_state[1].checkLose()) { 
                System.out.println("Player 1 wins!");
                break;
            }
            
            player_1_turn = !player_1_turn;
        }
        
    }
    
    public static void playSingleplayer() {
        Player[] game_state = {new Player(), new Player()};
        Boolean player_turn = true;
        Move move;
        
        // start of while loop
        printState(game_state, player_turn, true);
        
        //if (player_turn) {
          //  move = getPlayerMove();       // player's turn
            //game_state[0].attack(game_state[1], move);
        //} else {
            //move = getComputerMove();     // computer's turn
            //game_state[1].attack(game_state[2], move);
        //}
    }
    
    public static void main(String[] args) {
        Boolean single_player;
        
        System.out.println("\nChopsticks Simulator\n********************\n(c) 2015 Matthew Brauner\n");
        single_player = getGameMode();
        
        if (single_player) { playSingleplayer(); }
        else { playMultiplayer(); }
        
        System.out.println("Thank you for playing!");
    }
}