import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


/**
 * 
 */

/**
 * @author Shawn P Neuman
 * 
 */
public class FilterVBox
        extends VBox {



    private Text label;
    private Text keyWord;
    private Text location;
    private Text date;
    private Text dateRange;
    
    private TextField keyWordTF;
    private TextField locationTF;
    private TextField dateTF;
    private TextField dateRangeTF;

    /**
     * @param title
     */
    public FilterVBox(String title) {


        this.setStyle("-fx-background-color: cornsilk");

        this.setPadding(new Insets(10, 10, 10, 10));
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(20);
        
        label = new Text(title);
        label.setFont(Font.font("verdana", 16));
        this.getChildren().add(label);
        
        keyWord = new Text("Key Word");
        location = new Text("Location");
        date = new Text("Date");
        dateRange = new Text("Date Range");
        
        keyWordTF = new TextField();
        locationTF = new TextField();
        dateTF = new TextField();
        dateRangeTF = new TextField();
        
        grid.add(keyWord, 0, 0);
        grid.add(keyWordTF, 1, 0);
        
        grid.add(location, 0, 1);
        grid.add(locationTF, 1, 1);
        
        grid.add(date,0, 2);
        grid.add(dateTF, 1, 2);
        
        grid.add(dateRange, 0, 3);
        grid.add(dateRangeTF, 1, 3);
        
        this.getChildren().add(grid);
        
        
    }

}
