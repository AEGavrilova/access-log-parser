package StreamAPI.St2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Statistics {
    private HashMap<Integer, Integer> visitsPerSecond = new HashMap<>();
    private HashMap<String, Integer> visitsPerUser = new HashMap<>();
    private HashSet<String> referringDomains = new HashSet<>();

    public void logVisit(int timestamp, String userAgent, String ipAddress, String referer) {
        if (userAgent.toLowerCase().contains("bot")) {
            return;
        }

        visitsPerSecond.put(timestamp, visitsPerSecond.getOrDefault(timestamp, 0) + 1);

        visitsPerUser.put(ipAddress, visitsPerUser.getOrDefault(ipAddress, 0) + 1);

        if (referer != null && !referer.isEmpty()) {
            String domain = extractDomain(referer);
            referringDomains.add(domain);
        }
    }

    private String extractDomain(String url) {
        String domain = url.replaceFirst("^(https?://)?(www\\.)?", "");
        int slashIndex = domain.indexOf('/');
        if (slashIndex != -1) {
            domain = domain.substring(0, slashIndex);
        }
        return domain;
    }

    public int getPeakVisitsPerSecond() {
        return visitsPerSecond.values().stream()
                .max(Integer::compare)
                .orElse(0);
    }

    public Set<String> getReferringDomains() {
        return new HashSet<>(referringDomains);
    }

    public int getMaxVisitsBySingleUser() {
        return visitsPerUser.values().stream()
                .max(Integer::compare)
                .orElse(0);
    }
}
