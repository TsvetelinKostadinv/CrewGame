

/*
 * 31/08/2018 at 15:15:30
 * Reference.java created by Tsvetelin
 */
package com.crewgame.utils;


/**
 * @author Tsvetelin
 *
 */
public enum Reference
{
    ; // this needs to be here because this enum will not have any values but it will hold other enums
    
    public static enum Paths
    {
        META_PATH("resources/META_PATH.txt");
        
        private String value = null;
        
        /**
         * 
         */
        private Paths (String str) { this.value = str; }
        
        public String getValue() { return value; }
    }
    
}
