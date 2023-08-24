package hr.algebra.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.swing.JCheckBox;

import hr.algebra.dal.factory.RepositoryFactory;
import hr.algebra.dal.repository.AdminControlsRepository;
import hr.algebra.dal.repository.ImageRepository;
import hr.algebra.dal.repository.MarketRepository;
import hr.algebra.model.Market;
import hr.algebra.parsers.rss.IdeaParser;
import hr.algebra.utilities.MessageUtils;

public class AdminPanel extends javax.swing.JPanel {

  private static final AdminControlsRepository adminControlsRepository = RepositoryFactory.getAdminControlsRepository();
  private static final ImageRepository imageRepository = RepositoryFactory.getImageRepository();
  private static final MarketRepository marketRepository = RepositoryFactory.getMarketRepository();
  private final Map<String, JCheckBox> marketCheckboxMap = new HashMap<>();

  public AdminPanel() {
    initComponents();
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated
  // Code">//GEN-BEGIN:initComponents
  private void initComponents() {
    java.awt.GridBagConstraints gridBagConstraints;

    btnLoad = new javax.swing.JButton();
    btnDeleteAllContent = new javax.swing.JButton();
    cbCommodities = new javax.swing.JCheckBox();
    cbCrypto = new javax.swing.JCheckBox();
    cbIndices = new javax.swing.JCheckBox();
    cbCurrencies = new javax.swing.JCheckBox();
    cbStocks = new javax.swing.JCheckBox();
    jSeparator1 = new javax.swing.JSeparator();

    addComponentListener(new java.awt.event.ComponentAdapter() {
      public void componentShown(java.awt.event.ComponentEvent evt) {
        formComponentShown(evt);
      }
    });
    setLayout(new java.awt.GridBagLayout());

    btnLoad.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    btnLoad.setText("Load TradingView Feed");
    btnLoad.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnLoadActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 5;
    gridBagConstraints.ipadx = 16;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(24, 332, 288, 0);
    add(btnLoad, gridBagConstraints);

    btnDeleteAllContent.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    btnDeleteAllContent.setForeground(new java.awt.Color(255, 51, 51));
    btnDeleteAllContent.setText("Delete all content feed");
    btnDeleteAllContent.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        btnDeleteAllContentActionPerformed(evt);
      }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridheight = 6;
    gridBagConstraints.ipadx = 26;
    gridBagConstraints.ipady = 172;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(279, 33, 288, 336);
    add(btnDeleteAllContent, gridBagConstraints);

    cbCommodities.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    cbCommodities.setText("Commodities");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.ipadx = 96;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(279, 332, 0, 0);
    add(cbCommodities, gridBagConstraints);

    cbCrypto.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    cbCrypto.setText("Crypto");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.ipadx = 136;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(4, 332, 0, 0);
    add(cbCrypto, gridBagConstraints);

    cbIndices.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    cbIndices.setText("Indices");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 3;
    gridBagConstraints.ipadx = 133;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 332, 0, 0);
    add(cbIndices, gridBagConstraints);

    cbCurrencies.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    cbCurrencies.setText("Currencies");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 2;
    gridBagConstraints.ipadx = 108;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 332, 0, 0);
    add(cbCurrencies, gridBagConstraints);

    cbStocks.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
    cbStocks.setText("Stocks");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 4;
    gridBagConstraints.ipadx = 135;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(3, 332, 0, 0);
    add(cbStocks, gridBagConstraints);

    jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 1;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.gridheight = 6;
    gridBagConstraints.ipadx = 26;
    gridBagConstraints.ipady = 200;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(279, 58, 288, 0);
    add(jSeparator1, gridBagConstraints);
  }// </editor-fold>//GEN-END:initComponents

  private void btnLoadActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLoadActionPerformed
    try {
      List<Market> markets = marketRepository.selectMarkets();
      List<Market> selectedMarkets = new ArrayList<>();
      for (Market market : markets) {
        JCheckBox checkBox = marketCheckboxMap.get(market.getName());
        if (checkBox != null && checkBox.isSelected()) {
          market.setSelected(true);
          marketRepository.updateMarket(market.getId(), market);
          selectedMarkets.add(market);
        }
      }
      IdeaParser.parse(selectedMarkets);
    } catch (Exception ex) {
      Logger.getLogger(AdminPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
      MessageUtils.showErrorMessage("Unrecoverable error", "Unable to download content");
      System.exit(1);
    }
  }// GEN-LAST:event_btnLoadActionPerformed

  private void btnDeleteAllContentActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeleteAllContentActionPerformed
    try {
      adminControlsRepository.deleteAllContent();
      imageRepository.deleteAllImages();
    } catch (Exception ex) {
      MessageUtils.showErrorMessage("Unrecoverable error", "Unable to delete all content");
      System.exit(1);
    }
  }// GEN-LAST:event_btnDeleteAllContentActionPerformed

  private void formComponentShown(java.awt.event.ComponentEvent evt) {
    init();
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton btnDeleteAllContent;
  private javax.swing.JButton btnLoad;
  private javax.swing.JCheckBox cbCommodities;
  private javax.swing.JCheckBox cbCrypto;
  private javax.swing.JCheckBox cbCurrencies;
  private javax.swing.JCheckBox cbIndices;
  private javax.swing.JCheckBox cbStocks;
  private javax.swing.JSeparator jSeparator1;
  // End of variables declaration//GEN-END:variables

  private void init() {
    marketCheckboxMap.put("Commodities", cbCommodities);
    marketCheckboxMap.put("Crypto", cbCrypto);
    marketCheckboxMap.put("Indices", cbIndices);
    marketCheckboxMap.put("Currencies", cbCurrencies);
    marketCheckboxMap.put("Stocks", cbStocks);

    try {
      List<Market> markets = marketRepository.selectMarkets();
      for (Market market : markets) {
        JCheckBox checkBox = marketCheckboxMap.get(market.getName());
        if (checkBox != null) {
          checkBox.setSelected(market.isSelected());
        }
      }
    } catch (Exception ex) {
      MessageUtils.showErrorMessage("Unrecoverable error", "Unable to load markets");
      System.exit(1);
    }
  }
}
