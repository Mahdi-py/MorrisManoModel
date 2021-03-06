/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dobler
 */
public class MemoryInterface2 extends javax.swing.JFrame {

    /**
     * Creates new form MemoryInterface2
     */
    Memory m = new Memory ();
    public MemoryInterface2(Memory m) {
        this.m=m;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Memory");

        jButton1.setText("Search");
        
        jButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Vector data= new Vector();
                 m.FillData(data);
                
                 Vector column= new Vector();
                 for(int i= 0 ; i <= 255 ; i++) {
                     String hex = Integer.toHexString(i);
                     if(hex.length()==1) hex="0"+hex.toUpperCase();
                     else  hex=hex.toUpperCase();
                     column.add(hex);
                 }
                
                
                DefaultTableModel InvModel = new DefaultTableModel(data,column);
                 jTable1.setModel(InvModel);
                 jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 jTable1.setRowSelectionAllowed(true);
                 jTable1.setBackground(Color.WHITE);
                 jTable1.setOpaque(true);
                 jTable1.setDefaultEditor(Object.class, null); // to endable editing
                 jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                
                
                
               String hex = jTextField1.getText();
               try { 
                    int num=Integer.parseInt(hex,16); 
                    int row = Integer.parseInt(""+hex.charAt(0),16);
                    int coulmn = Integer.parseInt(""+hex.charAt(1)+hex.charAt(2),16);
                    if(hex.length()>3) { JOptionPane.showMessageDialog(null, "Size should be 3 digits only", "Failure", JOptionPane.ERROR_MESSAGE);    }
                    else  {
                    jTable1.changeSelection(row, coulmn, false, false); // row, column
                    jTable1.requestFocus();
                            }
                   
               }
               catch (Exception e) {
                   JOptionPane.showMessageDialog(null, "uncompitible type", "Failure", JOptionPane.ERROR_MESSAGE); 
               }
                
              
               
            
            }
        }) ;
         Vector data= new Vector();
                 m.FillData(data);
                
                 Vector column= new Vector();
                 for(int i= 0 ; i <= 255 ; i++) {
                     String hex = Integer.toHexString(i);
                     if(hex.length()==1) hex="0"+hex.toUpperCase();
                     else  hex=hex.toUpperCase();
                     column.add(hex);
                 }
                 
                 System.out.print(column.toString());
                 System.out.print(data.toString());
        
        DefaultTableModel InvModel = new DefaultTableModel(data,column);
                 jTable1.setModel(InvModel);
                 jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 jTable1.setRowSelectionAllowed(true);
                 jTable1.setBackground(Color.WHITE);
                 jTable1.setOpaque(true);
                 jTable1.setDefaultEditor(Object.class, null); // to endable editing
                 jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Address:");

        jLabel2.setText("Data    :");

        jButton2.setText("Update");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String Address = jTextField2.getText();
                String Data = jTextField3.getText();
                boolean err=false;
                try {
                    int a = Integer.parseInt(Address,16);
                    int d = Integer.parseInt(Data,16);
                }catch (Exception e ) {
                    err=true;
                }
                if(Data.equals("")||Address.equals("")||Data.length()>4||Address.length()>3||err) {JOptionPane.showMessageDialog(null, "Invalid input", "Failure", JOptionPane.ERROR_MESSAGE);}
                else {
                    
                m.Update(Address, Data);   
                 Vector data= new Vector();
                 m.FillData(data);
                
                 Vector column= new Vector();
                 for(int i= 0 ; i <= 255 ; i++) {
                     String hex = Integer.toHexString(i);
                     if(hex.length()==1) hex="0"+hex.toUpperCase();
                     else  hex=hex.toUpperCase();
                     column.add(hex);
                 }
                 
                 System.out.print(column.toString());
                 System.out.print(data.toString());
        
        DefaultTableModel InvModel = new DefaultTableModel(data,column);
                 jTable1.setModel(InvModel);
                 jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 jTable1.setRowSelectionAllowed(true);
                 jTable1.setBackground(Color.WHITE);
                 jTable1.setOpaque(true);
                 jTable1.setDefaultEditor(Object.class, null); // to endable editing
                 jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                
                
                
                }
            }
        });
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                                    .addComponent(jTextField3))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }

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
            java.util.logging.Logger.getLogger(MemoryInterface2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemoryInterface2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemoryInterface2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemoryInterface2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
      //  new MemoryInterface2().setVisible(true);
    }

   
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
   
}
