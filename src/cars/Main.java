package cars;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args){
        List<Car> list = new ArrayList<>();

        list.add(new Car((byte) 2));
        list.add(new Car((byte) 5));
        list.add(new Car((byte) 3));
        list.add(new Car((byte) 1));
        list.add(new Car((byte) 4));
        list.add(new Car((byte) 7));
        list.add(new Car((byte) 6));
        list.add(new Car((byte) 8));
        list.add(new Car((byte) 10));
        list.add(new Car((byte) 9));


        System.out.println(Arrays.toString(optionTwo(list)));
    }

    /*
        Решение задачи № 1
        Уверен в не правильности решения задачи.
    */
    public static void optionOne(List<Car> list){
        StringBuilder str = new StringBuilder();
        File file = new File("file.zip");
        ZipEntry zFile = new ZipEntry("finished.txt");
        try {
            if(!file.exists()) {
                file.createNewFile();
            }

            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
            zipOutputStream.putNextEntry(zFile);

            for (Car car:list) {
                str.append(car.toString());
            }

            zipOutputStream.write(str.toString().getBytes());
            zipOutputStream.flush();
            zipOutputStream.close();
        }
        catch (IOException e){
            /*
                Пробрасываем ошибку дальше.
                Либо обрабатываем.
                Может выскочить IOException при записи.
                Ошибку FileNotFoundException обработали на 41-43 строчке кода
             */
            throw new RuntimeException(e);
        }
    }
    /*
        Решение задачи № 2
        Просто передаем порядок номеров машин в порядке прибытия в массиве.
        + последнюю не записываем и соответсвенно приехала последней.
        c 20 байт до 9 байт
    */
    public static byte[] optionTwo(List<Car> list){
        byte[] ids = new byte[list.size() - 1];
        /*
            Мог имплементировать Comparable в Car (для метода compareTo(Object obj) ), но решил сделать так.
         */
        list.sort((x1,x2) -> {
            return x1.getPosition() - x2.getPosition();
        });

        for (int i = 0; i < list.size() - 1; i++) {
            ids[i] = list.get(i).getId();
        }

        return ids;
    }

}