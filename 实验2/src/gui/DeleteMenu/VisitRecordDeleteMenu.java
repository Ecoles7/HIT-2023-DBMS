package gui.DeleteMenu;

import sql.Delete;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisitRecordDeleteMenu extends  JFrame{
    private static final long serialVersionUID = 1158897003425269987L;
    private JPanel contentPane;
    public VisitRecordDeleteMenu()
    {
        //页面大小调整
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //提示文字
        JLabel lblid = new JLabel("输入要删除的访问信息");
        lblid.setFont(new Font("宋体", Font.PLAIN, 14));
        lblid.setHorizontalAlignment(SwingConstants.CENTER);
        lblid.setBounds(37, 39, 150, 23);
        contentPane.add(lblid, BorderLayout.NORTH);

        JLabel lblid_1 = new JLabel("访问遍号*");
        lblid_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_1.setBounds(70, 75, 55, 23);
        contentPane.add(lblid_1, BorderLayout.NORTH);

        JLabel lblid_2 = new JLabel("员工号*");
        lblid_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_2.setBounds(70, 100, 55, 23);
        contentPane.add(lblid_2, BorderLayout.NORTH);

        JLabel lblid_3 = new JLabel("访问时间*");
        lblid_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_3.setBounds(70, 125, 55, 23);
        contentPane.add(lblid_3, BorderLayout.NORTH);




        JButton btnNewButton = new JButton("删除");
        btnNewButton.setBounds(185, 195, 72, 23);
        contentPane.add(btnNewButton, BorderLayout.SOUTH);

        JTextField textField = new JTextField();
        textField.setColumns(10);
        textField.setSize(72, 23);
        textField.setLocation(130, 75);
        contentPane.add(textField, BorderLayout.CENTER);

        JTextField textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setSize(72, 23);
        textField_1.setLocation(130, 100);
        contentPane.add(textField_1, BorderLayout.CENTER);

        JTextField textField_2 = new JTextField();
        textField_2.setColumns(10);
        textField_2.setSize(72, 23);
        textField_2.setLocation(130, 125);
        contentPane.add(textField_2, BorderLayout.CENTER);




        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String vid = textField.getText();
                String sid = textField_1.getText();
                String vtime = textField_2.getText();
                String[] items = {vid, sid, vtime};
                Delete delete=new Delete();
                delete.deleteVisitRecord(items);
            }
        });
    }
}
