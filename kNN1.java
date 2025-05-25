import java.util.*;

import javax.annotation.processing.FilerException;

import java.io.*;

public class kNN1 {

    private static final Exception FileException = null;
    public static void main(String[] args) throws IOException {
        
        // Define and initalise the size of constants
        int TRAIN_SIZE = 200;       // no. of training patterns
        int TEST_SIZE = 200;        // no. of testing patterns
        int FEATURE_SIZE = 61;      // no. of features

        // Define the training array
        double[][] train = new double[TRAIN_SIZE][FEATURE_SIZE]; // training data 
        int[] train_label = new int[TRAIN_SIZE];   // training label        
        // Define the testing array
        double[][] test = new double[TEST_SIZE][FEATURE_SIZE]; // testing data
        int[] test_label = new int[TEST_SIZE]; // testing label 

         // Load the training pattern
         Scanner scp = new Scanner(new File("train_data")); 
         for(int i = 0; i < TRAIN_SIZE; i++) {
             for(int j = 0; j < FEATURE_SIZE; j++) {
                 if(scp.hasNextDouble()) {
                     train[i][j] = scp.nextDouble();
                 }
             }
         }
         scp.close();
 
          // Load the training label 
         Scanner scp2 = new Scanner(new File("train_label.txt"));
         for(int i = 0; i < TRAIN_SIZE; i++) {
                 if(scp2.hasNextInt()) {
                     train_label[i] = scp2.nextInt();
                 }
         }
         scp2.close();
 
         // Load the testing pattern
         Scanner scp3 = new Scanner(new File("test_data.txt"));
         for(int i = 0; i < TEST_SIZE; i++) {
             for( int j = 0; j < FEATURE_SIZE; j++) {
                 if(scp3.hasNextDouble()) {
                     test[i][j] = scp3.nextDouble();
                 }
             }
         }
         scp3.close();
         
         // Load the testing label
         Scanner scp4 = new Scanner(new File("test_label.txt"));
         for(int i = 0; i < TEST_SIZE; i++) {
                 if(scp4.hasNextInt()) {
                     test_label[i] = scp4.nextInt();
                 }
         }
         scp4.close();
 
         // Enter a value for the K-Value 
         int k = 1;
         // Writing the output.txt in the required format
         try {
             PrintWriter writer = new PrintWriter("output.txt");
             // Keep a count of the current number of correct predictions.
             int correctPredictions = 0;
             for(int i = 0; i < TEST_SIZE; i++) {
                     int predictedLabelIndex = calculateEculidian(test, train, FEATURE_SIZE, TEST_SIZE, TRAIN_SIZE, i, k);
                     int predictedLabel = train_label[predictedLabelIndex];
                     int actualLabel = test_label[i];
                 for(int j = 0; j < FEATURE_SIZE; j++) {
                     // writer.print(test[i][j] + " ");
                 } 
                 writer.println(predictedLabel + ", ");
                 // Check to see if the predictions are correct
                 if(predictedLabel == actualLabel) {
                     correctPredictions++;
                 }
             }
             // Calaculate and return the classification accuracy
             double accuracy = (double) correctPredictions / TEST_SIZE * 100;
             writer.println("Classification Accuracy: " + accuracy + "%");
 
             writer.close();
         }catch (Exception e) {
             System.out.println(e);
         }
 
  }  // End main loop
     private static int calculateEculidian(double[][]test, double[][]train, int FEATURE_SIZE, int TEST_SIZE, int TRAIN_SIZE, int rowIndex, int k){
         int[] indices = new int[k];
     // Create a 1D array to hold the result of the arthimetic.
         double[] distance = new double[train.length];
             // Calculate the eculidian distance between each test pattern against all the training patterns
             for(int j = 0; j < train.length; j++) {
                 double sum = 0;
                 for(int f = 0; f < FEATURE_SIZE; f++) {
                     sum += (test[rowIndex][f] - train[j][f]) * (test[rowIndex][f] - train[j][f]);
                 }
                 sum = Math.sqrt(sum);
                 distance[j] = sum;
             }
     // Find the minimum value in the distance array and return it.
             for(int i = 0; i < k; i++) {
                double min = Double.MAX_VALUE;
                 int minIndex = 0;
 
                 for(int j = 0; j < distance.length; j++) {
                     if(distance[j] < min) {
                     min = distance[j];
                     minIndex = j;
                 }
                }
             distance[minIndex] = Double.MAX_VALUE; // Mark the minimum distance as processed
             indices[i] = minIndex;
             }
         return indices[0];
    }
}