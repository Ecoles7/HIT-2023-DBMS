package sql;

import java.sql.SQLException;
import jdbc.ConJDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Insert {
    static ConJDBC c = new ConJDBC(); // 创建连接类对象
    static PreparedStatement prepsInsertProduct=null;
    static int re;

    public void insertDepartment(String[] items){
        String sql="insert into department (";
        String item = ") values (";
        if(!items[0].equals("")) {
            sql = sql + "did";
            item = item + "'" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            sql = sql + ", dname";
            item = item + ", " + "'" + items[1] + "'";
        }

        sql = sql + item + ")";

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("插入成功！");
            }
            else {
                System.out.println("插入失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertBed(String[] items){
        String sql="insert into bed (";
        String item = ") values (";
        if(!items[0].equals("")) {
            sql = sql + "rid";
            item = item + "'" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            sql = sql + ", bedid";
            item = item + ", " + "'" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            sql = sql + ", bedType";
            item = item + ", " + "'" + items[2] + "'";
        }

        sql = sql + item + ")";

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("插入成功！");
            }
            else {
                System.out.println("插入失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertGoodsreceive(String[] items){
        String sql="insert into goodsreceive (";
        String item = ") values (";
        if(!items[0].equals("")) {
            sql = sql + "lid";
            item = item + "'" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            sql = sql + ", sid";
            item = item + ", " + "'" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            sql = sql + ", retime";
            item = item + ", " + "'" + items[2] + "'";
        }
        if(!items[3].equals("")) {
            sql = sql + ", renum";
            item = item + ", " + "'" + items[3] + "'";
        }

        sql = sql + item + ")";

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("插入成功！");
            }
            else {
                System.out.println("插入失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertLivingGoods(String[] items){
        String sql="insert into livinggoods (";
        String item = ") values (";
        if(!items[0].equals("")) {
            sql = sql + "lid";
            item = item + "'" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            sql = sql + ", ltype";
            item = item + ", " + "'" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            sql = sql + ", lprice";
            item = item + ", " + "'" + items[2] + "'";
        }

        sql = sql + item + ")";

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("插入成功！");
            }
            else {
                System.out.println("插入失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertManager(String[] items){
        String sql="insert into manager (";
        String item = ") values (";
        if(!items[0].equals("")) {
            sql = sql + "mid";
            item = item + "'" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            sql = sql + ", mname";
            item = item + ", " + "'" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            sql = sql + ", mage";
            item = item + ", " + "'" + items[2] + "'";
        }

        sql = sql + item + ")";

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("插入成功！");
            }
            else {
                System.out.println("插入失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertOccuCerti(String[] items){
        String sql="insert into occucerti (";
        String item = ") values (";
        if(!items[0].equals("")) {
            sql = sql + "certi_id";
            item = item + "'" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            sql = sql + ", sid";
            item = item + ", " + "'" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            sql = sql + ", certi_dep";
            item = item + ", " + "'" + items[2] + "'";
        }

        sql = sql + item + ")";

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("插入成功！");
            }
            else {
                System.out.println("插入失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertRoom(String[] items){
        String sql="insert into room (";
        String item = ") values (";
        if(!items[0].equals("")) {
            sql = sql + "rid";
            item = item + "'" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            sql = sql + ", bednum";
            item = item + ", " + "'" + items[1] + "'";
        }

        sql = sql + item + ")";

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("插入成功！");
            }
            else {
                System.out.println("插入失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertRoomManage(String[] items){
        String sql="insert into roommanage (";
        String item = ") values (";
        if(!items[0].equals("")) {
            sql = sql + "mid";
            item = item + "'" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            sql = sql + ", rid";
            item = item + ", " + "'" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            sql = sql + ", rmcontent";
            item = item + ", " + "'" + items[2] + "'";
        }
        if(!items[2].equals("")) {
            sql = sql + ", rmtime";
            item = item + ", " + "'" + items[2] + "'";
        }

        sql = sql + item + ")";

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("插入成功！");
            }
            else {
                System.out.println("插入失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertStaff(String[] items){
        String sql="insert into staff (";
        String item = ") values (";
        if(!items[0].equals("")) {
            sql = sql + "sid";
            item = item + "'" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            sql = sql + ", sname";
            item = item + ", " + "'" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            sql = sql + ", sage";
            item = item + ", " + "'" + items[2] + "'";
        }
        if(!items[3].equals("")) {
            sql = sql + ", snum";
            item = item + ", " + "'" + items[3] + "'";
        }
        if(!items[4].equals("")) {
            sql = sql + ", ssex";
            item = item + ", " + "'" + items[4] + "'";
        }
        if(!items[5].equals("")) {
            sql = sql + ", did";
            item = item + ", " + "'" + items[5] + "'";
        }


        sql = sql + item + ")";

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("插入成功！");
            }
            else {
                System.out.println("插入失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertStaffOccu(String[] items){
        String sql="insert into staffoccu (";
        String item = ") values (";
        if(!items[0].equals("")) {
            sql = sql + "rid";
            item = item + "'" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            sql = sql + ", bedid";
            item = item + ", " + "'" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            sql = sql + ", sid";
            item = item + ", " + "'" + items[2] + "'";
        }
        if(!items[3].equals("")) {
            sql = sql + ", occuTime";
            item = item + ", " + "'" + items[3] + "'";
        }

        sql = sql + item + ")";

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("插入成功！");
            }
            else {
                System.out.println("插入失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertVisitor(String[] items){
        String sql="insert into visitor (";
        String item = ") values (";
        if(!items[0].equals("")) {
            sql = sql + "vid";
            item = item + "'" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            sql = sql + ", vname";
            item = item + ", " + "'" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            sql = sql + ", vsex";
            item = item + ", " + "'" + items[2] + "'";
        }
        if(!items[3].equals("")) {
            sql = sql + ", vnumber";
            item = item + ", " + "'" + items[3] + "'";
        }

        sql = sql + item + ")";

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("插入成功！");
            }
            else {
                System.out.println("插入失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertVisitorRecord(String[] items){
        String sql="insert into visitrecord (";
        String item = ") values (";
        if(!items[0].equals("")) {
            sql = sql + "vid";
            item = item + "'" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            sql = sql + ", sid";
            item = item + ", " + "'" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            sql = sql + ", vtime";
            item = item + ", " + "'" + items[2] + "'";
        }


        sql = sql + item + ")";

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("插入成功！");
            }
            else {
                System.out.println("插入失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args){
        Insert c=new Insert();
        String[] items={"wqe","eqwe"};
        c.insertDepartment(items);
    }



}
