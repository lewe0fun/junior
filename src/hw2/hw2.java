package hw2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Задача 1:
 * Создайте абстрактный класс "Animal" с полями "name" и "age".
 * Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.
 * Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:
 * Выведите на экран информацию о каждом объекте.
 * Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
 * <p>
 * Дополнительная задача:
 * <p>
 * Доработайте метод генерации запроса на удаление объекта из таблицы БД (DELETE FROM <Table> WHERE ID = '<id>')
 * В классе QueryBuilder который мы разработали на семинаре.
 */
public class hw2 {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        //Animal animal1 = new Cat("Барсик", 5, "Ooo long jonson", "uniCatValue");
        //info(animal1);
        Animal[] animals=new Animal[]{
                new Cat("Tom", 5, "Ooo long jonson", "uniCatValue"),
                new Dog("Rex", 5, "Awawawawa", 228)};

        for (Animal animal: animals){
            info(animal);
        }
    }

    private static <T> void info(T obj) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();
        Field[] superFields = objClass.getSuperclass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            System.out.printf("%s: %s\n", field.getName(), field.get(obj));
        }
        for (Field field : superFields) {
            field.setAccessible(true);
            System.out.printf("%s: %s\n", field.getName(), field.get(obj));
        }
       Method makeSound = objClass.getMethod("makeSound");
        makeSound.invoke(obj);
    }
}
