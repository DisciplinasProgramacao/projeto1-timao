public class Calendario {
    private static Compromisso[] arrayCalendario = new Compromisso[0];
    private Data diaInicio;
    private Data diaFim;
    Calendario(){
    }
    /**
     * Cria um array de calendario estático dando merge nos compromissos, e organiza seu conteúdo.
     *
     * @param arrayCompromissos array de compromissos
     */
    public static void criarArrayCalendario(Compromisso[] arrayCompromissos){
        arrayCalendario = mergeArrayCalendario(arrayCompromissos, Calendario.arrayCalendario);
        sortArrayCalendario(Calendario.arrayCalendario);
    }
    /**
     * Método que cria uma string de compromissos levando em conta o dia de inicio e final desejados
     *
     * @param diaInicio dia inicial desejado
     * @param diaFim dia final desejado
     * @return string com datas do array calendario
     */
    public String relatorioDatasSelecionadas(String diaInicio, String diaFim){
        this.diaInicio = new Data().desformatarData(diaInicio);  //desformata a data de inicio
        this.diaFim = new Data().desformatarData(diaFim); //desformata a data final
        int i;
        StringBuilder aux = new StringBuilder ("Relatorio dos Compromissos entre os dias " + this.diaInicio.dataFormatada() + " e " + this.diaFim.dataFormatada() + ":");
        for(i=0;i<Calendario.arrayCalendario.length;i++){
            if(Data.compararDatas(this.diaInicio,Calendario.arrayCalendario[i].getData(),this.diaFim)) {
                aux.append("\n" + Calendario.arrayCalendario[i].getNomecompromisso() + ": " + Calendario.arrayCalendario[i].getData().dataFormatada());
            }
        }
        return aux.toString();
    }
    /**
     * Método que organiza em ordem crescente as datas dentro do array calendario.
     *
     * @param arrayCalendario array do calendario
     * @return array calendario organizado
     */
    private static Compromisso[] sortArrayCalendario(Compromisso[] arrayCalendario) {
        int pos;
        Compromisso temp;
        for (int i = 0; i < arrayCalendario.length; i++)
        {
            pos = i;
            for (int j = i+1; j < arrayCalendario.length; j++)
            {
                if (arrayCalendario[j].getData().getAno() <= arrayCalendario[pos].getData().getAno() &&
                        arrayCalendario[j].getData().getMes() <= arrayCalendario[pos].getData().getMes() &&
                        arrayCalendario[j].getData().getDia() <= arrayCalendario[pos].getData().getDia())
                {
                    pos = j;
                }
            }

            temp = arrayCalendario[pos];
            arrayCalendario[pos] = arrayCalendario[i];
            arrayCalendario[i] = temp;
        }
        return arrayCalendario;
    }
    /**
     * Método que da merge nos compromissos dentro do array calendario, aumentando seu tamanho.
     *
     * @param arrayCompromissos array de compromissos
     * @param arrayCalendario array do calendario
     * @return array calendario com merge
     */
    private static Compromisso[] mergeArrayCalendario(Compromisso[] arrayCompromissos, Compromisso[] arrayCalendario){
        int array1 = arrayCompromissos.length;  //inicializa novo array com tamanho do array compromissos
        int array2 = arrayCalendario.length;  // inicializa novo array2 com tamanho do array de calendario
        Compromisso[] aux = new Compromisso[array1+array2];  //cria um array somando tamanho dos arrays compromissos e calendario
        System.arraycopy(arrayCalendario, 0, aux, 0, array2);
        System.arraycopy(arrayCompromissos, 0, aux, array2, array1);  //copia conteudo dentro dos arrays para dentro do novo array criado
        arrayCalendario = aux;  //substitui array calendario pelo novo calendario
        return arrayCalendario;
    }

    public static Compromisso[] getArrayCalendario() {
        return arrayCalendario;
    }


}

