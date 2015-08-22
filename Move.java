public class Move {
    private int player_hand;
    private int opponent_hand;
    
    public Move(int phand, int ohand) {
        player_hand = phand;
        opponent_hand = ohand;
    }
    
    public int getPlayerHand() { return player_hand; }
    
    public int getOpponentHand() { return opponent_hand; }
    
}