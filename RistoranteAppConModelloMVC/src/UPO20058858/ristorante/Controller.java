package UPO20058858.ristorante;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private Cliente clienteModel;
    private Ordine ordineModel;
    private  View view;
    public static Scanner tastiera = new Scanner(System.in);
    static List<Cliente> clienti = new ArrayList<>();

    /**
     *
     * @param model
     * @param ordine
     * @param view
     */
    public Controller(Cliente model, Ordine ordine, View view) {
        this.clienteModel = model;
        this.ordineModel = ordine;
        this.view = view;
    }


    /**
     *
     */
    public void inserisci(){
        String nome;
        String cognome;
        int nascita = 0;
        view.StampaMessagio("****** INSERIRE CLIENTE ******\n");
        tastiera.nextLine(); // per liberare il buffer
        view.StampaMessagio("inserisci il tuo nome: ");
        nome = tastiera.nextLine();
        view.StampaMessagio("inserisci il tuo cognome: ");
        cognome = tastiera.nextLine();
        do{
            try {
                view.StampaMessagio("inserisci la tua data di nascita: ");
                nascita = tastiera.nextInt();
                // suppongo che a 100 anni si sia troppo vecchio per usare questo tipo di applicazioni
                if(nascita>= LocalDate.now().getYear() || nascita<= (LocalDate.now().getYear()-100)){
                    view.StampaMessagio("l'anno di nascita che hai inserito non è valido");
                }
            } catch(InputMismatchException e){
                view.StampaMessagio(e.getMessage());
                view.StampaMessagio("la data di nascita non può contenere lettere o caratteri speciali\n inserire una nuova data di nascita");
                tastiera.next(); // per cancellare l'input non valido dal buffer
            }

        }while(nascita < 0 || nascita>=LocalDate.now().getYear() || nascita<= (LocalDate.now().getYear()-90));

        clienteModel = new Cliente(nome,cognome, LocalDate.now(), nascita);
        clienti.add(clienteModel);
        view.StampaMessagio("\n************ cliente registrato con successo ************\n");

        // qui Stampo a video l'identificativo del cliente
        // il cliente ha bisogno del suo identificativo per poter ordinare
        view.StampaMessagio("questo è il tuo identificativo\nnon condividerlo con nessuno!!!!!\n---->  " + clienteModel.getId());
    }


    /**
     *
     */
    public void CercaCliente(){
        int scelta = 0;
        view.StampaMessagio("****** Cerca cliente ******\n");
        view.StampaMessagio("digita la cifra corrispondente alla tua scelta");
        view.StampaMessagioRicerca();
        do{
            try{
                scelta = tastiera.nextInt();
                if(scelta < 1 || scelta > 2){
                    view.StampaMessagio("input non valido");
                    view.StampaMessagioRicerca();
                }
            }
            catch(InputMismatchException e){
                view.StampaMessagio(" devi digitare la cifra corrispondente alla tua scelta\n modifica la tua scelta!!\n");
                view.StampaMessagioRicerca();
                tastiera.next();
            }
        }while(scelta != 1 && scelta != 2);

        switch (scelta){
            case 1:
                tastiera.nextLine();
                String identificativo;
                view.StampaMessagio("inserire l'identificativo da ricercare: ");
                identificativo = tastiera.nextLine();
                for(Cliente cliente : clienti){
                    if(cliente.getId().equals(identificativo)){
                        view.StampaInfoCliente(cliente);
                    }
                }
                break;
            case 2:
                int etaMin = -1;
                int etaMax =-1;

                do{
                    try{
                        view.StampaMessagio("inserire l'eta minimo: ");
                        etaMin = tastiera.nextInt();
                        view.StampaMessagio("inserire l'eta maximo: ");
                        etaMax = tastiera.nextInt();
                        if( etaMin < 0 || etaMax < 0){
                            view.StampaMessagio("input non validi \n prova di nuovo");
                        }
                        if(etaMin > etaMax){
                            int tmp = etaMin;
                            etaMin = etaMax;
                            etaMax = tmp;
                        }
                    } catch (InputMismatchException e) {
                        view.StampaMessagio(e.getMessage());
                        view.StampaMessagio("l'età dev'essere un numero intero");
                        tastiera.next();
                    }
                }while (etaMin > etaMax || etaMin < 0 || etaMax <= 0);

                for (Cliente cliente : clienti) {
                    if(cliente.getNascita() <= LocalDate.now().getYear()-etaMin && cliente.getNascita() >= LocalDate.now().getYear()-etaMax){
                        view.StampaMessagio("id cliente: " + cliente.getId());
                    }
                }
                break;
            default:
                view.StampaMessagio("ERROR:: input non valido");
        }
    }


    /**
     *
     */
    public  void aggiungiOrdine(){
        String identificativo;
        int Numpiatti = 0;
        String TipoMenu = "" ;
        int scelta = 0;
        view.StampaMessagio("\n\t\t************ AGGIUNGERE ORDINE ************\n");
        tastiera.nextLine();
        view.StampaMessagio("\ninserisci il tuo id");
        identificativo = tastiera.nextLine();
        // cercare in che posizione si trova il cliente nel record ID
        for (Cliente cliente : clienti) {
            if(cliente.getId().equals(identificativo)){
                view.StampaMessagio(" cliente trovato\n");
                do{
                    try{
                        view.StampaMessagio("cosa vuoi ordinare?? digita la cifra corrispondente ");
                        view.StampaMenu();
                        scelta = tastiera.nextInt();
                        if(scelta < 1 || scelta > 4){
                            view.StampaMessagio("input non valido!!!! Riprova!!!");
                        }
                    }catch(InputMismatchException e){
                        view.StampaMessagio("devi digitare la cifra corrispondente alla tua scelta");
                        tastiera.next();
                    }
                }while(scelta < 1 || scelta > 4);

                TipoMenu = switch (scelta) {
                    case 1 -> "Crispy Bacon";
                    case 2 -> "Big Tasty";
                    case 3 -> "Double chicken BBQ";
                    case 4 -> "Wrap Gustoso";
                    default -> TipoMenu;
                };

                do{
                    try{
                        view.StampaMessagio("quanti piatti vuoi???");
                        Numpiatti = tastiera.nextInt();
                        if(Numpiatti <= 0){
                            view.StampaMessagio("numero di piatti non valido!!!!");
                        }
                    }catch(InputMismatchException e){
                        view.StampaMessagio("il numero di piatti deve essere un intero");
                        tastiera.next();
                    }
                }while(Numpiatti <= 0);


                 Ordine ordine = new Ordine(LocalDate.now(),Numpiatti,TipoMenu);
                cliente.AddOrdini(ordine);
                //clienti_ordini.get(cliente.getId()).add(ordine);
                break;
            }
        }
        do{
            try{
                view.StampaMessagio("vuoi ancora ordinare??\n 1- sì\n2- non");
                scelta = tastiera.nextInt();
                if(scelta < 1 || scelta > 2){
                    view.StampaMessagio("input non valido!! \n");
                }
            }catch(InputMismatchException e){
                view.StampaMessagio("la scelta non puo contenere lettere e/o caratteri speciali\n");
            }
        }while(scelta < 1 || scelta > 2);

        switch (scelta){
            case 1:
                aggiungiOrdine();
                break;
            case 2:
                break;
        }

    }

    /**
     *
     */

    public void StatisticheNumPiatti(){
        int Max= Integer.MIN_VALUE;
        int min= Integer.MAX_VALUE;
        int sommaNumPiatti = 0;
        int sommaTotale = 0;
        double media;
        int count = 0;

        for(Cliente cliente : clienti){
            if(!cliente.getOrdini().isEmpty()){
                for(Ordine ordine : cliente.getOrdini()){
                    sommaNumPiatti =0;
                    if(ordine.getNumeroPiatti() > 0){
                        sommaNumPiatti += ordine.getNumeroPiatti();

                    }
                }
                if(sommaNumPiatti > Max){
                    Max = sommaNumPiatti;
                }
                if(sommaNumPiatti < min){
                    min = sommaNumPiatti;
                }
                sommaTotale += sommaNumPiatti;
                count++;
            }
        }
        media = (double) sommaTotale /count;
        view.StampaStatisticheNumPiatti(Max,min,media);
    }

    /**
     *
     */

    public void StatisticheTipoMenu(){
        int M1 = 0;
        int M2 = 0;
        int M3 = 0;
        int M4 = 0;

        for(Cliente cliente : clienti){
            if(!cliente.getOrdini().isEmpty()){
                // per fare la media non prendo in conto i clienti che non hanno ordinato
                for(Ordine ordine : cliente.getOrdini()){
                    if(ordine.getTipoMenu().equalsIgnoreCase("crispy bacon")){
                        M1+= ordine.getNumeroPiatti();
                    }
                    if(ordine.getTipoMenu().equalsIgnoreCase("Big Tasty")){
                        M2+= ordine.getNumeroPiatti();
                    }
                    if(ordine.getTipoMenu().equalsIgnoreCase("double chicken BBQ")){
                        M3+= ordine.getNumeroPiatti();
                    }
                    if(ordine.getTipoMenu().equalsIgnoreCase("wrap gustoso")){
                        M4+= ordine.getNumeroPiatti();
                    }
                }
            }

        }

        view.StampaStatisticheTipoMenu(M1,M2,M3,M4);

    }

    /**
     *
     * @param lista
     * @param nomeFile
     */
    public static void SalvareSuFile(List<Cliente> lista,String nomeFile){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFile))){
            for(Cliente cliente : lista){
                oos.writeObject(cliente);
            }
            System.out.println("Dati salvati con successo sul file" + nomeFile);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    /**
     *
     * @param nomeFile
     * @return
     */

    public static List<Cliente> LetturaSuFile(String nomeFile){
        List<Cliente> lista = new ArrayList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFile))){
            Cliente c;
            while(true){
                try{
                    c = (Cliente) ois.readObject();
                    lista.add(c);
                } catch (EOFException e) {
                    break;
                }
            }

        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return lista;
    }

    /**
     *
     */

    public void Start(){
        clienti = LetturaSuFile("DatiClienti");
        int scelta = 0;
        view.StampaMessagio("benvenuto nel servizio di ristorazione dell'UPO");
        view.StampaHomePage();
        scelta = tastiera.nextInt();

        while (scelta!=100){
            switch (scelta){
                case 1:
                    inserisci();
                    break;
                case 2:
                    CercaCliente();
                    break;
                case 3:
                    aggiungiOrdine();
                    break;
                case 4:
                    StatisticheNumPiatti();
                    break;
                case 5:
                    StatisticheTipoMenu();
                    break;
                case 6:
                    SalvareSuFile(clienti,"DatiClienti");
                    System.exit(0);
            }
            view.StampaHomePage();
            scelta = tastiera.nextInt();

        }


    }

}


