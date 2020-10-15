package com.dbbest.dao;

import com.dbbest.model.Pipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PipeDaoImpl implements PipeDao {

  @Override
  public List<Pipe> findAll() {
    List<Pipe> pipeList = new ArrayList<>();
    String query = "SELECT * FROM PIPES";
    try (Connection connection = JDBCUtil.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query); ) {
      ResultSet resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        int startPoint = resultSet.getInt("START_POINT");
        int endPoint = resultSet.getInt("END_POINT");
        int length = resultSet.getInt("LENGTH");
        pipeList.add(new Pipe(startPoint, endPoint, length));
      }
    } catch (SQLException e) {
      throw new JDBCException("Troubles with the database when try to find all pipes", e);
    }
    return pipeList;
  }

  @Override
  public boolean isExists(int startPoint, int endPoint) {
    boolean isExists = false;
    String query = "SELECT * FROM PIPES WHERE START_POINT = ? AND END_POINT = ?";
    try (Connection connection = JDBCUtil.createConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)) {
      preparedStatement.setInt(1, startPoint);
      preparedStatement.setInt(2, endPoint);
      ResultSet resultSet = preparedStatement.executeQuery();
      isExists = resultSet.next();
    } catch (SQLException e) {
      throw new JDBCException("Troubles with the database when check is pipe exist", e);
    }
    return isExists;
  }

  @Override
  public void save(Pipe pipe) {
    String insert = "INSERT INTO PIPES (START_POINT, END_POINT, LENGTH) VALUES (?,?,?)";
    try (Connection connection = JDBCUtil.createConnection();
        PreparedStatement preparedStatementInsert = connection.prepareStatement(insert); ) {
      preparedStatementInsert.setInt(1, pipe.getStartPoint());
      preparedStatementInsert.setInt(2, pipe.getEndPoint());
      preparedStatementInsert.setInt(3, pipe.getLength());
      preparedStatementInsert.executeUpdate();
    } catch (SQLException e) {
      throw new JDBCException("Troubles with the database try to save pipe", e);
    }
  }
}
