package UPO20058858.ristorante;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.*;
import java.io.Serializable;

public class Cliente implements Serializable {

    private final String id;
    private String nome;
    private String cognome;
    private final LocalDate dataRegistrazione;
    private int nascita;
    private List<Ordine> ordini = new ArrayList<>();
    public Set <String> ids = new HashSet<>();

    /**
     *
     * @param nome
     * @param cognome
     * @param dataRegistrazione
     * @param nascita
     */
    public Cliente(String nome,String cognome, LocalDate dataRegistrazione, int nascita) {
        String id;
        do {
            id = RandomId();
        } while (ids.contains(id));
        ids.add(id);
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.dataRegistrazione = dataRegistrazione;
        this.nascita = nascita;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @return
     */
    public String getCognome() {
        return cognome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @param cognome
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     *
     * @return
     */
    public LocalDate getDataRegistrazione() {
        return dataRegistrazione;
    }

    /**
     *
     * @return
     */
    public int getNascita() {
        return nascita;
    }

    /**
     *
     * @param nascita
     */
    public void setNascita(int nascita) {
        if(nascita <= 0 || nascita > 2015 ){
            throw new IllegalArgumentException("la data di nascita non è valida");
        }
        this.nascita = nascita;
    }

    /**
     *
     * @param ordini
     */
    public void setOrdini(List<Ordine> ordini) {

        this.ordini = ordini;
    }

    /**
     *
     * @return
     */
    public List<Ordine> getOrdini() {
        return ordini;
    }

    /**
     *
     * @param ordine
     */

    public void AddOrdini(Ordine ordine){
        ordini.add(ordine);
    }

    /**
     *
     * @param ordine
     */
    public void RemoveOrdini(Ordine ordine){
        ordini.remove(ordine);
    }

    /**
     *
     * @param ordine
     */
    // questo serve a verificare se un cliente ha ordinato un piatto
    public void ContainsOrdine(String ordine){
        for(Ordine ordini : ordini){
            if(ordini.getTipoMenu().equalsIgnoreCase(ordine)){
                System.out.println(ordini);
            }
        }
    }

    /**
     *
     * @return
     */
    // questo metodo serve per generare identificativi casuali per i clienti
    // esempio: c2318
    public static String RandomId(){
        Random random = new SecureRandom();
        int id = random.nextInt(10000);
        return "c"+ String.format("%04d",id);
    }

}
