package com.mindlinksoft.recruitment.mychat.filter;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mindlinksoft.recruitment.mychat.ConversationExporterConfiguration;
import com.mindlinksoft.recruitment.mychat.Message;

/**
 * This class ensures all credit information is REDACTED.
 * 
 * @author Mohamed Yusuf
 *
 */
public class ObfuscateCreditCard implements Filter{
	
	private static final Logger LOGGER = Logger.getLogger(ObfuscateCreditCard.class.getName());
	
	/**
	 * This method uses regular expression replacement to,
	 * find and redact credit card details. Expression used is defined in
	 * the ConversationExporterConfiguration class.
	 * @param toFilter messages to filter.
	 * @param filter keywords to filter by.
	 */
	@Override
	public Set<Message> filter(Set<Message> toFilter, ConversationExporterConfiguration config) {
		LOGGER.log(Level.INFO, "Obfuscating credit card details");
		Set<Message> messages = new HashSet<Message>();
		
		for(Message mess : toFilter) {
			mess.setContent(mess.getContent().replaceAll(config.getCREDIT_REGEX(), config.getREDACT_REPLACMENT()));
			messages.add(mess);
		}		
		return messages;
	}
}
