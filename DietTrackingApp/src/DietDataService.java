import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

public class DietDataService {
    
    private int AccountID;

    public DietDataService(int AccountID) {
        this.AccountID = AccountID;
    }

    public JFreeChart generateAveragePlate() {
        DietDataRepository dietDataRepository = new DietDataRepository();
        List<DietData> dietDataList = dietDataRepository.findByAccountID(this.AccountID);
        DefaultPieDataset<String> dataset = new DefaultPieDataset<>();

        for (DietData dietData : dietDataList) {
            dataset.setValue(dietData.getFoodGroupName(), dietData.getFoodGroupCount());
        }

        return ChartFactory.createPieChart("Your Average Plate: ", dataset, true, true, false);
    }
}
