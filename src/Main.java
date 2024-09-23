import java.io.IOException;
//import java.util.ArrayList;
import java.util.List;

/**
 * Main class to coordinate reading the deck, checking conditions, and generating the report.
 */
public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Reader reader = new Reader();
        ReportGenerator reportGen = new ReportGenerator();

        try {
            // Read the deck from file
            reader.readDeckFile("src/deck.txt", deck);
            String deckID = reportGen.generateDeckID();

            // Check if void report is needed
            if (deck.generateReport()) {
                reportGen.generateTextReport(deckID, 0, new int[0], deck.getInvalidCards(),true); // Generate VOID report
            } else {
                // Generate regular report
                int totalCost = deck.calculateTotalEnergyCost();
                int[] histogram = deck.generatedEnergyHist();
                List<String> invalidCards = deck.getInvalidCards();

                reportGen.generateTextReport(deckID,totalCost,histogram,invalidCards,false);
            }

            System.out.println("Report generated successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

