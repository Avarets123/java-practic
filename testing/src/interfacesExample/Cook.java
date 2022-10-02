package interfacesExample;

public class Cook extends Worker implements CanCook {

    public Cook(String name) {
        super(name);
    }

    @Override
    public void cook() {
        System.out.println("Cooking");
    }
}
