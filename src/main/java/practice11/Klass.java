package practice11;

import java.util.Observable;

public class Klass extends Observable {
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
        if (this.equals(student.getKlass())) {
            this.leader = student;
            this.setChanged();
            notifyObservers(student.getName() + " become Leader of Class " + this.number);
        } else {
            System.out.println("It is not one of us.");
        }
    }

    public Student getLeader() {
        return leader;
    }

    public void appendMember(Student student) {
        student.setKlass(this);
        this.setChanged();
        notifyObservers(student.getName() + " has joined Class " + this.number);
    }


    public boolean isIn(Student student) {
        return this.equals(student.getKlass());
    }
}
