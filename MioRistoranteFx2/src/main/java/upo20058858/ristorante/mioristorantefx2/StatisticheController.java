package upo20058858.ristorante.mioristorantefx2;

import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;

public class StatisticheController {
    @FXML
    public ListView<String> ListViewStastisticheMenu;
    @FXML
    public ListView<String> ListViewStatisticheNumPiatti;
    @FXML
    public void initialize() {
        StampaStatistiche();
    }

    @FXML
    public void StampaStatistiche(){
        StatisticheNumPiatti(MainApplication.clienti);
        StatisticheTipoMenu(MainApplication.clienti);

    }
    @FXML
    public void StatisticheNumPiatti(List<ClienteModel> lista){
        int min = 0;
        int max = 0;
        double media;
        int SumNumPiatti;
        int SumTotale = 0;
        int count = 0;
        for(ClienteModel cliente : lista){
            if(!cliente.getOrdini().isEmpty()){
                SumNumPiatti=0;
                for(OrdineModel ordine : cliente.getOrdini()){
                    if(ordine.getNumeroPiatti()>0){
                        SumNumPiatti+=ordine.getNumeroPiatti();
                    }
                }
                if(SumNumPiatti > max){
                    max = SumNumPiatti;
                }
                if(SumNumPiatti < min){
                    min = SumNumPiatti;
                }
                SumTotale+=SumNumPiatti;
                count++;
            }
        }
        media = (double) SumTotale/count;
        ListViewStatisticheNumPiatti.getItems().add("Num-MAx ordini: " + max);
        ListViewStatisticheNumPiatti.getItems().add("Num-Min ordini: " + min);
        ListViewStatisticheNumPiatti.getItems().add("Num-Total ordini: " + SumTotale);
        ListViewStatisticheNumPiatti.getItems().add("Num Ordinanti: " + count);
        ListViewStatisticheNumPiatti.getItems().add("media Ordini: " + media);

    }

    @FXML
    public void StatisticheTipoMenu(List<ClienteModel> lista){
        int M1 = 0;
        int M2 = 0;
        int M3 = 0;
        int M4 = 0;
        for(ClienteModel cliente : lista){
            if(!cliente.getOrdini().isEmpty()){
                for(OrdineModel ordine : cliente.getOrdini()){
                    if(ordine.getTipoMenu().equalsIgnoreCase("menu bambino")){
                        M1++;
                    }
                    if(ordine.getTipoMenu().equalsIgnoreCase("menu vegano")){
                        M2++;
                    }
                    if(ordine.getTipoMenu().equalsIgnoreCase("menu classico")){
                        M3++;
                    }
                    if(ordine.getTipoMenu().equalsIgnoreCase("menu gourmet")){
                        M4++;
                    }
                }
            }
        }
        ListViewStastisticheMenu.getItems().add("menu Bambino: " + M1);
        ListViewStastisticheMenu.getItems().add("menu Vegano: " + M2);
        ListViewStastisticheMenu.getItems().add("menu Classico: " + M3);
        ListViewStastisticheMenu.getItems().add("menu Gourmet: " + M4);

    }


}
