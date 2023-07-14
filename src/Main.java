

public class Main {

    public static void main(String[] args) {
        Integer i = new Integer(127);
        Integer j = new Integer(127);
        System.out.println(i.equals(j));

        /**
         *  На 17 java даже не скопилируется ;-)
         */
    }

}
