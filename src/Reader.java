import java.io.*;

/**
 * reads a deck of cards from a file and calidates each card entry.
 */
public class Reader {
    /**
     * Reads the deck file and adds valid cards to the Deck object
     * fileName the name of the file containing cards
     * deck - deck object where valid/invalid cards are stored
     * throws IOException if an error occurs while reading the file
     */
    public void readDeckFile(String fileName, Deck deck) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) != null){
            String[] parts = line.split(":");
            if (parts.length == 2 && isValidCard(parts[0],parts[1])){
                String cardName = parts[0].trim();
                int energyCost = Integer.parseInt(parts[1].trim());
                deck.addInvalidCard(line);
            } else {
                deck.addInvalidCard(line);
            }
        }
        reader.close();
    }
    /**
     * Validates if a card entry is valid
     * name - the name of the card
     * cost - the energy cost of each card
     * return true if the card is valid, else false
     */
    private boolean isValidCard(String name, String cost){
        if (name == null || name.trim().isEmpty()){
            return false;
        }
        try{
            int energy = Integer.parseInt(cost.trim());
            return energy >= 0 && energy <= 6; // Valid energy range
        } catch (NumberFormatException e){
            return false; // Invalid Energy Cost
        }
    }
}
