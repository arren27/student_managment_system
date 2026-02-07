package StudentManagment;
import java.util.ArrayList;

public class student{
            private int rollno;
            private String name;
            private int branch;
            private int year;
            public student(int rollno ,String name, int branch,int year){
                this.rollno=rollno;
                this.name=name;
                this.branch=branch;
                this.year=year;

            }
            public int getrollno(){return rollno;}
            public String getname(){return name;}
            public int getbranch(){return branch;}
            public double getyear(){return year;}
            public void display(){
                System.out.println("name: " + name + " rollno: " + rollno + " branch: " + branch + "year" + year );

            }
            public static void main(String[] args) {
                ArrayList<student> students = new ArrayList<>();
                students.add(new student(69, "arnav" , 1, 1));
                students.add(new student(21, "anu", 2, 2));
                students.add(new student(44, "rishi", 3, 4));
                for (student s:students){
                    s.display();
                }


            }

        }
        

    

    

        
    
    

