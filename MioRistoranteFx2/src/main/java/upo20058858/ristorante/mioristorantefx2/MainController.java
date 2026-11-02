package upo20058858.ristorante.mioristorantefx2;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.*;

public class MainController {

    @FXML
    public Button ButtonInserire;
    @FXML
    public Button ButtonRicerca;
    @FXML
    public Button ButtonOrdinare;
    @FXML
    public Button ButtonStatistiche;
    @FXML
    public Button ButtonExit;

    /**
     *
     */
    @FXML
    public void InserisciCliente() {
        try {
            // Caricamento della scena Inserimento.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Inserimento.fxml"));
            Scene newScene = new Scene(loader.load());

            // creazione di una nuova finestra
            // così la finestra principale non si chiude e rimane attiva
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.setTitle("Inserimento");  // Titre de la nouvelle fenêtre

            InserimentoController controller = loader.getController();
            controller.setStage(newStage);

            newStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     */

    @FXML
    public void RicercareCliente() {
        try {
            // caricamento della scena ricercaClienti.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ricercaclienti.fxml"));
            Scene newScene = new Scene(loader.load());

            // Obtenir le stage actuel (la fenêtre principale)
            // à modifier prend exemple sur la methode du dessus
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.setTitle("Ricerca");  // Titre de la nouvelle fenêtre

            RicercaController controller = loader.getController();
            controller.setStage(newStage);

            newStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     *
     */
    @FXML
    public void Ordinare() {
        try {
            // Charger la scène NewScene.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ordinare1.fxml"));
            Scene newScene = new Scene(loader.load());

            // Obtenir le stage actuel (la fenêtre principale)
            Stage NewStage = new Stage();
            NewStage.setScene(newScene);
            NewStage.setTitle("Ordinare");

            Ordinare1Controller controller = loader.getController();
            controller.setStage(NewStage);
            NewStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    @FXML
    public void StatisticheRistorante() {
        try {
            // Charger la scène NewScene.fxml
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Statistiche.fxml"));
            Scene newScene = new Scene(loader.load());

            // Créer un nouveau stage pour la nouvelle fenêtre
            Stage newStage = new Stage();
            newStage.setScene(newScene);
            newStage.setTitle("Statistiche");  // Titre de la nouvelle fenêtre
            newStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    @FXML
    public void Off() {
        MainApplication.SalvareSuFile(MainApplication.clienti,"DatiClienti");
        Platform.exit();
    }





}