import java.io.*;

public class Konto implements Serializable{
    private int saldo;
     String kontonr;
    public Konto(int s, String kN){
        saldo = s;
        kontonr = kN;
    }
    public void saldobesked(){
        if(saldo > 0){
            System.out.println("Ditt saldo är " + saldo);
        }
        if(saldo < 0){
            System.out.println("Due pank mannen");
        }
    }
    public void uttag(int belopp){
        saldo -= belopp;
        System.out.println("Ditt saldo har uppdaterats till " + saldo);
        if(saldo > 0){
            System.out.println("Ditt saldo är " + saldo);
        }
        if(saldo < 0){
            System.out.println("du har egentligen inte råd med att ta ut pengar but here we are");
        }
    }
    public void inmatning(int belopp){
        saldo += belopp;
        if(saldo > 0){
            System.out.println("Ditt saldo är " + saldo);
        }
        if(saldo < 0){
            System.out.println("Due pank fortfarande pank bror");
        }
    }
}