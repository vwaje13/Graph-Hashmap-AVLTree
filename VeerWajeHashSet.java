import java.util.*;

public class VeerWajeHashSet<E> implements Collection<E> {
  private static int DEFAULT_INITIAL_CAPACITY = 4;
  private static int MAXIMUM_CAPACITY = 1 << 30;
  private int capacity;
  private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;
  private float loadFactorThreshold;
  private int size = 0;
  private LinkedList<E>[] table;

  public VeerWajeHashSet() {
    this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
  }

  public VeerWajeHashSet(int initialCapacity) {
    this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
  }

  public VeerWajeHashSet(int initialCapacity, float loadFactorThreshold) {
    if (initialCapacity > MAXIMUM_CAPACITY)
      this.capacity = MAXIMUM_CAPACITY;
    else
      this.capacity = trimToPowerOf2(initialCapacity);

    this.loadFactorThreshold = loadFactorThreshold;
    table = new LinkedList[capacity];
  }

  @Override
  public void clear() {
    size = 0;
    removeElements();
  }

  @Override
  public boolean contains(Object e) {
    int bucketIndex = hash(e.hashCode());
    if (table[bucketIndex] != null) {
      LinkedList<E> bucket = table[bucketIndex];
      return bucket.contains(e);
    }
    return false;
  }

  @Override
  public boolean add(E e) {
    
	  
	  if (contains(e))
      return false; 

    if (size + 1 > capacity * loadFactorThreshold) {
      if (capacity == MAXIMUM_CAPACITY)
        throw new RuntimeException("Exceeding maximum capacity");

      rehash();
    }

    int bucketIndex = hash(e.hashCode());

    if (table[bucketIndex] == null) {
      table[bucketIndex] = new LinkedList<E>();
    }

    table[bucketIndex].add(e);
    size++;
    return true;
  }

  @Override
  public boolean remove(Object e) {
    if (!contains(e))
      return false;

    int bucketIndex = hash(e.hashCode());

    if (table[bucketIndex] != null) {
      LinkedList<E> bucket = table[bucketIndex];
      bucket.remove(e);
    }

    size--;
    return true;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public java.util.Iterator<E> iterator() {
    return new MyHashSetIterator(this);
  }

  private class MyHashSetIterator implements java.util.Iterator<E> {
    private java.util.ArrayList<E> list;
    private int current = 0;
    private VeerWajeHashSet<E> set;

    public MyHashSetIterator(VeerWajeHashSet<E> set) {
      this.set = set;
      list = setToList();
    }

    @Override
    public boolean hasNext() {
      return current < list.size();
    }

    @Override
    public E next() {
      return list.get(current++);
    }

    public void remove() {
      
    	set.remove(list.remove(current));
    }
  }

  private int hash(int hashCode) {
    return supplementalHash(hashCode) & (capacity - 1);
  }

  private static int supplementalHash(int h) {
    h ^= (h >>> 20) ^ (h >>> 12);
    return h ^ (h >>> 7) ^ (h >>> 4);
  }

  private int trimToPowerOf2(int initialCapacity) {
    int capacity = 1;
    while (capacity < initialCapacity) {
      capacity <<= 1;
    }
    return capacity;
  }

  private void removeElements() {
    for (int i = 0; i < capacity; i++) {
      if (table[i] != null) {
        table[i].clear();
      }
    }
  }

  private void rehash() {
    java.util.ArrayList<E> list = setToList();
    capacity <<= 1;
    table = new LinkedList[capacity];
    size = 0;

    for (E element : list) {
      add(element);
    }
  }

  private java.util.ArrayList<E> setToList() {
    java.util.ArrayList<E> list = new java.util.ArrayList<>();

    for (int i = 0; i < capacity; i++) {
      if (table[i] != null) {
        for (E e : table[i]) {
          list.add(e);
        }
      }
    }

    return list;
  }

  @Override
  public String toString() {
    java.util.ArrayList<E> list = setToList();
    StringBuilder builder = new StringBuilder("[");

    for (int i = 0; i < list.size() - 1; i++) {
      builder.append(list.get(i) + ", ");
    }

    if (list.size() == 0)
      builder.append("]");
    else
      builder.append(list.get(list.size() - 1) + "]");

    return builder.toString();
  }

  @Override
  public boolean addAll(Collection<? extends E> arg0) {
	  boolean bool = false;
      for (E element : arg0) {
          if (this.add(element)) {
              bool = true;
          }
      }
      return bool;
  }

  @Override
  public boolean containsAll(Collection<?> arg0) {
	  for (Object obj : arg0) {
          if (!contains(obj)) {
              return false;
          }
      }
      return true;
  }

  @Override
  public boolean removeAll(Collection<?> arg0) {
    for (Object obj : arg0) {
    	if (contains(obj)) {
    		remove(obj);
    	}	
    }
    return true;
  }

  @Override
  public boolean retainAll(Collection<?> arg0) {
	  boolean modified = false;
      Iterator<E> iterator = this.iterator();
      while (iterator.hasNext()) {
          E element = iterator.next();
          if (!arg0.contains(element)) {
              iterator.remove();
              modified = true;
          }
      }
      return modified;
  }

  @Override
  public Object[] toArray() {
      Object[] result = new Object[size()];
      int i = 0;
      
      // Using an iterator to traverse the HashSet
      Iterator<E> it = iterator();
      while (it.hasNext()) {
          result[i++] = it.next();
      }

      return result;

  }

  @Override
  public <T> T[] toArray(T[] arg0) {
	  Object[] result = new Object[size()];
      int i = 0;
      
      
      if(arg0.length > size()) {
          arg0 = (T[]) java.lang.reflect.Array.newInstance(arg0.getClass().getComponentType(), size());
      }
   // Get the elements of the HashSet
      Object[] elements = toArray();
      
      // Copy the elements to the given array
      if (arg0.length > size) {
          System.arraycopy(elements, 0, arg0, 0, size);
          arg0[size] = null;
      } else {
          System.arraycopy(elements, 0, arg0, 0, arg0.length);
      }

      return arg0;

  }

}
