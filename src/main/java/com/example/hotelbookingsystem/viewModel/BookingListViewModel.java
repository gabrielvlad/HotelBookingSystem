package com.example.hotelbookingsystem.viewModel;

import com.example.hotelbookingsystem.model.Booking;
import com.example.hotelbookingsystem.model.Model;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingListViewModel {

        private Model model;

        private ObjectProperty<ObservableList<BookingTableProperty>> bookings;

        public BookingListViewModel(Model model){
            bookings =new SimpleObjectProperty<>();
            this.model= model;
        }

        public void bindTableItemsProperty(ObjectProperty<ObservableList<BookingTableProperty>> itemsProperty){
            itemsProperty.bind(bookings);
        }

        public void searchBookings(String phoneNumber, String email, int roomNumber, LocalDate dateFrom, LocalDate dateTo){
            ObservableList<BookingTableProperty> bookingsFormatted = FXCollections.observableArrayList();
            for (Booking b: model.searchBookings(phoneNumber, email, roomNumber, dateFrom,dateTo)) {
                bookingsFormatted.add(new BookingTableProperty(b));
            }
            bookings.setValue(bookingsFormatted);
        }
}