/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceUsuario;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;
import locadoraveiculos.LocadoraDados;

/**
 *
 * @author renan
 */
public class ListarLocacoes extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo;
    /**
     * Creates new form ListarLocaca
     */
    public ListarLocacoes() {
        initComponents();
        
        preencheLista();
        
    }
    
    private void preencheLista(){
        modelo = new DefaultTableModel();
        modelo.addColumn("Índice");
        modelo.addColumn("Cliente");
        modelo.addColumn("Tipo");
        modelo.addColumn("Veículo");
        modelo.addColumn("R$ Dia");
        modelo.addColumn("Seguro R$");
        modelo.addColumn("Desconto (%)");
        modelo.addColumn("Total R$");
        modelo.addColumn("Status");
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
        tabelaLocacoes = new javax.swing.JTable();
        btTodas = new javax.swing.JButton();
        btRecebidas = new javax.swing.JButton();
        btLocadas = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setTitle("Listar Locações");

        tabelaLocacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaLocacoes);

        btTodas.setText("Todas");
        btTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTodasActionPerformed(evt);
            }
        });

        btRecebidas.setText("Recebidas");
        btRecebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRecebidasActionPerformed(evt);
            }
        });

        btLocadas.setText("Locadas");
        btLocadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLocadasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(281, 281, 281)
                .addComponent(btTodas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btRecebidas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btLocadas)
                .addContainerGap(270, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btTodas)
                    .addComponent(btRecebidas)
                    .addComponent(btLocadas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTodasActionPerformed
        
        modelo.setNumRows(0);
        for (int i = 0; i< LocadoraDados.getLocacao().size(); i++){
            DecimalFormat df = new DecimalFormat("0.00");
            df.setRoundingMode(RoundingMode.HALF_DOWN);
            
            
            modelo.addRow(new String[]{String.valueOf(i), 
                LocadoraDados.getLocacao().get(i).getCliente().getNome(),
                LocadoraDados.getLocacao().get(i).getVeiculo().getTipo(),
                LocadoraDados.getLocacao().get(i).getVeiculo().getDescricao(),
                String.valueOf(df.format(LocadoraDados.getLocacao().get(i).getVeiculo().getValorDiaria())),
                String.valueOf(df.format(LocadoraDados.getLocacao().get(i).getValorSeguro())),
                String.valueOf(df.format(LocadoraDados.getLocacao().get(i).getDesconto())),
                String.valueOf(df.format(LocadoraDados.getLocacao().get(i).getValorLocacao())),
                String.valueOf(LocadoraDados.getLocacao().get(i).getStatus())
            
            });
        }
        
        
        tabelaLocacoes.setModel(modelo);
    }//GEN-LAST:event_btTodasActionPerformed

    private void btRecebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRecebidasActionPerformed
        
        
        modelo.setNumRows(0);
        for (int i = 0; i< LocadoraDados.getLocacao().size(); i++){
            
            if(LocadoraDados.getLocacao().get(i).getStatus().equals("RECEBIDO")){
            
                DecimalFormat df = new DecimalFormat("0.00");
                df.setRoundingMode(RoundingMode.HALF_DOWN);


                modelo.addRow(new String[]{String.valueOf(i), 
                    LocadoraDados.getLocacao().get(i).getCliente().getNome(),
                    LocadoraDados.getLocacao().get(i).getVeiculo().getTipo(),
                    LocadoraDados.getLocacao().get(i).getVeiculo().getDescricao(),
                    String.valueOf(df.format(LocadoraDados.getLocacao().get(i).getVeiculo().getValorDiaria())),
                    String.valueOf(df.format(LocadoraDados.getLocacao().get(i).getValorSeguro())),
                    String.valueOf(df.format(LocadoraDados.getLocacao().get(i).getDesconto())),
                    String.valueOf(df.format(LocadoraDados.getLocacao().get(i).getValorLocacao())),
                    String.valueOf(LocadoraDados.getLocacao().get(i).getStatus())

                });
        }
        
        }
        tabelaLocacoes.setModel(modelo);
        
    }//GEN-LAST:event_btRecebidasActionPerformed

    private void btLocadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLocadasActionPerformed
        modelo.setNumRows(0);
        for (int i = 0; i< LocadoraDados.getLocacao().size(); i++){
            
            if(LocadoraDados.getLocacao().get(i).getStatus().equals("LOCADO")){
            
                DecimalFormat df = new DecimalFormat("0.00");
                df.setRoundingMode(RoundingMode.HALF_DOWN);


                modelo.addRow(new String[]{String.valueOf(i), 
                    LocadoraDados.getLocacao().get(i).getCliente().getNome(),
                    LocadoraDados.getLocacao().get(i).getVeiculo().getTipo(),
                    LocadoraDados.getLocacao().get(i).getVeiculo().getDescricao(),
                    String.valueOf(df.format(LocadoraDados.getLocacao().get(i).getVeiculo().getValorDiaria())),
                    String.valueOf(df.format(LocadoraDados.getLocacao().get(i).getValorSeguro())),
                    String.valueOf(df.format(LocadoraDados.getLocacao().get(i).getDesconto())),
                    String.valueOf(df.format(LocadoraDados.getLocacao().get(i).getValorLocacao())),
                    String.valueOf(LocadoraDados.getLocacao().get(i).getStatus())

                });
        }
        
        }
        tabelaLocacoes.setModel(modelo);
    }//GEN-LAST:event_btLocadasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLocadas;
    private javax.swing.JButton btRecebidas;
    private javax.swing.JButton btTodas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaLocacoes;
    // End of variables declaration//GEN-END:variables
}
