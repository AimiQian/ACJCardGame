package groupofcards;

import ca.sheridancollege.project.Card;
import ca.sheridancollege.project.GroupOfCards;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

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

    public void addCard(Card c){
        this.showCards().add(c);
    }

    public Card removeCard(Card c){
        if(!this.showCards().contains(c)){
            throw new IllegalArgumentException("Card not found in the pile!");
        }
        else{
            return this.showCards().remove(this.showCards().indexOf(c));
        }
    }

    public Card removeCard(int index){
        if(index < 0 || index >= this.showCards().size()){
            throw new IllegalArgumentException("Card not found in the pile!");
        }
        else{
            return this.showCards().remove(index);
        }
    }

    public void combinePile(CardPile otherPile){
        for(Card c: otherPile.showCards()){
            this.addCard(c);
        }
    }

    public int count(){
        return this.showCards().size();
    }

    public void clear(){
        this.showCards().clear();
    }

}
