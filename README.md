# Задача 2

Дана функция:
```java
public boolean matches(String text, String regex) {
  return Pattern.compile(regex).matcher(text).matches();
}
```

Задача: изменить ее так, чтобы не было зависаний, а также добавить обработку исключений.

 
