import java.util.*;
public class skapaKonto{
    static Scanner scanner = new Scanner(System.in);
    static Scanner scanner2 = new Scanner(System.in); 
    static int x = 0;
    public static void main(String[] args){
        System.out.print('\u000c');

        boolean fort1 = true;
        boolean välj = true;
        boolean skapa = true;
        ArrayList<Konto> konto = new ArrayList<Konto>();
        while(välj){
            System.out.println("Välj alternativ:\n1. Skapa konto\n2. Logga in\n3. Avlsuta");
            int val = scanner.nextInt();
            switch(val){
                case 1: skapa=true; fort1=false; break;
                case 2: skapa = false; fort1=true; break;
                case 3: välj = false; break;
            }
            while(skapa){
                System.out.println("Ange kontonamn:");
                String nytt = scanner2.nextLine();
                konto.add(new Konto(0,nytt));
                skapa=false;
            }
            while(fort1){
                boolean fort2 = true;
                System.out.println("Vilket konto vill du välja?");
                String namn = scanner2.nextLine();

                for(int i = 0; i<konto.size(); i++){
                    if(konto.get(i).kontonr.equals(namn)){

                        while(fort2){
                            System.out.println("1. Saldobesked\n2. Uttag\n3. Insättning\n4. Avsluta");
                            int choice = scanner.nextInt();
                            switch(choice){
                                case 1: konto.get(i).saldobesked();break;
                                case 2: uttag(konto.get(i));break;
                                case 3: inmatning(konto.get(i));break;
                                case 4: fort2 = false; break;
                            }
                        }
                    }
                }
                System.out.println("Vill du logga ut?\n1. Ja\n2. Nej");
                int avsluta = scanner.nextInt();
                if(avsluta == 1){
                    fort1=false; 
                }
            }
        }
    }

    public static void uttag(Konto konto){
        System.out.println("Hur mycket vill du ta ut?");
        int belopp = scanner.nextInt();
        konto.uttag(belopp);
    }

    public static void inmatning(Konto konto){
        System.out.println("Hur mycket vill du sätta in?");
        int belopp = scanner.nextInt();
        konto.inmatning(belopp);
    }
}