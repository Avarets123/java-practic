package interfacesExample;

public class Programmer extends Worker implements CanProgramming {

    public Programmer(String name) {
        super(name);
    }

    @Override
    public void programming() {
        System.out.println("Programming");
    }
}
