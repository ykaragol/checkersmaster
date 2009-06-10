package checkers.controller;

import checkers.algorithm.IAlgorithm;
import checkers.domain.CalculationContext;
import checkers.domain.Model;
import checkers.domain.Move;
import checkers.domain.Player;

/**
 * Her bir oyuncuyu niteleyen sınıf
 * 
 * @author yusuf
 *
 */
public class Engine implements ModelListener{

	public void setCalculationContext(CalculationContext calculationContext) {
		this.calculationContext = calculationContext;
	}

	/**
	 * Kim olduğunu bilmesini sağlar.
	 */
	private Player player;
	
	private CalculationContext calculationContext;
	
	/**
	 * Yapılandırıcı, kim olduğunu bilerek üretilir.
	 * 
	 * @param player
	 */
	public Engine(Player player) {
		this.player = player;
	}

	public void playTurn(Model model) {
		//eğer ben güncellemediysem, rakip güncellemiştir ve sıra bende demektir.
		//çünkü toplamda iki oyuncu var.
		IAlgorithm algorithm = calculationContext.getAlgorithm();
		Move move = algorithm.algorithm(calculationContext, model, player);
		model.doMove(move);
	}
	
	@Override
	public void modelUpdated(Model model, Engine updater) {
		if(player == updater.player)
			return;
		playTurn(model);
	}

}
