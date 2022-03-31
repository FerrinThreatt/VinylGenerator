package cpsc2150.MyDeque;

import java.util.*;
public class ListDeque extends AbsDeque{
    /**
     * @invariant 0 <= myQ.size() < MAX_LENGTH
     */
    //this time store the deque in a list
    // myQ.get(0) is the front of the deque
    private List<Character> myQ;
    //complete the class

    /**
     * @pre 0 <= size <= MAX_LENGTH
     * @post myQ = ArrayList of characters
     */
    public ListDeque(){
        myQ = new ArrayList<Character>();
    }

    @Override
    public void enqueue(Character x){
        if(myQ.size() < MAX_LENGTH) {
            myQ.add(x);
        }
    }

    @Override
    public Character dequeue(){
        char temp;
        if(myQ.isEmpty()) {
            System.exit(0);
        }
        temp = myQ.get(0);
        myQ.remove(0);

        return temp;
    }

    @Override
    public void inject(Character x){
        if(myQ.size() < MAX_LENGTH){
            myQ.add(0, x);
        }
    }

    @Override
    public Character removeLast(){
        char temp;
        if(myQ.isEmpty()) {
            System.exit(0);
        }
        temp = myQ.get(myQ.size()-1);
        myQ.remove(myQ.size()-1);

        return temp;
    }

    @Override
    public int length(){
        return myQ.size();
    }

    @Override
    public void clear(){
        while(!myQ.isEmpty()){
            myQ.remove(0);
        }
    }
}
