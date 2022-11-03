package pro.sky;

import pro.sky.exeption.InvalidateIndexException;
import pro.sky.exeption.NotFoundElementException;
import pro.sky.exeption.NullItemException;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private Integer[] storage;
    private int size;

    public IntegerListImpl() {
        this.storage = new Integer[10];
    }

    public IntegerListImpl(int intSize) {
        this.storage = new Integer[intSize];
    }

    @Override
    public int add(Integer item) {
        if (validateSizeStorage()) {
            grow();
        }
        validateItem(item);
        storage[size++] = item;
        return item;
    }

    @Override
    public int add(int index, Integer item) {
        if (validateSizeStorage()) {
            grow();
        }
        validateItem(item);
        if (index == size) {
            storage[size++] = item;
            return item;
        }
        validateIndex(index);
        System.arraycopy(storage,index, storage, index + 1, size - index);
        storage[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateItem(item);
        storage[index] = item;
        return item;
    }

    @Override
    public int remove(Integer item) {
        validateItem(item);
        int index = indexOf(item);
        if (index == -1) {
            throw new NotFoundElementException();
        }
        System.arraycopy(storage,index + 1, storage,
                index, size - index - 1);
        size--;
        return item;
    }

    @Override
    public int remove() {
        if (this.isEmpty()) {
            throw new InvalidateIndexException();
        }
        Integer item = storage[size - 1];
        size--;
        return item;
    }

    @Override
    public boolean contains(Integer item) {
        validateItem(item);
        MergeSort mergeSort = new MergeSort();
        mergeSort.run(this.toArray());
        return binarySearch(item);
    }

    @Override
    public int indexOf(Integer item) {
        validateItem(item);
        for (int i = 0; i < size; i++) {
            if (storage[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        validateItem(item);
        for (int i = size - 1; i >= 0; i--) {
            if (storage[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int index) {
        validateIndex(index);
        return storage[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(storage, size);
    }

    private void grow() {
        int newSize = (3 * storage.length) / 2 + 1;
        Integer[] newStorage = new Integer[newSize];
        System.arraycopy(storage,0, newStorage,0,storage.length);
        storage = newStorage;
    }

    private void validateItem(Integer item) {
        if (item == null) {
            throw new NullItemException();
        }
    }

    private boolean validateSizeStorage() {
        return size == storage.length;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidateIndexException();
        }
    }
    public boolean binarySearch(Integer item) {
        int min = 0;
        int max = size - 1;
        while (min <= max) {
            int mid = (max + min) / 2;
            if (storage[mid] == item) {
                return true;
            }
            if (item < storage[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}
