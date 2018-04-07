package practice06;

public class Teacher extends Person {
    private static final int NO_CLASS = -1;
    private int klass;

    public Teacher(String name, int age, int klass) {
        super(name,age);
        this.klass = klass;
    }

    public Teacher(String name, int age) {
        super(name, age);
        klass = NO_CLASS;
    }


    public int getKlass() {
        return klass;
    }

    @Override
    public String introduce() {
        if (klass == NO_CLASS)
            return super.introduce() + " I am a Teacher. I teach No Class.";
        else
            return super.introduce() + " I am a Teacher. I teach Class " + klass + ".";
    }
}
