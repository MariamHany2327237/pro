package Core;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class AStarPathFinder {
    private final int[][] map;
    private final int rows;
    private final int cols;

    public AStarPathFinder(int[][] map) {
        this.map = map;
        this.rows = map.length;
        this.cols = map[0].length;
    }

    public List<PathCalc> findOptimalPath(int startX, int startY, int goalX, int goalY) {
        // Convert map coordinates to Point objects for simplicity
        Point start = new Point(startX, startY);
        Point goal = new Point(goalX, goalY);

        // Priority queue for open set (sorted by total cost)
        PriorityQueue<Node> openSet = new PriorityQueue<>();
        openSet.add(new Node(start, null, 0, heuristic(start, goal)));

        // Closed set to keep track of visited nodes
        Set<Point> closedSet = new HashSet<>();

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            // Goal reached, reconstruct path
            if (current.position.equals(goal)) {
                return reconstructPath(current);
            }

            closedSet.add(current.position);

            for (PathCalc direction : PathCalc.values()) {
                Point neighbor = getNeighbor(current.position, direction);

                if (!isValidCell(neighbor) || closedSet.contains(neighbor) || map[neighbor.x][neighbor.y] != 1) {
                    continue;
                }

                double tentativeCost = current.gCost + 1; 

                Node neighborNode = new Node(neighbor, current, tentativeCost, heuristic(neighbor, goal));
                if (!openSet.contains(neighborNode)) {
                    openSet.add(neighborNode);
                }
            }
        }

        // No path found
        return Collections.emptyList();
    }
    private List<PathCalc> reconstructPath(Node goalNode) {
        List<PathCalc> path = new ArrayList<>();
        Node current = goalNode;

        while (current.parent != null) {
            Point parent = current.parent.position;
            Point currentPos = current.position;

            // Determine the direction to move from parent to current position
            if (parent.x < currentPos.x) {
                path.add(PathCalc.DOWN);
            } else if (parent.x > currentPos.x) {
                path.add(PathCalc.UP);
            } else if (parent.y < currentPos.y) {
                path.add(PathCalc.RIGHT);
            } else if (parent.y > currentPos.y) {
                path.add(PathCalc.LEFT);
            }

            current = current.parent;
        }

        Collections.reverse(path);
        return path;
    }

    private Point getNeighbor(Point point, PathCalc direction) {
        int x = point.x, y = point.y;

        switch (direction) {
            case UP -> x--;
            case DOWN -> x++;
            case LEFT -> y--;
            case RIGHT -> y++;
        }

        return new Point(x, y);
    }

    private boolean isValidCell(Point point) {
        return point.x >= 0 && point.x < rows && point.y >= 0 && point.y < cols;
    }

    private double heuristic(Point a, Point b) {
        // Euclidean distance as the heuristic function
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    private static class Node implements Comparable<Node> {
        Point position;
        Node parent;
        double gCost; // Cost from start to this node
        double hCost; // Heuristic cost from this node to goal

        public Node(Point position, Node parent, double gCost, double hCost) {
            this.position = position;
            this.parent = parent;
            this.gCost = gCost;
            this.hCost = hCost;
        }

        // Calculate the total cost (fCost) for comparison in the priority queue
        public double getFCost() {
            return gCost + hCost;
        }

        @Override
        public int compareTo(Node other) {
            return Double.compare(getFCost(), other.getFCost());
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Node node = (Node) obj;
            return position.equals(node.position);
        }

        @Override
        public int hashCode() {
            return position.hashCode();
        }
    }
}