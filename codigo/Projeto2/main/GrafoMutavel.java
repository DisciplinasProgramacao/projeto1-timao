import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class GrafoMutavel extends Grafo{
    GrafoMutavel(String nome){
        super(nome);
    }
    public void carregar(String nomeArquivo) throws FileNotFoundException {
        int i;
        int origem, destino;
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
            addAresta(origem,destino);
        }
    }

    public void salvar(String nomeArquivo){

    }

    /**
     * Adiciona, se possível, um vértice ao grafo. O vértice é auto-nomeado com o próximo id disponível.
     */
    public boolean addVertice(int id){
        Vertice novo = new Vertice(id);
        return this.vertices.add(id, novo);
    }

    /**
     * Adiciona uma aresta entre dois vértices do grafo.
     * Não verifica se os vértices pertencem ao grafo.
     * @param origem Vértice de origem
     * @param destino Vértice de destino
     */
    public abstract boolean addAresta(int origem, int destino);

    public boolean delAresta(int origem, int destino){
        boolean deletou = false;
        Vertice saida = this.existeVertice(origem);
        Vertice chegada = this.existeVertice(destino);
        if(saida!=null && chegada !=null){
            saida.getArestas().remove(destino);
            chegada.getArestas().remove(origem);
        }
        return deletou;
    }

    public boolean delVertice(int id){
        boolean deletou = false;
        if(this.vertices.find(id)!=null){
            this.vertices.remove(id);
            deletou = true;
        }
        return deletou;
    }


}
