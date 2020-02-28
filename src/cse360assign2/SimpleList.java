package cse360assign2;
/*
 * Truxten Cook
 * ID: 423
 * A simple list class 
 */
public class SimpleList {
    private int[] list;
    private int count;

    /*
     * Constructor for SimpleList
     */
    SimpleList(){
        list = new int[10];
        count = 0;
    }
    
    /*
     * Adds passed value at the start of the list. Pushes current arguments back by one, knocking off the last one
     * if the list is full. Increments count on successful add up to 10
     * @param 	in 	the integer to be added to the list
     */
    public void add(int in){
        if(count == 0){
            list[0] = in;
        }else{
            int previous = list[0], temp;
            list[0] = in;
            for(int i = 1; i <= count && i < 10; i++){
                if(i <= 9) {
                    temp = list[i];
                    list[i] = previous;
                    previous = temp;
                }
            }
        }
        if(count != 10){
            count++;
        }

    }

    /*
     * Finds first instance of passed value and removes it from the list. Shifts everything after removed value back 
     * one index. Decrements count on successful removal.
     * @param 	in 	the integer to be removed from the list
     */
    public void remove(int in){
        boolean found = false;
        for(int i = 0; i < count; i++){
            if(i == 9){
                if(list[9] == in){
                    found = true;
                    list[9] = 0;
                }
            }else if(found){
                list[i] = list[i + 1];
            }else if(list[i] == in){
                found = true;
                list[i] = list[i + 1];
            }
        }
        if(found){
            count--;
        }
    }

    /*
     * Returns the number of items in the list
     * @return 		A integer showing the amount of items in the list
     */
    public int count(){
        return count;
    }

    /*
     * Returns a list of items in the array separated by strings
     * @return		A string containing the integers in the list
     */
    public String toString(){
        String answer = "";
        int index;
        if (count != 0) {
        	for(index = 0; index < count - 1; index++){
                answer += list[index];
                answer += " ";
            }
            answer += list[index];
        }
        return answer;
    }

    /*
     * Returns the index of a specified value. Return -1 if item cannot be found
     * @param key	the value that is to be searched
     * @return		the index of the found value.
     */
    public int search(int key){
        int index;
        boolean found = false;
        for(index = 0; index < count && !found; index++){
            if(key == list[index]){
                found = true;
            }
        }
        if (found == false) {
            index = -1;
        }else {
            index--;
        }
        return index;
    }
    
    /*
     * Method created to help with JUnit Testing. Takes in value and returns the value of the list at that index
     * @param index	the index to be returned
     * @return		the integer at the index specified in list 
     */
   public int getValue(int index) {
	   return list[index];
   }
}