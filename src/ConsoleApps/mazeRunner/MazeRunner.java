package ConsoleApps.mazeRunner;

public class MazeRunner {
    public static void main(String[] args) {
        Maze maze = new Maze(6, 6);
        maze.putTreasure(2, 3);
        maze.putAdventure(0, 0);
        maze.printMaze();
        System.out.println("Shortest path is : " + maze.shortestPath());
    }


}
