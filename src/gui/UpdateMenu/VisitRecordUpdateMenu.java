package gui.UpdateMenu;

import sql.Update;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisitRecordUpdateMenu extends JFrame{
    private static final long serialVersionUID = 1158897003425269987L;
    private JPanel contentPane;
    public VisitRecordUpdateMenu()
    {
        setBounds(200, 100, 450, 300);
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //提示文字
        JLabel lblid = new JLabel("输入要更新的员工访问信息");
        lblid.setFont(new Font("宋体", Font.PLAIN, 14));
        lblid.setHorizontalAlignment(SwingConstants.CENTER);
        lblid.setBounds(37, 39, 150, 23);
        contentPane.add(lblid, BorderLayout.NORTH);

        JLabel lblid_1 = new JLabel("访问编号*");
        lblid_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_1.setBounds(50, 75, 60, 23);
        contentPane.add(lblid_1, BorderLayout.NORTH);

        JLabel lblid_2 = new JLabel("员工号*");
        lblid_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_2.setBounds(50, 100, 60, 23);
        contentPane.add(lblid_2, BorderLayout.NORTH);

        JLabel lblid_3 = new JLabel("访问时间*");
        lblid_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_3.setBounds(50, 125, 60, 23);
        contentPane.add(lblid_3, BorderLayout.NORTH);

        JLabel lblid_5 = new JLabel("原访问编号*");
        lblid_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_5.setBounds(230, 75, 60, 23);
        contentPane.add(lblid_5, BorderLayout.NORTH);

        JLabel lblid_6 = new JLabel("原员工号*");
        lblid_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_6.setBounds(230, 100, 60, 23);
        contentPane.add(lblid_6, BorderLayout.NORTH);

        JLabel lblid_7 = new JLabel("原访问时间*");
        lblid_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_7.setBounds(230, 125, 60, 23);
        contentPane.add(lblid_7, BorderLayout.NORTH);




        JButton btnNewButton = new JButton("更新");
        btnNewButton.setBounds(185, 195, 72, 23);
        contentPane.add(btnNewButton, BorderLayout.SOUTH);

        JTextField textField = new JTextField();
        textField.setColumns(10);
        textField.setSize(72, 23);
        textField.setLocation(110, 75);
        contentPane.add(textField, BorderLayout.CENTER);

        JTextField textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setSize(72, 23);
        textField_1.setLocation(110, 100);
        contentPane.add(textField_1, BorderLayout.CENTER);

        JTextField textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setSize(72, 23);
        textField_2.setLocation(110, 125);
        contentPane.add(textField_2, BorderLayout.CENTER);


        JTextField textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setSize(72, 23);
        textField_4.setLocation(350, 75);
        contentPane.add(textField_4, BorderLayout.CENTER);

        JTextField textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setSize(72, 23);
        textField_5.setLocation(350, 100);
        contentPane.add(textField_5, BorderLayout.CENTER);

        JTextField textField_6 = new JTextField();
        textField_6.setColumns(10);
        textField_6.setSize(72, 23);
        textField_6.setLocation(350, 125);
        contentPane.add(textField_6, BorderLayout.CENTER);





        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String vid = textField.getText();
                String sid = textField_1.getText();
                String vtime = textField_2.getText();
                String oldvid = textField_4.getText();
                String oldsid = textField_5.getText();
                String oldvtime = textField_6.getText();
                String[] items = {vid, sid, vtime, oldvid, oldsid, oldvtime};
                Update update = new Update();
                update.updateVisotorRecord(items);
            }
        });
    }
    public static void main(String[] args) {
        VisitRecordUpdateMenu frame = new VisitRecordUpdateMenu();
        frame.setVisible(true);
    }
}
