/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nguyen_minhquan_priorityheap;

/**
 *
 * @author james
 */
public class PriorityQueue {
   
    private PriorityCustomer[] heap;
    private int size;
    
    private PriorityCustomer serviced = null;
    
    PriorityQueue(){ //constructor
        heap = new PriorityCustomer[60];
        size = 0;
    }
    
    public PriorityQueue(int s){
        heap = new PriorityCustomer[s];
        size = 0;        
    }
    
    public void add(PriorityCustomer c){
        
        if(size + 2 > heap.length){
            System.out.println("The heap is full");
            return;
        }
        //increase the size
        size++;
        //add new object to the next open position in heap
        heap[size]= c;
        //create a variable to keep track of the object's location in the heap
        int index = size;
        //Compare objet to it's parent until it's at the root. Using loop
        while(index > 1){
            //get parent index
            int parentIndex = index/2;
            //if parent index is the front of the line, being serviced. no switch
            if(heap[parentIndex] == heap[1]){
                    break;
                }
            //compare object to it's parent to see if it need to be swap
            else if(heap[index].getPriority() > heap[parentIndex].getPriority()){
                //swap objects
                PriorityCustomer temporary = heap[index]; //empty variable to hold object inside the index being swap out
                heap[index] = heap[parentIndex];
                heap[parentIndex] = temporary; //place the swap index held inside the empty(hold) variable in
                
                //update index to parent index after swap
                index = parentIndex; 
                
            } else{
                //parent value is larger. 
                break;
            }
        }
    }
    
    public PriorityCustomer remove(){
        /*remove root 
        take the last child and move it to the root position.
        swap around until the largest become the new parent
        ************************************************** */
        
        //check to make sure the heap isn't already empty
        if(size == 0){
            System.out.println(" The heap is already empty");
            return null;
        }
        
        //temporary reference variable to store root object, to be returned later
        PriorityCustomer temporary = heap[1];
        //move object in the last position to the root(last child)
        heap[1] = heap[size];
        heap[size] = null;
        size --;
        
        // ******control statement - control how the code flows. like if, loops, etc.******
        //store the index of the object we moved to the root
        int index = 1;
        
        //compare root to child, as long as there are child
        while(index <= size/2){
            //store index and value of child
            int leftChildIndex = index * 2;
            int rightChildIndex = leftChildIndex +1;
            
            int leftChildValue = heap [leftChildIndex].getPriority ();
            int rightChildValue = Integer.MIN_VALUE;
            
            //is therea right child?
            if(rightChildIndex <= size){
                rightChildValue = heap[rightChildIndex].getPriority();
            }
            
            //determine the larger of the 2 child
            int largerValue;
            int largerIndex;
            
            if(rightChildValue > leftChildValue){
                largerValue = rightChildValue;
                largerIndex = rightChildIndex;         
            }else{
                largerValue = leftChildValue;
                largerIndex = leftChildIndex;
            }
            
            //determine if a swap is needed between child and parent, all the way to root
            if(heap[index].getPriority() < largerValue){
                PriorityCustomer swap = heap[index];
                heap[index] = heap[largerIndex];
                heap[largerIndex] =  swap;
                
                //update index since it was moved to child position
                index = largerIndex;
            }else{ //parent value is larger, no swap is needed. done
                break;
            }
        }  
        //return the original root
        return temporary;
    }
    
    
    public PriorityCustomer inServiced(){
        //if nothing is in the heap, nothing can be serviced
        //System.out.println("the current heap size is: " + size);
        if( size == 0){
            return null;
        }else{ //if something is in the heap, serviced is equal to the first of the heap
            serviced = heap[1];
            return serviced;
        }
        
    }
    
    //return the size of queue
    public int getSize() {
        return size;
    }
    
}
