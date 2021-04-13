package cards;

/**
 * @author Aimi Qian
 * 
 * modified by: Christiana Kiervin & Joshua Miguel David
 * 
 * PlusFourCard is a functional card (inherits abstract class FuncCard).
 */
public class PlusFourCard extends FuncCard{
    
    /**
     * Default constructor
     */
    public PlusFourCard(){
        super(Color.RED);
    }

    /**
     * The equals method returns true if two objects are the same or if the given card is also an instance of PlusFourCard
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
        if(o instanceof PlusFourCard){
            return true;
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
     * @return true every time because you can always play this card, regardless of what was played before.
     */
    @Override
    public boolean isValid(UnoCard prevCard){
        return true;
    }

    /**
     * Standard toString method.
     * 
     * @return a formatted String stating the card type.
     */
    @Override
    public String toString(){
        return "Function Card(Plus 4)";
    }
}
