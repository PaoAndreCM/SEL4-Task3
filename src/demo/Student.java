package demo;

import java.util.Map;

public class Student {
    private String id;
    private String firstName;
    private String lastName;
    private Map<String, String> enrolledTo;

    public Student(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public Student(String id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this. lastName = lastName;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
            ", fName='" + firstName + '\'' +
            ", lName='" + lastName + '\'' +
            '}';
}


}
