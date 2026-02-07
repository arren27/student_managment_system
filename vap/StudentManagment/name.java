package StudentManagment;

import java.util.ArrayList;

public class name {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("arnav");
        names.add("rishi");
        names.add("parth");
        System.out.println("after adding 3 names"+names);
        System.out.println("size:"+names.size());
        
        names.add(1,"anu");
        System.out.println("after adding anu at index1:"+names);
        System.out.println("element of index 0:"+names.get(0));
        names.set(0,"arnav shelke");
        System.out.println("after undating index0:"+names);
        names.remove(2);
        System.out.println("after removing index2:"+names);
        names.remove("names");
        System.out.println("after removing 'arnav':"+names);
        System.out.println("contain'rahul'?"+names.contains("arnav"));
        System.out.println("contain'rahul'?"+names.contains("rahul"));
        System.out.println("is empty"+names.isEmpty());
        //looping  through array list\


        System.out.println("n===== looping through arraylist=====\n");
        // method 1: for-each loop(recommended)
        System.out.println("for-each loop:");
        for(String name:names){
            System.out.println("-"+name);
        }
        // method 2: traditional for loop with index
        System.out.println("\tradational for loop:");
        for (int i=0;i<names.size(); i++){
            System.out.println("index"+i+":"+names.get(i));

        }
    


    }

        
    }
    

