package org.saoud.GUI;
import org.saoud.Data;
import org.saoud.Session;
import org.saoud.SessionData;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class HighScorePanel extends JPanel {
    Session session;
    Data data;

    public HighScorePanel(Data data, Session session) {
        this.session = session;
        this.data = data;
        initComponents();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        for (SessionData se : session.getSessionData()) {
            String fullTime = String.format("%02d:%02d", se.getFullTime()/60, se.getFullTime()%60);
            model.addRow(new Object[]{se.getChildName(), se.getStartTime(), se.getcCount(), fullTime});
        }

        // Add row selection listener
        jTable1.getSelectionModel().addListSelectionListener(new RowClickListener());
    }

    private void initComponents() {
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
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
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }

    private JScrollPane jScrollPane1;
    private JTable jTable1;

    private class RowClickListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = jTable1.getSelectedRow();
                if (data.isAdmin() || session.getSessionData().get(selectedRow).getChildName().compareTo(data.getCurrentUser().getName()) == 0)
                    new SessionInfoFrame(session.getSessionData().get(selectedRow));
            }
        }
    }
}
