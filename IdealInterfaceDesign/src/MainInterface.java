import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


/**
 * 
 */

/**
 * @author Shawn P Neuman
 * 
 */
public class MainInterface
        extends Application {

    private String TITLE = "WEB ARCHIVE SEARCH TOOL";
    private Scene            scene;
    private TabPane          tabPane;
    private Tab              tabA;
//    private Tab              tabB;
    private SearchFilterHBox searchBox;



    /**
     * main method, will launch with command line arguments
     * 
     * @param args
     */
    public static void main(String[] args) {

        launch(args);
    }



    @Override
    public void start(final Stage primary) {
        
        primary.setTitle(TITLE);

        scene = new Scene(new VBox(), 1650, 800, Color.GOLDENROD);

        // HBox searchFilters = new HBox();

        searchBox = new SearchFilterHBox();
        tabPane = new TabPane();
        tabPane.setMinHeight(30);

        tabA = new Tab("Search Parameters");
//        tabB = new Tab("Search Results");
        tabA.setClosable(false);
//        tabB.setClosable(false);
        tabPane.getTabs().addAll(tabA);

        tabA.setContent(searchBox);
//         tabB.setContent(resultsBox);
//        tabB.setDisable(true);

        ((VBox) scene.getRoot()).getChildren().add(tabPane);

        primary.setScene(scene);

        primary.show();

    }

}
