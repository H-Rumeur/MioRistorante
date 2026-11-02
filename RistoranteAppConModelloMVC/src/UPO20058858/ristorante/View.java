package UPO20058858.ristorante;

public class View {


    /**
     *
     * @param messagio
     */
    public void StampaMessagio(String messagio){
        System.out.println(messagio);
    }

    /**
     *
     * @param cliente
     */
    public void StampaInfoCliente(Cliente cliente){
        System.out.println("id: " + cliente.getId());
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("cognome: " + cliente.getCognome());
        System.out.println("data di nascita: " + cliente.getNascita());
        System.out.println("data di registrazione: " + cliente.getDataRegistrazione());
        System.out.println("numero ordini: " + cliente.getOrdini().size());
        System.out.println("ordini: ");
        /*for(Ordine ordine : cliente.getOrdini()){
            StampaInfoOrdine(ordine);
          }
        */
        System.out.println("\n");
    }

    /**
     *
     * @param ordine
     */
    public void StampaInfoOrdine(Ordine ordine) {
        System.out.println("  Date de la commande: " + ordine.getDataordine());
        System.out.println("  Nombre de plats: " + ordine.getNumeroPiatti());
        System.out.println("  Type de menu: " + ordine.getTipoMenu());
    }

    /**
     *
     */

    public void StampaHomePage(){
        System.out.println("\n\t\t******** HOME PAGE *********\n");
        System.out.println("che vuoi fare?? digita la cifra corrispondente.\n");
        System.out.println("1- inserire un cliente");
        System.out.println("2- ricercare un cliente ");
        System.out.println("3- aggiungi ordine");
        System.out.println("4- statistiche numero piatti ");
        System.out.println("5- statistiche Menu");
        System.out.println("6- exit ");
        System.out.println("\n");
    }

    /**
     *
     */

    public  void StampaMenu(){
        System.out.println("\n\t\tMENU");
        System.out.println("\t1- Crispy bacon");
        System.out.println("\t2- Big tasty");
        System.out.println("\t3- double chicken BBQ");
        System.out.println("\t4- Wrap gustoso");
    }

    /**
     *
     */
    public void StampaMessagioRicerca(){

        System.out.println("1- ricerca per id");
        System.out.println("2- ricerca per étà");

    }

    /**
     *
     * @param max
     * @param min
     * @param media
     */

    public void StampaStatisticheNumPiatti(int max,int min,double media){
        System.out.println("il massimo è: " + max);
        System.out.println("il minimo è: " + min);
        System.out.println("la media è: " + media);
    }

    /**
     *
     * @param M1
     * @param M2
     * @param M3
     * @param M4
     */

    public void StampaStatisticheTipoMenu(int M1,int M2,int M3,int M4){
        System.out.println("Ordine: Crispy Bacon: " + M1);
        System.out.println("Ordine: Big Tasty: " + M2);
        System.out.println("Ordine: Double Chicken BBQ: " + M3);
        System.out.println("Ordine: Wrap Gustoso: " + M4);
    }

    
}
