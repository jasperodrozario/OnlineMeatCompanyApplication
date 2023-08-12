package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Jasper
 */
public class SaleReportController implements Initializable {

    @FXML
    private PieChart productSaleRatioPieChart;
    
    Alert anAlert = new Alert(Alert.AlertType.ERROR);

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<PieChart.Data> generatedPieDataSet = Product.getProductSaleRatioChart();
        if(generatedPieDataSet != null) {
            productSaleRatioPieChart.setData(generatedPieDataSet);
        }
        else {
            anAlert.setContentText("generatedPieDataSet is null");
            anAlert.show();
        }
    }    
    
    
    
}
