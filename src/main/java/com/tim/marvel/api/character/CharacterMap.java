package com.tim.marvel.api.character;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CharacterMap {
    private static final Map<String, Integer> characterNameToIdMap;

    static {
        characterNameToIdMap = new HashMap<>();
        characterNameToIdMap.put("spider-man", 1009610);
        characterNameToIdMap.put("hulk", 1009351);
        characterNameToIdMap.put("captain-america", 1009220);
        characterNameToIdMap.put("iron-man", 1009368);
        characterNameToIdMap.put("thor", 1009664);
        characterNameToIdMap.put("wolverine", 1009718);
        characterNameToIdMap.put("storm", 1009629);
        characterNameToIdMap.put("jean-grey", 1009496);
        characterNameToIdMap.put("gambit", 1009313);
        characterNameToIdMap.put("cyclops", 1009257);
        characterNameToIdMap.put("beast", 1009175);
    }

    public static int getCharacterIdByName(String name) {
        return characterNameToIdMap.getOrDefault(name.toLowerCase(), 0);
    }

    public static Collection<Integer> getCharacterIds() {
        return characterNameToIdMap.values();
    }
}
