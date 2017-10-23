/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.quadronegro.vo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author thiagocs
 */
public class CarnetImobiliarioTest {
    
    public CarnetImobiliarioTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of toString method, of class CarnetImobiliario.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        CarnetImobiliario instance = new CarnetImobiliario();
        instance.setSequencial("    002");
        instance.setSequencialImovel("100005.5");
        instance.setExercicio("2010");
        instance.setCodigoImpressao("106C      ");
        instance.setTituloCapa("IPTU e Taxas ");
        String[] enderecoCorrespondencia = new String[3];
        enderecoCorrespondencia[0] = "AAAAA";
        enderecoCorrespondencia[1] = "BBBBB";
        enderecoCorrespondencia[2] = "CCCCC";
        
        instance.setEnderecoCorrespondencia(enderecoCorrespondencia);
        
        System.out.println(instance);
    }
    
}
