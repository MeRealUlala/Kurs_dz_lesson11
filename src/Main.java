public class Main {
    public static void main(String[] args) {
        System.out.println("=== Тестирование MyArrayList (с новыми методами) ===\n");

        // 1. Создание списка
        MyArrayList<String> list = new MyArrayList<>();
        System.out.println("1. Создан пустой список");
        System.out.println("   Размер: " + list.size());
        System.out.println("   Пуст ли? " + list.isEmpty());
        System.out.println("   toString(): " + list.toString());

        // 2. Добавление элементов (оба метода add)
        System.out.println("\n2. Добавляем элементы разными способами:");

        // Используем обычный add (в конец)
        list.add("One");
        list.add("Three");
        System.out.println("   После add(\"One\"), add(\"Three\"):");
        System.out.println("   " + list.toString());

        // Используем add с индексом (вставка в середину)
        list.add(1, "Two");
        System.out.println("   После add(1, \"Two\"):");
        System.out.println("   " + list.toString());

        // Добавляем в начало
        list.add(0, "Zero");
        System.out.println("   После add(0, \"Zero\"):");
        System.out.println("   " + list.toString());

        // Добавляем в конец через add с индексом
        list.add(4, "Four");
        System.out.println("   После add(4, \"Four\"):");
        System.out.println("   " + list.toString());

        System.out.println("   Итоговый размер: " + list.size());

        // 3. Проверка метода set()
        System.out.println("\n3. Проверка метода set():");

        String oldValue = list.set(2, "TWO");
        System.out.println("   После set(2, \"TWO\"):");
        System.out.println("   Старое значение: " + oldValue);
        System.out.println("   Новый список: " + list.toString());

        // Заменяем первый элемент
        oldValue = list.set(0, "ZERO");
        System.out.println("   После set(0, \"ZERO\"):");
        System.out.println("   Старое значение: " + oldValue);
        System.out.println("   Новый список: " + list.toString());

        // 4. Комплексный тест: сочетание add и set
        System.out.println("\n4. Комплексный тест:");

        list.add(2, "Inserted");
        System.out.println("   После add(2, \"Inserted\"):");
        System.out.println("   " + list.toString());

        list.set(3, "REPLACED");
        System.out.println("   После set(3, \"REPLACED\"):");
        System.out.println("   " + list.toString());

        // 5. Проверка обработки ошибок в новых методах
        System.out.println("\n5. Проверка обработки ошибок в новых методах:");

        try {
            list.add(10, "Invalid"); // Неверный индекс для add
        } catch (IndexOutOfBoundsException e) {
            System.out.println("   ✓ Корректно поймано исключение при add(10, ...): " + e.getMessage());
        }

        try {
            list.set(10, "Invalid"); // Неверный индекс для set
        } catch (IndexOutOfBoundsException e) {
            System.out.println("   ✓ Корректно поймано исключение при set(10, ...): " + e.getMessage());
        }

        // 6. Проверка работы с большим количеством элементов
        System.out.println("\n6. Проверка с большим количеством элементов:");

        MyArrayList<Integer> numbers = new MyArrayList<>();
        System.out.println("   Начальная емкость: " + numbers.capacity());

        for (int i = 0; i < 15; i++) {
            numbers.add(i * 10);
        }

        System.out.println("   После добавления 15 элементов:");
        System.out.println("   Размер: " + numbers.size());
        System.out.println("   Емкость: " + numbers.capacity());
        System.out.println("   Первые 5 элементов: " +
                numbers.get(0) + ", " + numbers.get(1) + ", " +
                numbers.get(2) + ", " + numbers.get(3) + ", " + numbers.get(4));

        // Вставляем элемент в середину при полном массиве
        numbers.add(5, 999);
        System.out.println("   После add(5, 999) при полном массиве:");
        System.out.println("   Элемент с индексом 5: " + numbers.get(5));
        System.out.println("   Размер: " + numbers.size());

        System.out.println("\n=== Тестирование завершено ===");
    }
}