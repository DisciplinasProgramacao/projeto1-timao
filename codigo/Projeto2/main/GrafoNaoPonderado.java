public class GrafoNaoPonderado extends GrafoMutavel {

    GrafoNaoPonderado(String nome){
        super(nome);
    }

    @Override
    public boolean addAresta(int origem, int destino){
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
        GrafoNaoPonderado subgrafo = new GrafoNaoPonderado("Subgrafo de "+this.nome);
        Vertice[] arrayvertices = this.vertices.allElements(new Vertice[this.vertices.size()]);
        int i,j;
        for(i=0;i<arrayvertices.length;i++){
            if(vertices.find(arrayvertices[i].getId())!=null){
                subgrafo.addVertice(arrayvertices[i].getId());
                for(j=0;j<arrayvertices.length;j++){
                    if(existeAresta(arrayvertices[i].getId(),arrayvertices[j].getId())!=null){
                        if(vertices.find(arrayvertices[j].getId()) != null && vertices.find(arrayvertices[j].getId())!=vertices.find(arrayvertices[i].getId())) {
                            subgrafo.addAresta(arrayvertices[i].getId(), arrayvertices[j].getId());
                        }
                    }
                }
            }
        }
        return subgrafo;
    }

}
