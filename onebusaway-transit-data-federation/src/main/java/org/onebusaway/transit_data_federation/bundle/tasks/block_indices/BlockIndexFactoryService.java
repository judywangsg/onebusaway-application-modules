package org.onebusaway.transit_data_federation.bundle.tasks.block_indices;

import java.util.List;

import org.onebusaway.transit_data_federation.services.blocks.BlockLayoverIndex;
import org.onebusaway.transit_data_federation.services.blocks.BlockSequenceIndex;
import org.onebusaway.transit_data_federation.services.blocks.BlockTripIndex;
import org.onebusaway.transit_data_federation.services.blocks.FrequencyBlockTripIndex;
import org.onebusaway.transit_data_federation.services.transit_graph.BlockEntry;
import org.onebusaway.transit_data_federation.services.transit_graph.BlockTripEntry;
import org.onebusaway.transit_data_federation.services.transit_graph.FrequencyEntry;

public interface BlockIndexFactoryService {

  public List<BlockTripIndexData> createTripData(Iterable<BlockEntry> blocks);

  public List<BlockLayoverIndexData> createLayoverData(
      Iterable<BlockEntry> blocks);

  public List<FrequencyBlockTripIndexData> createFrequencyTripData(
      Iterable<BlockEntry> blocks);

  /****
   * 
   ****/

  public List<BlockTripIndex> createTripIndices(Iterable<BlockEntry> blocks);

  public List<BlockLayoverIndex> createLayoverIndices(
      Iterable<BlockEntry> blocks);

  public List<FrequencyBlockTripIndex> createFrequencyTripIndices(
      Iterable<BlockEntry> blocks);

  public List<BlockSequenceIndex> createSequenceIndices(
      Iterable<BlockEntry> blocks);

  /****
   * 
   ****/

  public BlockTripIndex createTripIndexForGroupOfBlockTrips(
      List<BlockTripEntry> blocks);

  public BlockLayoverIndex createLayoverIndexForGroupOfBlockTrips(
      List<BlockTripEntry> trips);

  public FrequencyBlockTripIndex createFrequencyIndexForTrips(
      List<BlockTripEntry> trips, List<FrequencyEntry> frequencies);

  public BlockSequenceIndex createSequenceIndexForGroupOfBlockSequences(
      List<BlockSequence> sequences);
}
