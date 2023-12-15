/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencampusaccounting;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Purchase extends javax.swing.JFrame {

    /**
     * Creates new form Purchase
     */
    public Purchase() { setTitle("Computerized Accounting");
        initComponents();
        addFunction();
    }
    String [][]item={{"Unicorn Cupcake","700"},{"Egg Tart","500"},{"DIY and dcorate","600"},{"Strawberry Yogurt","900"},{"Berry Yogurt","750"},
                {"Grape Yogurt","750"},{"Fruity Yogurt","900"},{"Strawberry Ice_cream","950"},{"Chocolate Ice_cream","800"},{"Vanila Ice_cream","800"},
                {"Sushi","1000"},{"Key_Chain","600"},{"UIT_Book","350"}};
    public void addFunction()
    {
        Date date = new Date();
        lblInputDate2.setText(String.valueOf(date.toLocaleString()));
        for(int i=0;i<13;i++)
            cbSelected.addItem(item[i][0]);
        cbSale.addItem("Cash");
        cbSale.addItem("Cheque");
        cbSale.addItem("Credit");
        cbSelected.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent event){
            JComboBox comboBox=(JComboBox)event.getSource();
            String output=item[comboBox.getSelectedIndex()][1];
            lblprice.setText(output);
        }
        });
        txtName.addFocusListener(new FocusListener()
                {
                    public void focusGained(FocusEvent e){
                        txtName.setText("");
                    }
                    public void focusLost(FocusEvent e){
                       if(txtName.getText().isEmpty())
                        {
                            txtName.setText("Enter Supplier Name");
                        }
                    }
                });
        txtInvoice.addFocusListener(new FocusListener()
                {
                    public void focusGained(FocusEvent e){
                        txtInvoice.setText("");
                    }
                    public void focusLost(FocusEvent e){
                       if(txtInvoice.getText().isEmpty())
                        {
                            txtInvoice.setText("Enter Invoice No");
                        }
                    }
                });
        txtqty.addFocusListener(new FocusListener()
                {
                    public void focusGained(FocusEvent e){
                        lblqty.setText("Qty");
                        txtqty.setText("");
                    }
                    public void focusLost(FocusEvent e){
                       if(txtqty.getText().isEmpty())
                        {
                            lblqty.setText("");
                            txtqty.setText("Qty");
                        }
                    }
                });
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPurchase = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPurchase = new javax.swing.JTable();
        txtInvoice = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtqty = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblprice = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnDone = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbSale = new javax.swing.JComboBox<>();
        lblInvoice = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblqty = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbSelected = new javax.swing.JComboBox<>();
        btnSave = new javax.swing.JButton();
        lblAmount = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblInputDate2 = new javax.swing.JLabel();
        btnSave1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtPurchase.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        txtPurchase.setForeground(new java.awt.Color(255, 51, 51));
        txtPurchase.setText("Purchase");
        txtPurchase.setAlignmentX(1000.0F);

        tblPurchase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Item No", "Item Name", "Qty", "Amount"
            }
        ));
        jScrollPane1.setViewportView(tblPurchase);

        txtInvoice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtInvoice.setText("AutoIncreament");
        txtInvoice.setEnabled(false);
        txtInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtInvoiceActionPerformed(evt);
            }
        });

        txtName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtName.setText("Enter Supplier Name");
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });

        txtqty.setText("Qty");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("x");

        lblprice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblprice.setText("price");

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("=");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnDone.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDone.setText("Done");
        btnDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoneActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Purchased By");

        cbSale.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        lblInvoice.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblInvoice.setText("Invoice No");

        lblName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblName.setText("Supplier Name");

        lblqty.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Select Item");

        cbSelected.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        lblAmount.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblAmount.setText("amount");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Date");

        lblInputDate2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnSave1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnSave1.setText("Return Home");
        btnSave1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSave1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(117, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtName, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                        .addComponent(txtInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblInputDate2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(203, 203, 203))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(101, 101, 101)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblqty, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel1))
                                    .addComponent(jLabel4))
                                .addGap(26, 26, 26)
                                .addComponent(lblprice, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(lblAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(254, 254, 254)
                                .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(402, 402, 402))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(cbSale, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(646, 646, 646)
                        .addComponent(txtPurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(btnSave1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(txtPurchase, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblInputDate2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbSelected, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblqty, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtqty, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton1)))
                                    .addComponent(lblAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblprice, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnDone, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbSale, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(btnSave)
                        .addGap(8, 8, 8)
                        .addComponent(btnSave1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int amount = Integer.parseInt(lblprice.getText())*Integer.parseInt(txtqty.getText());
                     lblAmount.setText(String.valueOf(amount));
    }//GEN-LAST:event_jButton1ActionPerformed
DefaultTableModel tbTableModel = new DefaultTableModel(new Object[]{"Item No","Item Name","Qty","Amount"},0);
int i=1,total=0;
String itemName="", qty="", price2="";
    private void btnDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoneActionPerformed
        // TODO add your handling code here:
        if(i!=1)
        {
          tbTableModel.getDataVector().removeElementAt(i-1);  
        }
        tblPurchase.setModel(tbTableModel);
        Object []dr={i,cbSelected.getSelectedItem(),txtqty.getText(),lblAmount.getText()};
                i++;
                total+=Integer.parseInt(lblAmount.getText());
            tbTableModel.addRow(dr);
            tbTableModel.addRow(new Object[]{"","Total","",String.valueOf(total)});
            itemName+=cbSelected.getSelectedItem()+"\n";  
            qty+=txtqty.getText()+"\n";
            price2+=lblAmount.getText()+"\n";
    }//GEN-LAST:event_btnDoneActionPerformed

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void txtInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtInvoiceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtInvoiceActionPerformed
public int DatbasePurchase(int year,int month, int date,String Name,String Item,String acc,String qty,String price3)
{
    String url = "jdbc:mysql://localhost:3306/computerizedaccounting";
    String username = "root";
    String password = "wuttyeetun";
    Connection conn;
    Statement stmt;
    String NameAcc = String.valueOf(txtName.getText())+" A/C";
    System.out.println(NameAcc);
    if(acc=="Cash A/C" || acc=="Cheque A/C" || acc.equals(NameAcc)){
                            price3=String.valueOf(Integer.parseInt(price3)*(-1));
                           }
    String query="INSERT INTO CUSTOMER(date,cname,item,account,qty,price) VALUES('"+String.valueOf(year)+'/'+String.valueOf(month)+'/'+String.valueOf(date)+"'"+",'"+Name+"','"+Item+"','"+acc+"',"+qty+","+price3+");";
    try{			 
			 conn = DriverManager.getConnection(url, username, password);
			 stmt = conn.createStatement();
                         int res=stmt.executeUpdate(query);	
		     //if(res==1) 
                       // JOptionPane.showMessageDialog(this, "Successfully Insert!");
		     conn.close();
                     return res;
		 }
		 catch (SQLException sqle){
		      System.out.println("SQL Exception thrown: " + sqle);
                      return 0;
		 }
}
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        tbTableModel.getDataVector().removeAllElements();
        tblPurchase.revalidate();
        tblPurchase.repaint();
        String Name = String.valueOf(txtName.getText());
        //String acc[] = null;
        String acc[]={"",""};
        Date d=new Date();
        int date = d.getDate();
        int month = d.getMonth()+1;
        int year = d.getYear()+1900;
        String query;
        String Success="";
        String itemName2[]=itemName.split("\n");
        String qty2[]=qty.split("\n");
        if(cbSale.getSelectedItem()=="Cash"){
            acc[0]="Cash A/C";
        }
        else if(cbSale.getSelectedItem()=="Cheque")
            acc[0]="Cheque A/C";
        else if(cbSale.getSelectedItem()=="Credit")
            acc[0]=Name+" A/C";
        String price3[]=price2.split("\n");
        int accControl = 0;
        //acc[1]=
             for(int i=0; i<itemName2.length*2;i++){
                double index = Math.floor(i/2);
                int index2 = (int)index;
                acc[1]=itemName2[index2]+" A/C";
                Success+=String.valueOf(DatbasePurchase(year, month, date, Name, itemName2[index2], acc[accControl],qty2[index2] , price3[index2]));
                if(accControl==0)
                    accControl=1;
                else
                    accControl=0;
              }
             if(!Success.contains("0"))
                    JOptionPane.showMessageDialog(this, "Successfully Insert!");
        txtInvoice.setText("");
        txtName.setText("");
        txtqty.setText("");
        total=0;
        itemName="";
        qty="";
        price2="";
        i=1;
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSave1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSave1ActionPerformed
        Home H=new Home();
        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        H.setSize(d.width,d.height);
        dispose();
        H.setVisible(true);
    }//GEN-LAST:event_btnSave1ActionPerformed

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
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Purchase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Purchase frame = new Purchase();
                Dimension screen;
                screen = Toolkit.getDefaultToolkit().getScreenSize();
               frame.setSize(screen.width,screen.height);
               frame.setTitle("Computerized Accounting");
                frame.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDone;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSave1;
    public javax.swing.JComboBox<String> cbSale;
    public javax.swing.JComboBox<String> cbSelected;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel lblAmount;
    public javax.swing.JLabel lblInputDate2;
    public javax.swing.JLabel lblInvoice;
    public javax.swing.JLabel lblName;
    public javax.swing.JLabel lblprice;
    public javax.swing.JLabel lblqty;
    public javax.swing.JTable tblPurchase;
    public javax.swing.JTextField txtInvoice;
    private javax.swing.JTextField txtName;
    private javax.swing.JLabel txtPurchase;
    private javax.swing.JTextField txtqty;
    // End of variables declaration//GEN-END:variables
}