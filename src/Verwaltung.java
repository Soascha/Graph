import java.util.Scanner;
import utils.*;

public class Verwaltung {
    private Scanner scanner;
    private Schulgraph schulgraph;

    public static void main(String[] args) {
        new Verwaltung();
    }

    public Verwaltung() {
        scanner = new Scanner(System.in);
        schulgraph = new Schulgraph();

        while (true) {
            System.out.println("== HAUPTMENÜ ==");
            System.out.println("[1] Breitensuche");
            int option = scanner.nextInt();
            scanner.nextLine();

            if (option == 1) {
                schulgraph.Breitensuche();
            } else if (option == 2) {

            }
        }
    }
}