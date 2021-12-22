package GUI;

import Modelo.Coin;
import Modelo.Money;
import static java.lang.Double.parseDouble;
import moneycalculator.MoneyCalculator;

public class GUIPanel extends javax.swing.JFrame {
    
    private final MoneyCalculator control;
    
    private void refresh() {
        Money result = control.getFinalAmmount();
        ammountOutput.setText(result.toString());
    }

    public GUIPanel(MoneyCalculator controlObject) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        initComponents();
        control = controlObject;
        for (Coin coin : control.getCoins()) {
            sourceCoin.addItem(coin);
        }
        for (Coin coin : control.getCoins()) {
            destinationCoin.addItem(coin);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sourceCoin = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        destinationCoin = new javax.swing.JComboBox<>();
        ammountInput = new javax.swing.JTextField();
        ammountOutput = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        sourceCoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sourceCoinActionPerformed(evt);
            }
        });

        jLabel1.setText("Moneda origen");

        jLabel2.setText("Moneda destino");

        destinationCoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                destinationCoinActionPerformed(evt);
            }
        });

        ammountInput.setText("0");
        ammountInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ammountInputActionPerformed(evt);
            }
        });

        ammountOutput.setEditable(false);
        ammountOutput.setText("jTextField2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(ammountInput, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sourceCoin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(destinationCoin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(ammountOutput, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                        .addGap(107, 107, 107)))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sourceCoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(ammountInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(destinationCoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(ammountOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sourceCoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sourceCoinActionPerformed
        control.setSource((Coin)sourceCoin.getSelectedItem());
        refresh();
    }//GEN-LAST:event_sourceCoinActionPerformed

    private void ammountInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ammountInputActionPerformed
        control.setInitAmmount(parseDouble(ammountInput.getText()));
        refresh();
    }//GEN-LAST:event_ammountInputActionPerformed

    private void destinationCoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_destinationCoinActionPerformed
        control.setDestination((Coin)destinationCoin.getSelectedItem());
        refresh();
    }//GEN-LAST:event_destinationCoinActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ammountInput;
    private javax.swing.JTextField ammountOutput;
    private javax.swing.JComboBox<Coin> destinationCoin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JComboBox<Coin> sourceCoin;
    // End of variables declaration//GEN-END:variables
}
