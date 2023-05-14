package sql;

import jdbc.ConJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
    static ConJDBC c = new ConJDBC(); // 创建连接类对象
    static String sql_insert=null;
    static PreparedStatement prepsInsertProduct=null;
    static int re;
    public  void updateDepartment(String[] items){
        boolean isFirst = true;
        String sql = "update department set ";
        if(!items[0].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "did = '" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "dname = '" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            sql = sql + " where did = '" + items[2] + "'";
        }

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("更新成功！");
            }
            else {
                System.out.println("更新失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void updateBed(String[] items){
        boolean isFirst = true;
        String sql = "update bed set ";
        if(!items[0].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "rid = '" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "bedid = '" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "bedType = '" + items[2] + "'";
        }

        if(!items[3].equals("")) {
            sql = sql + " where rid = '" + items[3] + "'";
        }
        if(!items[4].equals("")) {
            sql = sql + " and bedid = '" + items[3] + "'";
        }

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("更新成功！");
            }
            else {
                System.out.println("更新失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void updateGoodsreceive(String[] items){
        boolean isFirst = true;
        String sql = "update goodsreceive set ";
        if(!items[0].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "lid = '" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "sid = '" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "retime = '" + items[2] + "'";
        }
        if(!items[3].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "renum = '" + items[3] + "'";
        }
        if(!items[4].equals("")) {
            sql = sql + " where lid = '" + items[4] + "'";
        }
        if(!items[5].equals("")) {
            sql = sql + " and sid = '" + items[5] + "'";
        }
        if(!items[6].equals("")) {
            sql = sql + " and retime = '" + items[6] + "'";
        }
        if(!items[7].equals("")) {
            sql = sql + " and renum = '" + items[7] + "'";
        }

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("更新成功！");
            }
            else {
                System.out.println("更新失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void updateLivingGoods(String[] items){
        boolean isFirst = true;
        String sql = "update livinggoods set ";
        if(!items[0].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "lid = '" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "ltype = '" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "lprice = '" + items[2] + "'";
        }
        if(!items[3].equals("")) {
            sql = sql + " where lid = '" + items[3] + "'";
        }


        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("更新成功！");
            }
            else {
                System.out.println("更新失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void updateManager(String[] items){
        boolean isFirst = true;
        String sql = "update manager set ";
        if(!items[0].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "mid = '" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "mname = '" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "mage = '" + items[2] + "'";
        }
        if(!items[3].equals("")) {
            sql = sql + " where mid = '" + items[3] + "'";
        }


        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("更新成功！");
            }
            else {
                System.out.println("更新失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void updateOccuCerti(String[] items){
        boolean isFirst = true;
        String sql = "update occucerti set ";
        if(!items[0].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "certi_id = '" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "sid = '" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "certi_dep = '" + items[2] + "'";
        }
        if(!items[3].equals("")) {
            sql = sql + " where certi_id = '" + items[3] + "'";
        }


        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("更新成功！");
            }
            else {
                System.out.println("更新失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void updateRoom(String[] items){
        boolean isFirst = true;
        String sql = "update room set ";
        if(!items[0].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "rid = '" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "bedNum = '" + items[1] + "'";
        }

        if(!items[2].equals("")) {
            sql = sql + " where rid = '" + items[2] + "'";
        }


        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("更新成功！");
            }
            else {
                System.out.println("更新失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void updateRoomManage(String[] items){
        boolean isFirst = true;
        String sql = "update roommanage set ";
        if(!items[0].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "mid = '" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "rid = '" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "rmcontent = '" + items[2] + "'";
        }
        if(!items[3].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "rmtime = '" + items[3] + "'";
        }
        if(!items[4].equals("")) {
            sql = sql + " where mid = '" + items[4] + "'";
        }
        if(!items[5].equals("")) {
            sql = sql + " and rid = '" + items[5] + "'";
        }
        if(!items[6].equals("")) {
            sql = sql + " and rmcontent = '" + items[6] + "'";
        }
        if(!items[7].equals("")) {
            sql = sql + " and rmtime = '" + items[7] + "'";
        }


        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("更新成功！");
            }
            else {
                System.out.println("更新失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void updateStaff(String[] items){
        boolean isFirst = true;
        String sql = "update staff set ";
        if(!items[0].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "sid = '" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "sname = '" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "sage = '" + items[2] + "'";
        }
        if(!items[3].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "snum = '" + items[3] + "'";
        }
        if(!items[4].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "ssex = '" + items[4] + "'";
        }
        if(!items[5].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "did = '" + items[5] + "'";
        }


        if(!items[6].equals("")) {
            sql = sql + " where sid = '" + items[6] + "'";
        }


        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("更新成功！");
            }
            else {
                System.out.println("更新失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void updateStaffOccu(String[] items){
        boolean isFirst = true;
        String sql = "update staffoccu set ";
        if(!items[0].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "rid = '" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "bedid = '" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "sid = '" + items[2] + "'";
        }
        if(!items[3].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "occuTime = '" + items[3] + "'";
        }

        if(!items[4].equals("")) {
            sql = sql + " where rid = '" + items[4] + "'";
        }
        if(!items[5].equals("")) {
            sql = sql + " and bedid = '" + items[5] + "'";
        }
        if(!items[6].equals("")) {
            sql = sql + " and sid = '" + items[6] + "'";
        }


        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("更新成功！");
            }
            else {
                System.out.println("更新失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public  void updateVisitor(String[] items){
        boolean isFirst = true;
        String sql = "update visitor set ";
        if(!items[0].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "vid = '" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "vname = '" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "vsex = '" + items[2] + "'";
        }
        if(!items[3].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "vnumber = '" + items[3] + "'";
        }

        if(!items[4].equals("")) {
            sql = sql + " where vid = '" + items[4] + "'";
        }



        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("更新成功！");
            }
            else {
                System.out.println("更新失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public  void updateVisotorRecord(String[] items){
        boolean isFirst = true;
        String sql = "update visitorrecord set ";
        if(!items[0].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "vid = '" + items[0] + "'";
        }
        if(!items[1].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "sid = '" + items[1] + "'";
        }
        if(!items[2].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + ", ";
            }
            sql = sql + "vtime = '" + items[2] + "'";
        }

        if(!items[4].equals("")) {
            sql = sql + " where vid = '" + items[4] + "'";
        }
        if(!items[5].equals("")) {
            sql = sql + " and sid = '" + items[5] + "'";
        }
        if(!items[6].equals("")) {
            sql = sql + " and vtime = '" + items[6] + "'";
        }



        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("更新成功！");
            }
            else {
                System.out.println("更新失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        Update c=new Update();
        String[] items={"yrc","yrcc","wqe"};
        c.updateDepartment(items);
    }


}
