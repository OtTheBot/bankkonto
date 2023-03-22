import java.util.*;
import java.io.*;
public class Person implements Serializable{
    private int saldo;
    String namn;
    String personnr;
    String kod;
    ArrayList<Konto> konto;
    public Person(String n, String pN, String pK, ArrayList<Konto> Konto){
        namn = n;
        personnr = pN;
        kod = pK;
        konto = Konto;
    }
}