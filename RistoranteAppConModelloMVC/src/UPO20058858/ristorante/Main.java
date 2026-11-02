package UPO20058858.ristorante;

import java.io.*;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        View view = new View();
        Cliente clientemodel = new Cliente(null,null,null,0);
        Ordine ordineModel= new Ordine(null,0,null);

        Controller controller = new Controller(clientemodel,ordineModel,view);
        controller.Start();


    }


}