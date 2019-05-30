package StudentMap_5_2;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class StudentPanel extends JPanel implements ActionListener {
    private InfoPanel infoPanel;
    private JPanel bottomMenu;
    private JButton addStudentBtn, addFiveStudents, findStudentBtn, listStudentsBtn;
    private HashMap<Integer, Student> students;

    public StudentPanel(HashMap<Integer, Student> students) {
        super(new BorderLayout());

        this.students = students;
        
        setPreferredSize(new Dimension(600, 400));
      
        this.infoPanel = new InfoPanel();
        this.add(infoPanel, BorderLayout.CENTER);

        this.bottomMenu = new JPanel();
        {
            bottomMenu.setPreferredSize(new Dimension(this.getWidth(), 40));
            bottomMenu.setBackground(Color.lightGray);

            addStudentBtn = new JButton("Add Student");
            addStudentBtn.addActionListener(this);
            bottomMenu.add(addStudentBtn);

            addFiveStudents = new JButton("Add Five Students");
            addFiveStudents.addActionListener(this);
            bottomMenu.add(addFiveStudents);

            findStudentBtn = new JButton("Find Student");
            findStudentBtn.addActionListener(this);
            bottomMenu.add(findStudentBtn);

            listStudentsBtn = new JButton("List Students");
            listStudentsBtn.addActionListener(this);
            bottomMenu.add(listStudentsBtn);
        }
      this.add(bottomMenu, BorderLayout.SOUTH);

      Timer timer = new Timer(100, this);
      timer.start();  
   }
   
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if (source == addStudentBtn) {
            AddStudentPane addPanel = new AddStudentPane();
            int result = JOptionPane.showConfirmDialog(this, addPanel, "New Student", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                if (addPanel.getStudentName().isEmpty() || addPanel.getStudentBirthdate().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "You must provide a name and birthday.");
                } else {
                    Student aStudent = new Student(students.size(), addPanel.getStudentName(), addPanel.getStudentBirthdate());
                    infoPanel.details.setText(aStudent.toString());
                    students.put(aStudent.getId(), aStudent);
                }
            }

        } else if (source == addFiveStudents) {

            students.put(students.size(), new Student(students.size(), "Jerry", "1998"));
            students.put(students.size(), new Student(students.size(), "Mike", "2000"));
            students.put(students.size(), new Student(students.size(), "Mary", "2001"));
            students.put(students.size(), new Student(students.size(), "Nigel", "2014"));
            students.put(students.size(), new Student(students.size(), "Sarah", "1987"));

        } else if (source == findStudentBtn) {
            String result = JOptionPane.showInputDialog(this, "Enter a student ID Number.");

            if (result != null) {
                Student aStudent = students.get(Integer.parseInt(result));
                if (aStudent != null) {
                    infoPanel.details.setText(aStudent.toString());
                } else JOptionPane.showMessageDialog(this, "Student not found...");
            }

        } else if (source == listStudentsBtn) {
            updateList();
        }
    }

    private void updateList() {
        String studentList = "";
        for (Map.Entry<Integer, Student> entry : students.entrySet()) {
            studentList += entry.getValue().toString();
        }

        if (studentList == "") studentList = "No students enrolled...";

        infoPanel.list.setText(studentList);
    }

    private class AddStudentPane extends JPanel {

        private JTextField nameField, speciesField;

        AddStudentPane() {

            this.nameField = new JTextField();
            this.speciesField = new JTextField();

            GridLayout layout = new GridLayout(4, 1);

            this.setLayout(layout);
            this.add(new JLabel("Name"));
            this.add(nameField);

            this.add(new JLabel("Birthdate"));
            this.add(speciesField);
        }

        public String getStudentName() {
            return this.nameField.getText();
        }

        public String getStudentBirthdate() {
            return this.speciesField.getText();
        }

    }
    private class InfoPanel extends JPanel {

        JTextArea details, list;

        public InfoPanel() {
            super(new GridLayout(1, 2));

            setPreferredSize(new Dimension(600, 300));

            this.details = new JTextArea("Find a student to see their details...");
            details.setEditable(false);
            JScrollPane detailsPane = new JScrollPane(details);
            detailsPane.setBorder(new TitledBorder("Student Details"));
            this.add(detailsPane);

            this.list = new JTextArea("Update student list to see all student details...");
            list.setEditable(false);
            JScrollPane listPane = new JScrollPane(list);
            listPane.setBorder(new TitledBorder("Student List"));
            this.add(listPane);
        }
    }
}
