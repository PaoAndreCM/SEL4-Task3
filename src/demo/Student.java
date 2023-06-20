package demo;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String id;
    private String fName;
    private String lName;
    private Map<String, String> enrolledTo;

    public Student(String id, String fName, String lName){
        this.id = id;
        this.fName = fName;
        this. lName = lName;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String FName) {
        this.fName = FName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String LName) {
        this.lName = LName;
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

    @Override
public String toString() {
    return "Student{" +
            "id='" + id + '\'' +
            ", fName='" + fName + '\'' +
            ", lName='" + lName + '\'' +
            '}';
}


}
