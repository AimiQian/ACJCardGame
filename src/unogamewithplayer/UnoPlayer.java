package unogamewithplayer;

import ca.sheridancollege.project.Card;
import ca.sheridancollege.project.Player;
import cards.*;
import groupofcards.CardPile;

import java.util.ArrayList;
import java.util.Scanner;

public class UnoPlayer extends Player {
    private CardPile cp = new CardPile(7);
    private Card lastPlayerCard;
    private Card playedCard;

    public UnoPlayer(String name){
        super(name);
    }

    public Card getPlayedCard() {
        return playedCard;
    }

    public void setPlayedCard(Card playerCard) {
        this.playedCard = playerCard;
    }

    public Card getLastPlayerCard() {
        return lastPlayerCard;
    }

    public void setLastPlayerCard(Card lastPlayerCard){
        this.lastPlayerCard = lastPlayerCard;
    }

    public void takeNewCard(Card c){
        this.cp.addCard(c);
    }

    public Card playCard(Card c){
        System.out.println(this.getPlayerID() + " is playing " + c);
        return this.cp.removeCard(c);
    }

    public Card playCard(int index){
        System.out.println(this.getPlayerID() + " is playing " + this.cp.getCard(index));
        return this.cp.removeCard(index);
    }

    //show how many cards left in hand
    public int remain(){
        return this.cp.count();
    }

    //show the current cards in hand
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

        int choice  = in.nextInt();


        Card c = this.playCard(validUnoCards.get(choice));

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

    @Override
    public String toString(){
        return "Player(" + this.getPlayerID() + ")";
    }
}
