package org.saoud.GUI;
import org.saoud.Session;
import org.saoud.SessionData;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;
import static org.saoud.GUI.UIPanel.getData;

public class HighScorePanel extends JPanel {
    Session session;
    public HighScorePanel(Session session) {
        this.session = session;
        initComponents();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (SessionData se : session.getSessionData()) {
            String fullTime = String.format("%02d:%02d", se.getFullTime()/60, se.getFullTime()%60);
            model.addRow(new Object[]{se.getChildName(), se.getStartTime(), se.getcCount(), fullTime});
        }

        jTable1.getSelectionModel().addListSelectionListener(new RowClickListener());
    }

    private void initComponents() {
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        JButton rapotbtn = new JButton("Rapor");
        if (!getData().isAdmin())
            rapotbtn.setVisible(false);
        rapotbtn.addActionListener(e -> {
            try {
                if (session.writeToCsv())
                    rapotbtn.setForeground(Color.green);
            }catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });
        jTable1.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{
                        "Name", "Start time", "True", "Time"
                }
        ) {
            final Class[] types = new Class[]{
                    String.class, String.class, int.class, String.class
            };
            final boolean[] canEdit = new boolean[]{
                    false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        jScrollPane1.setViewportView(jTable1);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                                        .addComponent(rapotbtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(rapotbtn)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                .addContainerGap())
        );
    }

    private JScrollPane jScrollPane1;
    private JTable jTable1;

    private class RowClickListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = jTable1.getSelectedRow();
                if (getData().isAdmin() || session.getSessionData().get(selectedRow).getChildName().compareTo(getData().getCurrentUser().getName()) == 0)
                    new SessionInfoFrame(session.getSessionData().get(selectedRow));
            }
        }
    }
}
