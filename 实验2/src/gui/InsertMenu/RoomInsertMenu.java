package gui.InsertMenu;

import sql.Insert;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomInsertMenu extends JFrame {
    private static final long serialVersionUID = 1158897003425269987L;
    private JPanel contentPane;
    public RoomInsertMenu()
    {
        //页面大小调整
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //提示文字
        JLabel lblid = new JLabel("输入要添加的房间信息");
        lblid.setFont(new Font("宋体", Font.PLAIN, 14));
        lblid.setHorizontalAlignment(SwingConstants.CENTER);
        lblid.setBounds(37, 39, 150, 23);
        contentPane.add(lblid, BorderLayout.NORTH);

        JLabel lblid_1 = new JLabel("房间号*");
        lblid_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_1.setBounds(70, 75, 60, 23);
        contentPane.add(lblid_1, BorderLayout.NORTH);

        JLabel lblid_2 = new JLabel("床铺数量");
        lblid_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_2.setBounds(70, 100, 60, 23);
        contentPane.add(lblid_2, BorderLayout.NORTH);


        JButton btnNewButton = new JButton("添加*");
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



        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String rid = textField.getText();
                String bednum = textField_1.getText();
                String[] items = {rid, bednum};
                Insert insert = new Insert();
                insert.insertRoom(items);
            }
        });
    }
    public static void main(String[] args) {
        RoomInsertMenu frame = new RoomInsertMenu();
        frame.setVisible(true);
    }
}
