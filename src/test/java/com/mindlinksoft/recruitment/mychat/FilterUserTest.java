package com.mindlinksoft.recruitment.mychat;

import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;
import org.junit.Test;

import com.mindlinksoft.recruitment.mychat.filter.FilterUser;

/**
 * This class tests various aspects of the user filter.
 * 
 * @author Mohamed Yusuf
 *
 */
public class FilterUserTest {

	@Test
	public void testFilterUserBob() {
		Set<Message> convo = new HashSet<Message>();

		String[] filter = {"bob"};
		convo.addAll(new FilterUser().filter(new GenerateMockMessages().genMockMessages(), filter));
		for(Message mess : convo) {
			assertEquals(mess.getUsername(), filter[0]);
		}
	}
	
	@Test
	public void testFilterUserMike() {
		Set<Message> convo = new HashSet<Message>();

		String[] filter = {"mike"};
		convo.addAll(new FilterUser().filter(new GenerateMockMessages().genMockMessages(), filter));
		for(Message mess : convo) {
			assertEquals(mess.getUsername(), filter[0]);
		}
	}
	
	@Test
	public void testFilterUserAngus() {
		Set<Message> convo = new HashSet<Message>();

		String[] filter = {"angus"};
		convo.addAll(new FilterUser().filter(new GenerateMockMessages().genMockMessages(), filter));
		for(Message mess : convo) {
			assertEquals(mess.getUsername(), filter[0]);
		}
	}
	
	@Test
	public void testFilterUserJohn() {
		Set<Message> convo = new HashSet<Message>();

		String[] filter = {"john"};
		convo.addAll(new FilterUser().filter(new GenerateMockMessages().genMockMessages(), filter));
		for(Message mess : convo) {
			assertEquals(mess.getUsername(), filter[0]);
		}
	}
	
	@Test
	public void testFilterUserAlan() {
		Set<Message> convo = new HashSet<Message>();

		String[] filter = {"alan"};
		convo.addAll(new FilterUser().filter(new GenerateMockMessages().genMockMessages(), filter));
		for(Message mess : convo) {
			assertEquals(mess.getUsername(), filter[0]);
		}
	}
	
	@Test
	public void testFilterUserIncorrect() {
		Set<Message> convo = new HashSet<Message>();

		String[] filter = {"alan"};
		convo.addAll(new FilterUser().filter(new GenerateMockMessages().genMockMessages(), filter));
		for(Message mess : convo) {
			assertNotEquals(mess.getUsername(), "john");
		}
	}
	
	@Test
	public void testFilterMultipleUsers_1() {
		Set<Message> convo = new HashSet<Message>();
		String[] filter = {"alan", "bob"};
		Set<String> filterSet = Set.of(filter);
		
		convo.addAll(new FilterUser().filter(new GenerateMockMessages().genMockMessages(), filter));
		for(Message mess : convo) {
			assertTrue(filterSet.contains(mess.getUsername()));
		}
	}
	
	@Test
	public void testFilterMultipleUsers_2() {
		Set<Message> convo = new HashSet<Message>();
		String[] filter = {"alan", "finch"};
		Set<String> filterSet = Set.of(filter);
		
		convo.addAll(new FilterUser().filter(new GenerateMockMessages().genMockMessages(), filter));
		for(Message mess : convo) {
			assertTrue(filterSet.contains(mess.getUsername()));
		}
	}
	
	@Test
	public void testFilterMultipleUsers_3() {
		Set<Message> convo = new HashSet<Message>();
		String[] filter = {"tom", "bob", "mike"};
		Set<String> filterSet = Set.of(filter);
		
		convo.addAll(new FilterUser().filter(new GenerateMockMessages().genMockMessages(), filter));
		for(Message mess : convo) {
			assertTrue(filterSet.contains(mess.getUsername()));
		}
	}
	
	@Test
	public void testFilterMultipleUsers_4() {
		Set<Message> convo = new HashSet<Message>();
		String[] filter = {"gina", "alex"};
		Set<String> filterSet = Set.of(filter);
		
		convo.addAll(new FilterUser().filter(new GenerateMockMessages().genMockMessages(), filter));
		for(Message mess : convo) {
			assertTrue(filterSet.contains(mess.getUsername()));
		}
	}
	
	@Test
	public void testFilterMultipleUsersIncorrect_1() {
		Set<Message> convo = new HashSet<Message>();
		String[] filter = {"bob", "mike"};
		
		convo.addAll(new FilterUser().filter(new GenerateMockMessages().genMockMessages(), filter));
		for(Message mess : convo) {
			assertFalse(mess.getUsername().equals("alan"));
		}
	}
	
	@Test
	public void testFilterMultipleUsersIncorrect_2() {
		Set<Message> convo = new HashSet<Message>();
		String[] filter = {"bob", "mike", "smith"};
		
		convo.addAll(new FilterUser().filter(new GenerateMockMessages().genMockMessages(), filter));
		for(Message mess : convo) {
			assertFalse(mess.getUsername().equals("craig"));
		}
	}
	
	@Test
	public void testFilterMultipleUsersIncorrect_3() {
		Set<Message> convo = new HashSet<Message>();
		String[] filter = {"gina", "smith", "tim"};
		
		convo.addAll(new FilterUser().filter(new GenerateMockMessages().genMockMessages(), filter));
		for(Message mess : convo) {
			assertFalse(mess.getUsername().equals("mike"));
		}
	}
	
	@Test
	public void testFilterMultipleUsersIncorrect_4() {
		Set<Message> convo = new HashSet<Message>();
		String[] filter = {"bob", "mike"};
		
		convo.addAll(new FilterUser().filter(new GenerateMockMessages().genMockMessages(), filter));
		for(Message mess : convo) {
			assertFalse(mess.getUsername().equals("john"));
		}
	}
}
