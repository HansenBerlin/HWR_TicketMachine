import java.io.Console;

public class App 
{
    public static void main(String[] args) throws Exception 
    {
        // Öffnet mal die Datei DimitrovIfElseApproach zuerst und lest da die Kommentare. Danach dann hier weiter :-)

        // könnt ihr ignorieren
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_RESET = "\u001B[0m";

        // das auch
        System.out.println(ANSI_YELLOW + "First Solution: If Else Statements" + ANSI_RESET);
        
        // da ich hier 4 Lösungen ausprobiere, sind diese jeweils in einer eigenen Klasse erstellt
        // Klassen sind Dateien mit einer klar definierten Funktion. Sie haben Eigenschaften und
        // Funktionen. Ein Objekt der Klasse Dimitrov...usw. wird hier erstellt, um danach die Methoden
        // die diese Klasse enthält verwenden zu können. Im prinzip könnt ihr das aber erstmal ignorieren, 
        // da das schon in den Bereich OOP geht.
        DimitrovIfElseApproach firstSolution = new DimitrovIfElseApproach();

        // Hier wird jetzt nach dem Pseudocodeschame von Herrn Dimitrov zuerst das eine 'Unterprgramm' (inputZone)
        // aufgerufen, dann das nächste usw. Zugleich wird in der ersten If Condition der Rückgabewert der Methode 
        // abgefragt (remember?). Also: Wenn der Rückgabewert gleich null ist (Logische Operatoren wie und, oder, gleich werden 
        // in Java mit Doppelzeichen geschrieben), gab es offensichtlich keine gültige Zoneneingabe mit der wir weiterarbeiten 
        // können. Also gehe dann in den ersten Block und gebe die Fehlermeldung aus. Der Rest wird dann übersprungen und
        // das Programm wäre beendet (hier nicht, weil die anderen Lösungen noch durchlaufen).
        if(firstSolution.inputZone() == 0)
        {
            System.out.println("Debug Info: No valid user input in InputZone function. Exit Application");
        }
        else
        {
            // Wenn wir es bis hierher geschafft haben, also wenn der Rückgabewert von inputZone nicht 0 war, wird als nächstes
            // der Rückgabewert von InputTicketType angefragt. Gleicher Spaß: Bei 0 gehe in den Block, ansonsten gehe in den else
            // Block 
            if(firstSolution.inputTicketType() == 0)
            {
                System.out.println("Debug Info: No valid user input in InputTicketType function");
            }
            else
            {
                // Geschafft: Hier wird das dritte 'Unterprogramm' aufgerufen und der Preis ausgegeben
                firstSolution.printTicket();
            }
        }    



        // Vom Ablauf her passiert hier das gleiche, guckt aber in die Klasse (Datei) DimitrovCasesApproach rein
        // Da kommentiere ich den Unterschied
        System.out.println(ANSI_YELLOW + "Second Solution: Switch/Case" + ANSI_RESET);
        
        DimitrovCasesApproach secondSolution = new DimitrovCasesApproach();
        
        if(secondSolution.inputZone() == 0)
        {
            System.out.println("Debug Info: No valid user input in InputZone function. Exit Application");
        }
        else
        {
            if(secondSolution.inputTicketType() == 0)
            {
                System.out.println("Debug Info: No valid user input in InputTicketType function");
            }
            else
            {
                secondSolution.printTicket();
            }
        }


        // Dieser Versuch ist für etwas Fortgeschrittene und deckt mehr ab als in der Anforderung stand. Vielleicht habt ihr trotzdem Lust es nachzuvollziehen.
        // Dann weiter in Datei/Klasse HannesApproachOnlyValidInput
        System.out.println(ANSI_YELLOW + "Third Solution (Addon): Switch with If Else, No termination on invalid inputs, Clean injection of Parameters" + ANSI_RESET);
        
        // Wenn ihr die Kommentare in der Klasse gelesen habt versteht ihr vielleicht was die Werte in den Klammern sind. Die Grundpreise und die Multiplikatoren.
        // Vorteil: Die kann ich jetzt ändern (z.B. wenn sich der Grundpreis auf 2.9 ändert) und alles funktioniert weiterhin
        HannesApproachOnlyValidInputs thirdSolution = new HannesApproachOnlyValidInputs(2, 2.8, 6, 25);

        // Hier werden jetzt einfach noch die beiden Methoden aufgerufen, eine Abfrage mit if else ist unnötig, weil alle Fälle in der Klasse abgedeckt werden
        thirdSolution.askForInput();
        thirdSolution.printTicket();


        // Letzter Versuch: Ignorieren aller Best Practices und versuchen, das Ergebnis mit möglich wenig Code abzudecken und trotdem alle Anforderungen zu erfüllen
        // Kommentare in HannesShortApproach
        System.out.println(ANSI_YELLOW + "Fourth Solution: Very small sourcecode, ignoring any best practices in program architecture" + ANSI_RESET);

        Console con = System.console();
        HannesShortApproach fourthSolution = new HannesShortApproach(con.readLine("Zone: "), con.readLine("Ticket Type: "));
    }
}
