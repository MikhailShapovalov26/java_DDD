### DDD and TDDD


* для доп изучения https://medium.com/@berrachdim/test-driven-development-tdd-in-java-a-comprehensive-guide-with-examples-c66a77afe036
1) Этап реализуем тестирование метода `add`, основные моменты по данному методу, добавить имя с номером. Метод должен возвращать количество 
контактов после добавления, при этом гарантируется, что не будут добавляться повторяющиеся имена;
- Пишем метод заглушку
```java
public int add(String name, String number){
        return 0;
    }
```
Первый тестом проверяем, что он просто добавляет наш контакт
```java
 @Test
    public void testAddPhoneBook(){
        String name = null;
        String number = null;
        PhoneBook phoneBook = new PhoneBook();
        assertEquals(1, phoneBook.add(name, number));
    }
```
Результат, тест упал
```bash
/home/mshapovalov/.sdkman/candidates/java/11.0.27.fx-librca/bin/java -javaagent:/opt/intellij-idea-community/plugins/java/lib/rt/debugger-agent.jar=file:///tmp/capture11132881972828764523.props -ea -Didea.test.cyclic.buffer.size=1048576 -javaagent:/opt/intellij-idea-community/lib/idea_rt.jar=44295 -Dkotlinx.coroutines.debug.enable.creation.stack.trace=false -Ddebugger.agent.enable.coroutines=true -Dkotlinx.coroutines.debug.enable.flows.stack.trace=true -Dkotlinx.coroutines.debug.enable.mutable.state.flows.stack.trace=true -Dfile.encoding=UTF-8 -classpath /opt/intellij-idea-community/lib/idea_rt.jar:/opt/intellij-idea-community/plugins/junit/lib/junit5-rt.jar:/opt/intellij-idea-community/plugins/junit/lib/junit-rt.jar:/home/mshapovalov/java/netology/DDD/TDD/target/test-classes:/home/mshapovalov/java/netology/DDD/TDD/target/classes:/home/mshapovalov/.m2/repository/junit/junit/4.13.2/junit-4.13.2.jar:/home/mshapovalov/.m2/repository/org/hamcrest/hamcrest-core/1.3/hamcrest-core-1.3.jar:/home/mshapovalov/.m2/repository/org/junit/jupiter/junit-jupiter/5.13.0/junit-jupiter-5.13.0.jar:/home/mshapovalov/.m2/repository/org/junit/jupiter/junit-jupiter-api/5.13.0/junit-jupiter-api-5.13.0.jar:/home/mshapovalov/.m2/repository/org/opentest4j/opentest4j/1.3.0/opentest4j-1.3.0.jar:/home/mshapovalov/.m2/repository/org/junit/platform/junit-platform-commons/1.13.0/junit-platform-commons-1.13.0.jar:/home/mshapovalov/.m2/repository/org/apiguardian/apiguardian-api/1.1.2/apiguardian-api-1.1.2.jar:/home/mshapovalov/.m2/repository/org/junit/jupiter/junit-jupiter-params/5.13.0/junit-jupiter-params-5.13.0.jar:/home/mshapovalov/.m2/repository/org/junit/jupiter/junit-jupiter-engine/5.13.0/junit-jupiter-engine-5.13.0.jar:/home/mshapovalov/.m2/repository/org/junit/platform/junit-platform-engine/1.13.0/junit-platform-engine-1.13.0.jar com.intellij.rt.junit.JUnitStarter -ideVersion5 -junit4 ru.netology.PhoneBookTest,testAddPhoneBook

org.opentest4j.AssertionFailedError: expected: <1> but was: <0>
Expected :1
Actual   :0
<Click to see difference>
.....
```
Второй тест должен проверить на уникальность имени добавляемой записи
```java
        @Test
    public void testAddPhoneBookRepetition() {
        String name = "test";
        String number = "+79999999999";
        String name2 = "test";
        String number2 = "+79999999998";
        assertEquals(1, phoneBook.add(name, number));
        assertNotEquals(1, phoneBook.add(name2, number2));
}
```
Переделал, так как второй раз добавления нового контакта должен вернуть 0 и чтобы проверить что добавление не произошло, то делаем `assertNotEquals`
```bash
org.opentest4j.AssertionFailedError: expected: <1> but was: <0>
Expected :1
Actual   :0
```

Реализация метода `add`
```java
   public int add(String name, String number){
        if(name ==null || number ==null){
            return 0;
        }
        if( !phoneBook.containsKey(name)){
            phoneBook.put(name, number);
            return 1;
        }
        return 0;
    }
```
Проверяем на вход не пустые значения, если они не пусты, то ищем уникальный контакт, если его нет в нашей Map то добавляем новый контакт.

Результат, тесты зеленные.
![img.png](img.png)

2) Реализуем тестирование второго метода из класса PhoneBook, основные описание поведения метода
   findByNumber — найти имя по номеру без полного перебора;
```java
    @BeforeEach
    void setUp() {
        String name = "test";
        String number = "+79999999998";
        String name2 = "test2";
        String number2 = "+79999999999";

        phoneBook.add(name, number);
        phoneBook.add(name2, number2);
    }

    @Test
    public void findByNumber() {
        String numberTest = "+7999999999";
        assertEquals("test2",phoneBook.findByNumber(numberTest));
    }
```
Результат теста красный,
```bash
org.opentest4j.AssertionFailedError: 
Expected :test2
Actual   :null
```

Для тестирования данного метода, мы сначала добавляем тестовые данные, так как Map в начале пустой и потом ищём необходимый контакт.
Реализация данного метода:
```java

```