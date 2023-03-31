package gui;

import gui.InquiryMenu.*;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InquiryMainMenu extends JFrame{
    private static final long serialVersionUID = 1158897003425269987L;
    private JPanel contentPane;
    public InquiryMainMenu(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //页面大小调整
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //提示文字
        JLabel lblid = new JLabel("选择要查询的信息");
        lblid.setHorizontalAlignment(SwingConstants.CENTER);
        lblid.setBounds(37, 39, 200, 23);
        contentPane.add(lblid);

        //下拉框
        JComboBox<String> comboBox = new JComboBox<String>(new String[] {
                "查询某部门的所有员工入住信息",
                "查询某员工的入住信息",
                "查询某房间的入住信息",
                "查询某个房间的房间事务",
                "统计每个管理员处理的事务数量",
                "查询某员工的物资领取信息",
                "查询领取物品的数量都超过某个值的员工信息",
                "查询某个员工的舍友信息",
                "查询某个外来人员的访问信息",
                "查询某个员工的访问信息"
        });
        comboBox.setMaximumRowCount(5);
        comboBox.setBounds(76, 95, 265, 35);
        contentPane.add(comboBox, BorderLayout.CENTER);

        JButton btnNewButton = new JButton("查询");
        btnNewButton.setBounds(24, 185, 72, 23);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int item = comboBox.getSelectedIndex();
                switch(item) {
                    case 0:
                        InquiryAllDepartmentMenu amenu = new InquiryAllDepartmentMenu();
                        amenu.setVisible(true);
                        break;
                    case 1:
                        InquiryAllStaffMenu bmenu = new InquiryAllStaffMenu();
                        bmenu.setVisible(true);
                        break;
                    case 2:
                        InquiryAllRoomMenu cmenu = new InquiryAllRoomMenu();
                        cmenu.setVisible(true);
                        break;
                    case 3:
                        InquiryRoomAffairMenu emenu = new InquiryRoomAffairMenu();
                        emenu.setVisible(true);
                        break;
                    case 4:
                        InquiryManagerNumMenu fmenu = new InquiryManagerNumMenu();
                        fmenu.setVisible(true);
                        break;
                    case 5:
                        InquiryStaffGoodsMenu gmenu = new InquiryStaffGoodsMenu();
                        gmenu.setVisible(true);
                        break;
                    case 6:
                        InquiryStaffGoodsNumMenu hmenu = new InquiryStaffGoodsNumMenu();
                        hmenu.setVisible(true);
                        break;
                    case 7:
                        InquiryStaffRoommateMenu imenu = new InquiryStaffRoommateMenu();
                        imenu.setVisible(true);
                        break;
                    case 8:
                        InquiryVisitInfoMenu jmenu = new InquiryVisitInfoMenu();
                        jmenu.setVisible(true);
                        break;
                    case 9:
                        InquiryStaffVisitMenu kmenu = new InquiryStaffVisitMenu();
                        kmenu.setVisible(true);
                        break;

                }
            }
        });
    }
    public static void main(String[] args) {

        InquiryMainMenu frame = new InquiryMainMenu();
        frame.setVisible(true);

    }
}
