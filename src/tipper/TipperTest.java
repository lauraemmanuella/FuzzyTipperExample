package tipper;


import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;


public class TipperTest {

	public static void main(String[] args) {
		FIS fis = FIS.load("src/tipper/tipper.fcl", true); // Load from 'FCL' file
		
		
		
		// Show 
        JFuzzyChart.get().chart(fis.getFunctionBlock("tipper"));
		
	    fis.setVariable("service", 3); // Set inputs
	    fis.setVariable("food", 7);
	    fis.evaluate(); // Evaluate

	 // Show output variable's chart
        Variable tip = fis.getFunctionBlock("tipper").getVariable("tip");
        JFuzzyChart.get().chart(tip, tip.getDefuzzifier(), true);

        // Print ruleSet
        System.out.println(fis);
	}

}
