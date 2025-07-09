package com.event.dao;

import com.event.model.Participant;
import com.event.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO {

    public void addParticipant(Participant p) {
        String sql = "INSERT INTO participants(name, email, event_id) VALUES (?, ?, ?)";
        try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            ps.setString(2, p.getEmail());
            ps.setInt(3, p.getEventId());
            ps.executeUpdate();
            System.out.println("Participant registered successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Participant> getAllParticipants() {
        List<Participant> participants = new ArrayList<>();
        String sql = "SELECT * FROM participants";
        try (Connection con = DBUtil.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Participant p = new Participant(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getInt("event_id"));
                participants.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return participants;
    }
}
