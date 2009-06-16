package checkers.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class ConfigurationPanel extends JPanel{
	
	private JLabel lbAlgorithmLabel;
	private JLabel lbDepth;
	private JLabel lbEvaluation;
	private JComboBox cmbAlgorithmCombo;
	private JComboBox cmbDepthCombo;
	private JComboBox cmbEvaluationCombo;
	private JButton buttonSave;
	
	private ConfigurationModel model;
	private MainView callBack;
	
	public ConfigurationModel getConfigurationModel() {
		return model;
	}

	public void setConfigurationModel(ConfigurationModel configurationModel) {
		this.model = configurationModel;
		updateView();
	}
	
	private void updateView() {
		DefaultComboBoxModel algorithmModel = new DefaultComboBoxModel(model.getAlgorithmNames());
		cmbAlgorithmCombo.setModel(algorithmModel);

		DefaultComboBoxModel depthModel = new DefaultComboBoxModel(model.getDepth());
		cmbDepthCombo.setModel(depthModel);
		
		DefaultComboBoxModel evaluationModel = new DefaultComboBoxModel(model.getEvaluationNames());
		cmbEvaluationCombo.setModel(evaluationModel);
	}

	private void updateModelClicked(){
		convertAndUpdateModel();
		callBack.configurationUpdated(model);
	}

	private void convertAndUpdateModel() {
		model.setSelectedAlgorithmName((String)cmbAlgorithmCombo.getSelectedItem());
		model.setSelectedEvaluationName((String)cmbEvaluationCombo.getSelectedItem());
		model.setSelectedDepth((Integer)cmbDepthCombo.getSelectedItem());
	}

	public ConfigurationPanel(MainView callBack){
		this.callBack = callBack;
		init();
	}
	
	public void init() 
	{
	   this.setBorder(BorderFactory.createTitledBorder( "Configuration Panel" ) );
	   GridBagLayout gbConfigPanel = new GridBagLayout();
	   GridBagConstraints gbcConfigPanel = new GridBagConstraints();
	   this.setLayout( gbConfigPanel );

	   Insets insets = new Insets(3, 4, 10, 4);
	   
	   lbAlgorithmLabel = new JLabel( "Algorithms    : "  );
	   gbcConfigPanel.gridx = 0;
	   gbcConfigPanel.gridy = 0;
	   gbcConfigPanel.gridwidth = 1;
	   gbcConfigPanel.gridheight = 1;
	   gbcConfigPanel.fill = GridBagConstraints.BOTH;
	   gbcConfigPanel.weightx = 1;
	   gbcConfigPanel.weighty = 1;
	   gbcConfigPanel.insets = insets;
	   gbcConfigPanel.anchor = GridBagConstraints.NORTH;
	   gbConfigPanel.setConstraints( lbAlgorithmLabel, gbcConfigPanel );
	   this.add( lbAlgorithmLabel );

	   lbDepth = new JLabel( "Depth            :"  );
	   gbcConfigPanel.gridx = 0;
	   gbcConfigPanel.gridy = 1;
	   gbcConfigPanel.gridwidth = 1;
	   gbcConfigPanel.gridheight = 1;
	   gbcConfigPanel.fill = GridBagConstraints.BOTH;
	   gbcConfigPanel.weightx = 1;
	   gbcConfigPanel.weighty = 1;
	   gbcConfigPanel.insets = insets;
	   gbcConfigPanel.anchor = GridBagConstraints.NORTH;
	   gbConfigPanel.setConstraints( lbDepth, gbcConfigPanel );
	   this.add( lbDepth );

	   lbEvaluation = new JLabel( "Evaluation     :"  );
	   gbcConfigPanel.gridx = 0;
	   gbcConfigPanel.gridy = 2;
	   gbcConfigPanel.gridwidth = 1;
	   gbcConfigPanel.gridheight = 1;
	   gbcConfigPanel.fill = GridBagConstraints.BOTH;
	   gbcConfigPanel.weightx = 1;
	   gbcConfigPanel.weighty = 1;
	   gbcConfigPanel.insets = insets;
	   gbcConfigPanel.anchor = GridBagConstraints.NORTH;
	   gbConfigPanel.setConstraints( lbEvaluation, gbcConfigPanel );
	   this.add( lbEvaluation );

	   cmbAlgorithmCombo = new JComboBox(  );
	   gbcConfigPanel.gridx = 1;
	   gbcConfigPanel.gridy = 0;
	   gbcConfigPanel.gridwidth = 1;
	   gbcConfigPanel.gridheight = 1;
	   gbcConfigPanel.fill = GridBagConstraints.BOTH;
	   gbcConfigPanel.weightx = 1;
	   gbcConfigPanel.weighty = 0;
	   gbcConfigPanel.insets = insets;
	   gbcConfigPanel.anchor = GridBagConstraints.NORTH;
	   gbConfigPanel.setConstraints( cmbAlgorithmCombo, gbcConfigPanel );
	   this.add( cmbAlgorithmCombo );

	   cmbDepthCombo = new JComboBox();
	   gbcConfigPanel.gridx = 1;
	   gbcConfigPanel.gridy = 1;
	   gbcConfigPanel.gridwidth = 1;
	   gbcConfigPanel.gridheight = 1;
	   gbcConfigPanel.fill = GridBagConstraints.BOTH;
	   gbcConfigPanel.weightx = 1;
	   gbcConfigPanel.weighty = 0;
	   gbcConfigPanel.insets = insets;
	   gbcConfigPanel.anchor = GridBagConstraints.NORTH;
	   gbConfigPanel.setConstraints( cmbDepthCombo, gbcConfigPanel );
	   this.add( cmbDepthCombo );

	   cmbEvaluationCombo = new JComboBox();
	   gbcConfigPanel.gridx = 1;
	   gbcConfigPanel.gridy = 2;
	   gbcConfigPanel.gridwidth = 1;
	   gbcConfigPanel.gridheight = 1;
	   gbcConfigPanel.fill = GridBagConstraints.BOTH;
	   gbcConfigPanel.weightx = 1;
	   gbcConfigPanel.weighty = 0;
	   gbcConfigPanel.insets = insets;
	   gbcConfigPanel.anchor = GridBagConstraints.NORTH;
	   gbConfigPanel.setConstraints( cmbEvaluationCombo, gbcConfigPanel );
	   this.add( cmbEvaluationCombo );

	   
	   buttonSave = new JButton( "Save" );
	   gbcConfigPanel.gridx = 1;
	   gbcConfigPanel.gridy = 3;
	   gbcConfigPanel.gridwidth = 1;
	   gbcConfigPanel.gridheight = 1;
	   gbcConfigPanel.fill = GridBagConstraints.BOTH;
	   gbcConfigPanel.weightx = 1;
	   gbcConfigPanel.weighty = 0;
	   gbcConfigPanel.insets = insets;
	   gbcConfigPanel.anchor = GridBagConstraints.NORTH;
	   gbConfigPanel.setConstraints( buttonSave, gbcConfigPanel );
	   this.add( buttonSave );
	   
	   buttonSave.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				updateModelClicked();
			}		   
	   });
	   
	} 
	

//	public static void main(String[] args) {
//		ConfigurationPanel panel = new ConfigurationPanel();
//		panel.setConfigurationModel(new ConfigurationModel());
//		JFrame frame = new JFrame("Game Configuration");
//		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//		frame.setContentPane( panel );
//		frame.pack();
//		frame.setResizable(false);
//		frame.setVisible( true );
//	}
}
