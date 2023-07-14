package cars;

public class Car {

    private static byte nextId = 1;
    private byte id;
    private byte position;


    public Car(byte position) {
        this.id = nextId++;
        this.position = position;
    }


    public byte getId() {
        return id;
    }

    public void setId(byte id) {
        this.id = id;
    }

    public byte getPosition() {
        return position;
    }

    public void setPosition(byte position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return id + " " + position;
    }
}