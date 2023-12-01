import java.util.Comparator;
public class MaxArrayDq<dq>extends New_ArrayDq<dq>{
private Comparator<dq> comp;
public MaxArrayDq(Comparator <dq> sth){
    super();
    comp = sth;
}
public MaxArrayDq(){
    super();
}
/*public static class Comparatoring implements Comparator<Integer>{
    @Override
    public int compare(Integer one, Integer two){
        if (one == two){
            return 0;}
        else if (one > two){
            return -1;}
        else {
            return 1;}
    }
    public static class Comparatoring2 implements Comparator<String> {
        @Override
        public int compare(String one, String two) {
            if (one.equals(two)) {
                return 0;
            } else if (one.length() > two.length()) {
                return -1;
            } else {
                return 1;
            }
        }
    }
}*/
public dq max(Comparator <dq> c){
    if (sizecontrol == 0){
        return null;
    }
    dq max = super.get(0);
    for(int i = 1; i<sizecontrol; i++){
        dq current = super.get(i);
        if(c.compare(current, max) == 1){
            max = current;
        }
    }
    return max;
}
public dq max(){
    if (sizecontrol == 0){
        return null;
    }
    dq max = super.get(0);
    for(int i = 1; i<sizecontrol; i++){
        dq current = super.get(i);
        if(comp.compare(current, max) > 0){
            max = current;
        }
    }
    return max;
}
public static void main(String[]args){
    Comparator <String> s = new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return o1.length()-o2.length();
        }
    };
    MaxArrayDq<String> DayEast1 = new MaxArrayDq<>();
    DayEast1.addLast("Marcus");
    DayEast1.addLast("Harry");
    DayEast1.addLast("Michael");
    DayEast1.addLast("Andy");
    MaxArrayDq<String> DayEast2 = new MaxArrayDq<>(s);
    DayEast2.addLast("Tony");
    DayEast2.addLast("Isaac");
    DayEast2.addLast("Alexander");
    DayEast2.addLast("Lincoln");

    System.out.println(DayEast1.max(s));
    System.out.println(DayEast2.max());
    System.out.println();
    DayEast2.printDeque();
}
}
