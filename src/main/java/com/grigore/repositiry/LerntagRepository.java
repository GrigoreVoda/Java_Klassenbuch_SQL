package com.grigore.repositiry;

import com.grigore.config.ConnectionFactory;
import com.grigore.model.Lerntag;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LerntagRepository {
    private Connection connection() throws SQLException {
        return ConnectionFactory.getConnection();
    }
    private Lerntag zeileToLerntag(ResultSet rs) throws SQLException {
        Lerntag lerntag = new Lerntag();
        lerntag.setLenrtagId(rs.getInt("lerntag_id"));
        lerntag.setDozentId(rs.getInt("dozent_id"));
        lerntag.setLernfeldId(rs.getString("lernfeld_id"));
        lerntag.setDatum(rs.getDate("datum").toLocalDate());
        return lerntag;
    }
    public Lerntag lerntagByDate(LocalDate date){
       // Date dateQsl= new Date(date.getYear(), date.getMonth().getValue(), date.getDayOfMonth());
        Date dateQsl = Date.valueOf(date);
        Lerntag lerntag = new Lerntag();
        String sqlQuery = "SELECT * FROM lerntag WHERE datum =?";
        try(PreparedStatement stm = connection().prepareStatement(sqlQuery)){
            stm.setDate(1,dateQsl );
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                lerntag = zeileToLerntag(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lerntag;
    }
public Lerntag lerntagById(int id){
        Lerntag lerntag = new Lerntag();
        String sqlQuery = "SELECT * FROM lerntag WHERE lerntag_id=?";
        try(PreparedStatement stm = connection().prepareStatement(sqlQuery)){
            stm.setInt(1,id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                lerntag = zeileToLerntag(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    return lerntag;
}

    public List<Lerntag> findAll(){
        List<Lerntag> lerntagList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM lerntag";
        try(Connection con = connection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sqlQuery)) {
            lerntagList.add(zeileToLerntag(rs));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return lerntagList;
    }
}
