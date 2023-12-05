package main.java.com.magicvet;

import main.java.com.magicvet.component.AplicationRunner;
import java.util.Scanner;

public class Main {

    public static Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        AplicationRunner runner = new AplicationRunner();
        runner.run();
    }

}