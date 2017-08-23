package site.share2u.som;

import java.io.*;
import java.util.ArrayList;

/**
 * 
 * 类包含SOM神经网络，以及训练和测试数据
 * 
 */
public class NeuralK {

	/**
	 * 训练集
	 */
	private Kohonen_Training_Data Kohonen_Train = new Kohonen_Training_Data();
	private Kohonen_Test_Data[] Kohonen_Test; // number of tests is variable
	private int number_of_Kohonen_tests;

	/**
	 * 竞争层拓扑结构
	 */
	public Kohonen_Topology Kohonen_Design = new Kohonen_Topology();

	/**
	 * 构造神经网络拓扑结构，建立权值数组
	 */
	public void construct_Kohonen_network() {
		System.out.println("**** Kohonen Self-Organizing Map ****");
		Kohonen_Design.establish_Kohonen_topology(1);
	}

	/**
	 * 加载，归一化训练集数组
	 */
	private void initialize_Kohonen_training_storage_array(int KN) {
		int KT = KN;
		Kohonen_Train.acquire_net_info(Kohonen_Design.dimensions_of_signal);
		Kohonen_Train.request_Kohonen_data(KT);
	}

	private void establish_Kohonen_test_battery_size() {
		System.out
				.println("Please enter the number of tests you wish to run on the Kohonen Neural Network: ");
		// number_of_Kohonen_tests = MyInput.readInt();
		number_of_Kohonen_tests = 1;
		System.out.println();
		if (number_of_Kohonen_tests > 0) {
			// create testing array
			Kohonen_Test = new Kohonen_Test_Data[number_of_Kohonen_tests];
			for (int t = 0; t < number_of_Kohonen_tests; t++) {
				Kohonen_Test[t] = new Kohonen_Test_Data();
				Kohonen_Test[t]
						.acquire_net_info(Kohonen_Design.dimensions_of_signal);
			}
		}
	}

	/**
	 * 训练神经网络
	 * 
	 * @param KOHN
	 * @throws IOException
	 */
	private void train_Kohonen_network(int KOHN) {
		int dim, ep, k_epochs, pattern, knodes, dolock;
		System.out.println();
		System.out.println("For Neural Network #" + KOHN);
		System.out
				.println("please enter the maximum learning rate parameter (0-1): ");
		// Kohonen_Design.max_learning_rate = MyInput.readDouble();
		// TODO:最大学习率
		Kohonen_Design.max_learning_rate = 1.0;
		System.out.println();
		System.out
				.println("please enter the minimum learning rate parameter (0-1): ");
		// Kohonen_Design.min_learning_rate = MyInput.readDouble();
		// TODO:最小学习率
		Kohonen_Design.min_learning_rate = 0.0;
		System.out.println();
		System.out
				.println("please enter the number of epochs（训练次数） used to train the Kohonen Map: ");
		// k_epochs = MyInput.readInt();
		// TODO:训练次数
		k_epochs = 10000;
		System.out.println();
		ep = 0;
		dolock = 0;
		// FileWriter fileWriter = new FileWriter(new File("learning.txt"));学习率
		//ArrayList<Double> al = new ArrayList<Double>();
		do {
			// 样本数量
			for (pattern = 0; pattern < Kohonen_Train.sample_number; pattern++) {
				// 聚簇个数
				for (knodes = 0; knodes < Kohonen_Design.maximum_number_of_clusters; knodes++) {
					// 样本维度
					for (dim = 0; dim < Kohonen_Design.dimensions_of_signal; dim++) {
						// 取出每个样本中的归一化维度数据放到竞争层中每个簇的输入数组中
						// 并不是随机取样本里的值，有什么影响？
						Kohonen_Design.node_in_cluster_layer[knodes].input_value[dim] = Kohonen_Train.number_of_samples[pattern].data_in_sample[dim];
					}
				}
				Kohonen_Design.kluster_nodes_compete_for_activation();
				Kohonen_Design.update_the_Kohonen_network2(ep, k_epochs);
				//Kohonen_Design.update_the_Kohonen_network(ep, k_epochs);
				//Kohonen_Design.update_the_Kohonen_network1();
			}
			// 修改学习率的部分
			update_learning2(ep, k_epochs);
			//al.add(Kohonen_Design.interim_learning_rate);
			System.out.println("第 " + (ep + 1) + " 次训练已完成" + "---学习率："
					+ Kohonen_Design.interim_learning_rate);
			if ((ep == k_epochs - 1)
					|| (Kohonen_Design.interim_learning_rate == 0.0))// 学习率等于0或者训练次数到达
			{
				dolock = 1;
			}
			ep = ep + 1;
		} while (dolock <= 0);
		/*
		 * fileWriter.write(al.toString()); fileWriter.close();
		 */Kohonen_Design.saveMinDistances();
		Kohonen_Train.delete_signal_array();
	}

	/**
	 * 原本学习率下降函数
	 * 
	 * @param epoch_count
	 *            当前的训练次数
	 * @param max_epochs
	 *            最大的训练次数
	 */
	private void update_learning(int epoch_count, int max_epochs) {
		int maxepoch;
		if (max_epochs == 1) {
			maxepoch = 1;
		} else {
			maxepoch = max_epochs - 1;
		}
		// 学习率调整
		double adjusted_learning_rate = Kohonen_Design.max_learning_rate
				- (((Kohonen_Design.max_learning_rate - Kohonen_Design.min_learning_rate) / maxepoch) * epoch_count);
		Kohonen_Design.interim_learning_rate = adjusted_learning_rate
				* Kohonen_Design.interim_learning_rate;
	}

	/**
	 * 单调下降
	 * 
	 * @param epoch_count
	 *            当前的训练次数
	 * @param max_epochs
	 *            最大的训练次数
	 */
	private void update_learning1(int epoch_count, int max_epochs) {
		int maxepoch;
		if (max_epochs == 1) {
			maxepoch = 1;
		} else {
			maxepoch = max_epochs - 1;
		}
		// 学习率调整
		double adjusted_learning_rate = Kohonen_Design.max_learning_rate
				- (((Kohonen_Design.max_learning_rate - Kohonen_Design.min_learning_rate) / maxepoch) * epoch_count);
		// 单调下降
		Kohonen_Design.interim_learning_rate = adjusted_learning_rate * 1;
	}

	private void update_learning2(int epoch_count, int max_epochs) {
		int maxepoch;
		if (max_epochs == 1) {
			maxepoch = 1;
		} else {
			maxepoch = max_epochs - 1;
		}
		// 学习率调整
		double adjusted_learning_rate = Kohonen_Design.max_learning_rate
				- (((Kohonen_Design.max_learning_rate - Kohonen_Design.min_learning_rate) / Math
						.log(maxepoch + 1)) * (Math.log(epoch_count + 1)));
		// 单调下降
		Kohonen_Design.interim_learning_rate = adjusted_learning_rate * 1;
	}

	private void test_Kohonen_network(int KNET) {
		int tnet, dim, pattern, knodes;
		double realvalue;
		tnet = KNET;
		for (int ktest = 0; ktest < number_of_Kohonen_tests; ktest++) {
			Kohonen_Test[ktest].request_Kohonen_data(tnet);
			System.out.println("For Kohonen neural network #" + KNET
					+ " and test #" + (ktest + 1) + ":");
			System.out
					.println("please enter the name of the file to hold the test");
			Kohonen_Test[ktest].resultsname = MyInput.readString();
			System.out.println();
			FileWriter Kohonen_savefile_ptr;
			StringBuffer s = new StringBuffer("");
			try {
				Kohonen_savefile_ptr = new FileWriter(
						Kohonen_Test[ktest].resultsname);

				for (pattern = 0; pattern < Kohonen_Test[ktest].sample_number; pattern++) {
					for (knodes = 0; knodes < Kohonen_Design.maximum_number_of_clusters; knodes++) {
						for (dim = 0; dim < Kohonen_Design.dimensions_of_signal; dim++) {
							Kohonen_Design.node_in_cluster_layer[knodes].input_value[dim] = Kohonen_Test[ktest].number_of_samples[pattern].data_in_sample[dim];
						}
					}
					Kohonen_Design.kluster_nodes_compete_for_activation();
					
					for (dim = 0; dim < Kohonen_Design.dimensions_of_signal; dim++) {
//						realvalue = (Kohonen_Test[ktest].number_of_samples[pattern].data_in_sample[dim] * (Kohonen_Test[ktest].max_output_value[dim] - Kohonen_Test[ktest].min_output_value[dim]))
//								+ Kohonen_Test[ktest].min_output_value[dim];
						realvalue = Kohonen_Test[ktest].number_of_samples[pattern].data_in_sample[dim];
						s.append(realvalue).append(" ");
					}
//					s.append(pattern + 1).append(" ");
					if(pattern>=0 && pattern <50){
						s.append("A").append("-");
					}else if(pattern >=50 && pattern <100){
						s.append("B").append("-");
						
					}else if(pattern >=100 && pattern <150){
						s.append("C").append("-");
						
					}
					s.append(
							Kohonen_Design.node_in_cluster_layer[Kohonen_Design.kluster_champ].row
									+ "-"
									+ Kohonen_Design.node_in_cluster_layer[Kohonen_Design.kluster_champ].col)
							.append("\r\n");
				}
				Kohonen_savefile_ptr.write(s.toString());

				Kohonen_savefile_ptr.close();
			} catch (IOException exc) {
				System.out.println(exc.toString());
			}

			Kohonen_Test[ktest].delete_signal_array();
		} // end test loop
	}

	/**
	 * 选择神经网络训练|测试
	 */
	public void network_training_testing(int TT) {
		int tt = TT;
		int menu_choice;

		System.out.println();
		System.out.println("**************** Operations Menu ****************");
		System.out.println("  Please select one of the following options:");
		System.out.println("      1. Train Kohonen network only ");
		System.out.println("      2. Test Kohonen network only ");
		System.out.println("      3. Train and Test Kohonen network");
		System.out.println("*************************************************");
		System.out.println("         Your choice?: ");
		// menu_choice = MyInput.readInt();
		menu_choice = 3;
		System.out.println();
		switch (menu_choice) {
		case 1:
			initialize_Kohonen_training_storage_array(tt);
			train_Kohonen_network(tt);
			break;

		case 2:
			establish_Kohonen_test_battery_size();
			if (number_of_Kohonen_tests > 0) {
				test_Kohonen_network(tt);
			}
			break;

		case 3:
			initialize_Kohonen_training_storage_array(tt);
			train_Kohonen_network(tt);
			establish_Kohonen_test_battery_size();
			if (number_of_Kohonen_tests > 0) {
				test_Kohonen_network(tt);
			}
			break;

		default:
			network_training_testing(tt);
		}
	}
}
