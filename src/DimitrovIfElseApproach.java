import java.util.Scanner;
import java.text.DecimalFormat;


public class DimitrovIfElseApproach
{
    // Hier werden zwei Objekte erstellt, die später in dieser Klasse noch verwendet werden.
    // Jede Sprache hat eine 'Grundausstattung' an Funktionen, auf die zugegriffen werden kann
    // Diese Funktionen sind in Bibliotheken gespeichert. Mit Frameworks kann man diese
    // Bibliothek erweitern und muss so nicht jedes Mal das Rad neu erfinden. Allerdings entsteht
    // dadurch eine Abhängigkeit von den Entwicklern des Frameworks.      
    Scanner input = new Scanner(System.in);
    DecimalFormat round = new DecimalFormat("0.00");

    // Hier werden 2 Variablen deklariert. Deklaration heißt: Ich sage dem Compiler oder Interpreter, dass
    // es ab jetzt diese Variable mit Namen x vom Datentyp y in einem bestimmten Kontext (hier der Klasse 
    // DimitrovIfElseApproach) gibt. In diesem Kontext kann nun keine andere Variable denselben Namen annehmen
    // Für die Schreibweise gibt es unterschiedliche Konventionen, sehr gängig ist camelCase. Also klein,
    // ohne Leerzeichen und mit einem Großbuchstaben für jedes folgende Wort. hochschuleFürWirtschaftUndRecht z.B.
    // Der Name kann frei gewählt werden, sollte aber für Variablen die öfter verwendet werden, 'sprechend' sein.
    // Variablen können auch initialisiert werden, also ihnen ein Wert zugewisen werden. Das sähe dann so aus:
    // private double basePriceInEur = 2;
    // Die Variable hat nun den Wert 2, kann den aber während der Laufzeit verändern.
    // Das private am Anfang ist der Zugriffsmodifizierer, kann erstmal ignoriert werden.
    // double bzw. int stehen für den Datentyp. int steht für Integer, also eine Ganzzahl (default 32 bit also 2 hoch 37)
    // ein double ist eine Dezimalzahl mit einem höheren Wertebereich, braucht also entsprechend mehr Speicher
    // Primitive Datentypen wie int, short, double etc. werden in Java klein geschrieben, alle anderen groß (auch String)
    private double basePriceInEur;
    private int zoneSelection;

    // Hier wird ein Konstruktor erstellt, ist nur für OOP (Objektorientierte Programmierung) relevant und kann hier 
    // erstmal ignoriert werden
    public DimitrovIfElseApproach()
    {
    }

    // Hier wird das erste 'Unterprogramm' erstellt, wie ihr es in Herrn Dimitrovs Pseudocode findet. Das geschieht in Form einer
    // Funktion oder Methode (je nach Sprache wird das anders bezeichnet, ist aber im Prinzip dasselbe). Auch eine Methode kann einen
    // Zugriffsmodifizierer haben (ignorieren), danach folgt der Rückgabetyp (hier double, d.H. die Fuktion muss einen Wert vom
    // Typ double zurückgeben, sichtbar am return Keyword) und der Name der Methode (Namenskonvention in Java: wie Variablen) in Form eines Verbs (weil Methode immer irgendwas 
    // 'machen', also verarbeiten))
    public double inputZone()
    {
        // Hier wird für den Nutzer_in ein Hinweis ausgegeben, was er als nächstes machen soll.
        // Den Befehl System.out.println solltet ihr euch merken, kommt sicher noch oft
        // Der Text in Klammern ist der Wert den ich an die Methode println übergebe. Wo kommt die Methode her?
        // Mit der oben erwähnten Standardaustattung von java, und zwar aus der PrintStream Klasse (out).
        // Nicht alle Methoden brauchen einen Übergabewert. Aber erstmal egal. Was hier wichtig ist: Der Wert ist
        // hier vom Datentyp String (also Text). Strings müssen immer in "" stehen, sonst wird nicht kompiliert.
        System.out.println("Please type 1 for zone 1 or 2 for zone 2");            

        // Hier wird der String inputZone deklariert (remember?) und auch initialisiert, also ihm ein Wert zugewiesen
        // Den Wert beziehe ich aus dem, was Nutzer_in nun eingibt (input.nectLine()).
        String inputZone = input.nextLine();

        // hier nun die erste einfache Abfrage, wenn die Eingabe 1 oder 2 war wird der basePrice entsprechend gesetzt
        // Diese Variable basePrice gibt es, weil ich sie ganz oben deklariert habe. Hätte ich sie innerhalb dieser Methode deklariert, 
        // könnte ich auch nur innerhalb dieser Methode darauf zugreifen und sie ändern. Wann immer nichts anderes notwendig ist sollte
        // man das auch tun. Hier brauche ich den Wert aber später in einer anderen Methode, deshab so. Wird irgendwas anderes als
        // 1 oder 2 eingegeben, gibt die Methode 0 zurück (nicht null, aber das ist auch nochmal was anderes :-) )     
        // Die Zone Selection wird gesetzt, damit sie später in der Ausgabe wie gefordert abgerufen werden kann, für die Programm-
        // logik wäre es nicht notwendig   
        if(inputZone.equals("1")) {zoneSelection = 1; return basePriceInEur = 2; }
        else if (inputZone.equals("2")) {zoneSelection = 2; return basePriceInEur = 2.8;}
        else return 0;
    }


    public double inputTicketType()
    {
        // Same as above., das "\n" ist einfach nur ein Zeilenumbruch, mit dem + in einem String kann man Dinge verketten        
        System.out.println("Please type 1 for standard ticket" + "\n" +
            "Please type 2 for weekly pass" + "\n" +
            "Please type 3 for annual ticket");  
   
        String ticketType = input.nextLine();

        // Eigentlich auch wie oben, nur das hier gleich gerechnet wird. Der basePrice ist schon gesetzt, weil ja im Hauptprogramm die Methode
        // inputZone, die diese Variable initialisiert, aufgerufen wird. Also kann ich damit jetzt weiterrechnen. Beispiel zweite Zeile mit basePrice 2
        // basePriceInEur(ist grade 2) = basePriceInEur(immer noch 2) * 6
        // also ist basePriceInEur jetzt 12
        if(ticketType.equals("1")) return basePriceInEur = basePriceInEur * 1;
        else if(ticketType.equals("2")) return basePriceInEur = basePriceInEur * 6;
        else if(ticketType.equals("3")) return basePriceInEur = basePriceInEur * 25;
        else return 0;    
    }

    // Diese Methode ost eine void Methode. Void heißt leer. Void Methoden haben keinen Rückgabewert, können aber natürlich trotzdem Variablen
    // manipulieren. Deshalb findet ihr hier auch kein return Keyword.
    public void printTicket()
    {
        // Hier wird nun einfach die Ausgabe gemacht. Das + irgendeinName ist in dem Fall der int oder double, der an den String drangehängt wird
        // Er wird also automatisch in einen string konvertiert. die round.format Methode rundet einfach auf 2 Stellen hinter dem Komma.
        System.out.println("Your zone selection: " + zoneSelection);
        System.out.println("Your ticket price : " + round.format(basePriceInEur));
        System.out.println("Thanks for your purchase and have a good ride.");
    }
}


