package org.example;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.example.model.Student;

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // Getting Class object using forName()
            Class<?> clazz = Class.forName("org.example.model.Student");

            // *********CLASS INFORMATION ACCESS*********
            // Display class name
            System.out.println("Class name: " + clazz.getName());

            // Display package name
            System.out.println("Package name: " + clazz.getPackage().getName());

            // *********CONSTRUCTORS*********
            // Get all constructors
            Constructor<?>[] constructors = clazz.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println("Constructor: " + constructor);
            }

            // Get a specific constructor (with parameters)
            Constructor<?> constructor = clazz.getConstructor(String.class, int.class);
            System.out.println("Constructor with parameters: " + constructor);

            // Create a new instance using the constructor
            Student studentInstance = (Student) constructor.newInstance("John Doe", 20);
            System.out.println("Student Instance: Name = " + studentInstance.getName() + ", Age = " + studentInstance.getAge());

            // *********METHODS*********
            // Get all public methods
            Method[] methods = clazz.getMethods();
            for (Method method : methods) {
                System.out.println("Method: " + method.getName());
            }

            // Get a specific method (e.g., setName(String))
            Method setNameMethod = clazz.getMethod("setName", String.class);
            System.out.println("Specific method: " + setNameMethod);

            // Invoke the setName method
            setNameMethod.invoke(studentInstance, "Jane Doe");

            // Get the getName() method and invoke it
            Method getNameMethod = clazz.getMethod("getName");
            String name = (String) getNameMethod.invoke(studentInstance);
            System.out.println("Updated Name: " + name);

            // *********INVOKING PRIVATE METHODS*********
            // Get the private method displayInfo()
            Method displayInfoMethod = clazz.getDeclaredMethod("displayInfo");

            // Make the private method accessible
            displayInfoMethod.setAccessible(true);

            // Invoke the private method
            displayInfoMethod.invoke(studentInstance);

            // *********FIELDS*********
            // Get all declared fields (including private fields)
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                System.out.println("Declared Field: " + field.getName());
            }

            // Get the private field "name"
            Field nameField = clazz.getDeclaredField("name");

            // Make the private field accessible
            nameField.setAccessible(true);

            // Modify the value of the field
            nameField.set(studentInstance, "Alice Johnson");

            // Get the modified value of the field
            String nameValue = (String) nameField.get(studentInstance);
            System.out.println("Modified name: " + nameValue);

            // *********ANNOTATION*********
            Class<?> userClassz = Class.forName("org.example.model.User");
            Field username = userClassz.getDeclaredField("username");

            Annotation[] annotations = username.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                System.out.println("Annotation: " + annotation);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
