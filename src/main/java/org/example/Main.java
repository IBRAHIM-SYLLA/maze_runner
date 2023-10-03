package org.example;

import org.example.classes.Maze;
import org.example.generators.SimplePerfectMazeGenerator;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello world!");

        Maze maze = new SimplePerfectMazeGenerator().generate(3, 3);
        System.out.println(maze.toString());
    //     SimplePerfectMazeGenerator simplePerfect = new SimplePerfectMazeGenerator();
    //     simplePerfect.maze = maze;

    //     //  System.out.println(maze.grille());
    //     String mazeInitial = maze.toString(); // Générer le labyrinthe initial
    // //    System.out.println(mazeInitial);

    //     // String mazeWithRandomPath = maze.generatePath(mazeInitial, 3); // 3 cellules modifiées en "."
    //     System.out.println(simplePerfect.generate(maze.width, maze.height).toString());
    }
}