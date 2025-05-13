import java.util.Scanner;

public class Ausgabe {
    private Scanner scanner;
    private Schulgraph schulgraph;

    public static void main(String[] args) {
        new Ausgabe();
    }

    public Ausgabe() {
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