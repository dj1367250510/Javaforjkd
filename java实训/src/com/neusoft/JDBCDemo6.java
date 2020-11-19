package com.neusoft;

import com.neusoft.domain.Emp;
import com.neusoft.utils.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCDemo6 {
    public static void main(String[] args) throws Exception  {
//      List<Emp> emplist= findall();
        List<Emp> emplist= findall2();
        for (Emp e : emplist){
            System.out.println(e);
        }
    }
    //List<Emp> <>代表泛型的意思 对存储类型做限制
//    public static List<Emp> findall() throws Exception{
//        //多态写法： 父类引用指向子类对象
//        //声明一个list 所有的emp对象
//        List<Emp> list =  new ArrayList<>();
//        Class.forName("com.mysql.jdbc.Driver");
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jkd","root","root");
//        String sql = "select *from  emp";
//        Statement stmt = conn.createStatement();
//        ResultSet rs = stmt.executeQuery(sql);
//        while(rs.next()){
//            int empno = rs.getInt(1);
//            String ename= rs.getString(2);
//            String job = rs.getString(3);
//            int mgr = rs.getInt(4);
//            Date hiredata = rs.getDate(5);
//            int sal = rs.getInt(6);
//            int comm = rs.getInt(7);
//            int deptno = rs.getInt(8);
//            Emp emp = new Emp(empno,ename,job,mgr,hiredata,sal,comm,deptno);
//            list.add(emp);
//        }
//        stmt.close();
//        conn.close();
//        return list;
//    }
    //调用JDBCUtils工具类进行操作
    public static List<Emp> findall2() throws Exception{
        List<Emp> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        String sql = "select *from  emp";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            int empno = rs.getInt(1);
            String ename= rs.getString(2);
            String job = rs.getString(3);
            int mgr = rs.getInt(4);
            Date hiredata = rs.getDate(5);
            int sal = rs.getInt(6);
            int comm = rs.getInt(7);
            int deptno = rs.getInt(8);
            Emp emp = new Emp(empno,ename,job,mgr,hiredata,sal,comm,deptno);
            list.add(emp);
        }
        JDBCUtils.close(rs,stmt,conn);
        return list;
    }
}
