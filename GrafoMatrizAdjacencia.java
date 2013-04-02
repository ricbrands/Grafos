package programagrafos;


import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ricardo
 */
public class GrafoMatrizAdjacencia {
    private int matriz[][];
    private List<Vertice> vertices;
    
    public GrafoMatrizAdjacencia(){
        matriz = new int[0][0];
        vertices = new ArrayList<>();
    }
    
    public GrafoMatrizAdjacencia(int numVertices){
        matriz = new int[numVertices][numVertices];
        vertices = new ArrayList<>(numVertices);
    }
    
    public void addVertice(Vertice verticeNovo){
        int matrizNova[][];
        if (buscaVertice(verticeNovo) == null){
            matrizNova = new int[matriz.length+1][matriz.length+1];
            for(int i=0; i<matrizNova.length; i++){
                for(int j=0; j<matrizNova.length; j++){
                    if ((i < matriz.length) && (j<matriz.length)) {
                        matrizNova[i][j] = matriz[i][j];
                    }
                    else{
                        matrizNova[i][j] = 0;
                    }
                }
            }               
            vertices.add(verticeNovo);
            matriz = matrizNova;
            JOptionPane.showMessageDialog(null, "Vértice inserido com sucesso!");
           
        }
        else{
           JOptionPane.showMessageDialog(null, "Vértice já pertence ao Grafo!");    
        }           
    }
    
    public Vertice buscaVertice(Vertice vertice){
        for(int i=0; i < matriz.length; i++){
            if (vertices.get(i).getIdentificador().equals(vertice.getIdentificador())){
                return vertices.get(i);
            }                 
        }
        return null;
    }
    
    public Vertice buscaVertice(String Identificador){        
        for(int i=0; i < matriz.length; i++){
            if (vertices.get(i).getIdentificador().equals(Identificador)){
                return vertices.get(i);
            }                 
        }
        return null;
    }
    
    public int buscaIndiceVertice(Vertice vertice){        
        for(int i=0; i < matriz.length; i++){
            if (vertices.get(i).getIdentificador().equals(vertice.getIdentificador())){
                return i;
            }                 
        }
        return -1;
    }
    
    public void inserirAresta(Vertice vi, Vertice vf){
        int indiceVi, indiceVf;
        indiceVi = buscaIndiceVertice(vi);
        indiceVf = buscaIndiceVertice(vf);
        if (indiceVi != -1){
            if (indiceVf != -1){
               matriz[indiceVi][indiceVf] = 1;
               matriz[indiceVf][indiceVi] = 1;
               JOptionPane.showMessageDialog(null, "Aresta inserida!");
            }
            else{
               JOptionPane.showMessageDialog(null, "Vértice final não encontrado!");    
            }
        }
        else{
           JOptionPane.showMessageDialog(null, "Vértice inicial não encontrado!");    
        }
    }
    
    public void excluirAresta(Vertice vi, Vertice vf){
        int indiceVi, indiceVf;
        indiceVi = buscaIndiceVertice(vi);
        indiceVf = buscaIndiceVertice(vf);
        if (indiceVi != 0){
            if (indiceVf != 0){
               matriz[indiceVi][indiceVf] = 0;
               matriz[indiceVf][indiceVi] = 0;
            }
            else{
               JOptionPane.showMessageDialog(null, "Vértice final não encontrado!");    
            }
        }
        else{
           JOptionPane.showMessageDialog(null, "Vértice inicial não encontrado!");    
        }
    }
    
    public void exibirGrafo(){
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz.length; j++){
                System.out.print(matriz[i][j]);
            }
            System.out.println();
        }
    }
    
}
