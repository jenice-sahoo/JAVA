public class Marks {

    public static void main(String[] args) throws Exception {
        
        String s="10";
        //int c=Integer.parseInt(s);
        int c=Integer.parseInt(s);
        System.out .println(c);

        String s1="30";
        int c1=Integer.parseInt(s1);
        System.out .println(c1);

        String s2="80";
        int c2=Integer.parseInt(s2);
        System.out .println(c2);

        int total = c+c1+c2;
        System.out.println("The total marks scored is: " + total);
    }

}
