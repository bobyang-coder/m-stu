import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ResourceBundle;

/**
 * 原生jdbc
 *
 * @author bob {Tel：15811588260}-{Email：bobyang_coder@163.com}
 * @version 1.0
 * @since 2017/3/26
 */
public class JdbcMain {
    private static final Logger logger = LoggerFactory.getLogger(JdbcMain.class);
    private static String password;
    private static String user;
    private static String url;
    private static String driver;

    static {
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        password = rb.getString("password");
        user = rb.getString("username");
        url = rb.getString("url");
        driver = rb.getString("driver");
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //定义sql语句 ?表示占位符
        String sql = "SELECT * FROM AUTH_USER t WHERE t.username = ?";
        //1.加载数据库驱动
        Class.forName(driver);
        //2.通过驱动管理类获取数据源链接
        Connection connection = DriverManager.getConnection(url, user, password);
        //3.根据sql获取预处理statement,并设置参数
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "bob");
        //4.执行sql获取结果集
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            logger.info("resultSet:id={},username={}", resultSet.getString("user_id"), resultSet.getString("username"));
        }
        //5.释放资源
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }

}
