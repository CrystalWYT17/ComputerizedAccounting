/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opencampusaccounting;


import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author ASUS
 */
public class BarChart extends javax.swing.JFrame {

    /**
     * Creates new form BarChart
     */
    public BarChart() {
        //initComponents();
        databaseBarChart();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(BarChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarChart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BarChart().setVisible(true);
            }
        });
    }

    private void databaseBarChart() {
        String url = "jdbc:mysql://localhost:3306/computerizedaccounting";
			 String username = "root";
			 String password = "wuttyeetun";
			 
			 Connection conn;
			 Statement stmt;
			 ResultSet rs;
                         String item;int price,qty;int totalUnicorn=0; int totalEgg=0; int totalDIY=0; int totalStraw=0; int totalBerry=0; int totalGrape=0;int totalFruity=0;
                         int totalStrawIce=0;int totalChoco=0;
                         int totalVanila=0;int totalSushi=0;int totalKey=0;int totalUIT=0;
                         char hint='a';
			 
			 String st="";
                         
			 String query = "SELECT * FROM CUSTOMER";
                         //String query1="SELECT "
			// String query= "SELECT * FROM STUDENT WHERE stuaddress='Pathein'";
			String [][]items={{"Unicorn Cupcake","U"},{"Egg Tart","E"},{"DIY and dcorate","D"},{"Strawberry Yogurt","S"},{"Berry Yogurt","B"},{"Grape Yogurt","G"},
                                        {"Fruity Yogurt","F"},{"Strawberry Ice_cream","I"},{"Chocolate Ice_cream","C"},
                                        {"Vanila Ice_cream","V"},{"Sushi","J"},{"Key_Chain","K"},{"UIT_Book","T"}};
                        //String []shortcut={"U","E","D","S","B","G","F","I","C","V","J","K","T"};
                        try{ 
				 Class.forName("com.mysql.jdbc.Driver"); //Register JDBC driver
				 conn = DriverManager.getConnection(url, username, password); //Open a connection
				 stmt = conn.createStatement();  //creates a Statement object for sending SQL statements to the database			 
			     rs = stmt.executeQuery(query);  //Execute a query
			     
			     while(rs.next()){   //Extract data from result set
			    	 
			    	 //String rno=rs.getString(1);
			    	 item=rs.getString(4);
			      	 qty=rs.getInt(6);
			      	 price=rs.getInt(7);
			      	 if(qty>0 & price>0) {
                                     for(int i=0; i<items.length; i++){
                                         if(item.equalsIgnoreCase(items[i][0])){
                                             System.out.println(items[i][0]);
                                          hint=items[i][1].charAt(0);
                                          System.out.println(hint);
                                         switch(hint){
                                         case'U':totalUnicorn+=qty*price;break;//totalDIY=0; int totalStraw=0; int totalBerry=0; int totalGrape=0;int totalVanila=0;int toalSushi=0;int toalKey=0;int toalUIT=0;
                                         case'E':totalEgg+=qty*price;break;
                                         case'D':totalDIY+=qty*price;break;
                                         case'S':totalStraw+=qty*price;break;
                                         case'B':totalBerry+=qty*price;break;
                                         case'G':totalGrape+=qty*price;break;
                                         case'F':totalFruity+=qty*price;break;
                                         case'I':totalStrawIce+=qty*price;break;
                                         case'C':totalChoco+=qty*price;break;
                                         case'V':totalVanila+=qty*price;break;
                                         case'J':totalSushi+=qty*price;break;
                                         case'K':totalKey+=qty*price;break;
                                         case'T':totalUIT+=qty*price;break;
                                        }
                                         }
                                     }
                                 }
                                 
                              
			     }		
			     //JOptionPane.showMessageDialog(this, "Student Information\n \n"+st, this.getTitle(),JOptionPane.INFORMATION_MESSAGE);
			     rs.close(); 
			     conn.close();
                             
                                
                                  DefaultCategoryDataset barChartData=new DefaultCategoryDataset();
                                  //System.out.println("Start");
                                  //System.out.println("TotalUnicorn="+totalUnicorn);
                                  
                                  if(totalUnicorn>0){
                                 barChartData.setValue(new Integer(totalUnicorn),"Prices","Unicorn Cupcake");//System.out.println("TotalUnicorn="+totalUnicorn);
                             }
                              if(totalEgg>0){
                                barChartData.setValue(new Integer(totalEgg),"Prices","Egg Tart");
                             }
                              if(totalDIY>0){
                                 barChartData.setValue(new Integer(totalDIY),"Prices","DIY and dcorate");
                             }   
                              if(totalStraw>0){
                                 barChartData.setValue(new Integer(totalStraw),"Prices","Strawberry Yogurt");
                             }
                              if(totalBerry>0){
                                 barChartData.setValue(new Integer(totalBerry),"Prices","Berry Yogurt");
                             }
                              if(totalGrape>0){
                                 barChartData.setValue(new Integer(totalGrape),"Prices","Grape Yogurt");
                             }   
                              if(totalFruity>0){
                                 barChartData.setValue(new Integer(totalFruity),"Prices","Fruity Yogurt");
                             }
                              if(totalStrawIce>0){
                                barChartData.setValue(new Integer(totalStrawIce),"Prices","Strawberry Ice_Cream");
                             }
                              if(totalChoco>0){
                                 barChartData.setValue(new Integer(totalChoco),"Prices","Chocolate Ice_Cream");
                             }
                              if(totalVanila>0){
                                 barChartData.setValue(new Integer(totalVanila),"Prices","Vanila Ice_Cream");
                             }
                              if(totalSushi>0){
                                 barChartData.setValue(new Integer(totalSushi),"Prices","Sushi");
                             }
                              if(totalKey>0){
                                 barChartData.setValue(new Integer(totalKey),"Prices","Key_Chain");
                             }
                              if(totalUIT>0){
                                 barChartData.setValue(new Integer(totalUIT),"Prices","UIT_Book");System.out.println("UIT="+totalUIT);
                             }
                                  
                                  
                                 
                                // barChartData.setValue("Price",new Integer(price));
                                 JFreeChart chart=ChartFactory.createBarChart("List Of Monthly Saling Items","Items","Prices",barChartData,PlotOrientation.VERTICAL,false,true,false); 
                                 CategoryPlot bar=chart.getCategoryPlot();
                                 bar.setRangeGridlinePaint(Color.BLUE);
                                 ChartFrame frame=new ChartFrame("Bar Chart of Items",chart);
                                 /*ChartPanel panel=new ChartPanel(chart);
                                     panelChart.removeALL();
                                     panelChart.add(panel,BorderLayout.CENTER);
                                     panelChart.validate();*/
                                 frame.setVisible(true);
                                 frame.setSize(450,500);
			 }
			 catch (ClassNotFoundException cnfe){
			      System.out.println("Driver could not be loaded: " + cnfe);
			 }
			 catch (SQLException sqle){
			      System.out.println("SQL Exception thrown: " + sqle);
			 }
        
        
        
        
        
        
        
        
       
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
