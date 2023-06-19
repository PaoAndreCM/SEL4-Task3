import java.util.List;

public class Student {
    private String id;
    private String FName;
    private String LName;
    private List<LabGroup> enrolledTo;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public void setLName(String LName) {
        this.LName = LName;
    }

    public List<LabGroup> getEnrolledTo() {
        return enrolledTo;
    }

    public void setEnrolledTo(List<LabGroup> enrolledTo) {
        this.enrolledTo = enrolledTo;
    }

    public void addLabGroup(){

    }

}
