package sample.controllers.dashboardController.ReceptionistDash.PostalMail;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import sample.models.PostalMail;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ViewDispMailList {

    @FXML
    private AnchorPane mailListAnchor;

    @FXML
    private TableView<PostalMail> mailTable;

    @FXML
    private TableColumn<PostalMail, String> fromCol;

    @FXML
    private TableColumn<PostalMail, String> toCol;

    @FXML
    private TableColumn<PostalMail, String> noteCol;

    @FXML
    private TableColumn<PostalMail, LocalDate> dateCol;

    @FXML
    private TableColumn<PostalMail, String> viewCol;

    @FXML
    private JFXButton addMailBtn;

    @FXML
    private Button viewMail;

    @FXML
    void addMail(ActionEvent event) {

    }

    public void initialize() throws IOException {
        ArrayList<PostalMail> mailArrayList = PostalMail.viewMail("Dispatched");
        ObservableList<PostalMail> obsMails = FXCollections.observableArrayList();
        obsMails.addAll(mailArrayList);

        fromCol.setCellValueFactory(new PropertyValueFactory<>("from"));
        toCol.setCellValueFactory(new PropertyValueFactory<>("toName"));
        noteCol.setCellValueFactory(new PropertyValueFactory<>("note"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        Callback<TableColumn<PostalMail,String>, TableCell<PostalMail,String>> cellFactory=(param) ->{
            return new TableCell<PostalMail,String>(){
                @Override
                public void updateItem(String item,boolean empty){
                    super.updateItem(item,empty);
                    if(empty){
                        setGraphic(null);
                    } else {
                        viewMail = new Button("View");
                        viewMail.setOnAction(event -> {
                            ViewDispMail.selectedMail= getTableView().getItems().get(getIndex());
                            BorderPane parentBorderPane = (BorderPane) (mailListAnchor.getParent());
                            try {
                                Parent viewComplain= FXMLLoader.load(getClass().getResource("../../../../views/dashboard/recepDash/PostalMail/viewDispatchedMail.fxml"));
                                parentBorderPane.setCenter(viewComplain);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });

                        setGraphic(viewMail);
                    }
                    setText(null);
                };
            };
        };


        viewCol.setCellFactory(cellFactory);
        mailTable.setItems(obsMails);
    }

}
