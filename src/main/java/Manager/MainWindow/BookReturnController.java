package Manager.MainWindow;

import Manager.Model.BookLog;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import com.jfoenix.controls.*;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;

import Manager.shared.Util;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Iron on 2016/12/12.
 */
public class BookReturnController {

    public Label messageLabel;
    private List<BookLog> bookLogList;

    public JFXTextField bookIdTextField;
    @FXML
    private JFXTreeTableView<BookLog> bookListView;

    public void initialize() {
        bookLogList = new ArrayList<>();
        JFXTreeTableColumn<BookLog, Integer> idColumn = new JFXTreeTableColumn<>("图书编号");
        idColumn.setCellValueFactory(param -> new SimpleObjectProperty<Integer>(param.getValue().getValue().getId()));

        JFXTreeTableColumn<BookLog, String> titleColumn = new JFXTreeTableColumn<>("书名");
//        titleColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getTitle()));

        JFXTreeTableColumn<BookLog, String> publisherColumn = new JFXTreeTableColumn<>("出版社");
//        publisherColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getValue().getPublisher()));

        bookListView.getColumns().addAll(idColumn, titleColumn, publisherColumn);
        flashTable();
    }

    public void handleReturnBook(ActionEvent event) {
//        BookLog bookLog = null;
//        try{
//            bookLog = BookLog.selectBookById(Integer.parseInt(bookIdTextField.getText()));
//        }
//        catch (NumberFormatException e) {
//            Util.setMessageLabel(messageLabel, Util.MESSAGE_ERROR, "您的输入有误，请重新输入");
//            return;
//        }
//        if (bookLog == null) {
//            Util.setMessageLabel(messageLabel, Util.MESSAGE_ERROR, "该图书不存在");
//            return;
//        }
//        if (bookLog.getStatus() != BookLog.STATUS.OUTSIDE){
//            Util.setMessageLabel(messageLabel, Util.MESSAGE_ERROR, "该图书已在馆，无需归还");
//            return;
//        }
//        bookLog.setStatus(BookLog.STATUS.INSIDE);
//        bookLog.setBorrower(null);
//        bookLog.setBorrowedDate("null");
//        bookLog.save();
//        bookLogList.add(bookLog);
//        flashTable();
//        Util.setMessageLabel(messageLabel, Util.MESSAGE_SUCCESS, "图书归还成功");
    }

    public void flashTable() {
        ObservableList<BookLog> bookLogs = FXCollections.observableArrayList(bookLogList);
        final TreeItem<BookLog> root = new RecursiveTreeItem<BookLog>(bookLogs, RecursiveTreeObject::getChildren);
        bookListView.setRoot(root);
        bookListView.setShowRoot(false);
    }
}
