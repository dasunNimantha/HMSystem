package sample.controllers.dashboardController.ReceptionistDash;

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
import sample.models.Visitor;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class RecepVisitorList {

    @FXML
    private AnchorPane visitorAnchor;

    @FXML
    private TableView<Visitor> visitorTable;

    @FXML
    private TableColumn<Visitor, String> nameCol;

    @FXML
    private TableColumn<Visitor, Integer> idNoCol;

    @FXML
    private TableColumn<Visitor, LocalDate> dateCol;

    @FXML
    private TableColumn<Visitor, String> purposeCol;

    @FXML
    private TableColumn<Visitor, LocalTime> inTimeCol;

    @FXML
    private TableColumn<Visitor, LocalTime> outTimeCol;

    @FXML
    private TableColumn<Visitor, String> viewCol;

    @FXML
    private JFXButton addVisitorBtn;

    @FXML
    private Button viewVisitor;

    @FXML
    void addVisitor(ActionEvent event) throws IOException {
        Parent addVisitor = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/recepAddVisitor.fxml"));
        BorderPane tempBorderPane = (BorderPane) visitorAnchor.getParent();
        tempBorderPane.setCenter(addVisitor);
    }

    public void initialize() throws IOException {
        ArrayList<Visitor> visitorArrayList = Visitor.viewComplain("Receptionist");
        ObservableList<Visitor> obsComplains = FXCollections.observableArrayList();
        obsComplains.addAll(visitorArrayList);

        idNoCol.setCellValueFactory(new PropertyValueFactory<>("idNo"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("visitorName"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        inTimeCol.setCellValueFactory(new PropertyValueFactory<>("inTime"));
        outTimeCol.setCellValueFactory(new PropertyValueFactory<>("outTime"));
        purposeCol.setCellValueFactory(new PropertyValueFactory<>("purpose"));


        Callback<TableColumn<Visitor,String>, TableCell<Visitor,String>> cellFactory=(param) ->{
            return new TableCell<Visitor,String>(){
                @Override
                public void updateItem(String item,boolean empty){
                    super.updateItem(item,empty);
                    if(empty){
                        setGraphic(null);
                    } else {
                        viewVisitor = new Button("View");
                        viewVisitor.setOnAction(event -> {
                            RecepViewVisitor.selectedVisitor= getTableView().getItems().get(getIndex());
                            BorderPane parentBorderPane = (BorderPane) (visitorAnchor.getParent());
                            try {
                                Parent viewComplain= FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/recepViewVisitor.fxml"));
                                parentBorderPane.setCenter(viewComplain);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });

                        setGraphic(viewVisitor);
                    }
                    setText(null);
                };
            };
        };


        viewCol.setCellFactory(cellFactory);
        visitorTable.setItems(obsComplains);

    }



}
