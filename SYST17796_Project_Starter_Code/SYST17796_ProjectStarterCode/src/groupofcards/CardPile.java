package groupofcards;

import ca.sheridancollege.project.Card;
import ca.sheridancollege.project.GroupOfCards;
import java.util.ArrayList;

/**
 * @author Aimi Qian
 * This class extends GroupOfCards in strater code
 */
public class CardPile extends GroupOfCards {
    public CardPile(int size){
        super(size);
        this.setCards(new ArrayList<>());
    }

    public CardPile(int size, ArrayList<Card> cards){
        super(size);
        this.setCards(cards);
    }

    public Card getCard(int index){
        if(index < 0 || index >= this.showCards().size()){
            throw new IllegalArgumentException("Card not found in the pile!");
        }
        else {
            return this.showCards().get(index);
        }
    }

    //This method can put Card object into ArrayList
    public void addCard(Card c){
        this.showCards().add(c);
    }

    //remove the card from card pile by Card object
    public Card removeCard(Card c){
        if(!this.showCards().contains(c)){
            throw new IllegalArgumentException("Card not found in the pile!");
        }
        else{
            return this.showCards().remove(this.showCards().indexOf(c));
        }
    }

    //remove the card from card pile by the index of Card pile
    public Card removeCard(int index){
        if(index < 0 || index >= this.showCards().size()){
            throw new IllegalArgumentException("Card not found in the pile!");
        }
        else{
            return this.showCards().remove(index);
        }
    }

    //This method can combine the cards from two card piles to one card pile
    public void combinePile(CardPile otherPile){
        for(Card c: otherPile.showCards()){
            this.addCard(c);
        }
    }

    //This method can count the size of the card pile
    public int count(){
        return this.showCards().size();
    }

    //This method can clear all the cards in card pile
    public void clear(){
        this.showCards().clear();
    }

}
