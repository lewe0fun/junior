package hw3;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.*;


/**
 * Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
 * Обеспечьте поддержку сериализации для этого класса. Создайте объект класса Student и инициализируйте его данными.
 * Сериализуйте этот объект в файл. Десериализуйте объект обратно в программу из файла. Выведите все поля объекта,
 * включая GPA, и обсудите, почему значение GPA не было сохранено/восстановлено.
 * 2. * Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документы).
 */
public class Progra {
    public static final ObjectMapper objectMapper = new ObjectMapper();
    public static final XmlMapper xmlMapper = new XmlMapper();

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Student student = new Student("Станислав", 37, 100);
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("student.bin"))) {
            objectOutputStream.writeObject(student);
            System.out.println("Объект Student сериализован в bin.");
        }

        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("student.bin"))) {
            student = (Student) objectInputStream.readObject();
            System.out.println("Объект Student десериализован из bin.");
        }

        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("GPA: " + student.getGPA());

        student = new Student("Мстислав", 33, 95);

        try {
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(new File("student.json"), student);
            System.out.println("Объект Student сериализован в json.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            student = objectMapper.readValue(new File("student.json"), objectMapper.getTypeFactory().constructType(Student.class));
            System.out.println("Объект Student сериализован в json.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("GPA: " + student.getGPA());

        student = new Student("Яйцеслав", 66, 13);

        try {
            xmlMapper.writeValue(new File("student.xml"), student);
            System.out.println("Объект Student сериализован в xml.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            student = xmlMapper.readValue("student.json", Student.class);
            System.out.println("Объект Student сериализован в json.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Имя: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("GPA: " + student.getGPA());
    }
}
