package upo20058858.ristorante.mioristorantefx2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Ordinare1Controller {

    @FXML
    public Button ButtonIdordinareC;
    @FXML
    public TextField TextfieldIdOrdinare;
    @FXML
    public Label LabelOr;
    @FXML
    private Stage stage;
    @FXML
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     *
     * @param alertType
     * @param title
     * @param message
     */
    @FXML
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);  // No header text for simple alerts
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     *
     */
    public void ClienteEsistente() {
        String idOrdinare = TextfieldIdOrdinare.getText();
        boolean clienteTrovato = false;
       for(ClienteModel cliente : MainApplication.clienti){
            if(cliente.getId().equals(idOrdinare)){
                clienteTrovato = true;
                showAlert(Alert.AlertType.INFORMATION, "Cliente Esistente", "cliente trovato");
                 stage.close();
                 try {
                    // caricamento della scena Ordinare2.fxml
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("Ordinare2.fxml"));
                    Scene newScene = new Scene(loader.load());

                    // per aprire un nuovo stage senza chiudere la scena principale
                    Stage newStage = new Stage();
                    newStage.setScene(newScene);
                    newStage.setTitle("Ordinare");  // Titolo della nuova finestra

                    Ordinare2Controller controller = loader.getController();
                    controller.setStage(newStage);
                    controller.setOrdinante(cliente);

                    newStage.show();
                 } catch (IOException e) {
                    e.printStackTrace();
                 }

            }
        }
        if(!clienteTrovato){
            showAlert(Alert.AlertType.ERROR, "Cliente Esistente", "cliente non trovato");
            stage.close();
        }


    }


}
