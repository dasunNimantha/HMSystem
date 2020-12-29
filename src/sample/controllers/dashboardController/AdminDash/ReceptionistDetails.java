package sample.controllers.dashboardController.AdminDash;

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
import sample.models.Receptionist;
import sample.models.User;
import sample.models.UserTasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ReceptionistDetails {

    static final HashMap<String, Parent> signUpRecepMap = new HashMap<>();

    @FXML
    private AnchorPane recepDetailAnchor;

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
    void addNewReceptionistBtn(ActionEvent event) throws IOException {
        Parent step1 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/recepDetails/SignUp1.fxml"));
        Parent step2 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/recepDetails/SignUp2.fxml"));
        Parent step3 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/recepDetails/Step3.fxml"));

        signUpRecepMap.put("step1",step1);
        signUpRecepMap.put("step2",step2);
        signUpRecepMap.put("step3",step3);



        BorderPane parentBorderPane = (BorderPane) (recepDetailAnchor.getParent());
        parentBorderPane.setCenter(signUpRecepMap.get("step1"));


    }

    public void initialize(){

        try {
            ArrayList<User> userArrayList = UserTasks.viewUser(true,"Admin","Receptionist",null);
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
                            viewButton.setOnAction(event ->{
                                viewReceptionistDetails.selectedUser= (Receptionist) getTableView().getItems().get(getIndex());
                                BorderPane parentBorderPane = (BorderPane) (recepDetailAnchor.getParent());
                                try {
                                    Parent viewReceptionistDetails = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/recepDetails/viewReceptionistDetails.fxml"));
                                    parentBorderPane.setCenter(viewReceptionistDetails);
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
