package model.data_structures;

public interface IHashST<K,V> {
	void put(K key,V value);
	V get(K key);
	V delete(K key);
	Iterable<K> keys();
}
