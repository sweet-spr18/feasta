package com.esoxjem.movieguide.listing;

import com.esoxjem.movieguide.Building;
import com.esoxjem.movieguide.Movie;

import java.util.List;

/**
 * @author tta
 */
interface BuildingsListingView
{
    void showBuildings(List<Building> buildings);
    void loadingStarted();
    void loadingFailed(String errorMessage);
    void onBuildingClicked(Building building);
}
