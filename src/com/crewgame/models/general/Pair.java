package com.crewgame.models.general;

public class Pair<K, V> {
	
	private K key;
	private V value;
	
	public Pair(K key, V value)
	{
		this.setKey(key);
		this.setValue(value);
	}

	/**
	 * @return the value
	 */
	public V getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(V value) {
		this.value = value;
	}

	/**
	 * @return the key
	 */
	public K getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(K key) {
		this.key = key;
	}
	
}
