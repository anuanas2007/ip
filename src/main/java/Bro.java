import java.util.*;
import java.util.ArrayList;

public class Bro {

    ArrayList<Task> list1 = new ArrayList<Task>();

    public static void main(String[] args) {
        System.out.println("Hello! I'm THE BRO\n" + "What can I do for you?");
        Bro d = new Bro();
        d.output1();

    }
    public String output1(){
        Scanner sc= new Scanner(System.in);
        String str= sc.nextLine();

        if(str.equals("bye")){
            System.out.println("Bye. See you later broo!");
            System.exit(0);
        }

        else if(str.equals("list")){
            int count = 1;
            for(Task x: list1){
                System.out.println(count + "." + x.toString());
                count++;
            }
            return output1();
        }

        else if(str.startsWith("mark ")){
            int k = Integer.parseInt(str.substring(5));
            list1.get(k - 1).markAsDone();
            System.out.println("I have marked this task\n" + (list1.get(k-1)).toString());
            return output1();
        }

        else if(str.startsWith("unmark ")){
            int k = Integer.parseInt(str.substring(7));
            list1.get(k - 1).markAsNotDone();
            System.out.println("I have unmarked this task\n" + (list1.get(k-1)).toString());
            return output1();
        }

        else{
            Task t = new Task(str);
            t.markAsNotDone();
            list1.add(t);
            System.out.println("added: " + str);
            return output1();
        }
        return str;
    }
}
