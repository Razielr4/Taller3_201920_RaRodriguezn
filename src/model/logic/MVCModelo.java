package model.logic;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import model.data_structures.LinearProbingHashST;
import model.data_structures.SeparateChainingHashST;

public class MVCModelo {
	
	private SeparateChainingHashST<Key, Value> sC;
	private LinearProbingHashST<Key, Value> lP;
	
	public MVCModelo(){
		sC = new SeparateChainingHashST<>();
		lP = new LinearProbingHashST<>();
	}
	
	
	public SeparateChainingHashST<Key,Value> getS(){
		return sC;
	}
	
	public LinearProbingHashST<Key, Value> getL(){
		return lP;
	}
	
	/*
	 * Por cada archivo de datos leido, mostrar el número de
viajes cargado y el detalle (la zona origen, la zona destino, el día y el tiempo promedio) del primer
viaje y del último viaje leido. 
	 */
	
	public double[][] carga(){
		double ans[][] = new double[4][9];
		
		CSVReader reader1 = null;
		CSVReader reader2 = null;
		CSVReader reader3 = null;
		CSVReader reader4 = null;
		
		try{
			String[] nextLine;
			Key keyTemp = null;
			Value valueTemp = null;
			
			reader1 = new CSVReader(new FileReader("./data/bogota-cadastral-2018-1-WeeklyAggregate.csv"));
			reader2 = new CSVReader(new FileReader("./data/bogota-cadastral-2018-2-WeeklyAggregate.csv"));
			reader3 = new CSVReader(new FileReader("./data/bogota-cadastral-2018-3-WeeklyAggregate.csv"));
			reader4 = new CSVReader(new FileReader("./data/bogota-cadastral-2018-4-WeeklyAggregate.csv"));
			
			reader1.readNext(); reader2.readNext(); reader3.readNext(); reader4.readNext();
			
			nextLine = reader1.readNext();
			
			keyTemp = createKey(1,nextLine);
			valueTemp = createValue(nextLine);
			
			ans[0][0] = 1;
			ans[0][1] = keyTemp.getSourceid();
			ans[0][2] = keyTemp.getDstid();
			ans[0][3] = keyTemp.getDow();
			ans[0][4] = valueTemp.getMean();
			
			sC.put(keyTemp, valueTemp);
			lP.put(keyTemp, valueTemp);
			
			while ((nextLine = reader1.readNext()) != null) {
				nextLine = reader1.readNext();
				
				keyTemp = createKey(1,nextLine);
				valueTemp = createValue(nextLine);
				
				ans[0][0]++;
				
				sC.put(keyTemp, valueTemp);
				lP.put(keyTemp, valueTemp);
				
			}
			
			ans[0][5] = keyTemp.getSourceid();
			ans[0][6] = keyTemp.getDstid();
			ans[0][7] = keyTemp.getDow();
			ans[0][8] = valueTemp.getMean();
			
			//___________________________________CARGA ARCHIVO 2
			nextLine = reader2.readNext();
			
			keyTemp = createKey(2,nextLine);
			valueTemp = createValue(nextLine);
			
			ans[1][0] = 1;
			ans[1][1] = keyTemp.getSourceid();
			ans[1][2] = keyTemp.getDstid();
			ans[1][3] = keyTemp.getDow();
			ans[1][4] = valueTemp.getMean();
			
			sC.put(keyTemp, valueTemp);
			lP.put(keyTemp, valueTemp);
			
			while ((nextLine = reader2.readNext()) != null) {
				nextLine = reader2.readNext();
				
				keyTemp = createKey(2,nextLine);
				valueTemp = createValue(nextLine);
				
				ans[1][0]++;
				
				sC.put(keyTemp, valueTemp);
				lP.put(keyTemp, valueTemp);
				
			}
			
			ans[1][5] = keyTemp.getSourceid();
			ans[1][6] = keyTemp.getDstid();
			ans[1][7] = keyTemp.getDow();
			ans[1][8] = valueTemp.getMean();
			
			//___________________________________CARGA ARCHIVO 3			
			nextLine = reader3.readNext();
			
			keyTemp = createKey(3,nextLine);
			valueTemp = createValue(nextLine);
			
			ans[2][0] = 1;
			ans[2][1] = keyTemp.getSourceid();
			ans[2][2] = keyTemp.getDstid();
			ans[2][3] = keyTemp.getDow();
			ans[2][4] = valueTemp.getMean();
			
			sC.put(keyTemp, valueTemp);
			lP.put(keyTemp, valueTemp);
			
			while ((nextLine = reader3.readNext()) != null) {
				nextLine = reader3.readNext();
				
				keyTemp = createKey(3,nextLine);
				valueTemp = createValue(nextLine);
				
				ans[2][0]++;
				
				sC.put(keyTemp, valueTemp);
				lP.put(keyTemp, valueTemp);
				
			}
			
			ans[2][5] = keyTemp.getSourceid();
			ans[2][6] = keyTemp.getDstid();
			ans[2][7] = keyTemp.getDow();
			ans[2][8] = valueTemp.getMean();
			
			//___________________________________CARGA ARCHIVO 4
			nextLine = reader4.readNext();
			
			keyTemp = createKey(3,nextLine);
			valueTemp = createValue(nextLine);
			
			ans[3][0] = 1;
			ans[3][1] = keyTemp.getSourceid();
			ans[3][2] = keyTemp.getDstid();
			ans[3][3] = keyTemp.getDow();
			ans[3][4] = valueTemp.getMean();
			
			sC.put(keyTemp, valueTemp);
			lP.put(keyTemp, valueTemp);
			
			while ((nextLine = reader4.readNext()) != null) {
				nextLine = reader4.readNext();
				
				keyTemp = createKey(4,nextLine);
				valueTemp = createValue(nextLine);
				
				ans[3][0]++;
				
				sC.put(keyTemp, valueTemp);
				lP.put(keyTemp, valueTemp);
				
			}
			
			ans[3][5] = keyTemp.getSourceid();
			ans[3][6] = keyTemp.getDstid();
			ans[3][7] = keyTemp.getDow();
			ans[3][8] = valueTemp.getMean();
			
			
		}catch(Exception e){
			e.printStackTrace();

		}finally{
			if (reader1 != null) {
				try {
					reader1.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (reader2 != null) {
				try {
					reader2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			if (reader3 != null) {
				try {
					reader3.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}if (reader4 != null) {
				try {
					reader4.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return ans;
		
	}
	
	//TODO clases y metodos auxiliares
	
	public class Key implements Comparable<Key>{
		
		private int trimester;
		private int sourceid;
		private int dstid;
		private int dow;
		
		 public Key(int pTrimester, int pSourceid,int pDstid,int pDow){
			trimester = pTrimester;
			sourceid = pSourceid;
			dstid = pDstid;
			dow = pDow;
		}
		
		public int getDow(){
			return dow;
		}
		
		public int getDstid(){
			return dstid;
		}
		
		public int getTrimester(){
			return trimester;
		}
		
		public int getSourceid(){
			return sourceid;
		}
		
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + dstid;
			result = prime * result + sourceid;
			result = prime * result + trimester;
			return result;
		}
		
		public int compareTo(Key comp) {
			return (dow > comp.getDow())?1:(dow < comp.getDow())?-1:0;
		}
	}
	
	public class Value {
		private double mean;
		private double standard_deviation;
		
		public Value(double pMean,double pDerivation){
			mean = pMean;
			standard_deviation = pDerivation;
		}
		
		public double getMean(){
			return mean;
		}
		
		public double getStandard(){
			return standard_deviation;
		}
		
		
	}
	
    private Key createKey(int trimester,String[] datos) {
		
		int sourceid = Integer.parseInt(datos[0]); 
		int dstid = Integer.parseInt(datos[1]);
		int dow = Integer.parseInt(datos[2]);
		
		return new Key(trimester,sourceid,dstid,dow);
	}
    
    private Value createValue(String[] datos) {
    	
    	double mean = Double.parseDouble(datos[3]);
		double standard_deviation = Double.parseDouble(datos[4]);
    	
    	return new Value(mean,standard_deviation);
    }

}
