package org.example.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cell {

    public int id;
    public boolean murNord;
    public boolean murSud;
    public boolean murEst;
    public boolean murOuest;
    public int x;
    public int y;
    public Maze maze;


    public Cell(int id, boolean murNord, boolean murSud, boolean murEst,  boolean murOuest){
        this.id = id;
        this.murNord = murNord;
        this.murSud = murSud;
        this.murEst = murEst;
        this.murOuest = murOuest;
    }


    public Cell casseMurAleatoire() {
        Random random = new Random();

        int randomX = random.nextInt(maze.width);
        int randomY = random.nextInt(maze.height);

        Cell cell = maze.allCells.get(randomY).get(randomX);
        Cell neighbor = null;

        // Sélectionnez un mur aléatoire à casser (nord, sud, est, ouest)
        int randomDirection = random.nextInt(4);

        switch (randomDirection) {
            case 0: // Nord
                if (randomY > 0) {
                    neighbor = maze.allCells.get(randomY - 1).get(randomX);
                    if (cell.id != neighbor.id) {
                        if(cell.id < neighbor.id) {
                            for(Cell c : maze.allCellsByID(neighbor.id)) {
                                c.id = cell.id;
                            }
                        }
                        else if(cell.id > neighbor.id) {
                            for(Cell c : maze.allCellsByID(cell.id)) {
                                c.id = cell.id;
                            }
                        }
                        cell.murNord = false;
                        neighbor.murSud = false;
                    }
                }
                return neighbor;
            case 1: // Sud
                if (randomY < maze.height - 1) {
                    neighbor = maze.allCells.get(randomY + 1).get(randomX);
                    if (cell.id != neighbor.id) {
                        if(cell.id < neighbor.id) {
                            for(Cell c : maze.allCellsByID(neighbor.id)) {
                                c.id = cell.id;
                            }
                        }
                        else if(cell.id > neighbor.id) {
                            for(Cell c : maze.allCellsByID(cell.id)) {
                                c.id = cell.id;
                            }
                        }
                        cell.murSud = false;
                        neighbor.murNord = false;
                    }
                }
                return neighbor;
            case 2: // Est
                if (randomX < maze.width - 1) {
                    neighbor = maze.allCells.get(randomY).get(randomX + 1);
                    if (cell.id != neighbor.id) {
                        if(cell.id < neighbor.id) {
                            for(Cell c : maze.allCellsByID(neighbor.id)) {
                                c.id = cell.id;
                            }
                        }
                        else if(cell.id > neighbor.id) {
                            for(Cell c : maze.allCellsByID(cell.id)) {
                                c.id = cell.id;
                            }
                        }
                        cell.murEst = false;
                        neighbor.murOuest = false;
                    }
                }
                return neighbor;
            case 3: // Ouest
                if (randomX > 0) {
                    neighbor = maze.allCells.get(randomY).get(randomX - 1);
                    if (cell.id != neighbor.id) {
                        if(cell.id < neighbor.id) {
                            for(Cell c : maze.allCellsByID(neighbor.id)) {
                                c.id = cell.id;
                            }
                        }
                        else if(cell.id > neighbor.id) {
                            for(Cell c : maze.allCellsByID(cell.id)) {
                                c.id = cell.id;
                            }
                        }
                        cell.murOuest = false;
                        neighbor.murEst = false;
                    }
                }
                return neighbor;

            default:
                break;
        }

        // tet
        System.out.println("");
        return null;
    }



    public List<Cell> getNeighbours() {
        List<Cell> list = new ArrayList<>();
        if(y - 1 >= 0) list.add(maze.getCellPosition(x, y - 1));
        if(y + 1 < maze.height) list.add(maze.getCellPosition(x, y + 1));
        if(x + 1 < maze.width) list.add(maze.getCellPosition(x + 1, y));
        if(x - 1 >= 0) list.add(maze.getCellPosition(x - 1, y));
        return list;
    }

}
