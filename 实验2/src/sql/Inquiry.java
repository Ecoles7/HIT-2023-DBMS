package sql;

import jdbc.ConJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Vector;
import java.util.ArrayList;
import java.util.List;

public class Inquiry {
    static ConJDBC c = new ConJDBC(); // 创建连接类对象
    static PreparedStatement prepsInsertProduct=null;
    static ResultSet ret = null;

    public List<Vector<String>> inquiryAllDepartment(String item){
        //查询某部门的所有员工入住信息

        String sql = "select sid, sname, dname, rid,bedid , occuTime"
                + " from staff join department  using(did) join staffoccu using(sid)"  //连接查询
                + " where did = '" + item + "'";

        List<Vector<String>> result = new ArrayList<Vector<String>>();

        try{
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            ret = prepsInsertProduct.executeQuery();
            while (ret.next()){
                Vector<String> row = new Vector<String>();
                row.add(ret.getString(1));
                row.add(ret.getString(2));
                row.add(ret.getString(3));
                row.add(ret.getString(4));
                row.add(ret.getString(5));
                row.add(ret.getString(6));
                result.add(row);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<Vector<String>> inquiryAllStaff(String item){
            //查询某员工的入住信息

            String sql = "select sid, sname, dname, rid,bedid , occuTime"
                    + " from staff join department  using(did) join staffoccu using(sid)"  //连接查询
                    + " where sid = '" + item + "'";

            List<Vector<String>> result = new ArrayList<Vector<String>>();

            try{
                Connection con=c.getConnection();
                prepsInsertProduct = con.prepareStatement(sql);
                ret = prepsInsertProduct.executeQuery();
                while (ret.next()){
                    Vector<String> row = new Vector<String>();
                    row.add(ret.getString(1));
                    row.add(ret.getString(2));
                    row.add(ret.getString(3));
                    row.add(ret.getString(4));
                    row.add(ret.getString(5));
                    row.add(ret.getString(6));
                    result.add(row);
                }
            }catch (SQLException e) {
                e.printStackTrace();
            }

            return result;
    }

    public List<Vector<String>> inquiryAllRoom(String item){
        //查询某房间的入住信息

        String sql = "select sid, sname, dname, rid,bedid , occuTime"
                + " from staff join department  using(did) join staffoccu using(sid)"  //连接查询
                + " where rid = '" + item + "'";

        List<Vector<String>> result = new ArrayList<Vector<String>>();

        try{
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            ret = prepsInsertProduct.executeQuery();
            while (ret.next()){
                Vector<String> row = new Vector<String>();
                row.add(ret.getString(1));
                row.add(ret.getString(2));
                row.add(ret.getString(3));
                row.add(ret.getString(4));
                row.add(ret.getString(5));
                row.add(ret.getString(6));
                result.add(row);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }


    //查询某个房间的房间事务
    public List<Vector<String>> inquiryRoomAffair(String item){
        String sql = "select rid, mid, mname,rmcontent, rmtime"
                + " from roommanage join manager using(mid)"
                + " where rid = " + "'" + item + "'";

        List<Vector<String>> result = new ArrayList<Vector<String>>();
        try{
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            ret = prepsInsertProduct.executeQuery();
            while (ret.next()){
                Vector<String> row = new Vector<String>();
                row.add(ret.getString(1));
                row.add(ret.getString(2));
                row.add(ret.getString(3));
                row.add(ret.getString(4));
                row.add(ret.getString(5));
                result.add(row);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    //统计每个管理员处理的事务数量
    public List<Vector<String>> inquiryManagerNum(){
        String sql = "select mid, mname, count(*)"
                + " from roommanage join manager using(mid)" //分组查询
                + " GROUP BY mid";

        List<Vector<String>> result = new ArrayList<Vector<String>>();
        try{
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            ret = prepsInsertProduct.executeQuery();
            while (ret.next()){
                Vector<String> row = new Vector<String>();
                row.add(ret.getString(1));
                row.add(ret.getString(2));
                row.add(ret.getString(3));
                result.add(row);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    //查询某员工的物资领取信息
    public List<Vector<String>> inquiryStaffGoods(String item){
        String sql = "select sid, sname, lid,ltype,lprice,retime,renum"
                + " from goodsreceive join staff using(sid)"
                + "join livinggoods using(lid)"
                + " where sid = " + "'" + item + "'";

        List<Vector<String>> result = new ArrayList<Vector<String>>();
        try{
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            ret = prepsInsertProduct.executeQuery();
            while (ret.next()){
                Vector<String> row = new Vector<String>();
                row.add(ret.getString(1));
                row.add(ret.getString(2));
                row.add(ret.getString(3));
                row.add(ret.getString(4));
                row.add(ret.getString(5));
                row.add(ret.getString(6));
                row.add(ret.getString(7));
                result.add(row);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    //查询领取数量都超过某个数量的物资领取信息
    public List<Vector<String>> inquiryStaffGoodsNum(String num){
        String sql = "select sid,sname,count(distinct lid)"
                + " from goodsreceive join staff using(sid)"
                + " GROUP BY sid"
                + " having count(distinct lid) >" + "'" + num + "'";

        List<Vector<String>> result = new ArrayList<Vector<String>>();
        try{
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            ret = prepsInsertProduct.executeQuery();
            while (ret.next()){
                Vector<String> row = new Vector<String>();
                row.add(ret.getString(1));
                row.add(ret.getString(2));
                row.add(ret.getString(3));
                result.add(row);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    //查询某个员工的舍友信息
    public List<Vector<String>> inquiryStaffRoommate(String item){
        String sql = "select sid, sname, did,rid,bedid"
                + " from staff join staffoccu using(sid)"
                + " where rid = "
                + " (select rid from staffoccu where sid = " + "'" + item + "')"; //嵌套查询

        List<Vector<String>> result = new ArrayList<Vector<String>>();
        try{
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            ret = prepsInsertProduct.executeQuery();
            while (ret.next()){
                Vector<String> row = new Vector<String>();
                row.add(ret.getString(1));
                row.add(ret.getString(2));
                row.add(ret.getString(3));
                row.add(ret.getString(4));
                row.add(ret.getString(5));
                result.add(row);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    //查询某个外来人员的访问信息
    public List<Vector<String>> inquiryVisitInfo(String item){
        String sql = "select vid, vname, sid,sname,vtime"
                + " from visitrecord join visitor using(vid)"
                + "join staff using(sid)"
                + " where vid = " + "'" + item + "'";

        List<Vector<String>> result = new ArrayList<Vector<String>>();
        try{
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            ret = prepsInsertProduct.executeQuery();
            while (ret.next()){
                Vector<String> row = new Vector<String>();
                row.add(ret.getString(1));
                row.add(ret.getString(2));
                row.add(ret.getString(3));
                row.add(ret.getString(4));
                row.add(ret.getString(5));
                result.add(row);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    //查询某个员工的访问信息
    public List<Vector<String>> inquiryStaffVisit(String item){
        String sql = "select vid, vname, sid,sname,vtime"
                + " from visitrecord join visitor using(vid)"
                + "join staff using(sid)"
                + " where sid = " + "'" + item + "'";

        List<Vector<String>> result = new ArrayList<Vector<String>>();
        try{
            Connection con=c.getConnection();
            prepsInsertProduct = con.prepareStatement(sql);
            ret = prepsInsertProduct.executeQuery();
            while (ret.next()){
                Vector<String> row = new Vector<String>();
                row.add(ret.getString(1));
                row.add(ret.getString(2));
                row.add(ret.getString(3));
                row.add(ret.getString(4));
                row.add(ret.getString(5));
                result.add(row);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }




}
