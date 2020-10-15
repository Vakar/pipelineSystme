package com.dbbest.dao;

import org.h2.jdbc.JdbcConnection;
import org.h2.tools.RunScript;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {

  private static final File DB_FILE = new File("./pipelineSystem");

  private static final String USER_NAME = "sa";
  private static final String PSWD = "";

  private static final String CONNECTION_PROPERTIES = ";compress=true;db_close_on_exit=false;";
  private static final String SCHEMA_FILE = "classpath:schema.sql";

  static {
    try {
      RunScript.execute(dbUrl(), USER_NAME, PSWD, SCHEMA_FILE, StandardCharsets.UTF_8, false);
    } catch (SQLException e) {
      throw new JDBCException("Can not run JDBC script", e);
    }
  }

  private JDBCUtil() {}

  static JdbcConnection createConnection() throws SQLException {
    Properties props = new Properties();
    props.setProperty("user", USER_NAME);
    props.setProperty("password", PSWD);
    return new JdbcConnection(dbUrl(), props);
  }

  private static String dbUrl() {
    String dbPath = DB_FILE.getPath();
    dbPath = dbPath.replaceFirst(".h2.db$", "");
    return "jdbc:h2:" + dbPath + CONNECTION_PROPERTIES;
  }
}
