package net.opentsdb.tsd;

import net.opentsdb.core.TSDB;
import net.opentsdb.graph.Plot;
import net.opentsdb.core.Query;
import net.opentsdb.tsd.BadRequestException;

/**
 * Defines an externally usable API into TSD internals
 */
public class TsdApi {

    public Plot Query(final TSDB tsdb, long start_time, long end_time, Query[] queries, boolean nocache) {
        if (start_time == -1) {
            throw BadRequestException.missingParameter("start");
        }
        return null;
    }
}
