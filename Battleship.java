import java.util.HashSet;

public class BattleShip {
    public static String output(int N,String S,String T){
    int hit=0;
    int sink=0;
        HashSet<String> hits=new HashSet<>();
        String[] Tarray=T.split(" ");
        for(String myword:Tarray){
            hits.add(myword);
        }

        String[] ships=S.split(",");

        // ships=[1A 2A , 12A 12A]
        for(String ship:ships) {
            HashSet<String> shipContainers = new HashSet<>();
            // ships[0]=1A 2A
//   	char left = ship[0].substring(ship[0].length() - 1).charAt(0);
            String[] temp = ship.split(" ");
//            temp ->[12A] [12A]
//            String topLeft = temp[0];
//            String bottomRight = temp[1];
            System.out.println("temp values ->"+temp[0]+temp[1]);

            int top = Integer.parseInt(temp[0].substring(0,temp[0].length()-1));//1
            int bottom = Integer.parseInt(temp[1].substring(0,temp[1].length()-1));//2
            char left = temp[0].charAt(temp[0].length()-1);//A


            char right = temp[1].charAt(temp[1].length()-1);//A
            for (int i = top; i <= bottom; i++) {
                for (char j = left; j <= right; j++) {

                    shipContainers.add("" + i + j);
                }
            }
            if (hits.containsAll(shipContainers)) {
                System.out.println("ship container"+shipContainers);
                System.out.println("hits"+hits);
                sink++;
            }else {
            for (String mystr : shipContainers) {
                if (hits.contains(mystr)) {
                    System.out.println("hit one ship container"+shipContainers);
                    System.out.println("hit one hits"+hits);
                    hit++;
                        break;
                }}}
            


        }




    return ""+hit+sink;


    }
    public static void main(String args[]){
        System.out.println("Result="+output(4, "1B 2C,2D 4D", "2B 2D 3D 4D 4A"));
    }
}
