package com.company;

// Перед тем как в JVM попадет код он компилируется в байт код.
// Затем JVM начинает анализировать байт код для подготовки программы к работе,
// начинает с загрузки классов с помощью ClassLoader, которые указаны в программе в данном случаи это
// JvmComprehension, String, Object, Integer, System, PrintStream. Загрузка "ленивая" т.е. классы загружаются
// не сразу, а по мере выполнения программы, построчно. Далее происходит связывание Linking загруженных классов
// на предмет валидносит кода, подготовки статических полей и связывание ссылок на другие классы. И последний
// этап подготовки это  инициализация  на этом этапе выполняются static инициализаторы и
// инициализаторы static полей. После инициализации загрузка классов завершается и JVM может с этими данными
// работать. Подготовленные классы загружаются в область памяти называемую Metaspace, там будут храниться
// данные о классе это имена, методы, поля, константы и др. И теперь программа может начать выполняться.
public class JvmComprehension {
// Программа начинает выполняться построчно
// В основном используются 3 области памяти Stack Memory, Heap и Metaspace, где будут
// временно храниться данные

    public static void main(String[] args) { // В момент вызова метода main в области
                                    // памяти Stack Memory(здесь хранятся примитивные типы)
                                    // создается фрейм main
        int i = 1;                  // 1-> создается int i в фрейм main области памяти Stack Memory
                                    // и ему присваивается значение 1,
        Object o = new Object();    // 2-> создается объект Object в области памяти Heap
                                    // (здесь хранятся объекты) затем создается переменная о
                                    //  в фрейме main и переменной о присваивается ссылка
                                    //  на объект Object
        Integer ii = 2;             // 3-> создается объект Integer в области памяти Heap со значением 2
                                    // затем создается переменная ii в фрейме main
                                    // и переменной ii присваивается ссылка на объект
        printAll(o, i, ii);         // 4-> в области памяти Stack Memory над фреймом main создается фрейм
                                    // printAll, где создается переменная о, которой присваивается ссылка
                                    // на объект Object, далее создается переменная i которой присваивается
                                    // значение 1 и создается переменная ii, которой присваивается ссылка
                                    // на объект Integer
        System.out.println("finished"); // 7-> в области памяти Stack Memory создается фрейм println,
                                        // в области памяти Heap создается объект String куда записывается
                                        // значение "finished", а фрейм printAll и все вышестоящие
                                        // удаляются из Stack Memory. Garbage Collector удалит объект Integer для
                                        // для переменной uselessVar т.к. он уже никуда не ссылается
    }// После завершения программы Garbage Collector удаляет из Heap все ненужные объекты

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5->  создается объект Integer в области памяти Heap
                                                    // со значением 700 затем создается переменная uselessVar
                                                    // в фрейме printAll и переменной uselessVar присваивается
                                                    // ссылка на объект Integer
        System.out.println(o.toString() + i + ii);  // 6-> в области памяти Stack Memory над фреймом printAll
                                                    // создается фрейм println. Создается переменная
                                                    // int i, которой присваивается значение 1, создается
                                                    // переменная ii, которой присваивается ссылка на объект Integer
                                                    // Создается переменная о и ей присваивается ссылка на объект Object.
                                                    //  Затем в области памяти Stack Memory над фреймом println
                                                    // создается фрейм toString
    }
}
