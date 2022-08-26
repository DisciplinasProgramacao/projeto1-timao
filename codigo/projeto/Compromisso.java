package projeto;

public class Compromisso {
    private String nomecompromisso;
    private Data data;
    private int repetirdia;
    private int vezesrepetidas;
    private Data[] arraydatas;
    private Compromisso[] arraycompromissos;

    Compromisso(String nomecompromisso, String datanaoformatada, int repetirdia, int vezesrepetidas) {
        this.nomecompromisso = nomecompromisso;
        this.data = new Data().desformatarData(datanaoformatada);
        this.arraydatas=data.criarArrayData(this.data,repetirdia,vezesrepetidas);
        this.repetirdia = repetirdia;
        this.vezesrepetidas = vezesrepetidas;
        this.arraycompromissos = criarArrayCompromissos(this.arraydatas,this.nomecompromisso,this.vezesrepetidas);
        new Calendario(this.arraycompromissos);
    }
    Compromisso(String n, Data d) {
        this.nomecompromisso = n;
        this.data = d;
    }
    private Compromisso[] criarArrayCompromissos(Data arraydatas[],String nomecompromisso,int vezesrepetidas){
        Compromisso arraycompromissos[] = new Compromisso[vezesrepetidas];
        int i;
        Data aux;
        for(i=0;i<vezesrepetidas;i++){
            arraycompromissos[i] = new Compromisso(nomecompromisso,arraydatas[i]);
        }
        return arraycompromissos;
    }

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


    public Data getData() {
        return data;
    }


}
