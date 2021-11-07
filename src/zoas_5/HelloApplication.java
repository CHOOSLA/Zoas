package zoas_5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;



public class HelloApplication extends Application implements Observer {

    Thread t;
    FXMLLoader fxmlLoader;
    Scene scene;
    @Override
    public void start(Stage stage) throws IOException {
        //매개변수 값을 저장하기 위한 작업
        //mediaPath는 전역변수 이므로 매우 위험,,
        Parameters params = getParameters();
        List<String> list = params.getRaw();


        fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml")); //fxml을 로드한다

        scene = new Scene(fxmlLoader.load(), 900, 600);
        HelloController test  =fxmlLoader.getController();
        stage.setTitle("ZOAS_MediaPlayer");
        stage.setScene(scene);
        stage.show();


    }

    public void openMediaPlayer(String args){
        launch(args);
    }

    public FXMLLoader getFxmlLoader(){
        return fxmlLoader;
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}


