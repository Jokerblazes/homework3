package practice09;

public class Klass {
    private final int number;
    private Student leader;

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }


    public String getDisplayName() {
        return "Class " + number;
    }

    public void assignLeader(Student student) {
        if (this.equals(student.getKlass()))
            this.leader = student;
        else
            System.out.println("It is not one of us.");
    }

    public Student getLeader() {
        return leader;
    }

    public void appendMember(Student student) {
        student.setKlass(this);
    }
}
