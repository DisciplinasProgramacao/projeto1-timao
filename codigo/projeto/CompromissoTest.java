import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Tenta criar o compromisso com valores negativos para repetirdia e vezesrepetidas
// Testar se tamanho do array e os dias adicionados estão corretos

class CompromissoTest {

    @Test
    public void criarCompromissoTest(){
        Compromisso compromisso = new Compromisso("Terapia", "10/09/2002", -2, -7);
        assertEquals(1 , compromisso.getRepetirdia());
        assertEquals(1 , compromisso.getVezesrepetidas());
    }

    @Test
    public void criarArrayCompromissosTest(){
        Compromisso compromisso = new Compromisso("Terapia", "10/09/2002", 4, 5);
        assertEquals(5,compromisso.getArraycompromissos().length);
        assertEquals("14/09/2002", compromisso.getArraycompromissos()[1].getData().dataFormatada());
    }
}