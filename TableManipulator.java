import java.util.*;
import java.lang.*;

class TableMan{

	public static void main(String []args){
		
		Vector recordVec = new Vector();
		Integer[][][] tableSetArr;
		int maxPossibleRows = 0;
		int currentEntries = 0;
		int colCount;
		int[] colSizeArr;
		int[] rowSumArr;
		int[] rowSizeArr;


		while(recordVec.size()<10000){

			System.out.println("Plese enter Integer values of the list. Press Enter after each element. Enter 0 to end.");
			Vector tmpVec = new Vector();
			Scanner listScan = new Scanner(System.in);
			while(true){
				Integer temp = listScan.nextInt();
				if(temp==0)
					break;
				tmpVec.addElement(temp);
				currentEntries++;
				if(currentEntries > maxPossibleRows)
					maxPossibleRows = currentEntries;
			}
			recordVec.add(tmpVec);
			System.out.println("Do you want to add another record?");
			System.out.println("1. Yes");
			System.out.println("2. No");
			System.out.println("Enter 1 or 2");
			int choice = new Scanner(System.in).nextInt();
			if (choice==2)
				break;
		}
		colSizeArr = new int[recordVec.size()];
		rowSizeArr = new int[recordVec.size()];
		tableSetArr = new Integer[recordVec.size()][5][maxPossibleRows];
		//tableSetArr[] = new Integer[5][];
		//tableSetArr[][] = new Integer[maxPossibleRows];

		for(int i=0; i<recordVec.size();i++){


			int columns = (int)Math.ceil(Math.random()*5);
			colSizeArr[i] = columns;
			Vector temp = (Vector)recordVec.get(i);
			rowSizeArr[i] = (int)(Math.ceil((double)temp.size()/columns));
			int innerVecPos =0;

			for(int j=0;j<columns;j++){

				//tableSetArr[i] = new Integer[columns][];

				System.out.println("number of columns : "+columns);
				int numRows = (int)(Math.ceil((double)temp.size()/columns));
				System.out.println("number of rows : "+numRows+"\nVec Size : "+temp.size());

				for(int r=0;r<numRows;r++){

					//tableSetArr[i][j] = new Integer[(int)(Math.ceil((double)temp.size()/columns))];
					int vecSize = temp.size();
					System.out.println("Mod :"+vecSize%columns);
					int mod = vecSize%columns;

					if(mod==0 || (mod!=0 && r!=numRows-1)){

						if(temp.size()==innerVecPos)
							break;
						Vector tempInner = (Vector) recordVec.get(i);
						System.out.println("Normal routine.\n");
						System.out.println("Geting items from Vector "+i+ " : "+tempInner);
						tableSetArr[i][j][r] = (Integer) tempInner.get(innerVecPos);
						System.out.println("i="+i+"j="+j+"r="+r+"\n Vector Item value : "+ tempInner.get(innerVecPos));
						
						try{
							System.out.println("Value in array : "+tableSetArr[i][j][r]);
						}catch(Exception e){
							e.getMessage();
						}
						innerVecPos++;
					}
					if(mod!=0 && r==numRows-1 && j<=mod-1){
						if(temp.size()==innerVecPos+1)
							break;
						Vector tempInner = (Vector) recordVec.get(i);
						System.out.println("Extra round.\n");
						System.out.println("Geting items from Vector "+i+ " : "+tempInner);
						tableSetArr[i][j][r] = (Integer) tempInner.get(innerVecPos);
						System.out.println("i="+i+"j="+j+"r="+r+"\n Vector Item value : "+ tempInner.get(innerVecPos));
						
						try{
							System.out.println("Value in array : "+tableSetArr[i][j][r]);
						}catch(Exception e){
							e.getMessage();
						}
						innerVecPos++;
					}
					
				}
				System.out.println("Array size :"+tableSetArr[i][j].length+"\n");
			}

		}

		System.out.println("The lists you entered are: ");

		for(int l=0;l<recordVec.size();l++){
			System.out.println(recordVec.get(l));
		}

		/*
		for(int i=0;i<recordVec.size();i++){
			for(int j=0;j<((Vector)recordVec.get(i)).size();j++){
				Vector temp = (Vector)(recordVec.get(i));
				System.out.print(temp.get(j)+" ");
			}	
			System.out.println();
		}*/


		System.out.println("\n\nCol\t Row Sum");
		for(int x=0;x<tableSetArr.length;x++){
			rowSumArr = new int[rowSizeArr[x]];
			for(int y=0;y<tableSetArr[x].length;y++){
				try{
					for(int z=0;z<tableSetArr[x][y].length;z++){
						if(tableSetArr[x][y][z]!=null){
						rowSumArr[z] = rowSumArr[z]+tableSetArr[x][y][z];
						}
					}
				}catch(Exception e){
				}
			}
			System.out.print(colSizeArr[x]+"\t");
			for(int k=0;k<rowSizeArr[x];k++){
				System.out.print(rowSumArr[k]+" ");
			}
			System.out.println("");
		}



	}
	
	
}
 