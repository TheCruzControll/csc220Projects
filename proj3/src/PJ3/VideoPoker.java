package PJ3;
import java.util.*;

/*
 * Ref: http://en.wikipedia.org/wiki/Video_poker
 *      http://www.freeslots.com/poker.htm
 *
 *
 * Short Description and Poker rules:
 *
 * Video poker is also known as draw poker. 
 * The dealer uses a 52-card deck, which is played fresh after each playerHand. 
 * The player is dealt one five-card poker playerHand. 
 * After the first draw, which is automatic, you may hold any of the cards and draw 
 * again to replace the cards that you haven't chosen to hold. 
 * Your cards are compared to a table of winning combinations. 
 * The object is to get the best possible combination so that you earn the highest 
 * payout on the bet you placed. 
 *
 * Winning Combinations
 *  
 * 1. Jacks or Better: a pair pays out only if the cards in the pair are Jacks, Queens, Kings, or Aces. Lower pairs do not pay out.DONE
 * 2. Two Pair: two sets of pairs of the same card denomination. DONE
 * 3. Three of a Kind: three cards of the same denomination. DONE
 * 4. Straight: five consecutive denomination cards of different suit.  DONE
 * 5. Flush: five non-consecutive denomination cards of the same suit. DONE
 * 6. Full House: a set of three cards of the same denomination plus DONE
 * 	a set of two cards of the same denomination. 
 * 7. Four of a kind: four cards of the same denomination. DONE
 * 8. Straight Flush: five consecutive denomination cards of the same suit. DONE
 * 9. Royal Flush: five consecutive denomination cards of the same suit, DONE
 * 	starting from 10 and ending with an ace
 *
 */


/* This is the video poker game class.
 * It uses OneDeck and Card objects to implement video poker game.
 * Please do not modify any data fields or defined methods
 * You may add new data fields and methods
 * Note: You must implement defined methods
 */



public class VideoPoker {
    
    // Scanner for user input methods
    private Scanner scanner;
    
    // default constant values
    private static final int defaultBalance=100;
    private static final int numberCards=5;

    // default constant payout value and playerHand types
    private static final int[]    winningMultipliers={1,2,3,5,6,9,25,50,250};
    private static final String[] winningHands={ 
	  "Royal Pair" , "Two Pairs" , "Three of a Kind", "Straight", "Flush	", 
	  "Full House", "Four of a Kind", "Straight Flush", "Royal Flush" };

    // use one deck of cards
    private final OneDeck thisDeck;

    // holding current player 5-card hand, balance, bet    
    private List<Card> playerHand;
    private int playerBalance;
    private int playerBet;

    /** default constructor, set balance = defaultBalance */
    public VideoPoker()
    {
	this(defaultBalance);
    }

    /** constructor, set given balance */
    public VideoPoker(int balance)
    {
	this.playerBalance= balance;
        thisDeck = new OneDeck();
    }

    /** This display the payout table based on winningMultipliers and 
      * winningHands arrays */
    private void showPayoutTable()
    { 
	System.out.println("\n\n");
	System.out.println("Payout Table   	      Multiplier   ");
	System.out.println("=======================================");
	int size = winningMultipliers.length;
	for (int i=size-1; i >= 0; i--) {
		System.out.println(winningHands[i]+"\t|\t"+winningMultipliers[i]);
	}
	System.out.println("\n\n");
    }
    
    // check if user wants to see payout table
    boolean showPayoutTable = true;
    
    /** Check current playerHand using winningMultipliers and winningHands arrays
     *  Must print yourHandType (default is "Sorry, you lost") at the end of function.
     *  This can be checked by testCheckHands() and main() method.
     */
    private void checkHands()
    {
	// implement this method
        if(isRoyalFlush())
        {
    		System.out.println("Royal Flush!");
    		playerBalance += winningMultipliers[8] * playerBet;
    	}
    	else if(isStraightFlush())
        {
    		System.out.println("Straight Flush!");
    		playerBalance += winningMultipliers[7] * playerBet;	
    	}
        else if(isStraight())
        {
    		System.out.println("Straight!");
    		playerBalance += winningMultipliers[3] * playerBet;	
    	}
        else if(isFlush())
        {
    		System.out.println("Flush!");
    		playerBalance += winningMultipliers[4] * playerBet;	
    	}
        else if(isFullHouse())
        {
    		System.out.println("Full House!");
    		playerBalance += winningMultipliers[5] * playerBet;	
    	}
        else if(isFourOfAKind())
        {
    		System.out.println("Four of a kind!");
    		playerBalance += winningMultipliers[6] * playerBet;	
    	}
        else if(isThreeOfAKind())
        {
    		System.out.println("Three of a kind!");
    		playerBalance += winningMultipliers[2] * playerBet;	
    	}
        else if(isTwoPair())
        {
    		System.out.println("Two Pair!");
    		playerBalance += winningMultipliers[1] * playerBet;	
    	}
        else if(isRoyalPair())
        {
    		System.out.println("Royal Pair!");
    		playerBalance += winningMultipliers[0] * playerBet;	
    	}
    	else
    		System.out.println("Sorry, you lost!");
    }

    
    
    /*************************************************
     *   add additional private methods here ....
     *
     *************************************************/
    private boolean isRoyalFlush()//five consecutive denomination cards of the same suit, starting from 10 and ending with an ace
    {
        boolean royalFlush = true;
        int firstCardSuit = playerHand.get(0).getSuit();
    	List<Integer> royalFlushRankList = Arrays.asList(1,10,11,12,13);
        
        //if it doesnt meet any of the requirements then it is not a royal flush
        for(Card card : playerHand)
        {
            if((card.getSuit() != firstCardSuit || !royalFlushRankList.contains(card.getRank())))
    		royalFlush = false;
        }
        return royalFlush;
    }

    private boolean isStraightFlush()//five consecutive denomination cards of the same suit
    {
        boolean straightFlush = true;
        int firstCardSuit = playerHand.get(0).getSuit();
        List<Integer> sortedCardRanks = new ArrayList<>();
        
        for(Card card : playerHand)
        {
            sortedCardRanks.add(card.getRank());
        }
        
        //sort cards
        Collections.sort(sortedCardRanks);
        
        //if theyre not all the same suit then it is false
        for(Card card : playerHand){
    		if(card.getSuit() != firstCardSuit)
    			straightFlush = false;
    	}

        for(int i = 0; i < 4; i++){
    		if(!(sortedCardRanks.get(i) == (sortedCardRanks.get(i+1) - 1)))
    			straightFlush = false;
    	}

        return straightFlush;
    }
    
    private boolean isFourOfAKind() //four cards of the same number
    {
        boolean fourOfAKind = true;
        List<Integer> sortedCardRanks = new ArrayList<>();
        for(Card card : playerHand)
        {
            sortedCardRanks.add(card.getRank());
        }
        
        Collections.sort(sortedCardRanks);
        
        /*If the hand has a four of a kind then the common rank
          must be in the middle of the hand*/
        int commonValue = sortedCardRanks.get(2);
        
        /*
          Counts how many times the common rank shows up in the hand.
        */
        int counter = 0;
        
        for(int i = 0;i<4;i++)
        {
            if(sortedCardRanks.get(i) == commonValue)
            {
                counter++;
            }
        }
        
        /*If there isnt 4 instances of the common rank. 
          Then it is not a four of a kind*/
        if(counter!=4)
            fourOfAKind = false;
        return fourOfAKind;
    }
    
    private boolean isFullHouse()
    {
        boolean fullHouse = false;
        List<Integer> sortedCardRanks = new ArrayList<>();
        for(Card card : playerHand)
        {
            sortedCardRanks.add(card.getRank());
        }
        
        Collections.sort(sortedCardRanks);
        
        //Splits Hand Into 2 Common Values since a Full house only has 2 values
        /*The only index that should differ in a full house is the middle index
          so i chose index to the left and to the right because those values will
          not change. 
        */
        int commonValue = sortedCardRanks.get(1);
        int commonValue2 = sortedCardRanks.get(3);
        
        //Counters for both of the values
        int counter = 0;
        int counter2 = 0;
        
        for(int i = 0;i<5;i++)
        {
            if(sortedCardRanks.get(i) == commonValue)
            {
                counter++;
            }
            else if(sortedCardRanks.get(i) == commonValue2)
            {
                counter2++;
            }
        }
        
        if((counter == 3 && counter2==2) || (counter == 2 && counter2==3))
        {
            return true;
        }
        
        return fullHouse;
    }
    
    private boolean isFlush()//five non-consecutive denomination cards of the same suit
    {
        int firstCardSuit = playerHand.get(0).getSuit();

    	//Check to see that all card suits are identical
    	for(Card card : playerHand){
    		if(card.getSuit() != firstCardSuit)
    			return false;
    	}

    	return true;
    }
    
    private boolean isStraight()//five consecutive denomination cards of different suit.
    {
        boolean straight = false;
        int firstCardSuit = playerHand.get(0).getSuit();
        List<Integer> sortedCardRanks = new ArrayList<>();
        for(Card card : playerHand)
        {
            sortedCardRanks.add(card.getRank());
        }
        
        //sort cards so you can see if theyre consecutive
        Collections.sort(sortedCardRanks);
        
        //Test to see if there is a different suit
        for(Card card : playerHand){
    		if(card.getSuit() != firstCardSuit)
                {
    			straight = true;
                        break;
                }
    	}
        
        //Test to see if theyre all consecutive
        for(int i = 0; i < 4; i++){
    		if(!(sortedCardRanks.get(i) == (sortedCardRanks.get(i+1) - 1)))
    			return false;
    	}
        
        return straight;
    }
    
    private boolean isThreeOfAKind() //three cards of the same number
    {
        boolean threeOfAKind = true;
        List<Integer> sortedCardRanks = new ArrayList<>();
        for(Card card : playerHand)
        {
            sortedCardRanks.add(card.getRank());
        }
        
        Collections.sort(sortedCardRanks);
        
        /*If the hand has a three of a kind then the common rank
          must be in the middle of the hand*/
        int commonValue = sortedCardRanks.get(2);
        int counter = 0;
        
        for(int i = 0;i<4;i++)
        {
            if(sortedCardRanks.get(i) == commonValue)
            {
                counter++;
            }
        }
        
        /*If there isnt 4 instances of the common rank. 
          Then it is not a four of a kind*/
        if(!(counter==3))
            return false;
        return true;
    }
    
    private boolean isTwoPair()
    {
        boolean twoPair = false;
        List<Integer> sortedCardRanks = new ArrayList<>();
        
        for(Card card : playerHand)
        {
            sortedCardRanks.add(card.getRank());
        }
        
        Collections.sort(sortedCardRanks);
        int counter = 0;
        
        //Since it is sorted. There is a pair if there are 2 equal values next to eachother
        for(int i = 0;i<4;i++)
        {
            if(sortedCardRanks.get(i) == sortedCardRanks.get(i+1))
            {
                counter++;
            }
        }
        
        //It is a twoPair if and only if the counter is 2
        if(counter==2)
            twoPair = true;
        
        return twoPair;
    }
    
    private boolean isRoyalPair()
    {
        boolean royalPair = false;
        List<Integer> sortedCardRanks = new ArrayList<>();
        List<Integer> royalRankList = Arrays.asList(1,11,12,13);
        for(Card card : playerHand)
        {
            sortedCardRanks.add(card.getRank());
        }
        
        Collections.sort(sortedCardRanks);
        int counter = 0;
        
        for(int i = 0;i<4;i++)
        {
            //If card(i) is the same as card(i+1) and is a royal card or ace
            if(sortedCardRanks.get(i) == sortedCardRanks.get(i+1) && royalRankList.contains(sortedCardRanks.get(i)))
            {
                counter++;
            }
        }
        
        /*There can only be 2 pairs max in a hand. 
          This is if there is only 1 pair
        */
        if (counter != 0 && counter != 2)
        {
            royalPair = true;
        }
        
        return royalPair;
    }
    /*
    private boolean isPair()
    {
        boolean royalPair = false;
        List<Integer> sortedCardRanks = new ArrayList<>();
        for(Card card : playerHand)
        {
            sortedCardRanks.add(card.getRank());
        }
        
        Collections.sort(sortedCardRanks);
        int counter = 0;
        
        for(int i = 0;i<sortedCardRanks.size();i++)
        {
            //If card(i) is the same as card(i+1)
            if(sortedCardRanks.get(i) == sortedCardRanks.get(i+1))
            {
                counter++;
            }
        }
        
        if (counter != 0 && counter != 2)
        {
            royalPair = true;
        }
        
        return royalPair;
    }*/
    
    private void showBalance(){
    	System.out.println("Balance: $" + playerBalance);
    }
    
    private void getBet()
    {
        System.out.print("Enter bet: ");
        try
        {
            scanner = new Scanner(System.in);
            playerBet = scanner.nextInt();

            if(playerBet > playerBalance)
            {
                System.out.println("Bet is larger than balance, try again");
                //If its invalid loop it again
                getBet();
            }
    	}
    	catch(InputMismatchException e)
        {
            System.out.println("Invalid entry. Try again");
            //If its invalid loop it again
            getBet();
    	}
    }
    
    private void updateBalance()
    {
        playerBalance -= playerBet;
    }
    
    private void dealCards()
    {
        try
        {
            playerHand = thisDeck.deal(numberCards);
            System.out.println(playerHand.toString());
        }
        catch(PlayingCardException e)
        {
            System.out.println("PlayingCardException:" + e.getMessage());
        }
    }
    
    private void changeCards()
    {
        System.out.print("Enter positions of cards to keep (e.g. 1 4 5 ): ");
        scanner = new Scanner(System.in);
        String positionsInput = scanner.nextLine();
        
        //Split input by spaces and put them into an array
        String[] positions = positionsInput.split(" ");
        
        //If they didnt enter anything then just exit out
        if(positionsInput.isEmpty())
        {
    		return;
    	}
        
        try
        {
            for(int i=0;i<positions.length;i++)
            {
                //position 1 for the user is index 0 so we have to change the number
                int position = Integer.parseInt(positions[i]) - 1;
                
                //Change the card of the position given
                playerHand.set(position, thisDeck.deal(1).get(0));
            }
            System.out.println(playerHand.toString());
        }
        catch(Exception e)
        {
            System.out.println("Please input integers 1-5 only. Try again");
            //If invalid loop again
            changeCards();
    	}
        
        
    }
    
    private void exitGame()
    {
    	System.out.println("Bye!");
	System.exit(0);
    }
    private void userPlayoutTable()
    {
        System.out.println("\nWant to see payout table (y or n)");
    	String input = scanner.nextLine();
        
    	if(input.equals("n"))
        {
            showPayoutTable = false;
            System.out.println("-----------------------------------");
    	}
        else if(input.equals("y"))
            showPayoutTable = true;
        
        else if(input.isEmpty())
        {
            //If invalid loop again
            userPlayoutTable();
    	}
        else
        {
            System.out.println("Invalid entry. Try again");
            userPlayoutTable();
        }
    }
    
    private void newGame()
    {
        System.out.println("Play again? (y or n)");
        scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        if(input.equals("y"))
        {
            userPlayoutTable();
            play();
        }
        else if(input.equals("n"))
        {
            exitGame();
        }
        else if(input.isEmpty())
        {
            newGame();
        }
        else
        {
            System.out.println("Invalid entry. Try again");
            userPlayoutTable();
    	}
    }
    
    public void play() 
    {
    /** The main algorithm for single player poker game 
     *
     * Steps:
     * 		showPayoutTable()
     *
     * 		++	
     * 		show balance, get bet 
     *		verify bet value, update balance
     *		reset deck, shuffle deck, 
     *		deal cards and display cards
     *		ask for positions of cards to keep  
     *          get positions in one input line
     *		update cards
     *		check hands, display proper messages
     *		update balance if there is a payout
     *		if balance = O:
     *			end of program 
     *		else
     *			ask if the player wants to play a new game
     *			if the answer is "no" : end of program
     *			else : showPayoutTable() if user wants to see it
     *			goto ++
     */

	// implement this method
        if(showPayoutTable){
    		showPayoutTable();
    	}
        //Show Balance
        showBalance();
        
        //Get Bet
        getBet();
        
        //Verify bet value and update balance
        updateBalance();
        
        //Reset deck
        thisDeck.reset();
        
        //Shuffle Deck
        thisDeck.shuffle();
        
        //Deal and Display Cards
        dealCards();
        
        /*ask for positions of cards to keep  
         *get positions in one input line
         *update cards
         */
        changeCards();
        
        //Check Hands
        checkHands();
        
        //Show balance
        showBalance();
        if(playerBalance == 0){
    		exitGame();
    	}
    	else{
    		newGame();
                play();
    	}
    }


    /*************************************************
     *   do not modify methods below
     *   methods are used for testing your program.
     *
     *************************************************/

    /** testCheckHands is used to test checkHands() method 
     *  checkHands() should print your current hand type
     */ 
    public void testCheckHands()
    {
      	try {
    		playerHand = new ArrayList<Card>();

		// set Royal Flush
		playerHand.add(new Card(1,4));
		playerHand.add(new Card(10,4));
		playerHand.add(new Card(12,4));
		playerHand.add(new Card(11,4));
		playerHand.add(new Card(13,4));
		System.out.println(playerHand);
    		checkHands();
		System.out.println("-----------------------------------");

		// set Straight Flush
		playerHand.set(0,new Card(9,4));
		System.out.println(playerHand);
    		checkHands();
		System.out.println("-----------------------------------");

		// set Straight
		playerHand.set(4, new Card(8,2));
		System.out.println(playerHand);
    		checkHands();
		System.out.println("-----------------------------------");

		// set Flush 
		playerHand.set(4, new Card(5,4));
		System.out.println(playerHand);
    		checkHands();
		System.out.println("-----------------------------------");

		// "Royal Pair" , "Two Pairs" , "Three of a Kind", "Straight", "Flush	", 
	 	// "Full House", "Four of a Kind", "Straight Flush", "Royal Flush" };

		// set Four of a Kind
		playerHand.clear();
		playerHand.add(new Card(8,4));
		playerHand.add(new Card(8,1));
		playerHand.add(new Card(12,4));
		playerHand.add(new Card(8,2));
		playerHand.add(new Card(8,3));
		System.out.println(playerHand);
    		checkHands();
		System.out.println("-----------------------------------");

		// set Three of a Kind
		playerHand.set(4, new Card(11,4));
		System.out.println(playerHand);
    		checkHands();
		System.out.println("-----------------------------------");

		// set Full House
		playerHand.set(2, new Card(11,2));
		System.out.println(playerHand);
    		checkHands();
		System.out.println("-----------------------------------");

		// set Two Pairs
		playerHand.set(1, new Card(9,2));
		System.out.println(playerHand);
    		checkHands();
		System.out.println("-----------------------------------");

		// set Royal Pair
		playerHand.set(0, new Card(3,2));
		System.out.println(playerHand);
    		checkHands();
		System.out.println("-----------------------------------");

		// non Royal Pair
		playerHand.set(2, new Card(3,4));
		System.out.println(playerHand);
    		checkHands();
		System.out.println("-----------------------------------");
      	}
      	catch (Exception e)
      	{
		System.out.println(e.getMessage());
      	}
    }

    /** testOneDeck() is used to test OneDeck class  
     *  testOneDeck() should execute OneDeck's main()
     */ 
    public void testOneDeck()
    {
    	OneDeck tmp = new OneDeck();
        tmp.main(null);
    }

    /* Quick testCheckHands() */
    public static void main(String args[]) 
    {
	VideoPoker pokergame = new VideoPoker();
	pokergame.testCheckHands();
    }
}
