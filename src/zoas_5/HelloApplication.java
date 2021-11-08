package zoas_5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.scene.control.DialogEvent;
import javafx.scene.control.DialogPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;


import static zoas_5.HelloController.mediaPath;
import static zoas_5.HelloController.seekSentance;



public class HelloApplication extends Application {

    Thread t;
    FXMLLoader fxmlLoader;
    Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
        //매개변수 값을 저장하기 위한 작업
        //mediaPath는 전역변수 이므로 매우 위험,,
        Parameters params = getParameters();
        List<String> list = params.getRaw();
        mediaPath = list.get(0);

        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("resources/hello-view.fxml")); //fxml을 로드한다

        scene = new Scene(fxmlLoader.load(), 900, 600);
        HelloController test  =fxmlLoader.getController();
        stage.setTitle("ZOAS_MediaPlayer");
        stage.setScene(scene);
        stage.show();
    }



    @Override
    public void stop(){
        System.out.println("stop!!!!\n\n\n");
    }

    public void openMediaPlayer(String args){
        launch(args);
    }

    public FXMLLoader getFxmlLoader(){
        return fxmlLoader;
    }
}

class test2 {

    FXMLLoader fxmlLoader;

    public static void main(String[] args){
        HelloController.seekSentance = "";


        System.out.println("이거");
        HelloApplication yes = new HelloApplication();
        yes.openMediaPlayer("src/zoas_5/resources/test.mp4"); // 계속 실행됨

    }
}


