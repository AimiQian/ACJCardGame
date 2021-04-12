package cards;

/**
 * @author Aimi Qian
 * 
 * modified by: Christiana Kiervin & Joshua Miguel David
 * 
 * This class extends UnoCard to allow users to generate instances of normal cards (regular numbered cards).
 * 
 */
public class NormalCard extends UnoCard{
    private int num;

    /**
     * Multi-parameter constructor accepts a given colour and number.
     * 
     * It uses the parent class' constructor to assign the colour and the current class' mutator method to assign number.
     * 
     * @param color the assigned colour
     * @param num the number of the card
     */
    public NormalCard (Color color, int num){
        super(color);
        this.setNum(num);
    }

    /**
     * A method for accessing the number of the current card.
     * 
     * 
     * @return the value of the number attribute for the current card.
     */
    public int getNum() {
        return this.num;
    }

    
    /**
     * A method for mutating the number of the current card.
     * 
     * @param num is the number the system wants to set the card value as. If the number is between 0 and 9 then it will be set.
     * 
     * Throws an exception if the given number is not valid (between 0-9).
     */
    public void setNum(int num) {
        if(num >= 0 && num <= 9) {
            this.num = num;
        }
        else{
            throw new IllegalArgumentException("Number should be between 0 - 9.");
        }
    }

    /**
     * The equals method returns true if two objects are the same or if you have another instance of a normal card with the same colour and number.
     * 
     * @param o the given card object to be compared to the current object.
     * 
     * @return true if cards are the same

     */
    @Override
    public boolean equals(Object o){
        if(this == o ){
            return true;
        }
        if (o == null){
            return false;
        }
        if(o instanceof NormalCard){
            NormalCard nc = (NormalCard) o;
            return this.getColor() == nc.getColor() && this.getNum() == nc.getNum();
        }
        else{
            return false;
        }
    }

    /**
     * isValid checks whether the card is valid to play in the current player's turn.
     * 
     * @param prevCard the card object played in the last player's turn.
     * 
     * @return true if the last card was also a normal card with the same colour OR a normal card with the same number OR a functional card with the same colour.

     */
    @Override
    public boolean isValid(UnoCard prevCard){
        if(prevCard instanceof NormalCard){
            NormalCard nc = (NormalCard) prevCard;
            return this.getColor() == nc.getColor() || this.getNum() == nc.getNum();
        }
        else if(prevCard instanceof FuncCard){
            FuncCard fc = (FuncCard) prevCard;
            return this.getColor() == fc.getColor();
        }
        else{
            return false;
        }
    }

    /**
     * Standard toString method.
     * 
     * @return a formatted string providing the card type, colour and number.
     */
    @Override
    public String toString(){
        return "Normal Card (Color:" + this.getColor().getColorName() + "/Num:" + this.getNum() + ")";
    }

}
