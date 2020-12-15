package sample.controllers;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import sample.controllers.SceneLoader;
import sample.controllers.SceneLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.HashMap;

// This function is used to change multiple scenes in one stage

public class ScreenController {
    private final HashMap<String, Parent> screenMap = new HashMap<>();
    private final Scene main;

    public ScreenController(Scene scene) {
        main = scene;
    }

    public void addScreen(String name,Parent pane){
        screenMap.put(name, pane);
    }

    public void removeScreen(String name) {
        screenMap.remove(name);
    }

    public void activate(String name) {
        main.setRoot(screenMap.get(name));
    }
}
