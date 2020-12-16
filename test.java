public class test{
   public static void main(String[] args) throws Exception{
      Identification myPc = new Identification();
   
      System.out.println(myPc.getLocalIp());
   
      for(String i : myPc.getMAC()){
         System.out.println(i);
      }
   }
}