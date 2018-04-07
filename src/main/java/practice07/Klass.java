package practice07;

public class Klass {
    private final int number;

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj))
            return true;
        if (!(obj instanceof Klass))
            return false;
        return number == ((Klass) obj).getNumber();
    }

    public String getDisplayName() {
        return "Class " + number;
    }
}

