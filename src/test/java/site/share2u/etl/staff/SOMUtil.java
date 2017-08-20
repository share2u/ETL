package site.share2u.etl.staff;

import org.neuroph.core.Neuron;
import org.neuroph.nnet.Kohonen;

public class SOMUtil {
	// get unit with closetst weight vector
	public static int getWinnerIndex(Kohonen neuralNetwork) {
		Neuron winner = new Neuron();
		double minOutput = 100;
		int winnerIndex = -1;
		Neuron[] neurons = neuralNetwork.getLayerAt(1).getNeurons();
		for (int i = 0; i < neurons.length; i++) {
			double out = neurons[i].getOutput();
			if (out < minOutput) {
				minOutput = out;
				winnerIndex = i;
			} // if
		} // while
		return winnerIndex;
	}

	/**
	 * 10行10列中的位置
	 * 
	 * @param index
	 * @return
	 */
	public static int getRowFromIndex(int index) {
		return index / 10 + 1;
	}

	public static int getColFromIndex(int index) {
		return index % 10 + 1;
	}

}
