import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

import java.util.List;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;


public class Main {
    public static void main(String[] args) {
        String FileName = "D:\\ITI\\Courses\\JAVA\\Day 4\\Election Project\\president_county_candidate.csv";
        Presidential_Election_Analysis E = new Presidential_Election_Analysis();
        List<ElectDetails> ElectionDetails = E.ReadData(FileName);
        E.WhoWins();

    }
}

