//import java.util.Collection;
import java.util.Iterator;
//import java.util.Deque;
public class New_ArrayDq<dq>implements Iterable<dq>{
private dq[] items;
static int sizecontrol;
private int indexF;
private int indexL;
public New_ArrayDq(){
    items = (dq[])new Object[12];
    sizecontrol = 0;
    }

    public boolean isFull(){
    return(sizecontrol == items.length);
    }
    //@Override
    public boolean isEmpty(){
    if (sizecontrol==0){
        return true;
    }return false;
    }
   // @Override
    public void addLast(dq sth){
    if(isFull()){
        dq[] a = (dq[]) new Object[items.length * 3 / 2];
        int endcopy = a.length - items.length;
        int startcopynumber = sizecontrol - indexF;
        System.arraycopy(items, indexF, a, 0, startcopynumber);
        System.arraycopy(items, 0, a, startcopynumber, sizecontrol - startcopynumber);
        items = a;
        items[sizecontrol] = sth;
        indexL = sizecontrol;
        indexF = 0;
        sizecontrol++;
        return;
    }
    if(isEmpty()){
        items[items.length-1]=sth;
        indexL=items.length-1;
        indexF=items.length-1;
    }
    else if(indexL == items.length-1 ){
        items[0]=sth;
        indexL=0;
    }
    else{
        items[indexL+1]=sth;
        indexL=indexL+1;
    }
    sizecontrol++;
    /*if (isFull()){
        glorp(sizecontrol*2/3);
    }
    items[sizecontrol] = sth;
    sizecontrol++;*/
    }
    //@Override
    public void addFirst(dq item) {
        if (isFull()) {
            dq[] a = (dq[]) new Object[items.length * 3 / 2];
            int endCopy = a.length - items.length;
            int startcopynumber = sizecontrol - indexF;
            System.arraycopy(items, indexF, a, endCopy, startcopynumber);
            System.arraycopy(items, 0, a, startcopynumber + endCopy, sizecontrol - startcopynumber);
            items = a;
            items[endCopy - 1] = item;
            indexF = endCopy - 1;
            indexL = indexF + sizecontrol;
            sizecontrol++;
            return;
        }
        if(isEmpty()){
            items[0] = item;
        }
        else if (indexF == 0 && items[items.length-1]==null) {
            items[items.length - 1] = item;
            indexF = items.length - 1;
        }
        else {
            items[indexF - 1] = item;
            indexF = indexF-1;
        }
        sizecontrol++;
    }


   // @Override
    public dq removeLast(){
        dq x = items[indexL];
        items[indexL] = null;
        if (indexL == 0){
            indexL = items.length-1;
        }
        indexL --;
        return x;
    }
   // @Override
    public dq removeFirst(){
        dq x = items[indexF];
        items[indexF] = null;
        if (indexF == items.length-1){
            indexF = 0;
        }
        indexF --;
        return x;
    }
    public dq get(int index){
        return items[(indexF+index) % items.length];
    }
    public int size(){
        return sizecontrol;
    }
    public void printDeque(){
        for(int i = 0; i<sizecontrol; i++){
            System.out.println(get(i));
        }
    }
    public boolean contains(dq sth){
        for (int i = indexF; i<sizecontrol; i++){
            if (items[i].equals(sth)){
                return true;
            }
            if(i == items.length-1)
                i = 0;
            if (i == indexL)
                return false;
        }return false;
    }
    public Iterator<dq> iterator(){
        return new ArrayDqIterator();
    }
    private class ArrayDqIterator implements Iterator<dq>{
        int pas;
        public ArrayDqIterator(){
            pas = indexF ;
        }
        public boolean hasNext(){
            return pas < sizecontrol;
        }
        public dq next(){
            dq item = items[pas+1];
            pas++;
            return item;
        }
    @Override
    public String toString(){
        String badstring = "{";
        for(dq s: items){
            badstring += s + ",";
        }
        // badstring+="}";
        return badstring.substring(0,badstring.length()-2) + "}";
    }
    @Override
    public boolean equals(Object object) {
        if (object instanceof New_ArrayDq o) {
            if (size() != o.size()) {
                return false;
            }
            for (dq item : items) {
                if (!o.contains(item)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }


    }

    public static void main(String[] args) {
        //ignores null adds.
        New_ArrayDq<Integer> see = new New_ArrayDq<>() ;

        System.out.println(see.isEmpty());
        see.addLast(9);
        see.addLast(12);
        see.addFirst(2);
        see.addFirst(243);
        see.printDeque();
        System.out.println(see);

    }
}

