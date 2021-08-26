package com.olegyashcherov.generics.CollectionUtils;

import java.util.*;

public class Main {

    private static List<Person> personList;
    private static List<Employee> employeeList;

    public static void main(String[] args) {

        Person m_p = new Person(1234, "Михаил");
        Person b_p = new Person(1235, "Борис");
        Person s_p = new Person(1267, "Сергей");
        Person a_p = new Person(1289, "Анна");
        Person d_p = new Person(1201, "Дмитрий");
        Person v_p = new Person(1154, "Виктория");

        Employee b_e = new Employee(1235, "Борис", 1);
        Employee e_e = new Employee(1745, "Екатерина", 2);
        Employee m_e = new Employee(1234, "Михаил", 3);
        Employee a_e = new Employee(1289, "Анна", 4);
        Employee i_e = new Employee(1775, "Иван", 5);

        System.out.println("\nСоздаем коллекции Person и Employee");
        System.out.println("Employee наполняем элементами");

        personList = CollectionUtils.newArrayList();
        employeeList = CollectionUtils.newArrayList();

        employeeList.add(b_e);
        employeeList.add(e_e);
        employeeList.add(m_e);
        employeeList.add(a_e);
        employeeList.add(i_e);
        System.out.println(employeeList);

        System.out.println("\nPerson заполняем из Employee");
        CollectionUtils.addAll(employeeList, personList);
        System.out.println(personList);
//        System.out.println(personList.get(0));

        System.out.println("\nИндекс элемента в коллекциях");
        System.out.println(a_e + ", index " + CollectionUtils.indexOf(personList,a_e));
        System.out.println(a_e + ", index " + CollectionUtils.indexOf(employeeList,a_e));

        System.out.println("\nНовый Person заполняем из Employee с лимитом");
        personList = (List<Person>) CollectionUtils.limit(employeeList,3);
        System.out.println(personList);

        System.out.println("\nДобавляем в коллекцию Person объект Person и объект наследуемый от Person");
        personList.add(v_p);
        System.out.println(personList);
        CollectionUtils.add(personList,i_e);
        System.out.println(personList);

        System.out.println("\nУдаляем из коллекции Person все элементы коллекции Employee");
        CollectionUtils.removeAll(personList,employeeList);
        System.out.println(personList);

        System.out.println("\nПроверка на содержание всех элементов одной коллекции в другой");
        System.out.println(CollectionUtils.containsAll(personList,employeeList));
        System.out.println("\nПроверка на содержание любого элементов одной коллекции в другой");
        CollectionUtils.addAll(employeeList, personList);
        System.out.println(personList);
        System.out.println(CollectionUtils.containsAny(personList,employeeList));

        System.out.println("\nВывод коллекции Person в заданном диапазоне\nPerson реализует Comparable (сравнение по именам)");
        Collections.sort(personList);
        System.out.println(personList);
        personList = CollectionUtils.range(personList,v_p,i_e);
        System.out.println(personList);

        System.out.println("\nВывод коллекции Employee в заданном диапазоне\nс помощью Comparator (сравнение по табельным номерам)");
        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        };
        employeeList.sort(comparator);
        System.out.println(employeeList);

        employeeList = CollectionUtils.range(employeeList, a_e, i_e, comparator);
        System.out.println(employeeList);

    }

}
