package controller;

import model.Gasket;
import view.View;



public class Main {
    public static void main(String[] args) {
        View view = new View();
        Gasket.setViewThread(view);
        view.start();
    }

}
