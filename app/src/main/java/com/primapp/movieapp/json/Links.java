package com.primapp.movieapp.json;

/**
 * Created by Moises on 08/11/2015.
 */

import java.util.Map;

import java.util.HashMap;
import java.util.Map;


public class Links {
    
    private String self;
    private String alternate;
    private Map<String, Object> additionalProperties = new HashMap<>();
    
             /**
       * @return The self
       */
       public  String getSelf() {
             return self;
       }
    
             /**
       * @param self The self
       */
       public  void setSelf(String self) {
             this.self = self;
       }
    
             /**
       * @return The alternate
       */
       public  String getAlternate() {
             return alternate;
         }

             /**
       * @param alternate The alternate
       */
       public  void setAlternate(String alternate) {
             this.alternate = alternate;
         }

       public  Map<String, Object> getAdditionalProperties() {
             return this.additionalProperties;
         }

       public  void setAdditionalProperty(String name, Object value) {
             this.additionalProperties.put(name, value);
         }

}