package upo20058858.ristorante.mioristorantefx2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Ordinare2Controller {
    @FXML
    public Label LabelTipoMenu;
    @FXML
    public Label LabelNumPiatti;
    @FXML
    public TextField TextFieldNumPiatti;
    @FXML
    public Button ButtonOrdinare2;
    @FXML
    public ChoiceBox<String> ChoiceBoxMenu;
    @FXML
    private Stage stage;
    @FXML
    private ClienteModel clientemodel;

    @FXML
    public void setStage(Stage stage){
        this.stage = stage;
    }
    @FXML
    public void setOrdinante(ClienteModel cliente){
        this.clientemodel = cliente;

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

    public void initialize(){
        ChoiceBoxMenu.getItems().add("Menu Bambino");
        ChoiceBoxMenu.getItems().add("Menu Vegano");
        ChoiceBoxMenu.getItems().add("Menu Classico");
        ChoiceBoxMenu.getItems().add("Menu Gourmet");
    }

    /**
     *
     */
    @FXML
    public void Ordinare() {
        int numPiatti = Integer.parseInt(TextFieldNumPiatti.getText());
        String TipoMenu = ChoiceBoxMenu.getValue();
        if(numPiatti > 0 && !TipoMenu.isEmpty()){
          OrdineModel ordine = new OrdineModel(LocalDate.now(),numPiatti,TipoMenu);
          clientemodel.AddOrdini(ordine);
          showAlert(Alert.AlertType.INFORMATION, "Ordinare", "Ordine registrato con successo!");
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
          alert.setTitle("Ordinare");
          alert.setHeaderText(null);
          alert.setContentText("vuoi ancora ordinare ??");
          ButtonType result = alert.showAndWait().orElse(ButtonType.CANCEL);
          if(result != ButtonType.OK){
                stage.close();
          }
          else {
              ChoiceBoxMenu.setValue(null);
              TextFieldNumPiatti.clear();
          }

        }
        else{
            showAlert(Alert.AlertType.ERROR, "ERROR", "Errore:: verifica gli input!!!");
        }
        System.out.println(clientemodel.toString());
    }


}
