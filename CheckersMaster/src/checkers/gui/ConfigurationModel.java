package checkers.gui;

import java.util.LinkedList;
import java.util.List;

import checkers.algorithm.AlphaBetaAlgorithm;
import checkers.algorithm.GreedyAlgorithm;
import checkers.algorithm.IAlgorithm;
import checkers.algorithm.MinimaxAlgorithm;
import checkers.evaluation.IEvaluation;
import checkers.evaluation.MenCountEvaluation;
import checkers.evaluation.PlayableWeightenedMenCountEvaluation;
import checkers.evaluation.RatioWeightenedCountEvaluation;
import checkers.evaluation.EnhancedWeightenedMenCountEvaluation;
import checkers.evaluation.WeightenedMenCountEvaluation;

public class ConfigurationModel {

	private List<IAlgorithm> algorithms = new LinkedList<IAlgorithm>();
	{
		algorithms.add(new GreedyAlgorithm());
		algorithms.add(new MinimaxAlgorithm());
		algorithms.add(new AlphaBetaAlgorithm());
	}
	
	private IAlgorithm selectedAlgorithm = null;
	
	private Integer[] depth = new Integer[] {3, 4, 5, 6, 7};
	
	private int selectedDepth = 3;
	
	private List<IEvaluation> evaluations = new LinkedList<IEvaluation>();
	{
		evaluations.add(new MenCountEvaluation());
		evaluations.add(new WeightenedMenCountEvaluation());
		evaluations.add(new RatioWeightenedCountEvaluation());
		evaluations.add(new EnhancedWeightenedMenCountEvaluation());
		evaluations.add(new PlayableWeightenedMenCountEvaluation());
	}
	
	private IEvaluation selectedEvaluation;

	public List<IAlgorithm> getAlgorithms() {
		return algorithms;
	}

	public void setAlgorithms(List<IAlgorithm> algorithms) {
		this.algorithms = algorithms;
	}

	public IAlgorithm getSelectedAlgorithm() {
		return selectedAlgorithm;
	}

	public void setSelectedAlgorithm(IAlgorithm selectedAlgorithm) {
		this.selectedAlgorithm = selectedAlgorithm;
	}
	
	public Integer[] getDepth() {
		return depth;
	}

	public void setDepth(Integer[] depth) {
		this.depth = depth;
	}

	public int getSelectedDepth() {
		return selectedDepth;
	}

	public void setSelectedDepth(int selectedDepth) {
		this.selectedDepth = selectedDepth;
	}

	public List<IEvaluation> getEvaluations() {
		return evaluations;
	}

	public void setEvaluations(List<IEvaluation> evaluations) {
		this.evaluations = evaluations;
	}

	public IEvaluation getSelectedEvaluation() {
		return selectedEvaluation;
	}

	public void setSelectedEvaluation(IEvaluation selectedEvaluation) {
		this.selectedEvaluation = selectedEvaluation;
	}
	
	public String[] getAlgorithmNames(){
		String[] array = new String[algorithms.size()];
		for (int i = 0; i < algorithms.size(); i++) {
			array[i] = algorithms.get(i).getName();
		}
		return array;
	}

	public String[] getEvaluationNames() {
		String[] array = new String[evaluations.size()];
		for (int i = 0; i < evaluations.size(); i++) {
			array[i] = evaluations.get(i).getClass().getSimpleName();
		}
		return array;
	}

	public void setSelectedAlgorithmName(String selectedItem) {
		for (int i = 0; i < algorithms.size(); i++) {
			if(algorithms.get(i).getName().equals(selectedItem)){
				selectedAlgorithm = algorithms.get(i);
				break;
			}
		}
	}

	public void setSelectedEvaluationName(String selectedItem) {
		for (int i = 0; i < evaluations.size(); i++) {
			if(evaluations.get(i).getClass().getSimpleName().equals(selectedItem)){
				selectedEvaluation = evaluations.get(i);
				break;
			}
		}
	}
}
