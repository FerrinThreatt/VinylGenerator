package cpsc2150.MyDeque;

public class ArrayDeque extends AbsDeque {
    /**
     * @invariant MAX_LENGTH == 100
     */
    // where the data is stored. myQ[0] is the front of the deque
    private Character[] myQ;

    //tracks how many items in the deque
    // also used to find the end of the deque
    private int myLength;

    //complete the class

    /**
     * @pre 0 <= size <= MAX_LENGTH
     * @post myQ = Character array
     */
    public ArrayDeque(){
        myQ = new Character[MAX_LENGTH];
        myLength = 0;
    }

    @Override
    public void enqueue(Character x){
        if(myLength < MAX_LENGTH){
            myQ[myLength] = x;
            myLength++;
        }
    }

    @Override
    public Character dequeue(){
        char temp = myQ[0];
        if(myLength != 0){
            for(int i=0; i<myLength-1; i++){
                myQ[i] = myQ[i+1];
            }
            if(myLength < MAX_LENGTH){
                myQ[myLength-1] = 0;
            }
            myLength--;
        }
        return temp;
    }

    @Override
    public void inject(Character x){
        if(myLength < MAX_LENGTH){
            if(myLength == 0){
                enqueue(x);
            }
            else{
                for(int i = myLength-1; i>=0; i--){
                    myQ[i+1] = myQ[i];
                }
                myQ[0] = x;
                myLength++;
            }
        }
    }

    @Override
    public Character removeLast(){
        char temp = myQ[myLength-1];
        myQ[myLength-1] = 0;
        myLength--;

        return temp;
    }

    @Override
    public int length(){
        return myLength;
    }

    @Override
    public void clear(){
        for(int i=0; i<myLength; i++){
            myQ[i] = 0;
            myLength--;
        }
    }
}

