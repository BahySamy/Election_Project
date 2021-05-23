public class ElectDetails {
    String state;
    String candidate;
    int total_votes;
    public ElectDetails(String state, String candidate, int total_votes){
        this.state = state;
        this.candidate = candidate;
        this.total_votes =  total_votes;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCandidate() {
        return candidate;
    }

    public void setCandidate(String candidate) {
        this.candidate = candidate;
    }

    public int getTotal_votes() {
        return total_votes;
    }

    public void setTotal_votes(int total_votes) {
        this.total_votes = total_votes;
    }
}
