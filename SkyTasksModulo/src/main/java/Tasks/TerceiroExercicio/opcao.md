## Outra opcão da terceira questão com JavaFX

 ```
 imports & package
 
public class Main {

    private static final String VIDEO_PATH = "src/main/resources/com/video/sky/apos_skytef_rede_ancora.mp4";

    public static void main(String[] args) {
 
        initJavaFXToolkit();

        Platform.runLater(() -> {
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Reprodução de Vídeo");

    
            File videoFile = new File(VIDEO_PATH);
            Media media = new Media(videoFile.toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setAutoPlay(true);

            MediaView mediaView = new MediaView(mediaPlayer);
            mediaView.setFitWidth(primaryStage.getWidth());
            mediaView.setFitHeight(primaryStage.getHeight());

            Button closeButton = new Button("Fechar");
            closeButton.setOnAction(event -> {
                mediaPlayer.dispose();
                primaryStage.close();
            });
            
            StackPane root = new StackPane();
            root.getChildren().addAll(mediaView, closeButton);
            
            Scene scene = new Scene(root, 1280, 720);
            primaryStage.setScene(scene);
            primaryStage.setFullScreen(true);

            primaryStage.show();
        });
    }

    private static void initJavaFXToolkit() {
        new JFXPanel(); 
    }
}

 ```
