import utils.*;


public class Schulgraph {
    Graph schulgraph = new Graph();
    List<Vertex> Ergebnisliste = new List<>();
    Queue<Vertex> warteschlange = new Queue<>();
    List<Vertex> neighbours = new List<>();

    public static void main(String[] args) {
        new Schulgraph();

    }

    public Schulgraph() {

        Vertex Inforaum = new Vertex("Inforaum");
        schulgraph.addVertex(Inforaum);
        Vertex PZ = new Vertex("PZ");
        schulgraph.addVertex(PZ);
        schulgraph.addEdge(new Edge(Inforaum, PZ, 96));
        Vertex WC = new Vertex("WC");
        schulgraph.addVertex(WC);
        schulgraph.addEdge(new Edge(WC, Inforaum, 80));
        Vertex Aula = new Vertex("Aula");
        schulgraph.addVertex(Aula);
        schulgraph.addEdge(new Edge(Aula, Inforaum, 95));
        schulgraph.addEdge(new Edge(Aula, WC, 15));
        Vertex Kunstraum = new Vertex("Kunstraum");
        schulgraph.addVertex(Kunstraum);
        schulgraph.addEdge(new Edge(Kunstraum, Inforaum, 64));
        schulgraph.addEdge(new Edge(Kunstraum, Aula, 71));
        Vertex Musikraum = new Vertex("Musikraum");
        schulgraph.addVertex(Musikraum);
        schulgraph.addEdge(new Edge(Musikraum, Inforaum, 50));
        schulgraph.addEdge(new Edge(Kunstraum, Musikraum, 9));
        Vertex Inforaum2 = new Vertex("Inforaum2");
        schulgraph.addVertex(Inforaum2);
        schulgraph.addEdge(new Edge(Inforaum2, Inforaum, 5));
        schulgraph.addEdge(new Edge(Inforaum2, Musikraum, 55));
        schulgraph.addEdge(new Edge(Inforaum2, Kunstraum, 50));
        Vertex Schulzoo = new Vertex("Schulzoo");
        schulgraph.addVertex(Schulzoo);
        schulgraph.addEdge(new Edge(Schulzoo, Inforaum, 5));
        Vertex Chemieraum = new Vertex("Chemieraum");
        schulgraph.addVertex(Chemieraum);
        schulgraph.addEdge(new Edge(Chemieraum, Schulzoo, 7));
        Vertex Treppenhaus = new Vertex("Treppenhaus");
        schulgraph.addVertex(Treppenhaus);
        schulgraph.addEdge(new Edge(Treppenhaus, Inforaum, 13));
        schulgraph.addEdge(new Edge(Treppenhaus, Chemieraum, 22));
        Vertex Bioraum = new Vertex("Bioraum");
        schulgraph.addVertex(Bioraum);
        schulgraph.addEdge(new Edge(Bioraum, Treppenhaus, 21));
        schulgraph.addEdge(new Edge(Bioraum, Schulzoo, 7));
        schulgraph.addEdge(new Edge(Bioraum, Chemieraum, 4));
        Vertex Fußballplatz = new Vertex("Fußballplatz");
        schulgraph.addVertex(Fußballplatz);
        schulgraph.addEdge(new Edge(Inforaum, Fußballplatz, 34));
        Vertex Sporthalle = new Vertex("Sporthalle");
        schulgraph.addVertex(Sporthalle);
        schulgraph.addEdge(new Edge(Sporthalle, Inforaum, 95));
        schulgraph.addEdge(new Edge(Fußballplatz, Sporthalle, 58));
        Vertex TorSF = new Vertex("Tor(SF)");
        schulgraph.addVertex(TorSF);
        schulgraph.addEdge(new Edge(TorSF, Sporthalle, 63));
        schulgraph.addEdge(new Edge(TorSF, Fußballplatz, 34));
        Vertex Tischtennisplatten = new Vertex("Tischtennisplatten");
        schulgraph.addVertex(Tischtennisplatten);
        schulgraph.addEdge(new Edge(TorSF, Tischtennisplatten, 8));
        schulgraph.addEdge(new Edge(Fußballplatz, Tischtennisplatten, 57));
        schulgraph.addEdge(new Edge(Sporthalle, Tischtennisplatten, 28));
        Vertex TorRK = new Vertex("Tor(RK)");
        schulgraph.addVertex(TorRK);
        schulgraph.addEdge(new Edge(PZ, TorRK, 98));
        Vertex Sekretariat = new Vertex("Sekretariat");
        schulgraph.addVertex(Sekretariat);
        schulgraph.addEdge(new Edge(Sekretariat, TorRK, 78));
        schulgraph.addEdge(new Edge(Sekretariat, PZ, 37));
        Vertex Radkeller = new Vertex("Radkeller");
        schulgraph.addVertex(Radkeller);
        schulgraph.addEdge(new Edge(Radkeller, PZ, 45));
        schulgraph.addEdge(new Edge(Radkeller, Sekretariat, 26));
        Vertex Lehrerzimmer = new Vertex("Lehrerzimmer");
        schulgraph.addVertex(Lehrerzimmer);
        schulgraph.addEdge(new Edge(Lehrerzimmer, TorRK, 79));
        schulgraph.addEdge(new Edge(Lehrerzimmer, Sekretariat, 18));
        schulgraph.addEdge(new Edge(Lehrerzimmer, Radkeller, 27));
        schulgraph.addEdge(new Edge(Lehrerzimmer, PZ, 37));
        Vertex Mensa = new Vertex("Mensa");
        schulgraph.addVertex(Mensa);
        schulgraph.addEdge(new Edge(Mensa, Lehrerzimmer, 96));
        schulgraph.addEdge(new Edge(Mensa, WC, 22));
        Vertex Cafeteria = new Vertex("Cafeteria");
        schulgraph.addVertex(Cafeteria);
        schulgraph.addEdge(new Edge(Cafeteria, Mensa, 7));
        schulgraph.addEdge(new Edge(Cafeteria, WC, 22));
        schulgraph.addEdge(new Edge(Cafeteria, Aula, 7));
        schulgraph.addEdge(new Edge(Cafeteria, Kunstraum, 90));
    }

    public List Breitensuche() {
        schulgraph.setAllVertexMarks(false);
        Queue <Vertex> zuBesuchende = new Queue();
        List <Vertex> Nachbarn = new List();
        List <Vertex> Besuchte = new List();

        zuBesuchende.enqueue(schulgraph.getVertex("Inforaum"));
        zuBesuchende.front().setMark(true);
        while (!zuBesuchende.isEmpty()) {
            Nachbarn = schulgraph.getNeighbours(zuBesuchende.front());
            Nachbarn.toFirst();
            Besuchte.append(zuBesuchende.front());
            Besuchte.toLast();
            System.out.println(Besuchte.getContent().getID());
            while(Nachbarn.hasAccess()){
                if(Nachbarn.getContent().isMarked()) {
                }
                else {
                    zuBesuchende.enqueue(Nachbarn.getContent());
                    Nachbarn.getContent().setMark(true);
                }
                Nachbarn.next();
            }
            zuBesuchende.dequeue();
        }
        return Besuchte;
    }

    public List Tiefensuche(Vertex pStart) {
        return null;
    }
}