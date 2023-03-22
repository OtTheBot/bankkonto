import java.util.*;
import java.io.*;
public class six implements Serializable{
    static Scanner scannerInt = new Scanner(System.in);
    static Scanner scannerString = new Scanner(System.in); 
    static int x = 0;
    static ArrayList<Person> person = new ArrayList<Person>();
    public static void main(String[] args){
        System.out.print('\u000c');
        String namn;
        String personnr;
        String kod;
        boolean fort1 = false;
        boolean välj = true;
        boolean skapa = false;
        boolean skapaP = false;
        boolean fort1P = false;
        boolean kontodel = false;
        
        hamtaAllt();
        
        int index = 0;
        while(välj){
            System.out.println("Välj alternativ:\n1. Lägg till person\n2. Logga in\n3. Avlsuta");
            int val1 = scannerInt.nextInt();
            switch(val1){
                case 1: skapaP=true; fort1P=false; break;
                case 2: skapaP = false; fort1P=true; break;
                case 3: välj = false; break;
            }
            while(skapaP){
                System.out.println("Ange namn:");
                namn = scannerString.nextLine();

                System.out.println("Ange personnummer:");
                personnr = scannerString.nextLine();

                System.out.println("Ange kod:");
                kod = scannerString.nextLine();

                person.add(new Person(namn, personnr, kod, new ArrayList<Konto>()));
                skapaP = false;
            }
            while(fort1P){
                boolean fort2 = true;
                System.out.println("Vilken person vill du välja?");
                String namnval = scannerString.nextLine();

                for(int i = 0; i<person.size(); i++){
                    if(person.get(i).namn.equals(namnval)){
                        System.out.println("Vad är koden?");
                        String kskKod = scannerString.nextLine();
                        if (kskKod.equals(person.get(i).kod)){
                            index = i;
                            kontodel = true;
                            fort1P = false;
                            break;
                        }
                        else{
                            System.out.println("Fel kod");
                            fort1P = true;
                        }
                        break;
                    }
                }
            }
            while(kontodel){
                System.out.println("Välj alternativ:\n1. Skapa konto\n2. Logga in\n3. Byt person\n4. Avsluta");
                int val2 = scannerInt.nextInt();
                switch(val2){
                    case 1: skapa = true; fort1 = false; break;
                    case 2: skapa = false; fort1 = true; break;
                    case 3: välj = true; kontodel = false; break;
                    case 4: välj = false; kontodel = false; break;
                }
                while(skapa){
                    System.out.println("Ange kontonamn:");
                    String nytt = scannerString.nextLine();
                    person.get(index).konto.add(new Konto(0,nytt));
                    skapa=false;
                }
                while(fort1){
                    boolean fort2 = true;
                    System.out.println("Vilket konto vill du välja?");
                    String kontonamn = scannerString.nextLine();

                    for(int j = 0; j<person.get(index).konto.size(); j++){
                        if(person.get(index).konto.get(j).kontonr.equals(kontonamn)){

                            while(fort2){
                                System.out.println("1. Saldobesked\n2. Uttag\n3. Insättning\n4. Avsluta");
                                int choice = scannerInt.nextInt();
                                switch(choice){
                                    case 1: person.get(index).konto.get(j).saldobesked();break;
                                    case 2: uttag(person.get(index).konto.get(j));break;
                                    case 3: inmatning(person.get(index).konto.get(j));break;
                                    case 4: fort2 = false; break;
                                }
                            }
                        }
                    }
                    System.out.println("Vill du byta konto?\n1. Ja\n2. Nej");
                    int avsluta = scannerInt.nextInt();
                    if(avsluta == 1){
                        fort1=false; 
                    }
                }
            }
        }
        sparaAllt();
    }

    public static void uttag(Konto konto){
        System.out.println("Hur mycket vill du ta ut?");
        int belopp = scannerInt.nextInt();
        konto.uttag(belopp);
    }

    public static void inmatning(Konto konto){
        System.out.println("Hur mycket vill du sätta in?");
        int belopp = scannerInt.nextInt();
        konto.inmatning(belopp);
    }

    static void sparaAllt(){
        try {
            FileOutputStream fos=new FileOutputStream("sparfil_1");
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(person);
            oos.close();
        }
        catch(Throwable t){
            System.out.println("Fel vid sparande");
        }
    }

    static void hamtaAllt(){  
        try {
            FileInputStream fis=new FileInputStream("sparfil_1"); 
            ObjectInputStream ois=new ObjectInputStream(fis);
            person = (ArrayList<Person>) ois.readObject();
            ois.close();
        }
        catch(Throwable t){
            System.out.println("Går ej att hämta info");
        }
    }

}