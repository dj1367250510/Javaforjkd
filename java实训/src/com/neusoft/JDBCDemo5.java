package com.neusoft;

import java.sql.*;

public class JDBCDemo5 {
    public static void main(String[] args) throws Exception {
        //1、导入驱动jar包, 建立libs文件夹， 右键 add as library
//2、 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
//3、获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jkd","root","root");
//4、定义sql
        String sql = "select *from  emp";
//5、获取数据库连接对象statement
        Statement stmt = conn.createStatement();
//6、执行sql
        ResultSet rs = stmt.executeQuery(sql);
//7、处理结果
        while(rs.next()){
            int EMPNO = rs.getInt("EMPNO");
            String ENAME = rs.getString("ENAME");
            String JOB = rs.getString("JOB");
            int MGR = rs.getInt("MGR");
            Date HIREDATE = rs.getDate("HIREDATE");
            int SAL = rs.getInt("SAL");
            int COMM = rs.getInt("COMM");
            int DEPTNO = rs.getInt("DEPTNO");
            System.out.println("EMPNO: "+EMPNO+" ENAME: "+ENAME
                    +" JOB: "+JOB+" MGR: "+MGR+" HIREDATE: "+
                    HIREDATE+" SAL :"+SAL+" COMM :"+COMM+" DEPTNO :"+DEPTNO);
        }
//8、释放资源
        stmt.close();
        conn.close();
    }
}
