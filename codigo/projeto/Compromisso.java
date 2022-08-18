package projeto;

public class Compromisso {
    public String nomecompromisso;

    public String datanaoformatada;
    public Data data;
    public int repetirdia;
    public int vezesrepetidas;
    public Data[] datacompromissos;

    //public RepetirCompromisso repetir;
    Compromisso(String n, String d, int r, int v) {
        this.nomecompromisso = n;
        this.data = formatarData(d);
        this.repetirdia = r;
        this.vezesrepetidas = v;
        this.datacompromissos = repetirCompromisso(r,v);
        //this.repetir = new RepetirCompromisso(n,data,r,v);
    }

    Compromisso(String n, Data d) {
        this.nomecompromisso = n;
        this.data = d;
    }

    Compromisso() {
    }

    public Data[] repetirCompromisso(int r, int v){
        Data arraydata[] = new Data[v];
        arraydata[0] = this.data;
        Data aux = new Data(this.data.dia,this.data.mes,this.data.ano);
        int i;
        int j;
        for(i=1;i<v;i++){
            for(j=0;j<r;j++){
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

    public void relatorioDatas(){
        int i;
        String dataformatada;
        for(i=0;i<this.vezesrepetidas;i++){
            dataformatada = this.datacompromissos[i].dataFormatada();
            System.out.println(dataformatada);
        }
    }

    public Data formatarData(String datanaoformatada) {

        String[] detalhes = datanaoformatada.split("/");
        int dia = Integer.parseInt(detalhes[0]);
        int mes = Integer.parseInt(detalhes[1]);
        int ano = Integer.parseInt(detalhes[2]);

        data = new Data(dia, mes, ano);

        return data;
    }


}
