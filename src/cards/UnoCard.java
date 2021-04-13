package cards;

import ca.sheridancollege.project.Card;

/**
 * @author Aimi Qian
 * This class extends Card class in starter code
 */
public abstract class UnoCard extends Card {
    private Color color;

    public Color getColor(){
        return this.color;
    }

    public void setColor(Color color){
        this.color = color;
    }

    protected UnoCard(Color color){
        this.color = color;
    }

    //Abstract method, need to be implemented by subclasses
    //all UnoCards need to have valid method to be used to check if the card can be played
    public abstract boolean isValid(UnoCard prevCard);

}
