package Manager.MainWindow;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXDrawersStack;
import com.jfoenix.controls.JFXNodesList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

/**
 * Created by Iron on 2016/12/7.
 */
public class BaseController {

    @FXML
    private StackPane stackPane;
    @FXML
    private Pane sideBarPane;
    @FXML
    private AnchorPane rootPane;

    public AnchorPane bookManagePane, readerManagePane, bookBorrowPane, bookReturnPane;

    private Node[] nodes;

    @FXML
    private JFXDrawersStack drawerStack;

    @FXML
    public void initialize() throws IOException {
        SharedControllers.baseController=this;
        bookBorrowPane = FXMLLoader.load(getClass().getResource("/FXML/BookBorrow.fxml"));
        bookReturnPane = FXMLLoader.load(getClass().getResource("/FXML/BookReturn.fxml"));
        bookManagePane = FXMLLoader.load(getClass().getResource("/FXML/BookManage.fxml"));
        readerManagePane = FXMLLoader.load(getClass().getResource("/FXML/ReaderManage.fxml"));
         nodes = new Node[]{
                bookBorrowPane,
                bookReturnPane,
                bookManagePane,
                readerManagePane
        };

        for (Node node :
                nodes) {
            node.setVisible(false);
            stackPane.getChildren().add(node);
        }

        bookBorrowPane.toFront();
        bookBorrowPane.setVisible(true);
    }


    public void handleCloseWindow(javafx.event.ActionEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }

    public void handleMinimize(javafx.event.ActionEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.setIconified(true);
    }


    public void handleReturnPane(javafx.event.ActionEvent event) {
        for (Node node :
                nodes) {
            node.setVisible(false);
        }
        bookReturnPane.setVisible(true);
        bookReturnPane.toFront();
    }

    public void handleBookManagePane(javafx.event.ActionEvent event) {
        for (Node node :
                nodes) {
            node.setVisible(false);
        }
        bookManagePane.setVisible(true);
        bookManagePane.toFront();
    }

    public void handleReaderManagePane(javafx.event.ActionEvent event) {
        for (Node node :
                nodes) {
            node.setVisible(false);
        }
        readerManagePane.setVisible(true);
        readerManagePane.toFront();
    }

    public void handleBorrowPane(javafx.event.ActionEvent event) {
        for (Node node :
                nodes) {
            node.setVisible(false);
        }
        bookBorrowPane.setVisible(true);
        bookBorrowPane.toFront();
    }
}
