package programagrafos;


import programagrafos.Vertice;
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
    
}
