import java.util.*;
public class Deck {
    private List<String> validCards = new ArrayList<>();
    private List<String> invalidCards = new ArrayList<>();
    private Map<String, Integer> cardEnergy = new HashMap<>();


    /**
     * Adds a card with the energy cost to the deck.
     * @param cardName identifies the card.
     * @param energyCost the cost of the enrgy of the card
     */
    public void addCard(String cardName, int energyCost){
        validCards.add(cardName);
        cardEnergy.put(cardName, cardEnergy.getOrDefault(cardName,0)+ energyCost);
    }
    /**
     * Adds a card to the list of invalid cards
     * @param cardName the name of the invalid card
     */
    public void addInvalidCard(String cardName){
        invalidCards.add(cardName);
    }
    /**
     * Calculates total energy cost of all claid cards in the deck
     * returns the total energy cost
     */
    public int calculateTotalEnergyCost(){
        int totalCost = 0;
        for(int cost : cardEnergy.values()){
            totalCost += cost;
        }
        return totalCost;
    }
    /**
     * creates the histogram of energy costs for the cards in the deck
     * returns a map where the key is the energy cost and the value is the count of cards with that cost
     */
    public int[] generatedEnergyHist(){
        int[] histogram = new int[7];
        for(int cost : cardEnergy.values()){
            if(cost >= 0 && cost <= 6){
                histogram[cost]++;
            }
        }
      return histogram;
    }
    /**
     * list of valid card entries
     * param is the list valid cards
     */
    public List<String> getValidCards(){
        return validCards;
    }

    /**
     * list of invalid card entries
     * param is the list invalid cards
     */
    public List<String> getInvalidCards(){
        return invalidCards;
    }
    /**
     * determines if a valid report should be generated based on invalid cards or total
     * number of invalid cards.
     * returns true if void report is needed, else false
     */
    public boolean generateReport(){
        return invalidCards.size() >10 || validCards.size()>100;
    }
}
