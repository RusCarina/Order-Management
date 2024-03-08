package bll.validators;

        import model.Clients;

public class AgeValidator implements Validator<Clients> {
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 80;

    public void validate(Clients t) {

        if (t.getAge() < MIN_AGE || t.getAge() > MAX_AGE) {
            throw new IllegalArgumentException("The Student Age limit is not respected!");
        }

    }

}

