package com.java;


import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileOperations {

    File file = new File(System.getProperty("user.home") + "/Downloads/SalesInvoiceGenerator/src/resources/student-data.txt");
    ArrayList<Student> result = new ArrayList<Student>();

    public void readDataFile() {
        //String[] row =null;
        List<String[]> row = new ArrayList<String[]>();


        try {

            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String[] rows = sc.nextLine().split("\\$");
                for (int i = 0; i < rows.length; i++) {
                     System.out.println(rows[i]);
                   String singleRow = rows[i];
                    for (int j = 0; j < singleRow.length(); j++) {
                        String[] rowdata  = singleRow.split("#");
                       System.out.println(rowdata[j]);
                       row.add(rowdata);
                        writeDataFile(row);

                    }
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void writeDataFile( List<String[]> cellData){
        File file = new File(System.getProperty("user.home") + "/Downloads/SalesInvoiceGenerator/src/resources/student-data.CSV");

        try{
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile, '#',
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END);

            writer.writeAll(cellData);

        } catch (Exception e){


        }


    }

}
