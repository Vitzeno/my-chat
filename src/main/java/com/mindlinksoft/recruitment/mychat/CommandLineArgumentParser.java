package com.mindlinksoft.recruitment.mychat;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Represents a helper to parse command line arguments.
 */
public final class CommandLineArgumentParser {
	
	FlagProperties flagProps = new FlagProperties();
	private TreeSet<Integer> flagIndexes = new TreeSet<Integer>();
	private TreeSet<Integer> targerIndexes = new TreeSet<Integer>();
	
	private String[] targetArray;
	private String[] args;
	
	
    /**
     * Parses the given {@code arguments} into the exporter configuration.
     * @param arguments The command line arguments.
     * @return The exporter configuration representing the command line arguments.
     */
    public ConversationExporterConfiguration parseCommandLineArguments(String[] arguments) {
    	this.args = arguments;
    	ConversationExporterConfiguration config = new ConversationExporterConfiguration(args[0], args[1]);

    	findFlags(config);
    	findTargets();
    	validateFlags();
    	System.out.println(Arrays.toString(args));
    	
    	for(Integer index : flagIndexes) {
    		
    		String[] targets;
    		if(flagIndexes.higher(index) == null)
				targets = Arrays.copyOfRange(args, index + 1, args.length);
			else
				targets = Arrays.copyOfRange(args, index + 1, flagIndexes.higher(index));
    		
    		switch(args[index]) {
    		case "-fu":
    			config.setFILTER_USER(true);
    			config.setUsersToFilter(targets);
    			break;
    		case "-fw":
    			config.setFILTER_WORD(true);
    			config.setWordsToFilter(targets);
    			break;
    		case "-b":
    			config.setBLACKLIST_WORD(true);
    			config.setWordsToBlacklist(targets);
    			break;
    		case "-oc":
    			config.setOBFS_CREDIT_CARD(true);
    			break;
    		case "-ou":
    			config.setOBFS_USER(true);
    			config.setUsersToObfuscate(targets);
    			break;
    		case "-r":
    			config.setGEN_REPORT(true);
    			break;
    		}
    	}
    	
        return config;
    }
    
    /**
     * Helper method to ensure arguments provided are in the correct format
     * and relevant targets are present
     */
    public void validateFlags() {
    	for(Integer index : flagIndexes) {
    		//Ensure flags use valid syntax
    		if(!flagProps.getFLAGS().containsKey(args[index])) {
    			throw new IllegalArgumentException(args[index] + " is not a valid flag.");
    		}
    		
    		//Ensure target(s) appear after flag
    		if(!targerIndexes.contains(index + flagProps.getFLAGS().get(args[index]))) {
    			if(flagProps.getFLAGS().get(args[index]) < 0) {
	    				continue;
    				}
    			else
    				throw new IllegalArgumentException("Flag " + args[index] + " has not been provided with the correct number of targets");
    		}
    	}
    }
    
    /**
     * Helper method to locate the indexes of flags in the provided arguments
     * @param config
     */
    public void findFlags(ConversationExporterConfiguration config) {
    	for(int i = config.getARGS_START();i < args.length;i++) {
    		if(args[i].startsWith(config.getFLAG_INDICATOR())) {
        		flagIndexes.add(i);
    		} else {
    			targerIndexes.add(i);
    		}
    	}
    }
    
    /**
     * Helper method to locate the indexes of targets in the provided arguments
     */
    public void findTargets() {
    	targetArray = new String[args.length - flagIndexes.size()];
    	int targetIndex = 0;
    	for(int i = 0;i < args.length; i++) {
    		if(!flagIndexes.contains(i)) {
    			targetArray[targetIndex++] = args[i];
    		}
    	}
    }	
}
