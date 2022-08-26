package projeto;

public class Calendario {

    private static Compromisso[] arrayCalendario = new Compromisso[0];

    private Data diaInicio;

    private Data diaFim;


    Calendario(Compromisso[] arrayCompromissos){
        arrayCalendario = mergearrayCalendario(arrayCompromissos, Calendario.arrayCalendario);
        arrayCalendario = sortArrayCalendario(Calendario.arrayCalendario);

    }

    Calendario(){

    }

    public String relatorioDatasSelecionadas(String diaInicio, String diaFim){
        this.diaInicio = new Data().desformatarData(diaInicio);
        this.diaFim = new Data().desformatarData(diaFim);
        int i;
        String aux = ("Relatorio dos Compromissos entre os dias " + this.diaInicio.dataFormatada() + " e " + this.diaFim.dataFormatada() + ":");
        for(i=0;i<Calendario.arrayCalendario.length;i++){
            if(this.diaInicio.getAno() <= Calendario.arrayCalendario[i].getData().getAno() && this.diaFim.getAno() >= Calendario.arrayCalendario[i].getData().getAno()){
                if(this.diaInicio.getMes() <= Calendario.arrayCalendario[i].getData().getMes() && this.diaFim.getMes() >= Calendario.arrayCalendario[i].getData().getMes()){
                    if(this.diaInicio.getDia() <= Calendario.arrayCalendario[i].getData().getDia() && this.diaFim.getDia() >= Calendario.arrayCalendario[i].getData().getDia()){
                        aux += ("\n" + Calendario.arrayCalendario[i].getData().dataFormatada());
                    }
                }
            }
        }
        return aux;
    }




    private Compromisso[] sortArrayCalendario(Compromisso[] arrayCalendario) {
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



    private Compromisso[] mergearrayCalendario(Compromisso[] arrayCompromissos, Compromisso[] arrayCalendario){
        int array1 = arrayCompromissos.length;
        int array2 = arrayCalendario.length;
        Compromisso[] aux = new Compromisso[array1+array2];
        System.arraycopy(arrayCalendario, 0, aux, 0, array2);
        System.arraycopy(arrayCompromissos, 0, aux, array2, array1);
        arrayCalendario = aux;
        return arrayCalendario;
    }



}
