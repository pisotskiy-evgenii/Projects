package circle;

public class NotValueOfRadius extends Exception {
    @Override
    public String toString() {
        return "the radius doesn't set. Please, set it";
    }

}
