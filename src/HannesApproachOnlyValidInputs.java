import java.util.Scanner;
import java.text.DecimalFormat;


public class HannesApproachOnlyValidInputs
{
    Scanner input = new Scanner(System.in);
    DecimalFormat round = new DecimalFormat("0.00");

    private int ticketSelection;
    private int zoneSelection;

    // Hier initialisiere ich 4 Parameter, die ja evtl bei Preisänderung etc. variabel sein sollten. Vom Hauptprogramm aus
    // oder noch besser (in einer echten Applikation) von einer Konfigurationsoberfläche aus (Adminbackend) können diese
    // Werte angepasst werden
    private double priceZoneOne;
    private double priceZoneTwo;
    private double multiplierWeek;
    private double multiplierYear;

    // Hier wieder der Konstruktor. Diesen rufe ich im Hauptprogramm auf, um auf die public member der Klasse zugreifen
    // zu können. Jetzt aber mit dem Unterschied, dass ich wie das auch in einer Methode möglich ist Parameter (oder
    // Argumente) übergebe. Wenn irgendwo eine Methode oder ein Konstruktor aufgerufen wird, der Parameter annimmt,
    // müssen diese übergeben werden (Überladungen mal außen vor gelassen). Ich muss also hier wenn ich den Konstruktor aufrufe
    // Werte die dem Datentyp double entsprechen angeben (s. Hauptprogramm). Zudem 'injecte' ich diese Werte beim Aufruf in die
    // Variablen dieser Klasse. Dadurch kann von außen nicht manipuliert werden und durch die Injection (würde man eigentlich mit
    // Interfaces machen) erhalte ich eine modulare Struktur
    public HannesApproachOnlyValidInputs(double priceZoneOne, double priceZoneTwo, double multiplierWeek, double multiplierYear)
    {
        this.priceZoneOne = priceZoneOne;
        this.priceZoneTwo = priceZoneTwo;
        this.multiplierWeek = multiplierWeek;
        this.multiplierYear = multiplierYear;
    }


    public void askForInput()
    {
        // Beide Strings müssen initialisiert werden, weil im nächsten Block der Wert abgefragt wird. Hier kommen wir jetzt zum null
        // Hat eine Variable keinen Wert (wurde also nie initialisiert), greift aber dann irgendwas auf den Wert zu (in einer Condition)
        // gibt es je nach Laufzeitumgebung kleinere oder größere Umgebung. Schonmal irgendwo die null Exception als Fehlermeldung gehabt?
        // Tada. Da kommt die her.
        String inputZone = "";
        String ticketType = "";

        System.out.println("Please type 1 for zone 1 or 2 for zone 2");

        // Der Loop läuft so lange, wie der Wert inputZone nicht 1 und nicht 2 ist. Also: Ist die Bedingung wahr (true)
        // läuft der Loop. Ich sage: wahr ist wenn inputZone NICHT (das ist das Ausrufezeichen davor) 1 ist UND (das ist das &&) inputZone
        // NICHT 2 ist. Umgekehrt heißt das, sobald inputZone 1 ODER 2 ist, ist die Bedingung nicht mehr erfüllt, also false. Dann
        // springt er aus dem Loop raus und geht in den nächsten Block
        while(!inputZone.equals("1") && !inputZone.equals("2"))
        {            
            inputZone = input.nextLine();
            
            // Hier wird mit regex (regular expression) nochmal abgefragt ob nach der Eingabe der Wert 1 oder 2 ist (oder ist |)
            // Wenn das zutrifft ist alles gut. break heißt, er geht sofort aus dem Loop und macht weiter im Code
            // Wenn die Bedingung nicht erfüllt ist, kommt der Hinweis in der Ausgabe und der Loop beginnt von vorne. 
            // Vorteil: Es kann nie ein falscher Wert gesetzt werden und das Programm wird nie beendet solange eine falsche
            // Eingabe erfolgt.
            if(inputZone.matches("1|2")) break;
            else System.out.println("Invalid input. Please type in valid number of 1 or 2");
        }

        System.out.println("Please type 1 for standard ticket" + "\n" +
            "Please type 2 for weekly pass" + "\n" +
            "Please type 3 for annual ticket");  

        while(!ticketType.equals("1") && !ticketType.equals("2") && !ticketType.equals("3"))
        {            
            ticketType = input.nextLine();
            if(ticketType.matches("1|2|3")) break;
            else System.out.println("Invalid input. Please type in valid number of 1, 2 or 3");
        }
        
        // Wenn wir es bis hier geschafft haben, sind ticketType und inputZone beide valide Werte. Da dies aber strings sind
        // mit denen nicht gerechnet werden kann, müssen sie in Integer umgewandelt (geparsed) werden. Das ist tendenziell gefährlich und
        // sollte wenns geht vermieden werden. Da hier aber vorher sauber suageschlossen wird, dass die Variablen jemals einen 
        // anderen Wert annehmen können als einen zur Umwandlung gültigen Wert, kann man das machen. 
        ticketSelection = Integer.parseInt(ticketType);
        zoneSelection = Integer.parseInt(inputZone);
    }


    // Hier wird mit einem einfachen Switch der Preis gesetzt. Die Werte sind nicht hardgecoded, um später das Programm anpassen zu können
    // Es wäre z.B. einfach im Hauptprogramm einfach den Multiplier als übergebenem Wert im Konstruktor zu ändern und alles würde weiterhin
    // problemlos und korrekt laufen. 
    public double calculatePrice()
    {
        switch(ticketSelection)
        {
            case 1:
            if(zoneSelection == 1) return priceZoneOne;
            else return priceZoneTwo;

            case 2:
            if(zoneSelection == 1) return priceZoneOne * multiplierWeek;
            else return priceZoneTwo * multiplierWeek ;
            
            case 3:
            if(zoneSelection == 1) return priceZoneOne * multiplierYear;
            else return priceZoneTwo * multiplierYear;

            default: return 0;
        }
    }


    public void printTicket()
    {
        System.out.println("Your zone selection: " + zoneSelection);

        // Statt hier den Preis zu übergeben wird einfach die calculatePrice Methode aufgerufen, die ja den Preis zurückgibt.
        System.out.println("Your ticket price : " + round.format(calculatePrice()) + "€");
        System.out.println("Thanks for your purchase and have a good ride.");
    }
}


