package groupofcards;

import ca.sheridancollege.project.Card;
import ca.sheridancollege.project.GroupOfCards;
import java.util.ArrayList;

/**
 * @author Aimi Qian
 * 
 * modified by: Christiana Kiervin & Joshua Miguel David
 * 
 * This class extends GroupOfCards in the starter code to allow users to instantiate a deck of uno cards.
 * It provides methods which allow users to create and manipulate card decks or piles of card as they exist in a user's hand.
 */
public class CardPile extends GroupOfCards {
    
    /**
     * Single parameter constructor accepts the given number  of cards it should contain and creates an arrayList of that size
     * 
     * @param size 
     */
    public CardPile(int size){
        super(size);
        this.setCards(new ArrayList<>());
    }

    /**
     * Multi-parameter constructor accepts the size of the deck and a pre-existing ArrayList of cards
     * 
     * 
     * @param size the number of cards the deck should hold
     * @param cards an ArrayList of cards that already exist that the deck should use.
     */
    public CardPile(int size, ArrayList<Card> cards){
        super(size);
        this.setCards(cards);
    }

    /**
     * An accessor method which returns the value of the card in the pile at a given index
     * 
     * throws an exception if the given index is out of bounds.
     * 
     * @param index the index of the card in the deck
     * @return the value of the card at a given index
     */
    public Card getCard(int index){
        if(index < 0 || index >= this.showCards().size()){
            throw new IllegalArgumentException("Card not found in the pile!");
        }
        else {
            return this.showCards().get(index);
        }
    }

    /**
     * This method adds a given Card object to the ArrayList for the current Card Pile (adding it to the deck)
     * 
     * @param c the given Card object to be added
     */
    public void addCard(Card c){
        this.showCards().add(c);
    }

    
    /**
     * This method removes a given Card object from the ArrayList for the current Card Pile (removes a card from the deck)
     * 
     * Throws an exception if the card is not in the deck already.
     * 
     * @param c the given Card object to be removed
     * return the card that has been removed
     */
    public Card removeCard(Card c){
        if(!this.showCards().contains(c)){
            throw new IllegalArgumentException("Card not found in the pile!");
        }
        else{
            return this.showCards().remove(this.showCards().indexOf(c));
        }
    }

    /**
     * This method removes a card from the deck(ArrayList) given an index of where the card is in the deck.
     * 
     * Throws an exception if the card is not in the deck already.
     * 
     * @param index the index of the card to be removed from the pile
     * @return the removed card from the deck
     */
    public Card removeCard(int index){
        if(index < 0 || index >= this.showCards().size()){
            throw new IllegalArgumentException("Card not found in the pile!");
        }
        else{
            return this.showCards().remove(index);
        }
    }

    /**
     * A method to combine two existing card piles into one.
     * 
     * @param otherPile the pile that the system wants to add to the current pile.
     */
    public void combinePile(CardPile otherPile){
        for(Card c: otherPile.showCards()){
            this.addCard(c);
        }
    }

    /**
     * This method returns the number of cards in the current pile.
     * 
     * @return the number of cards that are currently in the card pile.
     */
    public int count(){
        return this.showCards().size();
    }

    /**
     * This method clears all the cards in card pile
     */
    public void clear(){
        this.showCards().clear();
    }

}
