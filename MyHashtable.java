
package main;

public class MyHashtable {
    private int capacity;
    private int elementSize;
    // TODO: Create a hash table (a list, a list of a linkedlist, an array, etc.)
      private MyInteger [] hashArray;


    public MyHashtable(int capacity) {
        this.capacity = capacity;
        this.elementSize = 0;
        allocateArray(capacity);
    
    }
    
    

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getElementSize() {
        return elementSize;
    }

    public void setElementSize(int elementSize) {
        this.elementSize = elementSize;
    }
     public void insert(int x){
    int currentPos= findPos(x);
    if(isActive(currentPos))
        return;
    
    hashArray[currentPos]=new MyInteger(x);
    
    if(++elementSize>hashArray.length/2)
        rehash();
    
    }
     public boolean contains(int x){
    int currentPos= findPos(x);
     return isActive( currentPos );
    
    }
      public void printTable(){
        for(int i= 0; i<hashArray.length; i++){
            
            System.out.print(i+ "=>");
            if(hashArray[i]!=null)
            System.out.println(hashArray[i].get());
            else
                System.out.println("İt is empty.");
        }
      }
    
    public int hashFunction(int x) {
        
         int hashValue=  x%capacity;
         if(hashValue<0)
             hashValue+=capacity;
         
         return hashValue;
         
       
    }
         
          public void rehash(){
    
    MyInteger [] oldArray=hashArray;
    allocateArray(nextPrime(2*oldArray.length));
    elementSize=0;
     for(int i=0; i< oldArray.length; i++){
         if(oldArray[i] !=null){
             insert(oldArray[i].get());
         
         }
     
     }
    
    }
           public static int nextPrime(int x){
    if(x%2==0)
        x++;
    for(;!isPrime(x); x+=2);
    
    return x;
    }
    public static boolean isPrime(int n){
        if(n==2 || n==3)
            return true;
        
        if(n==1 || n%2==0)
            return false;
        
        for(int i=3; i*i<=n; i+=2)
        if(n%i==0)
            return false;
        
    return true;
    
    
    
    }
    
      public int findPos(int x){
    
    int offset=1;
    int currentPos= hashFunction(x);
    
    while(hashArray[currentPos]!= null && hashArray[currentPos].get()!=x){
        currentPos+=offset;
        offset+=2;
    if(currentPos>=hashArray.length)
    currentPos-=hashArray.length;
    
    
    }
    return currentPos;
      }
       public void allocateArray(int arraySize){
        this.hashArray=new MyInteger[nextPrime(arraySize)];
    
    }
    
    public boolean isActive(int currentPos){
        return hashArray[currentPos]!=null;
    
    }
    public void makeEmpty(){
        elementSize=0;
        for(int i=0; i<hashArray.length; i++){
            hashArray[i]=null;
        }
     
}
}
