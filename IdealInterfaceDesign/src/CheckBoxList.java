

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;


/**
 * @author Shawn P Neuman
 *
 */
public class CheckBoxList extends VBox {
    private Text             label;
    private Map<CheckBox, String> type;
    int              numSelected = 0;
//    int              selectionLimit;
    
    /**
     * @param title the title of this box
     * @param types the types of filters, e.g. flood, fire, quake, etc
//     * @param selectionLimit
     */
    public CheckBoxList(String title, String[] types) {
//        if(selectionLimit == null) {
//            
//        }
//        this.selectionLimit = selectionLimit;

        this.setStyle("-fx-background-color: cornsilk");
        this.setPadding(new Insets(10, 10, 10, 10));
        this.setSpacing(20);
        
        label = new Text(title);
        label.setFont(Font.font("verdana", 16));
        this.getChildren().add(label);
        type = new LinkedHashMap<>();
        populateList(types);
        
    }
    
    /**
     * populate a list of CheckBoxes
     * 
     * @param values
     */
    public void populateList(String[] values) {

        for (CheckBox zeBox : type.keySet()) {
            this.getChildren().remove(zeBox);
        }
        type.clear();
        for (String value : values) {

            final CheckBox checkBox = new CheckBox(value);
            // this can be used to limit the number of selections
            
//            checkBox.selectedProperty().addListener(
//                    new ChangeListener<Boolean>() {
//
//                        @Override
//                        public void changed(
//                                ObservableValue<? extends Boolean> observable,
//                                Boolean oldValue, Boolean newValue) {
//
//                            if (oldValue) {
//                                numSelected--;
//                            }
//                            else {
//                                numSelected++;
//                                if (numSelected > selectionLimit) {
//                                    checkBox.selectedProperty().setValue(false);
//        
//                                }
//                            }
//
//                        }
//
//
//                    });
            
            type.put(checkBox, value);
            this.getChildren().add(checkBox);

        }
    }

    /**
     * Returns the list of selected values.
     * 
     * @return the list of selected values.
     */
    public Set<String> getList() {

        Set<String> selectedList = new LinkedHashSet<>();

        for (CheckBox box : type.keySet()) {
            if (box.isSelected()) {

                selectedList.add(type.get(box));
            }
        }


        return selectedList;

    }

//    /**
//     * @param limit
//     */
//    public void setSelectionLimit(int limit) {
//
//        selectionLimit = limit;
//        System.out.println("Push the limit! " + limit);
//    }
}
