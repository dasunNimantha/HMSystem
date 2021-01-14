package sample.controllers.dashboardController;

import com.jfoenix.controls.JFXProgressBar;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ResourceBundle;

public class WebViewController implements Initializable {

    static  WebEngine web;
    static boolean connectionAvailable= false;

    @FXML
    private WebView webView;

    @FXML
    private JFXProgressBar webLoadingBar;

    @FXML
    private AnchorPane conErrorAnchor;

    @FXML
    private BorderPane webViewBorderPane;

    @FXML
    void backWeb(ActionEvent event) {
        final WebHistory webHistory = web.getHistory();
        int urlIndex = webHistory.getCurrentIndex()-1;
        if(urlIndex>=0){
            web.load(webHistory.getEntries().get(urlIndex).getUrl());
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            URL conCheckUrl = new URL("http://www.google.com/");
            URLConnection connection = conCheckUrl.openConnection();
            connection.connect();
            connectionAvailable = true;
        } catch (IOException e) {
            System.out.println("No Internet");
        }

        if(connectionAvailable){
            web = webView.getEngine();
            String urlWeb = "http://www.google.com";
            web.load(urlWeb);

            webLoadingBar.progressProperty().bind(web.getLoadWorker().progressProperty());
            web.getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
                @Override
                public void changed(ObservableValue<? extends Worker.State> observableValue, Worker.State state, Worker.State newValue) {
                    if(newValue == Worker.State.SUCCEEDED ){
                        webLoadingBar.setVisible(false);
                    }
                }
            });
        }

    }



}
