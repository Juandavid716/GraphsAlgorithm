/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafos;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author CORE I5 6TA
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Image ImagenFondo;
    public URL url;
    Validacion valid = new Validacion();
    public  static int contador= 0;
    public boolean sw=true,s2=true,logicA=false,logicV=false,logicB=false;
    public int VerticeElim=0;
      public int AristaElim=0;
        public int AddArista=0;
   public static int weightArray[][] = new int[20][20];
   public static int visited[] = new int [20];
 public static  int d[] = new int[20];
  public static  int p[] = new int[20];
public Nodo ObtenerNodo1=null;
public Nodo ObtenerNodo2=null;
 public static  int nodeA, nodeB, weight;
public  static  int current, total, mincost;
public Nodo vertice;
    public ArrayList<Nodo> getGrafo() {

        return grafo;
    }
      public  ArrayList<Nodo> grafo;
       public  ArrayList<Conexion> aristas;
private  int MAXIMO_VERTICES;
private  int MAXIMO_ARISTAS;

private int[][] matriz;
        public  ArrayList<Conexion> Removibles;
                public  ArrayList<pair3> RemoviblesEdge;
              public  ArrayList<Conexion> Adyacentes;
        public ArrayList<pair3> edges = new ArrayList<pair3>();
       public Point punto1,punto2;
       public  int s =1;
       public Conexion arista;
       public boolean finA= true;
    public NewJFrame() {
        initComponents();
        this.grafo = new ArrayList<>();
        this.aristas = new ArrayList<>();
        this.Removibles = new ArrayList<>();
        this.RemoviblesEdge = new ArrayList<>();
this.Adyacentes = new ArrayList<>();
        eliminararista.setVisible(false);
        eliminarvertice.setVisible(false);
        agregararista.setVisible(false);
        finalizararista.setVisible(false);
        PrimBoton.setVisible(false);
        KruskralBoton.setVisible(false);
        CostoM.setVisible(false);
         this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/ubi.png")).getImage());

    }
    int fathers[] = new int[2000];

int find(int x){
	if(fathers[x] == x){
		return x;
	}
	return find(fathers[x]);
}

void unite(int x, int y){
	int fx = find(x);
	int fy = find(y);
	fathers[fx] = fy;
}
 public void paint(Graphics g) {
  
        super.paint(g); 
         for (Nodo nodos : grafo) {
        nodos.paint(g);
    }
         
         for (Conexion c : aristas) {
             if(c.isSw()==true){
                 Graphics2D g1= (Graphics2D) g;
     g1.setColor(Color.red);
             c.paint(g1);
             } else {
                 if(c.isSw2()==true){
              
                 Graphics2D g1= (Graphics2D) g;
     g1.setColor(Color.blue);
             c.paint(g1);
                 } else {
                    Graphics2D g1= (Graphics2D) g;
     g1.setColor(Color.black);
             c.paint(g1);
                 
                 }
              
             }
    
     }
    }
 public void GrafoMatrixAdyacencia(int nroVertices, int nroAristas) {
MAXIMO_VERTICES = nroVertices;
MAXIMO_ARISTAS = nroAristas;



matriz = new int[MAXIMO_VERTICES][MAXIMO_VERTICES];

for (int i = 0; i < getMAX_VERTICES(); i++) {
for (int j = 0; j < getMAX_VERTICES(); j++) {
matriz[i][j] = 0;
}
}
}

    public int[][] getMatrix() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.println(matriz[i][j]);
            }
        }
        return matriz;
    }
public int getMAX_VERTICES() {
return MAXIMO_VERTICES;
}public boolean BuscarConexo(){
    boolean sw = false;
    int contador= 0;
            for (Nodo g : grafo) {
           
                for (Conexion c : aristas) {
                    
                     if((g.getX()==c.getX1() && g.getY()==c.getY1()|| (g.getX()==c.getX1() && g.getY()==c.getY2())||(g.getX()==c.getX2() && g.getY()==c.getY1())||(g.getX()==c.getX2() && g.getY()==c.getY2())) ){
 
         contador++;
        break;
           
        }
                }
            }
            
            if(contador==grafo.size()){
            sw = true;
            } 
return sw;
}
 public void Kruskral(int n,int m){

	
	for(int i=1;i<=1999;i++){
		fathers[i]=i;
	}

	
	int a,b;
                int w;
	

	
		int pesoMST = 0, mstAristas = 0;
	int	mst_ni = 0;
	
	 Collections.sort(edges, new Comparator<pair3>() {
	        @Override 
	        public int compare(pair3 p1, pair3 p2) {
	            return p1.w - p2.w;
	        }
	 });
boolean conexo = false;
         
	while( ( mstAristas < n-1) || (mst_ni < m) ){
           if(edges.size()>mst_ni && BuscarConexo()==true){
        
           
		a = edges.get(mst_ni).a;
               

		b = edges.get(mst_ni).b;
       
		w = edges.get(mst_ni).w;
		
		if( find(a) != find(b) ) {
			//
			unite(a,b);
		
			pesoMST += w;
			    
		
			mstAristas++;
                         for (Conexion ad : aristas) {
                if(ad.getX1()+ad.getY1()==a && ad.getX2()+ad.getY2()==b){
            ad.setSw(true);
                }
            }
		}
             
             
		
		mst_ni++;
           } else {
          conexo = true;
          break;
           }
	}
        if(conexo==true){
              JOptionPane.showMessageDialog(null, "El grafo es no conexo y por lo tanto no se puede aplicar el algoritmo de Kruskal");
        } else {
        JOptionPane.showMessageDialog(null,"La ruta minima es de "+ pesoMST+" metros");
         repaint();
        }
	

}
   private boolean Interseccion(Point p){
   Rectangle fig = new Rectangle(p.x - Nodo.distancia/2,p.y - Nodo.distancia,Nodo.distancia,Nodo.distancia);
       for (Nodo nodo : grafo) {
           if(new Rectangle(nodo.getX() - Nodo.distancia/2,nodo.getY() - Nodo.distancia,Nodo.distancia,Nodo.distancia).intersects(fig)){
           return true;
           }
       }
       return false;
   }


    public void mouseClicked(MouseEvent me) {
    
    }

    public void mousePressed(MouseEvent me) {
      
    }

    public void mouseReleased(MouseEvent me) {
       
    }

    public void mouseEntered(MouseEvent me) {
        
    }


    public void mouseExited(MouseEvent me) {
      
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jLabel2 = new javax.swing.JLabel();
        principal = new javax.swing.JPanel();
        finalizarvertice = new javax.swing.JButton();
        eliminarvertice = new javax.swing.JButton();
        agregararista = new javax.swing.JButton();
        eliminararista = new javax.swing.JButton();
        finalizararista = new javax.swing.JButton();
        KruskralBoton = new javax.swing.JButton();
        PrimBoton = new javax.swing.JButton();
        CostoM = new javax.swing.JButton();
        nuevoG = new javax.swing.JButton();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1149, 500));
        getContentPane().setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Map.PNG"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1149, 390);

        principal.setBackground(new java.awt.Color(255, 255, 255));

        finalizarvertice.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        finalizarvertice.setText("Finalizar");
        finalizarvertice.setBorder(null);
        finalizarvertice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finalizarverticeMouseClicked(evt);
            }
        });
        finalizarvertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarverticeActionPerformed(evt);
            }
        });

        eliminarvertice.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        eliminarvertice.setText("Eliminar vertices");
        eliminarvertice.setBorder(null);
        eliminarvertice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarverticeMouseClicked(evt);
            }
        });
        eliminarvertice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarverticeActionPerformed(evt);
            }
        });

        agregararista.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        agregararista.setText("Agregar Aristas");
        agregararista.setBorder(null);
        agregararista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregararistaMouseClicked(evt);
            }
        });
        agregararista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregararistaActionPerformed(evt);
            }
        });

        eliminararista.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        eliminararista.setText("Eliminar Aristas");
        eliminararista.setBorder(null);
        eliminararista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminararistaActionPerformed(evt);
            }
        });

        finalizararista.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        finalizararista.setText("Finalizar Grafo");
        finalizararista.setBorder(null);
        finalizararista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizararistaActionPerformed(evt);
            }
        });

        KruskralBoton.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        KruskralBoton.setText("Kruskral");
        KruskralBoton.setBorder(null);
        KruskralBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KruskralBotonActionPerformed(evt);
            }
        });

        PrimBoton.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        PrimBoton.setText("Prim");
        PrimBoton.setBorder(null);
        PrimBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PrimBotonActionPerformed(evt);
            }
        });

        CostoM.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        CostoM.setText("Costo minimo");
        CostoM.setBorder(null);
        CostoM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CostoMActionPerformed(evt);
            }
        });

        nuevoG.setFont(new java.awt.Font("Trebuchet MS", 0, 11)); // NOI18N
        nuevoG.setText("Nuevo grafo");
        nuevoG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout principalLayout = new javax.swing.GroupLayout(principal);
        principal.setLayout(principalLayout);
        principalLayout.setHorizontalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(PrimBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(KruskralBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(eliminarvertice, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(finalizararista, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(agregararista, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(eliminararista, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(finalizarvertice, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(CostoM, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(nuevoG)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        principalLayout.setVerticalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalLayout.createSequentialGroup()
                .addGroup(principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(principalLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(eliminararista, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, principalLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PrimBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(KruskralBoton, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(eliminarvertice, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(finalizararista, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(agregararista, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(finalizarvertice, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CostoM, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nuevoG))))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        getContentPane().add(principal);
        principal.setBounds(0, 390, 1150, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void EliminarVertices(Nodo g){

pair3 tmp2 =null;
   for (int i = 1; i <= grafo.size()+1; i++) {
       
                weightArray[i][g.getContador()] =  weightArray[g.getContador()][i] = 0;
       
        }
   
   

    for (Conexion c : aristas) {
       
        
        if((g.getX()==c.getX1() && g.getY()==c.getY1()|| (g.getX()==c.getX1() && g.getY()==c.getY2())||(g.getX()==c.getX2() && g.getY()==c.getY1())||(g.getX()==c.getX2() && g.getY()==c.getY2())) ){
           Removibles.add(c);
        
           
        }
       
 
    }
    for (Conexion x : Removibles) {
         for (pair3 pp : edges) {
           if(x.getX1()+x.getY1()==pp.a && (x.getX2()+x.getY2()==pp.b)){
          RemoviblesEdge.add(pp);

                }
    }
           this.aristas.remove(x);
    }
    
    for(pair3 px : RemoviblesEdge){
    this.edges.remove(px);
    }
    this.grafo.remove(g);
 
repaint();
}

public void EliminarArista(Nodo g){
      for (Conexion arista1 : aristas) {
            arista1.setSw(false);
            arista1.setSw2(false);
        }
    
    Conexion tmp = null; 
     pair3 tmp2 = null; 
    for (Conexion c : aristas) {
       
        
        if((g.getX()==c.getX1() && g.getY()==c.getY1()|| (g.getX()==c.getX1() && g.getY()==c.getY2())||(g.getX()==c.getX2() && g.getY()==c.getY1())||(g.getX()==c.getX2() && g.getY()==c.getY2())) ){
     tmp = c;
          
        }
    }
    for (pair3 pp : edges) {
       
        if(pp.a-tmp.getY1()==tmp.getX1() || pp.a-tmp.getY2()==tmp.getX1() || pp.a-tmp.getX2() == tmp.getX1() || pp.a-tmp.getX1()==tmp.getX1()){
        tmp2 = pp;
        }
    }
    edges.remove(tmp2);
aristas.remove(tmp);
repaint();
}
 public int compare(Conexion p1, Conexion p2) {
	            return Integer.parseInt(p1.getNombre()) - Integer.parseInt(p2.getNombre());
	        }
 public void prim(int verticeCount, int edgeCount, int  ver){

int mayorC = 0;

       for (int i = 1; i <= verticeCount; i++) {
           p[i] = visited[i] = 0;
           d[i] = 32767;
        }

        

        current = ver;
        d[current] = 0;
        total = 1;
        visited[current] = 1;
        while( total != verticeCount) {
            for (int i = 1; i <= verticeCount; i++) {
         
                if ( weightArray[current][i] != 0) {
                   
             
       
                    if( visited[i] == 0) { 
                        if (d[i] > weightArray[current][i] ) {
                       
                            d[i] = weightArray[current][i];
                           
                            p[i] = current;
                  
                        }
                       
                    }
                }
            }
            mincost=32767;
            for (int i = 1 ; i <= verticeCount; i++) {
                if (visited[i] == 0) {
                    if (d[i] < mincost) {
       
                        
                        mincost = d[i];
                 
                        current = i;
                    }
                }
            }

            visited[current]=1;
            total++;
        }

        mincost=0;



        for(int i=1;i<=verticeCount;i++){
                if(p[i]!=0){
                         for (Nodo n: grafo) {
            
                        if(n.getContador()==i){
                        ObtenerNodo1 = n;
                        }
                        if(n.getContador()==p[i]){
                        ObtenerNodo2 = n;
                        }
                    }
                         System.out.println(ObtenerNodo1+" "+ObtenerNodo2);
                    for (Conexion x : aristas) {
                                if((ObtenerNodo1.getX()==x.getX1() && ObtenerNodo1.getY()==x.getY1()&& ObtenerNodo2.getX()==x.getX2()&&ObtenerNodo2.getY()==x.getY2()) || (ObtenerNodo1.getX()==x.getX2() && ObtenerNodo1.getY()==x.getY2()&& ObtenerNodo2.getX()==x.getX1()&&ObtenerNodo2.getY()==x.getY1()) ){
                                    {
                                      
                         x.setSw2(true);
                         mincost = mincost + Integer.parseInt(x.getNombre());
                                    }
          
        }
                                
                            
                         }
                    
                    
                   
                }



        }
         JOptionPane.showMessageDialog(null,"La ruta minima es de "+ mincost+" metros");
        repaint();
 }
    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        if(!Interseccion(evt.getPoint())&& sw==true){
           boolean noRepetidos = false;
String input = JOptionPane.showInputDialog("Ingrese el nombre del vertice");
if(grafo.isEmpty()){
noRepetidos = false;
} else {

for (Nodo nodo : grafo) {
                if(nodo.getNombre().equals(input)){
                noRepetidos = true;
                }
            }
}

if(input == null || (input != null && ("".equals(input))) ){
    
JOptionPane.showMessageDialog(null, "Escriba el nombre del vertice");
}else {
    if(input.length()>10){
       JOptionPane.showMessageDialog(null, "Escriba un nombre con menos de 10 caracteres");
    } else {
        if(noRepetidos==true){
        JOptionPane.showMessageDialog(null, "Ya existe un vertice con ese nombre");
        } else {
         contador++;
       this.grafo.add(new Nodo(evt.getX(),evt.getY(),input,contador));
       
   
       repaint();
        
        }
     
    }
  
}
           
       }
        
               if(evt.getButton()== MouseEvent.BUTTON3 && s==0){
                  
             for (Nodo nodo : grafo) {

               Boolean siesta = false;
                 if(new Rectangle(nodo.getX() - Nodo.distancia/2,nodo.getY() - Nodo.distancia,Nodo.distancia,Nodo.distancia).contains(evt.getPoint())){
                    vertice = nodo;
                     if(punto1 == null){
                     punto1 = new Point(nodo.getX(),nodo.getY());
                 } else {
                 punto2 = new Point(nodo.getX(),nodo.getY());
               
                         for (Conexion x : aristas) {
                                if((punto1.x==x.getX1() && punto1.y==x.getY1()&& punto2.x==x.getX2()&&punto2.y==x.getY2()) || (punto1.x==x.getX2() && punto1.y==x.getY2()&& punto2.x==x.getX1()&&punto2.y==x.getY1()) ){
                                    {
                                    siesta = true;
                                    }
          
        }
                                
                            
                         }
                         if(siesta==false){
 
                               String op = 
                      JOptionPane.showInputDialog("Ingresa el peso de la arista");
                               if(op == null || (op != null && ("".equals(op))) ){
    
JOptionPane.showMessageDialog(null, "Agregue una arista como minimo");
} else{
              if(valid.SoloNumeros(op)==false ){
    JOptionPane.showMessageDialog(null, "Digite solo números");
    
    }                 else {    
                                    this.aristas.add(new Conexion(punto1.x,punto1.y,punto2.x,punto2.y,op,false, false));
                                   
                                edges.add(new pair3(Integer.parseInt(op),punto1.x+punto1.y,punto2.x+punto2.y));
                           
                                for (Nodo n: grafo) {
//                              
                                 if(n.getX()==punto1.x && n.getY()==punto1.y){
                                 nodeA = n.getContador();
                               
                               
                                
                             }
                                 if(n.getX()==punto2.x&&n.getY()==punto2.y){
                                     nodeB = n.getContador();
                              
                                 }
                                }
           
            weight= Integer.parseInt(op);
                   
            weightArray[nodeA][nodeB]  = weightArray[nodeB][nodeA] = weight;
                               }
                         }
                                } else {
                         JOptionPane.showMessageDialog(null,"Ya se encuentra una arista");
                         }
            
         repaint();
       vertice = nodo;
                 punto1= null; 
                 punto2 = null; 
                 }
                   
                     
                 
                 } 
                
             }
               }
       
        Nodo temp = null;
      
        
         if(evt.getButton()== MouseEvent.BUTTON3 ){
          
             for (Nodo nodo : grafo) {
        
                 if(new Rectangle(nodo.getX() - Nodo.distancia/2,nodo.getY() - Nodo.distancia,Nodo.distancia,Nodo.distancia).contains(evt.getPoint())){
               if(logicV==true){
                 
                    VerticeElim++;
                 
               }
                  vertice = nodo;
                  
                   if(logicA==true){
                         AristaElim++;
                   }
                  
                
                 } 
                
             }
             
         
               
      }
    }//GEN-LAST:event_jLabel2MouseClicked

    private void finalizarverticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarverticeActionPerformed
// Panel2 p = new Panel2();
// p.setSize(1100,50);
// principal.removeAll();
// principal.add(p);
//principal.revalidate();
//principal.repaint();
if(!grafo.isEmpty()){
sw = false;
s2 = false;
    finalizarvertice.setVisible(false);
   agregararista.setVisible(true);
   finalizararista.setVisible(true);

 for (int i = 1; i <= grafo.size(); i++) {
            for(int j = 1; j <= grafo.size(); j++) {
                weightArray[i][j] = 0;
            }
        }
} else {

JOptionPane.showMessageDialog(null, "Agregue un nodo como minimo");
}

    }//GEN-LAST:event_finalizarverticeActionPerformed

    private void eliminarverticeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarverticeActionPerformed
   for (Conexion arista1 : aristas) {
            arista1.setSw(false);
            arista1.setSw2(false);
        }
        
        AristaElim = 0;      
        if(VerticeElim>0){
            
        EliminarVertices(vertice);
        } else {
          JOptionPane.showMessageDialog(null, "Selecciona el vertice a eliminar");
           logicV = true;
        }
        if(grafo.isEmpty()){
          JOptionPane.showMessageDialog(null, "No hay vertices para eliminar");
        }
        

    }//GEN-LAST:event_eliminarverticeActionPerformed

    private void eliminarverticeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarverticeMouseClicked
 
    }//GEN-LAST:event_eliminarverticeMouseClicked

    private void agregararistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregararistaMouseClicked

    }//GEN-LAST:event_agregararistaMouseClicked

    private void eliminararistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminararistaActionPerformed
    
        if(AristaElim>0){
            
       EliminarArista(vertice);
        } else {
          JOptionPane.showMessageDialog(null, "Selecciona los dos vertices que unen la arista a eliminar");
          logicA = true;
        }
        if(aristas.isEmpty()){
          JOptionPane.showMessageDialog(null, "No hay aristas para eliminar");
        }

    }//GEN-LAST:event_eliminararistaActionPerformed

    private void finalizararistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizararistaActionPerformed
   if(!aristas.isEmpty()){
 AristaElim = 0;
   CostoM.setVisible(true);
        s = -1;    
finA = false;
eliminararista.setVisible(true);
eliminarvertice.setVisible(true);
finalizararista.setVisible(false);
agregararista.setVisible(false);
GrafoMatrixAdyacencia(grafo.size(),aristas.size());
} else {

JOptionPane.showMessageDialog(null, "Agregue una arista como minimo");
}
        
       
    }//GEN-LAST:event_finalizararistaActionPerformed

    private void agregararistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregararistaActionPerformed
 if(AddArista>0){
            
      s = 0;
        } else {
          JOptionPane.showMessageDialog(null, "Selecciona  dos vertices con clic derecho para agregar una arista ");
            s = 0;
          AddArista++;
        }     
    }//GEN-LAST:event_agregararistaActionPerformed

    private void finalizarverticeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finalizarverticeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_finalizarverticeMouseClicked

    private void KruskralBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KruskralBotonActionPerformed
        for (Conexion arista1 : aristas) {
            arista1.setSw(false);
            arista1.setSw2(false);
        }
        Kruskral(grafo.size(),aristas.size());
    }//GEN-LAST:event_KruskralBotonActionPerformed

    private void PrimBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PrimBotonActionPerformed
String v = JOptionPane.showInputDialog("Ingresa el vertice de origen");
int cont = 0;
boolean logic = false;
for(Nodo p : grafo){
if(p.getNombre().equals(v)){
logic = true;
 cont = p.getContador();
break;
}

}
if(logic==true){
  for (Conexion arista1 : aristas) {
            arista1.setSw(false);
            arista1.setSw2(false);
        }
        prim(grafo.size()+1,aristas.size(),cont);

} else {
JOptionPane.showMessageDialog(null, "No existe un nodo con ese nombre");
}

    }//GEN-LAST:event_PrimBotonActionPerformed

    private void CostoMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CostoMActionPerformed
      PrimBoton.setVisible(true);
      KruskralBoton.setVisible(true);
    }//GEN-LAST:event_CostoMActionPerformed

    private void nuevoGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoGActionPerformed
  sw = true;
  s = -1;
      finalizarvertice.setVisible(true);
      eliminararista.setVisible(false);
eliminarvertice.setVisible(false);
finalizararista.setVisible(false);
agregararista.setVisible(false);
CostoM.setVisible(false);
PrimBoton.setVisible(false);
KruskralBoton.setVisible(false);
      edges.clear();
      grafo.clear();
      RemoviblesEdge.clear();
      aristas.clear();
      Removibles.clear();
      Adyacentes.clear();
      contador = 0;
      VerticeElim = 0;
      AristaElim = 0;
      AddArista = 0;
      repaint();
    }//GEN-LAST:event_nuevoGActionPerformed
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CostoM;
    private javax.swing.JButton KruskralBoton;
    private javax.swing.JButton PrimBoton;
    private javax.swing.JButton agregararista;
    private javax.swing.JButton eliminararista;
    private javax.swing.JButton eliminarvertice;
    private javax.swing.JButton finalizararista;
    private javax.swing.JButton finalizarvertice;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JButton nuevoG;
    private javax.swing.JPanel principal;
    // End of variables declaration//GEN-END:variables

    private Nodo ObtenerGrafo(Nodo nodo) {
return nodo;
    }
}
