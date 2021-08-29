public class IceCream {

   private int temp;
   
   public IceCream () {
      temp = (int)(Math.random () * 50);
   }
   
   public int getTemp () {
      return temp;
   }
   
   public String toString () {
      return "" + temp;
   }

}