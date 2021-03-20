package cards;

import ca.sheridancollege.project.Card;

/**
 * @author Aimi Qian
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

    public abstract boolean isValid(UnoCard prevCard);

}
