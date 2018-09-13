

/*
 * 04/09/2018 at 23:30:28
 * WorldTileProperty.java created by Tsvetelin
 */
package com.crewgame.world.maps.worldTile.worldTileProperties;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;


@Documented
@Retention ( RUNTIME )
@Target ( TYPE )
/**
 * @author Tsvetelin
 *
 */
public @interface WorldTileProperty
{
    public Class< ? > propertyClass();
}
