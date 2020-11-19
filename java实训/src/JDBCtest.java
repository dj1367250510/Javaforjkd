import com.neusoft.domain.Emp;
import com.neusoft.utils.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class JDBCtest {
    public static void main(String[] args) throws Exception {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("请输入账号名：");
        String username = sc1.next();
        Scanner sc2 = new Scanner(System.in);
        System.out.println("请输入你的密码：");
        String password = sc2.next();
        boolean flag = login(username,password);
        if (flag){
            System.out.println("登陆成功");
        }
        else {
            System.out.println("登陆失败，请重新输入！");
        }
    }

    /**
     * 用户登陆
     * @param username
     * @param password
     * @return
     */
        public static boolean login(String username,String password) throws Exception {
            //参数校验
            if(username==null || password==null){
                return false;
            }
                Connection conn =null;
                Statement stmt =null;
                ResultSet rs =null;
                try {
                    conn = JDBCUtils.getConnection();
                    String sql = "select * from user where username = '"+username+"' and password='"+password+"'";
                    System.out.println(sql);
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);
                    return rs.next();
                }catch (Exception e){
                    e.printStackTrace();
                } finally {
                    JDBCUtils.close(rs,stmt,conn);
                }
                //走到这里说明有异常需要返回false
                return false;
        }
}
