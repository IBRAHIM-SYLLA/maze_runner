package org.example.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Maze{

    public int width;
    public int height;
    public List<List<Cell>> allCells =  new ArrayList<>();
    

    public Maze(int width, int height){
        this.width = width;
        this.height = height;
        int id = 0;

        for(int i = 0; i < this.height; i++){
            List<Cell> col = new ArrayList<>();
            for(int j = 0; j < this.width; j++){
                Cell cell = new Cell(id++, true, true, true, true);
                cell.maze = this;
                cell.x = j;
                cell.y = i;
                col.add(cell);
            }
            allCells.add(col);
        }
        
    }

    public int numberOfZero() {
        int counter = 0;
        for (int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                if (allCells.get(x).get(y).id == 0) counter++;
            }
        }

        return counter;
    }

    public List<Cell> allCellsByID(int id) {
        ArrayList<Cell> cells = new ArrayList<>();
        for(int x = 0; x < width; x++) {
            for(int y = 0; y < height; y++) {
                if(allCells.get(x).get(y).id == id) {
                    cells.add(allCells.get(x).get(y));
                }
            }
        }

        return cells;
    }

    public String toString() {
        String res = "";
        // pour chaque cellule
        for(int y = 0; y < height; y++) {
            // cell.casseMurAleatoire();
            // pour le mur du haut
            for(int x = 0; x < width; x++) {
                Cell c = allCells.get(y).get(x);
                // s'il y a le mur du nord, l'afficher, sinon mettre un vide
                res += c.murNord ? "###" : "#.#";
            }

            res += "\n";

            // pour le mur de gauche et de droite
            for(int x = 0; x < width; x++) {
                Cell c = allCells.get(y).get(x);
                // s'il y a le mur de l'ouest, l'afficher, sinon mettre un vide
                res += c.murOuest ? "#" : ".";
                res += c.id; // l'espace au milieu
                // s'il y a le mur de l'est, l'afficher, sinon mettre un vide
                res += c.murEst ? "#" : ".";
            }

            res += "\n";

            // pour le mur du bas
            for(int x = 0; x < width; x++) {
                Cell c = allCells.get(y).get(x);
                // s'il y a le mur du sud, l'afficher, sinon mettre un vide
                res += c.murSud ? "###" : "#.#";
            }

            res += "\n";
        }

        return res;
    }

    public Cell cellAleatoire(){
        Random random = new Random();
        return allCells.get(random.nextInt(this.height)).get(random.nextInt(this.width));
    }

    public Cell getCellById(int id){
        for (List<Cell> list : allCells) {
            for (Cell cell : list) {
                allCells.get(id);
                if (cell.id == id){
                    return cell;
                }
            }
        }
        return null;
    }

    public Cell getCellPosition(int x, int y){
        return allCells.get(x).get(y);
    }
}
