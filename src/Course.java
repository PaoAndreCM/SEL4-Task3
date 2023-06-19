import java.util.List;

public class Course {

    private String id;
    private String courseName;
    private int credits;
    private List<LabGroup> labGroups;

    public Course(String id, String courseName, int credits) {
        this.id = id;
        this.courseName = courseName;
        this.credits = credits;
        this.labGroups = labGroups; // TODO build two labs and add them to the list
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
