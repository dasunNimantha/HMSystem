<?xml version="1.0" encoding="UTF-8"?>

<?import com.jfoenix.controls.JFXButton?>
<?import javafx.scene.control.Label?>
<?import javafx.scene.control.TextField?>
<?import javafx.scene.layout.AnchorPane?>
<?import javafx.scene.shape.Circle?>
<?import javafx.scene.text.Font?>

<AnchorPane fx:id="moAppointAnchor" prefHeight="400.0" prefWidth="600.0" xmlns="http://javafx.com/javafx/11.0.1" xmlns:fx="http://javafx.com/fxml/1" fx:controller="sample.controllers.dashboardController.MODash.moViewAppointController">
   <children>
      <AnchorPane fx:id="viewAppointAnchor" layoutX="10.0" layoutY="10.0" prefHeight="583.0" prefWidth="986.0" style="-fx-background-color: #F5F5F5; -fx-background-radius: 8;">
         <children>
            <AnchorPane layoutX="29.0" layoutY="32.0" prefHeight="230.0" prefWidth="262.0" style="-fx-background-color: #EEEEEE; -fx-background-radius: 20; -fx-border-radius: 20;">
               <children>
                  <Circle fx:id="patientProfileImage" fill="WHITE" layoutX="131.0" layoutY="88.0" radius="74.0" stroke="WHITE" strokeType="INSIDE" />
                  <Label fx:id="patientName" alignment="CENTER" layoutX="21.0" layoutY="173.0" prefHeight="42.0" prefWidth="219.0" text="Dasun Nimamantha">
                     <font>
                        <Font name="System Bold" size="14.0" />
                     </font>
                  </Label>
               </children>
            </AnchorPane>
            <AnchorPane layoutX="29.0" layoutY="276.0" prefHeight="299.0" prefWidth="262.0" style="-fx-background-color: #EEEEEE; -fx-background-radius: 20; -fx-border-radius: 20;">
               <children>
                  <Label layoutX="18.0" layoutY="23.0" prefHeight="34.0" prefWidth="226.0" text="Information">
                     <font>
                        <Font name="System Bold" size="20.0" />
                     </font>
                  </Label>
                  <Label layoutX="22.0" layoutY="137.0" prefHeight="26.0" prefWidth="80.0" text="Age :" AnchorPane.leftAnchor="22.0">
                     <font>
                        <Font name="System Bold" size="14.0" />
                     </font>
                  </Label>
                  <Label layoutX="22.0" layoutY="188.0" prefHeight="26.0" prefWidth="80.0" text="Gender :" AnchorPane.leftAnchor="22.0">
                     <font>
                        <Font name="System Bold" size="14.0" />
                     </font>
                  </Label>
                  <Label layoutX="22.0" layoutY="242.0" prefHeight="26.0" prefWidth="87.0" text="Blood Type :" AnchorPane.leftAnchor="22.0">
                     <font>
                        <Font name="System Bold" size="14.0" />
                     </font>
                  </Label>
                  <TextField fx:id="ageText" alignment="CENTER" editable="false" layoutX="155.0" layoutY="137.0" prefHeight="27.0" prefWidth="92.0" style="-fx-border-color: transparent; -fx-background-color: transparent;" AnchorPane.leftAnchor="155.0" />
                  <TextField fx:id="genderText" alignment="CENTER" editable="false" layoutX="155.0" layoutY="188.0" prefHeight="27.0" prefWidth="92.0" style="-fx-background-color: transparent; -fx-border-color: transparent;" AnchorPane.leftAnchor="155.0" />
                  <TextField fx:id="bloodTypeText" alignment="CENTER" editable="false" layoutX="155.0" layoutY="242.0" prefHeight="27.0" prefWidth="92.0" style="-fx-background-color: transparent; -fx-border-color: transparent;" AnchorPane.leftAnchor="155.0" />
                  <Label layoutX="18.0" layoutY="86.0" prefHeight="26.0" prefWidth="134.0" text="Appointment No :">
                     <font>
                        <Font name="System Bold" size="14.0" />
                     </font>
                  </Label>
                  <TextField fx:id="appointmentNoLbl" alignment="CENTER" editable="false" layoutX="151.0" layoutY="86.0" prefHeight="27.0" prefWidth="92.0" style="-fx-border-color: transparent; -fx-background-color: transparent;" />
               </children>
            </AnchorPane>
            <AnchorPane layoutX="782.0" layoutY="32.0" prefHeight="123.0" prefWidth="160.0" style="-fx-background-color: #EEEEEE; -fx-background-radius: 20; -fx-border-radius: 20;">
               <children>
                  <Label fx:id="statusLbl" alignment="CENTER" layoutX="13.0" layoutY="62.0" prefHeight="42.0" prefWidth="134.0" text="Pending">
                     <font>
                        <Font name="System Bold" size="18.0" />
                     </font>
                  </Label>
                  <Label alignment="CENTER" layoutX="14.0" layoutY="14.0" prefHeight="42.0" prefWidth="134.0" text="Status">
                     <font>
                        <Font name="System Bold" size="26.0" />
                     </font>
                  </Label>
               </children>
            </AnchorPane>
            <AnchorPane layoutX="339.0" layoutY="188.0" prefHeight="260.0" prefWidth="279.0" style="-fx-background-color: #EEEEEE; -fx-background-radius: 20; -fx-border-radius: 20;">
               <children>
                  <Label alignment="CENTER" layoutX="46.0" layoutY="23.0" prefHeight="27.0" prefWidth="186.0" text="Symptoms">
                     <font>
                        <Font name="System Bold" size="18.0" />
                     </font>
                  </Label>
               </children>
            </AnchorPane>
            <AnchorPane layoutX="667.0" layoutY="188.0" prefHeight="260.0" prefWidth="274.0" style="-fx-background-color: #EEEEEE; -fx-background-radius: 20; -fx-border-radius: 20;">
               <children>
                  <Label alignment="CENTER" layoutX="45.0" layoutY="23.0" prefHeight="27.0" prefWidth="186.0" text="Allergies">
                     <font>
                        <Font name="System Bold" size="18.0" />
                     </font>
                  </Label>
               </children>
            </AnchorPane>
            <AnchorPane layoutX="561.0" layoutY="32.0" prefHeight="123.0" prefWidth="160.0" style="-fx-background-color: #EEEEEE; -fx-background-radius: 20; -fx-border-radius: 20;">
               <children>
                  <Label fx:id="timeLbl" alignment="CENTER" layoutX="32.0" layoutY="14.0" prefHeight="42.0" prefWidth="96.0" text="10.00">
                     <font>
                        <Font name="System Bold" size="28.0" />
                     </font>
                  </Label>
                  <Label fx:id="ampmLbl" alignment="CENTER" layoutX="29.0" layoutY="62.0" prefHeight="42.0" prefWidth="102.0" text="AM">
                     <font>
                        <Font name="System Bold" size="25.0" />
                     </font>
                  </Label>
               </children>
            </AnchorPane>
            <AnchorPane layoutX="339.0" layoutY="32.0" prefHeight="123.0" prefWidth="160.0" style="-fx-background-color: #EEEEEE; -fx-background-radius: 20; -fx-border-radius: 20;">
               <children>
                  <Label fx:id="dateLbl" alignment="CENTER" layoutX="32.0" layoutY="14.0" prefHeight="42.0" prefWidth="96.0" text="23">
                     <font>
                        <Font name="System Bold" size="28.0" />
                     </font>
                  </Label>
                  <Label fx:id="monthLbl" alignment="CENTER" layoutX="29.0" layoutY="56.0" prefHeight="42.0" prefWidth="102.0" text="Dec">
                     <font>
                        <Font name="System Bold" size="25.0" />
                     </font>
                  </Label>
               </children>
            </AnchorPane>
            <JFXButton fx:id="completeBtn" layoutX="522.0" layoutY="526.0" onAction="#completeAppo" prefHeight="42.0" prefWidth="242.0" style="-fx-background-color: #EEEEEE;" text="Mark as completed">
               <font>
                  <Font name="System Bold" size="12.0" />
               </font>
            </JFXButton>
            <JFXButton layoutX="815.0" layoutY="526.0" onAction="#backFromViewAppo" prefHeight="42.0" prefWidth="118.0" style="-fx-background-color: #EEEEEE;" text="Back">
               <font>
                  <Font name="System Bold" size="12.0" />
               </font>
            </JFXButton>
         </children>
      </AnchorPane>
   </children>
</AnchorPane>
