package practice10;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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
            //由于HashSet并不会根据大小排序，所以先取出数值排序，再返回
            Set<Integer> set = new HashSet<>();
            classes.forEach(klass -> set.add(klass.getNumber()));
            set.stream().sorted().forEach(integer -> stringBuilder.append(" ")
                    .append(integer).
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
        for (Klass klass : classes) {
            if (klass.isIn(student)) {
                return true;
            }
        }
        return false;
    }
}
