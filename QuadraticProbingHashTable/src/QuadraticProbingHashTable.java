/**
 * Created by lishaoxun on 2016/6/28.
 */
public class QuadraticProbingHashTable<T> {

    private static final int DEFAULT_TABLE_LENGTH = 101;
    private HashEntry<T>[] array;
    private int currentSize;

    private static class HashEntry<T> {
        public T element;
        public boolean isActive;

        @SuppressWarnings("unused")
        public HashEntry(T t) {
            this(t, true);
        }

        public HashEntry(T t, boolean i) {
            this.element = t;
            isActive = i;
        }
    }

    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_LENGTH);
    }

    public QuadraticProbingHashTable(int size) {
        allocateArray(size);
        makeEmpty();
    }

    public void makeEmpty() {
        currentSize = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    @SuppressWarnings("unchecked")
    private void allocateArray(int arraySize) {
        array = new HashEntry[arraySize];
    }

	/*
	 * private static int nextPrime(int n) { if (n % 2 == 0) n++; for (;
	 * !isPrime(n); n += 2) ; return n; }
	 *
	 * private static boolean isPrime(int n) { if (n == 2 || n == 3) return
	 * true; if (n == 1 || n % 2 == 0) return false; for (int i = 3; i <= n;
	 * i++) { if (n % i == 0) return false; } return true; }
	 */

    public boolean contains(T t) {
        int currentPos = findPos(t);
        return isActive(currentPos);
    }

    private boolean isActive(int currentPos) {

        return array[currentPos] != null && array[currentPos].isActive;
    }

    private int findPos(T t) {
        int offset = 1;
        int currentPos = myHash(t);
        while (array[currentPos] != null
                && !array[currentPos].element.equals(t)) {
            offset += 1;
            currentPos += offset;
            offset += 2;
            if (currentPos >= array.length)
                currentPos -= array.length;
        }
        return currentPos;
    }

    private int myHash(T t) {
        int hashVal = t.hashCode();
        hashVal %= array.length;
        if (hashVal < 0)
            hashVal += array.length;
        return hashVal;
    }

    public boolean insert(T t) {
        int currentPos = findPos(t);
        if (isActive(currentPos))
            return false;
        array[currentPos] = new HashEntry<T>(t, true);
        if (++currentSize > array.length / 2)
            rehash();
        return true;
    }

    private void rehash() {
        HashEntry<T>[] oldArray = array;
        allocateArray(oldArray.length * 2);
        for (HashEntry<T> entry : array) {
            if (entry != null && entry.isActive)
                insert(entry.element);
        }
    }

    public boolean remove(T t) {
        int currentPos = findPos(t);
        if (isActive(currentPos)) {
            array[currentPos].isActive = false;
            currentSize--;
            return true;
        } else
            return false;
    }

    public static void main(String[] args) {
        QuadraticProbingHashTable<Integer> H = new QuadraticProbingHashTable<Integer>(
                20);
        Integer[] data = { 4317, 1323, 6173, 4199, 4344, 9679, 1989 };
        for (int i = 0; i < data.length; i++) {
            if (H.insert(data[i]))
                System.out.println("Ok I got it!");
        }
        for (int i = 0; i < data.length; i++) {
            if (H.contains(data[i]))
                System.out.println("Find it !!");
        }
        for (int i = 0; i < data.length; i++) {
            if(H.remove(data[i]))
                System.out.println("Delete  success !");
        }
        for(int i = 0;i<data.length;i++){
            if(!H.contains(data[i]))
                System.out.println("You can not find anyone!");
            else
                System.out.println("OK you are a lucky boy!");
        }
    }
}
