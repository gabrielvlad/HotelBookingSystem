package com.example.hotelbookingsystem.view;

import com.example.hotelbookingsystem.viewModel.ViewModelFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler {

    // TODO ADD NAME OF YOUR FXML HERE
    // EXAMPLE
    public static final String GUEST_LIST_VIEW = "guest_list_view.fxml";

    private final Scene currentScene;
    private Stage primaryStage;
    private final ViewFactory viewFactory;

    public ViewHandler(ViewModelFactory viewModelFactory) {
        this.viewFactory = new ViewFactory(this, viewModelFactory);
        this.currentScene = new Scene(new Region());
    }

    public void start(Stage primaryStage){
        this.primaryStage = primaryStage;
        primaryStage.setResizable(false);
        openView(GUEST_LIST_VIEW);
    }

    public void openView(String id) {
        Region root = switch(id) {
            case GUEST_LIST_VIEW -> viewFactory.loadGuestListView();
            default -> throw new IllegalArgumentException("Unknown view: " + id);
        };
        currentScene.setRoot(root);
        primaryStage.setScene(currentScene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public void closeView() {
        primaryStage.close();
    }

}
