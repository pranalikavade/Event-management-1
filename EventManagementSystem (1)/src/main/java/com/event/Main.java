package com.event;

import com.event.service.EventService;
import com.event.service.ParticipantService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EventService eventService = new EventService();
        ParticipantService participantService = new ParticipantService();

        while (true) {
            System.out.println("\n===== Event Management System =====");
            System.out.println("1. Add Event");
            System.out.println("2. List Events");
            System.out.println("3. Register Participant");
            System.out.println("4. List Participants");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: eventService.addEvent(); break;
                case 2: eventService.listEvents(); break;
                case 3: participantService.registerParticipant(); break;
                case 4: participantService.listParticipants(); break;
                case 5: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}
