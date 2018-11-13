package main.core;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import main.database.DBConnection;
import main.database.QueryBuilder;


import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    JFXTextField firstName;

    @FXML
    JFXTextField lastName;

    @FXML
    JFXTextField age;

    @FXML
    JFXComboBox<String> comboBox;

    Connection connection = DBConnection.getConnection();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList <String> options = FXCollections.observableArrayList(
                "Male", "Female"
        );

        comboBox.getItems().addAll(options);
    }



    @FXML
    private void onSaveButtonPress(ActionEvent event){

        String firstName = this.firstName.getText();

        String lastName = this.lastName.getText();

        String age  = this.age.getText();

        String gender = this.comboBox.getValue();

        List columns = new ArrayList();


        columns.add("first_name");

        columns.add("last_name");

        columns.add("age");

        columns.add("gender");

        columns.add("date_joined");

        List values = new ArrayList();

        values.add(firstName);

        values.add(lastName);

        values.add(age);

        values.add(gender);

        values.add(LocalDate.now());

        String table ="users";

        QueryBuilder.insertData(table,columns,values);


    }


}
