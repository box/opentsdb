nohup /opt/tsd/opentsdb/tsdb tsd --staticroot=/opt/tsd/opentsdb/static --port=4242 --cachedir=/tmp/tsd > /opt/tsd/opentsdb/logs/tsdb.out 2> /opt/tsd/opentsdb/logs/tsdb.err < /dev/null  &
