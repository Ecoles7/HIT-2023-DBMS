package gui.InquiryMenu;

import gui.InquiryTable.AffairNumTable;
import gui.InquiryTable.AffairTable;
import sql.Inquiry;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class InquiryManagerNumMenu extends JFrame {
    private static final long serialVersionUID = 1158897003425269987L;
    private JPanel contentPane;
    public InquiryManagerNumMenu()
    {
        //页面大小调整
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //提示文字
        JLabel lblid = new JLabel("统计每个管理员处理的事务数量");
        lblid.setFont(new Font("宋体", Font.PLAIN, 20));
        lblid.setBounds(37, 39, 300, 40);
        contentPane.add(lblid, BorderLayout.NORTH);

        JButton btnNewButton = new JButton("查找");
        btnNewButton.setBounds(185, 195, 72, 23);
        contentPane.add(btnNewButton, BorderLayout.SOUTH);



        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Inquiry inquiry = new Inquiry();
                List<Vector<String>> result = inquiry.inquiryManagerNum();
                AffairNumTable table = new AffairNumTable(result);
                table.setVisible(true);
            }
        });


    }
}
