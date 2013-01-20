package net.opentsdb.tsd;

import net.opentsdb.core.DataPoints;
import net.opentsdb.core.Query;
import net.opentsdb.core.TSDB;
import net.opentsdb.graph.Plot;

import java.util.HashSet;
import java.util.TimeZone;

/**
 * Defines an externally usable API into TSD internals
 */
public class TsdApi {

    public Plot Query(final TSDB tsdb, long start_time, long end_time, Query[] tsdbqueries, TimeZone tz, boolean nocache)
            throws RuntimeException
    {
        if (start_time == -1) {
            throw new IllegalArgumentException("Invalid start time");
        }

        final long now = System.currentTimeMillis() / 1000;
        if (end_time == -1) {
            end_time = now;
        }

        for (final Query tsdbquery : tsdbqueries) {
                tsdbquery.setStartTime(start_time);
                tsdbquery.setEndTime(end_time);
        }

        final Plot plot = new Plot(start_time, end_time, tz);

        final int nqueries = tsdbqueries.length;
        @SuppressWarnings("unchecked")
        final HashSet<String>[] aggregated_tags = new HashSet[nqueries];

        for (int i = 0; i < nqueries; i++) {
            // XXX This is slow and will block Netty.
            // TODO(tsuna): Optimization: run each query in parallel.
            final DataPoints[] series = tsdbqueries[i].run();
            for (final DataPoints datapoints : series) {
                plot.add(datapoints, "");
                aggregated_tags[i] = new HashSet<String>();
                aggregated_tags[i].addAll(datapoints.getAggregatedTags());
            }
        }

        return plot;
    }

}
