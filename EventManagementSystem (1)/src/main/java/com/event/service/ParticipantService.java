package com.event.service;

import com.event.dao.ParticipantDAO;
import com.event.model.Participant;

import java.util.List;
import java.util.Scanner;

public class ParticipantService {
    private final ParticipantDAO participantDAO = new ParticipantDAO();
    private final Scanner scanner = new Scanner(System.in);

    public void registerParticipant() {
        System.out.print("Enter Participant Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Event ID to Register: ");
        int eventId = Integer.parseInt(scanner.nextLine());

        Participant p = new Participant(0, name, email, eventId);
        participantDAO.addParticipant(p);
    }

    public void listParticipants() {
        List<Participant> participants = participantDAO.getAllParticipants();
        for (Participant p : participants) {
            System.out.println("ID: " + p.getId() + ", Name: " + p.getName() + ", Email: " + p.getEmail() + ", Event ID: " + p.getEventId());
        }
    }
}
