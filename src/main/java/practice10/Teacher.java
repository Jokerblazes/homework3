package practice10;

import java.util.Set;

public class Teacher extends Person {

    private Set<Klass> classes;

    public Teacher(int id, String name, int age, Set<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Set<Klass> getClasses() {
        return classes;
    }

    @Override
    public String introduce() {
        if (classes == null)
            return basicIntroduce() + " I teach No Class.";
        else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(basicIntroduce())
                    .append(" I teach Class");
            classes.forEach(klass -> stringBuilder.append(" ")
                    .append(klass.getNumber()).
                            append(","));
            stringBuilder.deleteCharAt(stringBuilder.length() - 1)
                    .append(".");
            return stringBuilder.toString();
        }
    }

    public String introduceWith(Student student) {
        if (isTeaching(student)) {
            return basicIntroduce() +  " I teach " + student.getName() + ".";
        } else
            return basicIntroduce() +  " I don't teach " + student.getName() + ".";
    }

    private String basicIntroduce() {
        return super.introduce() + " I am a Teacher.";
    }

    public boolean isTeaching(Student student) {
        return classes.contains(student.getKlass());
    }
}
