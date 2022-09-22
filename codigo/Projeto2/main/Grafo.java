/** 
 * MIT License
 *
 * Copyright(c) 2021 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Classe básica para um Grafo simples
 */
public abstract class Grafo {
    public final String nome;
    ABB<Vertice> vertices;

    /**
     * Construtor. Cria um grafo vazio com capacidade para MAX_VERTICES
     */
    public Grafo(String nome){
        this.nome = nome;
        this.vertices = new ABB<>();
    }

    public Vertice existeVertice(int idVertice){
        return this.vertices.find(idVertice);
    }

    public Aresta existeAresta(int verticeA, int verticeB){
       if(this.vertices.find(verticeA).existeAresta(verticeB)!=null){
           return this.vertices.find(verticeA).existeAresta(verticeB);
       }
       return null;
    }
    
    /**
     * Verifica se este é um grafo completo. 
     * @return TRUE para grafo completo, FALSE caso contrário
     */
    public boolean completo(){
        int i;
        Vertice[] arrayvertices = this.vertices.allElements(new Vertice[this.vertices.size()]);
        for(i=0;i<arrayvertices.length;i++){
            if (arrayvertices[i].grau() == (ordem() - 1)) {
            } else {
                return false;
            }
        }
        return true;
    }

//    public boolean euleriano(){
//        int i;
//        Vertice[] arrayvertices = this.vertices.allElements(new Vertice[this.vertices.size()]);
//        for(i=0;i< arrayvertices.length;i++){
//            if()
//        }
//    }

    public abstract Grafo subGrafo(ABB<Vertice> vertices);
    
    public int tamanho(){
        int i;
        int tamanho = 0;
        Vertice[] arrayvertices = this.vertices.allElements(new Vertice[this.vertices.size()]);
        for(i=0;i<arrayvertices.length;i++){
            tamanho += arrayvertices[i].grau();
        }
        tamanho/=2;
        tamanho+=ordem();
        return tamanho;
    }

    public int ordem(){
        return this.vertices.size();
    }
}
