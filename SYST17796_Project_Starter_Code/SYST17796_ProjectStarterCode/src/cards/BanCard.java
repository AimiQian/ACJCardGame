package cards;

/**
 * @author Aimi Qian
 * 
 * modified by: Christiana Kiervin & Joshua Miguel David
 * 
 * BanCard is a functional card (inherits abstract class FuncCard) and provides the methods associated with skipping a player's turn.
 * 
 * 
 */

public class BanCard extends FuncCard{
    
    /**
     * Single parameter constructor
     * 
     * @param color is the given colour of the card
     */
    public BanCard (Color color){
        super(color);
    }

    /**
     * The equals method returns true if two objects are the same or two ban cards are the same colour, which constitutes being the same.
     * 
     * @param o the given card object to be compared to the current object.
     * 
     * @return true if cards are the same
     */
    @Override
    public boolean equals(Object o){
        if(this == o){
            return true;
        }
        if(o == null){
            return false;
        }
        if(o instanceof BanCard){
            BanCard bc = (BanCard) o;
            return this.getColor() == bc.getColor();
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
     * @return true if colour is the same or card type is the same
     */
    @Override
    public boolean isValid(UnoCard prevCard){
        return this.getColor() == prevCard.getColor()||prevCard instanceof BanCard;
    }

    
    /**
     * Standard toString method which returns 
     * 
     * @return the formatted string containing the type and colour of the card.
     */
    @Override
    public String toString(){
        return "Function Card(Ban/Color:" + this.getColor().getColorName() + ")";
    }
}
