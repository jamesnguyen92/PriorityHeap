public class A2Driver {
   public static void main(String[] args) {
        PriorityQueue heap = new PriorityQueue();
        int maxQueueLength = 0;
        int count = 0;
        int total = 0;
        
        for(int i = 0; i < 60; i++){
            int rand = (int)(Math.random()*4+1); //generate a random number from 1 to 4.
            //System.out.println("random = "+rand);
            if (rand == 4){     
                heap.add(new PriorityCustomer ()); //add customer
                count++; 
                System.out.println("New customer, Queue length is now: " + count);
                 
            } 
            //update and store largest queue value
            if(count > maxQueueLength){
                   maxQueueLength = count;
               }   
            //create a PriorityCustomer object and set it equal to the Root Parent
            //being serviced(check out)
            PriorityCustomer checkOut = heap.inServiced(); 
            //condition check if anyone is being service, they get their service time
            //decrease each loop
            if(checkOut != null){
                checkOut.decServiceTime();
                if(checkOut.getServiceTime() == 0){
                heap.remove();  //remove once service time is at 0
                count --; //decrement the queue length
                System.out.println("Customer serviced and removed from the queue.  Queue length is now: "+ count);
                total++;    //increment total number of customer serviced within the hour
                }
            }
            System.out.println(" - - - -  - - - - - - - - --  -- - - - - ");
            
        }
    System.out.println("The maximum queue length is: " + maxQueueLength );
    System.out.println("The total customer serviced is: " + total );
    }
    
}
