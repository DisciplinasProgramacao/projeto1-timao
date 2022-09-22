import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GrafoPonderado extends GrafoMutavel{

    GrafoPonderado(String nome){
        super(nome);
    }

    public void carregar(String nomeArquivo) throws FileNotFoundException {
        int i;
        int origem, destino, peso;
        int numvertices;
        Scanner leitor = new Scanner(new File(nomeArquivo));
        String linha = leitor.nextLine();
        numvertices = Integer.parseInt(linha);
        for(i=1;i<=numvertices;i++){
            addVertice(i);
        }
        while(leitor.hasNextLine()){
            linha = leitor.nextLine();
            String [] detalhes = linha.split(";");
            origem = Integer.parseInt(detalhes[0]);
            destino = Integer.parseInt(detalhes[1]);
            peso = Integer.parseInt(detalhes[2]);
            addAresta(origem,destino,peso);
        }
    }

    public boolean addAresta(int origem, int destino, int peso) {
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if(saida!=null && chegada !=null){
            saida.addAresta(destino,peso);
            chegada.addAresta(origem,peso);
            adicionou = true;
        }
        return adicionou;
    }

    @Override
    public boolean addAresta(int origem, int destino) {
        boolean adicionou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if(saida!=null && chegada !=null){
            saida.addAresta(destino);
            chegada.addAresta(origem);
            adicionou = true;
        }
        return adicionou;
    }

    @Override
    public Grafo subGrafo(ABB<Vertice> vertices){
        GrafoPonderado subgrafo = new GrafoPonderado("Subgrafo de "+this.nome);
        Vertice[] arrayvertices = this.vertices.allElements(new Vertice[this.vertices.size()]);
        int i,j;
        for(i=0;i<arrayvertices.length;i++){
            if(vertices.find(arrayvertices[i].getId())!=null){
                subgrafo.addVertice(arrayvertices[i].getId());
                for(j=0;j<arrayvertices.length;j++){
                    if(existeAresta(arrayvertices[i].getId(),arrayvertices[j].getId())!=null){
                        if(vertices.find(arrayvertices[j].getId()) != null && vertices.find(arrayvertices[j].getId())!=vertices.find(arrayvertices[i].getId())) {
                            subgrafo.addAresta(arrayvertices[i].getId(), arrayvertices[j].getId(),existeAresta(arrayvertices[i].getId(),arrayvertices[j].getId()).peso());
                        }
                    }
                }
            }
        }
        return subgrafo;
    }


}
