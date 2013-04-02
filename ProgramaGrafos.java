package programagrafos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Ricardo
 */
public class ProgramaGrafos extends JFrame implements ActionListener{
    JButton btoCriarGrafoMatrizAdjacencia, btoAdicionarVertice
            , btoMostrarGrafo, btoBuscarVertice, btoAdicionarAresta
            , btoExibirGrafo;
    GrafoMatrizAdjacencia grafo;
    Vertice vertice;

    public ProgramaGrafos(){
        super("Grafos");
        inicializarComponentes();
    }
    
    private void inicializarComponentes(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(900,600);
        btoCriarGrafoMatrizAdjacencia = new JButton("Criar Grafo");
        btoAdicionarVertice = new JButton("Adicionar Vértice");
        btoMostrarGrafo = new JButton("Mostrar Grafo");
        btoBuscarVertice = new JButton("Buscar vértice");
        btoAdicionarAresta = new JButton("Adicionar Aresta");
        btoExibirGrafo = new JButton("Exibir Grafo");
        btoCriarGrafoMatrizAdjacencia.addActionListener(this);
        btoAdicionarVertice.addActionListener(this);
        btoMostrarGrafo.addActionListener(this);
        btoBuscarVertice.addActionListener(this);
        btoAdicionarAresta.addActionListener(this);
        btoExibirGrafo.addActionListener(this);
        btoCriarGrafoMatrizAdjacencia.setBounds(725, 300, 150, 25);
        btoAdicionarVertice.setBounds(725, 330, 150, 25);
        btoMostrarGrafo.setBounds(725, 360, 150, 25);
        btoBuscarVertice.setBounds(725, 390, 150, 25);
        btoAdicionarAresta.setBounds(725, 420, 150, 25);
        btoExibirGrafo.setBounds(725, 450, 150, 25);
        this.add(btoCriarGrafoMatrizAdjacencia);
        this.add(btoAdicionarVertice);
        this.add(btoMostrarGrafo);
        this.add(btoBuscarVertice);
        this.add(btoAdicionarAresta);
        this.add(btoExibirGrafo);
    }
    
    public static void main(String[] args) {
        ProgramaGrafos programaPrincipal = new ProgramaGrafos();
        programaPrincipal.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(btoCriarGrafoMatrizAdjacencia == e.getSource()){
            if (grafo == null){
                grafo = new GrafoMatrizAdjacencia();
                JOptionPane.showMessageDialog(null, "Grafo criado!");
            }
            else{
                JOptionPane.showMessageDialog(null, "Grafo já existe!");
            }
        }
        if(btoAdicionarVertice == e.getSource()){
            if (grafo != null){
                vertice = new Vertice();
                vertice.setIdentificador(JOptionPane.showInputDialog("Identificador do vértice:"));
                grafo.addVertice(vertice);
            }
            else{
                JOptionPane.showMessageDialog(null, "É necessário criar o grafo primeiro!");    
            }
        }
        if(btoBuscarVertice == e.getSource()){
            if (grafo != null){
                String Identificador;
                Identificador = JOptionPane.showInputDialog("Identificador do vértice:");
                if(grafo.buscaVertice(Identificador) != null){
                    JOptionPane.showMessageDialog(null, "Vértice achado!");    
                }
                else{
                    JOptionPane.showMessageDialog(null, "Vértice NÃO achado!");    
                }                   
            }
            else{
                JOptionPane.showMessageDialog(null, "É necessário criar o grafo primeiro!");
            }
        }
        if(btoAdicionarAresta == e.getSource()){
            Vertice vi, vf;
            if (grafo != null){                
                vi = grafo.buscaVertice(JOptionPane.showInputDialog("Identificador do 1o vértice:"));
                if (vi != null){
                    vf = grafo.buscaVertice(JOptionPane.showInputDialog("Identificador do 2o vértice:"));
                    if (vf != null){
                        grafo.inserirAresta(vi, vf);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Vértice 2 não encontrado!");    
                    }
                }
                else{
                   JOptionPane.showMessageDialog(null, "Vértice 1 não encontrado!"); 
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "É necessário criar o grafo primeiro!");    
            }            
        }
        if(btoExibirGrafo == e.getSource()){
            grafo.exibirGrafo();
        }
    }
    
}
