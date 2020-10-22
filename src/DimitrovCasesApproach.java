import java.text.DecimalFormat;
import java.util.Scanner;

public class DimitrovCasesApproach
{
    Scanner input = new Scanner(System.in);
    DecimalFormat round = new DecimalFormat("0.00");

    private double basePriceInEur;
    private int zoneSelection;


    public DimitrovCasesApproach()
    {
    }

    // bis hierher ist ja alles in DimitrovIfElseApproach erklärt
    public double inputZone()
    {
        System.out.println("Please type 1 for zone 1 or 2 for zone 2");              
        String inputZone = input.nextLine();
        
        // Statt des if else statements in der anderen Klasse wird hier ein Switch verwendet
        // hinter dem switch keyword muss immer der Variablenname stehen der überprüft werden soll
        // da ja hier inputZone vorher ein Wert zugewiesen wurde (die Nutzer_inneneingabe), kann der
        // auch abgefragt werden. In den Cases darunter steht dann hinter case einfach nur das, was ich 
        // für den Fall 'erwarte'. Trifft das zu, gebe ich den Wert hinter return zurück. Hier setze ich direkt
        // den Wert der Variable, man könnte auch einfach return irgendeinWert zurückgeben, da ich aber die Variable später noch
        // brauche mache ich es so. Wichtig: Nach der Rückgabe wird der Switch beendet. Default heißt: wenn alle Fälle
        // nicht eingetreten sind, mache das. Im prinzp der else nach einem if/ifelse
        // Auch wichtig: Der Rückgabewert muss dem Datentyp entsprechen, den ich zurückgeben will. Wenn ich jetzt also 
        // sagen würde return "Zwei" (was ein String ist), würde die IDE meckern bzw. nicht kompilieren weil ein Rückgabewert
        // vom Typ double erwartet wird
        switch(inputZone)
        {
            case "1":
            zoneSelection = 1;
            return basePriceInEur = 2;

            case "2":
            zoneSelection = 2;
            return basePriceInEur = 2.8;

            default:
            return basePriceInEur = 0;
        }
    }


    public double inputTicketType()
    {
        System.out.println("Please type 1 for standard ticket" + "\n" +
            "Please type 2 for weekly pass" + "\n" +
            "Please type 3 for annual ticket"); 
                   
        String ticketType = input.nextLine();

        switch(ticketType)
        {
            case "1":
            return basePriceInEur;

            case "2":
            return basePriceInEur *= 6;

            case "3":
            return basePriceInEur *= 25;

            default:
            return 0;
        }
    }


    public void printTicket()
    {
        System.out.println("Your zone selection: " + zoneSelection);
        System.out.println("Your ticket price : " + round.format(basePriceInEur) + "€");
        System.out.println("Thanks for your purchase and have a good ride.");
    }
}


