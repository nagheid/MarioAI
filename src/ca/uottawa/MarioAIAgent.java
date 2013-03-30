package ca.uottawa;

import ch.idsia.agents.Agent;
import ch.idsia.agents.controllers.BasicMarioAIAgent;
import ch.idsia.benchmark.mario.engine.sprites.Mario;
import ch.idsia.benchmark.mario.environments.Environment;

import java.util.*;
import algorithms.DStarLite;

public class MarioAIAgent extends BasicMarioAIAgent implements Agent {

	// TOUSE: Rectangular grid  + D*

	// a graph of go or no-go rates of vx in graph
	// will just use theirs
	//int gridRatings[][];

	int trueJumpCounter = 0;
	int trueSpeedCounter = 0;

	public MarioAIAgent(String s) {
		super(s);
		// TODO Auto-generated constructor stub
		System.out.println( Arrays.toString(enemies) );
	}
	
	public MarioAIAgent() {
		super("MarioAIAgent");
		System.out.println( Arrays.toString(enemies) );
		reset();
	}

	@Override
	public void reset()
	{
	    action = new boolean[Environment.numberOfKeys];
	    action[Mario.KEY_RIGHT] = true;
	    action[Mario.KEY_SPEED] = true;
	    trueJumpCounter = 0;
	    trueSpeedCounter = 0;
	}

	@Override
	public String getName() {
		return "MarioAIAgent";
	}

	@Override
	public void setName(String arg0) {
		name = arg0;
	}

	private boolean DangerOfAny()
	{

	        if ((getReceptiveFieldCellValue(marioEgoRow + 2, marioEgoCol + 1) == 0 &&
	            getReceptiveFieldCellValue(marioEgoRow + 1, marioEgoCol + 1) == 0) ||
	            getReceptiveFieldCellValue(marioEgoRow, marioEgoCol + 1) != 0 ||
	            getReceptiveFieldCellValue(marioEgoRow, marioEgoCol + 2) != 0 ||
	            getEnemiesCellValue(marioEgoRow, marioEgoCol + 1) != 0 ||
	            getEnemiesCellValue(marioEgoRow, marioEgoCol + 2) != 0)
	            return true;
	        else
	            return false;
	}
	
	@Override
	public boolean[] getAction()
	{
	    // this Agent requires observation integrated in advance.

	    if (DangerOfAny() && getReceptiveFieldCellValue(marioEgoRow, marioEgoCol + 1) != 1)  // a coin
	    {
	        if (isMarioAbleToJump || (!isMarioOnGround && action[Mario.KEY_JUMP]))
	        {
	            action[Mario.KEY_JUMP] = true;
	        }
	        ++trueJumpCounter;
	    }
	    else
	    {
	        action[Mario.KEY_JUMP] = false;
	        trueJumpCounter = 0;
	    }

	    if (trueJumpCounter > 16)
	    {
	        trueJumpCounter = 0;
	        action[Mario.KEY_JUMP] = false;
	    }
	    
	    return action;
	}

}
