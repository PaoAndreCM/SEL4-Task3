
import java.util.Map;

public class Student {
    private String id;
    private String FName;
    private String LName;
    private Map<String, String> enrolledTo;


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

    public Map<String, String> getEnrolledTo() {
        return enrolledTo;
    }

    public void setEnrolledTo(Map<String, String> enrolledTo) {
        this.enrolledTo = enrolledTo;
    }

    public void enrollToLabGroup(String courseId, String labGroupId){
        enrolledTo.put(courseId,labGroupId);
    }

    public void updateLabGroup(String courseId, String labgroupId){
        enrolledTo.replace(courseId,labgroupId);
    }

}
