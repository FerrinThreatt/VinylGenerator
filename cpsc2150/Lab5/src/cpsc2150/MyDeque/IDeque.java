package cpsc2150.MyDeque;

/**
 * A deque containing characters.
 * A deque is a data structure a double-ended queue that allows you
 * to insert and remove from both ends.
 * This deque is bounded by MAX_LENGTH
 */
public interface IDeque {
    public static final int MAX_LENGTH = 100;

    // Adds x to the end of the deque

    /**
     * @pre 0 <= size <= MAX_LENGTH
     * @post myQ[size] = x
     * @param x value to put in queue
     */
    public void enqueue(Character x);

    //removes and returns the Character at the front of the deque

    /**
     * @pre size > 0
     * @post size--
     * @return myQ[0]
     */
    public Character dequeue();

    // Adds x to the front of the deque

    /**
     * @pre 0 <= size <= MAX_LENGTH
     * @post myQ[0] = x
     * @param x value to put in front of queue
     */
    public void inject(Character x);

    //removes and returns the Character at the end of the deque

    /**
     * @pre size > 0
     * @post size--
     * @return myQ[size-1]
     */
    public Character removeLast();

    //returns the number of Characters in the deque

    /**
     * @post size = size
     * @return size
     */
    public int length();

    //clears the entire deque

    /**
     * @post myQ[0] = null
     */
    public void clear();

    /**
     * @pre myQ = NULL
     * @post returns top element
     * @return Character
     */
    default Character peek(){
        Character temp;
        temp = dequeue();
        inject(temp);

        return temp;
    }

    /**
     * @pre size > 0
     * @post will return character at end of deque
     * @return Character
     */
    default Character endOfDeque(){
        Character temp;
        for(int i=0; i<length(); i++){
            temp = dequeue();
            enqueue(temp);
            if(i == length()-1){
                return temp;
            }

        }
        return 0;
    }

    /**
     * @pre size > 0, (pos >= 1)
     * @post inserts c at position pos in the deque.
     * @return void
     */
    default void insert(Character c, int pos){
        Character temp;
        for(int i=0; i<length()-1; i++){
            temp = dequeue();
            if(i == pos-1){
                enqueue(c);
            }
            enqueue(temp);
        }
    }

    /**
     * @pre size != null
     * @post removes and returns head element
     * @return Character
     */
    default Character remove(int pos){
        Character temp;
        Character removed = ' ';
        for(int i=0; i<length()+1; i++){
            temp = dequeue();
            if(i == pos-1){
                removed = temp;
            }
            else{
                enqueue(temp);
            }
        }
        return removed;
    }

    /**
     * @pre (pos >= 1)
     * @post returns character in position pos in the deque and without removing
     * @return Character
     */
    default Character get(int pos){
        Character temp;
        Character got = ' ';
        for(int i=1; i<=length(); i++){
            temp = dequeue();
            if(i == pos){
                got = temp;
            }
            enqueue(temp);
        }
        return got;
    }

}
