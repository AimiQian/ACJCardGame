package cards;

/**
 * @author Aimi Qian
 * 
 * modified by: Christiana Kiervin & Joshua Miguel David
 * 
 * ChangeColorCard is a functional card (inherits abstract class FuncCard) and provides the methods associated with changing the colour of card that a player is allowed to play next.
 * 
 */
public class ChangeColorCard extends FuncCard{
    
    /**
     * Default constructor
     * 
     */
    public ChangeColorCard(){
        super(Color.RED);
    }

    
    /**
     * The equals method returns true if two objects are the same or if you have another instance of a change colour card.
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
        if(o instanceof ChangeColorCard){
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
     * @return true every time because you can play this card at any point in the game.

     */
    @Override
    public boolean isValid(UnoCard prevCard){
        return true;
    }

    /**
     * Standard toString method.
     * 
     * @return a formatted string explaining the type of card it is.
     */
    @Override
    public String toString(){
        return "Function Card (Change color)";
    }

}
