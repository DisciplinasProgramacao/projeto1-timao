public class Compromisso {
    private String nomecompromisso;
    private Data data;
    private int repetirdia;
    private int vezesrepetidas;
    private Data[] arraydatas;

    private Compromisso[] arraycompromissos;

    /**
     * Construtor do compromisso. inicializa um compromisso com os atributos recebidos,
     * cria um array de datas, cria um array de compromissos, adiciona array de compromissos à classe Calendario.
     * O Compromisso criado possui um nome, uma data, em quantos dias tem que ser repetido, e quantas vezes é repetido.
     * Caso repetirdia e vezesrepetidas sejam menor que 0, seram inicializados com valor default = 1.
     *
     * @param nomecompromisso Nome do Compromisso
     * @param datanaoformatada Data não formatada
     * @param repetirdia dias adicionados à cada repetição
     * @param vezesrepetidas vezes em que o compromisso é repetido
     */

    Compromisso(String nomecompromisso, String datanaoformatada, int repetirdia, int vezesrepetidas) {
        this.nomecompromisso = nomecompromisso;
        this.data = new Data().desformatarData(datanaoformatada);  // desformata a datanaoformatada
        if(repetirdia > 0 && vezesrepetidas > 0){     // checa se os valores de repetirdia e vezesrepetidas são maiores que 0
            this.repetirdia = repetirdia;
            this.vezesrepetidas = vezesrepetidas;
        }
        else{
            this.repetirdia = 1;
            this.vezesrepetidas = 1;
        }
        this.arraydatas=data.criarArrayData(this.data,this.repetirdia,this.vezesrepetidas);  // cria array de datas
        this.arraycompromissos = criarArrayCompromissos(this.arraydatas,this.nomecompromisso,this.vezesrepetidas); // cria array compromissos
        new Calendario(this.arraycompromissos);  // inicializa calendario de compromissos
    }

    /**
     * Construtor utilizado para repetir compromissos dentro do método criarArrayCompromissos
     *
     * @param nomecompromisso Nome do Compromisso
     * @param datanaoformatada Data não formatada
     */
    Compromisso(String nomecompromisso, Data datanaoformatada) {
        this.nomecompromisso = nomecompromisso;
        this.data = datanaoformatada;
    }

    /**
     * Método que cria um array de compromissos com o tamanho baseado em quantas vezes
     * ele tem que ser repetido. todos compromissos dentro do array possuem o mesmo nome.
     *
     * @param arraydatas Array de datas
     * @param nomecompromisso Nome do compromisso
     * @param vezesrepetidas vezes em que o compromisso é repetido
     * @return retorna um array de compromissos
     */
    private Compromisso[] criarArrayCompromissos(Data arraydatas[],String nomecompromisso,int vezesrepetidas){
        Compromisso arraycompromissos[] = new Compromisso[vezesrepetidas];
        int i;
        Data aux;
        for(i=0;i<vezesrepetidas;i++){
            arraycompromissos[i] = new Compromisso(nomecompromisso,arraydatas[i]);
        }
        return arraycompromissos;
    }

    /**
     * Método que cria uma string com os compromissos criados
     *
     * @return retorna uma string com todos os compromissos criados
     */
    public String relatorioCompromissos(){
        int i;
        String dataformatada;
        String aux = "Relatorio:";
        for(i=0;i<this.vezesrepetidas;i++){
            dataformatada = this.arraycompromissos[i].data.dataFormatada();
            aux += ("\n" + dataformatada);
        }
        return aux;
    }

    public int getVezesrepetidas() {
        return vezesrepetidas;
    }

    public int getRepetirdia() {
        return repetirdia;
    }
    public Data getData() {
        return data;
    }

    public Compromisso[] getArraycompromissos() {
        return arraycompromissos;
    }


}

