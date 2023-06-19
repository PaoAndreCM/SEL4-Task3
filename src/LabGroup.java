import java.util.List;
import java.util.SplittableRandom;

public class LabGroup {
    private int id;
    private int size;
    private int freeSpots;
    private Course parentCourse;
    private List<Student> participants;

    public LabGroup(int id, Course parentCourse){
        this.id = id;
        this.size = this.freeSpots =  20; // every LabGroup is created with 20 spots available by default
        this.parentCourse = parentCourse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getFreeSpots() {
        return freeSpots;
    }

    public void setFreeSpots(int freeSpots) {
        this.freeSpots = freeSpots;
    }

    public Course getParentCourse() {
        return parentCourse;
    }

    public void setParentCourse(Course parentCourse) {
        this.parentCourse = parentCourse;
    }

    public List<Student> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Student> participants) {
        this.participants = participants;
    }

    public void updateLabGroupSize(int newSize){
        int oldSize = size;
        size = newSize;
        freeSpots = freeSpots + (newSize - oldSize);
    }

    public void removeOneFreeSpot(){
        if( freeSpots > 0 ) {
            this.freeSpots = freeSpots-1;
        } else {
            System.out.println("No more free spots");
        }
    }

    public void addParticipant(Student participant){
        participants.add(participant);
    }

    public void removeParticipant(String participantId){
        for (Student participant:participants) {
            if ( participant.getId().equals(participantId)) {
                participants.remove(participant);
            }
        }
    }
}
