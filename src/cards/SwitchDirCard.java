package cards;

/**
 * @author Aimi Qian
 * 
 * modified by: Christiana Kiervin & Joshua Miguel David
 * 
 * SwitchDirCard is a functional card (inherits abstract class FuncCard).
 */
public class SwitchDirCard extends FuncCard{
    /**
     * Single parameter constructor
     * 
     * @param color the given colour of the card.
     */
    public SwitchDirCard(Color color){
        super(color);
    }

    /**
     * The equals method returns true if two objects are the same or if the given card is also an instance of SwitchDirCard with the same colour.
     * 
     * @param o the given card object to be compared to the current object.
     * 
     * @return true if cards are the same or if they are both instances of SwitchDirCard with the same colours.
     */
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null){
            return false;
        }
        if(o instanceof SwitchDirCard){
            SwitchDirCard sdc = (SwitchDirCard) o;
            return this.getColor() == this.getColor();
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
     * @return true if the colour matches the previously played card's colour OR if the previous card was also a SwitchDirCard.
     */
    @Override
    public boolean isValid(UnoCard prevCard){
        return this.getColor() ==  prevCard.getColor()|| prevCard instanceof SwitchDirCard;
    }

    /**
     * Standard toString method.
     * 
     * @return a formatted String providing the card type and its colour.
     */
    @Override
    public String toString(){
        return "Function Card(Reverse/Color:" + this.getColor().getColorName() + ")";
    }

}
