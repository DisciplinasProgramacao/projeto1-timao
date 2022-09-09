import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Testa a criação de um calendario de compromissos
// Testa o merge e o sort dos arrays do calendario

class CalendarioTest {

    @BeforeEach
    public void criarCompromisso(){
        Compromisso compromisso = new Compromisso("Pilates", "02/05/2020", 7, 4);
    }
    @Test
    public void criarCalendarioTest(){
        assertEquals(9,Calendario.getArrayCalendario()[1].getData().getDia());
        assertEquals(4,Calendario.getArrayCalendario().length);
    }

    @Test
    public void mergeSortArrayCalendarioTest(){
        Compromisso compromisso2 = new Compromisso("Pelada", "03/05/2020", 4, 4);
        assertEquals(3,Calendario.getArrayCalendario()[1].getData().getDia());
        assertEquals(8,Calendario.getArrayCalendario().length);

    }


}