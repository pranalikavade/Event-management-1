package com.event.service;

import com.event.dao.EventDAO;
import com.event.model.Event;

import java.util.List;
import java.util.Scanner;

public class EventService {
    private final EventDAO eventDAO = new EventDAO();
    private final Scanner scanner = new Scanner(System.in);

    public void addEvent() {
        System.out.print("Enter Event Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Event Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter Event Location: ");
        String location = scanner.nextLine();

        Event e = new Event(0, name, date, location);
        eventDAO.addEvent(e);
    }

    public void listEvents() {
        List<Event> events = eventDAO.getAllEvents();
        for (Event e : events) {
            System.out.println("ID: " + e.getId() + ", Name: " + e.getName() + ", Date: " + e.getDate() + ", Location: " + e.getLocation());
        }
    }
}
