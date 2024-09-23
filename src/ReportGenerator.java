import java.io.*;
import java.util.List;
import java.util.Random;

/**
 * Generates a report containing deck information and histogram, saved as a text file.
 */
public class ReportGenerator {

    /**
     * Generates a text report with deck information and histogram.
     * @param fileName name of the file
     * @param totalCost The total energy cost of the cards in the deck.
     * @param histogram An array of energy costs and their occurrences.
     * @param isVoid True if the report should be marked as VOID.
     * @param invalidCards List of any invalid vards found
     * @throws IOException If an error occurs while writing to the file.
     */
    public void generateTextReport(String fileName, int totalCost, int[] histogram, List<String> invalidCards, boolean isVoid) throws IOException {
        String reportFileName;

        if (isVoid) {
            reportFileName = fileName + "(VOID).txt";
        } else {
            reportFileName = fileName + ".txt";
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(reportFileName))){
            //if report is VOID write "VOID" and end execution
            if(isVoid){
                writer.write("VOID\n");
                return;
            }
            //Deck ID and total cost
            writer.write("Deck ID: "+ fileName + "\n");
            writer.write("Total Energy Cost: " + totalCost + "energy\n");

            //histogram data
            writer.write("Energy Cost Dist. (Histogram):\n");
            for(int i =0; i < histogram.length; i++){
                writer.write(i + "energy:" + histogram[i] + "\n");
            }
            // listing invalid cards
            if(!invalidCards.isEmpty()){
                writer.write("\n Invalid Cards:\n");
                for(String card : invalidCards){
                    writer.write(card + "\n");
                }
            }
        }
    }

    /**
     * Generates a unique 9-digit ID for the deck.
     * @return The unique 9-digit deck ID.
     */
    public String generateDeckID() {
        Random random = new Random();
        int id = 100000000 + random.nextInt(900000000); // 9-digit random number
        return String.valueOf(id);
    }
}

