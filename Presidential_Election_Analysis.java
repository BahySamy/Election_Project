import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoubleToIntFunction;

public class Presidential_Election_Analysis {

    public List<ElectDetails> ReadData(String FileName){
        List<ElectDetails> jobdetails = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(FileName))) {
            String line = br.readLine();
            if (line != null) {
                line = br.readLine(); // the first real data
            }
            while (line != null) {
                String[] attributes = line.split(",");
                ElectDetails jd = CreateElectDetails(attributes);
                jobdetails.add(jd);
                line = br.readLine();
            }


        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return jobdetails;
    }

    public ElectDetails CreateElectDetails(String[] metadata){
        String state = metadata[0];
        String candidate = metadata[2];
        int  total_votes = 0;
        if(metadata[4]!=null && metadata[4].length()>0)
            total_votes= Integer.parseInt(metadata[4]);
        return new ElectDetails(state, candidate, total_votes);
    }

    public int Total(){
        String FileName = "D:\\ITI\\Courses\\JAVA\\Day 4\\Election Project\\president_county_candidate.csv";
        Presidential_Election_Analysis E = new Presidential_Election_Analysis();
        List<ElectDetails> ElectionDetails = E.ReadData(FileName);
        List<Integer> total_array= new ArrayList<>();
        for(ElectDetails k:ElectionDetails){
            total_array.add(k.total_votes);
        }
        int total_sum = 0;
        for(int k: total_array ){
            total_sum = total_sum + k;
        }
        System.out.println(total_sum);
        return total_sum;
    }

    public int trump_percentage() {
        String FileName = "D:\\ITI\\Courses\\JAVA\\Day 4\\Election Project\\president_county_candidate.csv";
        Presidential_Election_Analysis E = new Presidential_Election_Analysis();
        List<ElectDetails> ElectionDetails = E.ReadData(FileName);
        List<Integer> total_array = new ArrayList<>();
        List<String> candidate_array = new ArrayList<>();

        for (ElectDetails k : ElectionDetails) {
            total_array.add(k.total_votes);
        }

        for (ElectDetails k : ElectionDetails) {
            candidate_array.add(k.candidate);
        }

        List<Integer> trump_votes = new ArrayList<>();
        for(int i=0; i < candidate_array.toArray().length;i++) {
            //System.out.println(candidate_array.get(i));
            if (candidate_array.get(i).equals("Donald Trump")) {
                trump_votes.add(total_array.get(i));
            }
        }
        int trump_sum = 0;
        for(int d=0; d < trump_votes.toArray().length;d++ ){
            trump_sum = trump_sum + trump_votes.get(d);

        }
        System.out.println("Trump Votes:");
        System.out.println(trump_sum);
        return trump_sum;
        }

    public int biden_percentage() {
        String FileName = "D:\\ITI\\Courses\\JAVA\\Day 4\\Election Project\\president_county_candidate.csv";
        Presidential_Election_Analysis E = new Presidential_Election_Analysis();
        List<ElectDetails> ElectionDetails = E.ReadData(FileName);
        List<Integer> total_array = new ArrayList<>();
        List<String> candidate_array = new ArrayList<>();

        for (ElectDetails k : ElectionDetails) {
            total_array.add(k.total_votes);
        }

        for (ElectDetails k : ElectionDetails) {
            candidate_array.add(k.candidate);
        }

        List<Integer> biden_votes = new ArrayList<>();
        for(int i=0; i < candidate_array.toArray().length;i++) {
            //System.out.println(candidate_array.get(i));
            if (candidate_array.get(i).equals("Joe Biden")) {
                biden_votes.add(total_array.get(i));

            }
        }
        int biden_sum = 0;
        for(int z=0; z < biden_votes.toArray().length;z++ ){
            biden_sum = biden_sum + biden_votes.get(z);
        }
        System.out.println("Biden Votes:");
        System.out.println(biden_sum);
        return biden_sum;
    }

    public void WhoWins(){
        String FileName = "D:\\ITI\\Courses\\JAVA\\Day 4\\Election Project\\president_county_candidate.csv";
        Presidential_Election_Analysis E = new Presidential_Election_Analysis();
        List<ElectDetails> ElectionDetails = E.ReadData(FileName);
        if(E.biden_percentage() > E.trump_percentage()){
            System.out.println("Biden Wins!");
        }else{
            System.out.println("Trump Wins!");
        }

    }
}



