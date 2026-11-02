/**
 * @author STYVE WILSON KITIO KENFACK
 */

package upo20058858.ristorante.mioristorantefx2;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class MainApplication extends Application {
    @FXML
    public static List<ClienteModel> clienti = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("HomePage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Mio Ristorante FX");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event -> {
           SalvareSuFile(clienti,"DatiClienti");
        });

    }

    @FXML
    public static void SalvareSuFile(List<ClienteModel> lista,String nomeFile){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeFile))){
            for(ClienteModel cliente : lista){
                oos.writeObject(cliente);
            }
            System.out.println("Dati salvati con successo sul file" + nomeFile);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
    @FXML
    public static List<ClienteModel> LetturaSuFile(String nomeFile){
        List<ClienteModel> lista = new ArrayList<>();

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeFile))){
            ClienteModel c;
            while(true){
                try{
                    c = (ClienteModel) ois.readObject();
                    lista.add(c);
                } catch (EOFException e) {
                    break;
                }
            }

        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
         for(ClienteModel cliente : lista){
             cliente.RemoveAllOrdini();
         }
        return lista;
    }

    public static void main(String[] args) {
        // lettura dei dati dei clienti già registrati
        clienti = LetturaSuFile("DatiClienti");
        launch();
    }
}