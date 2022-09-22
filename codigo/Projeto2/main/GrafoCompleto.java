public class GrafoCompleto extends Grafo{
    private int ordem;
    GrafoCompleto(String nome,int ordem){
        super(nome);
        this.ordem = ordem;
        int i,j;
        for(i=1;i<=ordem;i++) {
            Vertice novo = new Vertice(i);
            this.vertices.add(i, novo);
        }
        for(i=1;i<=ordem;i++){
            for(j=1;j<=ordem;j++){
                if(i!=j){
                    this.vertices.find(i).addAresta(j);
                }
                continue;
            }
        }

    }
    public boolean completo(){
        int i;
        Vertice[] arrayvertices = this.vertices.allElements(new Vertice[this.vertices.size()]);
        for(i=0;i<arrayvertices.length;i++){
            if (arrayvertices[i].grau() == (this.ordem - 1)) {
            } else {
                return false;
            }
        }
        return true;
    }
    public boolean euleriano(){
        int i;
        for(i=1;i<=ordem;i++){
            if(this.vertices.find(i).grau()%2!=0){
                return false;
            }
        }
        return true;
    }

    @Override
    public GrafoCompleto subGrafo(ABB<Vertice> vertices){
        GrafoCompleto subgrafo = new GrafoCompleto("Subgrafo de "+super.nome, vertices.size());
        return subgrafo;
    }


}
