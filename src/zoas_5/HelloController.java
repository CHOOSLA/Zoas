package zoas_5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javafx.util.Duration;

import javax.swing.tree.ExpandVetoException;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private AnchorPane mainPane;

    @FXML
    private GridPane videoPane;
    @FXML
    private GridPane controlPane;

    @FXML
    private Pane controlUnionPane;

    @FXML
    private GridPane test;

    @FXML
    public MediaView media_p;

    @FXML
    private AnchorPane media_c;

    @FXML
    private Button start_bt;

    @FXML
    private Button stop_bt;

    @FXML
    private Slider media_s;

    @FXML
    private AnchorPane volume_p;
    @FXML
    private Label volume_t;
    @FXML
    private Slider volume_s;


    private ImageView ivPlay;
    private ImageView ivPause;

    private boolean flag = false;

    private ChangeListener<? super Number> widthChangeListener;
    private ChangeListener<? super Number> heightChangeListener;

    public static String mediaPath = null;
    public static String seekSentance = null;

    Media mediaVideo;
    public static MediaPlayer mediaplayer;

    Thread t;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        final int IV_WIDTH = 75;
        final int IV_HEIGHT = 100;
        //new File(mediaPath).toURI().toString()
        mediaVideo = new Media(mediaPath); //미디어 연결
        mediaplayer = new MediaPlayer(mediaVideo);
        media_p.setMediaPlayer(mediaplayer);
        //media_p.setLayoutX(mediaVideo.getWidth());
        //media_p.setLayoutY(mediaVideo.getHeight());
        mediaplayer.setAutoPlay(true);



        try {
            Image ImagePlay = new Image(new File("src/main/java/com/example/demo/resources/play-btn.png").toURL().toString());
            ivPlay = new ImageView(ImagePlay);
            ivPlay.setFitHeight(IV_HEIGHT);
            ivPlay.setFitWidth(IV_WIDTH);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try {
            Image ImagePause = new Image(new File("src/main/java/com/example/demo/resources/stop-btn.png").toURL().toString());
            ivPause = new ImageView(ImagePause);
            ivPause.setFitHeight(IV_HEIGHT);
            ivPause.setFitWidth(IV_WIDTH);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        start_bt.setGraphic(ivPlay);
        stop_bt.setGraphic(ivPause);

        volume_t.setText("Volume");


        start_bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mediaplayer.play();
            }
        });
        stop_bt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mediaplayer.pause();
            }
        });
        volume_s.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                mediaplayer.setVolume(volume_s.getValue());
            }
        });
        volume_s.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                volume_s.setValue(t1.doubleValue());
                mediaplayer.setVolume(t1.doubleValue());
            }
        });


        media_s.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                media_s.setMax(mediaVideo.getDuration().toSeconds());
                double currentTime = mediaplayer.getCurrentTime().toSeconds();
                if(Math.abs(currentTime - t1.doubleValue()) > 0.5){
                    mediaplayer.seek(Duration.seconds( t1.doubleValue()));
                }
            }
        });

        // 동영상 크기 변하게 만들기
        ChangeListener<Number> mainPaneSizeListener = (observable, oldValue, newValue) -> {
            ReadOnlyDoubleProperty property = (ReadOnlyDoubleProperty)observable;
            String id = ((Pane)property.getBean()).getId(); // Pane 이름
            String name = property.getName(); // 바꾸는 항목
            Double value = property.getValue(); //값


            if(value==600.0 && !flag){
                flag = true;
                return;
            }

            if(id.equals("mainPane")){
                if(name.equals("width")){
                    videoPane.setMinWidth(value);
                    videoPane.setMaxWidth(value);

                    if(media_p.getFitHeight() >= videoPane.getHeight() && media_p.getFitWidth() <= videoPane.getWidth()
                    || videoPane.getHeight()==0.0){
                        return;
                    }
                    media_p.setFitHeight(media_p.getFitWidth()/2);
                    media_p.setFitWidth(videoPane.getWidth());

                }
                if(name.equals("height")){
                    value = value - media_c.getHeight();
                    videoPane.setMinHeight(value);
                    videoPane.setMaxHeight(value);
                }

                if(media_p.getFitWidth() >= videoPane.getWidth() && media_p.getFitHeight() <= videoPane.getHeight()
                        || videoPane.getHeight()==0.0){
                    return;
                }
                media_p.setFitWidth(media_p.getFitHeight()*2);
                media_p.setFitHeight(videoPane.getHeight());
            }

        };

        mainPane.widthProperty().addListener(mainPaneSizeListener);
        mainPane.heightProperty().addListener(mainPaneSizeListener);

        // 컨트롤 바 좌우 위치 조정
        ChangeListener<Number> videoPaneWidthListener = (observable, oldValue, newValue) -> {
            controlPane.setMinWidth(newValue.doubleValue());
            controlPane.setMaxWidth(newValue.doubleValue());

            double tmp = newValue.doubleValue() / 2;
            double tmp2 = controlUnionPane.getPrefWidth() / 2;

            controlUnionPane.setLayoutX(tmp - tmp2);
        };

        // 컨트롤 바 위아래 위치 조정
        ChangeListener<Number> videoPaneHeightListener = (observable, oldValue, newValue) -> {
            controlPane.setLayoutY(newValue.doubleValue());
        };

        videoPane.widthProperty().addListener(videoPaneWidthListener);
        videoPane.heightProperty().addListener(videoPaneHeightListener);

        // 문장이 넘어 온 것을 확인하기 위한 작업
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("확인중...");
                while(true){
                    if(seekSentance!=null){
                        try {
                            //mediaplayer.seek(Duration.seconds(500.0));
                            //media_s.setValue(500.0);
                            Thread.sleep(1000);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        });
        t.start();

    }


    public String getTime (java.time.Duration time){
        int hours = (int)time.toHours();
        int minutes = (int)time.toMinutes();
        int seconds = (int)time.toSeconds();

        if (seconds > 59) seconds = seconds % 60;
        if (minutes > 59) minutes = minutes % 60;
        if (hours > 59) hours = hours % 60;

        if(hours>0) return String.format("%d:%02d:%02d",hours, minutes,seconds);
        else return String.format("%02d:%02d",minutes, seconds);
    }

    class CheckComing implements Runnable {
        @Override
        public void run() {
            while(true){
                if(seekSentance!=null){
                    mediaplayer.seek(Duration.seconds(500.0));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}