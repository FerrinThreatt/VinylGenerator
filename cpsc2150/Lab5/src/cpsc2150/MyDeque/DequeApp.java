package cpsc2150.MyDeque;

import java.util.*;
public class DequeApp {
    public static void main(String[] args) {
        IDeque q;
        /*
        You will add in code here to ask the user whether they want an
        array implementation or a list implementation.
        Then use their answer to initialize q appropriately
        */
        Scanner input = new Scanner(System.in);
        Character charTemp;
        int intTemp;
        int pos;
        System.out.println("Enter 1 for array implementation or 2 for List implementation");
        intTemp = input.nextInt();
        if(intTemp == 1){
            q = new ArrayDeque();
        }
        else if(intTemp == 2){
            q = new ListDeque();
        }
        else{
            q = null;
        }

        while(intTemp!=12) {
            System.out.println("Select an option:");
            System.out.println("1. Add to the end of the Deque");
            System.out.println("2. Add to the front of the Deque");
            System.out.println("3. Remove from the front of the Deque");
            System.out.println("4. Remove from the end of the Deque");
            System.out.println("5. Peek from the front of the Deque");
            System.out.println("6. Peek from the end of the Deque");
            System.out.println("7. Insert to a position in the Deque");
            System.out.println("8. Remove from a position in the Deque");
            System.out.println("9. Get a position in the Deque");
            System.out.println("10. Get the length of the Deque");
            System.out.println("11. Clear the Deque");
            System.out.println("12. Quit");

            intTemp = input.nextInt();
            switch(intTemp){
                case 1:
                    System.out.println("What character to enqueue to the end of the Deque?");
                    charTemp = input.next().charAt(0);
                    if(q.length() < q.MAX_LENGTH) {
                        q.enqueue(charTemp);
                    }
                    break;
                case 2:
                    System.out.println("What character to inject to the front of the Deque?");
                    charTemp = input.next().charAt(0);
                    if(q.length() < q.MAX_LENGTH) {
                        q.inject(charTemp);
                    }
                    break;
                case 3:
                    if(q.length() != 0){
                        System.out.println("Character at front: " + q.dequeue());
                    }
                    else{
                        System.out.println("Deque is empty!");
                    }
                    break;
                case 4:
                    if(q.length() != 0){
                        System.out.println("Character at end: " + q.removeLast());
                    }
                    else {
                        System.out.println("Deque is empty!");
                    }
                    break;
                case 5:
                    if(q.length() != 0){
                        System.out.println("Peek: " + q.peek());
                    }
                    else{
                        System.out.println("Deque is empty!");
                    }
                    break;
                case 6:
                    if(q.length() != 0){
                        System.out.println("EndOfDeque: " + q.endOfDeque());
                    }
                    else{
                        System.out.println("Deque is empty!");
                    }
                    break;
                case 7:
                    pos = q.length()+1;
                    System.out.println("What character to insert to the Deque?");
                    charTemp = input.next().charAt(0);
                    while(!(pos > 0 && pos <= q.length())) {
                        System.out.println("What position to insert in?");
                        pos = input.nextInt();
                        if(!(pos > 0 && pos <= q.length())){
                            System.out.println("Not a valid position in the Deque!");
                        }
                    }
                    if(q.length() < q.MAX_LENGTH) {
                        if(pos == 1){
                            q.inject(charTemp);
                        }
                        else {
                            q.insert(charTemp, pos);
                        }
                    }
                    break;
                case 8:
                    if(q.length() != 0){
                        pos = q.length()+1;
                        while(!(pos > 0 && pos <= q.length())) {
                            System.out.println("What position to remove from the Deque?");
                            pos = input.nextInt();
                            if(!(pos > 0 && pos <= q.length())){
                                System.out.println("Not a valid position in the Deque!");
                            }
                        }
                        System.out.println(q.remove(pos) + " was at position " + pos + " in the Deque.");
                    }
                    else{
                        System.out.println("Deque is empty!");
                    }
                    break;
                case 9:
                    if(q.length() != 0) {
                        pos = q.length() + 1;
                        while (!(pos > 0 && pos <= q.length())) {
                            System.out.println("What position to get from the Deque?");
                            pos = input.nextInt();
                            if (!(pos > 0 && pos <= q.length())) {
                                System.out.println("Not a valid position in the Deque!");
                            }
                        }
                        System.out.println(q.get(pos) + " was at position " + pos + " in the Deque.");
                    }
                    else{
                        System.out.println("Deque is empty!");
                    }
                    break;
                case 10:
                    System.out.println("Length of Deque: " + q.length());
                    break;
                case 11:
                    System.out.println("Deque is now empty!");
                    q.clear();
                    break;
                case 12:
                    System.exit(0);
                    break;
            }
            /*for(int i=0; i<q.length(); i++){
                charTemp = q.dequeue();
                System.out.print(charTemp + " ");
                q.enqueue(charTemp);
            }*/
            System.out.println("Deque is:");
            System.out.println(q.toString());
        }


        /*Character x = 'a';
        q.enqueue(x);
        x = 'k';
        q.enqueue(x);
        x = 'j';
        q.enqueue(x);
        x = '1';
        q.enqueue(x);
        x = 'f';
        q.enqueue(x);*/
        //Add the code to print the deque. After the code is finished, the deque should still contain all its values in order

    }
}
