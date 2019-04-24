
/*
 * 04/09/2018 at 23:30:28
 * WorldTileProperty.java created by Tsvetelin
 */
package com.crewgame.world.maps.worldTile.worldTileProperties;


import javax.swing.ImageIcon;


/**
 * @author Tsvetelin
 *
 */
public interface WorldTileProperty extends PropertyGameObject
{

    /**
     * 
     * It is called during the loading of the tile the first time it is created
     * and never again
     * 
     * @param otherProps
     *            - the other properties of the tile
     * @return a new instance of the properties after the effects of the
     *         property taking place
     */
    public WorldTileProperties init ( WorldTileProperties otherProps );

    /**
     * 
     * Getter for the icon
     * 
     * @return the icon to be displayed
     */
    public ImageIcon getIcon ();

    // TODO implement the menu for every property( a way to return it from a
    // method )
}
