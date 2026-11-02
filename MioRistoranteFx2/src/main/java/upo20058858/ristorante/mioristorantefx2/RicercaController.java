package upo20058858.ristorante.mioristorantefx2;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class RicercaController {
    @FXML
    public TextField TextFieldRicercaEtamin;
    @FXML
    public TextField TextFieldRicercaEtaMax;
    @FXML
    public Button ButtonRicerca;
    @FXML
    public ListView<String> ListViewRicerca = new ListView<>();
    @FXML
    public TextField TextFieldRicercaid;
    @FXML
    private Stage stage;

    @FXML
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);  // No header text for simple alerts
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void RicercaClienti() {
        String id = TextFieldRicercaid.getText();
        String min = TextFieldRicercaEtamin.getText();
        String max = TextFieldRicercaEtaMax.getText();
        String nome;
        String cognome;
        String Nascita;
        ListViewRicerca.getItems().clear();
        TextFieldRicercaEtamin.clear();
        TextFieldRicercaEtaMax.clear();
        TextFieldRicercaid.clear();

        if ((id == null || id.isEmpty()) && (min == null || min.isEmpty()) && (max == null || max.isEmpty())) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "Devi riempi uno o la ricerca per id o la ricerca per età");// Arrêter la méthode si aucune recherche valide n'est fournie
        }

        else if ((min == null || min.isEmpty()) || (max == null || max.isEmpty())) {
            boolean trovato = false;
            for (ClienteModel cliente : MainApplication.clienti) {
                if (cliente.getId().equals(id)) {
                    nome = cliente.getNome();
                    cognome = cliente.getCognome();
                    Nascita = Integer.toString(cliente.getNascita());
                    // Ajout des informations dans la ListView
                    ListViewRicerca.getItems().addAll(nome, cognome, Nascita, cliente.getId());
                    trovato = true;
                }
            }
            if (!trovato) {
                showAlert(Alert.AlertType.INFORMATION, "Messaggio", "Nessun cliente trovato");
            }
        }
        else if (id.isEmpty() && (!min.isEmpty() && !max.isEmpty())) {
            int x = Integer.parseInt(min);
            int y = Integer.parseInt(max);
            if(x<=0||y<=0) {
                showAlert(Alert.AlertType.ERROR,"input error","l'età non può essere nullo o negarivo");
            }
            else{
                boolean trovato = false;
                for(ClienteModel cliente : MainApplication.clienti) {
                    int age = LocalDate.now().getYear()-cliente.getNascita();
                    if(age >= x && age <= y){
                            nome = cliente.getNome();
                            cognome = cliente.getCognome();
                            Nascita = Integer.toString(cliente.getNascita());
                            ListViewRicerca.getItems().addAll(nome,cognome,Nascita, cliente.getId());
                            ListViewRicerca.getItems().add("\n");
                            trovato = true;
                    }
                }
                if(!trovato) {
                    showAlert(Alert.AlertType.INFORMATION,"Messaggio","nessun cliente trovato");
                }
            }
        }



    }
}
