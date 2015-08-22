public class Player {
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
    
    public boolean checkLose() { return (left.getHand() == 0 && right.getHand() == 0) ? true : false; }
    
    public void attack(Player o, Move m) {
        if (m.getPlayerHand() == 0 && m.getOpponentHand() == 0) { o.addLeft(this.left.getHand()); }
        else if (m.getPlayerHand() == 0 && m.getOpponentHand() == 1) { o.addRight(this.left.getHand()); }
        else if (m.getPlayerHand() == 1 && m.getOpponentHand() == 0) { o.addLeft(this.right.getHand()); }
        else if (m.getPlayerHand() == 1 && m.getOpponentHand() == 1) { o.addRight(this.right.getHand()); }
        else { this.split(); }
    }
    
    public void split() {
        int total_hand = left.getHand() + right.getHand();
        left.setHand(total_hand / 2);
        right.setHand(total_hand / 2 + total_hand % 2);
    }
}