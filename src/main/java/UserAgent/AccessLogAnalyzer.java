package UserAgent;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

enum HttpMethod {
    GET, POST, PUT, DELETE, HEAD, OPTIONS, PATCH, CONNECT, TRACE
}

class UserAgent {
    private final String osType;
    private final String browser;

    public UserAgent(String userAgentString) {
        this.osType = parseOsType(userAgentString);
        this.browser = parseBrowser(userAgentString);
    }

    private String parseOsType(String userAgent) {
        if (userAgent.contains("Windows")) return "Windows";
        if (userAgent.contains("Mac OS")) return "macOS";
        if (userAgent.contains("Linux")) return "Linux";
        if (userAgent.contains("Android")) return "Android";
        if (userAgent.contains("iOS")) return "iOS";
        return "Other";
    }

    private String parseBrowser(String userAgent) {
        if (userAgent.contains("Edge")) return "Edge";
        if (userAgent.contains("Firefox")) return "Firefox";
        if (userAgent.contains("Chrome")) return "Chrome";
        if (userAgent.contains("Opera")) return "Opera";
        if (userAgent.contains("Safari")) return "Safari";
        return "Other";
    }

    public String getOsType() {
        return osType;
    }

    public String getBrowser() {
        return browser;
    }
}

class LogEntry {
    private final String ipAddress;
    private final LocalDateTime dateTime;
    private HttpMethod method;
    private final String path;
    private final int responseCode;
    private final int dataSize;
    private final String referer;
    private final UserAgent userAgent;

    public LogEntry(String logLine) {
        String[] parts = logLine.split(" ");

        this.ipAddress = parts[0];

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss Z", Locale.ENGLISH);
        String dateTimeStr = parts[3].substring(1) + " " + parts[4].replace("]", "");
        this.dateTime = ZonedDateTime.parse(dateTimeStr, formatter).toLocalDateTime();

        String request = parts[5].startsWith("\"") ? parts[5].substring(1) : parts[5];
        String[] requestParts = request.split(" ");
        try {
            this.method = HttpMethod.valueOf(requestParts[0]);
        } catch (IllegalArgumentException e) {
            this.method = HttpMethod.GET;
        }
        this.path = requestParts.length > 1 ? requestParts[1] : "";

        this.responseCode = Integer.parseInt(parts[8]);
        this.dataSize = parts[9].equals("-") ? 0 : Integer.parseInt(parts[9]);

        this.referer = parts[10].equals("\"-\"") ? null :
                parts[10].startsWith("\"") ? parts[10].substring(1, parts[10].length()-1) : parts[10];

        StringBuilder userAgentBuilder = new StringBuilder();
        for (int i = 11; i < parts.length; i++) {
            userAgentBuilder.append(parts[i]).append(" ");
        }
        String userAgentStr = userAgentBuilder.toString().trim();
        if (userAgentStr.startsWith("\"") && userAgentStr.endsWith("\"")) {
            userAgentStr = userAgentStr.substring(1, userAgentStr.length()-1);
        }
        this.userAgent = new UserAgent(userAgentStr);
    }

    public String getIpAddress() { return ipAddress; }
    public LocalDateTime getDateTime() { return dateTime; }
    public HttpMethod getMethod() { return method; }
    public String getPath() { return path; }
    public int getResponseCode() { return responseCode; }
    public int getDataSize() { return dataSize; }
    public String getReferer() { return referer; }
    public UserAgent getUserAgent() { return userAgent; }
}

class Statistics {
    private int totalTraffic;
    private LocalDateTime minTime;
    private LocalDateTime maxTime;
    private final Map<String, Integer> osStatistics = new HashMap<>();
    private final Map<String, Integer> browserStatistics = new HashMap<>();

    public Statistics() {
        this.totalTraffic = 0;
        this.minTime = null;
        this.maxTime = null;
    }

    public void addEntry(LogEntry entry) {
        this.totalTraffic += entry.getDataSize();

        if (this.minTime == null || entry.getDateTime().isBefore(this.minTime)) {
            this.minTime = entry.getDateTime();
        }
        if (this.maxTime == null || entry.getDateTime().isAfter(this.maxTime)) {
            this.maxTime = entry.getDateTime();
        }

        String os = entry.getUserAgent().getOsType();
        osStatistics.put(os, osStatistics.getOrDefault(os, 0) + 1);

        String browser = entry.getUserAgent().getBrowser();
        browserStatistics.put(browser, browserStatistics.getOrDefault(browser, 0) + 1);
    }

    public double getTrafficRate() {
        if (minTime == null || maxTime == null || totalTraffic == 0) {
            return 0.0;
        }
        long hours = ChronoUnit.HOURS.between(minTime, maxTime);
        if (hours == 0) hours = 1;
        return (double) totalTraffic / hours;
    }

    public Map<String, Integer> getOsStatistics() {
        return new HashMap<>(osStatistics);
    }

    public Map<String, Integer> getBrowserStatistics() {
        return new HashMap<>(browserStatistics);
    }
}

public class AccessLogAnalyzer {
    public static void main(String[] args) {
        Statistics stats = new Statistics();
        String line = "37.231.123.209 - - [25/Sep/2022:06:25:04 +0300] \"GET /engine.php?rss=1&json=1&p=156&lg=1 HTTP/1.0\" 200 61096 \"https://nova-news.ru/search/?rss=1&lg=1\" \"Mozilla/5.0 (Linux; Android 6.0.1; SM-J500M Build/MMB29M) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.91 Mobile Safari/537.36\"";
         LogEntry entry = new LogEntry(line);
         stats.addEntry(entry);

        System.out.println("Средний трафик в час: " + stats.getTrafficRate() + " байт/час");
    }
}
