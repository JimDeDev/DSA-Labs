package TablesGUI_7_1;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBPanel extends JPanel implements ActionListener {
    private InfoPanel infoPanel;
    private JPanel bottomMenu;
    private JButton loginBtn, viewTablesBtn;
    private DatabaseManager db;

    public DBPanel(DatabaseManager dbManager) {
        super(new BorderLayout());

        this.db = dbManager;
        
        setPreferredSize(new Dimension(600, 400));
      
        this.infoPanel = new InfoPanel();
        this.add(infoPanel, BorderLayout.CENTER);

        this.bottomMenu = new JPanel();
        {
            bottomMenu.setPreferredSize(new Dimension(this.getWidth(), 40));
            bottomMenu.setBackground(Color.lightGray);

            loginBtn = new JButton("Login");
            loginBtn.addActionListener(this);
            bottomMenu.add(loginBtn);

            viewTablesBtn = new JButton("View Tables");
            viewTablesBtn.addActionListener(this);
            bottomMenu.add(viewTablesBtn);

        }
      this.add(bottomMenu, BorderLayout.SOUTH);

      Timer timer = new Timer(100, this);
      timer.start();  
   }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source == loginBtn) {
            LoginPane loginPanel = new LoginPane();
            int result = JOptionPane.showConfirmDialog(this, loginPanel, "Login", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                if (loginPanel.getUser().isEmpty() || loginPanel.getPass().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "You must provide a username and password.");
                } else {
                    db.login(loginPanel.getUser(), loginPanel.getPass());
                }
                if (db.isConnected()) {
                    JOptionPane.showMessageDialog(this, "Connection success.");

                }
            }
        } else if (source == viewTablesBtn) {

            ResultSet rs = db.runQuery("SHOW tables");
            ArrayList<String> data = new ArrayList<>();
            try {
                int nCol = rs.getMetaData().getColumnCount();

                while (rs.next()) {
                    for (int i = 1; i <= nCol; i++) {
                        data.add(rs.getObject(i).toString());
                    }
                }

                String[] strings = new String[data.size()];

                for (int i = 0; i < data.size(); i++) {
                    strings[i] = data.get(i);
                }

                this.infoPanel.setData(strings);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        this.repaint();
    }

    private class InfoPanel extends JPanel implements ListSelectionListener {

        JList tableList;
        String[] data;

        public InfoPanel() {
            super(new GridLayout(1, 2));

            setPreferredSize(new Dimension(600, 300));
            this.tableList = new JList();
            tableList.addListSelectionListener(this);

            this.add(tableList);

        }

        public void setData(String[] data) {
            this.data = data;
            this.tableList.setListData(data);
        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            System.out.println(data[tableList.getSelectedIndex()]);
        }
    }


        private class LoginPane extends JPanel {

        private JTextField userField, passField;

        LoginPane() {
            this.userField = new JTextField();
            this.passField = new JTextField();

            GridLayout layout = new GridLayout(4, 1);

            this.setLayout(layout);
            this.add(new JLabel("Username"));
            this.add(userField);

            this.add(new JLabel("Password"));
            this.add(passField);
        }

        public String getUser() {
            return this.userField.getText();
        }

        public String getPass() {
            return this.passField.getText();
        }

    }
}
