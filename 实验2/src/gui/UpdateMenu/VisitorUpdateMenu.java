package gui.UpdateMenu;

import sql.Insert;
import sql.Update;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisitorUpdateMenu extends JFrame{
    private static final long serialVersionUID = 1158897003425269987L;
    private JPanel contentPane;
    public VisitorUpdateMenu()
    {
        //页面大小调整
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //提示文字
        JLabel lblid = new JLabel("输入要更新的访问人员信息");
        lblid.setFont(new Font("宋体", Font.PLAIN, 14));
        lblid.setHorizontalAlignment(SwingConstants.CENTER);
        lblid.setBounds(37, 39, 150, 23);
        contentPane.add(lblid, BorderLayout.NORTH);

        JLabel lblid_1 = new JLabel("访问遍号*");
        lblid_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_1.setBounds(70, 75, 55, 23);
        contentPane.add(lblid_1, BorderLayout.NORTH);

        JLabel lblid_2 = new JLabel("姓名*");
        lblid_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_2.setBounds(70, 100, 55, 23);
        contentPane.add(lblid_2, BorderLayout.NORTH);

        JLabel lblid_3 = new JLabel("性别*");
        lblid_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_3.setBounds(70, 125, 55, 23);
        contentPane.add(lblid_3, BorderLayout.NORTH);

        JLabel lblid_4 = new JLabel("联系方式*");
        lblid_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_4.setBounds(70, 150, 55, 23);
        contentPane.add(lblid_4, BorderLayout.NORTH);

        JLabel lblid_5 = new JLabel("原访问编号*");
        lblid_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_5.setBounds(70, 175, 55, 23);
        contentPane.add(lblid_5, BorderLayout.NORTH);



        JButton btnNewButton = new JButton("更新");
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

        JTextField textField_3 = new JTextField();
        textField_3.setColumns(10);
        textField_3.setSize(72, 23);
        textField_3.setLocation(130, 150);
        contentPane.add(textField_3, BorderLayout.CENTER);

        JTextField textField_4 = new JTextField();
        textField_4.setColumns(10);
        textField_4.setSize(72, 23);
        textField_4.setLocation(130, 175);
        contentPane.add(textField_4, BorderLayout.CENTER);





        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String vid = textField.getText();
                String vname = textField_1.getText();
                String vsex = textField_2.getText();
                String vnumber = textField_3.getText();
                String voldid = textField_4.getText();
                String[] items = {vid, vname, vsex, vnumber, voldid};
                Update update = new Update();
                update.updateVisitor(items);
            }
        });
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VisitorUpdateMenu frame = new VisitorUpdateMenu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
