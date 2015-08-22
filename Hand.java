public class Hand {
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