/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencampusaccounting;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.net.ssl.*;
/**
 *
 * @author ASUS
 */
public class Journal extends javax.swing.JFrame {
ImageIcon image1,image2,image3;
DefaultTableModel tbTableModel = new DefaultTableModel(new Object[]{"Date","Account Name","Debit","Credit"},0);
    /**
     * Creates new form Journal
     */
    public Journal() { setTitle("Computerized Accounting");
        initComponents();
        jTable1.getTableHeader().setFont(new Font("SansSerif",Font.BOLD,15));
        jTable1.setRowHeight(40);
        image1=new ImageIcon(getClass().getResource("journal.png"));
        image2=new ImageIcon(getClass().getResource("journal3.png"));
        image3=new ImageIcon(getClass().getResource("journal41.png"));
        jLabel1=new JLabel(image1);
        jLabel2=new JLabel(image2);
        jLabel3=new JLabel(image3);
        jLabel1.setBounds(100, 80, 250, 280);
        jLabel2.setBounds(90, 400, 350, 280);
        jLabel3.setBounds(210, -70, 200, 200);
        add(jLabel3);
        add(jLabel1);
        add(jLabel2);
        databaseJournal();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        btnReturn1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "Account Name", "Debit", "Credit"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Long.class, java.lang.Long.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 102));
        jLabel3.setText("Journal");

        btnReturn1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReturn1.setText("Return Home");
        btnReturn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturn1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)))
                        .addGap(0, 64, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReturn1)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 695, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(81, 81, 81)
                .addComponent(jLabel1)
                .addGap(136, 136, 136)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnReturn1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public void databaseJournal(){
        String url = "jdbc:mysql://localhost:3306/computerizedaccounting";
			 String username = "root";
			 String password = "wuttyeetun";
			 
			 Connection conn;
			 Statement stmt;
			 ResultSet rs;
                         String date,account,credit,debit;int price;
			 
			 String st="";
			 jTable1.setModel(tbTableModel);
                         
			 String query = "SELECT * FROM CUSTOMER";
                         //String query1="SELECT "
			// String query= "SELECT * FROM STUDENT WHERE stuaddress='Pathein'";
			 
			 try{ 
				 Class.forName("com.mysql.jdbc.Driver"); //Register JDBC driver
				 conn = DriverManager.getConnection(url, username, password); //Open a connection
				 stmt = conn.createStatement();  //creates a Statement object for sending SQL statements to the database			 
			     rs = stmt.executeQuery(query);  //Execute a query
			     
			     while(rs.next()){   //Extract data from result set
			    	 
			    	 //String rno=rs.getString(1);
			    	 date=rs.getString(2);
			      	 account=rs.getString(5);
			      	 price=rs.getInt(7);
			      	 if(price<0){
                                     credit=String.valueOf(price*(-1));debit=null;
                                     //Object []dr={date,account,debit,credit};
                                 }
                                 else{
                                     debit=String.valueOf(price);credit=null;
                                     //Object []dr={date,account,debit,credit};
                                 }
			      Object []dr={date,account,debit,credit};	
                              tbTableModel.addRow(dr);
			     }		
			     //JOptionPane.showMessageDialog(this, "Student Information\n \n"+st, this.getTitle(),JOptionPane.INFORMATION_MESSAGE);
			     rs.close(); 
			     conn.close();
			 }
			 catch (ClassNotFoundException cnfe){
			      System.out.println("Driver could not be loaded: " + cnfe);
			 }
			 catch (SQLException sqle){
			      System.out.println("SQL Exception thrown: " + sqle);
			 }
		}
        
    
    private void btnReturn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturn1ActionPerformed
        Home H=new Home();
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        H.setSize(d.width,d.height);
        dispose();
        H.setVisible(true);
    }//GEN-LAST:event_btnReturn1ActionPerformed

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
            java.util.logging.Logger.getLogger(Journal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Journal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Journal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Journal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 Journal J=new Journal();
                Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
                J.setSize(d.width,d.height);
                J.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReturn1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
