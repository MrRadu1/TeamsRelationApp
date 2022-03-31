package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import exceptions.InvalidInputException;

public class Manangement implements Comparable<String>{
	private Map<String, TreeSet<String>> friendsMap;
	
	public Manangement() {
		friendsMap = new HashMap<>();
	}
	
	public Map<String, TreeSet<String>> getFriendsMap(){
		return friendsMap;
	}
	
	public void setFriendsMap(Map<String, TreeSet<String>> friendsMap) {
		this.friendsMap = friendsMap;
	}
	
	public void addTeam(String echipa) {
		friendsMap.put(echipa, new TreeSet<String>());
	}
	
	public void deleteEchipa(Echipa echipa) {
		friendsMap.remove(echipa);
		
		for(TreeSet<String> echipe : friendsMap.values()) {
			if(echipe.contains(echipa)) {
				echipe.remove(echipe);
			}
		}
	}
	
	public void addFriendship(String echipa1,  String echipa2) throws InvalidInputException{
		if (echipa1.equals(echipa2))
			throw new InvalidInputException("Nu se poate adauga relatie intre 2 echipe diferite!");
		friendsMap.get(echipa1).add(echipa2);
		friendsMap.get(echipa2).add(echipa1);
	}
	
	public String toString() {
		String result = "";
		for(Map.Entry<String, TreeSet<String>> entry : friendsMap.entrySet()) {
			result += "Team with name " + entry.getKey() + " has the following friends: ";
			result += entry.getValue() + "\n";
		}
		
		return result;
	}
	
	@Override
	public int compareTo(String x) {
			return this.compareTo(x);

	}
}
