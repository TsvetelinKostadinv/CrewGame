

/*
 * 05/09/2018 at 23:30:55
 * Saver.java created by Tsvetelin
 */
package com.crewgame.java.utils.saving;

import java.io.File;

import com.crewgame.java.base.BaseGameObject;

/**
 * @author Tsvetelin
 *
 */
public interface Saver
{
    public < T extends BaseGameObject > void save(File location, T save);
}
