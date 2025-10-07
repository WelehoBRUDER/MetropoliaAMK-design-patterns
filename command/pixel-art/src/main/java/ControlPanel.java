import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ControlPanel {
    private Controls controls;
    private PixelCanvas root;
    private HBox hBox;

    public ControlPanel(Controls controls, PixelCanvas root) {
        this.controls = controls;
        this.root = root;
        this.hBox = new HBox(10);

        Button generateCodeButton = new Button("Generate Code");
        Button clearButton = new Button("Clear");
        generateCodeButton.setFocusTraversable(false);
        clearButton.setFocusTraversable(false);

        generateCodeButton.setOnAction(e -> {
           controls.generateCode();
           root.getCanvas().requestFocus();
        });

        clearButton.setOnAction(e -> {
            controls.clearCanvas();
            root.getCanvas().requestFocus();
        });

        hBox.getChildren().addAll(generateCodeButton, clearButton);
    }

    public HBox getHBox() {
        return hBox;
    }

}
