package sample.controllers.dashboardController.AdminDash;

import com.jfoenix.controls.JFXButton;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import sample.models.Crypto;
import sample.models.Patient;
import sample.models.User;
import sample.models.UserTasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PatientDetails  {

    static final HashMap<String, Parent> signUpscreenMap = new HashMap<>();

    @FXML
    private AnchorPane patientDetailAnchor;

    @FXML
    private TableView<User> userTable;

    @FXML
    private TableColumn<User, String> tableNameCol;

    @FXML
    private TableColumn<User, Integer> tableIdCol;

    @FXML
    private TableColumn<User, Integer> tablePhoneNoCol;

    @FXML
    private TableColumn<User, String > tableTasks;

    @FXML
    private Button viewButton;


    @FXML
    void addNewPatientBtn(ActionEvent event) throws IOException {
        Parent step1 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/patientDetails/SignUp1.fxml"));
        Parent step2 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/patientDetails/SignUp2.fxml"));
        Parent step3 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/patientDetails/SignUp3.fxml"));

        signUpscreenMap.put("step1",step1);
        signUpscreenMap.put("step2",step2);
        signUpscreenMap.put("step3",step3);

        

        BorderPane parentBorderPane = (BorderPane) (patientDetailAnchor.getParent());
        parentBorderPane.setCenter(signUpscreenMap.get("step1"));


    }

     public void initialize(){

         IntegerProperty hoveredID = new SimpleIntegerProperty(-1);

         userTable.setRowFactory(tableView -> {
             final TableRow<User> row = new TableRow<>();
             row.hoverProperty().addListener((observable,wasHovered,isNowHovered) -> {
                 final User user = row.getItem();
                 if (isNowHovered && user != null) {
                     hoveredID.set(row.getItem().getIdNumber());
                     System.out.println(hoveredID);
                 } else {
                     viewButton.setVisible(false);
                 }
             });

             return row;
         });

        try {
            ArrayList<User> userArrayList = UserTasks.viewUser(true,"Admin","Patient",null);
            ObservableList<User> obsUsers = FXCollections.observableArrayList();
            obsUsers.addAll(userArrayList);


            tableNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            tableIdCol.setCellValueFactory(new PropertyValueFactory<>("idNumber"));
            tablePhoneNoCol.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));


            Callback<TableColumn<User,String>, TableCell<User,String>> cellFactory=(param) ->{
                return new TableCell<User,String>(){
                    @Override
                    public void updateItem(String item,boolean empty){
                        super.updateItem(item,empty);
                        if(empty){
                            setGraphic(null);
                        } else {
                            viewButton = new Button("View");
                            viewButton.setVisible(false);

                            viewButton.setOnAction(event ->{
                                viewPatientDetails.selectedUser= (Patient) getTableView().getItems().get(getIndex());
                                BorderPane parentBorderPane = (BorderPane) (patientDetailAnchor.getParent());
                                try {
                                    Parent viewPatientDetails = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/patientDetails/viewPatientDetails.fxml"));
                                    parentBorderPane.setCenter(viewPatientDetails);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });


                            setGraphic(viewButton);
                        }
                        setText(null);
                    };
                };
            };



            tableTasks.setCellFactory(cellFactory);
            userTable.setItems(obsUsers);




        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
