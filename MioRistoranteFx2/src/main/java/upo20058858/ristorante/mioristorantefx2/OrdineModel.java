package upo20058858.ristorante.mioristorantefx2;

import java.io.Serializable;
import java.time.LocalDate;

public class OrdineModel implements Serializable {


    private LocalDate DataOrdine;
    private int numeroPiatti;
    private String tipoMenu;


    /**
     *
     * @param DataOrdine
     * @param numeroPiatti
     * @param tipoMenu
     */
    public OrdineModel(LocalDate DataOrdine,int numeroPiatti,String tipoMenu) {

        this.DataOrdine = DataOrdine;
        this.numeroPiatti = numeroPiatti;
        this.tipoMenu = tipoMenu;
    }

    /**
     *
     * @return
     */
    public LocalDate getDataordine() {

        return DataOrdine;
    }

    /**
     *
     * @return
     */
    public String getTipoMenu() {
        return tipoMenu;
    }

    /**
     *
     * @return
     */
    public int getNumeroPiatti() {
        return numeroPiatti;
    }


    /*
    public void StampaInfoOrdine() {
        System.out.println("  Date de la commande: " + DataOrdine);
        System.out.println("  Nombre de plats: " + numeroPiatti);
        System.out.println("  Type de menu: " + tipoMenu);
    }

     */

    /**
     *
     * @return
     */
    public String toString() {
        return "ordini:" + "\tData Ordine:"+ DataOrdine +"\tnumero piatti:" + numeroPiatti +"\ttipoMenu:" + tipoMenu ;
    }
}
