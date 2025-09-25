import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class RenderMap extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();

        Canvas canvas = new Canvas();
        root.getChildren().add(canvas);

        stage.setTitle("FlyweightRPGMapGen");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
