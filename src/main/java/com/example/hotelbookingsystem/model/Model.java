package com.example.hotelbookingsystem.model;

import javafx.collections.ObservableList;
import java.time.LocalDate;
import java.util.ArrayList;

public interface Model {

    void addBooking(ArrayList<Guest> guests, Room room, LocalDate dateFrom, LocalDate dateTo);

    ObservableList<Guest> searchGuests(String firstName, String lastName, String phoneNumber, String passportNumber, String email);

    ObservableList<Room> searchRooms(int floor, int size, int quality, LocalDate from, LocalDate to);


//    int getRoomCount();
//    ArrayList<Room> getRooms();
//    User getCurrentUser();
//    void deleteRoom(Room room);
//    boolean logInUser(String name, String password) throws IOException;
//    void addPropertyChangeListener(String event, PropertyChangeListener listener);
//    void removePropertyChangeListener(String event, PropertyChangeListener listener);

    public ObservableList<Room> showALlBookedRooms();
    public ObservableList<Room> showALlAvailableRooms();
    public ObservableList<Room> showALlOutOfOrderRooms();

    public ObservableList<Booking> searchBookings(String phoneNumber, String email, int roomNumber, LocalDate dateFrom, LocalDate dateTo);
}


