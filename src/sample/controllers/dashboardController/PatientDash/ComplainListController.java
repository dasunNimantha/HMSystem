package sample.controllers.dashboardController.PatientDash;

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
import sample.models.Complain;

import java.io.IOException;
import java.util.ArrayList;

public class ComplainListController {

    @FXML
    private AnchorPane complainViewAnchor;

    @FXML
    private Button viewComplain;


    @FXML
    private TableColumn<Complain, String> viewCol;


    @FXML
    private TableView<Complain> complainTable;

    @FXML
    private TableColumn<Complain, Integer> complainIdCol;

    @FXML
    private TableColumn<Complain, String> complainedDateCol;

    @FXML
    private TableColumn<Complain, String> complainTypeCol;

    @FXML
    private TableColumn<Complain, String> actionTakenCol;


    @FXML
    private TableColumn<Complain, String> complainedByCol;

    @FXML
    private JFXButton makeComplainBtn;

    @FXML
    void makeComplain(ActionEvent event) {

    }

    public void initialize() throws IOException {

        ArrayList<Complain> complainArrayList = Complain.viewComplain(false,"Patient",PatientController.patientData[0]);
        ObservableList<Complain> obsComplains = FXCollections.observableArrayList();
        obsComplains.addAll(complainArrayList);


        complainIdCol.setCellValueFactory(new PropertyValueFactory<>("complainID"));
        complainedByCol.setCellValueFactory(new PropertyValueFactory<>("complaintBy"));
        complainTypeCol.setCellValueFactory(new PropertyValueFactory<>("complainType"));
        complainedDateCol.setCellValueFactory(new PropertyValueFactory<>("complainedDate"));
        actionTakenCol.setCellValueFactory(new PropertyValueFactory<>("actionTaken"));

        Callback<TableColumn<Complain,String>, TableCell<Complain,String>> cellFactory=(param) ->{
            return new TableCell<Complain,String>(){
                @Override
                public void updateItem(String item,boolean empty){
                    super.updateItem(item,empty);
                    if(empty){
                        setGraphic(null);
                    } else {
                        viewComplain = new Button("View");
                        viewComplain.setOnAction(event -> {
                            ComplainViewController.selectedComplain= getTableView().getItems().get(getIndex());
                            BorderPane parentBorderPane = (BorderPane) (complainViewAnchor.getParent());
                            try {
                                Parent viewComplain= FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/ViewComplain.fxml"));
                                parentBorderPane.setCenter(viewComplain);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });

                        setGraphic(viewComplain);
                    }
                    setText(null);
                };
            };
        };


        viewCol.setCellFactory(cellFactory);
        complainTable.setItems(obsComplains);

    }

}
