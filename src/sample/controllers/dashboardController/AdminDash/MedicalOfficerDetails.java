package sample.controllers.dashboardController.AdminDash;

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
import sample.models.MedicalOfficer;
import sample.models.Receptionist;
import sample.models.User;
import sample.models.UserTasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MedicalOfficerDetails {


    @FXML
    private AnchorPane moDetailAnchor;

    static final HashMap<String, Parent> signUpMOScreenMap = new HashMap<>();

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

    static final HashMap<String, Parent> signUpmoMap = new HashMap<>();

    @FXML
    void addNewMOBtn(ActionEvent event) throws IOException {

        Parent step1 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/moDetails/SignUp1.fxml"));
        Parent step2 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/moDetails/SignUp2.fxml"));
        Parent step3 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/moDetails/Step3.fxml"));
        signUpmoMap.put("step1",step1);
        signUpmoMap.put("step2",step2);
        signUpmoMap.put("step3",step3);

        BorderPane parentBorderPane = (BorderPane) (moDetailAnchor.getParent());
        parentBorderPane.setCenter(signUpmoMap.get("step1"));
    }

    public void initialize() throws IOException {
        try {
            ArrayList<User> userArrayList = UserTasks.viewUser(true,"Admin","Medical_Officer",null);
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
                            final Button viewButton = new Button("View");
                            viewButton.setOnAction(event -> {
                                viewMODetails.selectedUser= (MedicalOfficer) getTableView().getItems().get(getIndex());
                                BorderPane parentBorderPane = (BorderPane) (moDetailAnchor.getParent());
                                try {
                                    Parent viewMODetails = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/moDetails/viewMODetails.fxml"));
                                    parentBorderPane.setCenter(viewMODetails);
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
