package com.grigore.repositiry;

import com.grigore.config.ConnectionFactory;
import com.grigore.model.Lernfeld;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LernfeldRepository {

private Connection connect() throws SQLException{
    return ConnectionFactory.getConnection();
}

private Lernfeld zeileToLernfeld(ResultSet rs) throws SQLException {
   Lernfeld lernfeld = new Lernfeld();
    lernfeld.setID(rs.getString("lernfeld_id"));
    lernfeld.setTitel(rs.getString("titel"));
    java.sql.Date date = rs.getDate("start_datum");
    lernfeld.setStartDatum(date.toLocalDate());
    java.sql.Date endDatum = rs.getDate("end_datum");
    lernfeld.setEndDatum(endDatum.toLocalDate());
    return lernfeld;
}

public Lernfeld lernfeldById(String id){
    Lernfeld lernfeld = new Lernfeld();
    String sqlQuery = "SELECT * FROM lernfeld WHERE lernfeld_id=?";
    try(PreparedStatement stm = connect().prepareStatement(sqlQuery)) {
        stm.setString(1,id);
        ResultSet rs = stm.executeQuery();
        while (rs.next()){
            lernfeld = zeileToLernfeld(rs);
        }

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    return lernfeld;
}

public List<Lernfeld> findAll() throws SQLException{
    List<Lernfeld> lernfeldList = new ArrayList<>();
    String sqlQuery = "SELECT * FROM lernfeld";

    try(Connection con = ConnectionFactory.getConnection()){
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sqlQuery);
        while (rs.next()){
            lernfeldList.add(zeileToLernfeld(rs));

        }

    } catch (Exception e) {
        throw new RuntimeException(e);
    }

    return lernfeldList;
}


}
