public class BasicClasses {

}

class Main {
    public static void main (String[] args) {
        City a = new Capital("Mow", 20);
        City b = new Capital("Washington", 12);
        System.out.println(a.name);
        System.out.println(b.name);
        b.printP();
        System.out.println(a.getPeople());
    }
}

class City {
    String name;
    private int people;

    City (int people) {
        this.people = people;
    }

    void printP() {
        System.out.println(this.people);
    }

    int getPeople() {
        return people;
    }
}

class Capital extends City {
    Capital (String name, int people) {
        super(people);
        this.name = name;
    }

    @Override
    void printP() {
        System.out.println("This is the capital with name " + name);
    }
}

class Village extends City {
    Village(int people) {
        super(people);
    }


}