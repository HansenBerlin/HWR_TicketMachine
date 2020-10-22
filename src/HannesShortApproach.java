import java.text.DecimalFormat;

public class HannesShortApproach 
{
    // ich initialisiere die Varialben gleich mit, weil ich dann später weniger Fälle abfangen muss. 
    double price = 2;
    int multiplier = 1;
    int zone = 1;

    DecimalFormat round = new DecimalFormat("0.00");

    // Alles wird direkt im Konstruktor gemacht. Absolut schlechter Stil, also nicht nachmachen. Übergeben wird der Input
    // der direkt im Hauptprogramm abgefragt wird (auch schlechter Stil)

    // Challenge für die folgende Logik ist, dass ihr das mal selber nachvollziehen könnt. Denkt dran: | bedeutet oder.
    // Vielleicht hat ja noch wer ne Idee für eine kürzere Lösung
    
    public HannesShortApproach(String inputZone, String inputTicketType)
    {
        if(inputZone.matches("1|2") && inputTicketType.matches("1|2|3"))
        {
            if(inputZone.equals("2")) {price = 2.8; zone = 2;}
            if(inputTicketType.equals("2")) multiplier = 6;
            else if(inputTicketType.equals("3")) multiplier = 12;
            System.out.println("The price for zone " +zone + " is " + round.format(multiplier*price) + "€.");
        }
        else System.out.println("No valid user input!");
    }
}
