package maktab74.util;

import maktab74.domain.Company;

public class ShowMenu {

    public static void showMenu() {
        System.out.println("1 . login company");
        System.out.println("2 . show ticket");
    }

    public static void wrong() {
        System.out.println("1 . number is wrong");
    }

    public static void showCompanyMenu() {
        System.out.println("1 . registry company");
        System.out.println("2 . login company");
        System.out.println("3 . Back");
    }

    public static void enterNameCompany() {
        System.out.println("enter name company :");
    }

    public static void enterUserName() {
        System.out.println("enter Username company :");

    }

    public static void enterPassword() {
        System.out.println("enter Password company :");

    }

    public static void successfully() {
        System.out.println("successfully");
    }

    public static void wroungUserNameOrPassword() {
        System.out.println("wrong userName Or password !!!");
    }

    public static void printWelcomeToProfile(Company companyCurent) {

        System.out.println("welcome to profile"+ "   "+companyCurent.getName() );
    }
    public static void loginCompany() {
        System.out.println("1 . add ticket ");
        System.out.println("2 . Exit ");
    }

    public static void enterOrigin() {
        System.out.println("enter origin :");
    }

    public static void destination() {
        System.out.println(" enter destination :");
    }

    public static void price() {
        System.out.println("enter price :");
    }

    public static void number() {
        System.out.println("enter number :");
    }
}