package net.opentsdb;

/** Build data for {@code net.opentsdb} */
public final class BuildData {
  /** Short revision at which this package was built. */
  public static final String short_revision = "unknown";
  /** Full revision at which this package was built. */
  public static final String full_revision = "unknown";
  /** UTC date at which this package was built. */
  public static final String date = "2013/01/20 18:25:45 +0000";
  /** UNIX timestamp of the time of the build. */
  public static final long timestamp = 1358706345;

  /** Represents the status of the repository at the time of the build. */
  public static enum RepoStatus {
    /** The status of the repository was unknown at the time of the build. */
    UNKNOWN,
    /** There was no local modification during the build. */
    MINT,
    /** There were some local modifications during the build. */
    MODIFIED;
  }
  /** Status of the repository at the time of the build. */
  public static final RepoStatus repo_status = RepoStatus.MODIFIED;

  /** Username of the user who built this package. */
  public static final String user = "unknown";
  /** Host on which this package was built. */
  public static final String host = "unknown";
  /** Path to the repository in which this package was built. */
  public static final String repo = "unknown";

  /** Human readable string describing the revision of this package. */
  public static final String revisionString() {
    return "net.opentsdb built at revision unknown (MODIFIED)";
  }
  /** Human readable string describing the build information of this package. */
  public static final String buildString() {
    return "Built on 2013/01/20 18:25:45 +0000 by unknown@unknown:/";
  }

  // These functions are useful to avoid cross-jar inlining.

  /** Short revision at which this package was built. */
  public static String shortRevision() {
    return short_revision;
  }
  /** Full revision at which this package was built. */
  public static String fullRevision() {
    return full_revision;
  }
  /** UTC date at which this package was built. */
  public static String date() {
    return date;
  }
  /** UNIX timestamp of the time of the build. */
  public static long timestamp() {
    return timestamp;
  }
  /** Status of the repository at the time of the build. */
  public static RepoStatus repoStatus() {
    return repo_status;
  }
  /** Username of the user who built this package. */
  public static String user() {
    return user;
  }
  /** Host on which this package was built. */
  public static String host() {
    return host;
  }
  /** Path to the repository in which this package was built. */
  public static String repo() {
    return repo;
  }

  // Can't instantiate.
  private BuildData() {}
}
