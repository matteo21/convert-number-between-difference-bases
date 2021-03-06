/*

    Autore: Rota Matteo
    Data: 20/10/2017


    Oggetto: Tutte le conversioni possibili dalle/alle basi: decimale, ottale, binaria ed esadecimale.


 */

package conversioni;
import java.util.Scanner;



public class Conversioni {
    
    
    public static void main(String[] args) {
        
        menu();
    }
    
    
    public static void menu(){
        
        //variabili
        int ripeti = 0;             //reciclare il programma
        String inizio, fine;        //base di partenza, base di arrivo
        boolean contr1, contr2;     //validazione scelta base partenza/arrivo
        
        
        //scanner
        Scanner input = new Scanner(System.in);
        
              
        do{
            
            System.out.println("\tESERCIZIO CONVERSIONI\nConversioni tra le basi decimale, binaria, ottale ed esadecimale a scelta\n\n");
            System.out.println("lEGENDA:\n\tDEC: decimale\n\tBIN: binario\n\tOTT: ottale\n\tESA: esadecimale\n");
            

            //scelta iniziale
            System.out.print("Formato INIZIALE: ");
            inizio = input.next();
            inizio = inizio.toUpperCase();
            
            contr1 = controllo(inizio);
            
            
            if(contr1)
            {
                //scelta finale
                System.out.print("Formato FINALE: ");
                fine = input.next();
                fine = fine.toUpperCase();

                contr2 = controllo(fine);
                
                if(contr2 && inizio.equals(fine) == false)
                   converti(inizio, fine);
                    
                else if(inizio.equals(fine) == true)
                    System.out.println("NON E' POSSIBILE AVERE BASE DI PARTENZA E ARRIVO UGUALE!\n");
                else
                    System.out.println("INPUT NON VALIDO! CONSULTARE LA LEGENDA...\n");
                
            }
            else
                System.out.println("INPUT NON VALIDO! CONSULTARE LA LEGENDA...\n");
            
            
            //richiesta di rieseguire programma
            try{
                
                System.out.print("\nRipetere programma [1]? Risposta: ");
                ripeti = input.nextInt();
            }
            catch(Exception e)
            {
                System.exit(0);
            }
            
            if(ripeti == 1)
                System.out.println("\n\n\n\n\n");
            
            
        }while(ripeti==1);
        
        
        
    }
    
    
    //se l'input non è nessuno dei seguenti, errore
    public static boolean controllo(String input){
        
        //controllo
        switch(input)
        {
            case "DEC":
                return true;
                

            case "BIN":
                return true;
                

            case "OTT":
                return true;
                

            case "ESA":
                return true;
                

        }
        
        return false;
    }
    
    
    //il metodo è dotato di uno switch principale dove al suo interno sono 
    //contenuti altri switch per scegliere rispettivamente da che base a quale convertire.
    public static void converti(String inizio, String fine)
    {
        String conversione = new String();
        
        switch(inizio)
        {
            
            case "DEC":
                
                switch(fine)
                {

                    case "BIN":
                        decBin();
                        
                        break;

                    case "OTT":
                        decOtt();
                        break;

                    case "ESA":
                        decEsa();
                        break;
                        
                }
                
                break;
                

            case "BIN":
                
                switch(fine)
                {
                    case "DEC":
                        binDec();
                        break;

                    case "OTT":
                        binOtt();
                        break;

                    case "ESA":
                        binEsa();
                        break;
                        
                }
                
                break;
                

            case "OTT":
                
                switch(fine)
                {
                    case "BIN":
                        ottBin();
                        break;

                    case "DEC":
                        ottDec();
                        break;

                    case "ESA":
                        ottEsa();
                        break;
                        
                }
                
                break;
                

            case "ESA":
                
                switch(fine)
                {
                    case "BIN":
                        esaBin();
                        break;

                    case "OTT":
                        esaOtt();
                        break;

                    case "DEC":
                        esaDec();
                        break;
                       
                }
                
                break;
            
            
        }    
            
        
    }
    
    
    //sviluppo metodi conversione - utilizzo le funzioni avanzate dei metodi parseInt e toString
    public static void decBin(){
        
        int num;
        String conversione;
        
        
        System.out.println("\n\nDECIMALE -> BINARIO\n");
        
        try{
            
            num = Integer.parseInt(getNumero());
            conversione = Integer.toBinaryString(num);

            System.out.println("\n\nConversione:\n\t" + num + "(DEC)  =>  " + conversione + "(BIN)\n");
        }
        catch(NumberFormatException e)
        {
            System.err.println("NUMERO INSERITO da convertire non valido!\n");
        }
        
    }
    
    public static void decOtt(){
        
        int num;
        String conversione;
        
        System.out.println("\n\nDECIMALE -> OTTALE\n");
        
        try{
                
            num = Integer.parseInt(getNumero());
            conversione = Integer.toOctalString(num);

            System.out.println("\n\nConversione:\n\t" + num + "(DEC)  =>  " + conversione + "(OTT)\n");

        }
        catch(NumberFormatException e)
        {
            System.err.println("NUMERO INSERITO da convertire non valido!\n");
        }
        
        
    }
    
    public static void decEsa(){
        
        int num;
        String conversione;
        
        System.out.println("\n\nDECIMALE -> ESADECIMALE\n");
        
        try{
            
            num = Integer.parseInt(getNumero());
            conversione = Integer.toHexString(num);

            System.out.println("\n\nConversione:\n\t" + num + "(DEC)  =>  " + conversione.toUpperCase() + "(ESA)\n");

        }
        catch(NumberFormatException e)
        {
            System.err.println("NUMERO INSERITO da convertire non valido!\n");
        }
        
        
    }
    
    
    public static void binDec(){
        
        String num;
        String conversione;
        
        System.out.println("\nBINARIO -> DECIMALE\n");
        
        try{
            
            num = getNumero();
            conversione = Integer.toString(Integer.parseInt(num,2));


            System.out.println("\n\nConversione:\n\t" + num + "(BIN)  =>  " + conversione + "(DEC)\n");

        }
        catch(NumberFormatException e)
        {
            System.err.println("NUMERO INSERITO da convertire non valido!\n");
        }
        
        
    }
    
    public static void binOtt(){
        
        String num;
        String conversione;
        
        System.out.println("\nBINARIO -> OTTALE\n");
        
        try{
            
            num = getNumero();
            conversione = Integer.toString(Integer.parseInt(num,2),8);


            System.out.println("\n\nConversione:\n\t" + num + "(BIN)  =>  " + conversione + "(OTT)\n");

        }
        catch(NumberFormatException e)
        {
            System.err.println("NUMERO INSERITO da convertire non valido!\n");
        }
        
    }
    
    public static void binEsa(){
        
        String num;
        String conversione;
        
        System.out.println("\nBINARIO -> ESADECIMALE\n");
        
        try{
            
            num = getNumero();
            conversione = Integer.toString(Integer.parseInt(num,2),16);


            System.out.println("\n\nConversione:\n\t" + num + "(BIN)  =>  " + conversione.toUpperCase() + "(ESA)\n");

        }
        catch(NumberFormatException e)
        {
            System.err.println("NUMERO INSERITO da convertire non valido!\n");
        }
        
        
    }
    
    
    public static void ottDec(){
        
        String num;
        String conversione;
        
        System.out.println("\nOTTALE -> DECIMALE\n");
        
        try{
            
            num = getNumero();
            conversione = Integer.toString(Integer.parseInt(num,8));


            System.out.println("\n\nConversione:\n\t" + num + "(OTT)  =>  " + conversione + "(DEC)\n");

        }
        catch(NumberFormatException e)
        {
            System.err.println("NUMERO INSERITO da convertire non valido!\n");
        }
        
        
    }
    
    public static void ottBin(){
        
        String num;
        String conversione;
        
        System.out.println("\nOTTALE -> BINARIO\n");
        
        try{
            
            num = getNumero();
            conversione = Integer.toString(Integer.parseInt(num,8), 2);


            System.out.println("\n\nConversione:\n\t" + num + "(OTT)  =>  " + conversione + "(BIN)\n");

        }
        catch(NumberFormatException e)
        {
            System.err.println("NUMERO INSERITO da convertire non valido!\n");
        }
        
    }
    
    public static void ottEsa(){
        
        String num;
        String conversione;
        
        System.out.println("\nOTTALE -> ESADECIMALE\n");
        
        try{
            
            num = getNumero();
            conversione = Integer.toString(Integer.parseInt(num,8), 16);


            System.out.println("\n\nConversione:\n\t" + num + "(OTT)  =>  " + conversione.toUpperCase() + "(ESA)\n");

        }
        catch(NumberFormatException e)
        {
            System.err.println("NUMERO INSERITO da convertire non valido!\n");
        }
        
    }
    
    
    public static void esaDec(){
        
        String num;
        String conversione;
        
        System.out.println("\nESADECIMALE -> DECIMALE\n");
        
        try{
            
            num = getNumero();
            conversione = Integer.toString(Integer.parseInt(num, 16));


            System.out.println("\n\nConversione:\n\t" + num.toUpperCase() + "(ESA)  =>  " + conversione + "(DEC)\n");

        }
        catch(NumberFormatException e)
        {
            System.err.println("NUMERO INSERITO da convertire non valido!\n");
        }
        
    }
    
    public static void esaBin(){
        
        String num;
        String conversione;
        
        System.out.println("\nESADECIMALE -> BINARIO\n");
        
        try{
            
            num = getNumero();
            conversione = Integer.toString(Integer.parseInt(num, 16), 2);


            System.out.println("\n\nConversione:\n\t" + num.toUpperCase() + "(ESA)  =>  " + conversione + "(BIN)\n");

        }
        catch(NumberFormatException e)
        {
            System.err.println("NUMERO INSERITO da convertire non valido!\n");
        }
        
    }
    
    public static void esaOtt(){
        
        String num;
        String conversione;
        
        System.out.println("\nESADECIMALE -> OTTALE\n");
        
        try{
            
            num = getNumero();
            conversione = Integer.toString(Integer.parseInt(num, 16), 8);


            System.out.println("\n\nConversione:\n\t" + num.toUpperCase() + "(ESA)  =>  " + conversione + "(OTT)\n");

        }
        catch(NumberFormatException e)
        {
            System.err.println("NUMERO INSERITO da convertire non valido!\n");
        }
        
    }
    
    
    //prendo qualsiasi numero come stringa
    public static String getNumero(){
        
        Scanner input = new Scanner(System.in);
        
        System.out.print("Inserisci in numero di partenza: ");
        return input.nextLine();
        
    }
    
}
