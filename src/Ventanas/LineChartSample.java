/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

/**
 *
 * @author adan-
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
 
 
public class LineChartSample extends Application {
 
    @Override public void start(Stage stage) {
        stage.setTitle("SGA MONITOR");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
         xAxis.setLabel("%");
        final LineChart<String,Number> lineChart = 
                new LineChart<String,Number>(xAxis,yAxis);
       
        lineChart.setTitle("MONITOR STATUS");
                          
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("SHARED POOL ");
        
        series1.getData().add(new XYChart.Data("10%",  23));
        series1.getData().add(new XYChart.Data("20%",  14));
        series1.getData().add(new XYChart.Data("30%",  15));
        series1.getData().add(new XYChart.Data("40%",  24));
        series1.getData().add(new XYChart.Data("50%",  34));
        series1.getData().add(new XYChart.Data("60%",  36));
        series1.getData().add(new XYChart.Data("70%",  22));
        series1.getData().add(new XYChart.Data("80%",  100));
        series1.getData().add(new XYChart.Data("90%",  43));
        series1.getData().add(new XYChart.Data("100%", 17));

        
       /* XYChart.Series series2 = new XYChart.Series();
        series2.setName("I/O");
        series2.getData().add(new XYChart.Data("Jan", 33));
        series2.getData().add(new XYChart.Data("Feb", 34));
        series2.getData().add(new XYChart.Data("Mar", 25));
        series2.getData().add(new XYChart.Data("Apr", 44));
        series2.getData().add(new XYChart.Data("May", 39));
        series2.getData().add(new XYChart.Data("Jun", 16));
        series2.getData().add(new XYChart.Data("Jul", 55));
        series2.getData().add(new XYChart.Data("Aug", 54));
        series2.getData().add(new XYChart.Data("Sep", 48));
        series2.getData().add(new XYChart.Data("Oct", 27));
        series2.getData().add(new XYChart.Data("Nov", 37));
        series2.getData().add(new XYChart.Data("Dec", 29));
        
        XYChart.Series series3 = new XYChart.Series();
        series3.setName("CPU MONITOR");
        series3.getData().add(new XYChart.Data("Jan", 44));
        series3.getData().add(new XYChart.Data("Feb", 35));
        series3.getData().add(new XYChart.Data("Mar", 36));
        series3.getData().add(new XYChart.Data("Apr", 33));
        series3.getData().add(new XYChart.Data("May", 31));
        series3.getData().add(new XYChart.Data("Jun", 26));
        series3.getData().add(new XYChart.Data("Jul", 22));
        series3.getData().add(new XYChart.Data("Aug", 25));
        series3.getData().add(new XYChart.Data("Sep", 43));
        series3.getData().add(new XYChart.Data("Oct", 44));
        series3.getData().add(new XYChart.Data("Nov", 45));
        series3.getData().add(new XYChart.Data("Dec", 44));
        */
        Scene scene  = new Scene(lineChart,800,600);       
       // lineChart.getData().addAll(series1, series2, series3);
       lineChart.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }
 
 
    public static void main(String[] args) {
        launch(args);
    }
}
