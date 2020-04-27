package events;

public abstract class ControlEvent {
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract boolean eventPassed();


    @Override
    public String toString() {
          return "\n"+name + ", candidate number " + id + " " + (eventPassed()?"passed ":"failed ");
    }
}

