public class Data {
    //#region atributos
    //constante: dias de cada mês
    private static final int[] DIASDOMES = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30,
            31, 30, 31};
    private static final int ANO_ATUAL = 2022;
    private static final String[] DIASDASEMANA = {"sábado", "domingo", "segunda",
            "terça", "quarta", "quinta", "sexta"}; //2022 começa em um sábado
    //atributos
    private int dia;
    private int mes;
    private int ano;
    //#endregion

    //#region Construtores

    /**
     * Inicializador privado. É utilizado pelos construtores. Faz a validação e, em
     * caso de data inválida, retorna 01/01/1900.
     *
     * @param dia Dia para a data
     * @param mes Mês para a data
     * @param ano Ano para a data
     */
    private void init(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        if (!this.dataValida()) {     //se a data não é válida... (método da própria classe)
            this.dia = this.mes = 1;
            this.ano = 1900;
        }
    }

    /**
     * Construtor completo: recebe dia, mês e ano e valida a data. Datas inválidas
     * vão para 01/01/1900
     *
     * @param dia Dia para a data
     * @param mes Mês para a data
     * @param ano Ano para a data
     */

    public Data(int dia, int mes, int ano) {
        this.init(dia, mes, ano);
    }

    /**
     * Construtor para ano atual: recebe dia, mês e completa com ano atual (2022).
     * Datas inválidas vão para 01/01/1900
     *
     * @param dia Dia para a data
     * @param mes Mês para a data
     */

    public Data(int dia, int mes) {
        this.init(dia, mes, ANO_ATUAL);
    }

    /**
     * Construtor para data padrão: 01/01/1900
     */
    public Data() {
        this.init(1, 1, 1990);
    }
    //#endregion

    /**
     * Verifica se o ano da data armazenada é bissexto.
     * Para regras do ano bissexto:
     * http://educacao.uol.com.br/disciplinas/matematica/ano-bissexto-eles-se-
     * repetem-a-cada-4-anos.htm
     * http://www.sogeografia.com.br/Curiosidades/?pg=4
     *
     * @return Se o ano é bissexto (true) ou não (false)
     */
    public boolean anoBissexto() {
        boolean resposta = false;
        if (this.ano % 400 == 0)
            resposta = true;
        else if (this.ano % 4 == 0 && this.ano % 100 != 0)
            resposta = true;

        return resposta;
    }

    /**
     * Verifica se a data armazenada é válida (método privado). Só valem datas de
     * 1900 em diante.
     *
     * @return TRUE se é válida ; FALSE se não é válida
     */
    private Boolean dataValida() {
        Boolean resposta = true;        //resposta sobre a validade
        int maximoDeDias = 0;
        if (this.ano < 1900)
            resposta = false;
        else {
            if (this.mes < 1 || this.mes > 12)                           //mês<1 ou mês > 12-- > data inválida
                    resposta = false;
           else{
                maximoDeDias = DIASDOMES[mes];
                if (this.anoBissexto() && mes == 2)                    //caso de 29 / 02 em ano bissexto-- > data válida
                maximoDeDias++;
                if (this.dia > maximoDeDias)                //verifica validade de acordo com o mês atual
                resposta = false;
            }
        }
        return resposta;    //retorna a validação obtida
    }

    /**
     * Método static: calcula do dia da semana de uma data em 2022 (ignora o ano
     * caso seja diferente).
     * Datas inválidas retornam e são calculadas como 01/01/2022
     *
     * @return O dia da semana da data parametrizada em 2022.
     */
    public static String diaDaSemanaEm2022(String data) {

        int deslocamento = 0;
        int totalDias = 0;
        int mesParaSomar = 1;
        String[] detalhes = data.split("/");
        int dia = Integer.parseInt(detalhes[0]);
        int mes = Integer.parseInt(detalhes[1]);

        Data aux = new Data(dia, mes);

        while (mesParaSomar != aux.mes) {           //somamos todos os dias dos meses anteriores ao atual
            totalDias += DIASDOMES[mesParaSomar];
            mesParaSomar++;
        }
        totalDias += (aux.dia - 1);       //somamos os dias para chegar na data dentro do mês
                deslocamento = totalDias % 7;     //o deslocamento em dias no vetor contante de dias da semana indica o dia da data.
        return DIASDASEMANA[deslocamento];
    }


    /**
     * Retorna a data formatada
     *
     * @return String com a data no formato dd/mm/aaaa
     */
    public String dataFormatada() {

        return (String.format("%02d", this.dia) +
                "/" + String.format("%02d", this.mes) +
                "/" + String.format("%4d", this.ano));
    }

    /**
     * Método que cria um array de datas adicionando os dias desejados com tamanho
     * baseado nas vezes que a data deve ser repetida.
     *
     * @param data
     * @param repetirdia
     * @param vezesrepetidas
     * @return um array de datas
     */

    public Data[] criarArrayData(Data data,int repetirdia, int vezesrepetidas){
        Data arraydata[] = new Data[vezesrepetidas];
        arraydata[0] = data;
        Data aux = new Data(data.dia,data.mes,data.ano);
        int i;
        int j;
        for(i=1;i<vezesrepetidas;i++){
            for(j=0;j<repetirdia;j++){
                aux.dia++;
                if(aux.dataValida()==false){
                    aux.dia = 1;
                    aux.mes++;
                }
            }
            arraydata[i]= new Data(aux.dia,aux.mes,aux.ano);
        }
        return arraydata;
    }

    /**
     * Método que desformata uma string de data recebida
     *
     * @param datanaoformatada
     * @return um objeto data
     */

    public static Data desformatarData(String datanaoformatada) {

        String[] detalhes = datanaoformatada.split("/");
        int dia = Integer.parseInt(detalhes[0]);
        int mes = Integer.parseInt(detalhes[1]);
        int ano = Integer.parseInt(detalhes[2]);

        Data dataformatada = new Data(dia, mes, ano);

        return dataformatada;
    }


    /**
     * Método que compara data inicio, data desejada e data fim
     *
     * @param data1 data inicio
     * @param data2 data desejada
     * @param data3 data fim
     * @return true ou false
     */
    public static boolean compararDatas(Data data1,Data data2, Data data3){
        if(data1.getAno() <= data2.getAno() && data3.getAno() >= data2.getAno()){
            if(data1.getMes() <= data2.getMes() && data3.getMes() >= data2.getMes()){
                if(data1.getDia() <= data2.getDia() && data3.getDia() >= data2.getDia()){
                    return true;
                }
            }
        }
        return false;
    }

    public int getDia() {
        return dia;
    }
    public int getMes() {
        return mes;
    }
    public int getAno() {
        return ano;
    }

}
