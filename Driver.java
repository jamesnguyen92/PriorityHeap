public class Driver {
   public static void main (String[] args) {
   
      Heap heap = new Heap ();
      
      for (int i = 0; i < 10; i++) {
         heap.add ( new IceCream () );
      }
   /*
      for (int i = 0; i < 5; i++) {
         System.out.println ( heap.remove().toString() );
      }
      
      for (int i = 0; i < 5; i++) {
         heap.add ( new IceCream () );
      }
   */
   }
}