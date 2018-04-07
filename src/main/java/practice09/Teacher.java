package practice09;

public class Teacher extends Person {

    private Klass klass;

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Klass getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        if (klass == null)
            return basicIntroduce() + " I teach No Class.";
        else
            return basicIntroduce() +  " I teach " + klass.getDisplayName() + ".";
    }

    public String introduceWith(Student student) {
        if (student.getKlass().equals(klass)) {
            return basicIntroduce() +  " I teach " + student.getName() + ".";
        } else
            return basicIntroduce() +  " I don't teach " + student.getName() + ".";
    }

    private String basicIntroduce() {
        return super.introduce() + " I am a Teacher.";
    }
}
