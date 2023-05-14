package gui;

import gui.InsertMenu.*;
import gui.InquiryMenu.*;
import gui.DeleteMenu.*;
import gui.UpdateMenu.*;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame{
    private static final long serialVersionUID = 1158897003425269987L;
    private JPanel contentPane;
    public MainMenu()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //页面大小调整
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //提示文字
        JLabel lblid = new JLabel("选择要操作的表格");
        lblid.setHorizontalAlignment(SwingConstants.CENTER);
        lblid.setBounds(37, 39, 200, 23);
        contentPane.add(lblid);

        //下拉框
        JComboBox<String> comboBox = new JComboBox<String>(new String[] {
                "员工列表",
                "部门列表",
                "房间列表",
                "床铺列表",
                "物资列表",
                "管理员列表",
                "入住信息表",
                "物资领取表",
                "入住资格证明表",
                "房间事务表",
                "外来人员表",
                "访问记录表",
        });
        comboBox.setMaximumRowCount(5);
        comboBox.setBounds(76, 95, 265, 35);
        contentPane.add(comboBox, BorderLayout.CENTER);

        JButton btnNewButton = new JButton("增加");
        btnNewButton.setBounds(24, 185, 72, 23);
        contentPane.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int item = comboBox.getSelectedIndex();
                switch(item) {
                    case 0:
                        StaffInsertMenu amenu = new StaffInsertMenu();
                        amenu.setVisible(true);
                        break;
                    case 1:
                        DepartmentInsetMenu bmenu = new DepartmentInsetMenu();
                        bmenu.setVisible(true);
                        break;
                    case 2:
                        RoomInsertMenu cmenu = new RoomInsertMenu();
                        cmenu.setVisible(true);
                        break;
                    case 3:
                        BedInsertMenu dmenu = new BedInsertMenu();
                        dmenu.setVisible(true);
                        break;
                    case 4:
                        LivingGoodsInsertMenu etmenu = new LivingGoodsInsertMenu();
                        etmenu.setVisible(true);
                        break;
                    case 5:
                        ManagerInsertMenu ftmenu = new ManagerInsertMenu();
                        ftmenu.setVisible(true);
                        break;
                    case 6:
                        StaffOccuInsertMenu gtmenu = new StaffOccuInsertMenu();
                        gtmenu.setVisible(true);
                        break;
                    case 7:
                        GoodsreceiveInsertMenu htmenu = new GoodsreceiveInsertMenu();
                        htmenu.setVisible(true);
                        break;
                    case 8:
                        OccuCertiInsertMenu itmenu = new OccuCertiInsertMenu();
                        itmenu.setVisible(true);
                        break;
                    case 9:
                        RoomManageInsertMenu jmenu = new RoomManageInsertMenu();
                        jmenu.setVisible(true);
                        break;
                    case 10:
                        VisitorInsertMenu kmenu = new VisitorInsertMenu();
                        kmenu.setVisible(true);
                        break;
                    case 11:
                        VisitRecordInsertMenu lmenu = new VisitRecordInsertMenu();
                        lmenu.setVisible(true);
                        break;

                }
            }
        });

        JButton btnNewButton_1 = new JButton("删除");
        btnNewButton_1.setBounds(124, 185, 72, 23);
        contentPane.add(btnNewButton_1);
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int item = comboBox.getSelectedIndex();
                switch(item) {
                    case 0:
                        StaffDeleteMenu amenu = new StaffDeleteMenu();
                        amenu.setVisible(true);
                        break;
                    case 1:
                        DepartmentDeleteMenu bmenu = new DepartmentDeleteMenu();
                        bmenu.setVisible(true);
                        break;
                    case 2:
                        RoomDeleteMenu cmenu = new RoomDeleteMenu();
                        cmenu.setVisible(true);
                        break;
                    case 3:
                        BedDeleteMenu dmenu = new BedDeleteMenu();
                        dmenu.setVisible(true);
                        break;
                    case 4:
                        LivingGoodsDeleteMenu etmenu = new LivingGoodsDeleteMenu();
                        etmenu.setVisible(true);
                        break;
                    case 5:
                        ManagerDeleteMenu ftmenu = new ManagerDeleteMenu();
                        ftmenu.setVisible(true);
                        break;
                    case 6:
                        StaffOccuDeleteMenu gtmenu = new StaffOccuDeleteMenu();
                        gtmenu.setVisible(true);
                        break;
                    case 7:
                        GoodsreceiveDeleteMenu htmenu = new GoodsreceiveDeleteMenu();
                        htmenu.setVisible(true);
                        break;
                    case 8:
                        OccuCertiDeleteMenu itmenu = new OccuCertiDeleteMenu();
                        itmenu.setVisible(true);
                        break;
                    case 9:
                        RoomManageDeleteMenu jmenu = new RoomManageDeleteMenu();
                        jmenu.setVisible(true);
                        break;
                    case 10:
                        VisitorDeleteMenu kmenu = new VisitorDeleteMenu();
                        kmenu.setVisible(true);
                        break;
                    case 11:
                        VisitRecordDeleteMenu lmenu = new VisitRecordDeleteMenu();
                        lmenu.setVisible(true);
                        break;


                }
            }
        });

        JButton btnNewButton_2 = new JButton("修改");
        btnNewButton_2.setBounds(228, 185, 72, 23);
        contentPane.add(btnNewButton_2);
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int item = comboBox.getSelectedIndex();
                switch(item) {
                    case 0:
                        StaffUpdateMenu amenu = new StaffUpdateMenu();
                        amenu.setVisible(true);
                        break;
                    case 1:
                        DepartmentUpdateMenu bmenu = new DepartmentUpdateMenu();
                        bmenu.setVisible(true);
                        break;
                    case 2:
                        RoomUpdateMenu cmenu = new RoomUpdateMenu();
                        cmenu.setVisible(true);
                        break;
                    case 3:
                        BedUpdateMenu dmenu = new BedUpdateMenu();
                        dmenu.setVisible(true);
                        break;
                    case 4:
                        LivingGoodsUpdateMenu etmenu = new LivingGoodsUpdateMenu();
                        etmenu.setVisible(true);
                        break;
                    case 5:
                        ManagerUpdateMenu ftmenu = new ManagerUpdateMenu();
                        ftmenu.setVisible(true);
                        break;
                    case 6:
                        StaffOccuUpdateMenu gtmenu = new StaffOccuUpdateMenu();
                        gtmenu.setVisible(true);
                        break;
                    case 7:
                        GoodsreceiveUpdateMenu htmenu = new GoodsreceiveUpdateMenu();
                        htmenu.setVisible(true);
                        break;
                    case 8:
                        OccuCertiUpdateMenu itmenu = new OccuCertiUpdateMenu();
                        itmenu.setVisible(true);
                        break;
                    case 9:
                        RoomManageUpdateMenu jmenu = new RoomManageUpdateMenu();
                        jmenu.setVisible(true);
                        break;
                    case 10:
                        VisitorUpdateMenu kmenu = new VisitorUpdateMenu();
                        kmenu.setVisible(true);
                        break;
                    case 11:
                        VisitRecordUpdateMenu lmenu = new VisitRecordUpdateMenu();
                        lmenu.setVisible(true);
                        break;

                }
            }
        });

    }
    public static void main(String[] args) {
        MainMenu frame = new MainMenu();
        frame.setVisible(true);

    }
}
