import org.javatuples.Triplet;

import java.util.Scanner;

public class Input {
    public static Triplet getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Wpisz pierwszą współrzędną ");
        float x = sc.nextFloat();
        System.out.print("Wpisz drugą współżędną ");
        float y = sc.nextFloat();
        System.out.print("Wpisz liczbę dni ");
        int z = sc.nextInt();
        Triplet<Float, Float, Integer> tri = new Triplet<>(x, y, z);
        return tri;
    }
}
