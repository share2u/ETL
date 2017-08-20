package site.share2u.etl.staff;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.neuroph.core.data.DataSet;
import org.neuroph.core.data.DataSetRow;
import org.neuroph.nnet.Kohonen;


public class SOMTest {

	 public static void main(String[] args) throws IOException {
		File file = new File("e:/iris.data");
		FileInputStream fileInputStream = new FileInputStream(file);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
		String str;
		ArrayList<ArrayList<Double>> data =new ArrayList<>();
		String[] split;
		while((str=bufferedReader.readLine()) != null){
			ArrayList<Double> dataSplit = new ArrayList<>();
			split = str.split(",");
			
			for (int i = 0; i < split.length; i++) {
				/*if(i==0){
					dataKey.add(split[i]);
					continue;
				};*/
					dataSplit.add(Double.parseDouble(split[i]));
			}
			data.add(dataSplit);
		}
		int cloSize = data.size();//元素的个数
		int wdSize = data.get(0).size();//元素的维度
		for (int i = 0; i < cloSize; i++) {
			for (int j = 0; j <cloSize; j++) {
				data.get(i).add(0.0);				
			}
			data.get(i).set(wdSize+i, 1.0);
		}
		

        ResultFrame frame = new ResultFrame();
        int inputNeuronsCount=cloSize+wdSize;
        Kohonen som = new Kohonen(inputNeuronsCount, 100);
        DataSet ds = new DataSet(inputNeuronsCount);
        for (int i=0;i<data.size();i++) {
        	double[] row =new double[inputNeuronsCount];
        	for (int j = 0; j < data.get(i).size(); j++) {
        		row[j]=data.get(i).get(j);
			}
        	ds.addRow(new DataSetRow(row));
		}
        
        
        ArrayList<String> dataKey =new ArrayList<String>();
        for(int i=0;i<cloSize;i++){
        	if(i>=0 && i<51){
        		dataKey.add("A");
        	}
        	if(i>=51 && i<101){
        		dataKey.add("B");
        	}
        	if(i>=101 && i<151){
        		dataKey.add("C");
        	}
        }
        som.learn(ds);
        for (int i=0;i<data.size();i++) {
        	ArrayList<Double> arrayList = data.get(i);
        	double[] inputV =new double[inputNeuronsCount];
        	for (int j = 0; j < arrayList.size(); j++) {
        		inputV[j]=arrayList.get(j);
			}
        	som.setInput(inputV);
            som.calculate();
            int winnerIndex=SOMUtil.getWinnerIndex(som);
            int x=SOMUtil.getRowFromIndex(winnerIndex);
            int y=SOMUtil.getColFromIndex(winnerIndex);
            System.out.println(dataKey.get(i)+" "+x+" "+y );
            frame.addElementString(new ResultFrame.ElementString(dataKey.get(i), x, y));
        }
        frame.showMe();
        System.out.println("over");
		
	}
}
