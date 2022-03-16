package day8;

import java.util.Objects;

public class Ex01 {
    private Object[] elements;
    private int size;

    public Ex01() {
        // TODO
        this.elements = new Object[128];
    }
    public boolean add(Object o) {
        this.elements[this.size++] = o;
       // this.size++;
        return true;
    }
    public Object get(int index) {
        checkIndex(index, this.size);

        return this.elements[index];
    }

    void checkIndex(int index, int length) {
        if (index < 0 || index >= length)
            throw new IndexOutOfBoundsException("MyArrayList에는 " + index + " 에 위치하는 요소가 없어요");
    }
    public int size() {
        // TODO
        return this.size;
    }
    public boolean isEmpty() {
        // TODO
        return this.size == 0;
    }
    public int indexOf(Object o) {
        for(int i = 0; i < this.size; i++) {
            if (Objects.equals(o,elements[i])) {
                return i;
            }
        }
        return -1;
    }
    public void clear() {
        for (int i = 0; i < this.size; i++) {
            this.elements[i] = null;
        }
        this.size = 0;
        //this.elements = new Object[128];
    }
    public Object remove(int index) {
        // TODO
        checkIndex(index,size);
        Object [] temp = new Object[128];
        if(index != 0 && index != this.size) {
            for (int i = 0; i <= index - 1; i++) {
                temp[i] = this.elements[i];
            }
            for (int i = index + 1; i < this.size; i++) {
                temp[i - 1] = this.elements[i];
            }
        }else if(index == 0)
        {
            for (int i = 1; i <this.size; i++) {
                temp[i-1] = this.elements[i];
            }
        }
        else{
            for(int i =0 ; i< this.size -1;i++){
                temp[i] = this.elements[i];
            }
        }
        this.size--;
        return this.elements = temp;
    }

}
