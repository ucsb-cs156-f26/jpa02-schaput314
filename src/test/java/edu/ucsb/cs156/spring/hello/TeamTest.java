package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }
   
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_correct_answer() {
        assertEquals(true, team.equals(team));
        Object notATeam = "test-team";
        assertEquals(false, team.equals(notATeam));
        Team sameNameSameMembers = new Team("test-team");
        assertEquals(true, team.equals(sameNameSameMembers));
        Team sameNameDiffMembers = new Team("test-team");
        sameNameDiffMembers.getMembers().add("alice");
        assertEquals(false, team.equals(sameNameDiffMembers));
        Team diffNameSameMembers = new Team("other-team");
        assertEquals(false, team.equals(diffNameSameMembers));
        Team diffNameDiffMembers = new Team("other-team");
        diffNameDiffMembers.getMembers().add("alice");
        assertEquals(false, team.equals(diffNameDiffMembers)); 
    }

    @Test
    public void hashCode_returns_correct_value() {
        Team t = new Team("test-team");
        int result = t.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }

}
