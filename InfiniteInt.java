import java.util.StringTokenizer;

public class InfiniteInt extends DLList<Integer> implements Comparable<InfiniteInt>{

    public InfiniteInt(){
        super();
    }

    public InfiniteInt(String infiniteInt){
        super();
        StringTokenizer tokenizer = new StringTokenizer(infiniteInt, ",");

        while(tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            try {
                int tokenInt = Integer.parseInt(token);
                super.addLast(tokenInt);
            } catch (Exception e) {
                throw new IllegalArgumentException("Input must be an Integer");
            }
        }

    }

    public boolean equals(Object obj){

        if(obj == null)
            return false;
        if(this.getClass() != obj.getClass())
            return false;

        InfiniteInt aInfiniteInt = (InfiniteInt)obj;

        return this.toString().equals(aInfiniteInt.toString());
    }

    public String toString(){

        DLLNode<Integer> cursor = this.head;
        String infiniteIntString = "";
        if(cursor == null)
            throw new IllegalStateException("Cannot give toString if InfiniteInt is null");

        else{
            while(cursor != null){
                if(cursor == head)
                    infiniteIntString = cursor.toString();
                else if(cursor.data/100 != 0)
                    infiniteIntString = infiniteIntString + "," + cursor.toString();
                else if(cursor.data/10 != 0)
                    infiniteIntString = infiniteIntString + ",0" + cursor.toString();
                else if(cursor.data/1 != 0)
                    infiniteIntString = infiniteIntString + ",00" + cursor.toString();
                else
                    infiniteIntString = infiniteIntString + ",000";
                cursor = cursor.next;
            }
        }
        return infiniteIntString;
    }

    public int compareTo(InfiniteInt aInfiniteInt){

        int compareToInt = 0;
        if(this.equals(aInfiniteInt))
            return 0;
        else if(this.size() > aInfiniteInt.size())
            return 1;
        else if(this.size() < aInfiniteInt.size())
            return -1;
        else{
            DLLNode<Integer> thisCursor = this.head;
            DLLNode<Integer> aInfiniteIntCursor = aInfiniteInt.head;
            while(thisCursor != null && aInfiniteIntCursor != null){
                if(thisCursor.data > aInfiniteIntCursor.data)
                    compareToInt = 1;
                else if(thisCursor.data < aInfiniteIntCursor.data)
                    compareToInt = -1;
                thisCursor = thisCursor.next;
                aInfiniteIntCursor = aInfiniteIntCursor.next;
            }
        }
        return compareToInt;
    }

    public boolean isEven(){
        if(this == null)
            throw new IllegalStateException("InfiniteInt cannot be null");
        return this.tail.data % 2 == 0;
    }

    public boolean isDivisibleBy10(){
        if(this == null)
            throw new IllegalStateException("InfiniteInt cannot be null");
        return this.tail.data % 10 == 0;
    }

    public boolean isDivisibleBy1000(){
        if(this == null)
            throw new IllegalStateException("InfiniteInt cannot be null");
        return this.tail.data == 0;
    }

    public static InfiniteInt add(InfiniteInt inta, InfiniteInt intb){
        InfiniteInt infInt = new InfiniteInt();
        return infInt;
    }



}
