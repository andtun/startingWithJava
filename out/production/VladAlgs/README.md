# Тестируем скорость алгоритмов сортировки Java

### Структура кода

**Sort.java** - все алгоритмы сортировки
**Run.java** - main файл
**ArrayTools.java** - алгоритмы для работы с массивами

Будем считать, что алгоритмы сортировки и ArrayTools у нас уже готовы.

### Sort.java

Структура **Sort.java** устроена следующим образом:

```Java
public class Sort {

    // алгоритм быстрой сортировки
    public static class Quicksort {

            // вызываем Quicksort.sort(list) для сортировки массива list
            public static void sort(int[] list) {
                ...
            }
    }

    // пузырёк
    public static class Bubblesort {

            // аналогично вызываем Bubblesort.sort()
            public static void sort(int[] list) {
                ...
            }

    }

}
```

**Здесь важно, чтоб у каждого из наших классов был метод `public static void sort(int[] list)`**

### Что мы хотим?

Мы хотим засечь время, запустить алгоритм и ещё раз засечь время - чтобы понять время выполнения алгоритма.

*Вот псевдокод:*
```JavaScript
// функция принимает алгоритм, который надо запустить, и массив для сортировки
function track(algo, list) {
    time.track();
    algo(list);
    time.track();
}

```

### Как мы этого добьёмся

#### Создаём интерфейс

Мы знаем, что изначально функция в Java принимает аргументы типов `int`, `String`, `float` и проч. Нам придётся создать новый тип данных - `функция`, чтобы передать его нашей функции `track()` в качестве аргумента.

Создадим такой тип данных, назвав его `SortingAlg` *(пишем в Sort.java)*:

```Java
public interface SortingAlg {
    void sort(int[] list);
}
```
Теперь переменная типа `SortingAlg` - любой объект любого класса, *с условием*, что у этого класса есть метод `void sort(int[] list)`

#### Работаем в Run.java

Зайдём в `Run.java` и напишем следующие строчки:

```Java
class TimeTracker implements SortingAlg{

    SortingAlg alg;
    String name;
    double result;

    public TimeTracker(SortingAlg alg, String name) {
        this.alg = alg;
        this.name = name;
    }
}
```
Что мы сделали? Мы создали класс `TimeTracker`, который может работать с переменными типа `SortingAlg`.
У объектов класса три свойства:
 - сам алгоритм, который мы будем тестировать
 - название этого алгоритма
 - время, за которое алгоритм выполнен

 Что за метод `public TimeTracker(SortingAlg alg, String name)`?
 То же самое, что и `__init__` в питоне - инструкция, как создать новый объект класса.

 #### Изменяем Sort.java

 Теперь проставим `@Override` над методами `sort()`, и уберём у методов `sort` указатели `static`.
 Зачем это нужно? Долго объяснять, постарайтесь осознать сами.

 Получаем код:

 ```Java
 public class Sort {

     // алгоритм быстрой сортировки
     public static class Quicksort {

             // вызываем Quicksort.sort(list) для сортировки массива list
             @Override
             public void sort(int[] list) {
                ...
             }
     }

     // пузырёк
     public static class Bubblesort {

             // аналогично вызываем Bubblesort.sort()
             @Override
             public void sort(int[] list) {
                ...
             }

     }

 }
 ```

#### Создаём тестировщик времени

Вернёмся в **Run.java**. Добавим классу `TimeTracker` ещё один метод.
Напомню, что метод sort не статический, так что применяется он только к объекту класса `Timetracker`,
И знает поля `alg` и `name` этого объекта.

```Java
    @Override
    public void sort(int[] list) {

        // будем сортировать копию данного нам массива, чтобы сам данный массив остался нетронутым
        int[] listToSort = list.clone();

        // засекаем время
        long start = System.nanoTime();

        // Запускаем алгоритм
        alg.sort(listToSort);

        // Выводим время
        long end = System.nanoTime();
        result = (end - start)/3600000000.0;

        // Печатаем время
        System.out.print("Работа алгоритма " + name + " завершена за ");
        System.out.print(result);
        System.out.println(" секунд");
    }
```

#### Как это будет работать?**

```Java

// Создаём массив из алоритмов
TimeTracker[] algs = new TimeTracker[] {
                new TimeTracker(new Sort.Quicksort(), "quicksort"),
                new TimeTracker(new Sort.Bubblesort(), "bubblesort"),
        };

// Для каждого алгоритма вызываем .sort()
for (algo: algs) {
    algo.sort();
}
```

Вот, в общем-то, и всё.
Чуть больше пояснений будет позже.

