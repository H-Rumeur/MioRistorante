package upo20058858.ristorante.mioristorantefx2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InserimentoController {
    @FXML
    public TextField textFieldnome;
    @FXML
    public TextField textFieldcognome;
    @FXML
    public TextField textfieldnascita;
    @FXML
    public Button ButtonInvioInserimento;
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


    public void CreaClienti() {
        String nome = textFieldnome.getText();
        String cognome = textFieldcognome.getText();
        String x = textfieldnascita.getText();

        if (nome.isEmpty() || cognome.isEmpty() || x.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, "Input Error", "devi riempire tutti i campi");
            return;
        }

        int Nascita = Integer.parseInt(x);
        if(Nascita>= LocalDate.now().getYear() || Nascita<= (LocalDate.now().getYear()-100)  || Nascita ==0 ){
            showAlert(Alert.AlertType.ERROR, "Input Error", "Anno di nascita non valido");
        }
        if(Nascita<0){
            Nascita = Nascita * -1;
        }

        ClienteModel cliente = new ClienteModel(nome,cognome,LocalDate.now(),Nascita);
        MainApplication.clienti.add(cliente);
        showAlert(Alert.AlertType.INFORMATION, "Inserimento", "Inserimento effettuato\n questo è il suo ID: " + cliente.getId() + " non dimenticarlo!!");
        stage.close();

    }
}
