package gui.UpdateMenu;

import sql.Insert;
import sql.Update;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LivingGoodsUpdateMenu extends JFrame{
    private static final long serialVersionUID = 1158897003425269987L;
    private JPanel contentPane;
    public LivingGoodsUpdateMenu()
    {
        //页面大小调整
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel(new BorderLayout());
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //提示文字
        JLabel lblid = new JLabel("输入要更新的物资信息");
        lblid.setFont(new Font("宋体", Font.PLAIN, 14));
        lblid.setHorizontalAlignment(SwingConstants.CENTER);
        lblid.setBounds(37, 39, 150, 23);
        contentPane.add(lblid, BorderLayout.NORTH);

        JLabel lblid_1 = new JLabel("物资号*");
        lblid_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_1.setBounds(70, 75, 60, 23);
        contentPane.add(lblid_1, BorderLayout.NORTH);

        JLabel lblid_2 = new JLabel("物资类型*");
        lblid_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_2.setBounds(70, 100, 60, 23);
        contentPane.add(lblid_2, BorderLayout.NORTH);

        JLabel lblid_3 = new JLabel("物资价格*");
        lblid_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_3.setBounds(70, 125, 60, 23);
        contentPane.add(lblid_3, BorderLayout.NORTH);

        JLabel lblid_4 = new JLabel("原物资号*");
        lblid_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblid_4.setBounds(70, 150, 60, 23);
        contentPane.add(lblid_4, BorderLayout.NORTH);



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



        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String lid = textField.getText();
                String ltype = textField_1.getText();
                String lprice = textField_2.getText();
                String oldlid = textField_3.getText();
                String[] items = {lid, ltype, lprice,oldlid};
                Update update = new Update();
                update.updateLivingGoods(items);
            }
        });
    }
    public static void main(String[] args) {

                    LivingGoodsUpdateMenu frame = new LivingGoodsUpdateMenu();
                    frame.setVisible(true);

    }
}
