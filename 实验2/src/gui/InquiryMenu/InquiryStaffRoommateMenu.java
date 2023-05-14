package gui.InquiryMenu;

import gui.InquiryTable.StaffGoodsTable;
import gui.InquiryTable.StaffRoommateTable;
import sql.Inquiry;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class InquiryStaffRoommateMenu extends JFrame{
    private static final long serialVersionUID = 1158897003425269987L;
    private JPanel contentPane;
    public InquiryStaffRoommateMenu()
    {
        //页面大小调整
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //提示文字
        JLabel lblid = new JLabel("查询员工的舍友信息");
        lblid.setFont(new Font("宋体", Font.PLAIN, 20));
        lblid.setBounds(37, 39, 300, 40);
        contentPane.add(lblid, BorderLayout.NORTH);

        JLabel lblid_1 = new JLabel("输入查询的员工号");
        lblid_1.setFont(new Font("宋体", Font.PLAIN, 14));
        lblid_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_1.setBounds(60, 90, 150, 23);
        contentPane.add(lblid_1, BorderLayout.NORTH);


        JButton btnNewButton = new JButton("查找");
        btnNewButton.setBounds(185, 195, 72, 23);
        contentPane.add(btnNewButton, BorderLayout.SOUTH);

        JTextField textField = new JTextField();
        textField.setColumns(10);
        textField.setSize(72, 23);
        textField.setLocation(210, 90);
        contentPane.add(textField, BorderLayout.SOUTH);



        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String item= textField.getText();
                Inquiry inquiry = new Inquiry();
                List<Vector<String>> result = inquiry.inquiryStaffRoommate(item);
                StaffRoommateTable table = new StaffRoommateTable(result);
                table.setVisible(true);
            }
        });


    }
}
