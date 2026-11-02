package UPO20058858.ristorante;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

public class TestR {
    @Test
    public void test(){}
    @Test
    public void testCreaCliente(){
        Cliente cliente = new Cliente("Ninho","Damso", LocalDate.now(),1999);
        assertEquals("Ninho",cliente.getNome());
        assertEquals("Damso",cliente.getCognome());
        assertEquals(1999,cliente.getNascita());
    }

    @Test
    public void testSetterCliente(){
        Cliente cliente = new Cliente("Ninho","Damso", LocalDate.now(),1999);
        cliente.setNome("Mario");
        assertEquals("Mario",cliente.getNome());
        cliente.setCognome("Rossi");
        assertEquals("Rossi",cliente.getCognome());
        cliente.setNascita(2000);
        assertEquals(2000,cliente.getNascita());
    }

    @Test
    public void testOrdine(){
        Ordine ordine = new Ordine(LocalDate.now(),2,"menu vegano");
        assertEquals("menu vegano",ordine.getTipoMenu());
        assertEquals(2,ordine.getNumeroPiatti());
        assertEquals(LocalDate.now(),ordine.getDataordine());
    }


    @Test
    public void testInserimentoOrdine(){
        Cliente cliente = new Cliente("Ninho","Damso", LocalDate.now(),1999);
        Ordine ordine = new Ordine(LocalDate.now(),2,"menu vegano");
        Ordine ordine2 = new Ordine(LocalDate.now(),4,"menu bambino");
        cliente.AddOrdini(ordine);
        cliente.AddOrdini(ordine2);
        assertEquals(2,cliente.getOrdini().size());
        assertEquals("menu vegano",ordine.getTipoMenu());
    }
}
