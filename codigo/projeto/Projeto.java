package projeto;

import java.sql.SQLOutput;

public class Projeto {
    public static void main(String[] args) {
        Compromisso c = new Compromisso("Pilates", "02/05/2020", 7, 4);
        Compromisso c2 = new Compromisso("Pelada", "03/05/2020", 4, 4);
        String relatorio = new Calendario().relatorioDatasSelecionadas("02/05/2020","23/05/2020");
        System.out.println(c.relatorioCompromissos());
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(c2.relatorioCompromissos());
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.println(relatorio);
    }
}
