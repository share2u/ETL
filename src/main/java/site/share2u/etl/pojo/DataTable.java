package site.share2u.etl.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 根据数据生成和维护可视化数据模型，并提供查询接口
 * 四维的数据透视表
 * 
 */
public class DataTable {
	
	public static void main(String[] args) {
		//1.行列都是维度，度量的选择，分类的选择
		//2.1获取分类对应的行列的度量聚合数据  select 行分类，列，sum(money) from order group by 行分类，列
		//2.2获取子分类对应的行列的度量聚合数据 （多种） select 行（子分类），列，sum(money) from order group by 行（子分类），列
		//3.将数据映射到可视化透视表中
		//4.可视化透视表映射为图表
		int[][][] data = new int[1][2][2];
		data[0][0][0]=100;
		data[0][0][1]=200;
		data[0][1][0]=300;
		data[0][1][1]=400;
		DataTable dataTable = new DataTable(data);
		List<Lable> rows = new ArrayList<>();
		List<Lable> clos = new ArrayList<>();
		rows.add(new Lable(LableType.ROW, "row1", 0, 100, 200));
		rows.add(new Lable(LableType.ROW, "row2", 1, 300, 400));
		clos.add(new Lable(LableType.CLUM, "clo1", 0, 100, 300));
		clos.add(new Lable(LableType.CLUM, "clo2", 1, 200, 400));
		DataInfoOne dataInfoOne = new DataInfoOne(rows,clos);
		List<DataInfoOne> dataInfo = new ArrayList<DataInfoOne>();
		dataInfo.add(dataInfoOne);
		
		dataTable.setDataInfo(dataInfo);
		DataInfoOne dataInfoOneTest = dataTable.getDataInfo().get(0);
		List<Lable> rows2 = dataInfoOneTest.rows;
		List<Lable> clos2 = dataInfoOneTest.clos;
		for (int i = 0; i<rows2.size();i++) {
			for(int j =0; j<clos2.size();j++){
				System.out.println(rows2.get(i).getName()+","+clos2.get(j).getName()+":"+dataTable.getData()[0][i][j]);
			}
		}
	}
	//1.初始化可视化模型
/*		可视化模型需要哪些数据，
 * 			1.1四维数据矩阵中每个单元储存的度量值
 * 			1.2解释模型的信息，包括行列对应的维度项信息和可视化元素的信息
 * 				维度项信息：维度名称，行/列/层维度项名称列表和维度项索引，用于生成透视表上的文字标签
 * 				可视化元素信息：类型（行，列，层维度项，度量项），名称，行列层维度项的索引，维度项的最大最小值，用于可视化编码的方式
 * 		步骤：
 * 		1，1获取行列层的项的数量，以及对应的数值
 * 		1.2依次查询行列层上的维度的信息，初始化对应的数据结构
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
	//2.对模型的查询
	int[][][] data;

	public DataTable(int[][][] data) {
		super();
		this.data = data;
	}
	//多层多行多列的描述信息
	List<DataInfoOne> dataInfo;

	
	public List<DataInfoOne> getDataInfo() {
		return dataInfo;
	}
	public void setDataInfo(List<DataInfoOne> dataInfo) {
		this.dataInfo = dataInfo;
	}
	public int[][][] getData() {
		return data;
	}
	public void setData(int[][][] data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "DataTable [data=" + Arrays.toString(data) + ", dataInfo=" + dataInfo + "]";
	}
	
	
	
	
	
	
}
/**
 *某层的二维数据表的描述信息
 */
class DataInfoOne{
	List<Lable> rows,clos;

	public DataInfoOne(List<Lable> rows, List<Lable> clos) {
		super();
		this.rows = rows;
		this.clos = clos;
	}

	@Override
	public String toString() {
		return "DataInfoOne [rows=" + rows + ", clos=" + clos + "]";
	}
	

	
}

/**
 *数据库中列（维度项）
 */
class Item{
	//维度项的名称：服务类型
	private String name;
	//维度项的列表：医疗，培训。。。。
	private ArrayList<String> catrgory;
}
/**
 *透视表中的描述
 */
class Lable{
	
	public Lable(LableType type, String name, Integer index, double minVal, double maxVal) {
		super();
		this.type = type;
		this.name = name;
		this.index = index;
		this.minVal = minVal;
		this.maxVal = maxVal;
	}
	//行，列，层，度量项类型
	private LableType type;
	//对应Item中的维度项的名称
	private String name;
	//对应透视表中行列层的位置
	private Integer index;
	//度量项的最大，最小值
	double minVal,maxVal;
	
	public LableType getType() {
		return type;
	}

	public void setType(LableType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	public double getMinVal() {
		return minVal;
	}

	public void setMinVal(double minVal) {
		this.minVal = minVal;
	}

	public double getMaxVal() {
		return maxVal;
	}

	public void setMaxVal(double maxVal) {
		this.maxVal = maxVal;
	}

	@Override
	public String toString() {
		return "Lable [type=" + type + ", name=" + name + ", index=" + index + ", minVal=" + minVal + ", maxVal="
				+ maxVal + "]";
	}
	
}
