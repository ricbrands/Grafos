package programagrafos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ricardo
 */
public class Vertice {
    private String identificador;
    
    public Vertice(String v){
	setIdentificador(v);
    }
    
    public Vertice(){	
    }
    
    public void setIdentificador(String v){
	identificador = v;
    }
    
    public String getIdentificador(){
	return this.identificador;
    }
    
}
