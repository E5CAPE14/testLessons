package callback;

public class People {
    private String name;

    public static People register(String name){
        return new People(new RegisterHandler(),name);
    }

    private People(Callback callback,String name){
        this(name);
        /*
            Передаем себя на отправку сообщения.
            Происходит в методе RegisterHandler.
         */
        callback.execute(this);
    }
    private People(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                '}';
    }
}
