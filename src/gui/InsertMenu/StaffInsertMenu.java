package gui.InsertMenu;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import sql.Insert;

import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class StaffInsertMenu  extends JFrame{
    private static final long serialVersionUID = 1158897003425269987L;
    private JPanel contentPane;
    public StaffInsertMenu()
    {
        //页面大小调整
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //提示文字
        JLabel lblid = new JLabel("输入要插入的员工信息");
        lblid.setFont(new Font("宋体", Font.PLAIN, 14));
        lblid.setHorizontalAlignment(SwingConstants.CENTER);
        lblid.setBounds(37, 39, 150, 23);
        contentPane.add(lblid, BorderLayout.NORTH);

        JLabel lblid_1 = new JLabel("员工号*");
        lblid_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_1.setBounds(70, 75, 50, 23);
        contentPane.add(lblid_1, BorderLayout.NORTH);

        JLabel lblid_2 = new JLabel("姓名*");
        lblid_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_2.setBounds(70, 100, 50, 23);
        contentPane.add(lblid_2, BorderLayout.NORTH);

        JLabel lblid_3 = new JLabel("年龄*");
        lblid_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_3.setBounds(70, 125, 50, 23);
        contentPane.add(lblid_3, BorderLayout.NORTH);

        JLabel lblid_4 = new JLabel("身份证号*");
        lblid_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_4.setBounds(70, 150, 50, 23);
        contentPane.add(lblid_4, BorderLayout.NORTH);

        JLabel lblid_5 = new JLabel("性别*");
        lblid_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_5.setBounds(250, 75, 60, 23);
        contentPane.add(lblid_5, BorderLayout.CENTER);

        JLabel lblid_6 = new JLabel("部门号*");
        lblid_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_6.setBounds(250, 100, 60, 23);
        contentPane.add(lblid_6, BorderLayout.NORTH);


        JButton btnNewButton = new JButton("增加");
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
        textField_4.setLocation(330, 75);
        contentPane.add(textField_4, BorderLayout.CENTER);

        JTextField textField_5 = new JTextField();
        textField_5.setColumns(10);
        textField_5.setSize(72, 23);
        textField_5.setLocation(330, 100);
        contentPane.add(textField_5, BorderLayout.CENTER);



        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String sid = textField.getText();
                String sname = textField_1.getText();
                String sage = textField_2.getText();
                String snum = textField_3.getText();
                String ssex = textField_4.getText();
                String did = textField_5.getText();
                String[] items = {sid, sname, sage, snum, ssex, did};
                Insert insert = new Insert();
                insert.insertStaff(items);
            }
        });


    }
    public static void main(String[] args) {
        StaffInsertMenu frame = new StaffInsertMenu();
        frame.setVisible(true);
    }
}
