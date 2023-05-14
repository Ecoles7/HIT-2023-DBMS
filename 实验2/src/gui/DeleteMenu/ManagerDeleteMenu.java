package gui.DeleteMenu;

import sql.Delete;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerDeleteMenu extends JFrame{
    private static final long serialVersionUID = 1158897003425269987L;
    private JPanel contentPane;
    public ManagerDeleteMenu()
    {
        //页面大小调整
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //提示文字
        JLabel lblid = new JLabel("输入要删除的管理员信息");
        lblid.setFont(new Font("宋体", Font.PLAIN, 14));
        lblid.setHorizontalAlignment(SwingConstants.CENTER);
        lblid.setBounds(37, 39, 150, 23);
        contentPane.add(lblid, BorderLayout.NORTH);

        JLabel lblid_1 = new JLabel("管理员号*");
        lblid_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_1.setBounds(70, 75, 60, 23);
        contentPane.add(lblid_1, BorderLayout.NORTH);




        JButton btnNewButton = new JButton("删除");
        btnNewButton.setBounds(185, 195, 72, 23);
        contentPane.add(btnNewButton, BorderLayout.SOUTH);

        JTextField textField = new JTextField();
        textField.setColumns(10);
        textField.setSize(72, 23);
        textField.setLocation(130, 75);
        contentPane.add(textField, BorderLayout.CENTER);




        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String mid = textField.getText();
                Delete delete=new Delete();
                delete.deleteManager(mid);
            }
        });
    }
}
