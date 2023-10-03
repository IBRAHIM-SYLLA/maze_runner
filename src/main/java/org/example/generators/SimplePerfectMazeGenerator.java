package org.example.generators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.example.classes.Cell;
import org.example.classes.Maze;
import org.example.interfaces.MazeGenerator;

public class SimplePerfectMazeGenerator implements MazeGenerator {

    public Maze maze;

    public Maze generate(int width, int height) {

        maze = new Maze(width, height);

        List<Integer> cellUnique = new ArrayList<>();
        int i = 0;
        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++) {
                cellUnique.add(i++);
            }
        }

        // algo principal ici !
        // tant que le maze n'est pas rempli de zéro
        while (cellUnique.size() != 0) {
            // cellule principale
            // Collections.shuffle(cellUnique);
            // int randId = cellUnique.get(0);
            // ArrayList<Cell> cellsWithTheSameId = new ArrayList<>(); // cellules qui ont le même id

            Random random = new Random();
            int randomId = cellUnique.get(random.nextInt(cellUnique.size()));

            int x = randomId % width;
            int y = randomId / height;
            Cell cell = maze.allCells.get(x).get(y);
            Cell neighbor = cell.casseMurAleatoire();
            List<Cell> cellneighors = new ArrayList<>();
            List<Cell> nneighors = new ArrayList<>();
            int neighborid = neighbor.x + neighbor.y * width;
            cellneighors = cell.getNeighbours();
            nneighors = neighbor.getNeighbours();

            // List<Cell>

            if(allElementsEqual(cellneighors)){
                cellUnique.remove(cell.id);
            }
            if(allElementsEqual(nneighors)){
                cellUnique.remove(neighbor.id);
            }
            // Cell currentCell = maze.cellAleatoire();
            // for (int cell : cellUnique) {
            //     if(maze.getCellById(cell) == ) {

            //     }
            // }
            // if (cellUnique.contains(currentCell.id)) {
            //     while (cellUnique.contains(currentCell.id)) {
            //         currentCell = maze.cellAleatoire();
            //     }
            //     cellUnique.add(currentCell.id);
            // } else {
            //     cellUnique.add(currentCell.id);
            // }
            // System.out.println(maze.toString());;
        }

        return maze;
    }

    public boolean allElementsEqual(List<Cell> list) {
        if (list.isEmpty()) {
            return true;
        }
        Cell firstElement = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) != firstElement) {
                return false;
            }
        }
        return true;
    }
}
