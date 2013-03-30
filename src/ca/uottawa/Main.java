package ca.uottawa;

import ch.idsia.agents.controllers.ForwardAgent;
import ch.idsia.benchmark.tasks.BasicTask;
import ch.idsia.tools.MarioAIOptions;

public class Main {
	
	public static void main(String[] args) {
		// need to implement an agent
		MarioAIAgent agent = new MarioAIAgent();

		MarioAIOptions options = new MarioAIOptions();

		options.setLevelDifficulty(1);
		options.setLevelRandSeed(500);
		options.setAgent(agent);

		BasicTask task = new BasicTask(options);
		task.runSingleEpisode(1);
	}
}
