package com.event.dao;

import com.event.model.Event;
import com.event.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {

    public void addEvent(Event event) {
        String sql = "INSERT INTO events(name, date, location) VALUES (?, ?, ?)";
        try (Connection con = DBUtil.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, event.getName());
            ps.setString(2, event.getDate());
            ps.setString(3, event.getLocation());
            ps.executeUpdate();
            System.out.println("Event added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Event> getAllEvents() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM events";
        try (Connection con = DBUtil.getConnection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Event e = new Event(rs.getInt("id"), rs.getString("name"), rs.getString("date"), rs.getString("location"));
                events.add(e);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return events;
    }
}
