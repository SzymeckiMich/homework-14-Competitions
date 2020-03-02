public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private double score;

    public Person(String firstName, String lastName, double score) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    @Override
    public int compareTo(Person o) {
        if (this.score > o.score) {
            return -1;
        } else if (this.score < o.score) {
            return 1;
        } else {
            return this.firstName.compareTo(o.firstName);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getScore() {
        return score;
    }
}
