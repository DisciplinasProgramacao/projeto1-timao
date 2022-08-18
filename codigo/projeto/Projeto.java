package projeto;

public class Projeto {
    public static void main(String[] args) {
        Compromisso c = new Compromisso("Pilates", "20/03/2019", 7, 15);
        Compromisso c2 = new Compromisso("Pelada", "12/05/2021", 14, 8);
        //System.out.println(c.data.dataFormatada());
        c.relatorioDatas();
        System.out.println("-----------------------------------------------------------------------------------------");
        c2.relatorioDatas();
    }

}
