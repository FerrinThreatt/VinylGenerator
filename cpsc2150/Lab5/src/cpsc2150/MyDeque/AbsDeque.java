package cpsc2150.MyDeque;

abstract class AbsDeque implements IDeque {
    @Override
    public String toString(){
        Character charTemp;
        String strTemp = "<";
        for(int i=0; i<length(); i++){
            charTemp = dequeue();
            if(i == 0){
                strTemp += charTemp;
            }
            else {
                strTemp += ", " + charTemp;
            }
            enqueue(charTemp);
        }
        strTemp += ">";
        return strTemp;
    }
}
