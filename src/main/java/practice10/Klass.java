package practice10;

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

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj))
            return true;
        if (!(obj instanceof Klass))
            return false;
        return number == ((Klass) obj).getNumber();
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


    public boolean isIn(Student student) {
        return this.equals(student.getKlass());
    }
}
