package unogamewithplayer;

import ca.sheridancollege.project.Card;
import ca.sheridancollege.project.Player;
import cards.*;
import groupofcards.CardPile;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Aimi Qian
 * modified by: Christiana Kiervin & Joshua Miguel David
 * 
 * This class extends the Player class in the starter code. It contains methods which allow an individual to participate in an UnoGame.
 */
public class UnoPlayer extends Player {
    private CardPile cp = new CardPile(7); //Each player will have 7 cards in their hand
    private Card lastPlayerCard; //the prior card that has been chosen to play
    private Card playedCard;//the card the current user choose to play

    /**
     * Single parameter constructor which accepts a name.
     * 
     * @param name of the player
     */
    public UnoPlayer(String name){
        super(name);
    }

    /**
     * Accessor to return the card the user has selected to play on their current turn.
     * 
     * @return the card the user would like to play
     */
    public Card getPlayedCard() {
        return playedCard;
    }

    /**
     * Mutator to allow the player to specify which card they would like to play on their current turn.
     * 
     * @param playerCard is the Card object from the user's hand that they'd like to play.
     */
    public void setPlayedCard(Card playerCard) {
        this.playedCard = playerCard;
    }

    /**
     * Accessor to return the the card was was played last by a user.
     * 
     * @return the most recently played card.
     */
    public Card getLastPlayerCard() {
        return lastPlayerCard;
    }

    /**
     * Mutator to update the most recently played card during gameplay given the last played Card object.
     * 
     * @param lastPlayerCard is the Card object the user played in the most recent turn.
     */
    public void setLastPlayerCard(Card lastPlayerCard){
        this.lastPlayerCard = lastPlayerCard;
    }

    /**
     * A method to add a Card object to the current player's hand cardpile.
     * 
     * @param c the card which should be added to the player's hand.
     */
    public void takeNewCard(Card c){
        this.cp.addCard(c);
    }

    /**
     * A method to allow the user to play their card given the Card object in their hand that they'd like to play.
     * 
     * Removes the card from their current hand and returns it.
     * 
     * @param c the card the player would like to remove from their hand
     * @return the card that has been removed
     */
    public Card playCard(Card c){
        System.out.println(this.getPlayerID() + " is playing " + c);
        return this.cp.removeCard(c);
    }

    /**
     * A method to allow the user to play their card given the index of the Card object in their hand that they'd like to play.
     * 
     * Removes the card from their current hand and returns it.
     * 
     * @param index the index of the card the player would like to remove from their hand
     * @return the card that has been removed
     * 
     */
    public Card playCard(int index){
        System.out.println(this.getPlayerID() + " is playing " + this.cp.getCard(index));
        return this.cp.removeCard(index);
    }

    /**
     * A method to tell the user how many cards they have left in their hand.
     * 
     * @return the number of cards in their hand card pile
     */
    public int remain(){
        return this.cp.count();
    }

    /**
     * A method to display the cards that exist in a player's current hand card pile.
     * 
     * If there is only one card left, the player automatically declares Uno.
     * 
     */
    public void showStatus(){
        System.out.println("Your current cards:");
        System.out.println("\tFunction Cards:");
        for(Card c: this.cp.showCards()){
            if(c instanceof FuncCard){
                System.out.println("\t\t" + c);
            }
        }
        System.out.println("\tNormal Cards:");
        for(Card c: this.cp.showCards()){
            if(c instanceof NormalCard){
                System.out.println("\t\t" + c);
            }
        }

        if(this.remain() == 1){
            System.out.println("Uno! I have only one card left!");
        }
    }

    /**
     * This method will return an Arraylist of available cards to play. It calculates which cards are valid for a player to select for their turn.
     * 
     * @return an arrayList of valid cards that represent the player's options on their turn. 
     */
    public ArrayList<UnoCard> getValidCards(){
        ArrayList<UnoCard> vc = new ArrayList<>();
        for(Card c : this.cp.showCards()){
            UnoCard uc = (UnoCard) c;
            UnoCard puc = (UnoCard) this.lastPlayerCard;

            if(puc == null){
                //if this is the first player(puc == null), then he can play any card in hand
                vc.add(uc);
                continue;
            }
            if(uc.isValid(puc)){
                vc.add(uc);
            }
        }
        return vc;
    }


    /**
     * A method to suggest which cards the user can play based on the calculations of getValidCards.
     * It displays the array to the user in a friendly way.
     * 
     * @param vc the ArrayList of valid cards that can be played from the user's current hand.
     */
    public void showSuggestion(ArrayList<UnoCard> vc){
        if(vc.size() == 0){
            System.out.println("\nThe previous player plays: " + this.getLastPlayerCard() + ". So you have nothing to play, get penalized for 1 card!");
            return;
        }

        System.out.println("\nThe previous player plays: " + this.lastPlayerCard + ", So you can only play following:");

        for (int i = 0; i < vc.size(); i++) {
            System.out.println("\t" + i + " : " + vc.get(i));
        }

    }

    /**
     * A method which calls on all the methods a player needs to play their turn.
     * 
     */
    @Override
    public void play(){
        this.showStatus();
        ArrayList<UnoCard> validUnoCards = this.getValidCards();
        this.showSuggestion(validUnoCards);

        if(validUnoCards.size() == 0){
            this.setPlayedCard(null);//let other players know you have nothing to play
            return;
        }

        //if the player has the cards to play
        Scanner in = new Scanner(System.in);
        System.out.println("Enter which card do you want to play: (choose the index)");

        //The player choose the card from the suggestion by choosing an index
        int choice  = in.nextInt();


        Card c = this.playCard(validUnoCards.get(choice));

        //If they choose to play changecolor card and plusfour card, they should be asked to change a color
        if(c instanceof ChangeColorCard || c instanceof PlusFourCard){
            UnoCard un = (UnoCard)c;
            System.out.println("Which color Do you want to change to ?");
            System.out.println("1. Red 2. Yellow 3. Green 4. Blue  Your choice: ");
            int colorIndex = in.nextInt();
            Color color = Color.getColor(colorIndex);
            un.setColor(color);

            this.setPlayedCard(un);

        }
        else{
            this.setPlayedCard(c);
        }

    }

    /**
     * Standard toString method.
     * 
     * @return a formatted string which provides information about the current player.
     */
    @Override
    public String toString(){
        return "Player(" + this.getPlayerID() + ")";
    }
}
