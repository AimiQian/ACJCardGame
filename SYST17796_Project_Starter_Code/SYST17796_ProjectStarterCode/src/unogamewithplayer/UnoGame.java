package unogamewithplayer;

import ca.sheridancollege.project.Card;
import ca.sheridancollege.project.Game;
import ca.sheridancollege.project.Player;
import cards.*;
import groupofcards.CardPile;

import java.util.Scanner;

/**
 * @author Aimi Qian
 * 
 * modified by: Christiana Kiervin & Joshua Miguel David
 * 
 * This class extends Game class in starter code. It contains methods which allow for the main functionality of the Uno game-play from registering players to declaring a winner.
 * 
 */
public class UnoGame extends Game {
    private CardPile unPlayedCP = new CardPile(108);
    private CardPile playedCP = new CardPile(108);

    private int orderStep =1; //could be either 1 or -1
    private int currentPlayerIndex = -1;

    /**
     * Single parameter constructor to create the Uno Game
     * 
     * @param givenName 
     */
    public UnoGame(String givenName){
        super(givenName);
    }

    /**
     * A method to create new UnoPlayer objects for each player in the game by retrieving user inputted names.
     * 
     */
    private void registerPlayer(){
        System.out.println("Uno Player Registration");
        Scanner in = new Scanner(System.in);

        int i = 1;
        while(true){
            System.out.println("Enter User Name:");
            String name = in.nextLine();
            System.out.println("Player " + i + " registered!");
            UnoPlayer player = new UnoPlayer(name);
            this.getPlayers().add(player);
            System.out.print("More player? (Y/N)");
            String answer = in.nextLine();
            if(answer.equalsIgnoreCase("N")){

                break;
            }
            i++;
        }
    }

    
    /**
     * A method to welcome all players once they have been registered.
     */
    private void welcomePlayer(){
        System.out.println("Welcome Players: ");
        for (Player p : this.getPlayers()){
            System.out.println("\t" + p.getPlayerID());
        }
        System.out.println("Good luck!");

    }

    /**
     * A method to initialize the deck of uno cards. The unPlayed card pile object will receive 108 cards total.
     * 
     *  Normal Cards = 76:
     *      1-9: 9 number * 4 color * 2 = 72  
     *      0: 4 color = 4
     * 
     *  Functional Cards = 32:
     *      BanCard: 4 color * 2 = 8
     *      SwitchCard : 4 color * 2 = 8
     *      PlusTwoCard: 4 color * 2 = 8
     *      ChangeColorCard: 4
     *      PlusFourCard: 4
     * 
     *  Total 108 cards
     * 
     */
    private void iniCards(){

        for(Color color: Color.values()){
            //generate normal cards ( 0 - 9 ) * 4 colors
            for (int i = 0; i < 10; i++){
                this.unPlayedCP.addCard(new NormalCard(color, i));
            }
            //generate normal cards ( 1 - 9 ) * 4 colors
            for (int i = 1; i < 10; i++ ){
                this.unPlayedCP.addCard(new NormalCard(color, i));
            }

            //generate coloured functional cards
            this.unPlayedCP.addCard(new BanCard(color));
            this.unPlayedCP.addCard(new BanCard(color));
            this.unPlayedCP.addCard(new SwitchDirCard(color));
            this.unPlayedCP.addCard(new SwitchDirCard(color));
            this.unPlayedCP.addCard(new PlusTwoCard(color));
            this.unPlayedCP.addCard(new PlusTwoCard(color));

        }

        //generate uncoloured functional cards
        for(int i = 0; i < 4; i ++){
            this.unPlayedCP.addCard(new PlusFourCard());
            this.unPlayedCP.addCard(new ChangeColorCard());
        }

        this.unPlayedCP.shuffle();
    }

   
    /**
     * A method to deal 7 cards to each player. The methood will randomly draw cards from the unPlayed Card Pile and transfer them to the UnoPlayer's hand cardPile.
     * 
     */
    private void dealCards(){
        for(int i = 0; i < 7; i++){
            for(Player p : this.getPlayers()){
                UnoPlayer player = (UnoPlayer) p;

                //remove card from the card pile and give the card to the player
                Card c = this.unPlayedCP.removeCard(0);
                player.takeNewCard(c);
            }
        }
    }

    /**
     * nextPlayer will return the Player object for the player whose turn is next.
     * 
     * @return the UnoPlayer whose turn is next.
     */
    private UnoPlayer nextPlayer(){
        this.currentPlayerIndex = (this.currentPlayerIndex + this.orderStep) % this.getPlayers().size();
        if(this.currentPlayerIndex < 0){
            this.currentPlayerIndex += this.getPlayers().size();
        }

        return (UnoPlayer) this.getPlayers().get(this.currentPlayerIndex);
    }


    /**
     * A method to reverse the direction of current gameplay. It is called by special function ReverseDir cards to alter the UnoGame game-play.
     */
    private void reverse(){
        this.orderStep = this.orderStep * -1; // orderStep can only be 1 or -1
    }

    /**
     * Given a minimum number of cards allowed in a cardPile, this method ensures the players do not run out of cards to draw from by combining the played cards with unplayed cards.
     * 
     * @param minimum the minimum number of cards allowed in the unPlayed Card Pile before the decks will be combined and shuffled.
     */
    private void checkAndSupply(int minimum){
        // check if the number of card in the unplayed card pile falls below minimum amount
        // if so, add all played cards to unplayed pile and shuffle
        if(this.unPlayedCP.count() < minimum){
            System.out.println("\nNot enough card in unplayed card pile, will put all played cards back and shuffle!\n");
            this.unPlayedCP.combinePile(this.playedCP);
            this.playedCP.clear();
            this.unPlayedCP.shuffle();
        }
    }

    /**
     * A method to add cards from the unPlayed deck to a player's hand.
     * 
     * The player will receive cards when they cannot play any of their current cards or if they are penalized by a PlusTwo or PlusFour function card.
     * 
     * The method will add the specified number of cards to the given player's hand cardpile.
     * 
     * @param player the player who will be receiving cards
     * @param num the number of cards a player must take
     */
    private void penalize(UnoPlayer player, int num){
        this.checkAndSupply(num); //check if there are least number of cards left

        System.out.println("Haha! " + player.getPlayerID() + ", you are penalized for " + num + " more cards:");
        for(int i = 0; i < num; i ++){
            Card c = this.unPlayedCP.removeCard(0);//the player takes the card from the top of the card pile
            System.out.println("\t" + c);
            player.takeNewCard(c);
        }

    }

    /**
     * The play method calls upon all necessary methods to initialize a game and begins to play.
     */
    @Override
    public void play(){
        System.out.println("Uno Game Start");
        this.registerPlayer();
        this.welcomePlayer();
        this.iniCards();
        this.dealCards();

        Card previousPlayedCard = null;

        while(true){

            UnoPlayer player = this.nextPlayer();
            System.out.println("\n\n" + player.getPlayerID() + ", its your turn!");
            System.out.println("Last player played: " + previousPlayedCard + "\n");
            player.setLastPlayerCard(previousPlayedCard);

            if(previousPlayedCard instanceof PlusTwoCard){
                this.penalize(player, 2);
            }

            if(previousPlayedCard instanceof PlusFourCard){
                this.penalize(player, 4);
            }

            player.play();

            Card currentPlayerCard = player.getPlayedCard();
            if(currentPlayerCard == null){
                //if current player has no card to play
                this.penalize(player, 1);// Add one card
                continue; // skip all the following steps
            }
            else {
                previousPlayedCard = currentPlayerCard;
                this.playedCP.addCard(previousPlayedCard);
            }

            //judge if wins
            if(player.remain() == 0){
                this.declareWinner();
                break; // Game over, no need to continue
            }

            if(previousPlayedCard instanceof SwitchDirCard){
                this.reverse();
                System.out.println("\nThe game order has been reversed!\n");
            }

            if(previousPlayedCard instanceof BanCard){
                UnoPlayer skippedPlayer = this.nextPlayer();
                System.out.println("\nOh no!" + skippedPlayer.getPlayerID() + " has been skipped!\n");
            }

            if(previousPlayedCard instanceof ChangeColorCard){
                System.out.println("\nCurrent Color has been changed to " + ((ChangeColorCard) previousPlayedCard).getColor() + "!\n");

            }
        }

    }

    /**
     * A method to declare the winner of the game.
     * 
     */
    public void declareWinner(){
        Player winner = this.getPlayers().get(this.currentPlayerIndex);
        System.out.println("\nWinner is " + winner.getPlayerID() + "\nGame over! Thanks for playing!");
    }
}
