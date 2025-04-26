public class MyTestingClass {
    private int id;
    private int serialNumber;

    public MyTestingClass(int id, int serialNumber) {
        this.id = id;
        this.serialNumber = serialNumber;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = 31 * hash + id;
        hash = 31 * hash + serialNumber;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MyTestingClass)) return false;
        MyTestingClass other = (MyTestingClass) obj;
        return this.id == other.id && this.serialNumber == other.serialNumber;
    }
}
