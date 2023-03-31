package sql;

import jdbc.ConJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
    static ConJDBC c = new ConJDBC(); // 创建连接类对象
    static PreparedStatement prepsInsertProduct=null;
    static int re;

    public void deleteDepartment(String item){
        boolean isFirst = true;
        String sql = "delete from department where ";
        if(!item.equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + "and ";
            }
            sql = sql + "did = " + "'" + item + "' ";
        }

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("删除成功！");
            }
            else {
                System.out.println("删除失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBed(String[] items) {
        boolean isFirst = true;
        String sql = "delete from department where ";
        if (!items[0].equals("")) {
            if (isFirst) {
                isFirst = false;
            } else {
                sql = sql + "and ";
            }
            sql = sql + "rid = " + "'" + items[0] + "' ";
        }
        if (!items[1].equals("")) {
            if (isFirst) {
                isFirst = false;
            } else {
                sql = sql + "and ";
            }
            sql = sql + "bedid = " + "'" + items[1] + "' ";
        }
            try {
                Connection con = c.getConnection();
                prepsInsertProduct = con.prepareStatement(sql);
                re = prepsInsertProduct.executeUpdate();
                c.close();//关闭连接
                if (re > 0) {
                    System.out.println("删除成功！");
                } else {
                    System.out.println("删除失败！");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }

    public void deleteGoodsreceive(String[] items){
        boolean isFirst = true;
        String sql = "delete from goodsreceive where ";
        if(!items[0].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + "and ";
            }
            sql = sql + "lid = " + "'" + items[0] + "' ";
        }
        if(!items[1].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + "and ";
            }
            sql = sql + "sid = " + "'" + items[1] + "' ";
        }

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("删除成功！");
            }
            else {
                System.out.println("删除失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteLivingGoods(String item){
        boolean isFirst = true;
        String sql = "delete from livinggoods where ";
        if(!item.equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + "and ";
            }
            sql = sql + "lid = " + "'" + item + "' ";
        }

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("删除成功！");
            }
            else {
                System.out.println("删除失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteManager(String item){
        boolean isFirst = true;
        String sql = "delete from manager where ";
        if(!item.equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + "and ";
            }
            sql = sql + "mid = " + "'" + item + "' ";
        }


        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("删除成功！");
            }
            else {
                System.out.println("删除失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteOccuCerti(String item){
        boolean isFirst = true;
        String sql = "delete from occucerti where ";
        if(!item.equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + "and ";
            }
            sql = sql + "certi_id = " + "'" + item + "' ";
        }

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("删除成功！");
            }
            else {
                System.out.println("删除失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRoom(String item){
        boolean isFirst = true;
        String sql = "delete from room where ";
        if(!item.equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + "and ";
            }
            sql = sql + "rid = " + "'" + item + "' ";
        }

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("删除成功！");
            }
            else {
                System.out.println("删除失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRoomManage(String[] items){
        boolean isFirst = true;
        String sql = "delete from roommanage where ";
        if(!items[0].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + "and ";
            }
            sql = sql + "mid = " + "'" + items[0] + "' ";
        }
        if(!items[1].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + "and ";
            }
            sql = sql + "rid = " + "'" + items[1] + "' ";
        }
        if(!items[2].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + "and ";
            }
            sql = sql + "rmcontent = " + "'" + items[2] + "' ";
        }
        if(!items[3].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + "and ";
            }
            sql = sql + "rmtime = " + "'" + items[3] + "' ";
        }


        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("删除成功！");
            }
            else {
                System.out.println("删除失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteStaff(String item){
        boolean isFirst = true;
        String sql = "delete from staff where ";
        if(!item.equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + "and ";
            }
            sql = sql + "sid = " + "'" + item + "' ";
        }

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("删除成功！");
            }
            else {
                System.out.println("删除失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteStaffOccu(String[] items){
        boolean isFirst = true;
        String sql = "delete from staffoccu where ";
        if(!items[0].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + "and ";
            }
            sql = sql + "rid = " + "'" + items[0] + "' ";
        }
        if(!items[1].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + "and ";
            }
            sql = sql + "bedid = " + "'" + items[1] + "' ";
        }
        if(!items[2].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + "and ";
            }
            sql = sql + "sid = " + "'" + items[2] + "' ";
        }

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("删除成功！");
            }
            else {
                System.out.println("删除失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVisitor(String item){
        boolean isFirst = true;
        String sql = "delete from visitor where ";
        if(!item.equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + "and ";
            }
            sql = sql + "vid = " + "'" + item + "' ";
        }

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("删除成功！");
            }
            else {
                System.out.println("删除失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteVisitRecord(String[] items){
        boolean isFirst = true;
        String sql = "delete from visitrecord where ";
        if(!items[0].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + "and ";
            }
            sql = sql + "vid = " + "'" + items[0] + "' ";
        }
        if(!items[1].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + "and ";
            }
            sql = sql + "sid = " + "'" + items[1] + "' ";
        }
        if(!items[2].equals("")) {
            if(isFirst) {
                isFirst = false;
            }
            else {
                sql = sql + "and ";
            }
            sql = sql + "vtime = " + "'" + items[2] + "' ";
        }

        try {
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            re = prepsInsertProduct.executeUpdate();
            c.close();//关闭连接
            if(re > 0) {
                System.out.println("删除成功！");
            }
            else {
                System.out.println("删除失败！");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





}
