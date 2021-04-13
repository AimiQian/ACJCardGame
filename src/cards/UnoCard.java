package cards;

import ca.sheridancollege.project.Card;

/**
 * @author Aimi Qian
 * 
 * modified by: Christiana Kiervin & Joshua Miguel David
 * 
 * This abstract class extends Card class in starter code to provide a template for all Uno cards.
 */
public abstract class UnoCard extends Card {
    private Color color;

    /**
     * Accessor method returns the current colour of the current card.
     * 
     * @return returns the colour of the current card.
     */
    public Color getColor(){
        return this.color;
    }

    /**
     * Mutator method sets the colour of the current card
     * 
     * @param color the given color enum the user would like to set.
     */
    public void setColor(Color color){
        this.color = color;
    }

    /**
     * The protected single-parameter constructor allows only children to create instances of Uno Cards
     * 
     * @param color the enum colour given to the card.
     */
    protected UnoCard(Color color){
        this.color = color;
    }

    /**
     * Abstract method, need to be implemented by subclasses
     * all UnoCards need to have isValid method to be used to check if the card can be played 
     */
    public abstract boolean isValid(UnoCard prevCard);

}
