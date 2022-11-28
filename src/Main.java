import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Коллекции. Урок 3. ДЗ 1. Задание 1");
        Map<String, String> phonebook = new HashMap<>();
        phonebook.put("Иванов Иван", "89765467861");
        phonebook.put("Андреев Андрей", "567077573-21");
        phonebook.put("Семенов Семен", "56 5675 5677 66");
        phonebook.put("Петрова Мария", "8(765)6788896");
        phonebook.put("Васильева Василиса", "9-675-564-78-65");
        phonebook.put("Коровина Наталья", "4546778899099");
        phonebook.put("Светова Светлана", "677467897654");
        phonebook.put("Соколов Петр", "567899000-45");
        phonebook.put("Петров Дмитрий", "345465687876");
        phonebook.put("Воробьев Михаил", "3445677899007");
        phonebook.put("Орлов Елисей", "46890-453422");
        phonebook.put("Хомяков Анатолий", "4567788935788");
        phonebook.put("Мышкин Андрей", "890-34667899");

        for (Map.Entry<String, String> contact: phonebook.entrySet()) {
            System.out.println("Контакт " + contact.getKey() + ": " + contact.getValue());
        }


        System.out.println("Коллекции. Урок 3. ДЗ 1. Задание 3");
        Map<String, Integer> phoneBook2 = new HashMap<>();
        addContact(phoneBook2, "Михайлов Михаил", 567890);
        addContact(phoneBook2, "Володин Владимир", 56789087);
        addContact(phoneBook2, "Михайлов Михаил", 345789);
        addContact(phoneBook2, "Володин Владимир", 56789087);

        for (Map.Entry<String, Integer> contact : phoneBook2.entrySet()) {
            System.out.println("Контакт " + contact.getKey() + ": " + contact.getValue());
        }

        System.out.println("Коллекции. Урок 3. ДЗ 2. Задание 1");

        Map<String, List<Integer>> strWithNumbers = new HashMap<>();
        strWithNumbers.put("String1", generateListOfNum());
        strWithNumbers.put("String2", generateListOfNum());
        strWithNumbers.put("String3", generateListOfNum());
        strWithNumbers.put("String4", generateListOfNum());
        strWithNumbers.put("String5", generateListOfNum());

        for (Map.Entry<String, List<Integer>> text : strWithNumbers.entrySet()) {
            System.out.println(text.getKey() + "-->" + text.getValue());
        }

        generateNewNum(strWithNumbers);

        for (Map.Entry<String, List<Integer>> text : strWithNumbers.entrySet()) {
            System.out.println(text.getKey() + "-->" + text.getValue());
        }



        System.out.println("Коллекции. Урок 3. ДЗ 2. Задание 1");

        Map<Integer, String> collection = new LinkedHashMap<>();
        collection.put (1, "one");
        collection.put(2, "two");
        collection.put (3, "three");
        collection.put(4, "four");
        collection.put (5, "five");
        collection.put(6, "six");
        collection.put (7, "seven");
        collection.put(8, "eight");
        collection.put (9, "nine");
        collection.put(10, "ten");

        for (Map.Entry<Integer, String> text : collection.entrySet()) {
            System.out.println(text.getKey() + ": " + text.getValue());
        }

    }

    public static void addContact(Map<String, Integer> PhoneBook, String name, int number) {
        if (PhoneBook.isEmpty()) {
            PhoneBook.put(name, number);
        }
        else {
            String contactName = null;
            for (Map.Entry<String, Integer> contact : PhoneBook.entrySet()) {
                if (contact.getKey().equals(name) && number == contact.getValue()) {
                    throw new IllegalArgumentException("Значение уже введено");
                } else if (contact.getKey().equals(name) && contact.getValue() != number) {
                    contact.setValue(number);
                }
                contactName = contact.getKey();
            }
            if (!contactName.equals(name)) {
                PhoneBook.put(name, number);
            }
        }
    }

    public static List<Integer> generateListOfNum() {
        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();
        while (numbers.size() < 3) {
            numbers.add(random.nextInt(1001));
        }
        return numbers;
    }

    public static void generateNewNum(Map<String, List<Integer>> strWithNumbers) {
        for (List<Integer> listOfNumbers : strWithNumbers.values()) {
            int  sumOfNumbers = 0;
            for (Integer number : listOfNumbers) {
                sumOfNumbers += number;
            }
            listOfNumbers.clear();
            listOfNumbers.add(sumOfNumbers);
        }
    }
}


