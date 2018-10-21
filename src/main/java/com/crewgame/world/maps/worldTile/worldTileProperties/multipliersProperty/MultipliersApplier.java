

/*
 * 20/10/2018 at 18:30:08
 * MultipliersApplier.java created by Tsvetelin
 */
package com.crewgame.world.maps.worldTile.worldTileProperties.multipliersProperty;


/**
 * @author Tsvetelin
 *
 */
public interface MultipliersApplier<Applicant>
{
    /**
     * 
     * @param applicant - the end receiver of the multiplications( the same type is returned by the method)
     * @param multipliers - the multipliers to be applied
     * @return the resulting object after applying all the multipliers
     */
    public Applicant apply(Applicant applicant, Multipliers<Applicant> multipliers);
}
