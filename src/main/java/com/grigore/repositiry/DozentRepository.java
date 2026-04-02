package com.grigore.repositiry;

import com.grigore.config.ConnectionFactory;
import com.grigore.model.Dozent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DozentRepository {
    private Connection connect() throws SQLException {
        return ConnectionFactory.getConnection();
    }

    private Dozent zeileToDozent(ResultSet rs) throws SQLException {
        Dozent dozent = new Dozent();
        dozent.setDozentId(rs.getInt("dozent_id"));
        dozent.setNachname(rs.getString("nachname"));
        dozent.setVorname(rs.getString("vorname"));
        return dozent;
    }

    public Dozent findDozentById(int id) throws SQLException {
        Dozent dozent = new Dozent();
        String sqlRequest = "SELECT * FROM dozent WHERE dozent_id = ?";
        try(Connection con = connect();
            PreparedStatement ps = con.prepareStatement(sqlRequest)){
                ps.setInt(1,id);
                try (ResultSet rs = ps.executeQuery()){
                    while (rs.next()){
                        dozent = zeileToDozent(rs);
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
         return dozent;

            }


    public List<Dozent> findAll(){
        List<Dozent> dozentList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM dozent";
        try(Connection con = connect()){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sqlQuery);
            while (rs.next()) {
                dozentList.add(zeileToDozent(rs));
            }
        }
        catch (Exception o){

        }
        return  dozentList;
    }


    }


