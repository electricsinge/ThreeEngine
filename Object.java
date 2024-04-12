import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Point3D;
//import java.lang.Object;
//import org.apache.commons.geometry.euclidean.threed.line.Line3D;

public class Object{

    public int[][] verticies = {{}};

    void createLines(int[] startPoint, int[] endPoint){
        int rangeX = endPoint[0] - startPoint[0] + 1;
        int rangeY = endPoint[1] - startPoint[1] + 1;
        int rangeZ = endPoint[2] - startPoint[2] + 1;

        // Initialize a list to store the points
        List<int[]> points = new ArrayList<>();

        // Generate the points
        List<int[]> tempPoints = new ArrayList<>();
        for (int x = 0; x < rangeX; x++) {
            for (int y = 0; y < rangeY; y++) {
                for (int z = 0; z < rangeZ; z++) {
                    // Create a new point for each combination
                    int[] point = {startPoint[0] + x, startPoint[1] + y, startPoint[2] + z};
                    // Add the point to the temporary list
                    tempPoints.add(point);
                }
            }
        }
// Add all points from the temporary list to the original list
        points.addAll(tempPoints);

        // Convert the List<int[]> to int[][]
        int[][] pointsArray = points.toArray(new int[points.size()][]);

        int[][] mergedArray = new int[pointsArray.length + verticies.length][3];

        // Copy elements from array1 and array2 into mergedArray
        System.arraycopy(verticies, 0, mergedArray, 0, verticies.length);
        System.arraycopy(pointsArray, 0, mergedArray, verticies.length, pointsArray.length);

        verticies = mergedArray;

    }

    public Object(int[][] points){

        verticies = points;

      /*  createLines(points[0], points[1]);
        createLines(points[1], points[3]);
        createLines(points[0], points[2]);
        createLines(points[2], points[3]);
        createLines(points[4], points[5]);
        createLines(points[5], points[7]);
        createLines(points[4], points[6]);
        createLines(points[6], points[7]);
        createLines(points[0], points[4]);
        createLines(points[1], points[5]);
        createLines(points[2], points[6]);
        createLines(points[3], points[7]);*/


    }

}
