

/*
 * 02/09/2018 at 15:22:26
 * WorldTileProperty.java created by Tsvetelin
 */
package com.crewgame.java.world.maps.worldTileProperties;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention ( RUNTIME )
@Target ( TYPE )
/**
 * 
 * This annotation clarifies if an object can be used as a <code>WorldTile</code> property      <br>
 * in the <code>WorldTileInfo</code> object
 * 
 * @author Tsvetelin
 *
 */
public @interface WorldTileProperty
{
    public Class< ? > propertyClass();  
}
