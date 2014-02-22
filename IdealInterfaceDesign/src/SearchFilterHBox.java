import javafx.geometry.Insets;
import javafx.scene.layout.HBox;


/**
 * 
 */

/**
 * @author Shawn P Neuman
 * 
 */
public class SearchFilterHBox
        extends HBox {


    private CheckBoxList eventType;
    private CheckBoxList dataType;
    private FilterVBox filterBox;


    /**
     * 
     */
    public SearchFilterHBox () {
        
        this.setStyle("-fx-background-color: cornsilk");
        
        this.setPadding(new Insets(10, 10, 10, 10));
        
        String[] types = {"EarthQuake", "Fire", "Flood", "Hurricane", 
                "Shooting", "Tornado", "Tsunami", "Zombie Apocalypse" };       
        eventType = new CheckBoxList("Event Type", types);
        
        String[] filters = {"Tweets", "Web Pages", "Images"};
        dataType = new CheckBoxList("Data Type", filters);
        
        filterBox = new FilterVBox("Filters");
        
        this.getChildren().addAll(eventType, dataType, filterBox);
        
        
    }
}
