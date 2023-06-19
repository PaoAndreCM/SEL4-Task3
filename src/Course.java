import java.util.List;

public class Course {

    private int id;
    private String courseName;
    private int credits;
    private List<LabGroup> labGroups;

    public Course(int id, String courseName, int credits) {
        this.id = id;
        this.courseName = courseName;
        this.credits = credits;

        // creating and adding default lab groups per course
        LabGroup defaultLabGroup1 = new LabGroup(1,this);
        LabGroup defaultLabGroup2 = new LabGroup(2, this);
        this.labGroups.add(defaultLabGroup1);
        this.labGroups.add(defaultLabGroup2);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<LabGroup> getLabGroups() {
        return labGroups;
    }

    public void addNewLabGroup() {
        int id = labGroups.size() + 1;
        LabGroup newLabGroup = new LabGroup(id, this);
        labGroups.add(newLabGroup);
    }
}
