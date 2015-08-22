import java.util.*;

public class Sticks {
    // globals
    static final Scanner reader = new Scanner(System.in);
    
    // sub-classes
    public static class Hand {
        private int numfingers;
        
        public Hand() { numfingers = 1; }
        
        public int getHand() { return numfingers; }
        public void setHand(int n) { numfingers = n; }
        
        public int addHand(int n) {
            numfingers += n;
            if (numfingers > 4) { numfingers = 0; }
            return numfingers;
        }
    }
    
    public static class Player {
        private Hand left;
        private Hand right;
        
        public Player() {
            left = new Hand();
            right = new Hand();
        }
        
        public int getLeft() { return left.getHand(); }
        public int getRight() { return right.getHand(); }
        public void setLeft(int n) { left.setHand(n); }
        public void setRight(int n) { right.setHand(n); }
        public void addLeft(int n) { left.addHand(n); }
        public void addRight(int n) { right.addHand(n); }
        
        public void attack(Player o, Move m) {
            if (m.getPlayerHand() == 0 && m.getOpponentHand() == 0) { o.addLeft(this.left.getHand()); }
            else if (m.getPlayerHand() == 0 && m.getOpponentHand() == 1) { o.addRight(this.left.getHand()); }
            else if (m.getPlayerHand() == 1 && m.getOpponentHand() == 0) { o.addLeft(this.right.getHand()); }
            else if (m.getPlayerHand() == 1 && m.getOpponentHand() == 1) { o.addRight(this.right.getHand()); }
            else { 
                
            }
            
        }
    }
    
    public static class Move {
        private int player_hand;
        private int opponent_hand;
        
        public Move(int phand, int ohand) {
            player_hand = phand;
            opponent_hand = ohand;
        }
        
        public int getPlayerHand() { return player_hand; }
        public int getOpponentHand() { return opponent_hand; }
    }
    
    // static methods
    public static void clearConsole() { 
        //try { Runtime.getRuntime().exec("clear"); }
        //catch (Exception e) { System.out.println(e); }
        System.out.println("\n\n\n\n");
    }
    
    public static void printState(Player[] game_state, Boolean player_turn) {
        System.out.println("    " + game_state[1].getLeft() + "  " + game_state[1].getRight() + "\n");
        System.out.println("    " + game_state[0].getLeft() + "  " + game_state[0].getRight() + "\n");
        if (player_turn) { System.out.println("Your turn! \"ll\" for left attack left, \"lr\" for left attack right, \"rl\" for right attack left, \"rr\" for right attck right, \"s\" for split"); }
        else { System.out.println("Computer's turn!"); }
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
    
    
    public static void main(String[] args) {
        // game variables
        Player[] game_state = {new Player(), new Player()};
        Boolean player_turn = true;
        Move move;
        
        // start game
        System.out.println("\nChopsticks Simulator\n********************\n(c) 2015 Matthew Brauner\n\nPress ENTER to start");
        reader.nextLine();
        
        // start of while loop
        printState(game_state, player_turn);
        
        if (player_turn) {
            move = getPlayerMove();       // player's turn
            game_state[0].attack(game_state[1], move);
        } else {
            //move = getComputerMove();     // computer's turn
            game_state[1].attack(game_state[2], move);
        }
        
        
        
    }
}