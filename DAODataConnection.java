package DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAODataConnection {
    private static Connection conn;
    private final static String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final static String URL = "jdbc:oracle:thin:@localhost:8080:xe";
    private final static String DATABASE = "projectedb";
    private final static String USUARIO = "root";
    private final static String PASSWORD = "sangre10";

    private static Connection getConnection() {

        try {
            if (conn == null || conn.isClosed()) {
                try {
                    Class.forName(JDBC_DRIVER);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                try {
                    conn = DriverManager.getConnection(URL, USUARIO, PASSWORD);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            conn.setAutoCommit(false);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (conn != null) {
        } else {
            System.out.println("conexion erronea");

        }
        return conn;

    }

    public static int insertarRegistro(String sql) throws SQLException {
        conn = getConnection();
        Statement stm = null;
        int retorno = 0;
        try {
            stm = conn.createStatement();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            retorno = stm.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            //closeStatement(stm);
        }
        try {
            conn.commit();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return retorno;

    }

    public static void closeConnection() {
        try {
            if (conn != null && conn.isClosed()) {
                conn.close();
            }
        } catch (Exception e) {
            System.out.println("No se ha podido cerrar la conexion a la BD");
        } finally {
            conn = null;
        }
    }

    public static void closeStatement(Statement stm) {
        try {
            if (stm != null) {
                stm.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stm != null) {
                System.out.println("Desconectado del STM correctamente");
            }

        }

    }

    public static void closePreparedStatement(PreparedStatement preStm) {
        try {
            if (preStm != null) {
                preStm.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preStm != null) {
                System.out.println("Desconectado del preStm correctamente");
            }

        }

    }

    public static void rollback() throws SQLException {
        if(conn!=null)
            conn.rollback();
    }

    public static void setAutoCommit() {
        try {
            conn.setAutoCommit(true);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static ResultSet executeQuery(String query) throws SQLException {
        conn = getConnection();
        Statement stm = null;
        ResultSet rs;
        stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); // resultset
        // solo
        // para
        // leer
        // se
        // declara
        // asi,
        // sin
        // esto
        // no
        // te
        // devuelve
        // cuantos
        // registros
        rs = stm.executeQuery(query);
        //closeStatement(stm);
        return rs;
    }

    public static void closeResultSet(ResultSet rs) throws SQLException {
        if(rs!=null)
            rs.close();
    }

    public static int conseguirClave(String tabla, String campo) throws SQLException {
        String sql = "SELECT MAX(" + campo + ") as num FROM " + tabla;
        int num = 0;
        ResultSet rs = executeQuery(sql);

        if (rs != null &&  rs.next()) {  //!rs.isClosed()
            num = rs.getInt("num") + 1;
        } else
            num = 1;
        DAODataConnection.setAutoCommit();
        DAODataConnection.closeResultSet(rs);

        return num;
    }

    public static String getNombre(String tabla, String campo) throws SQLException {
        String sql = "SELECT ("+ campo + ") as nombre FROM " + tabla;
        String name;
        ResultSet rs = executeQuery(sql);

        if (rs != null && rs.next()) { //&& !rs.isClosed()
            name = rs.getString("nombre");
        } else
            name = "error";
        DAODataConnection.setAutoCommit();
        DAODataConnection.closeResultSet(rs);

        return name;
        // ejecutar string
        // ejecutar query string
        // close statement preparedstatement X
        // close statement statement X
        // conseguirclave string string
    }

    public static void getTodo(String nombreTabla) throws SQLException
    {
        String sql = "SELECT * FROM " + nombreTabla;
        String nombre,tipo,putnos;
        int id;
        ResultSet rs = executeQuery(sql);
        if (rs != null  && rs.next()) { //&& !rs.isClosed()
            while(rs.next())
            {
                id = rs.getInt("id");
                nombre= rs.getString("nombre");
                tipo=rs.getString("tipo");
                putnos=rs.getString("puntos");
                System.out.println("id es :" + id + " y nombre es:" + nombre + " y el tipo es :" + tipo + " y los puntos son :" + putnos);
            }
        } else
            System.out.println("error");
        DAODataConnection.setAutoCommit();
        DAODataConnection.closeResultSet(rs);

    }


}
