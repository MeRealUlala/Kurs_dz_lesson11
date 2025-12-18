public class MyArrayList<E> {
    // массив
    private Object[] elements;

    // Текущее количество элементов в массиве
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive: " + initialCapacity);
        }
        elements = new Object[initialCapacity];
        size = 0;
    }

    //ОСНОВНЫЕ МЕТОДЫ

    //Добавляет элемент в конец списка
    public void add(E element) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size] = element;
        size++;
    }

    //Вставляет элемент на указанную позицию в списке
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }
        if (size == elements.length) {
            increaseCapacity();
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    //Заменяет элемент в указанной позиции в этом списке на указанный элемент.
    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }
        E oldElement = (E) elements[index];
        elements[index] = element;
        return oldElement;
    }

    //Возвращает элемент по указанному индексу.
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }
        return (E) elements[index];
    }

    // Удаляет элемент по указанному индексу
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(
                    "Index: " + index + ", Size: " + size
            );
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        // Очищаем последний элемент из-за дубля
        elements[size - 1] = null;
        size--;
    }

    //Возвращает текущее количество элементов в списке.
    public int size() {
        return size;
    }
    //доп методы

    //Проверяет, содержится ли указанный элемент в списке.
    public boolean contains(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return true;
                }
            }
        }
        else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    //Удаляет все элементы из списка.
    public void clear() {
        // Очищаем все ссылки
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    //Возвращает строковое представление списка.
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size - 1; i++) {
            sb.append(elements[i]).append(", ");
        }
        // Добавляем последний элемент без запятой
        sb.append(elements[size - 1]).append("]");

        return sb.toString();
    }

    //Возвращает текущую емкость внутреннего массива.
    public int capacity() {
        return elements.length;
    }

    // Проверяет, пуст ли список.
    public boolean isEmpty() {
        return size == 0;
    }


    //Увеличивает емкость внутреннего массива.

    private void increaseCapacity() {
        int newCapacity = elements.length * 2;
        Object[] newArray = new Object[newCapacity];

        // Копируем старые элементы в новый массив
        for (int i = 0; i < elements.length; i++) {
            newArray[i] = elements[i];
        }

        elements = newArray;  // Заменяем старый массив новым
    }
}