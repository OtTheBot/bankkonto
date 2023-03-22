import java.util.*;
public class kontoMain{
    static Scanner scanner = new Scanner(System.in);
    static int x = 0;
    public static void main(String[] args){
        System.out.print('\u000c');

        boolean fort1 = true;
        Konto[] konto = new Konto[10];

        for(int i = 0 ; i < 10 ; i++){
            konto[i] = new Konto(1000, Integer.toString(i));
        }
        
        while(fort1){
            boolean fort2 = true;
            System.out.println("Vilket konto vill du välja? (1-10)");
            x = (scanner.nextInt() - 1);

            while(fort2){
                System.out.println("1. Saldobesked\n2. Uttag\n3. Insättning\n4. Avsluta");
                int choice = scanner.nextInt();
                switch(choice){
                    case 1: konto[x].saldobesked();break;
                    case 2: uttag(konto[x]);break;
                    case 3: inmatning(konto[x]);break;
                    case 4: fort2 = false; break;
                }
            }
            System.out.println("Vill du stänga ner tjänsten?\n1. Ja\2. Nej");
            int avsluta = scanner.nextInt();
            if(avsluta == 1){
                fort1 = false;
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