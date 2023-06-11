package matej.jenko.sg.sckr.si;
import java.util.*;

public class SeznamOpravil {
    public static void main(String[] args) {
        Map<String, List<Opravilo>> seznamOpravilPoDnevih = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        String[] dnevi = {"ponedeljek", "torek", "sreda", "četrtek", "petek", "sobota", "nedelja"};

        System.out.print("Vnesite dan v tednu: ");
        String izbraniDan = scanner.nextLine();

        if (!Arrays.asList(dnevi).contains(izbraniDan.toLowerCase())) {
            System.out.println("Napačen vnos dneva.");
            return;
        }

        System.out.println("\n--- " + izbraniDan.toUpperCase() + " ---");

        List<Opravilo> seznamOpravil = new ArrayList<>();
        int skupniCasOpravil = 0;

        // Vnos ure prostega časa
        System.out.print("Vnesite minute prostega časa: ");
        int prostiCas = scanner.nextInt();

        // Vnos števila opravil
        System.out.print("Vnesite število opravil: ");
        int steviloOpravil = scanner.nextInt();

        // Vnos opravil in časa za vsako opravilo
        for (int i = 1; i <= steviloOpravil; i++) {
            System.out.print("Vnesite ime opravila " + i + ": ");
            String imeOpravila = scanner.next();

            System.out.print("Vnesite čas za opravilo " + i + " (v minutah): ");
            int casOpravila = scanner.nextInt();

            seznamOpravil.add(new Opravilo(imeOpravila, casOpravila));
            skupniCasOpravil += casOpravila;
        }
        // Izpis povprečnega časa za vsako opravilo
        System.out.println("\nPovprečni čas za vsako opravilo:");
        
            double povprecniCas = (double) skupniCasOpravil / steviloOpravil;
            System.out.println("Povprečni čas na opravilo je: " + povprecniCas + " minut");

        // Izračun preostanka prostega časa
        int preostanekProstegaCasa = prostiCas - skupniCasOpravil;

        System.out.println("Preostanek prostega časa: " + preostanekProstegaCasa + " minut");

        // Dodajanje novega opravila, če je na voljo prosti čas
        if (preostanekProstegaCasa > 0) {
            System.out.print("\nAli želite dodati novo opravilo? (da/ne): ");
            String izbira = scanner.next();

            if (izbira.equalsIgnoreCase("da")) {
                System.out.print("Vnesite ime novega opravila: ");
                String imeOpravila = scanner.next();

                System.out.print("Vnesite čas za novo opravilo (v minutah): ");
                int casOpravila = scanner.nextInt();

                if (casOpravila <= preostanekProstegaCasa) {
                    seznamOpravil.add(new Opravilo(imeOpravila, casOpravila));
                    preostanekProstegaCasa -= casOpravila;
                    System.out.println("Opravilo dodano!");
                } else {
                    System.out.println("Opravilo ni bilo dodano, ker presega preostanek prostega časa.");
                }
            }
        }
    }
}