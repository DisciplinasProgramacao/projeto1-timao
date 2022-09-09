import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Testa se data esta sendo criada corretamente e testa criação com valores negativos
// Testa validação do Ano Bisexto
// Testa dia da semana em 2022
// Testa se data é formatada corretamente
// Testa se o array de data foi criado corretamente
// Testa data sendo desformatada

class DataTest {

    @Test
    public void criarDataTest(){
        Data data = new Data(10,9,2002);
        assertEquals(10,data.getDia());
        assertEquals(9,data.getMes());
        assertEquals(2002,data.getAno());
        Data data2 = new Data(-10,-6,33);
        assertEquals(1,data2.getDia());
        assertEquals(1,data2.getMes());
        assertEquals(1900,data2.getAno());
    }
    @Test
    public void anoBisextoTest(){
        Data data = new Data(10,9,2020);
        assertEquals(true,data.anoBissexto());
    }

    @Test
    public void diaDaSemanaTest(){
        assertEquals("sábado", Data.diaDaSemanaEm2022("10/09/2022"));
    }

    @Test
    public void dataFormatadaTest(){
        Data data = new Data(10,9,2020);
        assertEquals("10/09/2020",data.dataFormatada());
    }

    @Test
    public void criarArrayDataTest(){
        Data data = new Data(10,9,2020);
        assertEquals(4,data.criarArrayData(data,5,4).length);
        assertEquals(15,data.criarArrayData(data,5,4)[1].getDia());
        assertEquals(20,data.criarArrayData(data,5,4)[2].getDia());

    }

    @Test
    public void desformatarDataTest(){
        assertEquals(4,Data.desformatarData("4/03/2020").getDia());
        assertEquals(3,Data.desformatarData("4/03/2020").getMes());
        assertEquals(2020,Data.desformatarData("4/03/2020").getAno());


    }
}