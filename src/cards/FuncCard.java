package cards;

/**
 * @author Aimi Qian
 * 
 * modified by: Christiana Kiervin & Joshua Miguel David
 * 
 * This abstract class extends Unocard. It provides a template for all functional cards in the card deck.
 */
public abstract class FuncCard extends UnoCard{
    
    /**
     * The single parameter constructor accepts the color property
     * 
     * @param color the given colour of a card.
     */
    public FuncCard(Color color){
        super(color);
    }

}
