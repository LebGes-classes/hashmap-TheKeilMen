package pkg.prettystreet.hashmap;

public interface IHashMap <K, V> {
    //put(key, value): Вставляет пару ключ-значение в HashMap.
    void put(K key, V value);
    //get(key): Извлекает значение, связанное с указанным ключом.
    V get(K key);
    //containsKey(key): Проверяет, содержит ли HashMap указанный ключ.
    boolean containsKey(K key);
    //containsValue(value): Проверяет, содержит ли HashMap указанное значение.
    boolean containsValue(V value);
    //remove(key): Удаляет пару ключ-значение, связанную с указанным ключом.
    void remove(K key);
    //size(): Возвращает количество пар ключ-значение в HashMap.
    int size();
}



