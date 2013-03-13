package ca.uottawa;
import ch.idsia.agents.controllers.ForwardAgent;
import ch.idsia.benchmark.tasks.BasicTask;
import ch.idsia.tools.MarioAIOptions;

public class Main {

    public static void main(String[] args) {
      ForwardAgent agent = new ForwardAgent();

      MarioAIOptions options= new MarioAIOptions();

      options.setLevelDifficulty(1);
      options.setLevelRandSeed(100);
      options.setAgent(agent);

      BasicTask task = new BasicTask(options);
      task.runSingleEpisode(1);
    }
}
