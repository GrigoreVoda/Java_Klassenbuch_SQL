package com.grigore.repositiry;

import com.grigore.config.ConnectionFactory;
import com.grigore.model.Unterrichtseinheit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UnterrichtseinheitRepository {
    private Connection connection() throws SQLException {
        return ConnectionFactory.getConnection();
    }

private Unterrichtseinheit zeileToUnterrichtseinheit(ResultSet rs) throws SQLException {
        Unterrichtseinheit unterrichtseinheit = new Unterrichtseinheit();
         unterrichtseinheit.setEinheitId(rs.getInt("einheit_id"));
         unterrichtseinheit.setStunde(rs.getInt("stunde"));
         unterrichtseinheit.setInhalt(rs.getString("inhalt"));
         unterrichtseinheit.setLerntagId(rs.getInt("lerntag_id"));

        return unterrichtseinheit;
}

    public List<Unterrichtseinheit> findAll() throws SQLException {
        List<Unterrichtseinheit> unterrichtseinheitList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM unterrichtseinheit";
              try (Connection con = connection();
                   Statement stm = connection().createStatement();
                   ResultSet rs = stm.executeQuery(sqlQuery)){
                  while (rs.next()){
                    unterrichtseinheitList.add(zeileToUnterrichtseinheit(rs));
                  }
              }

              return unterrichtseinheitList;
    }
public List<Unterrichtseinheit> findUnterrchtseinheitenByLerntagId(int lerntagId) throws SQLException {
        List<Unterrichtseinheit> unterrichtseinheitList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM unterrichtseinheit WHERE lerntag_id=?";
        try(PreparedStatement stm = connection().prepareStatement(sqlQuery)){
            stm.setInt(1, lerntagId);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                unterrichtseinheitList.add(zeileToUnterrichtseinheit(rs));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return unterrichtseinheitList;
}
    public Unterrichtseinheit findUnterrischtseinheitById(int id){
        Unterrichtseinheit unterrichtseinheit = new Unterrichtseinheit();
        String sqlQuery = "SELECT * FROM unterrichtseinheit WHERE einheit_id=?";
        try(PreparedStatement stm = connection().prepareStatement(sqlQuery)) {
            stm.setInt(1,id);
            try(ResultSet rs = stm.executeQuery()){
                while (rs.next()){
                    unterrichtseinheit = zeileToUnterrichtseinheit(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    return unterrichtseinheit;
    }


}
