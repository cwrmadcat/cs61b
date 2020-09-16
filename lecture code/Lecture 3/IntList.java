public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }
    
    //Return size of list using recursion

    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    //Return size of list using iteration
    /*
    public int iterativeSize() {
        int counter = 1;
        IntList ref = this.rest;
        while (ref != null) {
            counter++;
            ref = ref.rest;
        }
        return counter;
    }
    */

    //Second iterative version pointing to the primary node instead of rest

    public int iterativeSize() {
        int counter = 0;
        IntList ref = this;
        while (ref != null) {
            counter++;
            ref = ref.rest;
        }
        return counter;
    }

    //Returns the value in the ith node of the list.  0th item is first.  Recursive Solution
    /*
    public int get(int ith) {
        if (ith == 0) {
            return first;
        }
        return rest.get(ith - 1);
    }
    */
    

    //Returns the value in the ith node of the list.  Iterative Solution
    
    public int get(int ith) {
        IntList ref = this;
        while (ith != 0) {
            ref = ref.rest;
            ith--;
        }
        return ref.first;
    }
    

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        System.out.println(L.iterativeSize());
        System.out.println(L.get(1));
    }
}