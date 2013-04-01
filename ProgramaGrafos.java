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
            , btoMostrarGrafo, btoBuscarVertice, btoAdicionarAresta;
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
        btoCriarGrafoMatrizAdjacencia.addActionListener(this);
        btoAdicionarVertice.addActionListener(this);
        btoMostrarGrafo.addActionListener(this);
        btoBuscarVertice.addActionListener(this);
        btoAdicionarAresta.addActionListener(this);
        btoCriarGrafoMatrizAdjacencia.setBounds(725, 300, 150, 25);
        btoAdicionarVertice.setBounds(725, 330, 150, 25);
        btoMostrarGrafo.setBounds(725, 360, 150, 25);
        btoBuscarVertice.setBounds(725, 390, 150, 25);
        btoAdicionarAresta.setBounds(725, 420, 150, 25);
        this.add(btoCriarGrafoMatrizAdjacencia);
        this.add(btoAdicionarVertice);
        this.add(btoMostrarGrafo);
        this.add(btoBuscarVertice);
        this.add(btoAdicionarAresta);
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
            if (grafo != null){
                String IdentificadorAresta1 = JOptionPane.showInputDialog("Identificador do vértice:");
                if (grafo.buscaVertice(IdentificadorAresta1) != null){
                    
                }
            }
            else{
                JOptionPane.showMessageDialog(null, "É necessário criar o grafo primeiro!");    
            }            
        }
    }
    
}
