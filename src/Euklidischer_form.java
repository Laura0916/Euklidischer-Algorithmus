import java.util.Scanner;

public class Euklidischer_form {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        int num1= getValue("Schreib nummer 1",scanner);
        int num2= getValue("Schreib nummer 2",scanner);

        int result= ggT(num1, num2);
        System.out.println("ggT = "+result);

        int[] bezout = erweitereEuklidisch(num1,num2);
        System.out.println("Coeficiente x: " + bezout[1]);
        System.out.println("Coeficiente y: " + bezout[2]);

        // Verificación de la identidad de Bézout
        System.out.println(num1 + " * " + bezout[1] + " + " + num2 + " * " + bezout[2] + " = " + bezout[0]);
    }

    //MESSAGE FOR ENTER A VALID NUMBER NOT 0

    private static int getValue(String message, Scanner scanner) {
        int nummer;
        do{
            System.out.println(message);
            nummer = scanner.nextInt();
        } while (nummer<0);
        return nummer;
    }
    // Function for Euklische Algorithmus

    private static int ggT(int num1, int num2) {
        if(num1==0){ // punto de interrupcion aqui || Überprüfen ob num 1 == 0
           return num2;
        } else if (num2==0) { // Überprüfen ob num 2 == 0
            return num1;
        } else if (num2 <= num1 && (num1 % num2) ==0) { // Überprüfen ob der Division  zwischen beiden nummer== 0
            return num2; // Wenn der Division zwischen beiden ist 0 dann nummer2 ist der ggT
        }

        if(num1<num2) {
            return ggT(num2,num1); // Wenn nummer1 < num2 tauschen wir die nummer
        } else {
            return ggT(num2,num1%num2); // Hier bekommt man der Rest
        }
    }

    // Erweiterer Euklidisch Algorithms
        public static int[] erweitereEuklidisch (int num1, int num2){
        if(num2 == 0) {
            return new int[]{num1,1,0};
        }

        int[] result = erweitereEuklidisch(num2, num1%num2);
        int ggT = result[0];
        int x1= result[1];
        int y1= result[2];

        int x = y1;
        int y = x1 - (num1/num2)* y1;
        return  new int[]{ggT,x,y};
    }


}
